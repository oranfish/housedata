package com.oranfish.service;

import com.oranfish.dao.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    private HouseMapper houseMapper;

    public Integer getCount(){
        return houseMapper.count();
    }
}
