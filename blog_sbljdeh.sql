/*
Navicat MySQL Data Transfer

Source Server         : 188.131.240.160
Source Server Version : 50725
Source Host           : 188.131.240.160:33306
Source Database       : blog_sbljdeh

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-31 08:22:58
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
-- Table structure for b_article
-- ----------------------------
DROP TABLE IF EXISTS `b_article`;
CREATE TABLE `b_article` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_title_name` varchar(128) DEFAULT NULL COMMENT '标题名称',
  `article_detail_url` varchar(128) DEFAULT NULL COMMENT '文章详细路径',
  `article_introduction` varchar(128) DEFAULT NULL COMMENT '文章简介',
  `article_state` int(5) DEFAULT '0' COMMENT '0=保存草稿,1=已上线,2已下线,3,已删除',
  `article_type` int(5) DEFAULT '0' COMMENT '0=下拉显示,1=banner轮播,2=banner右,3=特别推荐,4=推荐文章,5=点击排行',
  `browse_pic_01` varchar(128) DEFAULT NULL COMMENT '文章浏览显示图',
  `browse_pic_02` varchar(128) DEFAULT NULL COMMENT '文章浏览显示图',
  `browse_pic_03` varchar(128) DEFAULT NULL COMMENT '文章浏览显示图',
  `author_id` int(20) DEFAULT NULL COMMENT '文章作者ID',
  `author_name` varchar(128) DEFAULT NULL COMMENT '文章作者姓名',
  `category_id` int(20) DEFAULT NULL COMMENT '文章类别ID',
  `category_name` int(128) DEFAULT NULL COMMENT '文章类别名称',
  `publish_date` datetime DEFAULT NULL COMMENT '文章发布时间',
  `create_date` datetime DEFAULT NULL COMMENT '文章创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '文章修改时间',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
