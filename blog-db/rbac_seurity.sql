/*
Navicat MySQL Data Transfer

Source Server         : 188.131.240.160
Source Server Version : 50725
Source Host           : 188.131.240.160:33306
Source Database       : rbac_seurity

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-19 15:47:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(128) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(32) DEFAULT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `per_code` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `sort` varchar(128) DEFAULT NULL COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1002', 'Dashboard', 'menu', '', 'Dashboard', null, '1', '1');
INSERT INTO `sys_permission` VALUES ('1003', 'UI Elements', 'menu', null, 'UI Elements', null, '1', '1');
INSERT INTO `sys_permission` VALUES ('1004', 'Cards', 'menu', 'ui-cards.html', 'ui-cards', '1003', '1', '1');
INSERT INTO `sys_permission` VALUES ('1005', 'Widgets', 'menu', 'widgets.html', 'widgets', '1003', '1', '1');
INSERT INTO `sys_permission` VALUES ('1006', 'Charts', 'menu', 'charts.html', 'charts', null, '1', '1');
INSERT INTO `sys_permission` VALUES ('1007', 'Forms', 'menu', '', 'Forms', null, '1', '1');
INSERT INTO `sys_permission` VALUES ('1008', 'Form Components', 'menu', 'form-components.html', 'form-components', '1007', '1', '1');
INSERT INTO `sys_permission` VALUES ('1009', 'Custom Components', 'menu', 'form-custom.html', 'form-custom', '1007', '2', '1');
INSERT INTO `sys_permission` VALUES ('1010', 'Form Samples', 'menu', 'form-samples.html', 'form-samples', '1007', '3', '1');
INSERT INTO `sys_permission` VALUES ('1011', 'Form Notifications', 'menu', 'form-notifications.html', 'form-notifications', '1007', '4', '1');
INSERT INTO `sys_permission` VALUES ('1012', 'Tables', 'menu', '', 'Tables', null, '1', '1');
INSERT INTO `sys_permission` VALUES ('1013', 'Basic Tables', 'menu', 'table-basic.html', 'table-basic', '1012', '1', '1');
INSERT INTO `sys_permission` VALUES ('1014', 'Data Tables', 'menu', 'table-data-table.html', 'table-data-table', '1012', '2', '1');
INSERT INTO `sys_permission` VALUES ('1015', 'Pages', 'menu', '', 'Pages', null, '1', '1');
INSERT INTO `sys_permission` VALUES ('1016', 'Blank Page', 'menu', 'blank-page.html', 'blank-page', '1015', '1', '1');
INSERT INTO `sys_permission` VALUES ('1017', 'Login Page', 'menu', 'page-login.html', 'page-login', '1015', '2', '1');
INSERT INTO `sys_permission` VALUES ('1018', 'Lockscreen Page', 'menu', 'page-lockscreen.html', 'page-lockscreen', '1015', '3', '1');
INSERT INTO `sys_permission` VALUES ('1019', 'User Page', 'menu', 'page-user.html', 'page-user', '1015', '4', '1');
INSERT INTO `sys_permission` VALUES ('1020', 'Invoice Page', 'menu', 'page-invoice.html', 'page-invoice', '1015', '5', '1');
INSERT INTO `sys_permission` VALUES ('1021', 'Calendar Page', 'menu', 'page-calendar.html', 'page-calendar', '1015', '6', '1');
INSERT INTO `sys_permission` VALUES ('1022', 'Mailbox', 'menu', 'page-mailbox.html', 'page-mailbox', '1015', '7', '1');
INSERT INTO `sys_permission` VALUES ('1023', 'Error Page', 'menu', 'page-error.html', 'page-error', '1015', '8', '1');
INSERT INTO `sys_permission` VALUES ('1024', 'Home', 'menu', 'home.html', 'home', '1002', '1', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(36) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2205', '普通用户', 'ROLE_USER', '1', '普通用户');
INSERT INTO `sys_role` VALUES ('2206', '普通管理员', 'ROLE_ADMIN', '1', '普通管理员');
INSERT INTO `sys_role` VALUES ('2207', '系统管理员', 'ROLE_SYS_ADMIN', '1', '系统管理员');
INSERT INTO `sys_role` VALUES ('2208', '超级管理员', 'ROLE_SUP_ADMIN', '1', '超级管理员');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(36) NOT NULL,
  `sys_role_id` varchar(32) DEFAULT NULL COMMENT '角色id',
  `sys_permission_id` varchar(32) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('2856', '2205', '1011');
INSERT INTO `sys_role_permission` VALUES ('2857', '2206', '1024');
INSERT INTO `sys_role_permission` VALUES ('2858', '2207', '1003');
INSERT INTO `sys_role_permission` VALUES ('2859', '2207', '1004');
INSERT INTO `sys_role_permission` VALUES ('2860', '2207', '1005');
INSERT INTO `sys_role_permission` VALUES ('2861', '2207', '1006');
INSERT INTO `sys_role_permission` VALUES ('2862', '2207', '1007');
INSERT INTO `sys_role_permission` VALUES ('2863', '2207', '1008');
INSERT INTO `sys_role_permission` VALUES ('2864', '2207', '1009');
INSERT INTO `sys_role_permission` VALUES ('2865', '2207', '1010');
INSERT INTO `sys_role_permission` VALUES ('2866', '2207', '1011');
INSERT INTO `sys_role_permission` VALUES ('2867', '2207', '1012');
INSERT INTO `sys_role_permission` VALUES ('2868', '2207', '1013');
INSERT INTO `sys_role_permission` VALUES ('2869', '2207', '1014');
INSERT INTO `sys_role_permission` VALUES ('2870', '2207', '1015');
INSERT INTO `sys_role_permission` VALUES ('2871', '2207', '1016');
INSERT INTO `sys_role_permission` VALUES ('2872', '2207', '1017');
INSERT INTO `sys_role_permission` VALUES ('2873', '2207', '1018');
INSERT INTO `sys_role_permission` VALUES ('2874', '2207', '1019');
INSERT INTO `sys_role_permission` VALUES ('2875', '2207', '1020');
INSERT INTO `sys_role_permission` VALUES ('2876', '2207', '1021');
INSERT INTO `sys_role_permission` VALUES ('2877', '2207', '1022');
INSERT INTO `sys_role_permission` VALUES ('2878', '2207', '1023');
INSERT INTO `sys_role_permission` VALUES ('2879', '2206', '1023');
INSERT INTO `sys_role_permission` VALUES ('2880', '2206', '1020');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(36) NOT NULL COMMENT '主键',
  `user_code` varchar(32) DEFAULT NULL COMMENT '账号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `pass_word` varchar(100) DEFAULT NULL COMMENT '密码',
  `age` int(5) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `locked` char(5) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('20190013', 'zhangsan', '张三', '$2a$10$/Ybr7IULud2Ofn.tYIvdOexvCNaDknWCxhMHF8vTOuXPuTTDNoe.G', '26', '男', '15277671233', 'zhangsan@163.com', '上海市上海市松江区殷高路2号', null, '0');
INSERT INTO `sys_user` VALUES ('20190014', 'lisi', '李四', '$2a$10$/Ybr7IULud2Ofn.tYIvdOexvCNaDknWCxhMHF8vTOuXPuTTDNoe.G', '31', '男', '15712309087', 'lisi@51.com', '上海市上海市浦东新区酣梦路564号', null, '0');
INSERT INTO `sys_user` VALUES ('20190015', 'lihuan', '李欢', '$2a$10$/Ybr7IULud2Ofn.tYIvdOexvCNaDknWCxhMHF8vTOuXPuTTDNoe.G', '28', '女', '13578672281', 'lihuan@qq.com', '江苏省南京市华天小区源昌路6栋330', null, '0');
INSERT INTO `sys_user` VALUES ('20190016', 'lujunwei', '陆军委', '$2a$10$clklmY5liWjyZ3eGpWrXyeo7yOOpl0JY5eqvrArpjzIK4Qa2Sev9e', '25', '男', '15295159035', 'lujunwei_black@163.com', '上海上海市嘉定区秋竹路119弄904室', '', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(36) NOT NULL,
  `sys_user_id` varchar(32) DEFAULT NULL,
  `sys_role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('68906', '20190013', '2205');
INSERT INTO `sys_user_role` VALUES ('68907', '20190013', '2206');
INSERT INTO `sys_user_role` VALUES ('68908', '20190016', '2207');
