package com.oranfish.controller;

import com.oranfish.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HouseService houseService;

    @GetMapping("/{name}")
    public String getHello( @PathVariable("name") String name, Model model){
        model.addAttribute("result", "helloworld，" + name + "============");
        LOG.info(houseService.getTodayCount().toString());
        return "hello";
    }

}
