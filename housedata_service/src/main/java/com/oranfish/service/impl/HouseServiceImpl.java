package com.oranfish.service.impl;

import com.oranfish.common.DateUtils;
import com.oranfish.dao.HouseMapper;
import com.oranfish.entity.House;
import com.oranfish.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseMapper houseMapper;

    private static final Logger LOG = LoggerFactory.getLogger(HouseServiceImpl.class);

    public Integer getTodayCount(){
        return houseMapper.count(DateUtils.getToday(), DateUtils.getTodayAddDay(1));
    }

    public Integer batchInsert(List<House> houseList) {
        if(houseList != null && !houseList.isEmpty()){
            Iterator iterator = houseList.iterator();
            while(iterator.hasNext()){
                House house = (House)iterator.next();
                LOG.info("入库前未过滤的house：{}", house);
                if(house != null){
                    Integer houseCount = houseMapper.countSingleHouse(house, DateUtils.getToday(), DateUtils.getTodayAddDay(1));
                    if(houseCount != null && houseCount > 0){
                        iterator.remove();
                    }
                }
            }
            if(houseList != null && !houseList.isEmpty()){
                return houseMapper.batchInsert(houseList);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
