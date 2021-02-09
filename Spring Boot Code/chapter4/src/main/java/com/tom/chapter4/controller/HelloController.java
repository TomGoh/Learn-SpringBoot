package com.tom.chapter4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2021/2/9.
 *
 * @author Tom Goh
 */

@RestController
public class HelloController {

    @SuppressWarnings({"unused"})
    @GetMapping("/hello")
    public String getHello(){
        String result="";
        return "Hello!";
    }

}
