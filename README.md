# Spring-Cloudfly
[![Badge](https://img.shields.io/badge/language-java-brigtgreen.svg) ![](https://img.shields.io/npm/v/drone.svg) ![Badge](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu/#/en_US)

Spring Cloud 微服务相关知识学习总结

## 什么是微服务

微服务是系统架构上的一种设计风格，它的主旨是将一个原本独立的系统拆分成多个小型服务，这些小型服务都在各自独立的进程中进行，服务之间通过基于HTTP的RESTful API进行通信协作。被拆分成的每个小型服务都围绕着系统中的某一项或一些耦合度较高的业务功能进行构建，并且每个服务都维护着自身的数据存储、业务开发、自动化测试案例以及独立部署机制。由于有了轻量级的通信协作基础，所以这些微服务可以使用不同的语言来编写。

## Spring Cloud

Spring Cloud 是一个基于Spring boot 实现的微服务架构开发工具。其主要包含如下子项目：

- Spring Cloud Config：配置管理工具，支持使用Git存储配置内容，可以使用它实现应用配置的外部化存储，并支持客户端配置信息刷新、加密/解密配置内容等。
- Spring Cloud Netflix：核心组件，对多个Netflix OOS开源套件进行整合。
  - Eureka：服务治理组件
  - Hystrix：容错管理组件
  - Ribbon：客户端负载均衡的服务调用组件
  - Feign：基于Ribbon和Hystrix的声明式服务调用组件
  - Zuul：网关组件
  - Archaius：外部化配置组件

- Spring Cloud Bus：事件、消息总线，用于传播集群中的状态变化或事件，以触发后续处理，比如用来动态刷新配置等。
- Spring Cloud Cluster：针对ZooKeeper、Redis、Hazelcast、Consul的选举算法和通用状态模块实现。
- Spring Cloud Cloudfoundry：与Pivotal Cloudfoudry的整合支持。
- Spring Cloud Consul：服务发现与配置管理工具。
- Spring Cloud Stream：通过Redis、Ribbit或者Kafka实现的消费微服务，可以通过简单的声明式模型来发送和接收消息。
- Spring Cloud Security：安全工具包，提供在Zuul代理中对OAuth2客户端请求的中继器。
- ……

## 目录

1. [总览](https://github.com/tangming579/Spring-Cloudfly/blob/master/note/0-Overview.md)
2. [服务治理：Spring Cloud Eureka](https://github.com/tangming579/Spring-Cloudfly/blob/master/note/1-%E6%9C%8D%E5%8A%A1%E6%B2%BB%E7%90%86%EF%BC%9ASpringCloudEureka.md)
3. [客户端负载均衡：Spring Cloud Ribbon](https://github.com/tangming579/Spring-Cloudfly/blob/master/note/2-%E5%AE%A2%E6%88%B7%E7%AB%AF%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%EF%BC%9ASpringCloudRibbon.md)
4. 服务容错保护：Spring Cloud Hystrix
5. 声明式服务调用：Spring Cloud Feign
6. API网关服务：Spring Cloud Zuul
7. 分布式配置中心：Spring Cloud Config
8. 消息总线：Spring Cloud Bus
9. 消息驱动的微服务：Spring Cloud Stream
10. 分布式服务跟踪：Spring Cloud Sleuth