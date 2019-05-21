## 服务治理：Spring Cloud Consul

### 简介

Spring Cloud Consul项目是针对Consul的服务治理实现。Consul是一个分布式高可用的系统，它包含多个组件，但是作为一个整体，在微服务架构中为我们的基础设施提供服务发现和服务配置的工具。它包含了下面几个特性：

- 服务发现：consul通过DNS或者HTTP接口使服务注册和服务发现变的很容易，一些外部服务，例如saas提供的也可以一样注册。
- 健康监测：健康检测使consul可以快速的告警在集群中的操作。和服务发现的集成，可以防止服务转发到故障的服务上面。
- Key/Value存储：一个用来存储动态配置的系统。提供简单的HTTP接口，可以在任何地方操作。
- 多数据中心：无需复杂的配置，即可支持任意数量的区域。

服务发现的常用框架：

| Feature              | Eureka                       | Consul                 | zookeeper             | etcd              |
| -------------------- | ---------------------------- | ---------------------- | --------------------- | ----------------- |
| 服务健康检查         | 可配支持                     | 服务状态，内存，硬盘等 | (弱)长连接，keepalive | 连接心跳          |
| 多数据中心           | —                            | 支持                   | —                     | —                 |
| kv 存储服务          | —                            | 支持                   | 支持                  | 支持              |
| 一致性               | —                            | raft                   | paxos                 | raft              |
| cap                  | ap                           | cp                     | cp                    | cp                |
| 使用接口(多语言能力) | http（sidecar）              | 支持 http 和 dns       | 客户端                | http/grpc         |
| watch 支持           | 支持 long polling/大部分增量 | 全量/支持long polling  | 支持                  | 支持 long polling |
| 自身监控             | metrics                      | metrics                | —                     | metrics           |
| 安全                 | —                            | acl /https             | acl                   | https 支持（弱）  |
| spring cloud 集成    | 已支持                       | 已支持                 | 已支持                | 已支持            |

Consul结构：
<div>
    <image src="../res/img/consul-arch.png"></image>
</div>
Consul原理：

<div>
    <image src="../res/img/consul_service.png"></image>
</div>



### 构建Consul 服务端

1. [下载consul](https://www.consul.io/downloads.html)，解压后启动Consul，启动成功后在浏览器中打开：http://localhost:8500/ui/dc1/services

   <div>
       <image src="../res/img/consul1.png"></image>
   </div>

2. pom中添加依赖

   ```xml
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-consul-discovery</artifactId>
   </dependency>
   <!--健康检查依赖于此包!-->
   <dependency>
   	<groupId>org.springframework.boot</groupId>
   	<artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   
   <dependencyManagement>
   	<dependencies>
   		<dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-dependencies</artifactId>
   			<version>Greenwich.SR1</version>
   			<type>pom</type>
   			<scope>import</scope>
   		</dependency>
   	</dependencies>
   </dependencyManagement>
   ```

3. 配置文件

   ```
   spring.application.name=spring-cloud-consul-producer 
   server.port=8503
   spring.cloud.consul.host=localhost
   spring.cloud.consul.port=8500
   #设置不需要注册到 consul 中
   spring.cloud.consul.discovery.register=true
   ```

4. 在Application类上加@EnableDiscoveryClient注解，并新建Controller：

   1. 

      ```java
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
      ```

5. 为了模拟注册均衡负载复制一份上面的项目重命名为 spring-cloud-consul-consumer-2,修改对应的端口，修改完成后依次启动两个项目。

   <div>
       <image src="../res/img/consul2.png"></image>
   </div>

### 构建Consul 消费端