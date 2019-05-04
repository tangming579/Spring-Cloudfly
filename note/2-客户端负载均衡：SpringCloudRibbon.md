## 客户端负载均衡：Spring Cloud Ribbon

### 简介

Spring Cloud Ribbon是一个基于HTTP和TCP的客户端负载均衡工具。可以让我们轻松地将面向服务的REST模板请求自动转换成客户端负载均衡的服务调用。它几乎存在于每个Spring Cloud 构建的微服务和基础设施中。因为微服务间的调用，API网关的请求转发等内容，实际上都是通过Ribbon来实现的。

<div>
    <image src="../res/img/loadbalance.png"></image>
</div>

