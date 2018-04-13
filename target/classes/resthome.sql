/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : resthome

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 19/03/2018 12:35:38
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for oldman
-- ----------------------------
DROP TABLE IF EXISTS `oldman`;
CREATE TABLE `oldman`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  `birthday` date DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `oldman_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oldman
-- ----------------------------
INSERT INTO `oldman` VALUES (1, '张三', '男', 1, '1951-11-11', '这是一个比较和蔼的老人', 66, 'c3737d3b-883c-451c-9a9a-4bdaa7666acf.jpg');
INSERT INTO `oldman` VALUES (2, '赵欢', '男', 1, '1966-11-11', 'dsaasda', 66, '4f677621-0b44-4993-99ab-1b3336171ecc.jpg');
INSERT INTO `oldman` VALUES (3, '流通', '男', 1, '1965-05-06', '刘婷婷拖拖拖拖拖', 56, '49ec941e-aa69-49fb-9154-54447bf894de.jpg');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `oldid` int(10) NOT NULL,
  `roomid` int(10) NOT NULL,
  `createtime` date NOT NULL,
  `duration` int(10) NOT NULL,
  `status` int(10) NOT NULL,
  `price` decimal(50, 0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `oldid`(`oldid`) USING BTREE,
  INDEX `roomid`(`roomid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`oldid`) REFERENCES `oldman` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`roomid`) REFERENCES `room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 1, 1, '2018-03-18', 3, 1, 3000);
INSERT INTO `orders` VALUES (2, 1, 2, 2, '2018-03-18', 5, 1, 7500);
INSERT INTO `orders` VALUES (3, 1, 3, 3, '2018-03-18', 5, 0, 5000);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '101室', 1, 1000, '经典型', '101', '冰箱电视洗衣机空调', 1, '37442f08-79a7-487b-b809-20b84394e108.jpg');
INSERT INTO `room` VALUES (2, '105室', 1, 1500, '豪华型', '150', '冰箱洗衣机', 2, '456b9878-e67b-4746-9495-59543455f9e8.jpg');
INSERT INTO `room` VALUES (3, '102室', 0, 1000, '经典型', '100', '冰箱点式洗衣机', NULL, '71f5a878-2eb6-4149-9269-72eba70c24ea.jpg');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wuhongyu', '1234', '男', '15609261181');

SET FOREIGN_KEY_CHECKS = 1;
