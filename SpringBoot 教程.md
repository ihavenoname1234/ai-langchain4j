# SpringBoot 教程

  ![Spring Boot教程](https://www.cainiaojc.com/static/upload/210423/1629260.jpg)

Spring Boot教程提供了Spring Framework的基本和高级概念。我们的Spring Boot教程面向初学者和专业人士。

Spring Boot是一个Spring模块，为Spring框架提供RAD(快速应用程序开发)功能。

我们的Spring Boot教程涵盖了Spring Boot的所有主题，例如功能，项目，maven项目，启动程序项目向导，Spring Initializr，CLI，应用程序，注释，依赖项管理，属性，启动程序，执行器，JPA，JDBC等。

## 什么是Spring Boot

Spring Boot是一个构建在Spring框架顶部的项目。它提供了一种简便，快捷的方式来设置，配置和运行基于Web的简单应用程序。

它是一个Spring模块，提供了 **RAD(快速应用程序开发)**功能。它用于创建独立的基于Spring的应用程序，因为它需要最少的Spring配置，因此可以运行。

![什么是Spring Boot](https://www.cainiaojc.com/static/upload/210423/1629261.png)

简而言之，Spring Boot是 **Spring Framework** 和 **嵌入式服务器**的组合。

在Spring Boot不需要XML配置(部署描述符)。它使用约定优于配置软件设计范例，这意味着可以减少开发人员的工作量。

我们可以使用Spring **STS IDE** 或 **Spring Initializr** 进行开发Spring Boot Java应用程序。

**为什么要使用Spring Boot Framework？**

我们应该使用Spring Boot Framework，因为:

Spring Boot中使用了依赖项注入方法。它包含强大的数据库事务管理功能。它简化了与其他Java框架(如JPA/Hibernate ORM，Struts等)的集成。它减少了应用程序的成本和开发时间。

与Spring Boot框架一起，其他许多Spring姐妹项目也有助于构建满足现代业务需求的应用程序。 Spring姐妹项目如下:

**Spring Data:** 它简化了来自关系数据库和 **NoSQL** 数据库的数据访问。**Spring Batch:** 它提供了强大的**批处理**处理。**Spring Security:** 这是一个安全框架，可为应用程序提供强大的**安全性**。**Spring Social:** 它支持与LinkedIn等**社交网络**集成。**Spring Integration:** 它是企业集成模式的实现。使用轻量级消息传递和声明性适配器，它有助于与其他**企业应用程序**集成。

## Spring Boot的优点

它创建**独立** Spring应用程序，这些应用程序可以使用Java **-jar** 启动。借助不同的**嵌入式** HTTP服务器(例如 **Tomcat，Jetty** 等)，它可以轻松测试Web应用程序。我们不需要部署WAR文件。它提供了有用的' **starter** 'POM，以简化我们的Maven配置。它提供了**production-ready**功能，例如**metrics, health checks**和**externalized configuration.**。不需要 **XML** 配置。它提供了一个用于开发和测试Spring Boot应用程序的 **CLI** 工具。它提供了许多**插件**。它还最大限度地减少了编写多个**样板代码**(必须在几乎没有任何改动的情况下将其包含在许多地方)，XML配置和注释的情况。它**提高生产力**并减少开发时间。

## Spring Boot的限制

Spring Boot可以使用应用程序中不会使用的依赖项。这些依赖性增加了应用程序的大小。

## Spring Boot的目标

Spring Boot的主要目标是减少 **开发，单元测试**和 **集成测试**时间。

提供有目的的开发方法避免定义更多的注释配置避免编写大量导入语句避免XML配置。

通过提供或避免上述几点，Spring Boot Framework减少了 **开发时间，开发人员工作量**并 **提高了生产力**。

## Spring Boot的先决条件

要创建Spring Boot应用程序，必须满足以下先决条件。在本教程中，我们将使用 **Spring Tool Suite** (STS)IDE。

Java 1.8Maven 3.0 +Spring Framework 5.0.0.BUILD-SNAPSHOT建议使用IDE(Spring工具套件)。

## Spring Boot功能

Web开发SpringApplication应用程序事件和侦听器应用管理外部配置属性文件YAML支持类型安全配置日志安全性

**Web开发**

这是用于Web应用程序开发的非常适合的Spring模块。我们可以轻松创建一个独立的HTTP应用程序，该应用程序使用 **Tomcat，Jetty** 或Undertow等嵌入式服务器。我们可以使用 **spring-boot-starter-web** 模块快速启动和运行应用程序。

**SpringApplication**

SpringApplication是一个类，提供了一种方便的方式来引导Spring应用程序。可以从main方法开始。我们可以仅通过调用静态run()方法来调用应用程序。

示例

```java
public static void main(String[] args)
{  
    SpringApplication.run(ClassName.class, args);  
}
```

**应用程序事件和侦听器**

Spring Boot使用事件来处理各种任务。它允许我们创建用于添加侦听器的工厂文件。我们可以使用 **ApplicationListener键**来引用它。

总是在META-INF文件夹中创建工厂文件，例如 **META-INF/spring.factories** 。

**应用管理**

Spring Boot提供了为应用程序启用与管理员相关的功能的功能。它用于远程访问和管理应用程序。我们可以使用 **spring.application.admin.enabled** 属性在Spring Boot应用程序中启用它。

**外部配置**

Spring Boot允许我们外部化我们的配置，以便我们可以在不同环境中使用同一应用程序。该应用程序使用YAML文件来外部化配置。

**属性文件**

Spring Boot提供了一组丰富的 **应用程序属性**。因此，我们可以在项目的属性文件中使用它。该属性文件用于设置诸如 **server-port = 8082** 等属性。它有助于组织应用程序属性。

**YAML支持**

它提供了一种方便的方法来指定层次结构。它是JSON的超集。 SpringApplication类自动支持YAML。它是属性文件的代替方法。

**类型安全配置**

强大的类型安全配置用于管理和验证应用程序的配置。应用程序配置始终是至关重要的任务，应该是类型安全的。我们还可以使用此库提供的注释。

**日志**

Spring Boot对所有内部记录都使用通用记录。默认情况下管理日志记录依赖项。如果不需要自定义，我们不应更改日志记录依赖项。

**安全性**

Spring Boot应用程序是spring的Web应用程序。因此，默认情况下，通过所有HTTP端点上的基本身份验证，它是安全的。可以使用一组丰富的端点来开发安全的Spring Boot应用程序。

# SpringBoot 介绍

Spring Boot是用于创建微服务的基于Java的开源框架。它是由Pivotal Team开发的，用于构建独立的和生产就绪的弹簧应用程序。本章将向您介绍Spring Boot，并使您熟悉其基本概念。

## Spring与Spring Boot对比

**Spring:** Spring框架是最流行的Java应用程序开发框架。 Spring框架的主要功能是**依赖注入**或**控制反转**(IoC)。借助Spring Framework，我们可以开发一个**松耦合**的应用程序。如果纯粹定义应用程序类型或特征，最好使用。

**SpringBoot:** Spring Boot是Spring Framework的模块。它允许我们构建具有最少配置或零配置的独立应用程序。如果我们要开发一个简单的基于Spring的应用程序或RESTful服务，最好使用它。

Spring和Spring Boot之间的主要比较讨论如下:

| Spring                                                       | Spring Boot                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| **Spring Framework**是用于构建应用程序的广泛使用的Java EE框架。 | **SpringBoot Framework** 被广泛用于开发 **REST API** 。      |
| 它旨在简化Java EE开发，从而使开发人员更加高效。              | 它旨在缩短代码长度，并提供开发 **Web应用程序**的最简单方法。 |
| Spring Framework的主要功能是**依赖注入**。                   | Spring Boot的主要功能是**自动配置**。它会根据需求自动配置类。 |
| 通过允许我们开发**松耦合**应用程序，可以使事情变得更简单。   | 它有助于创建配置更少的**独立**应用。                         |
| 开发人员编写了大量代码(**模板代码**)来完成最小的任务。       | 它**减少**样板代码。                                         |
| 要测试Spring项目，我们需要显式设置服务器。                   | SpringBoot提供了**嵌入式服务器**，例如 **Jetty** 和 **Tomcat** 等。 |
| 它不支持内存数据库。                                         | 它提供了多个插件来处理嵌入式和**内存中**数据库，例如 **H2** 。 |
| 开发人员在 **pom.xml** 中为Spring项目手动定义依赖项。        | Spring Boot在pom.xml文件中带有 **starter** 概念，该概念内部负责根据Spring Boot要求下载依赖项 **JAR** 。 |

## Spring Boot与Spring MVC

**Spring Boot:** SpringBoot使得快速引导和开始开发基于Spring的过程变得容易。应用。它避免了很多样板代码。它隐藏了很多复杂的信息，因此开发人员可以快速入门并轻松开发基于Spring的应用程序。

**Spring MVC:** Spring MVC是用于以下方面的Web MVC框架: 构建Web应用程序。它包含许多用于各种功能的配置文件。这是一个面向HTTP的Web应用程序开发框架。

Spring Boot和Spring MVC出于不同的目的而存在。下面讨论了Spring Boot和Spring MVC之间的主要比较:

| SpringBoot                                                   | SpringMVC                                                 |
| ------------------------------------------------------------ | --------------------------------------------------------- |
| **SpringBoot** 是Spring的模块，用于使用合理的默认值打包基于Spring的应用程序。 | **SpringMVC** 是Spring框架下基于模型视图控制器的Web框架。 |
| 它提供了用于构建 **Spring-powered** 框架的默认配置。         | 它提供了**易于使用**功能来构建Web应用程序。               |
| 无需手动构建配置。                                           | 它需要手动进行构建配置。                                  |
| **不需要**部署描述符。                                       | **必需**。                                                |
| 它避免了样板代码，并将依赖项包装在一个单元中。               | 它分别指定每个依赖项。                                    |
| 它**减少**开发时间并提高生产率。                             | 要花费相同的时间，要花费**更多**。                        |

------

## Spring Boot体系结构

SpringBoot是Spring框架的模块。它用于轻松创建独立的生产级基于Spring的应用程序。它是在核心Spring框架的顶部开发的。

SpringBoot遵循一个分层的体系结构，其中每一层都与它的直接下层或上层(层次结构)进行通信。

之前了解 **SpringBoot Architecture** 后，我们必须了解其中的不同层和类。 SpringBoot中有**四个**层，如下所示:

**展示层****业务层****持久层****数据库层**![Spring Boot Architecture](https://www.cainiaojc.com/static/upload/210423/1633000.png)

**展示层:** 表示层负责处理HTTP请求，将JSON参数转换为对象，并对请求进行身份验证并将其传输到业务层。简而言之，它由**视图**即前端部分组成。

**业务层:** 业务层处理所有**业务逻辑** >。它由服务类组成，并使用数据访问层提供的服务。它还执行**授权**和**验证**。

**持久层:** 持久层包含所有**存储逻辑**，并将业务对象与数据库行进行相互转换。

**数据库层:** 在数据库层中， **CRUD** (创建，检索，更新，

## Spring Boot Flow Architecture

![Spring启动架构](https://www.cainiaojc.com/static/upload/210423/1633001.png)现在我们有验证器类，视图类和实用程序类。Spring Boot使用类似于Spring MVC，Spring Data等的所有模块。SpringBoot的体系结构与Spring MVC的体系结构相同，不同之处在于: 不需要 **DAO** 和 **DAOImpl** 类在Spring启动中。创建数据访问层并执行CRUD操作。客户端发出HTTP请求(PUT或GET)。请求发送到控制器，然后控制器映射该请求并进行处理。之后，如果需要，它将调用服务逻辑。在服务层中，所有业务逻辑都将执行。它对通过类映射到JPA的数据执行逻辑。如果没有发生错误，则会将JSP页面返回给用户。

# Springboot Initializr

**Spring Initializr** 是Pivotal Web服务提供的 **基于网络的工具**。借助 **Spring Initializr** ，我们可以轻松生成 **Spring Boot Project** 的结构。它提供了用于创建基于JVM的项目的可扩展API。

它还为项目提供了以元数据模型表示的各种选项。元数据模型使我们能够配置JVM和平台版本等支持的依赖项列表。它以众所周知的方式提供元数据，从而为第三方客户端提供必要的帮助。

## Spring Initializr模块

Spring Initializr具有以下模块:

**initializr-actuator:** : 它提供有关项目生成的其他信息和统计信息。这是一个可选模块。

**initializr-bom:** : 在此模块中， **BOM** 代表**物料清单**。在Spring Boot中，BOM是一种特殊的 **POM** ，用于控制项目**依赖项**的**版本**。它提供了一个中心位置来定义和更新这些版本。它提供了灵活性，可以在我们的模块中添加依赖项而无需担心版本。
在软件世界之外， **BOM** 是创建产品所需的零件，项目，组件和其他材料的列表。它说明了**如何，如何**和**在何处**收集所需材料。

**initializr-docs:** : 它提供了文档。

**initializr-generator:** : 这是一个核心项目生成库。

**initializr-generator-spring:**

**initializr-generator-test:** : 它提供了用于项目生成的测试基础结构。

**initializr-metadata:** : 它为项目的各个方面提供了元数据基础结构。

**initializr-service-example** : 它提供自定义实例。

**initializr-version-resolver:** 是一个可选模块，用于从任意POM中提取版本号。

**initializr-web** : 它为第三方客户端提供Web端点。

## 支持的界面

它支持 **IDE STS，IntelliJ IDEA Ultimate，NetBeans，Eclipse** 。您可以从 https://github.com/AlexFalappa/nb-springboot 。如果您使用的是VSCode，请从 https://github.com/下载插件microsoft/vscode-spring-initializr 。使用自定义Web UI http://start.spring.io 或 https://start-scs.cfapps.io 。它还支持 **Spring Boot CLI** 或 **cURL** 或 **HTTPie** 的命令行。

下图显示了Spring Initializr UI:

![Spring Initializer](https://www.cainiaojc.com/static/upload/210423/1633360.png)

## 生成项目

在创建项目之前，我们必须对UI友好。 Spring Initializr UI具有以下标签:

**Project:** 它定义项目的**种类**。我们可以创建 **Maven项目**或 **Gradle项目**。在整个教程中，我们将创建一个 **Maven项目**。

**Language:** : Spring Initializr提供了三种语言 **Java，Kotlin，**和 **Groovy** 的选择。默认情况下，选择Java。

**Spring Boot:** : 我们可以选择Spring Boot **版本**。最新版本为 **2.2.2** 。

**Project Metadata:** : 它包含与项目相关的信息，例如 **Group** ，Artifact等。Group表示 **package** 名称； **工件**表示**应用**名称。默认的组名称为 **com.example** ，默认的工件名称为**演示**。

**Dependencies:** 依赖性是可以添加到项目中的工件的集合。

还有另一个 **Options** 部分，其中包含以下字段:

**Name:** 与**工件**相同。

**Description:** 在描述字段中，我们可以编写项目的**描述**。

**Package Name:** 它也与**组**名称相似。

**Packaging:** 我们可以选择项目的**包装**。我们可以选择 **Jar** 或 **War** 。

**Java** : 我们可以选择要使用的 **JVM** 版本。在整个教程中，我们将使用 **Java 8** 版本。

有一个 **生成**按钮。当我们单击按钮时，它开始打包项目并下载您选择的 **Jar** 或 **War** 文件。

# Springboot 下载安装

## Spring Tool Suite(STS)IDE

Spring Tool Suite是用于开发Spring应用程序的IDE。它是基于Eclipse的开发环境。它提供了一个现成的环境来实施，运行，部署和调试应用程序。它可以验证我们的应用程序并为应用程序提供快速修复。

### 安装STS

**步骤1:** 从下载Spring Tool Suite href ="https://spring.io/tools3/sts/all" rel ="nofollow" target ="_blank"> https://spring.io/tools3/sts/all 。单击您正在使用的平台。在本教程中，我们使用Windows平台。

![下载并安装STS IDE](https://www.cainiaojc.com/static/upload/210424/0344220.png)

**步骤2:** 提取 **zip** 文件并安装STS。

sts-bundle-> sts-3.9.9.RELEASE-> Double -单击 **STS.exe** 。

![下载并安装STS IDE](https://www.cainiaojc.com/static/upload/210424/0344221.png)

**第3步:** " Spring Tool Suite 3启动器"对话框出现在屏幕上。点击 **启动**按钮。您可以根据需要更改工作区。

![下载并安装STS IDE](https://www.cainiaojc.com/static/upload/210424/0344222.png)

**步骤4:** 它开始启动STS。

![下载并安装STS IDE](https://www.cainiaojc.com/static/upload/210424/0344223.png)

STS用户界面如下:

![下载并安装STS IDE](https://www.cainiaojc.com/static/upload/210424/0344224.png)

# SpringBoot 项目创建

以下是创建简单Spring Boot项目的步骤。

**步骤1:** 打开Spring initializr https://start.spring.io 。

**步骤2:** 提供 **组**和 **工件**名称。我们提供了组名 **com.nhooo** 和工件 **spring-boot-example** 。

**步骤3:** 现在，点击 **Generate** (生成)。

![创建Spring Boot项目](https://www.cainiaojc.com/static/upload/210424/0345150.png)

何时我们单击"生成"按钮，它将开始将项目打包为 **.rar** 文件并下载该项目。

**步骤4:** 提取 **RAR** 文件。

**步骤5:** **导入**文件夹。

文件->导入->现有Maven项目->下一步->浏览->选择项目->完成

导入需要一些时间该项目。成功导入项目后，我们可以在 **Package Explorer** 中查看项目目录。下图显示了项目目录:

![正在创建Spring Boot项目](https://www.cainiaojc.com/static/upload/210424/0345151.png)

**SpringBootExampleApplication .java**

示例

```java
package com.nhooo.springbootexample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootExampleApplication.class, args);
}
}
```

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.2.BUILD-SNAPSHOT</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
<groupId>com.nhooo</groupId>
<artifactId>spring-boot-example</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>spring-boot-example</name>
<description>Demo project for Spring Boot</description>
<properties>
<java.version>1.8</java.version>
</properties>
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
<exclusions>
<exclusion>
<groupId>org.junit.vintage</groupId>
<artifactId>junit-vintage-engine</artifactId>
</exclusion>
</exclusions>
</dependency>
</dependencies>
<build>
<plugins>
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
</plugins>
</build>
<repositories>
<repository>
<id>spring-milestones</id>
<name>Spring Milestones</name>
<url>https://repo.spring.io/milestone</url>
</repository>
<repository>
<id>spring-snapshots</id>
<name>Spring Snapshots</name>
<url>https://repo.spring.io/snapshot</url>
<snapshots>
<enabled>true</enabled>
</snapshots>
</repository>
</repositories>
<pluginRepositories>
<pluginRepository>
<id>spring-milestones</id>
<name>Spring Milestones</name>
<url>https://repo.spring.io/milestone</url>
</pluginRepository>
<pluginRepository>
<id>spring-snapshots</id>
<name>Spring Snapshots</name>
<url>https://repo.spring.io/snapshot</url>
<snapshots>
<enabled>true</enabled>
</snapshots>
</pluginRepository>
</pluginRepositories>
</project>
```

**步骤6:** : 运行 **SpringBootExampleApplication.java** 文件。

右键单击该文件->运行方式-> Java应用程序

![正在创建Spring Boot项目](https://www.cainiaojc.com/static/upload/210424/0345152.png)

下图显示了应用程序已成功运行。

![创建Spring Boot项目](https://www.cainiaojc.com/static/upload/210424/0345153.png)

------

[使用SpringBoot CLI创建SpringBoot项目](https://www.cainiaojc.com/springboot/springboot-cli.html)[使用STS创建SpringBoot项目](https://www.cainiaojc.com/springboot/springboot-project-using-sts.html)

# SpringBoot整合SpringMvc实现第一个api接口

## 什么是api

我们经常能在互联网ai圈中看到所谓“申请api”的说法，那么究竟什么是api呢？

api，即应用程序编程接口（Application Programming Interface, API） ，也称应用编程接口，是一组为不同软件组件之间交互而创建的定义和[协议](https://baike.baidu.com/item/协议/670528?fromModule=lemma_inlink)，定义了软件模块之间如何相互交互，包括可以调用哪些功能、如何调用、需要提供的数据格式，以及返回结果的形式。通过API，开发者可以复用现有能力，而无需了解或修改底层实现细节。

它扮演着软件组件之间沟通桥梁的角色，与旨在连接人与计算机的用户界面（UI）不同，API旨在连接计算机程序或软件模块。

API本身是抽象的，它仅定义功能的调用方式（即接口），而不涉及功能的具体实现。例如，一个图形库的API会定义如何调用‘在屏幕上绘制一条直线’的函数，但不会暴露其底层代码是如何在屏幕上逐像素渲染的。应用程序在开发时只需链接到这组API，在运行时便可调用其实现库来完成相应功能。其核心目的之一是隐藏系统工作的内部细节，仅暴露对开发者有用的部分，并保持接口的稳定性，即使内部实现更新，调用方代码也无需更改。

总的来说，API 就是一套规则、协议和工具，精确定义了软件组件之间该如何通信（请求什么、怎么请求、返回什么格式），从而成为连接不同软件模块的桥梁——它只定义“怎么调用”，隐藏“怎么实现”，并保持接口稳定以便复用。

最后话说回来，在 AI 圈常说的“申请 API”，通常指去某个平台（如 OpenAI、Anthropic、国内大模型厂商等）注册账号、获取一串密钥（API Key / Token），从而获得调用该模型接口的权限和额度。有了这串密钥，你的程序就能通过 API 向对方的服务器发请求、拿回模型的回答。

### 发展历史

API的概念雏形可以追溯到20世纪50—60年代出现的子程序库和[操作系统](https://baike.baidu.com/item/操作系统/192?fromModule=lemma_inlink)调用。API这一术语在20世纪60年代末到70年代逐渐被广泛使用。早期的API主要是操作系统提供给应用程序的底层调用，用于进行文件管理、内存分配等操作。随着桌面操作系统和图形界面平台的成熟，软件库和框架的API变得愈发重要，例如微软发布的Windows API，它统一了Windows平台下应用程序的开发规范 。

进入21世纪，随着互联网的飞速发展，Web API成为API领域一个关键的发展方向，并逐渐成为主流。Web API允许不同计算机系统通过互联网进行通信和数据交换，极大地促进了分布式系统和微服务的流行，成为现代云计算、移动应用和物联网生态系统的技术基石。

### 基本原理与目的

API的核心原理是封装和抽象。它将复杂的功能逻辑或系统资源封装起来，通过一组定义良好、相对简单的接口暴露给外部。这带来了几个主要目的：

- 模块化与解耦： API允许将复杂的软件系统划分为独立的、可复用的模块。各模块通过API进行通信，降低了彼此的耦合度，便于独立开发、测试、部署和维护。
- 简化开发： 开发者可以直接调用成熟的API来实现复杂功能（如地图服务、在线支付），而无需从零开始，极大地提高了开发效率和软件质量。
- 控制与安全： API的提供方可以精确控制哪些功能或数据可以被外部访问，以及访问的权限和频率，从而保障底层系统的安全性和稳定性。
- 互操作性： 基于行业标准设计的API可以确保不同开发者、不同公司的软件系统之间能够顺畅地协同工作，构建起庞大的技术生态。

以动态链接库（DLL）为例，在Windows操作系统中，许多API以DLL文件的形式提供。DLL中包含可供应用程序调用的函数，程序运行时由系统将其动态链接或按需加载。这样，无论多少程序调用同一功能，磁盘上通常只需一份DLL文件；这样，多个应用程序可以共享内存中同一份API代码的只读副本，从而节约系统资源；同时，每个应用程序又拥有独立的数据空间，保证了运行的隔离性与安全。

### 主要分类

根据应用范围和技术实现，API可大致分为以下几类：

- 操作系统API： 由操作系统提供，用于管理硬件和系统资源，如Windows API、以及符合POSIX标准的API（常见于Linux、macOS等类Unix系统）。它们是编写桌面与服务器应用程序的基础。
- 程序库与框架API： 由特定的软件库或开发框架提供，用于实现特定功能，如用于图形渲染的DirectX API、用于数据库访问的JDBC API等。
- Web API： 通过网络协议在不同系统间传输与交换数据，是目前最主流的API形式。这类API通常基于网络协议（如HTTP/S、WebSocket）进行通信，并遵循特定的架构风格或规范，例如REST、SOAP、GraphQL和gRPC。例如，Google地图API允许开发者在自己的网站或应用中嵌入地图功能。

### 相关术语

为便于理解API在软件工程体系中的位置，常见相关术语包括：

- 接口（Interface）：广义的“接口”是模块之间的边界约定。API是“供程序调用的接口”的具体实例。
- 端点（Endpoint）：在Web API或微服务环境下，端点指可被调用的具体入口，通常由特定URL与HTTP方法共同定义，并结合请求头、路径参数与查询参数等决定实际行为，例如 GET /v1/users/{id}。在流式或双工协议（如WebSocket、gRPC）中，端点不总是仅以“URL+方法”表示。
- SDK（Software Development Kit，软件开发工具包）：SDK通常包含某个API的客户端库、示例代码、调试工具和文档，帮助开发者方便、正确、快速地调用该API。API是“规范”，SDK是“拿来即用的工具箱”。
- UI（User Interface，用户界面）：UI面向人类用户，强调交互体验；API面向程序，强调协议一致性和行为可预测性。两者都属于“接口”，但服务对象不同。
- 版本化（Versioning）与向后兼容性：向后兼容性是指：当API的实现升级后，原有调用方式依旧可以正常工作。常见做法是通过显式版本号（如v1、v2）并行维护多个接口，并配合弃用公告与迁移窗口，逐步引导调用方迁移。

## 实现接口

网页链接格式：localhost:port/context-path/index （其中index为@RequestMapping（）函数中的实参）

### hello实例

首个hello:

![image-20260908133218179](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908133218179.png)

打开浏览器，现在默认的端口是8080，输入localhost:8080：

![image-20260908133354588](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908133354588.png)

报404，因为没有对应匹配的方法

加上hello前缀：

![image-20260908133510167](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908133510167.png)



**增加前缀**

项目结构：

![image-20260908130312224](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908130312224.png)

TestApplication.java文件

```java
package cn.test.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/ind")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
        @RequestMapping("/hello")
        public String hello(){
            return "hello";
        }
}
```

application.yml文件

```java
spring:
  application:
    name: test
server:
  servlet:
    context-path: /api
  port: 90	
```

运行页面结果：

![image-20260908144200944](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908144200944.png)

可以看到，访问路径为localhost:90/api/ind/hello，即localhost:port/context-path/前缀/方法名（这里port=90，context-path为api，前缀设置为ind，方法名为hello）

# SpringBootMVC实现Restfulapi请求方法

请求类型：

![image-20260908144714380](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908144714380.png)

直接用浏览器输入框输入网址默认发生get请求。

传统请求方式：使用文号和拼接符拼接，例如：

![image-20260908145010066](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908145010066.png)

使用restful风格传递参数，直接放入参数值，不写参数名称，多个参数使用多个反斜杠（/）隔开。

## **GET无参请求api方法**

```java
package cn.test.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/ind")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
    @GetMapping
    public String index() {
        return "GET无参请求api方法已实现";
    }
}
```

**页面：**

![image-20260908165113949](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908165113949.png)



## GET Restful请求传值的方法

```java
@GetMapping("/{id}")
public String index(@PathVariable Long id){
    System.out.println("ID="+id);	//在编译器终端打印
    return "GET Restful请求传值的方法已实现成功";	//显示在网页上
}
```

**页面：**

![image-20260908165509816](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908165509816.png)

（注：此次11111为传入的参数）

## 普通带参数请求

```java
// 普通带参数请求：用 @RequestParam 接收 ?id=114&name=xxx（第一个参数用？第二个参数用连接符&）
@GetMapping
public String index2(@RequestParam Long id, @RequestParam String name){
    System.out.printf("ID=%s,name=%s\n",id,name);
    return "普通请求已实现，id=" + id + ", name=" + name;
}
```

**页面：**

![image-20260908165915159](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908165915159.png)

## post请求

post请求一般不需要上传参数，直接传递请求体，也就是表单数据。

前后端分离项目基本上是使用jason数据进行传递，但是我们的浏览器是没办法直接发送post请求，需自行下载接口调试工具（如apifox或postman）

```java
@PostMapping
public String save(@RequestBody Map<String,String> map){
    System.out.println(map.toString());
    return "post请求接受成功";
}
```

重启项目后打开apifox：

![image-20260908173946623](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908173946623.png)

可看到终端正常打印：

![image-20260908174107115](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908174107115.png)

## put请求

put请求一般是携带restful风格的参数和上面的请求体。

```java
@PutMapping("/{id}")
public String updata(@PathVariable Long id,@RequestBody Map<String,String>map){
    System.out.printf("ID=%s,name=%s\n",id,map);
    return "put请求接受成功";
}
```

修改路径：

![image-20260908175102117](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908175102117.png)

终端成功输出：

![image-20260908175127606](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908175127606.png)

## delete请求

```java
@DeleteMapping("/{id}")
public String delete(@PathVariable Long id){
    System.out.printf("ID=%s\n",id);
    return "delete请求接收成功";
}
```

apifox:

![image-20260908175634840](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908175634840.png)

终端成功打印ID:

![image-20260908175710433](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908175710433.png)

以上就是spring mvc的基本用法。

# Springboot多环境配置和修改项目启动时的水印

springboot启动时会打印spring的水印（如图所示，使用字符串拼接而成）

![image-20260908193425492](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908193425492.png)

市面上有很多生成水印的网站，生成后在项目resource下面创建banner.txt文件，复制黏贴水印的值，启动项目后即可使用。

**实例**

![image-20260908200515026](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908200515026.png)

## 多环境配置

在上线项目时，端口或前缀会和实际开发不一致，springboot提供了一种可以不用直接修改yml文件的方式，即多环境配置，通过在工作区中存在两份或多份yml文件副本，本体文件中选择特定副本的方式指定多种环境配置。

![image-20260908203522994](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260908203522994.png)

application.yml文件：

```java
spring:
  profiles:
    active: prod	//这里active:后面一定要有一个空格.直接写入副本文件杆-后面的内容
```

application-dev.yml文件：

```java
spring:
  application:
    name: test
server:
  servlet:
    context-path: /api
  port: 8080	//端口设置为8080
```

application-prod.yml文件：

```java
spring:
  application:
    name: test
server:
  servlet:
    context-path: /api
  port: 9090
```

在网页上运行可发现，通过修改application.yml文件中active后面的内容，自由选择你需要的环境配置。

补充：在上述例子中，我们不难发现，修改端口port后网页会显示拒绝连接。

以下是几种常见的网页异常状态：

| 现象                | 含义                           | 比喻                         |
| ------------------- | ------------------------------ | ---------------------------- |
| 拒绝连接（refused） | 端口上没有程序在监听           | 打电话过去，没人接           |
| 超时（TIMEOUT)      | 请求发出去了，但一直没回应     | 电话打通了但没人应答         |
| 404                 | 服务有，但没有这个路径         | 电话有人接了，但你找错地方了 |
| 500（白标）         | 服务有、路径有，但代码处理出错 | 电话接了，但对方操作失误     |

HTTP 状态码

HTTP 状态码是用以表示网页服务器超文本传输协议响应状态的3位数字代码，分为五大类：信息响应、成功响应、重定向、客户端错误和服务器错误。

**常见状态码分类：**

- **1xx 信息响应** ：表示请求已接收，需继续处理。

**100 Continue**：客户端应继续发送请求。

- **2xx 成功响应** 表示请求成功。

**200 OK**：请求成功，常用于 GET 和 POST 请求。

**201 Created**：资源已成功创建。

- **3xx 重定向** 表示需要进一步操作完成请求。

**301 Moved Permanently**：资源永久移动到新地址。

**302 Found**：资源临时移动。

- **4xx 客户端错误** 表示请求有误。

**400 Bad Request**：请求语法错误。

**401 Unauthorized**：需要身份验证。

**404 Not Found**：资源未找到。

- **5xx 服务器错误** 表示服务器无法处理请求。

**500 Internal Server Error**：服务器内部错误。

**503 Service Unavailable**：服务器暂时不可用。



三层架构的概念：前端的请求进入后端后通过这三层代码处理。

![image-20260909212707759](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260909212707759.png)

**数据库的安装**

数据库分为关系型数据库与非关系型数据库。关系型数据库使用表格的形式存储，非关系型数据库则使用key:value的方式存储。

安装mySQL,Redis,Navicat。

# SpringBoot整合Mybatis-Plus

下面，我们将通过一个简单的 Demo 来阐述 MyBatis-Plus 的强大功能。

用一个 User 表跑通单表 CRUD。六步：建库建表 → 加依赖 → 写配置 → 编码 → 跑测试 → 排错。

环境：JDK 21+ / Spring Boot 3.3.6 / MyBatis-Plus 3.5.17 / MySQL 8 / Navicat。

现有一张 User 表，其表结构如下：

| id   | name   | age  | email                                           |
| ---- | ------ | ---- | ----------------------------------------------- |
| 1    | Jone   | 18   | [test1@baomidou.com](mailto:test1@baomidou.com) |
| 2    | Jack   | 20   | [test2@baomidou.com](mailto:test2@baomidou.com) |
| 3    | Tom    | 28   | [test3@baomidou.com](mailto:test3@baomidou.com) |
| 4    | Sandy  | 21   | [test4@baomidou.com](mailto:test4@baomidou.com) |
| 5    | Billie | 24   | [test5@baomidou.com](mailto:test5@baomidou.com) |

------

## 一、建库建表

### 1.1 用 Navicat 连上 MySQL

打开 Navicat → 点左上角「连接」→ 选 **MySQL**，按下表填：

| 项     | 填什么                  |
| :----- | :---------------------- |
| 连接名 | `local`（随便起）       |
| 主机   | `localhost`             |
| 端口   | `3306`                  |
| 用户名 | `root`                  |
| 密码   | 你安装 MySQL 时设的密码 |

点「测试连接」，出现「连接成功」后点确定。

**连不上时对照报错**

**`2059 - Authentication plugin 'caching_sha2_password' cannot be loaded`**：Navicat 版本太老，换 Navicat 15 以上。 **`Access denied for user 'root'@'localhost'`**：密码填错了。 **`Can't connect to MySQL server on 'localhost' (10061)`**：MySQL 服务没启动，去「服务」里启动 `MySQL80`。

### 1.2 新建数据库

右键刚建的连接 →「新建数据库」：

| 字段     | 值                   |
| :------- | :------------------- |
| 数据库名 | `quickstart`         |
| 字符集   | `utf8mb4`            |
| 排序规则 | `utf8mb4_general_ci` |

字符集一定选 `utf8mb4`。默认值有时会落到 `latin1`，中文写进去会变 `???`。

> **数据库必须先建好再启动程序。**程序不会帮你建库，库不存在的话启动阶段就抛 `Unknown database 'quickstart'`，连起步都完不成。

### 1.3 建表脚本

双击 `quickstart` 让它成为当前库，然后点工具栏「查询」→「新建查询」，粘贴下面这段，点「运行」（`Ctrl+R`）。点击运行后，如果下方显示「受影响的行: 0」，说明建表成功。

```
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    id BIGINT NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);
```

同样的内容也在项目里存一份，路径 `src/main/resources/db/schema.sql`。

### 1.4 插入数据

把查询窗口里的内容全选删掉，粘贴这段，再点「运行」。这次应显示「受影响的行: 5」。

```navicat
DELETE FROM `user`;

INSERT INTO `user` (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```

复制

同步存一份到项目里：`src/main/resources/db/data.sql`。

> 第一行 `DELETE FROM` 不能省。
> 这两个脚本会在**每次应用启动时重跑**（见 3.3 节的 `mode: always`）， MySQL 是持久化库，不先删一遍第二次启动就是主键冲突。
> 反过来说：这意味着每次启动数据都会被重置回这 5 行。教程阶段很方便， 但你往库里存了要保留的数据之后，就得把 `mode: always` 去掉。

### 1.5 确认

```
SELECT * FROM `user`;
```

返回 5 行就对了。再在左侧表列表上右键「刷新」，能看到 `user` 表。

------

## 二、添加依赖

### 2.1 pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.6</version>
        <relativePath/>
    </parent>

    <groupId>com.baomidou</groupId>
    <artifactId>quickstart</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <properties>
        <java.version>21</java.version>
        <lombok.version>1.18.42</lombok.version>
    </properties>

    <dependencies>
        <!-- Spring Boot 3 用 boot3-starter，别用 mybatis-plus-boot-starter -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-spring-boot3-starter</artifactId>
            <version>3.5.17</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- MySQL 驱动。新坐标是 com.mysql:mysql-connector-j -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.14.0</version>
                <configuration>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                    </annotationProcessorPaths>
                    <proc>full</proc>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

复制

### 2.2 三处不能改错的地方

**`mybatis-plus-spring-boot3-starter`** —— 坐标写错会拖进 `mybatis-spring:2.1.2`，那是给 Spring 5 用的，启动直接抛 `Invalid value type for attribute 'factoryBeanObjectType'`。想确认拖对没有：



```
mvn dependency:tree -Dincludes=org.mybatis:mybatis-spring
```

复制

输出里应该是 `mybatis-spring:jar:3.0.5`。

**`com.mysql:mysql-connector-j`** —— 老文档里的 `mysql:mysql-connector-java` 已退役，Maven 拉不下来。

**`lombok.version` + `maven-compiler-plugin` 那两段** —— JDK 23 起 javac 不再自动启用 classpath 上的注解处理器，Lombok 会**静默失效**：编译成功、没有任何警告，但你得到的是一个只有字段、没有 getter/setter 的空壳类。症状是编译时报 `找不到符号: 方法 setName(String)`。版本要 ≥ 1.18.38，并且 `annotationProcessorPaths` + `<proc>full</proc>` 两样都要写——升版本不配置、或配置了却没升版本，都照样失效。

> 不想碰这个坑，就把 `@Data` 去掉、手写 getter/setter + `toString()`， Lombok 的依赖和编译插件配置也可以一并删掉。

------

## 三、写配置

### 3.1 application.yml

放到 `src/main/resources/application.yml`：



```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/quickstart?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: 你的MySQL密码

  sql:
    init:
      mode: always
      schema-locations: classpath:db/schema.sql
      data-locations: classpath:db/data.sql

mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

复制

`log-impl` 那行把 SQL 打到控制台，学习阶段建议开着。

### 3.2 URL 里那几个参数

| 参数                           | 作用                                                         |
| :----------------------------- | :----------------------------------------------------------- |
| `serverTimezone=Asia/Shanghai` | 不写有时报 `The server time zone value '中国标准时间' is unrecognized` |
| `allowPublicKeyRetrieval=true` | 不写有时报 `Public Key Retrieval is not allowed`             |
| `useSSL=false`                 | 本地没配证书，关掉省一串 SSL 警告                            |
| `characterEncoding=utf8`       | 客户端编码，防止中文乱码                                     |

嫌长的话只写 `jdbc:mysql://localhost:3306/quickstart` 也能连上，但建议至少保留前两个。

`driver-class-name` 也可以整行删掉——Connector/J 8 会自动注册驱动，Spring Boot 能从 URL 推断出来。**不要写 `com.mysql.jdbc.Driver`**，那是 MySQL 5 时代的类名，虽然还能跑，但会打两条 deprecated 警告。

### 3.3 `mode: always` 这行必须写

`spring.sql.init.mode` 的默认值是 `embedded`，意思是「只有数据源是 H2、HSQLDB 这类嵌入式库时才执行初始化脚本」。

所以走 MySQL 时不写这行，脚本会被**悄悄跳过**：应用照常启动、Maven 报 `BUILD SUCCESS`、测试显示 0 失败 0 错误，但表根本没建，一查询才报 `Table 'quickstart.user' doesn't exist`。

这一行是整份配置里最容易漏、也最要命的。

------

## 四、编码

包名统一用 `com.baomidou.mybatisplus.samples.quickstart`。

### 4.1 实体类 entity/User.java



```
package com.baomidou.mybatisplus.samples.quickstart.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`user`")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```

复制

`@Data` 生成 getter/setter/`equals`/`hashCode`/`toString`，前提是 2.2 节那两处 Lombok 配置写对了。

`@TableName` 里的反引号保留着——MySQL 裸写 `user` 也能跑，但 H2 里 `user` 是保留字，去掉反引号会直接语法错误。留着两边通用。

### 4.2 Mapper 接口 mapper/UserMapper.java



```
package com.baomidou.mybatisplus.samples.quickstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;

public interface UserMapper extends BaseMapper<User> {

}
```

复制

一个空接口就够了。`BaseMapper<User>` 已经把单表 CRUD 全部提供好了：`selectList`、`selectById`、`insert`、`updateById`、`deleteById`……不用写 XML。

### 4.3 启动类 Application.java



```
package com.baomidou.mybatisplus.samples.quickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

复制

`@MapperScan` 里的包名必须和 Mapper 接口的实际位置一字不差，写错了启动时报「找不到 Mapper」。也可以给每个接口加 `@Mapper` 来代替，两处只用一种。

------

## 五、跑测试

### 5.1 测试类 SampleTest.java

```
package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
```

复制

两个注意点：

- 用 `org.junit.jupiter.api.Assertions`，**不要用 `org.junit.Assert`**。Spring Boot 3 的 `starter-test` 里只有 JUnit 5，JUnit 4 的 `Assert` 不在 classpath 上，会报 `程序包 org.junit 不存在`。
- 不要用 `try/catch` 把查询包起来。异常被吞掉后测试依然显示全绿，你就看不到「表不存在」这类问题了。

### 5.2 执行

```
mvn test
```

控制台应该出现：

```
----- selectAll method test ------
==>  Preparing: SELECT id,name,age,email FROM `user`
==> Parameters:
<==    Columns: id, name, age, email
<==        Row: 1, Jone, 18, test1@baomidou.com
<==        Row: 2, Jack, 20, test2@baomidou.com
<==        Row: 3, Tom, 28, test3@baomidou.com
<==        Row: 4, Sandy, 21, test4@baomidou.com
<==        Row: 5, Billie, 24, test5@baomidou.com
<==      Total: 5
User(id=1, name=Jone, age=18, email=test1@baomidou.com)
User(id=2, name=Jack, age=20, email=test2@baomidou.com)
User(id=3, name=Tom, age=28, email=test3@baomidou.com)
User(id=4, name=Sandy, age=21, email=test4@baomidou.com)
User(id=5, name=Billie, age=24, email=test5@baomidou.com)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

`==> Preparing:` 那行是 MyBatis-Plus 真正发出去的 SQL。字段是逐个列出来的（不是 `SELECT *`），表名带反引号（因为 `@TableName` 里有）。

### 5.3 确认连的是哪个库

`assertEquals(5, ...)` 只能说明「查到了 5 条」。想确认连的是真实的 MySQL，加一行诊断：

```
@Autowired
private DataSource dataSource;

@Test
public void testSelect() {
    System.out.println("[诊断] 实际连接的 JDBC URL = "
            + ((HikariDataSource) dataSource).getJdbcUrl());
    // ... 其余不变
}
```

输出应该是：

```java
[诊断] 实际连接的 JDBC URL = jdbc:mysql://localhost:3306/quickstart
```

最直观的验证还是回 Navicat：右键 `quickstart` →「刷新」，再 `SELECT * FROM user`。测试里看到的 5 行和这里看到的是同一批数据。

------

## 六、排错对照

| 报错                                                       | 原因                          | 怎么改                                                  |
| :--------------------------------------------------------- | :---------------------------- | :------------------------------------------------------ |
| `Unknown database 'quickstart'`                            | 库没建                        | 按 1.2 节建库                                           |
| `Table 'quickstart.user' doesn't exist`                    | 少了 `mode: always`           | 按 3.3 节补上                                           |
| `Access denied for user 'root'@'localhost'`                | 密码不对                      | 改 `password`                                           |
| `Public Key Retrieval is not allowed`                      | URL 缺参数                    | 加 `allowPublicKeyRetrieval=true`                       |
| `The server time zone value ... is unrecognized`           | URL 缺参数                    | 加 `serverTimezone=Asia/Shanghai`                       |
| 中文显示成 `???`                                           | 字符集不是 `utf8mb4`          | 库、表、连接三层都确认                                  |
| 第二次启动报主键冲突                                       | `data.sql` 少了 `DELETE FROM` | 加回去                                                  |
| `程序包 org.junit 不存在`                                  | 用了 JUnit 4 的 `Assert`      | 换 `org.junit.jupiter.api.Assertions`                   |
| `找不到符号: 方法 setName(String)`                         | Lombok 被跳过                 | 按 2.2 节配 Lombok 版本和编译插件                       |
| `Invalid value type for attribute 'factoryBeanObjectType'` | starter 坐标选错              | 换成 `mybatis-plus-spring-boot3-starter`                |
| `Invalid bound statement (not found)`                      | 自定义方法没有对应 SQL        | 加 `@Select` 注解，或把 XML 放到 `resources/mapper/` 下 |
| Navicat 报 `2059 caching_sha2_password`                    |                               |                                                         |

## 继承

service框架

![image-20260915215412452](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260915215412452.png)

主代码

```java
@Test
public void testService(){
    List<User> userList =userService.list();
    userList.forEach(System.out::println);
}
```

UserService.java接口

```java
package cn.test.test.service;

import cn.test.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
}
```

UserServiceIpml.java类

```java
package cn.test.test.service.impl;
import cn.test.test.entity.User;
import cn.test.test.mapping.UserMapper;
import cn.test.test.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
```

## 增删改查api接口

UserController.java

```java
package cn.test.test.controller;

import cn.test.test.entity.User;
import cn.test.test.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.removeById(id);
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Object list() {
        return userService.list();
    }
}
```

## 分页接口

数据库里可能存在多条上万条记录，故使用分页的方式存储。

```java
@GetMapping("/page")
public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
    return Result.success(
            userService.page(new Page<>(pageNum, pageSize))
    );
}
```

实现

![image-20260916214951761](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260916214951761.png)

优质打印

![image-20260916215015054](C:\Users\1\AppData\Roaming\Typora\typora-user-images\image-20260916215015054.png)

这里可以看到，虽然设置pageNum=1,pageSize=2(每页展示两条数据)，但是系统把所有数据都传递过来了。

这是因为在mySQL中，要使用分页功能，需要往springboot容器中注入插件对象。

# MyBatis-Plus 分页插件配置与分页 API 实现教程

## 1. 分页插件配置

由于 MyBatis-Plus 3.5.16 版本中 `PaginationInnerInterceptor` 类不存在，使用自动配置方式：

**[application-dev.yml](cci:7://file:///C:/Users/1/.openclaw/workspace/test/src/main/resources/application-dev.yml:0:0-0:0) 配置：**
```yaml
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

**[MyBatisConfig.java](cci:7://file:///C:/Users/1/.openclaw/workspace/test/src/main/java/cn/test/test/config/MyBatisConfig.java:0:0-0:0) 配置：**
```java
package cn.test.test.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.test.test.mapping")
public class MyBatisConfig {
}
```

## 2. 分页 API 实现

**[UserController.java](cci:7://file:///C:/Users/1/.openclaw/workspace/test/src/main/java/cn/test/test/controller/UserController.java:0:0-0:0) 分页接口：**
```java
@GetMapping("/page")
public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum, 
                       @RequestParam(defaultValue = "10") Integer pageSize) {
    return Result.success(
        userService.page(new Page<>(pageNum, pageSize))
    );
}
```

## 3. 访问方式

启动应用后访问：
```
http://localhost:8080/api/user/page?pageNum=1&pageSize=10
```

## 4. 关键点

- **MyBatis-Plus 版本**：3.5.16 使用自动配置，无需手动配置分页拦截器
- **依赖**：`mybatis-plus-spring-boot3-starter` 已包含所需依赖
- **Service 层**：继承 `IService<User>`，使用内置的 `page()` 方法
- **返回结果**：使用 `Result` 包装分页结果，包含记录列表和分页信息

# MyBatis-Plus实现自动数据填充

数据库中存在一些字段，在更新或修改中需要自动填充数据，比如创建时间和更新时间，可在control方法中进行设置，不过mybatis也提供了自动填充的解决方案。

实体：

```java
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
```

填充处理器：

```java
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    public void insertFill(MetaObject m) {
        strictInsertFill(m, "createTime", LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(m, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
    public void updateFill(MetaObject m) {
        strictUpdateFill(m, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
```

`deleteById` 实际执行 `UPDATE ... SET deleted=1`，查询自动加 `WHERE deleted=0`。

# Redis 整合

### 1 依赖与配置

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

```yaml
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    password:
    database: 0
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 0
```

### 2 RedisTemplate 配置

默认的 `RedisTemplate<Object,Object>` 用 JDK 序列化，可读性差。改成 JSON：

```java
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> t = new RedisTemplate<>();
        t.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<>(Object.class);
        t.setKeySerializer(RedisSerializer.string());
        t.setHashKeySerializer(RedisSerializer.string());
        t.setValueSerializer(ser);
        t.setHashValueSerializer(ser);
        t.afterPropertiesSet();
        return t;
    }
}
```

### 3 基本使用

```java
@Autowired StringRedisTemplate stringRedisTemplate;
@Autowired RedisTemplate<String, Object> redisTemplate;

stringRedisTemplate.opsForValue().set("k", "v", 60, TimeUnit.SECONDS);
String v = stringRedisTemplate.opsForValue().get("k");

redisTemplate.opsForHash().put("user:1", "name", "tom");
```

### 4 注解缓存（简）

```java
@Cacheable(value = "user", key = "#id")
public User getById(Long id) { ... }

@CachePut(value = "user", key = "#user.id")
public User update(User user) { ... }

@CacheEvict(value = "user", key = "#id")
public void delete(Long id) { ... }
```

记得在启动类加 `@EnableCaching`。

---

# 认证授权：Sa-Token

> Sa-Token 是国产轻量级权限框架，特点是配置简单、注解丰富。
>
> [Sa-Token 官网 - Java 权限认证框架](https://sa-token.com/)
>
> [Sa-Token 框架介绍 - Sa-Token 官方文档 - 一站式 Java 权限认证框架](https://sa-token.com/readme.html)

### 1 依赖

```xml
<dependency>
    <groupId>cn.dev33</groupId>
    <artifactId>sa-token-spring-boot-starter</artifactId>
    <version>1.37.0</version>
</dependency>
<dependency>
    <groupId>cn.dev33</groupId>
    <artifactId>sa-token-redis-jackson</artifactId>
    <version>1.37.0</version>
</dependency>
```

### 2 配置

```yaml
sa-token:
  token-name: Authorization
  timeout: 2592000          # 30 天
  active-timeout: -1
  is-concurrent: true
  is-share: true
  token-style: uuid
  is-log: false
  is-read-cookie: false
  is-read-header: true
```

### 3 登录 / 注销

```java
@RestController
public class AuthController {

    @PostMapping("/login")
    public R<String> login(@RequestParam String name, @RequestParam String pwd) {
        // 校验账号密码（实际查 DB）
        if ("admin".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);             // 写入会话
            return R.ok(StpUtil.getTokenValue());
        }
        return R.fail("账号或密码错误");
    }

    @GetMapping("/logout")
    public R<Void> logout() {
        StpUtil.logout();
        return R.ok();
    }
}
```

### 4 鉴权注解

```java
@SaCheckLogin                              // 要求已登录
@GetMapping("/info")
public R<User> info() {
    return R.ok(StpUtil.getSession().get("user"));
}

@SaCheckRole("admin")                       // 要求角色
@SaCheckPermission("user:delete")           // 要求权限
@DeleteMapping("/user/{id}")
public R<Void> delete(@PathVariable Long id) { ... }
```

### 5 拦截器配置

```java
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry r) {
        r.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
            .addPathPatterns("/**")
            .excludePathPatterns("/login", "/register", "/favicon.ico");
    }
}
```

### 6 全局异常拦截

```java
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(NotLoginException.class)
    public R<Void> notLogin(NotLoginException e) {
        return R.fail("请先登录");
    }
    @ExceptionHandler(NotPermissionException.class)
    public R<Void> notPerm(NotPermissionException e) {
        return R.fail("无权限");
    }
}
```

---

# SpringBoot 注解

Spring Boot注解是一种元数据形式，可提供有关程序的数据。换句话说，注解用于提供有关程序的 **补充**信息。它不是我们开发的应用程序的一部分。它对其注解的代码的操作没有直接影响。不会更改已编译程序的操作。

在本节中，我们将讨论一些重要的 **Spring Boot注解**，我们将在本教程的后面部分使用。

## Core Spring框架注解

**@Required:** 它适用于 **bean** 设置方法。它指示必须在配置时使用必需的属性填充带注解的Bean，否则它将引发异常 **BeanInitilizationException** 。

**示例**

```java
public class Machine 
{
private Integer cost;
@Required
public void setCost(Integer cost) 
{
    this.cost = cost;
}
public Integer getCost() 
{
    return cost;
}   
}
```

**@Autowired:** : Spring通过提供@Autowired注解来提供基于注解的自动装配。它用于自动连接setter方法，实例变量和构造函数上的spring bean。当我们使用@Autowired批注时，spring容器通过匹配数据类型自动连接bean。

**示例**

```java
@Component
public class Customer
{
    private Person person;
    @Autowired
    public Customer(Person person) 
    { 
        this.person=person;
    }
}
```

**@Configuration:** : 它是一个类级别的注解。带有@Configuration注解的类由Spring Containers用作bean定义的源。

**示例**

```java
@Configuration
public class Vehicle
{
    @BeanVehicle engine()
    {
        return new Vehicle();
    }
}
```

**@ComponentScan:** : 当我们要扫描软件包中的bean时使用。它与注解@Configuration一起使用。我们还可以指定用于扫描Spring组件的基本软件包。

**示例**

示例

```java
@ComponentScan(basePackages = "com.nhooo")
@Configuration
public class ScanComponent
{
// ...
}
```

**@Bean:** 是方法级的注解。它是XML标记的代替方法。它告诉产生由Spring Container管理的bean的方法。

**示例**

示例

```java
@Bean
public BeanExample beanExample() 
{
    return new BeanExample ();
}
```

## Spring Framework构造型注解

**@Component:** 。它是一个类级别的注解。它用于将Java类标记为Bean。在类路径中找到了一个用 **@Component** 注解的Java类。 Spring框架将其拾取并在应用程序上下文中将其配置为 **Spring Bean** 。

**示例**

```java
@Component
public class Student
{
    .......
}
```

**@Controller:** @Controller是类级别的注解。它是 **@Component** 的专业化。它将一个类标记为Web请求处理程序。它通常用于服务网页。默认情况下，它返回一个字符串，该字符串指示要重定向的路由。它通常与 **@RequestMapping** 注解一起使用。

**示例**

```java
@Controller
@RequestMapping("books")
public class BooksController 
{
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Employee getBooksByName() 
    {
        return booksTemplate;
    }
}
```

**@Service:** 也用于类级别。它告诉Spring该类包含 **业务逻辑**。

**示例**

```java
package com.nhooo;
@Service
public class TestService
{
    public void service1()
    {
        //business code
    }
}
```

**@Repository:** 这是一个类级别的注解。该存储库是直接访问数据库的 **DAO** (数据访问对象)。该存储库执行与数据库有关的所有操作。

示例

```java
package com.nhooo;
@Repository 
public class TestRepository
{
    public void delete()
    {   
        //persistence code
    }
}
```

## Spring Boot注解

**@EnableAutoConfiguration:** : 它自动配置类路径中存在的bean，并将其配置为运行方法。在Spring Boot 1.2.0发行版中减少了使用此批注，因为开发人员提供了该批注的代替方法，即 **@SpringBootApplication** 。**@SpringBootApplication:** : 它是三个注解 **@ EnableAutoConfiguration，@ ComponentScan，**和 **@Configuration** 的组合。

### Spring MVC和REST注解

**@RequestMapping:** 用于映射**网络请求**。它具有许多可选元素，例如 consumes, header, method, name, params, path, produces和value。我们将其与类以及方法一起使用。

**示例**

```java
@Controller
public class BooksController 
{
    @RequestMapping("/computer-science/books")
    public String getAllBooks(Model model)
    {
        //application code
        return "bookList";
    }
}
```

**@GetMapping:** 它将 **HTTP GET** 请求映射到特定的处理程序方法。它用于创建**提取**的Web服务终结点，而不是使用 **@RequestMapping(method = RequestMethod.GET)**

**@PostMapping** 它将 **HTTP POST** 请求映射到特定的处理程序方法。它用于创建**创建**的Web服务终结点，而不是使用: **@RequestMapping(method = RequestMethod.POST)**

**@PutMapping:** 它将 **HTTP PUT** 请求映射到特定的处理程序方法。它用于创建**创建**或**更新**的Web服务终结点，而不是使用: **@RequestMapping(method = RequestMethod.PUT)**

**@DeleteMapping:** 它将 **HTTP DELETE** 请求映射到特定的处理程序方法。它用于创建**删除**资源的Web服务终结点。使用它而不是使用: **@RequestMapping(method = RequestMethod.DELETE)**

**@PatchMapping:** 它将 **HTTP PATCH** 请求映射到特定的处理程序方法。使用它代替使用: **@RequestMapping(method = RequestMethod.PATCH)**

**@RequestBody:** 用于将HTTP请求与方法参数中的对象**绑定**。在内部，它使用 **HTTP MessageConverters** 转换请求的正文。当我们用 **@RequestBody注解方法参数时，Spring框架会将传入的HTTP请求主体绑定到该参数。**

**@ResponseBody:** 它将方法返回值绑定到响应主体。它告诉Spring Boot Framework将返回的对象序列化为JSON和XML格式。**@PathVariable:** 用于从URI中提取值。它最适合RESTful Web服务，其中URL包含路径变量。我们可以在一个方法中定义多个@PathVariable。

**@RequestParam:** 用于从URL提取查询参数。也称为**查询参数**。它最适合Web应用程序。如果URL中不存在查询参数，则可以指定默认值。**@RequestHeader:** 用于获取有关HTTP请求标头的详细信息。我们将此注解用作**方法参数**。注解的可选元素是**名称，必填，值，defaultValue。** 对于标题中的每个细节，我们应指定单独的注解。我们可以在一种方法中多次使用它

**@RestController:** 可以将其视为 **@Controller** 和 **@ResponseBody** 注解**的组合。** @RestController注解本身使用@ResponseBody注解进行注解。无需使用@ResponseBody注解每个方法。

**@RequestAttribute:** 它将方法参数绑定到请求属性。它提供了从控制器方法方便地访问请求属性的方法。借助@RequestAttribute批注，我们可以访问服务器端填充的对象。

注意: 我们在RESTful Web服务教程中使用了以上所有示例和真实示例。

Spring Boot自动管理依赖性和配置。每个Spring Boot版本都提供了它所支持的依赖项列表。依赖关系列表是可以与 **Maven** 一起使用的 **材料清单**(弹簧启动依赖关系)的一部分。因此，我们无需在配置中指定依赖项的版本。 Spring Boot自行管理。当我们更新Spring Boot版本时，Spring Boot会以一致的方式自动升级所有依赖项。

## 依赖项管理的优点

通过在一个地方指定Spring Boot版本来提供依赖信息的集中化。当我们从一个版本切换到另一个版本时，它会有所帮助。它避免了不同版本的Spring Boot库的不匹配。我们只需要写一个库名称并指定版本。在多模块项目中很有用。

注意: 如果需要，Spring Boot还可以覆盖依赖项版本。

## Maven依赖管理系统

Maven项目从 **spring-boot-starter-parent继承了以下功能:**

默认的 **Java编译器版本**UTF-8 源编码它从spring-boot-dependency-pom继承了一个 **Dependency Section** 。它管理常见依赖项的版本。对于该依赖项，它将忽略 标签。从spring-boot-dependencies POM继承的依赖智能的**resource filtering**智能的**plugin configuration**

### 继承Starter Parent

在配置项目时，以下 **spring-boot-starter-parent** 会自动继承。

示例

```java
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.2.BUILD-SNAPSHOT</version>      
<!-- lookup parent from repository -->
<relativePath/> 
</parent>
```

注意: 在以上依赖项中，我们仅指定了Spring Boot版本。如果要添加其他启动器，只需删除标记。同样，我们也可以通过覆盖项目中的属性来覆盖个人依赖性。

例如，如果要添加与已注入的工件相同的另一个依赖项，请将该依赖项再次注入 **<properties>**标记中以覆盖

### 更改Java版本

我们还可以使用 **<java.version>**标记来更改Java版本。

示例

```java
<properties>  
<java.version>1.8</java.version>  
</properties>
```

### 添加Spring Boot Maven插件

我们还可以在 **pom.xml** 文件中 **添加Maven插件**。它将项目包装到可执行的 **jar** 文件中。

示例

```java
<build>  
<plugins>  
<plugin>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-maven-plugin</artifactId>  
</plugin>  
</plugins>  
</build>
```

### 不带父项POM的Spring Boot

如果我们不想使用 **spring-boot starter-parent** 依赖项，但仍想采用依赖管理的优势，我们可以使用 标签，如下所示:

注意: 它不维护插件管理。

示例

```java
<dependencyManagement>
<dependencies>
<dependency><!-- import dependency management from Spring Boot -->
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-dependencies</artifactId>
<version>2.2.2.RELEASE</version>
<type>pom</type>
<scope>import</scope>
</dependency>
</dependencies>
</dependencyManagement>
```

以上依赖项不允许覆盖。为了实现覆盖，我们需要在项目的 标记中的spring-boot-dependencies条目之前添加一个条目。

例如，要升级另一个 **spring-data-releasetrain** ，在pom.xml文件中添加以下依赖项。

示例

```java
<dependencyManagement>
<dependencies>
<!--Override Spring Data release train-->
<dependency>
<groupId>org.springframework.data</groupId>
<artifactId>spring-data-releasetrain</artifactId>
<version>Fowler-SR2</version>
<type>pom</type>
<scope>import</scope>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-dependencies</artifactId>
<version>2.2.2.RELEASE</version>
<type>pom</type>
<scope>import</scope>
</dependency>
</dependencies>
</dependencyManagement>
```

# SpringBoot 应用程序属性

Spring Boot Framework带有内置的机制，用于使用名为 **application.properties** 的文件进行应用程序配置。它位于 **src/main/resources** 文件夹中，如下图所示。

![图片.png](https://www.cainiaojc.com/static/upload/210424/1619230459.png)

Spring Boot提供了可以在 **application.properties** 文件中配置的各种属性。这些属性具有默认值。我们可以为Spring Boot应用程序设置一个或多个属性。 Spring Boot还允许我们根据需要定义自己的属性。

application.properties文件允许我们在 **不同的环境中运行应用程序。** 简而言之，我们可以使用application.properties文件进行以下操作:

配置Spring Boot框架定义我们的应用程序自定义配置属性

## application.properties的示例

示例

```java
#配置应用程序名称
pring.application.name = demoApplication
#配置端口
server.port = 8081
```

在上面的示例中，我们已经配置了 **应用程序名称**和 **端口**。端口8081表示应用程序在端口 **8081** 上运行。

注意: 以#开头的行是注释。

**YAML属性文件**

Spring Boot提供了另一个用于配置属性的文件，称为 **yml** 文件。 Yaml文件起作用是因为在类路径中存在 **Snake YAML** jar。除了使用application.properties文件之外，我们还可以使用application.yml文件，但是 **Yml** 文件应该出现在类路径中。

**应用示例.yml**

示例

```java
spring:
application:
name: demoApplication
server:
port: 8081
```

在上面的示例中，我们已经配置了 **应用程序名称**和 **端口**。端口8081表示应用程序在端口 **8081** 上运行。

## Spring Boot属性类别

有 16个Spring Boot属性的类别如下:

核心属性缓存属性邮件属性JSON属性数据属性交易属性数据迁移属性集成属性网络媒体资源模板属性服务器属性安全属性RSocket属性执行器属性DevTools属性测试属性

## 应用程序属性表

下表提供了常见的Spring Boot属性列表:

| 属性                                          | 默认值                | 说明                                                         |
| --------------------------------------------- | --------------------- | ------------------------------------------------------------ |
| Debug                                         | false                 | 它启用调试日志。                                             |
| spring.application.name                       |                       | 它用来设置应用程序名称。                                     |
| spring.application.admin.enabled              | false                 | 它用于启用应用程序的管理功能。                               |
| spring.config.name                            | application           | 用于设置配置文件名。                                         |
| spring.config.location                        |                       | 它用于配置文件名。                                           |
| server.port                                   | 8080                  | 配置HTTP服务器端口                                           |
| server.servlet.context-path                   |                       | 它配置应用程序的上下文路径。                                 |
| logging.file.path                             |                       | 它配置日志文件的位置。                                       |
| spring.banner.charset                         | UTF-8                 | 横幅文件编码。                                               |
| spring.banner.location                        | classpath: banner.txt | 它用于设置标题文件的位置。                                   |
| logging.file                                  |                       | 它用于设置日志文件名。例如，data.log。                       |
| spring.application.index                      |                       | 它用来设置应用程序索引。                                     |
| spring.application.name                       |                       | 它用来设置应用程序名称。                                     |
| spring.application.admin.enabled              | false                 | 它用于为应用程序启用管理功能。                               |
| spring.config.location                        |                       | 它用于配置文件位置。                                         |
| spring.config.name                            | application           | 用于设置文件名。                                             |
| spring.mail.default-encoding                  | UTF-8                 | 它用于设置默认的MimeMessage编码。                            |
| spring.mail.host                              |                       | 用于设置SMTP服务器主机。例如，smtp.example.com。             |
| spring.mail.password                          |                       | 用于设置SMTP服务器的登录密码。                               |
| spring.mail.port                              |                       | 用于设置SMTP服务器端口。                                     |
| spring.mail.test-connection                   | false                 | 它用于测试邮件服务器在启动时是否可用。                       |
| spring.mail.username                          |                       | 用于设置SMTP服务器的登录用户。                               |
| spring.main.sources                           |                       | 它用于设置应用程序的来源。                                   |
| server.address                                |                       | 它用于设置服务器应绑定到的网络地址。                         |
| server.connection-timeout                     |                       | 用于设置连接器在关闭连接之前将等待另一个HTTP请求的时间(以毫秒为单位)。 |
| server.context-path                           |                       | 它用于设置应用程序的上下文路径。                             |
| server.port                                   | 8080                  | 用于设置HTTP端口。                                           |
| server.server-header                          |                       | 用于服务器响应标头(如果为空则不发送标头)                     |
| server.servlet-path                           | /                     | 用于设置主调度程序servlet的路径                              |
| server.ssl.enabled                            |                       | 用于启用SSL支持。                                            |
| spring.http.multipart.enabled                 | 真                    | 它用于启用对分段上传的支持。                                 |
| spring.servlet.multipart.max-文件大小         | 1MB                   | 用于设置最大文件大小。                                       |
| spring.mvc.async.request-timeout              |                       | 它用于设置时间(以毫秒为单位)。                               |
| spring.mvc.date-format                        |                       | 用于设置日期格式。例如，dd/MM/yyyy。                         |
| spring.mvc.locale                             |                       | 用于设置应用程序的语言环境。                                 |
| spring.social.facebook.app-id                 |                       | 它用于设置应用程序的Facebook App ID。                        |
| spring.social.linkedin.app-id                 |                       | 它用于设置应用程序的LinkedIn应用程序ID。                     |
| spring.social.twitter.app-id                  |                       | 它用于设置应用程序的Twitter App ID。                         |
| security.basic.authorize-mode                 | role                  | 用于设置要应用的安全授权模式。                               |
| security.basic.enabled                        | true                  | 它用于启用基本身份验证。                                     |
| Spring.test.database.replace                  | any                   | 要替换的现有数据源的类型。                                   |
| Spring.test.mockmvc.print                     | default               | MVC打印选项                                                  |
| spring.freemaker.content-type                 | text/html             | 内容类型值                                                   |
| server.server-header                          |                       | 用于服务器响应标头的值。                                     |
| spring.security.filter.dispatcher-type        | async, error, request | 安全过滤器链调度程序类型。                                   |
| spring.security.filter.order                  | -100                  | 安全过滤器链顺序。                                           |
| spring.security.oauth2.client.registration。* |                       | OAuth客户端注册。                                            |
| spring.security.oauth2.client.provider。*     |                       | OAuth提供者详细信息。                                        |

# SpringBoot Starters

**Spring Boot** 提供了许多 **starters** ，允许我们在类路径中添加jar。 Spring Boot内置的 **入门程序**使开发更加轻松，快速。 **Spring Boot Starters**是 **依赖项描述符**。

在Spring Boot Framework中，所有启动程序都遵循类似的命名模式: **spring-boot-starter-\*** ，其中 ***** 表示特定类型的应用程序。例如，如果要使用Spring和JPA进行数据库访问，则需要在我们的 **pom.xml** 文件中包含 **spring-boot-starter-data-jpa** 依赖项

## 第三方Starters

我们还可以在项目中添加 **第三方启动程序**。但是我们不使用 **spring-boot-starter** 来包含第三方依赖项。 spring-boot-starter为官方的Spring Boot构件保留。第三方启动程序以项目名称开头。例如，第三方项目名称为 **abc** ，那么依赖项名称将为 **abc-spring-boot-starter。**

Spring Boot Framework在 **org.springframework.boot** 组下提供了以下应用程序启动器。

| 名称                                   | 说明                                                         |
| -------------------------------------- | ------------------------------------------------------------ |
| spring-boot-starter-thymeleaf          | 它用于使用Thymeleaf视图构建MVC Web应用程序。                 |
| spring-boot-starter-data-couchbase     | 它用于Couchbase面向文档的数据库和Spring Data Couchbase。     |
| spring-boot-starter-artemis            | 它用于使用Apache Artemis进行JMS消息传递。                    |
| spring-boot-starter-web-services       | 它用于Spring Web Services。                                  |
| spring-boot-starter-mail               | 它用于支持Java Mail和Spring Framework的电子邮件发送。        |
| spring-boot-starter-data-redis         | 用于Spring Data Redis和Jedis客户端的Redis键值数据存储。      |
| spring-boot-starter-web                | 它用于构建Web应用程序，包括使用Spring MVC的RESTful应用程序。它使用Tomcat作为默认的嵌入式容器。 |
| spring-boot-starter-data-gemfire       | 它用于GemFire分布式数据存储和Spring Data GemFire。           |
| spring-boot-starter-activemq           | 它用于使用Apache ActiveMQ的JMS消息传递中。                   |
| spring-boot-starter-data-elasticsearch | 它用于Elasticsearch搜索和分析引擎以及Spring Data Elasticsearch。 |
| spring-boot-starter-integration        | 它用于Spring集成。                                           |
| spring-boot-starter-test               | 它用于测试带有JUnit，Hamcrest和Mockito等库的Spring Boot应用程序。 |
| spring-boot-starter-jdbc               | 它用于具有Tomcat JDBC连接池的JDBC。                          |
| spring-boot-starter-mobile             | 它用于使用Spring Mobile构建Web应用程序。                     |
| spring-boot-starter-validation         | 它用于通过Hibernate Validator进行Java Bean验证。             |
| spring-boot-starter-hateoas            | 它用于通过Spring MVC和Spring HATEOAS构建基于超媒体的RESTful Web应用程序。 |
| spring-boot-starter-jersey             | 它用于使用JAX-RS和Jersey构建RESTful Web应用程序。代替spring-boot-starter-web。 |
| spring-boot-starter-data-neo4j         | 用于Neo4j图形数据库和Spring Data Neo4j。                     |
| spring-boot-starter-data-ldap          | 它用于Spring Data LDAP。                                     |
| spring-boot-starter-websocket          | 它用于构建WebSocket应用程序。它使用Spring Framework的WebSocket支持。 |
| spring-boot-starter-aop                | 它用于使用Spring AOP和AspectJ进行面向方面的编程。            |
| spring-boot-starter-amqp               | 它用于Spring AMQP和Rabbit MQ。                               |
| spring-boot-starter-data-cassandra     | 用于Cassandra分布式数据库和Spring Data Cassandra。           |
| spring-boot-starter-social-facebook    | 它用于Spring Social Facebook。                               |
| spring-boot-starter-jta-atomikos       | 它用于使用Atomikos进行JTA交易。                              |
| spring-boot-starter-security           | 它用于Spring Security。                                      |
| spring-boot-starter-mustache           | 它用于使用Mustache视图构建MVC Web应用程序。                  |
| spring-boot-starter-data-jpa           | 它用于带有Hibernate的Spring Data JPA。                       |
| spring-boot-starter                    | 它用于核心启动器，包括自动配置支持，日志记录和YAML。         |
| spring-boot-starter-groovy-templates   | 它用于使用Groovy模板视图构建MVC Web应用程序。                |
| spring-boot-starter-freemarker         | 它用于使用FreeMarker视图构建MVC Web应用程序。                |
| spring-boot-starter-batch              | 它用于Spring Batch。                                         |
| spring-boot-starter-social-linkedin    | 它用于Spring Social LinkedIn。                               |
| spring-boot-starter-cache              | 它用于Spring框架的缓存支持。                                 |
| spring-boot-starter-data-solr          | 它用于带有Spring Data Solr的Apache Solr搜索平台。            |
| spring-boot-starter-data-mongodb       | 它用于MongoDB面向文档的数据库和Spring Data MongoDB。         |
| spring-boot-starter-jooq               | 它用于jOOQ访问SQL数据库。代替spring-boot-starter-data-jpa或spring-boot-starter-jdbc。 |
| spring-boot-starter-jta-narayana       | 它用于Spring Boot Narayana JTA Starter。                     |
| spring-boot-starter-cloud-connectors   | 用于Spring Cloud Connector，可简化与Cloud Foundry和Heroku等云平台中服务的连接。 |
| spring-boot-starter-jta-bitronix       | 它用于使用Bitronix的JTA交易。                                |
| spring-boot-starter-social-twitter     | 它用于Spring Social Twitter。                                |
| spring-boot-starter-data-rest          | 它用于使用Spring Data REST在REST上公开Spring Data存储库。    |

## Spring Boot生产入门版

| 名称                             | 说明                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| spring-boot-starter-actuator     | 它用于Spring Boot的Actuator，提供了生产就绪功能，可帮助您监视和管理应用程序。 |
| spring-boot-starter-remote-shell | 它用于CRaSH远程shell通过SSH监视和管理您的应用程序。从1.5开始不推荐使用。 |

## Spring Boot技术入门

| 名称                         | 说明                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| spring-boot-starter-undertow | 用于Undertow，作为嵌入式servlet容器。代替spring-boot-starter-tomcat。 |
| spring-boot-starter-jetty    | 它用于Jetty作为嵌入式servlet容器。代替spring-boot-starter-tomcat。 |
| spring-boot-starter-logging  | 它用于使用Logback进行日志记录。默认的日志启动器。            |
| spring-boot-starter-tomcat   | 它用于Tomcat，作为嵌入式servlet容器。 spring-boot-starter-web使用的默认servlet容器启动器。 |
| spring-boot-starter-log4j2   | 用于Log4j2进行日志记录。代替spring-boot-starter-logging。    |

------

[SpringBoot Starter Parent](https://www.cainiaojc.com/springboot/springboot-starter-parent.html)[SpringBoot Starter Web](https://www.cainiaojc.com/springboot/springboot-starter-web.html)[SpringBoot Starter Data JPA](https://www.cainiaojc.com/springboot/springboot-starter-data-jpa.html)[SpringBoot Starter Actuator](https://www.cainiaojc.com/springboot/springboot-starter-actuator.html)[SpringBoot Starter Test](https://www.cainiaojc.com/springboot/springboot-starter-test.html)

# SpringBoot DevTools

## Spring Boot DevTools

Spring Boot 1.3提供了另一个名为Spring Boot DevTools的模块。 DevTools代表 **Developer Tool** 。该模块的目的是在使用Spring Boot应用程序时尝试并缩短开发时间。 Spring Boot DevTools接受更改并重新启动应用程序。

我们可以通过在pom.xml文件中添加以下依赖项来在我们的项目中实现DevTools。

示例

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<scope>runtime<scope >
</dependency>
```

## Spring Boot DevTools功能

Spring Boot DevTools提供以下功能:

**属性默认值****自动重启****LiveReload****远程调试隧道****远程更新和重新启动**

**属性默认值:** : Spring Boot提供了模板技术 **Thymeleaf** ，其中包含属性 **spring.thymeleaf.cache。**。缓存并允许我们更新页面，而无需重新启动应用程序。但是在开发过程中设置这些属性总是会带来一些问题。

当我们使用spring-boot-devtools模块时，不需要设置属性。在Thymeleaf，Freemarker，Groovy模板的开发缓存期间，将自动禁用。

注意: 如果我们不想在应用程序上应用属性默认值，可以在application.properties文件中将configprop: spring.devtools.add-properties []设置为false。

**自动重启:** 自动重启意味着重新加载Java类并在服务器端对其进行配置。服务器端更改后，它会动态部署，服务器会重新启动，并加载修改后的代码。它主要用于基于微服务的应用程序。 Spring Boot使用 **两种**类型的ClassLoader:

不变的类(三分之二)已加载到**基本ClassLoader中。**我们正在积极开发的类已加载到**重新启动ClassLoader中。**

应用程序重新启动时，重新启动的ClassLoader被丢弃，并填充了一个新的类。因此，基本的ClassLoader始终可用并已填充。

我们可以使用属性 **spring.devtools.restart.enabled** 设置为 **来禁用服务器的自动重启。错误。**

### 记住:

DevTools始终监视类路径资源。触发重启的唯一方法是更新类路径。DevTools需要单独的应用程序类加载器才能正常工作。默认情况下，Maven派生应用程序进程。自动重新启动与 **LiveReload一起很好地工作。**DevTools依赖于应用程序上下文的关闭挂钩在重新启动期间将其关闭。

**LiveReload:** Spring Boot DevTools模块包括一个名为 **LiveReload的嵌入式服务器。**，只要我们在其中进行更改，该应用程序就可以自动触发浏览器刷新。资源。这也称为 **自动刷新。**

**注意:** 我们可以通过设置属性 **spring.devtools.livereload来禁用LiveReload。启用**为 **false。**

它提供了适用于Chrome，Firefox和Safari的浏览器扩展。默认情况下，启用LiveReload。 LiveReload在以下路径上工作:

/META-INF/maven/META-INF/resources/资源/静态/public/模板

我们还可以通过排除上述路径来禁用浏览器中的自动重新加载。例如:

示例

```java
spring.devtools.restart.exclude=public/**, static/**, templates/**
```

我们可以使用属性 **spring.devtools.restart.additional-paths查看其他附加路径。**例如:

示例

```java
spring.devtools.restart.additional-paths=/path-to-folder
```

如果我们要排除其他路径并希望保留默认路径，请使用属性 **spring.devtools.restart.additional-exclude。**例如:

示例

```java
spring.devtools.restart.additional-exclude=styles/**
```

### 记住

我们可以一次运行一台LiveReload服务器。启动应用程序之前，请确保没有其他LiveReload服务器正在运行。如果我们从IDE启动多个应用程序，则它仅支持第一个LiveReload。

**远程调试隧道:** Spring Boot可以通过HTTP将JDWP(Java调试线协议)直接隧道到应用程序。它甚至可以将应用程序部署到仅公开端口80和443的Internet Cloud提供商。

**远程更新和重新启动:** DevTools提供的另一个技巧是: 它支持远程应用程序 **更新**和 **重新启动。**它监视本地类路径中的文件更改，并将其推送到远程服务器，然后重新启动。我们还可以将此功能与LiveReload结合使用。

## 使用触发文件

由于频繁的重启，自动重启有时会减慢开发时间。为了解决这个问题，我们可以使用一个 **触发文件。**。SpringBoot监视触发文件并检测该文件中的修改。它会重新启动服务器并重新加载所有先前的更改。

我们可以通过添加属性 **spring.devtools.restart.trigger-file在我们的应用程序中实现触发文件。**是内部的还是外部的。例如:

示例

```
spring.devtools.restart.trigger-file=c:/workspace-sts-3.9.9.RELEASE/restart-trigger.txt
```

### Spring Boot DevTools示例

**步骤1:** 使用Spring Initializr https://start.spring.io/。

**步骤2:** 提供 **组**名称和 **工件** ID。我们提供了组名 **com.nhooo** 和工件ID **spring-boot-devtools-example。**

**步骤3:** 添加以下依赖项: **spring-boot-starter-web** 和 **spring-boot-devtools** 。

**步骤4:** 点击 **生成**按钮。它将下载项目的 **Jar** 文件。

**步骤5:** 提取Jar文件。

**步骤6:** 将文件夹导入STS。

文件->导入->现有Maven项目->浏览->选择文件夹spring-boot-devtools-example->完成

导入成功后，我们可以在STS的Package Explorer部分中看到以下目录。

![Spring Boot DevTools](https://www.cainiaojc.com/static/upload/210424/0415470.png)

**步骤7:** 打开 **SpringBootDevtoolsExampleApplication.java** 并将其作为Java应用程序运行。

然后，在应用程序中进行任何更改(编辑或删除一些文件或代码)，然后保存所做的更改。保存更改后，服务器将重新启动并获取更改。

![Spring Boot DevTools](https://www.cainiaojc.com/static/upload/210424/0415471.png)

------

# SpringBoot 多模块项目

## Multi-Module项目

包含嵌套Maven项目的Spring Boot项目称为 **多模块项目**。在多模块项目中，父项目充当基础Maven配置的容器。

换句话说， **多模块项目**是从管理一组子模块的父pom构建的。或 **多模块项目**由父POM引用一个或多个子模块来定义。

父maven项目必须包含 **pom** 的包装类型使该项目成为聚合器。父项目的 **pom.xml** 文件包含子项目继承的所有 **模块，公共依赖项**和 **属性**的列表。父pom位于项目的根目录中。子模块是实际的Spring Boot项目，它们从父项目继承maven属性。

当我们运行多模块项目时，所有模块都一起部署在嵌入式Tomcat Server中。我们也可以部署单个模块。

## 父POM

父POM定义了 **组ID，工件ID，版本**，和 **packaging。**。在以前的Maven项目中，我们已经看到父级POM定义了包装 **jar。**。但是在多模块项目中，父级 **POM** 定义包装pom。打包pom引用了其他Maven项目。

## 为什么我们需要多模块项目

将项目分为多个模块是有用且易于维护的。我们还可以轻松编辑或删除项目中的模块，而不会影响其他模块。当我们需要分别部署模块时，这很有用。

我们只需要在父pom中指定所有依赖项即可。所有其他模块共享相同的pom，因此我们无需在每个模块中分别指定相同的依赖项。

## 子模块-ear，war和jar

子模块可以是任何项目，并且可以有任何包装。我们可以自由地在模块和束之间创建任何类型的依赖关系。

例如，我们正在创建 **EAR** (企业归档)， **WAR** (Web ARchive)和 **JAR** (Java ARchive)文件。 JAR文件捆绑到war文件中，而war文件捆绑到EAR文件中。 EAR文件是可以在应用程序服务器上部署的最终软件包。

EAR文件包含一个或多个WAR文件。每个WAR文件都包含服务项目，该项目对JAR中的所有WAR文件和打包类型具有通用代码。

![Spring Boot多模块项目](https://www.cainiaojc.com/static/upload/210424/0418570.png)

## Maven子项目/模块

子模块是独立的maven项目，它们共享父项目的属性。所有子项目都可以用一个命令来构建，因为它位于父项目中。定义项目之间的关系更容易。

## 多模块项目目录结构

让我们了解多模块项目目录结构。

在下图中，我们创建了一个名为 **spring-boot-multi-module-project** 的项目。它在目录底部包含父 **pom** 。之后，我们创建了两个 **Maven模块**，分别命名为 **module1** 和 **module2** 。这两个模块包含自己的pom文件。

![Spring Boot多模块项目](https://www.cainiaojc.com/static/upload/210424/0418571.png)

让我们打开父POM，并查看在项目中创建Maven模块时其配置。

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.2.BUILD-SNAPSHOT</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
<groupId>com.nhooo</groupId>
<artifactId>spring-boot-example</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>spring-boot-multi-module-project</name>
<description>Demo project for Spring Boot</description>
<properties>
<java.version>1.8</java.version>
</properties>
<packaging>pom</packaging>
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter</artifactId>
</dependency> 
<dependency>
 <groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.1.RELEASE</version>
<type>pom</type>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-webmvc</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
<exclusions>
<exclusion>
<groupId>org.junit.vintage</groupId>
<artifactId>junit-vintage-engine</artifactId>
</exclusion>
</exclusions>
</dependency>
</dependencies>
<build>
<plugins>
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
</plugins>
</build>
<repositories>
<repository>
<id>spring-milestones</id>
<name>Spring Milestones</name>
<url>https://repo.spring.io/milestone</url>
</repository>
<repository>
<id>spring-snapshots</id>
<name>Spring Snapshots</name>
<url>https://repo.spring.io/snapshot</url>
<snapshots>
<enabled>true</enabled>
</snapshots>
</repository>
</repositories>
<pluginRepositories>
<pluginRepository>
<id>spring-milestones</id>
<name>Spring Milestones</name>
<url>https://repo.spring.io/milestone</url>
</pluginRepository>
<pluginRepository>
<id>spring-snapshots</id>
<name>Spring Snapshots</name>
<url>https://repo.spring.io/snapshot</url>
<snapshots>
<enabled>true</enabled>
</snapshots>
</pluginRepository>
</pluginRepositories>
<modules>
<module>module1</module>
<module>module2</module>
</modules>
</project>
```

上面的pom文件与前面的示例相同。但是在此 **pom** 文件中，需要注意两件事: **包装**和 **模块。**

当我们创建多模块时项目，我们需要在父pom文件中配置打包pom，而不是 **jar。**

示例

```java
<packaging>pom</packaging>
```

当我们在项目中创建Maven模块时，Spring Boot会在 **module** 标签内的父pom中自动配置模块，如下所示。

示例

```java
<modules>
<module>module1</module>
<module>module2</module>
</modules>
```

现在，我们将查看 **module1的pom文件中的内容。**

**pom.xml**

示例

```java
<?xml version="1.0"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>com.nhooo</groupId>
<artifactId>spring-boot-multi-module-project</artifactId>
<version>0.0.1-SNAPSHOT</version>
</parent>
<groupId>com.nhooo</groupId>
<artifactId>module1</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>module1</name>
<url>http://maven.apache.org</url>
<properties>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
<dependencies>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>3.8.1</version>
<scope>test</scope>
</dependency>
</dependencies>
</project>
```

在此处，需要注意的是，上述pom文件不包含诸如 **starter-web，web-mvc等**之类的公共依赖项。它继承了所有公共依赖项和属性 **父pom。**

## Spring Boot多模块项目示例

让我们创建一个多模块应用程序示例。

**在以下示例中，我们创建了一个名为 \**spring-boot-multimodule的maven项目。\**这是主要应用程序。在主应用程序中，我们创建了\**五个\**模块，如下所示:****应用****模型****存储库****service-api****service-impl**

**应用程序模块**

应用程序模块是项目的主要模块。它包含应用程序类，在其中定义了运行Spring Boot Application所需的main方法。它还包含 **应用程序配置属性，控制器，视图**和 **资源。**

应用程序模块包括模型模块，服务实现模块作为包含模型的依赖项模块，存储库模块和服务API模块。

**模型模块**

模型模块包含 **实体**和在项目中使用的 **Visual Objects** 。

**存储库模块**

存储库模块包含 <在项目中使用的strong>  存储库。它取决于模型模块。

**服务API模块**

服务API模块包含所有项目 **服务。**这也取决于模型模块。

**服务实现模块**

服务实现模块可以实现服务。它取决于存储库模块和服务API模块。

## POM聚合器(父POM)

父pom包含所有应用程序模块。它还包括一个以上模块所需的所有常见依赖关系和属性。因为项目已将Spring IO Platform定义为父级，所以没有版本就定义了依赖项。

让我们了解我们创建的多模块应用程序的结构。

示例

```java
Spring-boot-multimodule  
├── pom.xml  
│   └── REDME.adoc  
├── application  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           ├── java  
│           │   └── sample  
│           │       └── multimodule  
│           │           ├── SampleWebJspApplication.java  
│           │           └── web  
│           │               └── WelcomeController.java  
│           └── resources  
│               ├── application.properties  
│               └── templates  
│                   └── welcome  
│                       └── show.html  
├── model  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           └── java  
│               └── sample  
│                   └── multimodule  
│                       └── domain  
│                           └── entity  
│                               └── Account.java  
|  
├── repository  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           └── java  
│               └── sample  
│                   └── multimodule  
│                       └── repository  
│                           └── AccountRepository.java  
├── service-api  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           └── java  
│               └── sample  
│                   └── multimodule  
│                       └── service  
│                           └── api  
│                               ├── AccountNotFoundException.java  
│                               └── AccountService.java  
└── service-impl  
    ├── pom.xml  
    └── src  
        └── main  
            └── java  
                └── sample  
                    └── multimodule  
                        └── service  
                            └── impl  
                                └── AccountServiceImpl.java
```

**步骤1:** 创建一个名为 **spring-boot-multimodule的 \**Maven项目\**。**

**步骤2:** 打开 **pom.xml** (父pom)文件，并将包装类型 **jar** 更改为 **pom。** 

**pom.xml(父pom)**

示例

```java
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<!-- Springio 平台是生成的应用程序的父应用程序，能够使用 Spring Boot 及其所有缺省配置 -->
<parent>
<groupId>io.spring.platform</groupId>
<artifactId>platform-bom</artifactId>
<version>2.0.1.RELEASE</version>
</parent>
<groupId>sample.multimodule</groupId>
<artifactId>sample.multimodule</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>pom</packaging>
<name>Parent - Pom Aggregator</name>
<properties>
<java.version>1.8</java.version>
</properties>
<dependencies>
<!-- Spring Boot 依赖 -->
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
</dependencies>
</project>
```

在上面的pom文件中要注意的一件事是，由于尚未创建Maven模块，因此未配置。现在，我们将如上所述创建一个Maven模块。

**步骤3:** 创建一个名为  **application的 \**Maven模块\** 。**

**步骤4:** 打开应用程序模块的  **pom.xml** 文件，并确保打包类型为  **jar。**

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <artifactId>sample.multimodule.application</artifactId>
    <packaging>jar</packaging>
    <name>Project Module - Application</name>
    <dependencies>
      <!-- Project modules -->
      <dependency>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule.service.impl</artifactId>
        <version>${project.version}</version>
      </dependency>
      <!-- Spring Boot dependencies -->
          <dependency>
              <groupId>org.apache.tomcat.embed</groupId>
              <artifactId>tomcat-embed-jasper</artifactId>
              <scope>provided</scope>
          </dependency>
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
      </dependency>
    
    </dependencies>
    
    <build>
        <plugins>
            <!-- Spring Boot plugins -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

**步骤5:** 创建  **主要**类。这是要运行的类。

**SampleWebJspApplication.java**

示例

```java
package sample.multimodule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.orm.jpa.EntityScan;
@SpringBootApplication
public class SampleWebJspApplication 
{
    public static void main(String[] args) throws Exception 
    {
        SpringApplication.run(SampleWebJspApplication.class, args);
    }
}
```

**步骤6:** 在包  **smaple.multimodule.web。**

下创建一个名称为  **WelocameController** 的Controller类。  
 **WelcomeController.java**

示例

```java
package sample.multimodule.web;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.multimodule.domain.entity.Account;
import sample.multimodule.service.api.AccountService;
@Controller
public class WelcomeController 
{
    @Value("${application.message:Hello World}")
    private String message = "Hello World";
    @Autowired
    protected AccountService accountService;
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) 
    {
        //试图获得23号帐户
        Account account = accountService.findOne("23");
        if(account == null){
            //如果创建帐户时出现问题，请返回显示错误状态的视图
            model.put("message", "Error getting account!");
            model.put("account", "");
            return "welcome/show";
        }  
        //返回显示23个帐户信息的视图
        String accountInfo = "Your account number is ".concat(account.getNumber());
        model.put("message", this.message);
        model.put("account", accountInfo);
        return "welcome/show";
    }
    @RequestMapping("foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }
}
```

**第7步:** : 在文件夹  **src/main/resource下创建一个名为 \**show.html\** 的 \**HTML\** templates ->welcome。**

**show.html**

示例

```java
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Spring Boot Multimodule</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <div>
      <b>Message: </b>
      <span th:text="${message}" />
    </div>
    <div>
      <b>Your account: </b>
      <span th:text="${account}" />
    </div>
</body>
</html>
```

**步骤8:** 打开  **application.properties** 文件，将  **application message**和  **thymeleaf**缓存配置为  **否。**

**application.properties**

示例

```java
#应用程序信息
application.message = Hello User!
dummy.type = type-inside-the-war

#Spring Thymeleaf 配置
spring.thymeleaf.cache = false
```

创建上述所有文件后，应用程序模块目录如下所示:

![ Spring Boot Multi-Module Project](https://www.cainiaojc.com/static/upload/210424/0418572.png)

让我们创建第二个模块，即  **model。**

**步骤9:** 创建一个  **Maven Module**，名称为  **model。**

**步骤10:** 打开模型的  **pom.xml** 文件模块，并确保包装类型为  **jar。**

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <artifactId>sample.multimodule.model</artifactId>
    <packaging>jar</packaging>
    <name>Project Module - Model</name>
    <description>Module that contains all Entities and Visual Objects to be used in the project. It doesn't have any dependencies. 
    </description>
</project>
```

**步骤11:** 在包  **sample.multimodule.domain.entity。**

下创建一个名称为 **Account** 的类。

**Account.java**

示例

```java
package sample.multimodule.domain.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Account 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String number;
    private String type;
    private String creditCardNumber;
    /**
     * 创建一个空帐户。
     */
    public Account() {
    }
    
    /**
     * 创建新帐户。
     * 
     * @param number
     *            the account number
     * @param id
     *            the account id
     */
    public Account(long id, String number) {
        this.number = number;
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
```

创建所有上述文件后，模型模块目录如下:

![ Spring Boot Multi-Module Project](https://www.cainiaojc.com/static/upload/210424/0418573.png)

让我们创建  **third** 模块

**步骤12:** 创建一个名为  **repository的 \**Maven模块\**。** strong>

**步骤13:** 打开应用程序模块的  **pom.xml** 文件，并确保打包类型为  **jar。**

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <artifactId>sample.multimodule.repository</artifactId>
    <packaging>jar</packaging>
    <name>Project Module - Repository</name>
    <description>Module that contains all repositories to be used in the project. Depends of Model Module.</description>
    <dependencies>
      <!-- Project modules -->
      <dependency>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule.model</artifactId>
        <version>${project.version}</version>
      </dependency>
      <!-- Spring Boot dependencies -->
      <dependency>
        <groupId>org.hsqldb</groupId>
        <artifactId>hsqldb</artifactId>
        <scope>runtime</scope>
      </dependency>
    </dependencies>
    
</project>
```

**步骤14:** 在包  **sample.multimodule.repository**

创建一个名称为  **AccountRepository** 的类。  
 **AccountRepository.java**

示例

```java
package sample.multimodule.repository;
import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import sample.multimodule.domain.entity.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> 
{
    Account findByNumber(String number);
}
```

创建上述所有文件后，存储库模块目录如下所示:

![ Spring Boot Multi-Module Project](https://www.cainiaojc.com/static/upload/210424/0418574.png)

让我们创建  **第四**模块，它是  **service-api。**

**步骤15:** 创建一个名为  **service-api的 \**Maven模块\**。**

**步骤16** : 打开  <strong应用程序**service-api 的> pom.xml 文件，并确保打包类型为  \**jar。\**** 

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <artifactId>sample.multimodule.service.api</artifactId>
    <packaging>jar</packaging>
    <name>Project Module - Service API</name>
    <description>Module that contains API of all project services. Depends of Model Module.</description>
    <dependencies>
      <!-- Project Modules -->
      <dependency>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule.model</artifactId>
        <version>${project.version}</version>
      </dependency>
    </dependencies> 
</project>
```

**步骤17:** 创建名称为  **sample.multimodule.service.api的软件包。**

**步骤18:** 创建一个名称为  **AccountNotFoundException的类。**如果未找到该帐户，它将处理异常。

**AccountNotFoundException.java**

示例

```java
package sample.multimodule.service.api;
public class AccountNotFoundException extends RuntimeException 
{
    private static final long serialVersionUID = -3891534644498426670L;
    public AccountNotFoundException(String accountId) 
    {
        super("No such account with id: " + accountId);
    }
}
```

**步骤19:** 创建一个名为  **AccountService的类。**它提供与帐户相关的服务，例如  **查找**和  **创建**帐户。

**AccountService.java**

示例

```java
package sample.multimodule.service.api;
import java.util.List;
import sample.multimodule.domain.entity.Account;
public interface AccountService 
{
    /**
     * 使用提供的帐号查找帐户。
     * 
     * @param number The account number
     * @return The account
     * @throws AccountNotFoundException if no such account exists.
     */
    Account findOne(String number) throws AccountNotFoundException;
    /**
     * Creates a new account.
     * @param number
     * @return created account
     */
    Account createAccountByNumber(String number);
}
```

创建上述所有文件之后，service-api模块目录如下所示:

![Spring Boot Multi-Module Project](https://www.cainiaojc.com/static/upload/210424/0418575.png)

**步骤20:** 创建一个名为  **service-impl的 \**Maven模块\**。**

**步骤21:** : 打开应用程序  **service-impl** 的  **pom.xml** 文件，并确保包装类型为jar。

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <artifactId>sample.multimodule.service.impl</artifactId>
    <packaging>jar</packaging>
    <name>Project Module - Service Implementation</name>
    <description>Module that contains services implementation defined on Service API module. Depends of Repository Module and Service API Module.</description>    
    <dependencies>
      <!-- Project Modules -->
      <dependency>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule.repository</artifactId>
        <version>${project.version}</version>
      </dependency>
      <dependency>
        <groupId>sample.multimodule</groupId>
        <artifactId>sample.multimodule.service.api</artifactId>
        <version>${project.version}</version>
      </dependency>
    </dependencies>
</project>
```

**步骤22:** 在包  **sample.multimodule.service.impl。**

下创建一个名称为 **AccountServiceImpl** 的类。

**AccountServiceImpl.java**

示例

```java
package sample.multimodule.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.multimodule.domain.entity.Account;
import sample.multimodule.repository.AccountRepository;
import sample.multimodule.service.api.AccountService;
import sample.multimodule.service.api.AccountNotFoundException;
@Service
public class AccountServiceImpl implements AccountService 
{
@Value("${dummy.type}")
private String dummyType;
@Autowired
    private AccountRepository accountRepository;
    /**
     * {@inheritDoc}
     * <p/>
     * Dummy method for testing purposes.
     * 
     * @param number The account number. Set 0000 to get an {@link AccountNotFoundException} 
     */
    @Override
    public Account findOne(String number) throws AccountNotFoundException {
        if(number.equals("0000")) {
            throw new AccountNotFoundException("0000");
        }
        Account account = accountRepository.findByNumber(number);
        if(account == null){
          account = createAccountByNumber(number);
        }
        return account;
    }
    @Override
    public Account createAccountByNumber(String number) {
        Account account = new Account();
        account.setNumber(number);
        return accountRepository.save(account);
    }
    public String getDummyType() {
        return dummyType;
    }
    public void setDummyType(String dummyType) {
        this.dummyType = dummyType;
    }
}
```

创建上述所有文件后，  **service-impl** 模块目录如下所示:

![Spring Boot Multi-Module Project](https://www.cainiaojc.com/static/upload/210424/0418576.png)

现在打开  **父pom** 文件，我们看到已创建的所有Maven模块都在  **中的父pom**标签。我们不需要手动配置它。

![Spring Boot多模块项目](https://www.cainiaojc.com/static/upload/210424/0418577.png)

现在确保所有五个模块都已安装创建，如下所示:

![Spring Boot Multi-Module Project](https://www.cainiaojc.com/static/upload/210424/0418578.png)

创建后所有模块，主项目目录如下所示:

![Spring Boot多模块项目](https://www.cainiaojc.com/static/upload/210424/0418579.png)

**步骤23:** 现在，将  **SampleWebJspApplication.java** 文件作为Java应用程序运行。

**步骤24:** 打开浏览器并调用URL http: //localhost: 8080。它返回  **消息**和帐号为  **23。**

![Spring Boot多模块项目](https://www.cainiaojc.com/static/upload/210424/04185710.png)

# SpringBoot 打包

在J2EE应用程序中，模块打包为 **JAR，WAR，**和 **EAR** 。 J2EE中使用的是压缩文件格式。 J2EE定义了三种类型的档案:

- War
- JAR
- EAR

![Spring Boot Packaging](https://www.cainiaojc.com/static/upload/210424/0434310.png)

## WAR

**WAR** 代表 **Web存档。**。WAR文件代表Web应用程序。 Web模块包含servlet类，JSP文件，HTML文件，JavaScript等，并打包为扩展名为。 **war** 的JAR文件。它包含一个名为 **WEB-INF** 的特殊目录。

WAR是一个模块，可加载到Java Application Server的Web容器中。 Java Application Server具有 **两个**容器: **Web容器**和 **EJB容器**。

**Web容器**托管基于Servlet API和JSP的Web应用程序。 Web容器要求将Web模块打包为WAR文件。这是WAR文件专用的JAR文件，在 **WEB-INF** 文件夹中包含 **web.xmlv** 文件。

**EJB容器**托管基于EJB API的Enterprise Java Bean。它要求将EJB模块打包为JAR文件。它在 **META-INF** 文件夹中包含一个 **ejb-jar.xml** 文件。

WAR文件的优点是可以轻松部署。在Web服务器环境中的客户端计算机上。要执行WAR文件，需要Web服务器或Web容器。例如，Tomcat，Weblogic和Websphere。

## JAR

**JAR** 代表 **Java存档。**包含Bean文件(类文件)，清单和EJB部署描述符(XML文件)的EJB(企业Java Beans)模块打包为JAR文件，扩展名为。 **jar。**软件开发人员可以分发Java类和各种元数据。

换句话说，一个封装一个或多个Java类，清单和描述符的文件称为JAR文件。它是存档的最低级别。它在J2EE中用于包装EJB和客户端Java应用程序。

## EAR

**EAR** 代表 **Enterprise Archive。**。EAR文件代表企业应用程序。上面两个文件打包为扩展名为。 **ear** 的JAR文件。它已部署到应用服务器中。它可以包含多个EJB模块(JAR)和Web模块(WAR)。这是一个特殊的JAR，它在 **META-INF** 文件夹中包含一个 **application.xml** 文件。

# SpringBoot 自动装配

SpringBoot自动配置根据我们添加的jar依赖项自动配置SpringBoot应用程序。

例如，如果类路径中存在H2数据库Jar，而我们尚未手动配置任何与数据库相关的bean，则Spring Boot的自动配置功能会在项目中自动对其进行配置。

我们可以启用自动通过使用注解 **@EnableAutoConfiguration** 配置功能。但是此注解不使用，因为它包装在 **@SpringBootApplication** 注解内。注解@SpringBootApplication是三个注解的组合: **@ComponentScan，@EnableAutoConfiguration，**和 **@Configuration** 。但是，我们使用@SpringBootApplication批注而不是使用@EnableAutoConfiguration。

**@SpringBootApplication = @ComponentScan + @EnableAutoConfiguration + @Configuration**

当添加 **在项目中使用spring-boot-starter-web** 依赖项时，Spring Boot自动配置会在类路径中查找Spring MVC。它会自动配置 **dispatcherServlet** ，默认的 **错误页面**和 **网络罐子**。

类似地，当我们添加spring-boot-starter-data-jpa 依赖关系，我们看到Spring Boot自动配置会自动配置 **数据源**和 **实体管理器**。

所有自动配置逻辑都在 **spring-boot-autoconfigure.jar** 中实现，如下图所示。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436130.png)

## 需要自动配置

基于Spring的应用程序需要很多配置。使用Spring MVC时，我们需要配置 **dispatcher servlet，视图解析器，Web jars** 。以下代码显示了Web应用程序中调度程序servlet的典型配置:

示例

```
<servlet>
<servlet-name>dispatcher</servlet-name>
<servlet-class>
org.springframework.web.servlet.DispatcherServlet
</servlet-class>
<init-param>
<param-name>contextConfigLocation</param-name>
<param-value>/WEB-INF/todo-servlet.xml</param-value>
</init-param>
<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
<servlet-name>dispatcher</servlet-name>
<url-pattern>/</url-pattern>
</servlet-mapping>
```

类似地，当我们使用Hibernate/JPA时，我们需要配置数据源，事务管理器，实体管理器工厂等等。

**配置数据源**

示例

```
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
destroy-method="close">
<property name="driverClass" value="${db.driver}" />
<property name="jdbcUrl" value="${db.url}" />
<property name="user" value="${db.username}" />
<property name="password" value="${db.password}" />
</bean>
<jdbc:initialize-database data-source="dataSource">
<jdbc:script location="classpath:config/schema.sql" />
<jdbc:script location="classpath:config/data.sql" />
</jdbc:initialize-database>
```

**配置实体管理器工厂**

示例

```
<bean
class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"
id="entityManagerFactory">
<property name="persistenceUnitName" value="hsql_pu" />
<property name="dataSource" ref="dataSource" />
</bean>
```

**配置事务管理器**

示例

```
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
<property name="entityManagerFactory" ref="entityManagerFactory" />
<property name="dataSource" ref="dataSource" />
</bean>
<tx:annotation-driven transaction-manager="transactionManager"/>
```

## 禁用自动配置类

如果我们不想被应用，我们还可以禁用特定的自动配置类。我们使用注解@EnableAutoConfiguration的 **exclude** 属性来禁用自动配置类。例如:

示例

```
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;
@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyConfiguration 
{
}
```

如果类不在类路径中，我们可以使用@EnableAutoConfiguration批注的属性 **excludeName** 并指定类的 **qualified** 名称。我们可以使用属性 **spring.autoconfigure.exclude** 排除任何数量的自动配置类。

### Spring Boot自动配置示例

在以下示例中，我们将看到Spring Boot的自动配置功能如何工作。

**步骤1:** 打开spring Initializr https://start.spring.io/。

**第2步:** **组**名称。我们提供了 **com.nhooo** 。

**步骤3:** 提供 **工件** ID。我们提供了 **spring-boot-autoconfiguration-example** 。

**步骤4:** 添加依赖项: **Spring Web，Spring Data JPA，**一个 **H2数据库**。

**步骤5:** 单击 **Generate** (生成)按钮。当我们单击"生成"按钮时，它会将项目包装在 **Jar** 文件中，并将其下载到本地系统。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436131.png)

**第6步: 提取** Jar文件并将其粘贴到STS工作区中。

**步骤7: 将**项目文件夹导入STS。

文件->导入->现有Maven项目->浏览->选择文件夹spring-boot-autoconfiguration-example->完成

导入需要一些时间。

**步骤8:** 在目录中创建名称为 **com.nhooo.controller** 的程序包。文件夹 **src/main/java** 。

**步骤9:** 在包中创建名称为 **ControllerDemo** 的Controller类。 strong> com.nhooo.controller 。

**ControllerDemo.java**

示例

```java
package com.nhooo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ControllerDemo 
{
    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }
}
```

**步骤10:** 在文件夹 **src/main/java** 中创建另一个名为 **com.nhooo.model** 的包。 p>

**步骤11:** 在包  **com.nhooo.model** 中创建一个名称为  **User** 的类。

**User.java**

示例

```java
package com.nhooo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userdata")
public class User 
{
    @Id
    private int id;
    private String username;
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getUname() 
    {
        return username;
    }
    public void setUname(String username) 
    {
        this.username = username;
    }
    @Override
    public String toString() 
    {
        return "User [id=" + id + ", uname=" + username + "]";
    }
}
```

现在，我们需要配置H2数据库。

**步骤12:** 打开  **application.properties** 文件并配置以下内容:  **端口，启用H2控制台，数据源，**和  **URL。**

**application.properties**

示例

```java
server.port=8085
spring.h2.console.enabled=true
spring.datasource.plateform=h2
spring.datasource.url=jdbc:h2:mem:nhooo
```

**步骤13:** 在文件夹  **src/main/resources中创建一个 \**SQL\** 文件。**

右键单击src/main/resources文件夹->新建->文件->提供文件名->完成

我们提供了文件名  **data.sql** 并将以下数据插入其中。

**data.sql**

示例

```java
insert into userdata values(101,'Tom');
insert into userdata values(102,'Andrew');
insert into userdata values(103,'Tony');
insert into userdata values(104,'Bob');
insert into userdata values(105,'Sam');
```

**步骤14:** 在  **src** 文件夹中创建一个名称为  **webapp** 的文件夹。

**步骤15:** 使用我们在  **ControllerDemo** 中返回的名称创建一个JSP文件。在ControllerDemo.java中，我们返回了  **home.jsp** 。

**home.jsp**

示例

```java
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addUser">
ID :<br />
<input type="text" name="t1"><br />
User name :<br />
<input type="text" name="t2"><br />
<input type="submit" value="Add">
</form>
</body>
</html>
```

**步骤16:** 运行  **SpringBootAutoconfigurationExampleApplication.java** 文件。我们可以在控制台中看到我们的应用程序已成功在端口  **8085** 上运行。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436132.png)

**步骤17:** 打开浏览器并调用URL  *http: //localhost: 8085/h2-console/*。它显示了我们在  **application.properties** 文件中配置的  **驱动程序类**，  **JDBC URL** ，以及默认的用户名  **sa** 。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436133.png)

我们还可以通过以下方式测试连接点击  **测试连接**按钮。如果连接成功，则显示消息  **测试成功。**

**步骤18:** 单击  **连接**按钮。它显示了我们在User.java文件中定义的表  **userdata** 的结构。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436134.png)

**步骤19:** 执行以下查询，以查看我们已插入  **data.sql** 文件中的数据

示例

```java
SELECT * FROM USERDATA;
```

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436135.png)

让我们仔细看一下控制台。我们看到  **TransactionManagement，DispatcherServlet，EntityManagerFactory，**和  **DataSource** 会自动配置，如下图所示。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436136.png)

## 调试自动配置

我们可以通过以下方法找到有关自动配置的更多信息: 使用以下两种方式:

打开调试日志记录使用Spring Boot执行器

**打开调试日志记录**

我们可以通过在  **application.properties** 中添加属性来调试日志记录文件。让我们在上面的示例中实现调试日志记录。打开  **application.properties** 文件并添加以下属性:

示例

```java
logging.level.org.springframework: DEBUG
```

现在重新启动应用程序。我们看到在日志中打印了一个自动配置报告。该报告包括所有自动配置的类。分为两部分:  **正向匹配**和  **负向匹配**，如下图所示。

**正向匹配**

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436137.png)

**否定匹配**

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436138.png)

**Spring Boot执行器**

我们还可以通过在项目中使用  **Actuator** 调试自动配置。我们还将添加  **HAL浏览器**，以简化操作。

让我们创建一个Spring Boot Actuator示例。

**步骤1:** 打开Spring Initializr http://start.spring.io 。

**步骤2:** 提供  **组**名称。我们提供了  **com.nhooo。**

**步骤3:** 提供  **工件** ID。我们提供了  **执行器自动配置示例。**

**步骤4:** 添加依赖项:  **Spring Web** 和  **Spring Boot Actuator。**

示例

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

**步骤5:** 单击  **Generate** (生成)按钮。它将与项目相关的所有规范绑定到一个  **jar** 文件中，并将其下载到我们的本地系统中。

**步骤6: 提取**下载的jar文件。

**步骤7: 使用以下步骤导入**项目文件夹:

文件->导入->现有Maven项目->下一步->浏览- >选择项目文件夹->完成

导入项目后，我们可以在IDE的  **Package Explorer** 部分中看到以下目录结构。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/0436139.png)

**步骤8:** 在包中创建Controller类  **com.nhooo。**我们创建了一个名为  **DemoRestController的控制器类。**

在Controller中，我们定义了一个名为  **hello( )**，它返回一个字符串。

**DemoRestController.java**

示例

```java
package com.nhooo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DemoRestController 
{
    @GetMapping("/hello")
    public String hello() 
    {
        return "Hello User, have a nice day.";
    }
}
```

**步骤9:** 运行  **ActuatorAutoConfigurationExampleApplication.java** 文件。

**步骤10:** 打开浏览器并调用URL  *http: //localhost: 8080/hello* 。它返回我们在控制器中指定的字符串。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/04361310.png)

现在调用执行器URL  *http: //localhost: 8080/actuator* 。它将启动显示以下三个URL的执行器:  **self** ，  **health** 和  **info** ，如下所示。

示例

```java
{"_links":{"self":{"href":"http://localhost:8080/actuator","templated":false},"health":{"href":"http://localhost:8080/actuator/health","templated":false},"health-path":{"href":"http://localhost:8080/actuator/health/{*path}","templated":true},"info":{"href":"http://localhost:8080/actuator/info","templated":false}}}
```

**步骤11:** 打开  **pom.xml** 文件并添加  **HAL浏览器**依赖项。

示例

```java
<dependency>
<groupId>org.springframework.data</groupId>
<artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```

**步骤12:** 再次，运行  **ActuatorAutoConfigurationExampleApplication.java** 文件。

要访问HAL浏览器，请键入  *http://localhost:8080* 在浏览器中，然后按Enter键。

![Spring Boot Auto-配置](https://www.cainiaojc.com/static/upload/210424/04361311.png)

现在我们可以通过HAL浏览器访问执行器。

在资源管理器的文本框中键入  **/actuator** ，然后单击  **Go** >按钮。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/04361312.png)

它显示了与执行器。执行器中最重要的是  **beans** 。

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/04361313.png)

当我们单击bean的箭头时，它会显示所有

![Spring Boot自动配置](https://www.cainiaojc.com/static/upload/210424/04361314.png)

以上该图显示了所有自动配置的  **beans** 的详细信息。

# SpringBoot Tomcat部署

在本节中，我们将学习如何在Tomcat Server上部署Spring Boot应用程序。

它包括三个步骤:

**设置Spring Boot应用程序****创建Spring Boot WAR****将WAR部署到Tomcat**

### 示例

让我们创建一个可在Tomcat上部署的Maven示例

**设置Spring Boot应用程序**

**步骤1:** 打开Spring Initializr http: //start.spring.io 。

**步骤2:** 提供 **Group** 名称。我们提供了 **com.nhooo。**

**步骤3:** 提供 **工件** ID。我们提供了 **spring-boot-war-deployment-example。**

**步骤4:** 添加 **Spring Web** 依赖项

示例

```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**步骤5:** 单击 **Generate** (生成)按钮。它包装了与项目相关的所有规范，并在我们的本地系统中下载了 **jar** 文件。

![使用Tomcat进行Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444560.png)

**步骤6: 提取** jar文件。

**步骤7: 导入**，请按照以下步骤操作:

文件->导入->现有Maven项目->下一步->浏览->选择项目文件夹->完成

导入项目后，我们可以在IDE的 **Package Explorer** 部分中看到以下目录结构。

![使用Tomcat进行Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444561.png)

**步骤8:** 在包 **com.nhooo** 中创建Controller类。我们创建了一个名为 **DemoRestController的类。**

在控制器类内部，我们定义了一个返回字符串的方法 **hello()**。

**DemoRestController.java**

示例

```java
package com.nhooo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DemoRestController 
{
@GetMapping("/hello")
public String hello() 
{
return "Hello User, have a nice day.";
}
}
```

**步骤9:** 作为Java应用程序运行 **SpringBootWarDeploymentExampleApplication.java** 文件。

**步骤10:** 打开浏览器并调用URL http: //localhost: 8080/hello。

![Spring Boot使用Tomcat进行项目部署](https://www.cainiaojc.com/static/upload/210424/0444562.png)

注意: 在进行下一步之前，请确保应用程序运行正常。

## 创建Spring Boot WAR

它利用了Spring Framework的Servlet 3.0支持，并允许我们在Servlet容器启动时配置应用程序。要创建用于部署的WAR，有 **三个**步骤:

在主类中扩展 **SpringBootServletInitializer** 类。将嵌入式servlet容器标记为**已提供**。将包装 **JAR** 更新为

让我们在应用程序中实现上述三个步骤。

**步骤11:** 打开 **SpringBootWarDeploymentExampleApplication.java** 文件并初始化Tomcat所需的Servlet上下文。为实现相同目的，扩展了 **SpringBootServletInitializer** 接口。

示例

```java
public class SpringBootWarDeploymentExampleApplication extends SpringBootServletInitializer
{
}
```

**步骤12:** 覆盖 **Configure** 方法。

示例

```java
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
{
return application.sources(SpringBootWarDeploymentExampleApplication.class);
}
```

**SpringBootWarDeploymentExampleApplication.java**

示例

```java
package com.nhooo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class SpringBootWarDeploymentExampleApplication extends SpringBootServletInitializer
{
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
{
return application.sources(SpringBootWarDeploymentExampleApplication.class);
}
public static void main(String[] args) 
{
SpringApplication.run(SpringBootWarDeploymentExampleApplication.class, args);
}
}
```

**步骤13:** 打开 **pom.xml** 文件，并将Servlet容器(Tomcat)标记为 **已提供**。

示例

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-tomcat</artifactId>
<scope>provided</scope>
</dependency>
```

**步骤14:** 我们需要部署 **WAR** 文件，因此在pom.xml文件中将包类型更改为WAR。

示例

```java
<packaging>war</packaging>
```

**步骤15:** 使用 标记修改最终的WAR文件名，以避免包含版本号。我们创建了一个名为 **web-services** 的WAR文件。

示例

```java
<finalName>web-services</finalName>
```

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>com.nhooo</groupId>
<artifactId>spring-boot-war-deployment-example</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>war</packaging>
<name>spring-boot-war-deployment-example</name>
<description>Demo project for Spring Boot</description>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.2.RELEASE</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
<properties>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
<java.version>1.8</java.version>
</properties>
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-tomcat</artifactId>
<scope>provided</scope>
</dependency>  
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
</dependencies>
<build>
<finalName>web-services</finalName>
 <plugins>
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
</plugins>     
</build>
</project>
```

要构建可部署Tomcat的WAR应用程序，我们执行maven clean包。之后，将在 **/target/abc.war** (其中将 **abc** 假定为Artifact Id)处生成我们的WAR文件。我们应该考虑到这种新设置使我们的Spring Boot Application成为 **非独立**应用程序。

**步骤16:** 创建 **WAR 文件":**



**右键单击项目-> Run As-> 5 Maven Build**

**![使用Tomcat进行Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444563.png)一个  \**Edit Configuration\** 对话框出现在屏幕上。\**第17步:\** 在  \**目标\**标签中编写  \**全新安装\**，然后检查  \**跳过测试\**。分别单击  \**应用\**和  \**运行\**按钮。![使用Tomcat进行Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444564.png)成功创建WAR文件后，它会显示  \**WAR文件路径\**和消息  \**BUILD SUCCESS\** 在控制台中，如下图所示。![使用Tomcat的Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444565.png)\**步骤18:\** 复制  \**路径\**并访问应用程序的  \**target\** 文件夹。我们在目标文件夹中找到了与pom.xml文件中指定的名称相同的WAR文件。在我们的实例中，路径为:示例`C:\Users\Anubhav\Documents\workspace-sts-3.9.9.RELEASE\spring-boot-war-deployment-example\target` ![使用Tomcat的Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444566.png)部署将WAR文件添加到Tomcat要部署WAR文件，请按照以下步骤操作:\**步骤19:\** 下载并安装  \**Apache Tomcat Server\** (如果未安装)。**



***\*步骤20:\** 复制WAR文件\**(web-services.war)\**并将其粘贴到webapps**文件夹。在我们的示例中，webapps文件夹的位置为:

示例

```java
C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps
```


![使用Tomcat的Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444567.png)

**步骤21:** 现在打开命令提示符并键入以下命令:

示例

```java
C:\Cd Program Files\Apache Software Foundation\Tomcat  8.5\bin
C:\Cd Program Files\Apache Software Foundation\Tomcat  8.5\bin>startup
```


![使用Tomcat的Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444568.png)

**启动**命令启动Tomcat服务器并部署WAR文件，如下所示。

![使用Tomcat的Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/0444569.png)

下图显示了WAR已成功部署。

![使用Tomcat进行Spring Boot项目部署](https://www.cainiaojc.com/static/upload/210424/04445610.png)

**步骤23:** 打开浏览器并调用URL http://localhost:8080/web-services/hello。它返回消息 **您好，用户好!**。

# SpringBoot AOP

该应用程序通常是多层开发的。典型的Java应用程序具有以下几层:

**Web层:** 它使用REST或Web应用程序公开**服务**。**业务层:** 它实现了应用程序的**业务逻辑**。**数据层:** 它实现了应用程序的**持久性逻辑**。

每层的职责不同，但是有一些适用于所有层的常见方面是 **日志记录，安全性，验证，缓存等**。这些常见方面被称为 **跨领域关注点。**

如果我们分别在每一层中实现这些关注点，则代码将变得更加难以维护。为了克服这个问题， **面向方面的编程**(AOP)提供了一种解决跨领域问题的解决方案。

将跨领域关注作为一个方面。定义切入点以指示必须在何处应用方面。

它确保跨领域关注点在一个内聚的代码组件中定义。

## AOP

AOP **(Aspect-Oriented Programming)**是一种通过允许 **跨领域关注点**分离来提高模块化的编程模式。这些跨部门关注点与主要业务逻辑不同。我们可以在不修改代码本身的情况下向现有代码添加其他行为。

Spring的AOP框架可帮助我们实现这些跨领域的关注。

使用AOP，我们在一个地方。我们可以自由定义应用此功能的方式和位置，而无需修改应用新功能的类。现在，可以将横切关注点模块化为特殊类，称为 **方面**。

方面有 **两个**的优点:

首先，每个关注点的逻辑现在都集中在一个地方，而不是分散在整个代码库中。其次，业务模块仅包含主要关注的代码。次要关注点已移至**方面**。

各个方面都有要执行的职责，称为 **Advice**。我们可以在一个或多个连接点将方面的功能实现到程序中。

## AOP的优点

它是用纯Java实现的。不需要特殊的编译过程。它仅支持方法执行连接点。仅提供运行时编织。有两种类型的AOP代理: **JDK动态代理**和 **CGLIB代理。**

## 跨领域关注点

跨领域关注点是我们要在应用程序中的多个位置实现的关注点。它会影响整个应用程序。

## AOP术语

- **Aspect:** 方面是一个模块，其中封装了**advice**和**pointcuts**，并提供**cross-cutting**可以有许多方面。我们可以使用带有 **@Aspect** 批注的常规类来实现方面。
- **Pointcut:** 切入点是一种表达式，它选择一个或多个执行Advice的连接点。我们可以使用**expressions**或**patterns**定义切入点。它使用与联接点匹配的不同类型的表达式。在Spring Framework中，使用 **AspectJ** 切入点表达语言。
- **Join point:** 连接点是应用程序中应用 **AOP方面**的点。或者它是Advice的特定执行实例。在AOP中，连接点可以是**方法执行，异常处理，更改对象变量值**等。
- **Advice:** Advice是我们在方法执行之前**before**或**after**采取的措施。该动作是在程序执行期间调用的一段代码。SpringAOP框架中有**五种**类型的Advice: **在Advicebefore, after, after-returning, after-throwing和**around advice。 是针对特定**join point的Advice。** 我们将在本节中进一步讨论这些Advice。
- **Target object:** 一个应用了Advice的对象称为**target object**。目标对象始终是**proxied**，这意味着在运行时将创建一个覆盖目标方法的子类，并根据其配置包含Advice。
- **Weaving:** 这是将各个方面与其他应用程序类型进行**linking aspects**的过程。我们可以在**运行时，加载时间**和**编译时**进行织造。

**Proxy:** 它是在将Advice应用于目标对象后创建的对象，称为 **proxy** 。 Spring AOP实现了 **JDK动态代理**，以使用目标类和Advice调用创建代理类。这些称为AOP代理类。

## AOP与OOP

AOP与OOP之间的区别如下:

| AOP                                                  | OOP                                                    |
| ---------------------------------------------------- | ------------------------------------------------------ |
| **Aspect:** 一个封装切入点，Advice和属性的代码单元。 | **Class:** 一个封装方法和属性的代码单元。              |
| **Pointcut:** 它定义了执行Advice的一组入口点。       | **Method signature:** 。它定义了执行方法主体的入口点。 |
| **Advice:** 这是跨领域关注点的实现。                 | **Method bodies:** 是业务逻辑问题的实现。              |
| **Waver: 借助Advice构造代码(源或对象)。**            | **Compiler: 它将源代码转换为目标代码。**               |

![Spring Boot AOP](https://www.cainiaojc.com/static/upload/210424/0447010.png)

## Spring AOP与AspectJ

AOP和OOP之间的区别如下:

| Spring AOP                                 | AspectJ                                                  |
| ------------------------------------------ | -------------------------------------------------------- |
| 需要单独的编译过程。                       | 它需要AspectJ编译器。                                    |
| 它仅支持方法执行切入点。                   | 它支持所有切入点。                                       |
| 它可以在Spring Container管理的bean上实现。 | 它可以在所有域对象上实现。                               |
| 它仅支持方法级编织。                       | 它可以波动字段，方法，构造函数，静态初始化器，最终类等。 |

## AOP Advice的类型

AOP Advice有五种类型，如下所示:

Before AdviceAfter AdviceAround AdviceAfter ThrowingAfter Returning

**Before Advice:** 在连接点之前执行的Advice在通知之前被调用。我们使用 **@Before** 批注将Advice标记为Before通知。

**After Advice:** 在连接点之后执行的Advice被称为after notification。我们使用 **@After** 注解将Advice标记为After通知。

**Around Advice:** 在连接点之前和之后执行的Advice是

**After Throwing:** 在连接点抛出异常时执行的Advice。

**After Returning:** 当方法成功执行时执行的Advice。

在应用程序中实现AOP之前，我们需要在pom.xml文件中添加 **Spring AOP** 依赖项。

## Spring Boot Starter AOP

Spring Boot Starter AOP是提供Spring AOP和AspectJ的依赖项。 AOP提供基本的AOP功能，而AspectJ提供完整的AOP框架。

示例

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-aop</artifactId>
<version>2.2.2.RELEASE</version>
</dependency>
```

在下一节中，我们将在应用程序中实现不同的Advice。

------

[SpringBoot AOP @Before注解说明和示例](https://www.cainiaojc.com/springboot/springboot-aop-before-advice.html)[SpringBoot AOP @After注解说明和示例](https://www.cainiaojc.com/springboot/springboot-aop-after-advice.html)[SpringBoot AOP @Around注解说明和示例](https://www.cainiaojc.com/springboot/springboot-aop-around-advice.html)[SpringBoot AOP @AfterReturning注解说明和示例](https://www.cainiaojc.com/springboot/springboot-aop-after-returning-advice.html)[SpringBoot AOP @AfterThrowing注解说明和示例](https://www.cainiaojc.com/springboot/springboot-aop-after-throwing-advice.html)

# Spring Boot JPA

## 什么是JPA？

**Spring Boot JPA** 是用于管理的Java规范Java应用程序中的**关系**数据。它允许我们访问和持久化Java对象/类与关系数据库之间的数据。 JPA遵循**对象关系映射**(ORM)。它是一组接口。它还提供了运行时 **EntityManager** API，用于处理针对数据库对象的查询和事务。它使用与平台无关的面向对象的查询语言JPQL(Java持久查询语言)。

在持久性方面，它涵盖了三个领域:

Java持久性API**Object-Relational**元数据在 **persistence** 包中定义的API本身

JPA不是框架。它定义了可以在任何框架中实现的概念。

## 为什么我们应该使用JPA？

与JDBC相比，JPA更简单，更清洁且劳动强度更低，SQL和手写映射。 JPA适用于非性能导向的复杂应用程序。与JDBC相比，JPA的主要优点在于，在JPA中，数据由对象和类表示，而在JDBC中，数据由表和记录表示。它使用POJO表示持久数据，从而简化了数据库编程。 JPA还有其他优点:

JPA避免使用SQL的特定于数据库的方言编写DDL。取而代之的是，它允许以XML或使用Java注解进行映射。JPA允许我们避免用SQL的数据库专用方言编写DML。JPA允许我们完全不使用任何DML语言来保存和加载Java对象和图形。当我们需要执行查询JPQL时，它允许我们用Java实体而不是(本机)SQL表和列来表达查询。

## JPA功能

JPA具有以下功能:

这是一个功能强大的存储库和自定义的**对象映射抽象。**它支持**跨商店持久性**。这意味着一个实体可以部分存储在MySQL和Neo4j(图形数据库管理系统)中。它从查询方法名称动态生成查询。域基类提供基本属性。它支持透明审核。集成自定义存储库代码的可能性。通过自定义名称空间很容易与Spring Framework集成。

## JPA体系结构

JPA是将业务实体存储为关系实体的源。它显示了如何将POJO定义为实体以及如何通过关系管理实体。

下图描述了JPA的类级别体系结构，该体系结构描述了JPA的核心类和接口。 **javax持久性**包。 JPA体系结构包含以下单元:

**Persistence:** 这是一个包含用于获取EntityManagerFactory实例的静态方法的类。**EntityManagerFactory:** 是EntityManager的工厂类。它创建和管理EntityManager的多个实例。**EntityManager:** 。它是一个界面。它控制对对象的持久性操作。它适用于Query实例。**Entity**: 实体是作为记录存储在数据库中的持久性对象。**Persistence Unit:** 它定义了一组所有实体类。在应用程序中，EntityManager实例对其进行管理。一组实体类表示包含在单个数据存储中的数据。**EntityTransaction:** 它与EntityManager类具有**一对一**关系。对于每个EntityManager，操作都由EntityTransaction类维护。**Query:** 该接口由每个JPA供应商实现，以获取符合条件的关系对象。![Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447160.png)

## JPA类关系

我们上面讨论的类和接口保持一种关系。下图显示了类和接口之间的关系。

![Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447161.png)EntityManager和EntiyTransaction之间的关系是**一对一**。每个EntityManager操作都有一个EntityTransaction实例。EntityManageFactory和EntiyManager之间的关系是**一对多**。这是EntityManager实例的工厂类。EntityManager和Query之间的关系是**一对多**。我们可以使用EntityManager类的实例执行任意数量的查询。EntityManager和Entity之间的关系是**一对多**。 EntityManager实例可以管理多个实体。

## JPA实现

JPA是一种开源API。有各种企业供应商，例如Eclipse，RedHat，Oracle等，通过在其中添加JPA来提供新产品。有一些流行的JPA实现框架，例如 **Hibernate，EclipseLink，DataNucleus** 等。它也称为**对象关系映射**(ORM)工具。

## 对象关系映射(ORM)

在ORM中，Java对象到数据库表的映射(反之亦然)被称为**对象关系映射。** ORM映射充当**关系数据库**(表和记录)和 **Java应用程序**(类和对象)之间的桥梁。

在下面如图所示，ORM层是适配器层。它将对象图的语言适应SQL和关系表的语言。

![Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447162.png)

ORM层存在于应用程序和数据库之间。它转换Java类和对象，以便可以在关系数据库中存储和管理它们。默认情况下，持久化的名称将成为表的名称，而字段将成为列。一旦应用程序建立，每个表行都对应一个对象。

## JPA版本

EJB的早期版本定义了与业务逻辑层结合的持久层。使用 **javax.ejb.EntityBean** 接口。 EJB规范包括JPA的定义。

在引入EJB 3.0时，持久层被分离并指定为JPA 1.0(Java Persistence API)。该API的规范已与2006年5月11日使用JSR 220的JAVA EE5规范一起发布。

2019年，JPA重命名为 **Jakarta Persistence** 。 JPA的最新版本是 **2.2** 。它支持以下功能:

Java 8，数据和时间APIAttributeConvertes中的CDI注入它使注解@Repeatable

## JPA和Hibernate之间的区别

**JPA:** JPA是一种Java规范，用于访问，管理和持久化之间的数据Java对象和关系数据库。这是ORM的标准方法。

**Hibernate:** 这是一种轻量级的开源ORM工具，用于在关系数据库系统中存储Java对象。它是JPA的提供者。它遵循JPA提供的一种通用方法。

下表描述了JPA和Hibernate之间的区别。

| JPA                                                          | Hibernate                                                |
| ------------------------------------------------------------ | -------------------------------------------------------- |
| JPA是用于在Java应用程序中映射关系数据的 **Java规范**。       | Hibernate是一个用于处理数据持久性的 **ORM框架**。        |
| JPA不提供任何实现类。                                        | 它提供了实现类。                                         |
| 它使用称为 **JPQL** (Java持久性查询语言)的平台无关的查询语言。 | 它使用自己的称为 **HQL** 的查询语言(Hibernate查询语言)。 |
| 它在 **javax.persistence** 包中定义。                        | 它在 **org.hibernate** 包中定义。                        |
| 它在 **Hibernate，EclipseLink** 等各种ORM工具中实现。        | Hibernate是JPA的**提供者**。                             |
| JPA使用 **EntityManager** 处理数据的持久性。                 | 在Hibernate中，使用 **Session** 处理数据的持久性。       |

## Spring Boot启动程序数据JPA

Spring Boot提供了启动程序依赖项 **spring-boot-starter-data-jpa** 以连接Spring Boot应用程序高效地使用关系数据库。 spring-boot-starter-data-jpa在内部使用spring-boot-jpa依赖项。

示例

```java
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-data-jpa</artifactId>  
<version>2.2.2.RELEASE</version>  
</dependency>
```

## Spring Boot JPA示例

我们创建一个使用JPA连接到数据库的Spring Boot应用程序。在下面的示例中，我们使用了内存数据库 **Apache Derby。**

**Apache Derby** : 这是一个嵌入式的**开源软件**关系数据库完全用Java实现。它在Apache License 2.0下可用。 Apache Derby具有以下优点:

易于安装，部署和使用。它基于Java，JDBC和SQL标准。它提供了一个嵌入式JDBC驱动程序，可让我们将Derby嵌入任何基于Java的解决方案中。它还通过Derby Network Client JDBC驱动程序和Derby Network Server支持客户机/服务器模式。

Spring Boot可以自动配置嵌入式数据库，例如 **H2，HSQL，**和 **Derbydatabases** 。我们不需要提供任何连接URL。我们只需要包含要使用的嵌入式数据库的构建依赖项即可。

在Spring Boot中，只需在pom中添加 **Derby** 依赖项即可轻松集成Apache Derby数据库。 xml文件。

示例

```java
<dependency>
<groupId>org.apache.derby</groupId>
<artifactId>derby</artifactId>
<scope>runtime</scope>
</dependency>
```

**步骤1:** 打开Spring Initializr https://start.spring.io/。

**步骤2:** 选择最新版本的Spring Boot **2.3.0(SNAPSHOT)**

**步骤3:** 提供**Group**名称。我们已经提供了 **com.nhooo。**

**步骤4:** 提供**Artifact** ID。我们提供了 **apache-derby-example** 。

**步骤5:** 添加依赖项: **Spring Web，Spring Data JPA**和 **Apache Derby数据库**。

**步骤6:** 单击 **Generate** (生成)按钮。当我们单击"生成"按钮时，它会将项目包装到一个Jar文件中，并将其下载到本地系统。

![ Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447163.png)

**步骤7: 提取** Jar文件并将其粘贴到STS工作区中。

**步骤8: 导入**

文件->导入->现有Maven项目->浏览->选择文件夹apache-derby-example->完成

导入需要一些时间。

**步骤9:** 在文件夹 **src/main/java**中创建一个名称为 **com.nhooo.model** 的包。

**步骤10:** 在包 **com.nhooo.model** 中创建一个名称为 **UserRecord** 的类，然后执行以下:

定义三个变量 **id, name, and email**。生成Getter和Setter。
右键单击文件-> Source-> Generate Getter和Setters定义默认的构造函数。使用注解 **@Entity将类标记为\**Entity\**。**使用注解 **@Id将 \**Id\** 标记为主键。**

**UserRecord.java**

示例

```java
package com.nhooo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity  
public class UserRecord 
{ 
@Id  
private int id;  
private String name;  
private String email;
//default conatructor  
public UserRecord()
{
}  
public int getId() 
{  
return id;  
}  
public void setId(int id) 
{  
this.id = id;  
}  
public String getName() 
{  
return name;  
}  
public void setName(String name) 
{  
this.name = name;  
}  
public String getEmail() 
{  
return email;  
}  
public void setEmail(String email) 
{
this.email = email;  
}  
}
```

**步骤11:** 在 **src/main/java文件夹中创建一个名称为 \**com.nhooo.controller\** 的包。**

**步骤12:** 在包 **com.nhooo.controller** 中创建一个名称为 **UserController** 的Controller类，并执行以下操作:

使用注解 **@RestController** 将类标记为控制器。使用注解 **@Autowired** 自动连接类 **UserService** 。我们定义了两个映射，一个映射用于**获取所有用户**，另一个映射用于**添加用户。**

**UserController.java**

示例

```java
package com.nhooo.controller;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;
import com.nhooo.model.UserRecord;
import com.nhooo.service.UserService;
import java.util.List;  
@RestController  
public class UserController 
{  
@Autowired  
private UserService userService;   
@RequestMapping("/")  
public List<UserRecord> getAllUser()
{  
return userService.getAllUsers();  
}     
@RequestMapping(value="/add-user", method=RequestMethod.POST)  
public void addUser(@RequestBody UserRecord userRecord)
{  
userService.addUser(userRecord);  
}     
}
```

**步骤13:** 在文件夹 **src/main/java中创建一个名称为 \**com.nhooo.service\** 的包。**

**步骤14:** 在包 **com.nhooo.service** 中创建名称为 **UserController** 的Service类，并执行以下操作:

通过使用注解 **@Service**将该类标记为服务。自动连接 **UserRepository**定义方法 **getAllUsers()**，该方法返回以下列表:定义另一个方法名称 **addUser()**，以保存用户记录。

**UserService.java**

示例

```java
package com.nhooo.service;  
import java.util.List;  
import java.util.ArrayList;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import com.nhooo.model.UserRecord;
import com.nhooo.repository.UserRepository;  
@Service  
public class UserService 
{  
@Autowired  
private UserRepository userRepository;  
public List<UserRecord> getAllUsers()
{  
List<UserRecord>userRecords = new ArrayList<>();  
userRepository.findAll().forEach(userRecords::add);  
return userRecords;  
}  
public void addUser(UserRecord userRecord)
{  
userRepository.save(userRecord);  
}  
}
```

**步骤15:** 在文件夹 **src/main/java**中创建一个名称为 **com.nhooo.repository** 的包。

**步骤16:** 在包 **com.nhooo.repository** 中创建名称为 **UserRepository** 的存储库接口，并扩展 **CrudRepository** 。

**UserRepository.java**

示例

```java
package com.nhooo.repository;  
import org.springframework.data.repository.CrudRepository;
import com.nhooo.model.UserRecord;  
public interface UserRepository extends CrudRepository<UserRecord, String> 
{  
}
```

**步骤17:** 现在，打开 **ApacheDerbyExampleApplication.java** 文件。它是在我们设置应用程序时默认创建的。

**ApacheDerbyExampleApplication.java**

示例

```java
package com.nhooo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ApacheDerbyExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(ApacheDerbyExampleApplication.class, args);
}
}
```

现在，我们已根据要求设置了所有必需的类和程序包。请注意，我们没有为数据库提供任何**连接URL** 。完成上述所有步骤后，项目目录如下所示:

![Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447164.png)

让我们运行该应用程序。

**步骤18:** 打开 **ApacheDerbyExampleApplication.java** 文件并将其作为Java应用程序运行。

**第19步:** 打开浏览器并调用URL http://localhost:8080/。由于未在列表中添加任何用户，因此返回空列表。

要将用户添加到数据库，我们将使用**发送 \**POST\** 请求Postman**。

**步骤20:** 打开**Postman**，然后执行以下操作:

选择 **POST**调用URL http://localhost:8080/add-user。点击**Body**选择Content-Type作为**JSON** (application/json)。将要插入的数据插入数据库中。我们插入了以下数据:

示例

```java
{
"id": "001",
"name": "Tom",
"email": "tom@gmail.com"
}
```

点击**发送**按钮。![Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447165.png)

当我们单击"发送"按钮时，它显示**状态: 200 OK** 。这表示请求已成功执行。

**步骤21:** 打开浏览器并调用URL http: //localhost: 8080。它返回我们已插入数据库中的用户。

![Spring Boot jpa](https://www.cainiaojc.com/static/upload/210424/0447166.png)

------

[SpringBoot JDBC](https://www.cainiaojc.com/springboot/springboot-jdbc.html)[SpringBoot JDBC示例](https://www.cainiaojc.com/springboot/springboot-jdbc-example.html)[SpringBoot 增删改查示例](https://www.cainiaojc.com/springboot/springboot-crud-operations.html)[SpringBoot H2数据库说明和示例](https://www.cainiaojc.com/springboot/springboot-h2-database.html)

# SpringBoot Thymeleaf

## 什么是Thymeleaf？

**Thymeleaf** 是一个开源Java库根据 **Apache许可2.0** 获得许可。这是一个 **HTML5/XHTML/XML** 模板引擎。它是用于Web(基于Servlet)和非Web(离线)环境的 **服务器端Java模板**引擎。对于现代HTML5 JVM Web开发而言，它是完美的选择。它提供了与Spring Framework的完全集成。

它对模板文件应用了一组转换，以显示应用程序生成的数据或文本。适合在Web应用程序中提供XHTML/HTML5。

Thymeleaf的目标是提供一种 **时尚**和 **格式良好**的模板创建方式。它基于XML标签和属性。这些XML标记定义了DOM(文档对象模型)上预定义逻辑的执行，而不是将该逻辑作为模板中的代码显式编写。它代替了 **JSP** 。

Thymeleaf的体系结构允许对模板进行 **快速** **处理**，具体取决于缓存解析的文件。它在执行过程中使用了最少的I/O操作。

## 为什么我们使用Thymeleaf？

JSP或多或少类似于HTML。但是它与Thymeleaf等HTML并不完全兼容。我们可以在浏览器中正常打开和显示Thymeleaf模板文件，而JSP文件则不能。

Thymeleaf支持像Spring EL这样的变量表达式($ {...})并在模型属性，星号表达式上执行(* {...})在表单支持bean上执行，哈希表达式(#{...})用于国际化，链接表达式(@{......))重写URL。

像JSP一样，Thymeleaf可以很好地用于Rich HTML电子邮件。

## Thymeleaf可以处理哪种模板？

Thymeleaf可以处理六种类型的模板(也称为" **模板模式**)如下:

XML有效的XMLXHTML有效的XHTMLHTML5旧版HTML5

除了旧版HTML5模式外，上述所有模式均引用 **定义明确的XML** 文件。它使我们能够处理具有独立标签，没有值的标签属性或未在引号之间写入等功能的HTML5文件。

要以这种特定模式处理文件，Thymeleaf会执行转换，将文件转换为 **格式良好的XML** 文件(有效的HTML5文件)。

注意: 在Thymeleaf中，验证仅适用于XHTML和XML模板。

Thymeleaf还允许我们通过指定两种在此模式下解析模板的方式来定义自己的模式。这样，Thymeleaf可以有效地将任何可以建模为DOM树的模型作为模板进行处理。

## 标准方言

Thymeleaf是模板引擎允许我们定义DOM节点的框架。在模板中处理的DOM节点。

将逻辑应用于DOM节点的对象称为 **处理器**。一组处理器以及一些额外的工件称为 **方言**。包含Thymeleaf核心库的方言称为 **标准方言。**

如果我们想在利用库的高级功能的同时定义自己的处理逻辑，则可以定义自己的方言。自己的方言。在模板引擎中，我们可以一次配置多个方言。

Thymeleaf集成包(thymeleaf-spring3和thymeleaf-spring4)定义了一个称为 **SpringStandard Dialect** 的方言。标准方言和SpringStandard几乎相同。但是标准方言有一些小的变化，可以更好地利用Spring框架中的某些功能。

例如，使用Spring Expression Language代替Thymeleaf的标准ONGL(对象图导航语言)。

标准方言可以以任何方式处理模板。但是，它非常适合面向Web的模板模式(HTML5和XHTML)。它支持并验证以下XHTML规范:

XHTML 1.0过渡版严格的XHTML 1.0XHTML 1.0框架集XHTML 1.1。

标准方言处理器是一种属性处理器，它允许浏览器在处理之前显示HTML5/XHTML模板文件。这是因为它们忽略了其他属性。

例如，当JSP文件使用标签库时，它包含一段代码，这些代码无法由以下浏览器显示:

示例

```java
<form:inputText name="student.Name" value="${student.name}" />
```

Thymeleaf标准方言允许我们使用以下代码实现相同的功能。

示例

```java
<input type="text" name=" student Name" value="Thomas" th:value="${student.name}" />
```

上面的代码还允许我们在其中定义 **value** 属性( **Thomas** )。在浏览器中打开原型时，将显示该值。在模板的Thymeleaf处理过程中，该属性将由对 **$ {student.name}** 的求值得出的值代替。

它允许设计人员和开发人员进行处理。相同的模板文件，减少了将静态原型转换为工作模板文件所需的工作。它称为 **自然模板**。

## Thymeleaf特征

它既可以在网络环境中使用，也可以在非网络环境中使用。用于HTML5/XML/XHTML的Java模板引擎。其高性能的解析模板缓存将I/O降至最低。如果需要，它可以用作模板引擎框架。它支持几种模板模式: XML，XHTML和HTML5。它允许开发人员扩展和创建自定义方言。它基于称为方言的模块化功能集。它支持国际化。

## Thymeleaf实现

我们可以通过在应用程序的pom.xml中添加  **spring-boot-starter-thymeleaf** 依赖项来实现Thymeleaf模板引擎文件。 Spring Boot将模板引擎配置为从  **/resource/templates中读取模板文件。**

示例

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

## Spring Boot Thymeleaf示例

我们创建一个Spring Boot应用程序并实现Thymeleaf模板。

**步骤1:** 打开Spring Initializr http://start.spring.io 。

**步骤2:** 选择Spring Boot版本  **2.3.0.M1。**

**步骤2:** 提供  **组**名称。我们提供了  **com.nhooo** 。

**步骤3:** 提供  **工件** ID。我们提供了  **spring-boot-thymeleaf-view-example。**

**步骤5:** 添加依赖项  **Spring Web** 和  **Thymeleaf**。

**步骤6:** 单击  **Generate** (生成)按钮。当我们单击"生成"按钮时，它将规格包装在  **Jar** 文件中，并将其下载到本地系统。

![Spring Boot thymeleaf视图](https://www.cainiaojc.com/static/upload/210424/0451170.png)

**第7步: 提取** Jar文件并将其粘贴到STS工作区中。

**步骤8: 导入** STS中的项目文件夹。

文件->导入->现有Maven项目->浏览->选择文件夹spring-boot-thymeleaf-view-example->完成

导入需要一些时间。

**步骤9:** 在包  **com.nhooo** 中创建类。我们创建了一个名为  **User的类。**

在该类中，我们定义了两个变量  **name** 和  **email** 并生成  **Getter和Setters。**

**User.java**

示例

```java
package com.nhooo;  
public class User 
{  
String name;  
String email;  
public String getName() 
{  
return name;  
}  
public void setName(String name) 
{  
this.name = name;  
}  
public String getEmail() 
{  
return email;  
}  
public void setEmail(String email) 
{  
this.email = email;  
}  
}
```

**步骤10:** 创建控制器类。我们创建了一个名为  **DemoController** 的控制器类。

**DemoController.java**

示例

```java
package com.nhooo;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.stereotype.Controller;  
@Controller  
public class DemoController 
{  
@RequestMapping("/")  
public String index()
{  
return"index";  
}  
@RequestMapping(value="/save", method=RequestMethod.POST)  
public ModelAndView save(@ModelAttribute User user)
{  
ModelAndView modelAndView = new ModelAndView();  
modelAndView.setViewName("user-data");      
modelAndView.addObject("user", user);    
return modelAndView;  
}  
}
```

下一步，我们将创建Thymeleaf模板。

**步骤11:** 在  **模板内部**(src/main/resources/模板)文件夹中，创建一个名称为  **user-data** 的Thymeleaf模板。

右键单击模板文件夹->新建->其他-> HTML文件->下一步->提供文件名->完成

注意: 不要忘记在模板文件中实现以下内容。

示例

```java
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```

**user-data.html**

示例

```java
<html xmlns:th="https://thymeleaf.org">  
<table>  
<tr>  
<td><h4>User Name: </h4></td>  
<td><h4 th:text="${user.name}"></h4></td>  
</tr>  
<tr>  
<td><h4>Email ID: </h4></td>  
<td><h4 th:text="${user.email}"></h4></td>  
</tr>  
</table>  
</html>
```

**步骤12:** 类似地，在文件夹模板中创建一个  **HTML** 文件。我们创建了一个名为  **index** 的HTML文件。

**index.html**

示例

```java
<html lang="en">  
<head>  
<title>Index Page</title>  
</head>  
<body>  
<form action="save" method="post">  
<table>  
<tr>  
<td><label for="user-name">User Name</label></td>  
<td><input type="text" name="name"></input></td>  
 </tr>  
<tr>  
<td><label for="email">Email</label></td>  
<td><input type="text" name="email"></input></td>  
</tr>  
<tr>  
<td></td>  
<td><input type="submit" value="Submit"></input></td>  
</tr>  
</table>  
</form>  
</body>  
</html>
```

**步骤13:** 打开  **application.properties** 文件并在其中添加以下属性。

**application.properties**

示例

```java
spring.thymeleaf.cache=false
spring.thymeleaf.suffix: .html
```

创建所有文件，文件夹和包后，项目目录如下所示:

![Spring Boot thymeleaf视图](https://www.cainiaojc.com/static/upload/210424/0451171.png)

让我们运行应用程序。

**步骤14:** 打开  **SpringBootThymeleafViewExampleApplication.java** 文件并以Java应用程序。

**SpringBootThymeleafViewExampleApplication.java**

示例

```java
package com.nhooo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootThymeleafViewExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootThymeleafViewExampleApplication.class, args);
}
}
```

**步骤15:** 现在，打开浏览器并调用URL http://localhost:8080。它显示输出，如下所示。

![Spring Boot thymeleaf视图](https://www.cainiaojc.com/static/upload/210424/0451172.png)

提供  **用户名**和  **电子邮件**，然后单击  **提交**按钮。

![Spring Boot百里香视图](https://www.cainiaojc.com/static/upload/210424/0451173.png)

点击  **提交**按钮，URL更改为http://localhost: 8080/save并显示显示用户数据，如下所示。

![Spring Boot thymeleaf视图](https://www.cainiaojc.com/static/upload/210424/0451174.png)

在本节中，我们讨论了Thymeleaf视图。如果要使视图更具吸引力，可以添加  **CSS** 和  **JS** 文件。这些文件必须位于  **src/main/resources/static** 文件夹下。

# Spring Boot缓存

Spring框架透明地在Spring应用程序中提供缓存。在Spring中，**缓存抽象**是一种机制，它允许在不影响代码的情况下一致使用各种缓存方法。

## 缓存抽象

缓存抽象机制适用于 **Java 方法**。使用缓存抽象的主要目的是根据缓存中存在的信息**减少**执行次数。它适用于昂贵的方法，例如 **CPU** 或 **IO绑定。**

每次调用方法时，抽象都会将缓存行为应用于该方法。它检查该方法是否已经针对给定参数执行。

如果是，则不执行实际方法就返回缓存的结果。如果否，则首先执行该方法，并将结果缓存并返回给用户。

注意: 此方法仅适用于保证为给定输入返回相同结果的方法。该方法执行多少次并不重要。

开发人员在处理缓存抽象时会注意两件事。

**缓存声明**: 它标识需要缓存的方法。**缓存配置:** 用于存储和读取数据的后备缓存。

### 缓存

缓存是临时内存的一部分( RAM )。它位于应用程序和持久性数据库之间。它存储最近使用的数据，从而尽可能减少数据库命中次数。换句话说，缓存是为了存储数据以供将来参考。

## 为什么要使用缓存？

使用缓存的主要原因是为了进行数据访问更快，更便宜。当多次请求高度请求的资源时，对于开发人员来说，缓存资源通常是有益的，这样它可以快速给出响应。在应用程序中使用缓存可以增强应用程序的性能。与从数据库中获取数据相比，从内存进行数据访问总是更快。它降低了货币成本和机会成本。

## 应缓存哪些数据？

不经常更改的数据。经常使用的读取查询，其查询结果在每个调用中至少一段时间没有变化。

## 缓存类型

有**四种**缓存类型如下:

内存中缓存数据库缓存Web服务器缓存CDN缓存

### 内存缓存

内存缓存可提高应用程序的性能。这是经常使用的区域。 **Memcached** 和 **Redis** 是内存中缓存的示例。它在应用程序和数据库之间存储键值。 Redis是一种**内存中，分布式**高级缓存工具，可用于备份和还原功能。我们还可以管理分布式集群中的缓存。

### 数据库缓存

数据库缓存是一种通过获取数据按需(动态)生成网页的机制。从数据库中。它在涉及客户端，Web应用程序服务器和数据库的**多层**环境中使用。通过分配查询工作负载，它提高了**可扩展性**和**性能**。最受欢迎的数据库缓存是 Hibernate 的一级缓存。

### Web服务器缓存

Web服务器缓存是一种存储数据以便**重用**的机制。例如，由Web服务器提供的网页的副本。用户首次访问该页面时将对其进行缓存。如果用户下次再次请求相同的内容，则缓存将提供页面的副本。这样可以避免服务器表单过载。 Web服务器缓存可提高页面交付速度，并减少后端服务器要做的工作。

### CDN缓存

**CDN** 代表**内容交付网络**。它是现代Web应用程序中使用的组件。通过**复制**常用文件(例如 HTML 页面，样式表)，它可以改善内容的传递。 ， JavaScript ，图像，视频等)分布在一组全球分布的**缓存服务器上。**

这是CDN越来越受欢迎的原因。 CDN减轻了应用程序源的负担，并改善了用户体验。它从附近的**缓存边缘**(更靠近最终用户的缓存服务器)或**存在点(PoP)**提供内容的本地副本。

## 缓存与缓冲区

| 缓存                       | 缓冲区                        |
| -------------------------- | ----------------------------- |
| 缓存基于**最近最少使用**。 | 缓冲区基于**先进先出**        |
| 它是页面缓存的大小。       | 它是内存中的原始块I/O缓冲区。 |
| 它生存了**很长**时期。     | 它生存了**短**时期。          |
| 我们**从缓存中读取**。     | 我们**写入**到缓冲区。        |
| 它存储**实际**文件数据。   | 它存储文件**元数据**。        |
| 它提高了 **read** 性能。   | 它提高了**写入**性能。        |

## Spring Boot缓存注解

### @EnableCaching

这是一个类级别的注解。我们可以通过使用 **@EnableCaching注解在Spring Boot应用程序中启用缓存。**它在 **org.springframework.cache.annotation** 包中定义。它与 **@Configuration** 类一起使用。

如果没有已定义的CacheManager实例，自动配置将启用缓存并设置 **CacheManager** 。它会扫描特定的提供程序，如果找不到，则会使用并发的 **HashMap创建内存中缓存。**

**示例**

在以下示例中， **@EnableCaching** 注解启用了缓存机制。

示例

```java
@SpringBootApplication
@EnableCaching 
public class SpringBootCachingApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootCachingApplication.class, args);
}
}
```

### @CacheConfig

这是一个类级别的注解，提供了与缓存有关的通用设置。它告诉Spring将类的缓存存储在何处。当我们使用注解为类添加注解时，它为该类中定义的任何缓存操作提供了一组默认设置。使用注解，我们不需要多次声明。

**示例**

在下面的示例中，**员工**是缓存的名称。

示例

```java
@CacheConfig(cacheNames={"employee"}) 
public class UserService
{
//some code
}
```

### @Caching

当我们同时需要两个注解 **@CachePut** 或 **@CacheEvict** 时使用同样的方法。换句话说，当我们要使用相同类型的多个注解时使用。

但是 **Java不允许为给定声明相同类型的多个注解**方法。为避免此问题，我们使用 **@Caching** 注解。

**示例**

在下面的示例中，我们使用了注解 **@Caching** 并将所有 **@CacheEvict** 注解分组。

示例

```java
@Caching(evict = {@CacheEvict("phone_number"), @CacheEvict(value="directory", key="#student.id") })public String getAddress(Student student) 
{
//some code
}
```

### @Cacheable

它是方法级别的注解。它为方法的返回值定义了一个缓存。 Spring框架管理方法对注解属性中指定的缓存的请求和响应。 @Cacheable批注包含更多选项。例如，我们可以使用 **value** 或 **cacheNames** 属性提供**缓存名称**。

我们还可以指定注解的 **key** 属性，用于唯一标识缓存中的每个条目。如果未指定密钥，Spring将使用默认机制来创建密钥。

**示例**

在以下示例中，我们缓存了< **cacheStudentInfo，**和 **id** 中方法 **studentInfo()**的strong>返回值是唯一键，用于标识缓存。

示例

```java
@Cacheable(value="cacheStudentInfo", key="#id")public List studentInfo()
{
//some code 
return studentDetails;
}
```

我们还可以通过使用condition属性在注解中应用条件。当我们在注解中应用条件时，它称为**条件缓存**。

例如，如果参数名称的长度短于20，则将缓存以下方法。

示例

```java
@Cacheable(value="student", condition="#name.length<20")public Student findStudent(String name)
{
//some code
}
```

### @CacheEvict

它是方法级别的注解。当我们想要从缓存中删除陈旧或未使用的数据时，将使用它。它需要一个或多个受操作影响的缓存。我们还可以在其中指定键或条件。如果我们想要广泛的缓存驱逐，则@CacheEvict批注提供一个名为 **allEntries** 的参数。它会驱逐所有条目，而不是根据密钥驱逐一个条目。

关于@CacheEvict批注的重要一点是它可以与void方法一起使用，因为该方法充当触发器。它避免了返回值。另一方面，@Cacheable批注需要一个返回值，该值用于添加/更新缓存中的数据。我们可以通过以下方式使用@CacheEvict批注:

逐出整个缓存:

示例

```java
@CacheEvict(allEntries=true)
```

通过密钥逐出条目:

示例

```java
@CacheEvict(key="#student.stud_name")
```

**示例**

以下带注解的方法从缓存 **student_data** 中清除所有数据。

示例

```java
@CacheEvict(value="student_data", allEntries=true) //removing all entries from the cache
public String getNames(Student student) 
{
//some code
}
```

### @CachePut

它是方法级别的注解。当我们想要**更新**缓存而不干扰方法执行时，使用它。这意味着该方法将始终执行，并将其结果放入缓存中。它支持@Cacheable批注的属性。

需要注意的是，由于@Cacheable和@CachePut批注的行为不同，因此它们是不相同的。 @Cacheable和@CachePut批注之间存在细微差别，就是@ **Cacheable** 批注**跳过方法执行**，而 **@CachePut** 批注**运行该方法**，然后将结果放入缓存。

**示例**

以下方法将更新缓存本身。

示例

```java
@CachePut(cacheNames="employee", key="#id")  //updating cachepublic Employee updateEmp(ID id, EmployeeData data)
{
//some code
}
```

## Spring Boot缓存依赖项

如果要在Spring Boot应用程序中启用缓存机制，则需要在pom.xml文件中添加缓存依赖项。它启用缓存并配置CacheManager。

示例

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

## Spring Boot缓存示例

我们创建一个Spring Boot应用程序并在其中实现缓存机制。

**步骤1:** 打开Spring Initializr http://start.spring.io 。

**步骤2:** 选择Spring Boot版本 **2.3.0.M1。**

**步骤2:** 提供**群组**名称。我们提供了 **com.nhooo。**

**步骤3:** 提供**工件** ID。我们提供了 **spring-boot-cache-example。**

**步骤5:** 添加依赖项 **Spring Web** 和 **Spring Cache抽象。**

**步骤6:** 单击 **Generate** (生成)按钮。当我们单击"生成"按钮时，它将规格包装在 **Jar** 文件中，并将其下载到本地系统。

**步骤7:** **提取** Jar文件并将其粘贴到STS工作区中。

**步骤8:** **导入** STS中的项目文件夹。

文件->导入->现有Maven项目->浏览->选择文件夹spring-boot-cache-example->完成

导入需要一些时间。

让我们打开 **pom.xml** 文件，看看我们已经向其中添加了哪些依赖项。

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.0.M1</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  <groupId>com.nhooo</groupId>
  <artifactId>spring-boot-cache-example</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>spring-boot-cache-example</name>
  <description>Demo project for Spring Boot</description>
  <properties>
    <java.version>1.8</java.version>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
      <exclusions>
        <exclusion>
          <groupId>org.junit.vintage</groupId>
          <artifactId>junit-vintage-engine</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
  <repositories>
    <repository>
      <id>spring-milestones</id>
      <name>Spring Milestones</name>
      <url>https://repo.spring.io/milestone</url>
    </repository>
  </repositories>
  <pluginRepositories>
    <pluginRepository>
      <id>spring-milestones</id>
      <name>Spring Milestones</name>
      <url>https://repo.spring.io/milestone</url>
    </pluginRepository>
  </pluginRepositories>
</project>
```

**步骤9:** 打开 **SpringBootCacheExampleApplication.java** 文件，并通过添加注解 **@EnableCaching启用缓存。**

示例

```java
SpringBootCacheExampleApplication.java
package com.nhooo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
//enabling caching
@EnableCaching
public class SpringBootCacheExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootCacheExampleApplication.class, args);
}
}
```

**步骤10:** 在名为 **com.nhooo.model的文件夹 \**src/main/java\** 中创建一个包。**

**步骤11:** 在模型包中，创建一个名称为 **Customer** 的类并定义以下内容:

定义三个**accountno, customername, acounttype**和**balance**。使用Constructor生成**构造器** 。
右键单击文件->源->使用字段生成构造器->全选->生成生成**Getters and Setters。**
右键单击文件->源->生成Getter和设置器->全选->生成

**Customer.java**

示例

```java
package com.nhooo.model;
public class Customer 
{
    private int accountno;
    private String customername;
    private String accounttype;
    private double balance;
    public Customer(int accountno, String customername, String accounttype, double balance) 
    {
        this.accountno = accountno;
        this.customername = customername;
        this.accounttype = accounttype;
        this.balance = balance;
    }
    public int getAccountno() 
    {
        return accountno;
    }
    public void setAccountno(int accountno) 
    {
        this.accountno = accountno;
    }
    public String getCustomername() 
    {
        return customername;
    }
    public void setCustomername(String customername) 
    {
        this.customername = customername;
    }
    public String getAccounttype() 
    {
        return accounttype;
    }
    public void setAccounttype(String accounttype) 
    {
        this.accounttype = accounttype;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
}
```

**步骤11:** 在文件夹 **src/main/java** 中创建一个名称为 **com.nhooo.controller的包。**

**步骤12:** 在Controller程序包中，创建一个名称为 **CustomerController** 的控制器类，然后执行以下操作:

使用注解 **@RestController将类标记为 \**Controller\** 。**使用注解 **@RequestMapping为控制器定义\**映射\**。**我们已经定义了映射**/customerinfo** 。创建**缓存**以使用注解 **@Cacheable获取数据。** 我们已经通过使用注解的 **value** 属性定义了缓存名称。我们在中添加了两个客户详细信息

**CustomerController.java**

示例

```java
package com.nhooo.controller;
import java.util.Arrays;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nhooo.model.Customer;
@RestController
public class CustomerController 
{
    @RequestMapping("/customerinfo")
    //defines a cache for method's return value
    @Cacheable(value="customerInfo")
    public List customerInformation()
    {
        System.out.println("customer information from cache");
        //adding customer detail in the List
          List detail=Arrays.asList(new Customer(5126890,"Charlie Puth","Current A/c", 450000.00),
                        new Customer(7620015,"Andrew Flintoff","Saving A/c", 210089.00)
                       );
        return detail;
    }
}
```

现在运行该应用程序。

**步骤13:** 打开 **SpringBootCacheExampleApplication.java** 文件并将其作为Java应用程序运行。

**步骤14:** 打开**Postman**，并发送带有URL http: //locahost: 8080/custmerinfo的 **GET** 请求。它返回客户详细信息，如下所示。

![Spring Boot Caching](https://www.cainiaojc.com/static/upload/210424/0453360.png)

------

[SpringBoot 缓存提供程序](https://www.cainiaojc.com/springboot/springboot-cache-provider.html)[SpringBoot EhCaching](https://www.cainiaojc.com/springboot/springboot-ehcaching.html)

# SpringBoot 程序运行

在本节中，我们将创建并运行一个简单的Spring Boot应用程序。

## 创建一个Spring Boot应用程序

**步骤1:** 打开Spring Initializr https://start.spring.io/。

**步骤2:** 选择 Spring Boot版本 **2.2.2.BUILD-SNAPSHOT。**

**步骤3:** 提供 **组**名称。我们提供了组名 **com.nhooo。**

**步骤4:** 提供 **工件**。我们已经提供了工件 **spring-boot-application-run。**

**步骤5:** 添加 **Spring Web** 依赖项。

**步骤6:** 单击 **Generate** 按钮。当我们单击"生成"按钮时，它将与应用程序相关的所有规范包装到一个 **Jar** 文件中，并将其下载到本地系统。

**步骤7:** **提取** jar文件。

**步骤8:** 复制文件夹并将其粘贴到STS工作区中。

**步骤9:** **导入**该项目。

文件->导入->现有Maven项目->下一步->浏览->选择文件夹spring- spring -boot-application-run->选择文件夹->完成

导入项目需要时间。成功导入项目后，我们可以在IDE的 **Package Explorer** 部分中看到它。

我们看到自动创建了两个文件，一个是 **pom.xml** ，另一个是 **Application.java** 文件。

![如何运行Spring Boot应用程序](https://www.cainiaojc.com/static/upload/210424/0455280.png)

**pom.xml** 文件包含所有 **依赖项**， **应用程序名称，Spring引导版本，组名，工件，**和其他 **插件。**

**pom.xml**

示例

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.2.BUILD-SNAPSHOT</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.nhooo</groupId>
	<artifactId>spring-boot-application-run</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-boot-application-run</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
	</dependency>
		
		  <dependency>
 <groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.1.RELEASE</version>
<type>pom</type>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
	<repositories>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
		</repository>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
	</repositories>
	<pluginRepositories>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
		</pluginRepository>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>
</project>
```

**main** 类是一个包含main()方法的类。它启动Spring ApplicationContext。这是我们为执行应用程序而运行的类。

**SpringBootApplicationRun.java**

示例

```java
package com.nhooo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootApplicationRun
{
    public static void main(String[] args) 
    {
        SpringApplication.run(SpringBootApplicationRun.class, args);
    }
}
```

**步骤10:** 创建一个控制器。我们创建了一个名称为 **HelloWorldController** 的控制器。

**HelloWorldController.java**

示例

```java
package com.nhooo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController 
{
    @RequestMapping("/")
    public String hello() 
    {
        return "Hello User";
    }
}
```

现在，我们已经创建了与 Spring Boot 应用程序相关的所有必需文件。

## 运行Spring Boot应用程序

用于运行 Spring Boot应用程序 ，打开主应用程序文件，然后以 **Java Application的身份运行它。**

![如何运行Spring Boot应用程序](https://www.cainiaojc.com/static/upload/210424/0455281.png)

当应用程序成功运行时，它会在控制台中显示该消息，如下所示。

![如何运行Spring Boot应用程序](https://www.cainiaojc.com/static/upload/210424/0455282.png)

现在，打开浏览器并调用URL http://localhost:8080。它显示了我们已返回控制器的消息。

# SpringBoot 更改端口

Spring Boot框架提供了用于运行Spring Boot应用程序的默认嵌入式服务器(Tomcat)。它在端口 **8080** 上运行。可以在Spring Boot中更改端口。

我们可以在 Spring Boot 中更改端口。通过使用以下接口和属性文件:

使用 **application.properties** 文件使用 **application.yml** 文件使用 **EmbeddedServletContainerCustomizer** 接口使用 **WebServerFactoryCustomizer** 界面使用**命令行参数**

## 使用application.properties文件

如果要更改默认端口，建议您使用application.properties文件。因为这是一种覆盖默认值的简便快捷的方法。我们使用 **server.port** 属性覆盖默认属性。

例如，如果要将默认端口8080更改为8082，请在application.properties文件中指定该属性。

**application.properties**

示例

```java
server.port=8082
```

我们还可以将port属性设置为0。它将扫描应用程序的随机端口。每当我们重新启动应用程序时，它都会使用一个新端口。

**application.properties**

示例

```java
server.port=0
```

## 使用application.yml文件

类似地，我们也可以使用 **yml** 文件来更改默认端口。使用 **application.properties** 或 **application.yml** 文件，两个文件的工作方式相同。

**application.yml**

示例

```java
server:
      port:8082
```

## 使用EmbeddedServletContainerCustomizer接口

如果您使用的是 **Spring Boot 1.x** 版本，它将提供一个接口 **EmbeddedServletContainerCustomizer** 更改默认端口。

**EmbeddedServletContainerCustomizer接口**

通过使用EmbeddedServletContainerCustomizer，我们可以自定义自动配置的嵌入式Servlet容器。在启动容器本身之前，所有这种类型的Bean都会通过容器工厂获得回调。因此，我们可以设置 **端口，地址**和 **均匀错误页面**。它在 **org.springframework.boot.context.embedded** 包中定义。

该接口包含名为 **customize()**的方法。它允许我们自定义和指定 **ConfigurableEmbeddedServletContainer** 。它解析我们要自定义的名为 **容器**的参数。

### 语法

示例

```java
void customize(ConfigurableEmbeddedServletContainer container)
```

**ConfigurableEmbeddedServletContainer接口**

这是一个反映 **EmbeddedServletContainerFactory** 接口(用于创建 **EmbeddedServletContainers的工厂接口)中的更改的接口。** 。它在 **org.springframework.boot.context.embedded** 包中定义。它包含一种用于更改端口的方法，称为setPort()方法。

**setPort()方法**

setPort()方法配置嵌入式servlet容器应侦听的端口。如果不指定端口，它将使用默认端口 **8080** 。如果要禁用嵌入式服务器的自动启动功能，请使用端口 **-1** 。端口-1表示它将不监听任何端口，而是启动Web应用程序上下文。该方法解析类型为int的参数端口(要设置的 **por** t)。

### 语法

示例

```java
void setPort(int port)
```

在下面的示例中，我们创建了一个名为 **ServerCustomizer** 的类，并实现了EmbeddedServletContainerCustomizer接口。我们已经重写了customize()方法，并调用了设置端口 **8097** 的setPort()方法。

**ServerCustomizer.java**

示例

```java
@Component
public class ServerCustomizer implements EmbeddedServletContainerCustomizer 
{
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) 
    {
        container.setPort(8097);
    }
}
```

## 使用WebServerFactoryCustomizer接口

Spring Boot 2.x版本提供了 **WebServerFactoryCustomizer** 接口来更改默认端口。它在包 **org.springframework.boot.web.server** 中定义。它解析Web服务器工厂类型的参数 **T** 。

### 语法

示例

```java
public interface WebServerFactoryCustomizer<T extends WebServerFactory<
```

该接口包含名为 **customize()**的方法。它允许我们自定义Web服务器工厂。它解析我们要自定义的名为 **factory** 的参数。在启动容器本身之前，所有这种类型的Bean都会通过服务器工厂进行回调。因此，我们可以设置 **端口，地址**和 **错误页面**。

### 语法

示例

```java
void  customize(T factory)
```

**WebServerFactory接口**

这是工厂的标记接口。它在 **org.springframework.boot.web.server** 包中定义。它创建一个 **WebServer** 。

**ConfigurableWebServerFactory**

这是配置Web服务器工厂的界面。它在包 **org.springframework.boot.web.server** 中定义。它扩展了 **WebServerFactory** 和 **ErrorPageRegistory** 。它包含一种更改端口的方法，称为 **setPort()**方法。

**setPort()**

setPort()方法配置应侦听嵌入式servlet容器的端口。当我们不指定端口时，它将使用默认端口 **8080** 。如果要禁用嵌入式服务器的自动启动功能，请使用端口 **-1** 。端口-1表示它将不监听任何端口，而是启动Web应用程序上下文。该方法解析类型为int的参数端口(要设置的 **port** )。

### 语法

示例

```java
void setPort(int port)
```

注意: 此setPort()方法的接口为ConfigurableWebServerFactory。

在下面的示例中，我们创建了一个名为 **ServerCustomizer** 的类，该类实现了WebServerFactoryCustomizer接口。我们已经重写了customize()方法，并调用了setPort()方法来设置端口 **9001** 。

**ServerCustomizer.java**

示例

```java
@Component
public class ServerCustomizer implements WebServerFactoryCustomizer< ConfigurableWebServerFactory < 
{
    @Override
    public void customize(ConfigurableWebServerFactory factory) 
    {
        factory.setPort(9001);
    }
}
```

## 使用命令行参数

我们还可以通过使用命令行参数在Spring Boot中更改端口。我们必须遵循以下步骤:

打开任何Spring Boot应用程序。单击**运行**菜单，然后选择**运行配置**，或右键单击应用程序文件- <运行方式-< **运行配置。屏幕上将显示"运行配置"窗口。  
 ![Spring Boot更改端口](https://www.cainiaojc.com/static/upload/210424/0456590.png) 
 \**运行配置窗口\**出现在屏幕上。  
 ![Spring Boot更改端口](https://www.cainiaojc.com/static/upload/210424/0456591.png)****选择要在其中更改端口的应用程序文件。在我们的实例中，我们想更改 \**SpringBootHelloWorldExampleApplication\** 的端口，所以我们选择了它。单击\**参数\**标签。
![Spring Boot更改端口](https://www.cainiaojc.com/static/upload/210424/0456592.png)在 \**VM参数\**字段中写入 \**-Dserver.port = 9001\** 。您可以指定自己的端口，而不是9001。
![Spring Boot更改端口](https://www.cainiaojc.com/static/upload/210424/0456593.png)现在，分别单击\**应用\**和\**运行\**按钮。
单击"运行"按钮后，应用程序开始运行。我们可以看到控制台，以查看正在哪个端口服务器上运行，如下所示。
![Spring Boot更改端口](https://www.cainiaojc.com/static/upload/210424/0456594.png)打开浏览器并调用URL http://localhost: 9001。它在端口 \**9001\** 上运行应用程序。
![Spring Boot更改端口](https://www.cainiaojc.com/static/upload/210424/0456595.png)**

# SpringBoot REST示例

REST应用程序遵循REST体系结构方法。我们使用REST应用程序来开发和设计网络应用程序。它生成对数据执行CRUD操作的HTTP请求。通常，它以JSON或 XML 格式返回数据。

## Spring Boot REST API示例

在下面的示例中，我们将创建一个REST应用程序。在此应用程序中，我们创建了一个产品列表并返回相同的列表。它以 JSON 格式返回数据。

让我们在RSET应用程序中实现它并了解REST方法通过执行以下步骤。

**步骤1:** 打开 Spring Initializr https://start.spring.io/。

**步骤2:** 选择 Spring Boot版本 **2.3.0.M2** 。

**步骤3:** 提供 **组**名称。我们提供了组名 **com.nhooo** 。

**步骤4:** 提供 **工件**。我们提供了 **Artifact spring-boot-rest-example** 示例。

**步骤5:** 添加 **Spring Web** 依赖项。

**步骤6:** 单击"生成"按钮。当我们单击 **Generate** (生成)按钮时，它将与应用程序相关的所有规范包装到 **Jar** 文件中，并将其下载到本地系统。

**步骤7:** **提取** jar文件。

**步骤8:** 复制文件夹并将其粘贴到STS工作区中。

**步骤9:** **导入**项目。

文件->导入->现有Maven项目->下一步->浏览- >选择文件夹spring- spring-boot-rest-example->选择文件夹->完成

导入项目需要时间。成功导入项目后，我们可以在IDE的 **Package Explorer** 部分中看到它。

**步骤10:** 创建一个 **模型**包 **com.nhooo** 中的类。我们创建了一个名为 **产品**的类。在此类中，请执行以下操作:

创建五个变量id，pname，batchno，price和noofproduct。创建默认的构造函数。使用字段生成**构造函数**。
右键单击文件->源->使用字段生成构造函数->全选->生成生成**字母**和setter。

右键单击文件->源->生成Getter和Setters->全选->生成

完成所有步骤后，类如下所示。

**Product.java**

示例

```java
package com.nhooo;
public class Product 
{
    private int id;
    private String pname;
    private String batchno;
    private double price;
    private int noofproduct;
    //默认构造函数
    public Product()
    {
        
    }
    //使用字段的构造函数
    public Product(int id, String pname, String batchno, double price, int noofproduct) 
    {
        super();
        this.id = id;
        this.pname = pname;
        this.batchno = batchno;
        this.price = price;
        this.noofproduct = noofproduct;
    }
    //getter和setter
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getPname() 
    {
        return pname;
    }
    public void setPname(String pname) 
    {
        this.pname = pname;
    }
    public String getBatchno() 
    {
        return batchno;
    }
    public void setBatchno(String batchno) 
    {
        this.batchno = batchno;
    }
    public double getPrice() 
    {
        return price;
    }
    public void setPrice(double price) 
    {
        this.price = price;
    }
    public int getNoofproduct() 
    {
        return noofproduct;
    }
    public void setNoofproduct(int noofproduct) 
    {
        this.noofproduct = noofproduct;
    }
}
```

现在，我们需要创建一个控制器。

**步骤11:** 在 **com.nhooo** 包中，创建一个Controller。我们创建了一个名称为 **ProductController** 的控制器。

使用注解 **@RestController** 注解类。我们已自动连接 **IProductService** 接口。我们将在下一步中创建它。我们已经使用注解 **@GetMapping** 创建了一个映射**/产品**。我们已将方法 **getProduct()**映射到**/product** 。该方法返回产品列表。

**ProductController.java**

示例

```java
package com.nhooo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController 
{
    @Autowired
    private IProductService productService;
    //将getProduct()方法映射到/product
    @GetMapping(value = "/product")
    public List<Product> getProduct() 
    {
        //查找所有产品
        List<Product> products = productService.findAll();
        //返回产品列表
        return products;
    }
}
```

**步骤12:** 在包 **com.nhooo** 中创建一个名称为 **IProductService** 的接口，并定义 **findAll()** 方法，该方法返回产品列表。

**IProductService.java**

示例

```java
package com.nhooo;
import java.util.List;
public interface IProductService 
{
List<Product> findAll();
}
```

**步骤13:** 创建一个 **Service** 类。我们在包 **com.nhooo** 中创建了一个名为 **ProductService** 的服务类。

使用注解 **@Service** 注解类，并实现 **IProductService** 接口。在此类中，使用注解 **@Override** 覆盖 **findAll()**方法。 ProductService类的findAll()方法将覆盖 **IProductService** 接口的findAll()方法。创建 **ArrayList** 的对象。**添加**阵列列表中的产品。返回产品的**列表**。

**ProductService.java**

示例

```java
package com.nhooo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class ProductService implements IProductService  
{
    @Override
    public List<Product> findAll()
    {
        //创建一个ArrayList对象
        ArrayList<Product> products = new ArrayList<Product>();
        //将产品添加到列表中
        products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
        products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
        products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
        products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
        products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
        products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
        //returns a list of product
        return products;
    }
}
```

**步骤14:** 在 **static** 文件夹(src/main/resources/static)中，创建一个HTML文件。我们已经创建了一个名为 **index** 的 HTML 文件。在此文件中，我们创建了 **获取所有产品**的链接。

**index.html**

示例

```java
<!DOCTYPE html>
<html>
<head>
<title>Home page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<p>
<a href="product">Get all Products</a>
</p>
</body>
</html>
```

现在，我们已经创建了所有文件和文件夹。创建所有文件后，项目目录看起来像是在愚弄:

![Spring Boot REST Example](https://www.cainiaojc.com/static/upload/210424/0459230.png)

让我们运行该应用程序。

**步骤15:** 打开 **SpringBootRestExampleApplication.java** 文件并以Java 应用程序。默认情况下，它运行在端口 **8080** 上。

**SpringBootRestExampleApplication.java**

示例

```java
package com.nhooo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootRestExampleApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(SpringBootRestExampleApplication.class, args);
    }
}
```

当应用程序成功运行时，它将显示消息，如下所示

![Spring Boot REST示例](https://www.cainiaojc.com/static/upload/210424/0459231.png)

**步骤16:** 打开浏览器并调用 URL http://localhost:8080/index.html。它显示了 **获取所有产品**的链接，如下图所示。

![Spring Boot REST示例](https://www.cainiaojc.com/static/upload/210424/0459232.png)

单击链接 **获取所有产品**。它以 **JSON** 格式返回产品列表，并且URL更改为http://localhost:8080/product。

![Spring Boot REST示例](https://www.cainiaojc.com/static/upload/210424/0459233.png)