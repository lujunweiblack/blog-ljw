/*
Navicat MySQL Data Transfer

Source Server         : 188.131.240.160
Source Server Version : 50725
Source Host           : 188.131.240.160:33306
Source Database       : blog-sbljdeh

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-24 17:56:20
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_article
-- ----------------------------
INSERT INTO `b_article` VALUES ('13', '实战: Vue+七牛云 upload', 'md/13.md', '目的：使用 vue 上传文件/图片 到七牛云', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '### 说明：\n     1、前台使用vue，后台用 java 传递一个 token。\n     2、token ： 这个相当于一个密钥。\n     3、简单点说。就不写什么去注册账号，找到 as he ks 啥的，都到这一步，这些都不用说了。\n\n\n\n#### 第一步：前台 \n    \n    1、安装 cnpm install qiniu-js /  npm install qiniu-js\n    2、main.js 配置\n![e94da782b5fe448eb8bfb9535f87f62d.png](http://image.lujunwei.com/assets/1555990484534.png)\n\n    3、使用 \n```js\nreleaseBlog() {     //发布博客\n              \n\n                var qiniu = require(\'qiniu-js\')\n                var config = {\n                    useCdnDomain: true,\n                    region: qiniu.region.z0,     //华东\n                };\n                var putExtra = {\n                    fname: \"\",\n                    params: {},\n                    mimeType: [] || null \n                };\n                var observer = {\n                    next(res){\n                        // ...\n                    },\n                    error(err){\n                        // ...\n                    }, \n                    complete(res){\n                        // ...\n                    }\n                }\n               \n                var url1 = this.$store.state.frontUrl + \"/getToken\"\n                this.$ajax.get(url1)\n                .then( response => {\n                    \n                    //获取 token 和 图片的名称\n                    this.token = response.data.token;\n                    this.key = response.data.key;\n\n\n                    //把图片上传到 七牛云\n                    var observable = qiniu.upload(this.$refs.file.files[0], this.key, this.token , putExtra, config)\n                    var subscription = observable.subscribe(observer) // 上传开始\n\n\n                    //把数据保存到 后台\n                    var url2 = this.$store.state.frontUrl + \"/saveBlog\"\n                    this.$ajax.post(url2,JSON.stringify(this.inputBlog))\n                    .then( response => {\n                       \n                    })\n\n                })\n\n            },\n```\n\n#### 这里做两点说明：\n   1、获取token：很明显，我的第一个 ajax 就是，去后台获取 token 的。后面会给出后台 制作 token的代码。\n\n\n   2、获取上传的文件数据：\n```html\n<input type=\"file\" ref=\"file\" accept=\"image/*\" >\nthis.$refs.file.files[0]\n```\n#### 第二步：后台\n\n  2-1：maven 依赖\n\n```java\n<dependency>\n            <groupId>com.qiniu</groupId>\n            <artifactId>qiniu-java-sdk</artifactId>\n            <version>7.2.11</version>\n            <scope>compile</scope>\n        </dependency>\n        <dependency>\n            <groupId>com.squareup.okhttp3</groupId>\n            <artifactId>okhttp</artifactId>\n            <version>3.3.1</version>\n            <scope>compile</scope>\n        </dependency>\n        <dependency>\n            <groupId>com.google.code.gson</groupId>\n            <artifactId>gson</artifactId>\n            <version>2.6.2</version>\n            <scope>compile</scope>\n        </dependency>\n        <dependency>\n            <groupId>com.qiniu</groupId>\n            <artifactId>happy-dns-java</artifactId>\n            <version>0.1.4</version>\n            <scope>compile</scope>\n        </dependency>\n        <dependency>\n            <groupId>junit</groupId>\n            <artifactId>junit</artifactId>\n            <version>4.12</version>\n            <scope>test</scope>\n        </dependency>\n```\n\n2-2：java代码\n```java\n@RequestMapping(value = \"/getToken\", method = RequestMethod.GET)\n    public QiNiu getToken() {\n        QiNiu qiNiu = new QiNiu();\n        // 这三个 就是  ak  sk   和你的 空间名\n        String accessKey = \"\";\n        String secretKey = \"\";\n        String bucket = \"\";\n        long expireSeconds = 600;\n        StringMap putPolicy = new StringMap();\n        Auth auth = Auth.create(accessKey, secretKey);\n        String upToken = auth.uploadToken(bucket,null, expireSeconds,putPolicy);\n\n        qiNiu.setKey(UUID.randomUUID().toString());\n        qiNiu.setToken(upToken);\n\n      return qiNiu;\n    };\n```\n', null, '2019-04-24 09:31:27', '2019-04-23 03:40:17', '2019-04-23 03:40:17');
INSERT INTO `b_article` VALUES ('14', 'Vue上传图片到七牛云', 'md/14.md', '通过客户端方式进行上传, 大大减少了服务端的压力.  实现的时候在token这块浪费了点时间', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '## 一. 引入七牛云插件\n![e94da782b5fe448eb8bfb9535f87f62d.png](http://image.lujunwei.com/assets/1555992375151.png)\n## 二. 绑定上传事件\n![微信截图_20190423114736.png](http://image.lujunwei.com/assets/1555992382411.png)\n## 三. 触发方法\n![微信截图_20190423114749.png](http://image.lujunwei.com/assets/1555992387930.png)\n## 四. 封装上传参数\n![image.png](http://image.lujunwei.com/assets/1555991302411.png)\n## 五. 后台\n![image.png](http://image.lujunwei.com/assets/1555992557931.png)', null, '2019-04-23 07:09:05', '2019-04-23 04:10:14', '2019-04-23 04:10:14');
INSERT INTO `b_article` VALUES ('18', 'mysql 一个被误导的错误： mysql jdbc连接，数据库ip变成了本地ip？', 'md/18.md', 'mysql 一个被误导的错误：', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '[转载: mysql jdbc连接，数据库ip变成了本地ip](https://blog.csdn.net/qq_17820539/article/details/79710068)\n\n#### mysql jdbc连接，数据库ip变成了本地ip？\n\n \n```java\njava.sql.SQLException: Access denied foruser \'btir\'@\'172.43.5.48\' (using password: YES)\n\n```\n\n###### 一个被误导的错误，看到这个错误时忘了可能是密码错了，因为这个东西是其他同事配置好的，所以没有多想，而且加上之前用过ssh登录命令，ssh的命令是这样格式的：\n\n```java\nssh -p 12333 root@216.230.230.114\n\n ```\n\n###### 没错，都有这种格式 user@ip，于是头脑昏了，以为数据库连错了，连到了本地ip（172.43.5.48，实际配置文件里面数据库并不在本地）。于是查框架代码，查半天，以为是哪里读配置文件错了，默认设成了本地ip，还对框架jar做了反编译。浪费好多时间。\n\n###### 实际上这句报错的意思就是mysql连接密码错了：\n\n \n```java\nAccess denied for user \'btir\'@\'172.43.5.48\' (using password: YES)\n ```\n \n\n###### btir是你用的登录用户名，而@后面的ip就是登录时的ip，不是数据库所在的ip！\n\n \n\n \n\n###### 附上关于ssh命令的说明：\n\n \n\n###### ssh命令用于远程登录上Linux主机。\n\n \n\n###### 常用格式：ssh [-l login_name] [-p port] [user@]hostname\n\n \n\n###### @后面是你要登录的主机域名或ip，这一点与上面的报错信息不一样。\n\n\n\n \n\n', null, '2019-04-23 07:52:25', '2019-04-23 07:52:25', '2019-04-23 07:52:25');
INSERT INTO `b_article` VALUES ('19', '关于别人聊天时描述不清的问题', 'md/19.md', '很多次别人描述问题时总是含糊其辞, 这个人之前是mysql 链接不上, 过了一会 又发了个连接不上, 到底是team链接不上还是mysql 链接不上呢??', '0', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '![image.png](http://image.lujunwei.com/assets/1556006259199.png)', null, '2019-04-24 09:05:03', '2019-04-23 07:59:19', '2019-04-23 07:59:19');
INSERT INTO `b_article` VALUES ('23', 'VUE 项目组件打包后还是比较大', 'md/23.md', '这个问题可以使用gzip, 因为工作原因还未尝试', '1', '1', '20190016', 'lujunwei', '10000913', '陆军委组织', '### 打包后的三个big 最大 <font color=\'red\' size=\'6+\'>**1.2M**</font>\n\n![image.png](http://image.lujunwei.com/assets/1556097619108.png)\n\n\n### 只能把它放到云上\n*因为我的服务器是1g1核的带宽也是1m的,对于加载500k以上的文件都是比较慢的了,七牛云的话不会限制下载大小,只不过暂时需要手动的上传*\n![image.png](http://image.lujunwei.com/assets/1556097857006.png)\n\n### 切换js加载源\n\n![image.png](http://image.lujunwei.com/assets/1556098034487.png)', null, '2019-04-24 09:27:32', '2019-04-24 09:27:32', '2019-04-24 09:27:32');
INSERT INTO `b_article` VALUES ('24', null, null, null, '0', '0', null, null, null, null, null, null, null, null, null);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_link
-- ----------------------------
