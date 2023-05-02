# seckill-mall

## tips

```bash
#安装编译环境（以mac-arm为例）
arch -arm64 brew install protobuf
#检查安装是否成功，出现版本号即为成功
protoc --version
#安装plugin，用于生成service
#从 https://repo.maven.apache.org/maven2/io/grpc/protoc-gen-grpc-java/ 下载 protoc-gen-grpc-java-1.54.1-osx-x86_64.exe
#下载完成放到对应目录后去掉.exe后缀，然后执行如下命令，否则会报错，原因见 https://stackoverflow.com/questions/55023435/grpc-out-protoc-gen-grpc-plugin-failed-with-status-code-1-on-osx-java
chmod +x protoc-gen-grpc-java-1.54.1-osx-x86_64.exe
#最后执行脚本文件即可，脚本文件见/common/src/main/java/com/zufe/yt/common/pb/gen_code.sh

#项目以来中添加如下依赖，版本与protoc版本一致
<dependency>
      <groupId>com.google.protobuf</groupId>
      <artifactId>protobuf-java</artifactId>
      <version>${protobuf.version}</version>
  </dependency>
```

## 商城秒杀系统-整体架构图

![](https://typora-imagehost-1308499275.cos.ap-shanghai.myqcloud.com/mac/macimage-20230416203428539.png)

### 聚合的一些设计原则

**1. 在一致性边界内建模真正的不变条件。**聚合用来封装真正的不变性，而不是简单地将对象组合在一起。聚合内有一套不变的业务规则，各实体和值对象按照统一的业务规则运行，实现对象数据的一致性，边界之外的任何东西都与该聚合无关，这就是聚合能实现业务高内聚的原因。

**2. 设计小聚合。**如果聚合设计得过大，聚合会因为包含过多的实体，导致实体之间的管理过于复杂，高频操作时会出现并发冲突或者数据库锁，最终导致系统可用性变差。而小聚合设计则可以降低由于业务过大导致聚合重构的可能性，让领域模型更能适应业务的变化。

**3. 通过唯一标识引用其它聚合。**聚合之间是通过关联外部聚合根 ID 的方式引用，而不是直接对象引用的方式。外部聚合的对象放在聚合边界内管理，容易导致聚合的边界不清晰，也会增加聚合之间的耦合度。

**4. 在边界之外使用最终一致性。**聚合内数据强一致性，而聚合之间数据最终一致性。在一次事务中，最多只能更改一个聚合的状态。如果一次业务操作涉及多个聚合状态的更改，应采用领域事件的方式异步修改相关的聚合，实现聚合之间的解耦。

**5. 通过应用层实现跨聚合的服务调用。**为实现微服务内聚合之间的解耦，以及未来以聚合为单位的微服务组合和拆分，应避免跨聚合的领域服务调用和跨聚合的数据库表关联。

## 代码目录

采用微服务开发的方式，以一个父pom作为总的项目，内置多个模块可单独构建成微服务。

### 一级目录

![image-20230411141820378](https://typora-imagehost-1308499275.cos.ap-shanghai.myqcloud.com/2022-12/image-20230411141820378.png)

### 二级目录(以person为例)

```shell
└─person
    │  PersonApplication.java
    ├─application
    │  │  TestService.java
    │  └─service
    ├─domain
    │  ├─aggregate1
    │  │  ├─entity
    │  │  ├─repository
    │  │  └─service
    │  └─aggregate2
    │      ├─entity
    │      ├─repository
    │      └─service
    ├─infrastructure
    │  ├─config
    │  ├─persistence
    │  │  ├─data
    │  │  └─repository
    │  ├─transfer
    │  └─util
    └─interfaces
        ├─dto
        └─facade
```

#### 1、用户接口层

- **Dto：** 它是数据传输的载体，内部不存在任何业务逻辑，我们可以通过 DTO 把内部的领域对象与外界隔离。
- **Facade：** 提供较粗粒度的调用接口，将用户请求委派给一个或多个应用服务进行处理。

#### 2、应用层

- **Service（应用服务）：**这层的服务是应用服务。

  >应用服务会对多个领域服务或外部应用服务进行封装、编排和组合，对外提供粗粒度的服务。应用服务主要实现服务组合和编排，是一段独立的业务逻辑。你可以将所有应用服务放在一个应用服务类里，也可以把一个应用服务设计为一个应用服务类，以防应用服务类代码量过大

#### 3、领域层

- **Aggregate（聚合）：** 它是聚合软件包的根目录，可以根据实际项目的聚合名称命名，比如权限聚合。

  >在聚合内定义聚合根、实体和值对象以及领域服务之间的关系和边界。聚合内实现高内聚的业务逻辑，它的代码可以独立拆分为微服务。
  >
  >以聚合为单位的代码放在一个包里的主要目的是为了业务内聚，而更大的目的是为了以后微服务之间聚合的重组。聚合之间清晰的代码边界，可以让你轻松地实现以聚合为单位的微服务重组，在微服务架构演进中有着很重要的作用。

- **Entity（实体）：** 它存放聚合根、实体、值对象以及工厂模式（Factory）相关代码。

  >实体类采用 **充血模型**，同一实体相关的业务逻辑都在实体类代码中实现。跨实体的业务逻辑代码在领域服务中实现。

- **Service（领域服务）：** 它存放领域服务代码。

  >一个领域服务是多个实体组合出来的一段业务逻辑。你可以将聚合内所有领域服务都放在一个领域服务类中，你也可以把每一个领域服务设计为一个类。如果领域服务内的业务逻辑相对复杂，我建议你将一个领域服务设计为一个领域服务类，避免由于所有领域服务代码都放在一个领域服务类中，而出现代码臃肿的问题。领域服务封装多个实体或方法后向上层提供应用服务调用。

- **Repository（仓储）：** 它存放所在聚合的查询或持久化领域对象的代码，通常包括仓储接口和仓储实现方法。为了方便聚合的拆分和组合，我们设定了一个原则：一个聚合对应一个仓储。

#### 4、基础层

- **Config：** 主要存放配置相关代码。
- **Util：** 主要存放平台、开发框架、消息、数据库、缓存、文件、总线、网关、第三方类库、通用算法等基础代码，你可以为不同的资源类别建立不同的子目录。

## 核心业务——秒杀

如何提升秒杀服务的性能是首要的，激进的做法就是面向内存编程（当然这太过激进了），问题的关键在于找到是哪个点卡住了秒杀（主要是新增订单）这个业务。要分析这个问题可以从一个很简单的方面去看：

>哪些点是可以通过加机器解决的，哪些点不可以
>
>因为是通过微服务容器化部署的，所以凡是能通过简单的加机器或者多开几个容器解决的问题那都不是问题，而那些不能通过加机器解决的问题才恰恰是卡住这个业务性能的点，解决了这个，性能自然而然就上去了。

再往下分析哪些是不能通过加机器解决的，首要的就是数据库问题：xxxxx

数据库优化的漏斗法则（从图中也可以看出硬件层面的提升对于数据库来说收益是很低的）：

![up-1ad064952d259a9389d0f1aac3842d27525](https://typora-imagehost-1308499275.cos.ap-shanghai.myqcloud.com/2022-12/up-1ad064952d259a9389d0f1aac3842d27525.webp)

从全局唯一id着手优化，正常的商品下单给他一个全局id，全局id的作用就是在多容器的情况下也做到全局唯一，而不是去依赖数据库

再优化就是秒杀活动中生成一个商品池，池中的每个商品对应一个全局唯一id，将一个池分片发奖，参考12306的抢票系统

这种全局唯一id思想适用于落库即死的数据，比如订单，落库了基本不会再改了，所以只要给他一个全局唯一的id代表身份即可，可以先在内存中存一下信息（还可以先写个日志防止数据丢失）然后定时同步持久化。

在一个就是考虑锁的问题，正常情况下下单过程中会给商品库存加个锁，确保串行扣减库存，但是加了锁必然影响性能，所以只要在库存这一步做到无锁化串行就能大大提升性能，最简单的例子就是用redis+lua脚本扣减库存

库存这个字段的获得：不要去数据库里创一个库存字段，而是创一个总量字段和已使用量字段，库存=两者相减。这种情况下是一个唯一不变的字段和一个唯一递增的字段可以保证库存的准确性，单独的一个可变的库存字段无法保证库存的准确性。

不用库存字段这样库存只能通过计算得出，相当于库存只有自己才能碰得到，别人是碰不到的，已使用量这个值也只在lua脚本里变更，确保准确性