/*
Navicat MariaDB Data Transfer

Source Server         : webserver
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : iclinic

Target Server Type    : MariaDB
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-03-15 12:07:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'vgpE4vmPOGHcKrm0wBpHUOojmK+jGa7oYKWeDvdYpgo=$4mGzENDDIeSr3XgRrYT5hiVmLYpbcWqjZaDNLhsSsPg=');
