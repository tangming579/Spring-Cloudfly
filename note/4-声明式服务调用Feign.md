## 声明式服务调用Spring Cloud Feign

### 简介

- Feign是一个声明式、模板化的HTTP客户端，通过Feign可以实现服务间的相互调用，比如服务A调用服务B暴露的一些接口；
- 同时Feign整合了Ribbon与Hystrix（负载均衡与熔断），所以Feign也可以实现服务的负载均衡调用。

### 使用

1. 引入依赖：
2. 主类加入@EnableFeginClients注解
3. 定义Service接口，通过FeignClient注解指定服务名来绑定服务
4. 参数绑定
5. 配置文件

