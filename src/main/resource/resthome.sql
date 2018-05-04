/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : resthome

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 04/05/2018 20:30:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '管理员', 21, '男', '21122222222222');

-- ----------------------------
-- Table structure for contacts
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `relation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `oldid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oldid`(`oldid`) USING BTREE,
  CONSTRAINT `contacts_ibfk_1` FOREIGN KEY (`oldid`) REFERENCES `oldman` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES (1, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 1);
INSERT INTO `contacts` VALUES (2, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 1);
INSERT INTO `contacts` VALUES (3, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 2);
INSERT INTO `contacts` VALUES (4, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 2);
INSERT INTO `contacts` VALUES (5, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 3);
INSERT INTO `contacts` VALUES (6, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 3);
INSERT INTO `contacts` VALUES (7, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 4);
INSERT INTO `contacts` VALUES (8, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 4);
INSERT INTO `contacts` VALUES (9, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 5);
INSERT INTO `contacts` VALUES (10, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 5);
INSERT INTO `contacts` VALUES (11, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 6);
INSERT INTO `contacts` VALUES (12, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 7);
INSERT INTO `contacts` VALUES (13, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 7);
INSERT INTO `contacts` VALUES (14, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 8);
INSERT INTO `contacts` VALUES (15, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 8);
INSERT INTO `contacts` VALUES (16, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 9);
INSERT INTO `contacts` VALUES (17, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 9);
INSERT INTO `contacts` VALUES (18, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 10);
INSERT INTO `contacts` VALUES (19, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 10);
INSERT INTO `contacts` VALUES (20, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 11);
INSERT INTO `contacts` VALUES (21, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 11);
INSERT INTO `contacts` VALUES (22, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 12);
INSERT INTO `contacts` VALUES (23, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 12);
INSERT INTO `contacts` VALUES (24, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 13);
INSERT INTO `contacts` VALUES (25, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 13);
INSERT INTO `contacts` VALUES (26, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 14);
INSERT INTO `contacts` VALUES (27, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 14);
INSERT INTO `contacts` VALUES (28, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 15);
INSERT INTO `contacts` VALUES (29, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 15);
INSERT INTO `contacts` VALUES (30, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 16);
INSERT INTO `contacts` VALUES (31, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 16);
INSERT INTO `contacts` VALUES (32, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 17);
INSERT INTO `contacts` VALUES (33, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 17);
INSERT INTO `contacts` VALUES (34, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 18);
INSERT INTO `contacts` VALUES (35, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 18);
INSERT INTO `contacts` VALUES (36, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 19);
INSERT INTO `contacts` VALUES (37, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 19);
INSERT INTO `contacts` VALUES (38, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 20);
INSERT INTO `contacts` VALUES (39, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 20);
INSERT INTO `contacts` VALUES (40, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 21);
INSERT INTO `contacts` VALUES (41, '张益达', '男', 21, '156666666', '辽宁省铁岭市开原县', '222222222222', '备注备注', '父子', 21);
INSERT INTO `contacts` VALUES (42, '林宛瑜', '女', 21, '156666666', '辽宁省铁岭市开原县', '222222221111', '备注备注', '父女', 6);

-- ----------------------------
-- Table structure for counts
-- ----------------------------
DROP TABLE IF EXISTS `counts`;
CREATE TABLE `counts`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `createtime` date DEFAULT NULL,
  `uid` int(10) DEFAULT NULL,
  `sid` int(10) DEFAULT NULL,
  `absence` int(10) DEFAULT NULL COMMENT '缺席',
  `wage` decimal(10, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `sid`(`sid`) USING BTREE,
  CONSTRAINT `counts_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `counts_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `salary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of counts
-- ----------------------------
INSERT INTO `counts` VALUES (1, NULL, 6, 6, NULL, NULL);
INSERT INTO `counts` VALUES (2, NULL, 7, 7, NULL, NULL);
INSERT INTO `counts` VALUES (3, NULL, 8, 8, NULL, NULL);
INSERT INTO `counts` VALUES (4, NULL, 9, 9, NULL, NULL);
INSERT INTO `counts` VALUES (5, NULL, 10, 10, NULL, NULL);

