package com.infly.springcloudconsul.Service;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix{

    public String call() {
        return "this messge send failed ";
    }
}
