## 服务治理：Spring Cloud Eureka

### 简介

Spring Cloud Eureka 是Spring Cloud Netflix 微服务套件的一部分，主要负责完成微服务架构中服务治理功能。服务治理是微服务架构中最为核心和基础的模块，它主要用来实现各个微服务实例的**自动化注册与发现**。

Eureka Server 提供注册服务，各个节点启动后，会在Eureka Server 中进行注册，这样Eureka Server 的服务注册表中将会存储所有可用服务节点信息，服务可用节点的信息可以在界面中直观地看到。

Eureka Client 主要用于处理服务的注册与发现的java客户端，用于简化与Eureka Server的交互，客户端同时也是一个负载均衡器。在应用启动后将会向Eureka Server 发送心跳。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server 将会从服务表中将这个节点移除。Netflix在其生产环境中使用的是另外的客户端，它提供基于流量、资源利用率以及出错状态的加权负载均衡。

**注意：**

从2.X起，eureka server 已经停止更新，替代方案为Consul。除了服务注册、发现，consul还提供了k-v存储等其它功能，consul的官网针对其它同类软件也做了详细比较，详见 [consul vs other software](https://www.consul.io/intro/vs/index.html)

<div>
    <image src="../res/img/eureka-architecture-overview.png"></image>
</div>
### 实践

1. pom中添加依赖

   ```xml
   <dependencies>
   	<dependency>
   		<groupId>org.springframework.cloud</groupId>
   		<artifactId>spring-cloud-starter</artifactId>
   	</dependency>
   	<dependency>
   		<groupId>org.springframework.cloud</groupId>
   		<artifactId>spring-cloud-starter-eureka-server</artifactId>
   	</dependency>
   	<dependency>
   		<groupId>org.springframework.boot</groupId>
   		<artifactId>spring-boot-starter-test</artifactId>
   		<scope>test</scope>
   	</dependency>
   </dependencies>
   ```

2. 添加启动代码注解@EnableEurekaServer

   ```java
   @SpringBootApplication
   @EnableEurekaServer
   public class SpringCloudEurekaApplication {
   
   	public static void main(String[] args) {
   		SpringApplication.run(SpringCloudEurekaApplication.class, args);
   	}
   }
   ```

3. 配置文件

   ```
   server.port=8000
   eureka.client.register-with-eureka=false
   eureka.client.fetch-registry=false
   
   eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/
   ```

**注意：**

就像Spring Boot需要依赖对应的Spring Framework版本一样，Spring Cloud需要依赖对应版本的Spring Boot，不能随便使用版本。版本的对应关系可以在 <https://start.spring.io/info> 上查看。

在springcloud的官网http://spring.io/projects/spring-cloud中也有相应的版本说明：