-- ----------------------------
-- Table structure for leaves
-- ----------------------------
DROP TABLE IF EXISTS `leaves`;
CREATE TABLE `leaves`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `createdate` date DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `uid` int(10) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  `deduct` decimal(10, 2) DEFAULT NULL COMMENT '本次扣除的工资',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `leaves_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of leaves
-- ----------------------------
INSERT INTO `leaves` VALUES (5, '2018-05-04', '测试', 6, 1, 100.00);
INSERT INTO `leaves` VALUES (6, '2018-05-04', '测试2', 6, 2, 150.00);

-- ----------------------------
-- Table structure for lelve
-- ----------------------------
DROP TABLE IF EXISTS `lelve`;
CREATE TABLE `lelve`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `lelve` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` decimal(10, 2) DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `oldid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oldid`(`oldid`) USING BTREE,
  CONSTRAINT `lelve_ibfk_1` FOREIGN KEY (`oldid`) REFERENCES `oldman` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lelve
-- ----------------------------
INSERT INTO `lelve` VALUES (1, 'A', 300.00, '随便备注一下', 1);
INSERT INTO `lelve` VALUES (2, 'A', 300.00, '随便备注一下', 2);
INSERT INTO `lelve` VALUES (3, 'A', 300.00, '随便备注一下', 3);
INSERT INTO `lelve` VALUES (4, 'A', 300.00, '随便备注一下', 4);
INSERT INTO `lelve` VALUES (5, 'B', 400.00, '随便备注一下', 5);
INSERT INTO `lelve` VALUES (6, 'B', 400.00, '随便备注一下', 6);
INSERT INTO `lelve` VALUES (7, 'B', 400.00, '随便备注一下', 7);
INSERT INTO `lelve` VALUES (8, 'B', 400.00, '随便备注一下', 8);
INSERT INTO `lelve` VALUES (9, 'B', 400.00, '随便备注一下', 9);
INSERT INTO `lelve` VALUES (10, 'B', 400.00, '随便备注一下', 10);
INSERT INTO `lelve` VALUES (11, 'C', 500.00, '随便备注一下', 11);
INSERT INTO `lelve` VALUES (12, 'C', 500.00, '随便备注一下', 12);
INSERT INTO `lelve` VALUES (13, 'C', 500.00, '随便备注一下', 13);
INSERT INTO `lelve` VALUES (14, 'C', 500.00, '随便备注一下', 14);
INSERT INTO `lelve` VALUES (15, 'C', 500.00, '随便备注一下', 15);
INSERT INTO `lelve` VALUES (16, 'C', 600.00, '随便备注一下', 16);
INSERT INTO `lelve` VALUES (17, 'C', 600.00, '随便备注一下', 17);
INSERT INTO `lelve` VALUES (18, 'C', 600.00, '随便备注一下', 18);
INSERT INTO `lelve` VALUES (19, 'C', 600.00, '随便备注一下', 19);
INSERT INTO `lelve` VALUES (20, 'C', 600.00, '随便备注一下', 20);
INSERT INTO `lelve` VALUES (21, 'A', 300.00, '随便备注一下', 21);
INSERT INTO `lelve` VALUES (22, 'A', 300.00, NULL, 22);

