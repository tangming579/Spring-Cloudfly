package com.infly.springcloudconsul.Service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "Hello Service is Error";
    }
}
