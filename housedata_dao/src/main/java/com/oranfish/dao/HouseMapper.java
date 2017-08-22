package com.oranfish.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface HouseMapper {
    Integer count(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
