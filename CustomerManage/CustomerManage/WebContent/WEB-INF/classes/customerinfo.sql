/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-12-04 01:32:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customerinfo
-- ----------------------------
DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `createtime` bigint(100) DEFAULT NULL,
  `updatetime` bigint(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `areaid` varchar(255) DEFAULT NULL,
  `areaname` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `flag` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
