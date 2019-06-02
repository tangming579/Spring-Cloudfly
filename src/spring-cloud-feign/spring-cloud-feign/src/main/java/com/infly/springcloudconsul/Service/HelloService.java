package com.infly.springcloudconsul.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="helloservice",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    public String hello();
}
