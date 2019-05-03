## 服务治理：Spring Cloud Eureka

Spring Cloud Eureka 是Spring Cloud Netflix 微服务套件的一部分，主要负责完成微服务架构中服务治理功能。服务治理是微服务架构中最为核心和基础的模块，它主要用来实现各个微服务实例的自动化注册与发现。

Eureka Server 提供注册服务，各个节点启动后，会在Eureka Server 中进行注册，这样Eureka Server 的服务注册表中将会存储所有可用服务节点信息，服务可用节点的信息可以在界面中直观地看到。

Eureka Client 主要用于处理服务的注册与发现的java客户端，用于简化与Eureka Server的交互，客户端同时也是一个负载均衡器。在应用启动后将会向Eureka Server 发送心跳。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server 将会从服务表中将这个节点移除。

Eureka Server之间通过复制的方式完成数据的同步，Eureka还提供了客户端缓存机制，即使所有的Eureka Server都挂掉，客户端依然可以利用缓存中的信息消费其他服务的API。综上，Eureka通过心跳检查、客户端缓存等机制，确保了系统的高可用性、灵活。