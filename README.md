# Spring-rabbitMQ
  - 在业务逻辑的异步处理，系统解耦，分布式通信以及控制高并发的场景下，消息队列有着广泛的应用。本项目基于Spring的AMQP模块，整合流行的开源消息队列中间件rabbitMQ,实现一个向rabbitMQ添加和读取消息的功能。并比较了两种模式：生产者-消费者模式和发布-订阅模式的区别。AMQP作为比JMS更加高级的消息协议，支持更多的消息路由和消息模式。
  
- 包含的特性如下：

  ![输入图片说明](http://git.oschina.net/uploads/images/2017/0223/081751_c96aa8d6_1110335.png "在这里输入图片标题")
  
1. 如上图，生产者消费者模型：添加了一个队列，并创建了两个消费者用于监听队列消息，我们发现，当有消息到达时，两个消费者会交替收到消息。这一过程虽然不用创建交换机，但会使用默认的交换机，并用默认的直连（default-direct）策略连接队列；

![输入图片说明](http://git.oschina.net/uploads/images/2017/0223/081802_088eb810_1110335.png "在这里输入图片标题")

2. 如下图，发布订阅模型，添加两个队列，分别各用一个消费者监听，设置一个交换机，类型为广播（fanout），交换机会将收到的消息广播给所有相连的队列：

![输入图片说明](http://git.oschina.net/uploads/images/2017/0223/081828_bb1c0dad_1110335.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2017/0223/081836_cf8c1eca_1110335.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2017/0223/081845_581684b4_1110335.png "在这里输入图片标题")

3. direct直连交换机通信模型，包括一个direct交换机，三个binding，两个队列，两个消费者监听器，消息只会被投入到routingkey一致的队列中

 ![输入图片说明](https://git.oschina.net/uploads/images/2017/0902/111518_ec24f2cf_1110335.png "3.png")
 ![输入图片说明](https://git.oschina.net/uploads/images/2017/0902/111713_388a2cb4_1110335.png "5.png")

4.topic主题交换机通信，包括一个topic交换机，三个binding，两个队列，两个消费者监听器，消息只会被投入到routingkey能够匹配的队列中，#表示0个或若干个关键字，*表示一个关键字

![输入图片说明](https://git.oschina.net/uploads/images/2017/0902/122830_278b8f19_1110335.png "4.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0902/122904_a0229951_1110335.png "6.png")

5. 进入http://localhost:8080/Spring-rabbitMQ/demo 可向rabbitMQ发送消息，如下图：
 ![输入图片说明](https://git.oschina.net/uploads/images/2017/0902/122918_5adae2c4_1110335.png "QQ截图20170902122553.png")


### 附录：个人作品索引目录（持续更新）

#### 基础篇:职业化，从做好OA系统开始
1. [SpringMVC,Mybatis,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/SSM)
2. [Struts2,Hibernate,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/S2SH)
3. [Spring,SpringMVC和Hibernate的整合实现增删改查](https://gitee.com/shenzhanwang/SSH)
4. [Spring平台整合activiti工作流引擎实现OA开发](https://gitee.com/shenzhanwang/Spring-activiti)
5. [Spring发布与调用REST风格的WebService](https://gitee.com/shenzhanwang/Spring-REST)
6. [Spring整合Apache Shiro框架，实现用户管理和权限控制](https://gitee.com/shenzhanwang/Spring-shiro)
7. [使用Spring security做权限控制](https://gitee.com/shenzhanwang/spring-security-demo)
8. [Spring整合Jasig CAS框架实现单点登录](https://gitee.com/shenzhanwang/Spring-cas-sso)
#### 中级篇：中间件的各种姿势
9. [Spring连接mongoDB数据库实现增删改查](https://gitee.com/shenzhanwang/Spring-mongoDB)
10. [Spring连接Redis实现缓存](https://gitee.com/shenzhanwang/Spring-redis)
11. [Spring连接图存数据库Neo4j实现增删改查](https://gitee.com/shenzhanwang/Spring-neo4j)
12. [Spring平台整合消息队列ActiveMQ实现发布订阅、生产者消费者模型（JMS）](https://gitee.com/shenzhanwang/Spring-activeMQ)
13. [Spring整合消息队列RabbitMQ实现四种消息模式（AMQP）](https://gitee.com/shenzhanwang/Spring-rabbitMQ)
14. Spring框架的session模块实现集中式session管理（[购买](https://www.fageka.com/store/item/s/id/fwW1QEK2848.html)）
15. [Spring整合websocket实现即时通讯](https://gitee.com/shenzhanwang/Spring-websocket)
16. 使用Spring boot整合mybatis,rabbitmq,redis,mongodb实现增删改查（[购买](https://www.fageka.com/store/item/s/id/0feQDHL1913.html)）
17. [Spring MVC整合FastDFS客户端实现文件上传](https://gitee.com/shenzhanwang/Spring-fastdfs)
18. 23种设计模式，源码、注释、使用场景（[购买](https://www.fageka.com/store/item/s/id/TuSSL2r3330.html)）
19. [使用ETL工具Kettle的实例](https://gitee.com/shenzhanwang/Kettle-demo)
20. Git指南和分支管理策略（[购买](https://www.fageka.com/store/item/s/id/Z7uh2iF1620.html)）
#### 高级篇：架构之美
21. [zookeeper原理、架构、使用场景和可视化](https://gitee.com/shenzhanwang/zookeeper-practice)
22. Spring框架整合dubbo框架实现分布式服务治理（SOA架构）（[购买](https://www.fageka.com/store/item/s/id/tTEHOF42241.html)）
23. Spring框架整合dubbox实现微服务架构（MSA架构）
24. 使用Spring Cloud实现微服务架构（MSA架构）（[购买](https://www.fageka.com/store/item/s/id/5T5cEY80304.html)）
25. 使用jenkins+centos+git+maven搭建持续集成环境自动化部署分布式服务（[购买](https://www.fageka.com/store/item/s/id/TvLt0pr4205.html)）
26. 使用docker+compose+jenkins+gitlab+spring cloud实现微服务的编排、持续集成和动态扩容（[购买](https://www.fageka.com/store/item/s/id/7Gi4FeN2111.html)）
27. 使用FastDFS搭建分布式文件系统（高可用、负载均衡）（[购买](https://www.fageka.com/store/item/s/id/sAKgl2n4209.html)）
28. 搭建高可用nginx集群和Tomcat负载均衡（[购买](https://www.fageka.com/store/item/s/id/78bvd6N2534.html)）
29. 搭建可扩展的ActiveMQ高可用集群（[购买](https://www.fageka.com/store/item/s/id/H1nWZ4j4443.html)）
30. 实现Mysql数据库的主从复制、读写分离、分表分库、负载均衡和高可用（[购买](https://www.fageka.com/store/item/s/id/lojrGCH2016.html)）
31. 搭建高可用redis集群实现分布式缓存（[购买](https://www.fageka.com/store/item/s/id/02HwT2W4038.html)）
32. [Spring整合SolrJ实现全文检索](https://gitee.com/shenzhanwang/Spring-solr)
#### 特别篇：分布式事务和并发控制
33. 基于可靠消息最终一致性实现分布式事务（activeMQ）（[购买](https://www.fageka.com/store/item/s/id/qwCZgHD2224.html)）
34. 使用TCC框架实现分布式事务（dubbo版）（[购买](https://www.fageka.com/store/item/s/id/woVwDpD0145.html)）
35. 使用TCC框架实现分布式事务（Spring Cloud版）（[购买](https://www.fageka.com/store/item/s/id/VZ4lvg40739.html)）
36. 决战高并发：数据库锁机制和事务隔离级别的实现（[购买](https://www.fageka.com/store/item/s/id/Xvk7DZI2400.html)）
37. 决战高并发：使用redis实现分布式锁（[购买](https://www.fageka.com/store/item/s/id/uFQStQ61656.html)）
38. 决战高并发：使用zookeeper实现分布式锁（[购买](https://www.fageka.com/store/item/s/id/NQp8kpF1940.html)）
39. 决战高并发：Java多线程编程实例（[购买](https://www.fageka.com/store/item/s/id/k6MzK041644.html)）
40. 决战高并发：使用netty实现高性能NIO通信（[购买](https://www.fageka.com/store/item/s/id/VtwnbVN5319.html)）

### 网店入口
[我的网店](https://www.fageka.com/Store/Index/shop/id/1zxrETbHcz)
   