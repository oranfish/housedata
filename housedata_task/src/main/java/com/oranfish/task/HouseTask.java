package com.oranfish.task;

import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import com.oranfish.service.HouseService;
import com.oranfish.task.job.HouseRunnableJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class HouseTask {

    private static final Logger LOG = LoggerFactory.getLogger(HouseTask.class);

    @Autowired
    private HouseService houseService;
    @Autowired
    private ClawService clawService;

    @Scheduled(cron="0 0 5 * * ?")
    public void doTask(){
        LOG.info("开始任务");
        Integer todayCount = houseService.getTodayCount();
        if(todayCount != null && todayCount == 0){
            Integer totalPages = clawService.getTotalPages("http://sh.lianjia.com/ershoufang/");
            if(totalPages != null && totalPages > 0){
                ExecutorService fixedThreadPool = Executors.newFixedThreadPool(16);
                List<House> list = new ArrayList<House>();
                CountDownLatch cdl = new CountDownLatch(totalPages);
                for(int i = 1; i <= totalPages; i++){
                    HouseRunnableJob job = new HouseRunnableJob("http://sh.lianjia.com/ershoufang/d" + i, list, cdl);
                    fixedThreadPool.execute(job);
                }
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                houseService.batchInsert(list);
                fixedThreadPool.shutdown();
            }
        }
        LOG.info("结束任务");
    }


}
