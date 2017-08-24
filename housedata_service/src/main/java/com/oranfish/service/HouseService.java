package com.oranfish.service;

import com.oranfish.entity.House;

import java.util.List;

public interface HouseService {
    Integer getTodayCount();
    Integer batchInsert(List<House> houseList);
}
