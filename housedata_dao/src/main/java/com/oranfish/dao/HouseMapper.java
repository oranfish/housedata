package com.oranfish.dao;

import com.oranfish.entity.House;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface HouseMapper {
    Integer count(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    Integer batchInsert(@Param("houseList") List<House> houseList);
}
