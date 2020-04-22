package com.neuedu.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
                int i = 0 ;
        int k = 0 ;
        int b = 0 ;
        int c = 0 ;
        return "{\"content\":\"hello Spring Boot!!\"}";
    }

}
