package com.infly.springcloudconsul.controller;

import com.infly.springcloudconsul.Service.HelloService;
import com.infly.springcloudconsul.Service.UserService;
import com.infly.springcloudconsul.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private UserService userService;

    @RequestMapping("/test1")
    public String Test1(){
        return helloService.hello();
    }

    @RequestMapping("/test2")
    public User Test2(Long userId){
        return userService.findUserById(userId);
    }
}
