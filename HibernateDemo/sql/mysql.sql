/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2015-08-14 09:18:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ddxx`
-- ----------------------------
DROP TABLE IF EXISTS `ddxx`;
CREATE TABLE `ddxx` (
  `id` int(11) NOT NULL auto_increment,
  `status` varchar(5) default NULL,
  `czid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ddxx
-- ----------------------------
INSERT INTO `ddxx` VALUES ('6', 'qqq', '21');
INSERT INTO `ddxx` VALUES ('7', 'qqq', '222');
INSERT INTO `ddxx` VALUES ('8', 'qqq', '222');
INSERT INTO `ddxx` VALUES ('9', 'aaaaa', '222');
INSERT INTO `ddxx` VALUES ('10', 'P', null);

-- ----------------------------
-- Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `xlid` int(11) NOT NULL auto_increment,
  `xlmc` varchar(250) default NULL,
  PRIMARY KEY  (`xlid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '京广线');
INSERT INTO `line` VALUES ('2', '京哈线');
INSERT INTO `line` VALUES ('3', '广九线');
INSERT INTO `line` VALUES ('4', '哈哈线');
INSERT INTO `line` VALUES ('5', '呵呵呵呵');
INSERT INTO `line` VALUES ('6', '广贵线');
INSERT INTO `line` VALUES ('10', '长唱常常');
INSERT INTO `line` VALUES ('11', '短短短短');
INSERT INTO `line` VALUES ('12', '一一一一');
INSERT INTO `line` VALUES ('13', '名称太长');
INSERT INTO `line` VALUES ('14', '嘻嘻嘻嘻');
INSERT INTO `line` VALUES ('15', '啊啦啦啦');
INSERT INTO `line` VALUES ('16', '嗯嗯嗯嗯');

-- ----------------------------
-- Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `czdm` int(11) NOT NULL auto_increment,
  `czmc` varchar(20) default NULL,
  `dj` varchar(5) default NULL,
  PRIMARY KEY  (`czdm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('3', '上海', '一级');
INSERT INTO `station` VALUES ('4', '南京', '一级');
INSERT INTO `station` VALUES ('5', '武汉', '二级');
INSERT INTO `station` VALUES ('8', '北京西', '特级');
INSERT INTO `station` VALUES ('9', '肇庆', '一级');
INSERT INTO `station` VALUES ('10', '北京', '九级');
INSERT INTO `station` VALUES ('11', '日本', '三级');
INSERT INTO `station` VALUES ('12', '泰国', '零级');
INSERT INTO `station` VALUES ('13', '谢闯', '啊哈');
INSERT INTO `station` VALUES ('15', '香港', '一级');
INSERT INTO `station` VALUES ('16', '湖北', '几级');
INSERT INTO `station` VALUES ('17', '东北', '四级');
INSERT INTO `station` VALUES ('18', '新疆', '二级');
INSERT INTO `station` VALUES ('19', '金光', '十级');
INSERT INTO `station` VALUES ('20', '黄野', '限制级');
INSERT INTO `station` VALUES ('21', '广州东', '一级');
INSERT INTO `station` VALUES ('22', '北京车站', '九级');
INSERT INTO `station` VALUES ('23', '北京车站', '八级级');
INSERT INTO `station` VALUES ('24', '北京车站', '八级级6');
INSERT INTO `station` VALUES ('25', '广州北京', '一级');

-- ----------------------------
-- Table structure for `stationjoinline`
-- ----------------------------
DROP TABLE IF EXISTS `stationjoinline`;
CREATE TABLE `stationjoinline` (
  `SID` int(11) default NULL,
  `LID` int(11) default NULL,
  `ID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stationjoinline
-- ----------------------------
INSERT INTO `stationjoinline` VALUES ('10', '1', '1');
INSERT INTO `stationjoinline` VALUES ('9', '1', '2');
INSERT INTO `stationjoinline` VALUES ('8', '1', '3');
INSERT INTO `stationjoinline` VALUES ('8', '2', '4');
INSERT INTO `stationjoinline` VALUES ('8', '3', '5');
INSERT INTO `stationjoinline` VALUES ('8', '4', '6');

-- ----------------------------
-- Table structure for `x_order`
-- ----------------------------
DROP TABLE IF EXISTS `x_order`;
CREATE TABLE `x_order` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `starttime` date default NULL,
  `price` float(10,3) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_order
-- ----------------------------
INSERT INTO `x_order` VALUES ('4', 'aaaa', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('5', 'zhangsan', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('6', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('7', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('8', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('10', '张三', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('14', '张三', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('15', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('16', '张阿三', '2015-08-10', '15.000');
INSERT INTO `x_order` VALUES ('17', '张思', '2015-08-10', '12.365');