-- ----------------------------
-- Table structure for malfunction
-- ----------------------------
DROP TABLE IF EXISTS `malfunction`;
CREATE TABLE `malfunction`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `oldid` int(10) DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oldid`(`oldid`) USING BTREE,
  CONSTRAINT `malfunction_ibfk_1` FOREIGN KEY (`oldid`) REFERENCES `oldman` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of malfunction
-- ----------------------------
INSERT INTO `malfunction` VALUES (1, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 1, '备注备注');
INSERT INTO `malfunction` VALUES (2, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 2, '备注备注');
INSERT INTO `malfunction` VALUES (3, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 3, '备注备注');
INSERT INTO `malfunction` VALUES (4, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 4, '备注备注');
INSERT INTO `malfunction` VALUES (5, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 5, '备注备注');
INSERT INTO `malfunction` VALUES (6, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 6, '备注备注');
INSERT INTO `malfunction` VALUES (7, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 7, '备注备注');
INSERT INTO `malfunction` VALUES (8, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 8, '备注备注');
INSERT INTO `malfunction` VALUES (9, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 9, '备注备注');
INSERT INTO `malfunction` VALUES (10, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 10, '备注备注');
INSERT INTO `malfunction` VALUES (11, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 11, '备注备注');
INSERT INTO `malfunction` VALUES (12, '小事故', '洗了一下被褥', '尿床', '2018-05-01', 12, '备注备注');
INSERT INTO `malfunction` VALUES (13, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 13, '备注备注');
INSERT INTO `malfunction` VALUES (14, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 14, '备注备注');
INSERT INTO `malfunction` VALUES (15, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 15, '备注备注');
INSERT INTO `malfunction` VALUES (16, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 16, '备注备注');
INSERT INTO `malfunction` VALUES (17, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 17, '备注备注');
INSERT INTO `malfunction` VALUES (18, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 18, '备注备注');
INSERT INTO `malfunction` VALUES (19, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 19, '备注备注');
INSERT INTO `malfunction` VALUES (20, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 20, '备注备注');
INSERT INTO `malfunction` VALUES (21, '小事故', '老人发脾气', '被其他老人嘲笑了一下', '2018-05-01', 21, '备注备注');

-- ----------------------------
-- Table structure for oldman
-- ----------------------------
DROP TABLE IF EXISTS `oldman`;
CREATE TABLE `oldman`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `uid` int(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `marital` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '婚姻状态',
  `political` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '政治面貌',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `oldman_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oldman
