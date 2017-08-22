package com.oranfish.task;

import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import com.oranfish.service.HouseService;
import com.oranfish.task.job.HouseRunnableJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class HouseTask {

    @Autowired
    private HouseService houseService;
    @Autowired
    private ClawService clawService;

    public void doTask(){
        if(houseService.getTodayCount() != null && houseService.getTodayCount() == 0){
            Integer totalPages = clawService.getTotalPages("http://sh.lianjia.com/ershoufang/");
            if(totalPages != null && totalPages > 0){
                ExecutorService fixedThreadPool = Executors.newFixedThreadPool(16);
                List<House> list = new ArrayList<House>();
                for(int i = 1; i <= totalPages; i++){
                    HouseRunnableJob job = new HouseRunnableJob("http://sh.lianjia.com/ershoufang/d" + i, list);
                    fixedThreadPool.execute(job);
                }
                //TODO入库



                fixedThreadPool.shutdown();
            }
        }
    }


}
