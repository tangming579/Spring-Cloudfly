package com.infly.springcloudconsul.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("helloservice")
public class HelloService {

    public String call() {
        return "this messge send failed ";
    }
}
