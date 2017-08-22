package com.oranfish.service;

import com.oranfish.entity.House;

import java.util.List;

public interface ClawService {
    Integer getTotalPages(String url);
    List<House> getPaginateData(String url);
}
