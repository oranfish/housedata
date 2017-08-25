package com.oranfish.task.job;

import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import com.oranfish.service.HouseService;
import com.oranfish.service.impl.ClawServiceImpl;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HouseRunnableJob implements Runnable{

    private String url;
    private List<House> list;
    private CountDownLatch cdl;
    private ClawService clawService = new ClawServiceImpl();

    public HouseRunnableJob(String url, List<House> list, CountDownLatch cdl){
        this.url = url;
        this.list = list;
        this.cdl = cdl;
    }

    public void run() {
        List<House> paginateDataList = clawService.getPaginateData(url);
        if(paginateDataList != null && !paginateDataList.isEmpty()){
            list.addAll(paginateDataList);
        }
        cdl.countDown();
    }
}
