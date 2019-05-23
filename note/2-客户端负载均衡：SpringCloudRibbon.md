## 客户端负载均衡：Spring Cloud Ribbon

### 简介

Spring Cloud Ribbon是一个基于HTTP和TCP的客户端负载均衡工具。可以让我们轻松地将面向服务的REST模板请求自动转换成客户端负载均衡的服务调用。它几乎存在于每个Spring Cloud 构建的微服务和基础设施中。因为微服务间的调用，API网关的请求转发等内容，实际上都是通过Ribbon来实现的。

<div>
    <image src="../res/img/loadbalance.png"></image>
</div>
负载均衡在系统架构中是一个非常重要，并且是不得不去实施的内容。因为负载均衡是对系统的高可用、网络压力的缓解和处理能力扩容的重要手段之一。

负载均衡又区分了两种类型：

- 客户端负载均衡(Ribbon)
  - 服务实例的**清单在客户端**，客户端进行负载均衡算法分配。
  - (客户端可以从Eureka Server中得到一份服务清单，在发送请求时通过负载均衡算法，**在多个服务器之间选择一个进行访问**)
- 服务端负载均衡(Nginx)
  - 服务实例的**清单在服务端**，服务器进行负载均衡算法分配

### TestTemplate

通过Eureka或Ribbon服务治理框架，我们可以通过服务名来获取具体的服务实例的位置(IP)。一般在使用Spring Cloud的时候**不需要自己手动创建**HttpClient来进行远程调用。可以使用Spring封装好的**RestTemplate**工具类：

```java
@RequestMapping("call")
public String call(){
  ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
  String url = serviceInstance.getUri().toString();
  String result = new RestTemplate().getForObject(url + "hello",String.class);
  return result;
}
```

### 自定义负载均衡策略

Ribbon是支持负载均衡，默认的负载均衡策略是轮询，也是可以根据自己实际的需求自定义负载均衡策略。

```java
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        //return new RandomRule();// 自定义为随机
        //return new RoundRobinRule();// 自定义为线性随机        
        return new RetryRule();// 自定义为重试机制选择功能
    }
}
```