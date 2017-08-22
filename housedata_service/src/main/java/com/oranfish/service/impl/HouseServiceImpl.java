package com.oranfish.service.impl;

import com.oranfish.common.DateUtils;
import com.oranfish.dao.HouseMapper;
import com.oranfish.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseMapper houseMapper;

    public Integer getTodayCount(){
        return houseMapper.count(DateUtils.getToday(), DateUtils.getTodayAddDay(1));
    }
}
