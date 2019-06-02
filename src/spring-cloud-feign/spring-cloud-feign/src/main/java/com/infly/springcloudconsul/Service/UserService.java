package com.infly.springcloudconsul.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="helloservice",fallback=UserServiceFallback.class)
public interface UserService {

    @RequestMapping(value="/findUser/{id}",method= RequestMethod.GET)
    public User findUserById(@PathVariable("id") Long id);
}
