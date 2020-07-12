/*
Navicat MySQL Data Transfer

Source Server         : localsystem
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : financialmanage

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-07-11 22:57:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `adminname` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'LiMing', '88888');
INSERT INTO `admin` VALUES ('2', 'MZL', '88888');

-- ----------------------------
-- Table structure for budget
-- ----------------------------
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `wid` int NOT NULL AUTO_INCREMENT,
  `wtime` varchar(200) DEFAULT NULL,
  `wnum` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`wid`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `budget_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of budget
-- ----------------------------
INSERT INTO `budget` VALUES ('3', '2020-07', '16000', '1');
INSERT INTO `budget` VALUES ('4', '2020-07', '6000', '17');

-- ----------------------------
-- Table structure for memorandum
-- ----------------------------
DROP TABLE IF EXISTS `memorandum`;
CREATE TABLE `memorandum` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `recordTime` date DEFAULT NULL,
  `thingPath` varchar(200) DEFAULT NULL,
  `topFont` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `memorandum_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of memorandum
-- ----------------------------
INSERT INTO `memorandum` VALUES ('3', '2020-07-07', 'd5bfcddb-e08a-4c3a-a833-ae1291eeb5aa.txt', '我要努力学习，天天向上，追求进步，不断提升自己的专业技术，为以后好好赚钱奠定基础！\r\n', '1');
INSERT INTO `memorandum` VALUES ('7', '2020-07-07', 'f5cdecc8-2ec5-45b1-bd3a-78613348d585.txt', '追求！\r\n', '1');
INSERT INTO `memorandum` VALUES ('8', '2020-07-07', 'eb744969-0220-4465-a2fe-76103bc76737.txt', '冲冲冲！\r\n', '1');
INSERT INTO `memorandum` VALUES ('9', '2020-07-07', '6533cbee-5dce-46c9-8833-4918f43f2d49.txt', '努力赚钱！冲冲冲！\r\n', '1');
INSERT INTO `memorandum` VALUES ('10', '2020-07-07', 'c82e82d5-a3b1-4dde-8097-3572d49b96ff.txt', '好好学习！天天向上！不断提升自己的专业技术水平！不断学习新的知识！马振乐，加油！\r\n', '1');
INSERT INTO `memorandum` VALUES ('11', '2020-07-07', 'e874fc66-3ae0-49c0-9c6f-b79b978b0849.txt', '马振乐会好好学习，以后努力赚钱养宝贝郭倩盈的！臭猪猪！美女！hhhh......哼哼哼\r\n', '1');
INSERT INTO `memorandum` VALUES ('12', '2020-07-07', 'be84d999-d63d-49c1-bc0b-ad37f79951bc.txt', '没有最好，只有更好！加油，加油！马振乐！\r\n', '1');
INSERT INTO `memorandum` VALUES ('13', '2020-07-07', 'e00eacb9-c98f-4718-b500-dcf5017687bb.txt', '马振乐，加油！加油！加油！努力！\r\n', '1');
INSERT INTO `memorandum` VALUES ('14', '2020-07-11', '9469615f-036d-4412-a02a-808a712fe284.txt', '加油！冲冲冲！\r\n', '1');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `nid` int NOT NULL AUTO_INCREMENT,
  `nTitle` varchar(200) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `visitCount` int DEFAULT NULL,
  `recordTime` date DEFAULT NULL,
  `nContent` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '想理财又不懂理财，不妨看看这篇文章', '李民', '理财', '70', '2020-06-05', 'f2.txt');
INSERT INTO `news` VALUES ('2', '想理财又不懂理财，不妨看看这篇文章', '李四', '理财', '52', '2020-06-05', 'f1.txt');
INSERT INTO `news` VALUES ('3', '想理财又不懂理财，不妨看看这篇文章', '赵器', '理财', '39', '2020-06-05', 'f1.txt');
INSERT INTO `news` VALUES ('4', '想理财又不懂理财，不妨看看这篇文章', '锡洪说', '赚钱', '28', '2020-06-05', 'f2.txt');
INSERT INTO `news` VALUES ('5', '想理财又不懂理财，不妨看看这篇文章', '锡洪说', '理财', '21', '2020-06-05', 'f1.txt');
INSERT INTO `news` VALUES ('6', '想理财又不懂理财，不妨看看这篇文章', '锡洪说', '理财', '24', '2020-06-05', 'f1.txt');
INSERT INTO `news` VALUES ('7', '想理财又不懂理财，不妨看看这篇文章', '锡洪说', '理财', '24', '2020-06-05', 'f2.txt');
INSERT INTO `news` VALUES ('8', '想理财又不懂理财，不妨看看这篇文章', '锡洪说', '理财', '21', '2020-06-05', 'f1.txt');
INSERT INTO `news` VALUES ('9', '想理财又不懂理财，不妨看看这篇文章', '锡洪说', '理财', '21', '2020-06-05', 'f1.txt');
INSERT INTO `news` VALUES ('23', '理财', '马振乐', '赚钱', '0', '2020-07-09', 'fe77e5b9-c950-4893-a25b-7af70cabf363.docx');
INSERT INTO `news` VALUES ('27', '理财', '马振乐', '智慧', '0', '2020-07-09', '664e50a5-c573-4672-8249-7d15663fdf37.txt');
INSERT INTO `news` VALUES ('29', '理财好方法', '李四', '智慧', '0', '2020-07-09', 'acad75bb-7315-4109-81a2-2e5085ff51dc.txt');

-- ----------------------------
-- Table structure for shouzhi_category
-- ----------------------------
DROP TABLE IF EXISTS `shouzhi_category`;
CREATE TABLE `shouzhi_category` (
  `szcid` int NOT NULL AUTO_INCREMENT,
  `parent_category` varchar(200) DEFAULT NULL,
  `son_category` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`szcid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of shouzhi_category
-- ----------------------------
INSERT INTO `shouzhi_category` VALUES ('1', '收入', '工资');
INSERT INTO `shouzhi_category` VALUES ('2', '收入', '奖学金');
INSERT INTO `shouzhi_category` VALUES ('3', '支出', '伙食费');
INSERT INTO `shouzhi_category` VALUES ('4', '收入', '比赛奖励');
INSERT INTO `shouzhi_category` VALUES ('5', '支出', '书杂费');
INSERT INTO `shouzhi_category` VALUES ('8', '收入', '奖励');
INSERT INTO `shouzhi_category` VALUES ('11', '支出', '零花钱');
INSERT INTO `shouzhi_category` VALUES ('12', '支出', '公费');
INSERT INTO `shouzhi_category` VALUES ('13', '支出', '其他杂费');
INSERT INTO `shouzhi_category` VALUES ('40', '收入', '兼职');
INSERT INTO `shouzhi_category` VALUES ('41', '支出', '捐款');

-- ----------------------------
-- Table structure for shouzhi_record
-- ----------------------------
DROP TABLE IF EXISTS `shouzhi_record`;
CREATE TABLE `shouzhi_record` (
  `szrid` int NOT NULL AUTO_INCREMENT,
  `szr_num` int DEFAULT NULL,
  `szr_date` date DEFAULT NULL,
  `szr_comment` varchar(200) DEFAULT NULL,
  `shouzhi_category_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`szrid`),
  KEY `user_id` (`user_id`),
  KEY `shouzhi_category_id` (`shouzhi_category_id`),
  CONSTRAINT `shouzhi_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE CASCADE,
  CONSTRAINT `shouzhi_record_ibfk_2` FOREIGN KEY (`shouzhi_category_id`) REFERENCES `shouzhi_category` (`szcid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of shouzhi_record
-- ----------------------------
INSERT INTO `shouzhi_record` VALUES ('1', '-80', '2020-05-21', '早餐', '3', '1');
INSERT INTO `shouzhi_record` VALUES ('3', '3000', '2020-08-08', '暑假工', '1', '1');
INSERT INTO `shouzhi_record` VALUES ('34', '-200', '2020-06-18', '各零碎费', '11', '1');
INSERT INTO `shouzhi_record` VALUES ('35', '1000', '2020-07-03', '宝盛五金厂', '1', '1');
INSERT INTO `shouzhi_record` VALUES ('38', '-400', '2020-07-02', '买早餐', '3', '1');
INSERT INTO `shouzhi_record` VALUES ('39', '-7000', '2020-07-06', '做牙', '13', '1');
INSERT INTO `shouzhi_record` VALUES ('40', '9000', '2020-07-03', '月工资', '1', '1');
INSERT INTO `shouzhi_record` VALUES ('41', '800', '2020-07-05', '互联网+比赛', '8', '1');
INSERT INTO `shouzhi_record` VALUES ('42', '1000', '2020-02-06', '大一上', '2', '1');
INSERT INTO `shouzhi_record` VALUES ('43', '9000', '2020-02-13', '互联网+比赛', '4', '1');
INSERT INTO `shouzhi_record` VALUES ('44', '-8000', '2020-02-10', '捐款', '13', '1');
INSERT INTO `shouzhi_record` VALUES ('45', '1000', '2020-07-10', '大一', '40', '1');
INSERT INTO `shouzhi_record` VALUES ('46', '-500', '2020-07-10', '大一上', '41', '1');
INSERT INTO `shouzhi_record` VALUES ('47', '1000', '2020-07-10', '互联网+比赛', '2', '17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Lisi', '88888', '男', '2198762451@qq.com', '13652707148');
INSERT INTO `user` VALUES ('2', 'mzl', '55555', '男', '2198902814@qq.com', '13652707142');
INSERT INTO `user` VALUES ('3', 'mazhenle', '55555', '男', '2198902814@qq.com', '13652707142');
INSERT INTO `user` VALUES ('14', 'wangwu', '88888', '男', '2765999@qq.com', '13659705142');
INSERT INTO `user` VALUES ('17', 'LiuWei', '99999', '男', '2198762451@qq.com', '13675898878');
INSERT INTO `user` VALUES ('18', 'wangxi', '88888', '女', '2198902814@qq.com', '13675489891');
INSERT INTO `user` VALUES ('19', 'lili', '88888', '男', '2198902814@qq.com', '13675489891');
INSERT INTO `user` VALUES ('20', 'wanyi', '1', '男', '2198902814@qq.com', '13675489891');
INSERT INTO `user` VALUES ('21', 'liurui', '88888', '男', '2198902814@qq.com', '13675489891');
INSERT INTO `user` VALUES ('22', 'guoqianying', '88888', '男', '908426461@qq.com', '15975068343');

-- ----------------------------
-- Table structure for wishlist
-- ----------------------------
DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `wid` varchar(200) DEFAULT NULL,
  `wish` varchar(200) DEFAULT NULL,
  `wnum` int DEFAULT NULL,
  `wdate` date DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of wishlist
-- ----------------------------
INSERT INTO `wishlist` VALUES ('2', '心愿单2020-07-06-01', '继续赚钱', '6000', '2020-07-06', '已完成', '1');
INSERT INTO `wishlist` VALUES ('3', '心愿单2020-06-16-01', '收多出少', '10000', '2020-06-16', '未完成', '1');
INSERT INTO `wishlist` VALUES ('4', '心愿单2020-07-01-01', '加油！', '2000', '2020-07-01', '已完成', '1');
INSERT INTO `wishlist` VALUES ('5', '心愿单2020-07-01-02', '努力奋斗！', '2000', '2020-07-01', '未完成', '1');
INSERT INTO `wishlist` VALUES ('7', '心愿单2020-07-02-01', '向高处走', '8888', '2020-07-02', '未完成', '1');
INSERT INTO `wishlist` VALUES ('8', '心愿单2020-07-03-04', '努力向前走！', '1000', '2020-07-03', '未完成', '1');
INSERT INTO `wishlist` VALUES ('9', '心愿单2020-07-03-01', '我一定能行的！努力赚钱去！加油！向年薪超30万出发！', '20000', '2020-07-03', '未完成', '1');
INSERT INTO `wishlist` VALUES ('11', '心愿单2020-07-03-02', '努力！', '6000', '2020-07-03', '未完成', '1');
INSERT INTO `wishlist` VALUES ('12', '心愿单2020-07-03-03', '加油！', '5000', '2020-07-03', '未完成', '1');
INSERT INTO `wishlist` VALUES ('13', '心愿单2020-07-11-01', '加油！！！', '4000', '2020-07-11', '未完成', '1');
