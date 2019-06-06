/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : power_system

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-06-06 11:58:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ps_fullmoney_log
-- ----------------------------
DROP TABLE IF EXISTS `ps_fullmoney_log`;
CREATE TABLE `ps_fullmoney_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户的userId',
  `accounts` varchar(255) DEFAULT NULL COMMENT '用户账户（号）',
  `surplusmoney` decimal(10,0) DEFAULT NULL COMMENT '每次用户充值完毕后账户的剩余金额',
  `fullmoney` decimal(10,0) DEFAULT NULL COMMENT '充值金额',
  `fulltime` datetime DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='用户充值记录表';

-- ----------------------------
-- Records of ps_fullmoney_log
-- ----------------------------
INSERT INTO `ps_fullmoney_log` VALUES ('1', '1', 'DX360210123456789', '98', '98', '2019-05-09 20:57:02');
INSERT INTO `ps_fullmoney_log` VALUES ('2', '8', '20191901', '0', '100', '2019-06-04 16:02:24');
INSERT INTO `ps_fullmoney_log` VALUES ('3', '8', '20191901', '100', '111', '2019-06-04 20:12:51');
INSERT INTO `ps_fullmoney_log` VALUES ('4', '8', '20191901', '211', '222', '2019-06-04 20:13:11');
INSERT INTO `ps_fullmoney_log` VALUES ('5', '8', '20191901', '433', '110', '2019-06-04 20:13:22');
INSERT INTO `ps_fullmoney_log` VALUES ('6', '8', '20191901', '543', '111', '2019-06-04 20:39:39');
INSERT INTO `ps_fullmoney_log` VALUES ('7', '8', '20191901', '654', '112', '2019-06-05 11:08:39');
INSERT INTO `ps_fullmoney_log` VALUES ('8', '8', '20191901', '766', '66', '2019-06-05 15:48:07');
INSERT INTO `ps_fullmoney_log` VALUES ('9', '8', '20191901', '832', '78', '2019-06-05 15:48:19');
INSERT INTO `ps_fullmoney_log` VALUES ('10', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('11', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('12', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('13', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('14', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('15', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('16', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('17', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('18', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('19', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('20', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('21', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('22', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('23', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('24', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('25', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('26', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('27', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('28', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('29', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('30', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('31', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('32', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('33', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('34', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('35', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('36', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('37', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('38', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('39', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('40', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('41', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('42', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('43', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('44', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('45', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('46', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('47', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('48', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('49', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('50', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('51', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('52', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('53', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('54', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('55', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('56', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('57', '8', '20191901', '910', '88', '2019-06-05 15:48:36');
INSERT INTO `ps_fullmoney_log` VALUES ('58', '8', '20191901', '910', '88', '2019-06-05 15:48:36');

-- ----------------------------
-- Table structure for ps_model_findtime
-- ----------------------------
DROP TABLE IF EXISTS `ps_model_findtime`;
CREATE TABLE `ps_model_findtime` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(10) DEFAULT NULL COMMENT '用户的userid',
  `accounts` varchar(24) DEFAULT NULL COMMENT '用户账户',
  `selecttime` datetime DEFAULT NULL COMMENT '查询时间',
  `modelflag` varchar(255) DEFAULT NULL COMMENT '记录查询不同模块的标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户查询某一个模块的时间记录表';

-- ----------------------------
-- Records of ps_model_findtime
-- ----------------------------
INSERT INTO `ps_model_findtime` VALUES ('1', '1', 'DX360210123456789', '2019-05-09 20:56:46', 'fullmoney');

-- ----------------------------
-- Table structure for ps_power_consumer_log
-- ----------------------------
DROP TABLE IF EXISTS `ps_power_consumer_log`;
CREATE TABLE `ps_power_consumer_log` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(10) DEFAULT NULL,
  `accounts` varchar(24) DEFAULT NULL COMMENT '用户账号',
  `power_consumer` decimal(10,0) DEFAULT NULL,
  `consumer_time` datetime DEFAULT NULL COMMENT '消耗时间',
  `consumer_flag` varchar(4) DEFAULT NULL COMMENT '消耗标志负数为减少正数为增加',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_power_consumer_log
-- ----------------------------
INSERT INTO `ps_power_consumer_log` VALUES ('1', '1', 'DX360210123456789', '2', '2019-05-09 20:02:27', '-1');
INSERT INTO `ps_power_consumer_log` VALUES ('2', '1', 'DX360210123456789', '4', '2019-05-09 20:10:36', '-1');
INSERT INTO `ps_power_consumer_log` VALUES ('3', '1', 'DX360210123456789', '7', '2019-05-09 21:02:46', '-1');

-- ----------------------------
-- Table structure for ps_system_table
-- ----------------------------
DROP TABLE IF EXISTS `ps_system_table`;
CREATE TABLE `ps_system_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_param_name` varchar(24) DEFAULT NULL COMMENT '系统参数名',
  `system_param_value` varchar(64) DEFAULT NULL COMMENT '系统参数值',
  `psram_explain` varchar(64) DEFAULT NULL COMMENT '系统参数说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_system_table
-- ----------------------------
INSERT INTO `ps_system_table` VALUES ('1', 'everypass', '0.5', '每度电的价钱');

-- ----------------------------
-- Table structure for ps_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `ps_userinfo`;
CREATE TABLE `ps_userinfo` (
  `userid` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(16) DEFAULT NULL COMMENT '用户姓名',
  `passwords` varchar(35) DEFAULT NULL COMMENT '密码加密存储',
  `salt` varchar(20) DEFAULT NULL COMMENT '加密存储的salt',
  `user_token` varchar(35) DEFAULT NULL COMMENT '用户的token值',
  `accounts` varchar(24) DEFAULT NULL COMMENT '用户账户',
  `hand_pic` varchar(32) DEFAULT NULL COMMENT '用户头像地址',
  `email` varchar(42) DEFAULT NULL COMMENT '邮箱地址',
  `age` varchar(4) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(16) DEFAULT NULL COMMENT '用户的手机号码',
  `identity` varchar(20) DEFAULT NULL COMMENT '用户的身份证号',
  `birthday` varchar(16) DEFAULT NULL COMMENT '出生日期',
  `nationality` varchar(32) DEFAULT NULL,
  `province` varchar(16) DEFAULT NULL COMMENT '省份',
  `city` varchar(16) DEFAULT NULL COMMENT '城市',
  `address` varchar(80) DEFAULT NULL COMMENT '用户的详细地址',
  `create_time` datetime DEFAULT NULL COMMENT '用户注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '用户最后一次登录的时间',
  `current_login_flag` varchar(4) DEFAULT NULL COMMENT '用户是否在登录标志，退出登录时为0，登录时为1',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `accountss` (`accounts`) USING BTREE COMMENT '用户账户建立索引',
  UNIQUE KEY `identity` (`identity`) USING BTREE COMMENT '身份证号唯一',
  UNIQUE KEY `mobile` (`mobile`) USING BTREE COMMENT '身份手机号码唯一',
  UNIQUE KEY `username` (`username`) USING BTREE COMMENT '用户名唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of ps_userinfo
-- ----------------------------
INSERT INTO `ps_userinfo` VALUES ('1', '红火火', '348a937d6b881fe33f61c68afde553ed', 'JUSNkiHvjKgCQjMn', null, 'DX360210123456789', '/pic/images.jpg', '767611329@qq.com', '30', '18912345678', '622301198210020538', '1982年10月02日', '中国', '北京', '大兴区', null, '2019-05-09 20:48:15', '2019-05-09 20:48:18', '0', null);
INSERT INTO `ps_userinfo` VALUES ('2', '红火', '348a937d6b881fe33f61c68afde553ed', 'JUSNkiHvjKgCQjMn', '', 'DX360210123456788', '/pic/images.jpg', '767611329@qq.com', '30', '18912345679', '622301198210020539', '1982年10月02日', '中国', '北京', '大兴区', '', '2019-05-09 20:48:15', '2019-05-09 20:48:18', '0', '');
INSERT INTO `ps_userinfo` VALUES ('3', '张三', '348a937d6b881fe33f61c68afde553ed', 'JUSNkiHvjKgCQjMn', '', 'DX360210123456787', '/pic/images.jpg', '767611329@qq.com', '30', '18912345670', '622301198210020530', '1982年10月02日', '中国', '北京', '大兴区', '', '2019-05-09 20:48:15', '2019-05-09 20:48:18', '0', '');
INSERT INTO `ps_userinfo` VALUES ('4', '李四', '348a937d6b881fe33f61c68afde553ed', 'JUSNkiHvjKgCQjMn', '', 'DX360210123456786', '/pic/images.jpg', '767611329@qq.com', '30', '18912345671', '622301198210020531', '1982年10月02日', '中国', '北京', '大兴区', '', '2019-05-09 20:48:15', '2019-05-09 20:48:18', '0', '');
INSERT INTO `ps_userinfo` VALUES ('5', '王五', '348a937d6b881fe33f61c68afde553ed', 'JUSNkiHvjKgCQjMn', '', 'DX360210123456785', '/pic/images.jpg', '767611329@qq.com', '30', '18912345672', '622301198210020532', '1982年10月02日', '中国', '北京', '大兴区', '', '2019-05-09 20:48:15', '2019-05-09 20:48:18', '0', '');
INSERT INTO `ps_userinfo` VALUES ('6', '赵六', '348a937d6b881fe33f61c68afde553ed', 'JUSNkiHvjKgCQjMn', '', 'DX360210123456784', '/pic/images.jpg', '767611329@qq.com', '30', '18912345673', '622301198210020533', '1982年10月02日', '中国', '北京', '大兴区', '', '2019-05-09 20:48:15', '2019-05-09 20:48:18', '0', '');
INSERT INTO `ps_userinfo` VALUES ('8', 'admin', '9d87a2252481d125e55028b25216d235', 'diptp0do8ptd6mmo', 'QA8RTXu7DpaTCFfXi0iGXN9TGi9RRNRD', '20191901', '/images/head.jpg', '123456@qq.com', '37', '15578888999', '622301198210020534', '1982年10月02日', '中国', '广西', '南宁', '广西壮族自治区南宁市西乡塘区安吉大道15号', '2019-06-04 13:22:30', '2019-06-06 11:58:11', '1', '密码123456');

-- ----------------------------
-- Table structure for ps_use_conumer
-- ----------------------------
DROP TABLE IF EXISTS `ps_use_conumer`;
CREATE TABLE `ps_use_conumer` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `userId` bigint(10) DEFAULT NULL COMMENT '用户的userid',
  `accounts` varchar(24) DEFAULT NULL COMMENT '用户账号',
  `electricitynumber` decimal(10,0) DEFAULT '0' COMMENT '用户所剩电量',
  `surplus_money` decimal(10,0) DEFAULT '0' COMMENT '用户账户所剩余额',
  `balance_warning` decimal(10,0) DEFAULT '20' COMMENT '余额告警设置值',
  `power_warning` decimal(10,0) DEFAULT '30' COMMENT '电量告警设置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户电量和余额消耗表';

-- ----------------------------
-- Records of ps_use_conumer
-- ----------------------------
INSERT INTO `ps_use_conumer` VALUES ('1', '1', 'DX360210123456789', '183', '91', '20', '30');
INSERT INTO `ps_use_conumer` VALUES ('2', '8', '20191901', '1996', '998', '20', '30');
