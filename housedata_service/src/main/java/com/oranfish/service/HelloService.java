package com.oranfish.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getHello(){
        return "helloWorld";
    }
}