-- ----------------------------
INSERT INTO `oldman` VALUES (1, '张三', '男', 6, '1952-11-20', '和蔼可亲的老人', 66, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (2, '李四', '男', 6, '1953-06-06', '和蔼可亲的老人', 65, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (3, '王五', '男', 6, '1952-08-09', '和蔼可亲的老人', 65, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (4, '赵春丽', '男', 6, '1969-11-01', '和蔼可亲的老人', 52, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (5, '马八一', '男', 7, '1965-12-13', '和蔼可亲的老人', 55, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (6, '刘东强', '男', 7, '1930-03-04', '和蔼可亲的老人', 80, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (7, '任冬冬', '女', 7, '1932-05-14', '和蔼可亲的老人', 86, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (8, '宋江', '男', 7, '1969-10-05', '和蔼可亲的老人', 58, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (9, '王可', '女', 8, '1962-11-05', '和蔼可亲的老人', 58, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (10, '李三妹', '女', 8, '1936-06-05', '和蔼可亲的老人', 81, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (11, '赵文龙', '男', 8, '1967-05-04', '和蔼可亲的老人', 81, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (12, '陈亚楠', '女', 8, '1952-01-05', '和蔼可亲的老人', 65, '没有添加图片', '2133145645646646', '已婚', '党员');
INSERT INTO `oldman` VALUES (13, '刘若若', '女', 8, '1965-02-02', '和蔼可亲的老人', 52, '没有添加图片', '2133145645646646', '再婚', '党员');
INSERT INTO `oldman` VALUES (14, '肖楚楚', '女', 9, '1952-01-05', '和蔼可亲的老人', 65, '没有添加图片', '2133145645646646', '丧偶', '党员');
INSERT INTO `oldman` VALUES (15, '王大刚', '男', 9, '1950-01-09', '和蔼可亲的老人', 58, '没有添加图片', '2133145645646646', '丧偶', '党员');
INSERT INTO `oldman` VALUES (16, '许思思', '女', 9, '1931-05-18', '和蔼可亲的老人', 81, '没有添加图片', '2133145645646646', '丧偶', '党员');
INSERT INTO `oldman` VALUES (17, '刘莹莹', '女', 9, '1953-06-21', '和蔼可亲的老人', 61, '没有添加图片', '2133145645646646', '丧偶', '党员');
INSERT INTO `oldman` VALUES (18, '王萌萌', '女', 10, '1958-11-15', '和蔼可亲的老人', 52, '没有添加图片', '2133145645646646', '丧偶', '党员');
INSERT INTO `oldman` VALUES (19, '刘丝丝', '女', 10, '1958-11-15', '和蔼可亲的老人', 52, '没有添加图片', '2133145645646646', '丧偶', '党员');
INSERT INTO `oldman` VALUES (20, '张丹丹', '女', 10, '1958-11-15', '和蔼可亲的老人', 58, '没有添加图片', '2133145645646646', '再婚', '党员');
INSERT INTO `oldman` VALUES (21, '王二狗', '男', 10, '1945-01-09', '和蔼可亲的老人', 72, '没有添加图片', '2133145645646646', '再婚', '党员');
INSERT INTO `oldman` VALUES (22, '测试', '男', 6, NULL, '1111111', 11, NULL, '11111111', '11111', '11111');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) DEFAULT NULL,
  `oldid` int(10) DEFAULT NULL,
  `roomid` int(10) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `duration` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `price` decimal(50, 0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `oldid`(`oldid`) USING BTREE,
  INDEX `roomid`(`roomid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`oldid`) REFERENCES `oldman` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`roomid`) REFERENCES `room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 6, 1, 1, '2017-01-01', 36, 1, 7200);
INSERT INTO `orders` VALUES (2, 6, 2, 2, '2017-02-02', 36, 1, 7200);
INSERT INTO `orders` VALUES (3, 6, 3, 3, '2017-03-01', 24, 1, 4800);
INSERT INTO `orders` VALUES (4, 6, 4, 4, '2017-04-01', 48, 1, 9600);
INSERT INTO `orders` VALUES (7, 7, 5, 5, '2017-04-02', 36, 1, 7200);
INSERT INTO `orders` VALUES (8, 7, 6, 6, '2017-05-01', 28, 1, 5600);
INSERT INTO `orders` VALUES (9, 7, 7, 7, '2017-06-02', 64, 1, 12800);
INSERT INTO `orders` VALUES (10, 7, 8, 8, '2017-07-01', 36, 1, 7200);
INSERT INTO `orders` VALUES (11, 8, 9, 9, '2017-08-01', 48, 1, 9600);
INSERT INTO `orders` VALUES (12, 8, 10, 10, '2017-09-01', 48, 1, 9600);
INSERT INTO `orders` VALUES (13, 8, 11, 11, '2017-10-01', 96, 1, 19200);
INSERT INTO `orders` VALUES (14, 8, 12, 12, '2017-11-01', 80, 1, 16000);
INSERT INTO `orders` VALUES (15, 9, 13, 13, '2017-12-01', 48, 1, 9600);
INSERT INTO `orders` VALUES (16, 9, 13, 13, '2018-01-01', 48, 2, 9600);
INSERT INTO `orders` VALUES (17, 9, 14, 14, '2018-01-15', 48, 1, 9600);
INSERT INTO `orders` VALUES (18, 9, 15, 15, '2018-01-20', 96, 1, 19200);
INSERT INTO `orders` VALUES (19, 9, 16, 16, '2018-02-01', 48, 1, 9600);
INSERT INTO `orders` VALUES (20, 9, 17, 17, '2018-02-05', 86, 1, 17200);
INSERT INTO `orders` VALUES (21, 10, 18, 18, '2018-03-03', 48, 1, 9600);
INSERT INTO `orders` VALUES (22, 10, 19, 19, '2018-03-05', 48, 1, 14400);
INSERT INTO `orders` VALUES (23, 10, 20, 20, '2018-04-01', 96, 1, 28800);
INSERT INTO `orders` VALUES (24, 10, 21, 21, '2018-04-26', 88, 1, 26400);
INSERT INTO `orders` VALUES (28, 6, 22, 22, '2018-05-04', 3, 1, 900);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `price` decimal(50, 0) DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `area` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `configure` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `oldid` int(10) DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oldid`(`oldid`) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`oldid`) REFERENCES `oldman` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '101', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 1, '没有添加图片');
INSERT INTO `room` VALUES (2, '102', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 2, '没有添加图片');
INSERT INTO `room` VALUES (3, '103', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 3, '没有添加图片');
INSERT INTO `room` VALUES (4, '104', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 4, '没有添加图片');
INSERT INTO `room` VALUES (5, '105', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 5, '没有添加图片');
INSERT INTO `room` VALUES (6, '106', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 6, '没有添加图片');
INSERT INTO `room` VALUES (7, '107', 1, 200, '经典型', '120', '冰箱,洗衣机,空调,电视,热水器', 7, '没有添加图片');
INSERT INTO `room` VALUES (8, '108', 1, 200, '经典型', '80', '冰箱,洗衣机,空调,电视,热水器', 8, '没有添加图片');
INSERT INTO `room` VALUES (9, '201', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 9, '没有添加图片');
INSERT INTO `room` VALUES (10, '202', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 10, '没有添加图片');
INSERT INTO `room` VALUES (11, '203', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 11, '没有添加图片');
INSERT INTO `room` VALUES (12, '204', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 12, '没有添加图片');
INSERT INTO `room` VALUES (13, '205', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 13, '没有添加图片');
INSERT INTO `room` VALUES (14, '206', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 14, '没有添加图片');
INSERT INTO `room` VALUES (15, '207', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 15, '没有添加图片');
INSERT INTO `room` VALUES (16, '208', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 16, '没有添加图片');
INSERT INTO `room` VALUES (17, '301', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 17, '没有添加图片');
INSERT INTO `room` VALUES (18, '302', 1, 200, '经典型', '100', '冰箱,洗衣机,空调,电视,热水器', 18, '没有添加图片');
INSERT INTO `room` VALUES (19, '303', 1, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', 19, '没有添加图片');
INSERT INTO `room` VALUES (20, '304', 1, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', 20, '没有添加图片');
INSERT INTO `room` VALUES (21, '305', 1, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', 21, '没有添加图片');
INSERT INTO `room` VALUES (22, '306', 1, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', 22, '没有添加图片');
INSERT INTO `room` VALUES (23, '307', 0, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', NULL, '没有添加图片');
INSERT INTO `room` VALUES (24, '308', 0, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', NULL, '没有添加图片');
INSERT INTO `room` VALUES (25, '401', 0, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', NULL, '没有添加图片');
INSERT INTO `room` VALUES (26, '402', 0, 300, '豪华型', '100', '冰箱,洗衣机,空调,电视,热水器,电磁炉,微波炉', NULL, '没有添加图片');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `salary` decimal(10, 2) DEFAULT NULL,
  `uid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (6, 3000.00, 6);
INSERT INTO `salary` VALUES (7, 3000.00, 7);
INSERT INTO `salary` VALUES (8, 3000.00, 8);
INSERT INTO `salary` VALUES (9, 3000.00, 9);
INSERT INTO `salary` VALUES (10, 3000.00, 10);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'wuhongyu', '1234', '男', '156666666', '吴宏宇', 20, '2222222215464');
INSERT INTO `user` VALUES (7, 'zhaohuan', '1234', '男', '15666666', '赵欢', 20, '1242424242424');
INSERT INTO `user` VALUES (8, 'liutong', '1234', '男', '155555555', '刘通', 20, '2111144545212121');
INSERT INTO `user` VALUES (9, 'liusihan', '1234', '女', '121452452', '刘思涵', 20, '1124524245245');
INSERT INTO `user` VALUES (10, 'liutianyuan', '1234', '男', '155555555', '刘天元', 20, '242452424524');

SET FOREIGN_KEY_CHECKS = 1;
