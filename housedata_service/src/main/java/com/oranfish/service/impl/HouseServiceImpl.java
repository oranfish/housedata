package com.oranfish.service.impl;

import com.oranfish.dao.HouseMapper;
import com.oranfish.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseMapper houseMapper;

    public Integer getCount(){
        return houseMapper.count();
    }
}
