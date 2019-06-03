/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80016
Source Host           : localhost:3366
Source Database       : sharpday

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-03 23:00:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_diary
-- ----------------------------
DROP TABLE IF EXISTS `b_diary`;
CREATE TABLE `b_diary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weather` varchar(10) DEFAULT NULL,
  `mood` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `week` varchar(10) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `context` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_diary
-- ----------------------------
INSERT INTO `b_diary` VALUES ('1', 'j', '1', 'da', '2019-06-05 22:59:11', null, '1', 'asd', null);
