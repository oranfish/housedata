package com.oranfish.service;

import com.oranfish.entity.House;

import java.util.List;

public interface ClawService {
    Integer getTotalPage(String url);
    List<House> getPaginateData(String url);
    List<String> getPart(String url, int level);
}
