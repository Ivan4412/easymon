/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : file_center

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-18 11:09:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_receiver
-- ----------------------------
DROP TABLE IF EXISTS `t_receiver`;
CREATE TABLE `t_receiver` (
  `receiver_id` varchar(30) NOT NULL COMMENT '接收人ID',
  `receiver_name` varchar(30)   COMMENT '用户姓名',
  `email` varchar(30)   COMMENT '电子邮件',
  `mobile_phone` varchar(11)   COMMENT '手机号码',
  `creater` varchar(30) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `updater` varchar(30) NOT NULL COMMENT '最后更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`receiver_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='信息接收人表';


-- ----------------------------
-- Table structure for t_datasource
-- ----------------------------
DROP TABLE IF EXISTS `t_datasource`;
CREATE TABLE `t_datasource` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据源ID',
  `datasource_desc` varchar(30)   COMMENT '数据源信息描述',
  `drive_class_name` varchar(100)   COMMENT '驱动名称',
  `url` varchar(500)   COMMENT '数据源URL',
  `username` varchar(100)   COMMENT '数据源用户名',
  `password` varchar(100)   COMMENT '数据源密码',
  `creater` varchar(30) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `updater` varchar(30) NOT NULL COMMENT '最后更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='数据源信息表';


-- ----------------------------
-- Table structure for t_monit_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_monit_rule`;
CREATE TABLE `t_monit_rule` (
  `rule_id` varchar(30) NOT NULL COMMENT '监控规则ID',
  `datesource_id` bigint(11)  COMMENT '数据源ID',
  `type` varchar(10) COMMENT '规则类型',
  `content` varchar(1024)   COMMENT '规则内容',
  `expected_result` varchar(100)   COMMENT '预期结果',
  `rule_desc` varchar(500)   COMMENT '规则描述',
  `trigger_type` smallint(2)  COMMENT '触发类型（1-间隔，2-Cron表达式）',
  `trigger_interval` int(10)   COMMENT '触发间隔（单位为秒）',
  `cron_expression` varchar(20)   COMMENT 'Cron表达式',
  `message` varchar(1024)   COMMENT '短信接收内容',
  `send_type` smallint(2)   COMMENT '发送方式(1-立即发送，2-次日发送，3-消息中心自动判断 4-当天只发送一次)',
  `is_vaild` smallint(1)  COMMENT '是否有效（0-否，1-是）',
  `creater` varchar(30) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `updater` varchar(30) NOT NULL COMMENT '最后更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`rule_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='监控规则配置表';

-- ----------------------------
-- Table structure for t_rule_receiver
-- ----------------------------
DROP TABLE IF EXISTS `t_rule_receiver`;
CREATE TABLE `t_rule_receiver` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则_接收人ID',
  `receiver_id` varchar(30) NOT NULL COMMENT '接收人ID',
  `rule_id` varchar(30) NOT NULL COMMENT '监控规则ID',
  `is_mail` smallint(1)  COMMENT '是否发送邮件（0-否，1-是）',
  `is_telephone` smallint(1)  COMMENT '是否发送短信（0-否，1-是）',
  `weChat_addr`  varchar(30) NULL   COMMENT '微信通知地址（0-不通知）',
  `creater` varchar(30) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `updater` varchar(30) NOT NULL COMMENT '最后更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='监控规则接收人配置表';


-- ----------------------------
-- Table structure for t_monit_Log
-- ----------------------------
DROP TABLE IF EXISTS `t_monit_Log`;
CREATE TABLE `t_monit_Log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '监控信息日志ID',
  `rule_id` varchar(30) NOT NULL COMMENT '监控规则ID',
  `receiver_id` varchar(30) COMMENT '接收人ID',
  `result` varchar(1000)   COMMENT '监控结果',
  `is_warning` smallint(1)  COMMENT '是否告警（0-否，1-是）',
  `is_mail` smallint(1)  COMMENT '是否已发送邮件（0-否，1-是）',
  `is_telephone` smallint(1)  COMMENT '是否已发送短信（0-否，1-是）',
  `is_weChat` smallint(1)  COMMENT '是否已发送微信消息（0-否，1-是）',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`id`),
  KEY `idx_created_time` (`created_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='监控信息日志表';


-- ----------------------------
-- Table structure for t_common_req
-- ----------------------------
DROP TABLE IF EXISTS `t_common_req`;
CREATE TABLE `t_common_req` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水号ID',
  `app_id` varchar(30)  COMMENT '渠道ID',
  `interface_name` varchar(50) COMMENT '接口名',
  `is_success` smallint(1)  COMMENT '请求是否成功（0-失败，1-成功，2-中间状态）',
  `req_content` varchar(2000)   COMMENT '请求内容',
  `rsp_content` varchar(2000)   COMMENT '响应内容',
  `return_code` varchar(10)   COMMENT '返回码',
  `remark` varchar(500)   COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`id`),
  KEY `idx_created_time` (`created_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='第三方接口请求记录表';

-- ----------------------------
-- Table structure for t_configuration
-- ----------------------------
DROP TABLE IF EXISTS `t_configuration`;
CREATE TABLE `t_configuration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置ID',
  `name` varchar(30) NOT NULL COMMENT '配置名',
  `content` varchar(200) NOT NULL COMMENT '配置内容',
  `ext` varchar(200) NOT NULL COMMENT '配置扩展内容',
  `is_vaild` smallint(1)  COMMENT '是否有效（0-否，1-是）',
  `creater` varchar(30) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `updater` varchar(30) NOT NULL COMMENT '最后更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

SET FOREIGN_KEY_CHECKS=1;
