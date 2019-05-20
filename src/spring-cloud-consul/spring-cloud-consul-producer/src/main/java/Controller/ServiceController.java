package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class ServiceController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String hello(){
        return "hello consul";
    }
}
