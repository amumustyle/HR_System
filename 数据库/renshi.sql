/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : renshi
Target Host     : localhost:3306
Target Database : renshi
Date: 2016-07-15 22:16:37
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for depart
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `departid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `departname` varchar(16) CHARACTER SET utf8 NOT NULL,
  `departtype` varchar(5) CHARACTER SET utf8 NOT NULL,
  `departtel` varchar(11) CHARACTER SET utf8 NOT NULL,
  `departst` varchar(10) CHARACTER SET utf8 NOT NULL,
  `departisdel` varchar(2) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  PRIMARY KEY (`departid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES ('101', '财务部', '部门', '13812345676', '2016-01-01', '0');
INSERT INTO `depart` VALUES ('102', '人事部', '部门', '13812345671', '2016-01-01', '0');
INSERT INTO `depart` VALUES ('103', '市场部', '部门', '13812345672', '2016-01-01', '0');
INSERT INTO `depart` VALUES ('104', '生产部', '部门', '13812345673', '2016-01-01', '0');
INSERT INTO `depart` VALUES ('105', '信息部', '部门', '13812345674', '2016-01-01', '0');
INSERT INTO `depart` VALUES ('106', '证券部', '部门', '13812345675', '2016-01-01', '0');
INSERT INTO `depart` VALUES ('111', '阿斯顿', '公司', '13811111111', '2016-07-01', '1');

-- ----------------------------
-- Table structure for empin
-- ----------------------------
DROP TABLE IF EXISTS `empin`;
CREATE TABLE `empin` (
  `empid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `empname` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `empsex` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `empbirth` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `empidcard` varchar(20) CHARACTER SET utf8 NOT NULL,
  `empdepart` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `emppost` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `empindate` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `empinwork` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `emptype` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `empfrom` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`empid`,`empidcard`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empin
-- ----------------------------
INSERT INTO `empin` VALUES ('101', '南基俊', '男', '1994-12-15', '111111199412151111', '人事部', '总经理', '2016-07-01', '2016-07-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('102', '方文昊', '男', '1994-10-03', '222222199410032222', '人事部', '总经理秘书', '2016-07-02', '2016-07-02', '正式工', '校园');
INSERT INTO `empin` VALUES ('103', '黄欧伟', '男', '1994-01-01', '444444199401014444', '人事部', '总经理秘书', '2016-07-01', '2016-07-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('104', '杨克盛', '男', '1994-04-09', '333333199404093333', '人事部', '总经理秘书', '2016-07-03', '2016-07-03', '正式工', '社会');
INSERT INTO `empin` VALUES ('105', '康英哲', '男', '1994-01-01', '555555199401015555', '财务部', '财务总监', '2016-07-01', '2016-07-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('106', '黄颖健', '男', '1994-01-01', '666666199401016666', '财务部', '财务副总监', '2016-06-01', '2016-06-01', '正式工', '社会');
INSERT INTO `empin` VALUES ('107', '张润杰', '男', '1994-01-01', '777777199401017777', '市场部', '销售经理', '2016-06-01', '2016-06-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('108', '吴海婧', '女', '1994-01-01', '888888199401018888', '市场部', '销售经理', '2016-06-01', '2016-06-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('109', '田月', '女', '1994-01-01', '999999199401019999', '财务部', '财务副总监', '2016-06-01', '2016-06-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('110', '舒慕蓉', '女', '1994-01-01', '100000199401011000', '财务部', '财务副总监', '2016-06-01', '2016-06-01', '正式工', '校园');
INSERT INTO `empin` VALUES ('111', '江河', '男', '1994-01-01', '100001199401011001', '市场部', '销售经理', '2016-07-01', '2016-07-01', '正式工', '校园');

-- ----------------------------
-- Table structure for empout
-- ----------------------------
DROP TABLE IF EXISTS `empout`;
CREATE TABLE `empout` (
  `empid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `empname` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `empsex` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `empbirth` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `empidcard` varchar(20) CHARACTER SET utf8 NOT NULL,
  `empdepart` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `emppost` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `empindate` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `empinwork` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `emptype` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `empfrom` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `empouttype` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `empoutdate` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`empid`,`empidcard`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empout
-- ----------------------------
INSERT INTO `empout` VALUES ('123', '是大法官', '男', '2016-07-02', '111111111111111111', '人事部', '总经理', '2016-07-01', '2016-07-17', '正式工', '社会', '主动辞职', '2016-07-01');
INSERT INTO `empout` VALUES ('555', '杨克仙儿', '男', '2016-07-01', '111111111111111111', '人事部', '总经理', '2016-07-01', '2016-07-01', '正式工', '校园', '主动辞职', '2016-07-01');
INSERT INTO `empout` VALUES ('666', '杨克神', '男', '2016-07-01', '1333333333333333', '人事部', '总经理', '2016-07-01', '2016-07-01', '正式工', '校园', '主动辞职', '2016-07-01');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `postname` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `posttype` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `postisdel` varchar(3) CHARACTER SET utf8 DEFAULT '0',
  PRIMARY KEY (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('111', '财务总监', '市场', '0');
INSERT INTO `post` VALUES ('112', '人事主管', '管理', '0');
INSERT INTO `post` VALUES ('113', '销售经理', '营销', '0');
INSERT INTO `post` VALUES ('114', '总经理', '管理', '0');
INSERT INTO `post` VALUES ('115', '总经理秘书', '管理', '0');
INSERT INTO `post` VALUES ('116', '董事长', '管理', '0');
INSERT INTO `post` VALUES ('117', '财务副总监', '市场', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(10) CHARACTER SET utf8 NOT NULL,
  `password` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '123123');
