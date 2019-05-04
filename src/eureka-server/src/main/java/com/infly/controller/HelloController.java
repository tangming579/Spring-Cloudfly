package com.infly.controller;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        return "hello " + name + " , this is first message";
    }
}
