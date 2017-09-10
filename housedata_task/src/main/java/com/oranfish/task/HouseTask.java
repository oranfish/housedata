package com.oranfish.task;

import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import com.oranfish.service.HouseService;
import com.oranfish.task.job.HouseRunnableJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class HouseTask {

    private static final Logger LOG = LoggerFactory.getLogger(HouseTask.class);

    @Autowired
    private HouseService houseService;
    @Autowired
    private ClawService clawService;
    @Value("${lianjia.url}")
    private String lianjiaUrl;

    @Scheduled(cron="${cron}")
    public void doTask(){
        LOG.info("开始任务");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        List<String> levelOneList = clawService.getLevelOnePart(lianjiaUrl + "/ershoufang/");
        if(levelOneList != null && !levelOneList.isEmpty()){
            for(String levelOne : levelOneList){
                List<String> levelTwoList = clawService.getLevelTwoPart(lianjiaUrl + levelOne);
                for(String levelTwo : levelTwoList){
                    clawData(lianjiaUrl + levelTwo, fixedThreadPool);
                }
            }
        }
        fixedThreadPool.shutdown();
        LOG.info("结束任务");
    }


    private void clawData(String dataUrl, ExecutorService fixedThreadPool){
        Integer totalPages = clawService.getTotalPage(dataUrl);
        if(totalPages != null && totalPages > 0){
            List<House> list = Collections.synchronizedList(new ArrayList<House>());
            CountDownLatch cdl = new CountDownLatch(totalPages);
            for(int i = 1; i <= totalPages; i++){
                HouseRunnableJob job = new HouseRunnableJob(dataUrl + "/d" + i, list, cdl);
                fixedThreadPool.execute(job);
            }
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            houseService.batchInsert(list);
        }
    }
}
