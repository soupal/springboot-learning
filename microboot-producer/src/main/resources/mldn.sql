/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : mldn

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-09-24 21:49:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `actid` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) DEFAULT NULL,
  `rid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`actid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action
-- ----------------------------
INSERT INTO `action` VALUES ('dept:edit', '部分编辑', 'dept');
INSERT INTO `action` VALUES ('dept:list', '部分列表', 'dept');
INSERT INTO `action` VALUES ('emp:add', '雇员入职', 'emp');
INSERT INTO `action` VALUES ('emp:edit', '雇员编辑', 'emp');
INSERT INTO `action` VALUES ('emp:list', '雇员列表', 'emp');
INSERT INTO `action` VALUES ('emp:remove', '雇员离职', 'emp');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(50) DEFAULT NULL,
  `loc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', '技术部', '北京');
INSERT INTO `dept` VALUES ('20', '开发部', '北京');
INSERT INTO `dept` VALUES ('30', '财务部', '上海');
INSERT INTO `dept` VALUES ('50', '行政部', '北京');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `mid` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `locked` int(11) DEFAULT '0',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('admin', '管理员', '3792042732634368C98394ED3BFE5E11', '0');
INSERT INTO `member` VALUES ('mldn', '隔壁老王', '3792042732634368C98394ED3BFE5E11', '0');

-- ----------------------------
-- Table structure for member_role
-- ----------------------------
DROP TABLE IF EXISTS `member_role`;
CREATE TABLE `member_role` (
  `mid` varchar(50) DEFAULT NULL,
  `rid` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_role
-- ----------------------------
INSERT INTO `member_role` VALUES ('admin', 'emp');
INSERT INTO `member_role` VALUES ('admin', 'emp');
INSERT INTO `member_role` VALUES ('mldn', 'emp');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('dept', '部门管理');
INSERT INTO `role` VALUES ('emp', '雇员管理');
