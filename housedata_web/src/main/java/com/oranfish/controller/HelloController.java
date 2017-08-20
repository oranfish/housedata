package com.oranfish.controller;

import com.oranfish.service.HelloService;
import com.oranfish.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private HouseService houseService;

    @RequestMapping("/{name}")
    public String getHello( @PathVariable("name") String name, Model model){
        String hello = helloService.getHello();
        model.addAttribute("result", hello + "，" + name);
        System.out.println(houseService.getCount());
        return "hello";
    }

}
