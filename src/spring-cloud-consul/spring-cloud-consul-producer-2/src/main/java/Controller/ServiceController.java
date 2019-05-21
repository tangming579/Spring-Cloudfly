package Controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class ServiceController {

    // hello 的服务
    @RequestMapping("/hello")
    public String hello(){
        return "hello consul 2";
    }
}
