/*
Navicat MariaDB Data Transfer

Source Server         : webserver
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : iclinic

Target Server Type    : MariaDB
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-03-22 09:17:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for patients
-- ----------------------------
DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `surname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `student_id` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nhif` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `added_by_user_id` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of patients
-- ----------------------------

-- ----------------------------
-- Table structure for patients_contacts
-- ----------------------------
DROP TABLE IF EXISTS `patients_contacts`;
CREATE TABLE `patients_contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) DEFAULT NULL,
  `next_of_kin_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `emergency_phone` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mobile` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `added_by_user_id` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `patients_contacts_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of patients_contacts
-- ----------------------------

-- ----------------------------
-- Table structure for patients_visits
-- ----------------------------
DROP TABLE IF EXISTS `patients_visits`;
CREATE TABLE `patients_visits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) DEFAULT NULL,
  `visit_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `visit_stage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `visit_stage_id` (`visit_stage_id`),
  CONSTRAINT `patients_visits_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `patients_visits_ibfk_2` FOREIGN KEY (`visit_stage_id`) REFERENCES `patients_visits_stages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of patients_visits
-- ----------------------------

-- ----------------------------
-- Table structure for patients_visits_stages
-- ----------------------------
DROP TABLE IF EXISTS `patients_visits_stages`;
CREATE TABLE `patients_visits_stages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `stage_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of patients_visits_stages
-- ----------------------------
INSERT INTO `patients_visits_stages` VALUES ('1', 'New', null);
INSERT INTO `patients_visits_stages` VALUES ('2', 'Visiting', null);
INSERT INTO `patients_visits_stages` VALUES ('3', 'Vitals Collection', null);
INSERT INTO `patients_visits_stages` VALUES ('4', 'Waiting for Doctor', null);
INSERT INTO `patients_visits_stages` VALUES ('5', 'Seeing Doctor', null);
INSERT INTO `patients_visits_stages` VALUES ('6', 'Out of Clinic', null);

-- ----------------------------
-- Table structure for patients_vitals
-- ----------------------------
DROP TABLE IF EXISTS `patients_vitals`;
CREATE TABLE `patients_vitals` (
  `patient_id` int(11) NOT NULL,
  `patients_visits_id` int(11) NOT NULL,
  `vitals_id` int(11) DEFAULT NULL,
  `vital_value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`patient_id`,`patients_visits_id`),
  KEY `patients_visits_id` (`patients_visits_id`),
  KEY `vitals_id` (`vitals_id`),
  CONSTRAINT `patients_vitals_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `patients_vitals_ibfk_2` FOREIGN KEY (`patients_visits_id`) REFERENCES `patients_visits` (`id`),
  CONSTRAINT `patients_vitals_ibfk_3` FOREIGN KEY (`vitals_id`) REFERENCES `vitals` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of patients_vitals
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'vgpE4vmPOGHcKrm0wBpHUOojmK+jGa7oYKWeDvdYpgo=$4mGzENDDIeSr3XgRrYT5hiVmLYpbcWqjZaDNLhsSsPg=');

-- ----------------------------
-- Table structure for vitals
-- ----------------------------
DROP TABLE IF EXISTS `vitals`;
CREATE TABLE `vitals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of vitals
-- ----------------------------
INSERT INTO `vitals` VALUES ('1', 'Blood Pressure', null);
INSERT INTO `vitals` VALUES ('2', 'Height', null);
INSERT INTO `vitals` VALUES ('3', 'Weight', null);
INSERT INTO `vitals` VALUES ('4', 'Temperature', null);
