package com.oranfish.task.job;

import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import com.oranfish.service.impl.ClawServiceImpl;

import java.util.List;

public class HouseRunnableJob implements Runnable{

    private String url;
    private List<House> list;

    private ClawService clawService = new ClawServiceImpl();

    public HouseRunnableJob(String url, List<House> list){
        this.url = url;
        this.list = list;
    }

    public void run() {
        List<House> paginateDataList = clawService.getPaginateData(url);
        if(paginateDataList != null && !paginateDataList.isEmpty()){
            list.addAll(paginateDataList);
        }
    }
}
