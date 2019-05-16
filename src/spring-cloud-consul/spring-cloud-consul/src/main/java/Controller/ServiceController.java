package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class ServiceController {
    @Autowired
    private DiscoveryClient  discoveryClient;
}
