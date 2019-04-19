/*
Navicat MySQL Data Transfer

Source Server         : 188.131.240.160
Source Server Version : 50725
Source Host           : 188.131.240.160:33306
Source Database       : blog-sbljdeh

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-19 15:46:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_about
-- ----------------------------
DROP TABLE IF EXISTS `b_about`;
CREATE TABLE `b_about` (
  `about_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `autograph_id` bigint(20) DEFAULT NULL COMMENT '签名主键',
  `about_name` varchar(128) DEFAULT NULL COMMENT '关于名称',
  `oneself_name` varchar(128) DEFAULT NULL COMMENT '本人姓名',
  `oneself_nick_name` varchar(128) DEFAULT NULL COMMENT '本人昵称',
  `oneself_intelligence` varchar(128) DEFAULT NULL COMMENT '本人职能',
  `oneself_brief` varchar(128) DEFAULT NULL COMMENT '本人简介',
  `oneself_brief_introduction` varchar(1000) DEFAULT NULL COMMENT '本人介绍',
  `head_url` varchar(128) DEFAULT NULL COMMENT '头像',
  `background_url` varchar(128) DEFAULT NULL COMMENT '背景图片',
  `sina_url` varchar(128) DEFAULT NULL COMMENT '新浪',
  `sina_name` varchar(128) DEFAULT NULL COMMENT '新浪',
  `tencent_url` varchar(128) DEFAULT NULL COMMENT '腾讯',
  `tencent_name` varchar(128) DEFAULT NULL COMMENT '腾讯',
  `qq_url` varchar(128) DEFAULT NULL COMMENT 'qq',
  `qq_name` varchar(128) DEFAULT NULL COMMENT 'qq',
  `email_url` varchar(128) DEFAULT NULL COMMENT '163email',
  `email_name` varchar(128) DEFAULT NULL COMMENT '163email',
  `wx_name` varchar(128) DEFAULT NULL COMMENT '微信',
  `wx_img_url` varchar(128) DEFAULT NULL COMMENT '微信',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`about_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_about
-- ----------------------------

-- ----------------------------
-- Table structure for b_article
-- ----------------------------
DROP TABLE IF EXISTS `b_article`;
CREATE TABLE `b_article` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_title_name` varchar(128) DEFAULT NULL COMMENT '标题名称',
  `article_detail_url` varchar(128) DEFAULT NULL COMMENT '文章详细路径',
  `article_introduction` varchar(2000) DEFAULT NULL COMMENT '文章简介',
  `article_state` int(5) DEFAULT '0' COMMENT '0=默认,1=已上线,2已删除',
  `article_type` int(5) DEFAULT '0' COMMENT '0=默认,1=特殊文章',
  `author_id` int(20) DEFAULT NULL COMMENT '文章作者ID',
  `author_name` varchar(128) DEFAULT NULL COMMENT '文章作者姓名',
  `category_id` int(20) DEFAULT NULL COMMENT '文章类别ID',
  `category_name` varchar(128) DEFAULT NULL COMMENT '文章类别名称',
  `backup_field_one` longtext COMMENT '备用字段',
  `backup_field_two` longtext COMMENT '备用字段',
  `publish_date` datetime DEFAULT NULL COMMENT '文章发布时间',
  `create_date` datetime DEFAULT NULL COMMENT '文章创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '文章修改时间',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_article
-- ----------------------------
INSERT INTO `b_article` VALUES ('4', 'mysql5.7 设置远程访问', 'md/4.md', 'mysql5.7设置远程访问不是和网上说的一样建个用户赋个权限就可以访问的。比如下边这个就是建用户赋权限，可能在之前的版本可以，但是我在我的mysql上一直不行。为此烦了好久！！！项目都耽误了！！', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', 'mysql5.7设置远程访问不是和网上说的一样建个用户赋个权限就可以访问的。比如下边这个就是建用户赋权限，可能在之前的版本可以，但是我在我的mysql上一直不行。为此烦了好久！！！项目都耽误了！！\n\n一、原来设置远程访问的方式\nMysql默认是不可以通过远程机器访问的,通过下面的配置可以开启远程访问 \n\n在MySQL Server端： \n\n执行mysql 命令进入mysql 命令模式， \n\nSql代码 \nmysql> use mysql;   \nmysql> GRANT ALL ON *.* TO user@\'%\' IDENTIFIED BY \'123456\' WITH GRANT OPTION;   \n#这句话的意思 ，允许任何IP地址（上面的 % 就是这个意思）的电脑 用admin帐户  和密码（admin）来访问这个MySQL Server   \n\n#必须加类似这样的帐户，才可以远程登陆。 root帐户是无法远程登陆的，只可以本地登陆  \n\n远程访问：\nmysql -h172.21.5.29 -uuser -p123456  即可了\n//172.21.5.29就是MySQL Server的IP地址，user就是刚才在 172.21.5.29上设置的远程访问帐户\n  另外你也可以在一个机器上模拟远程访问，就是多开几个终端，方便测试是否可以远程访问。\n\n \n我发现一个问题， 如果上面的命令你执行完毕， 你在 本地就是localhost ， 执行 :\nmysql -hlocalhost -uadmin -padmin   \n结果是失败的。 \n原来 上面的 % 竟然不包括localhost \n\n所以你还必须加上这样的 命令：\nmysql>GRANT ALL ON *.* TO admin@\'localhost\'  IDENTIFIED BY \'admin\' WITH GRANT OPTION; \n\n二、mysql5.7中设置远程访问\n我在按照上边的方法设置后，发现用mysql -h 并不能远程访问，修改了/etc/my.cnf配置文件把\n\n#skip-networking 注释掉\n加上bind-address=0.0.0.0\n\n然而并没有卵用！\n\n看得我都快背下来了！\n\n后来我直接去看他的配置文件：在/etc/mysql文件夹下\n\n\n\n点开图中的my.cnf:  有下面一些话：\n\n#\n# * IMPORTANT: Additional settings that can override those from this file!\n\n# 其他地方的配置可以覆盖此文件的配置\n# The files must end with \'.cnf\', otherwise they\'ll be ignored.  \n#\n\n!includedir /etc/mysql/conf.d/\n!includedir /etc/mysql/mysql.conf.d/\n\n文件最后的两个路径我很好奇，就去看了下：conf.d/:\n\n\n\n里边一个配置文件，打开发现，就一个[mysql]，然后啥都没有。\n\n再看另一个：\n\n\n\n也有一个配置文件，打开发现有惊喜，就在这里边有一句话：\n\n\n\n瞬间有种见到天日的感觉！！！看它的注释就明白，只能本地连接，问题出在这！！\n\n把bind-address注释掉：#bind-address=...\n\n重启mysql服务，远程链接：\n\nmysql -h172.17.0.1 -uuser -p\n//我的用户名是：user\n\n终于进去了，哈哈！！\n\n\n\n为了这个折腾了两天！！！我是服气mysql的！！', null, '2019-04-19 07:19:14', '2019-04-19 03:35:45', '2019-04-19 03:35:45');
INSERT INTO `b_article` VALUES ('7', 'Docker容器上Spring Cloud微服务相互调用时报错：java.net.UnknownHostException:主机名', 'md/7.md', 'Docker容器上Spring Cloud微服务相互调用时报错：java.net.UnknownHostException:主机名', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '项目背景：\n采用Spring Cloud+IEDA+Maven搭建了由多个微服务组成的项目，部署上线是用的是Docker容器技术。\n\n问题描述：\n部署上线过程中，各个微服务都正常启动，而且都注册到了eureka注册中心，但是相互调用时报java.net.UnknownHostException:主机名的错误。\n\n原因分析：\n各个微服务是以“主机名:服务名:端口”的形式注册到注册中心。当本地测试时，主机是同一个，为localhost，所以能找到主机并相互调用。当部署上线时，每个微服务运行在不同主机，主机名都各不相同，所以调用时找不到目标主机在哪。\n\n解决方法：\n让微服务以“ip:端口”的形式注册，这里的ip指的是部署的主机ip。\n我的Spring Cloud版本：\n```java\n<spring-cloud.version>Finchley.SR1</spring-cloud.version>\n```\n1\n在application.properties中添加\n```java\neureka.instance.prefer-ip-address=true\neureka.instance.instance-id=ip地址:端口\n```\n2\n其中，ip地址可以更换为http://域名，亲测可用。\n', null, '2019-04-19 07:35:16', '2019-04-19 07:22:01', '2019-04-19 07:22:01');
INSERT INTO `b_article` VALUES ('8', 'Spring Cloud Gateway基于服务发现的默认路由规则', 'md/8.md', 'Spring Cloud Gateway是Spring官方基于Spring 5.0，Spring Boot 2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供一种简单而有效的统一的API路由管理方式。Spring Cloud Gateway作为Spring Cloud生态系中的网关，目标是替代Netflix ZUUL，其不仅提供统一的路由方式，并且基于Filter链的方式提供了网关基本的功能，例如：安全，监控/埋点，和限流等。', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '1.Spring Gateway概述\n1.1 什么是Spring Cloud Gateway\nSpring Cloud Gateway是Spring官方基于Spring 5.0，Spring Boot 2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供一种简单而有效的统一的API路由管理方式。Spring Cloud Gateway作为Spring Cloud生态系中的网关，目标是替代Netflix ZUUL，其不仅提供统一的路由方式，并且基于Filter链的方式提供了网关基本的功能，例如：安全，监控/埋点，和限流等。\n\n\n\n1.2 Spring Cloud Gateway的功能\nSpring Cloud Gateway 的特征：\n\n基于 Spring Framework 5，Project Reactor 和 Spring Boot 2.0\n动态路由\nPredicates 和 Filters 作用于特定路由\n集成 Hystrix 断路器\n集成 Spring Cloud DiscoveryClient\n易于编写的 Predicates 和 Filters\n限流\n路径重写\n2. Spring Cloud Gateway的工程流程\n\n\n客户端向 Spring Cloud Gateway 发出请求。然后在 Gateway Handler Mapping 中找到与请求相匹配的路由，将其发送到 Gateway Web Handler。Handler 再通过指定的过滤器链来将请求发送到我们实际的服务执行业务逻辑，然后返回。\n过滤器之间用虚线分开是因为过滤器可能会在发送代理请求之前（“pre”）或之后（“post”）执行业务逻辑。\n\n2.1 Pre和POST两种类型的过滤器\n3.基于服务发现的默认路由规则\n3.1 zuul和gateway的默认路由规则\n3.1.1 zuul的默认路由规则\n说明默认情况下，Zuul会代理所有注册到Eureka Server的微服务，并且Zuul的路由规则如下：\nhttp://ZUUL_HOST:ZUUL_PORT/微服务在Eureka上的serviceId/** 会被转发到serviceId对应的微服务。\nhttp://localhost:8040/sc-zuul-first-provider/sc/order/2\n默认路由规则\n\n3.1.2 gateway的默认路由规则\n规则：http://Gateway_HOST:Gateway_PORT/大写的serviceId/**\n\n其中微服务应用名默认大写访问。\n\n实例代码：\n\n模块	说明	端口\neureka-service	Eureka Server注册中心	5000\ngateway-service	Spring Cloud Gateway Sever	5001\norder-service	服务提供者	5100\nuser-service	服务消费者	5200\n分别新建上面这四个服务，详见 spring cloud Finchley环境搭建\n其中gateway-service服务的application.yml配置文件如下：\n\nspring:\n  application:\n    name: gateway-service\n  cloud:        # spring cloud gateway 路由配置方式\n    gateway:\n      discovery:      #是否与服务发现组件进行结合，通过 serviceId(必须设置成大写) 转发到具体的服务实例。默认为false，设为true便开启通过服务中心的自动根据 serviceId 创建路由的功能。\n        locator:      #路由访问方式：http://Gateway_HOST:Gateway_PORT/大写的serviceId/**，其中微服务应用名默认大写访问。\n          enabled: true\n      routes:\n      - id: 163                     #网关路由到网易官网\n        uri: http://www.163.com/\n        predicates:\n          - Path=/163/**\n#      - id: ORDER-SERVICE           #网关路由到订单服务order-service\n#        uri: lb://ORDER-SERVICE\n#        predicates:\n#          - Path=/ORDER-SERVICE/**\n#      - id: USER-SERVICE            #网关路由到用户服务user-service\n#        uri: lb://USER-SERVICE\n#        predicates:\n#          - Pach=/USER-SERVICE/**\n\nserver:\n  port: 5001\n\n\nlogging:\n  level:\n    org.springframework.cloud.gateway: trace\n    org.springframework.http.server.reactive: debug\n    org.springframework.web.reactive: debug\n    reactor.ipc.netty: debug\n\n\neureka:\n  client:\n    service-url:\n      defaultZone: http://localhost:5000/eureka/\n\nfeign:\n  hystrix:\n    enabled: true\n\n\n配置项说明：\nspring.cloud.gateway.discovery.locator.enabled：是否与服务发现组件进行结合，通过 serviceId 转发到具体的服务实例。默认为false，设为true便开启通过服务中心的自动根据 serviceId 创建路由的功能。\n\neureka.client.service-url.defaultZone: http://localhost:5000/eureka/,指定注册中心的地址，Spring Cloud Gateway从注册中心获取已经注册的服务列表。\n\nlogging.level.org.springframework.cloud.gateway: debug,开启spring-Cloud-gateway的日志级别为debug，方便debug调试。\n\n3.3 启动测试\n3.3.1 错误的路由规则访问\n访问Spring Cloud Gateway对应的server，当访问http://localhost:5000/order-service/order/getOrderPort的时候，会出现报错内容如下所示：\n\n\n\n正确的Spring Cloud Gateway的默认路由规则:http://Gateway_HOST:Gateway_PORT/大写的serviceId/**\n\n3.3.2 Gateway正确的路由规则测试\n\n注：内容来源点击打开链接\n\n', null, '2019-04-19 07:42:46', '2019-04-19 07:36:56', '2019-04-19 07:36:56');

-- ----------------------------
-- Table structure for b_article_browse
-- ----------------------------
DROP TABLE IF EXISTS `b_article_browse`;
CREATE TABLE `b_article_browse` (
  `browse_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` varchar(128) DEFAULT NULL COMMENT '文章ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`browse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_article_browse
-- ----------------------------

-- ----------------------------
-- Table structure for b_article_like
-- ----------------------------
DROP TABLE IF EXISTS `b_article_like`;
CREATE TABLE `b_article_like` (
  `like_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` varchar(128) DEFAULT NULL COMMENT '文章ID',
  `like_state` int(5) DEFAULT '0' COMMENT '0,默认,1=点赞,2=取消赞,',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_article_like
-- ----------------------------

-- ----------------------------
-- Table structure for b_autograph
-- ----------------------------
DROP TABLE IF EXISTS `b_autograph`;
CREATE TABLE `b_autograph` (
  `autograph_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `autograph_name` varchar(128) DEFAULT NULL COMMENT '主键',
  `autograph_content` varchar(250) DEFAULT NULL COMMENT '主键',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`autograph_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_autograph
-- ----------------------------

-- ----------------------------
-- Table structure for b_label
-- ----------------------------
DROP TABLE IF EXISTS `b_label`;
CREATE TABLE `b_label` (
  `label_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label_name` varchar(128) DEFAULT NULL COMMENT '标签名称',
  `label_state` int(5) DEFAULT '0' COMMENT '标签状态 0=可用,1=不可用',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_label
-- ----------------------------

-- ----------------------------
-- Table structure for b_link
-- ----------------------------
DROP TABLE IF EXISTS `b_link`;
CREATE TABLE `b_link` (
  `link_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `link_name` varchar(128) DEFAULT NULL COMMENT '链接名称',
  `link_url` varchar(128) DEFAULT NULL COMMENT '链接名称',
  `link_state` int(5) DEFAULT '0' COMMENT '链接状态 0=可用,1=不可用',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_link
-- ----------------------------
