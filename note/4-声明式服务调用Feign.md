## 声明式服务调用Spring Cloud Feign

### 简介

- Feign是一个声明式、模板化的HTTP客户端，通过Feign可以实现服务间的相互调用，比如服务A调用服务B暴露的一些接口；
- 同时Feign整合了Ribbon与Hystrix（负载均衡与熔断），所以Feign也可以实现服务的负载均衡调用。

### 使用

