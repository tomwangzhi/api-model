/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : api-common

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2019-08-15 15:28:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_camera_info
-- ----------------------------
CREATE TABLE IF not EXISTS`t_camera_info` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `geo_string` varchar(255) DEFAULT NULL,
  `geometry` geometry DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `capability` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `port` int(11) NOT NULL,
  `rtspuri` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `type` bigint(20) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  `liveurl` varchar(255) DEFAULT NULL,
  `parameter` varchar(1024) NOT NULL DEFAULT '0',
  `code` varchar(255) DEFAULT NULL,
  `c_type` int(11) NOT NULL DEFAULT '1',
  `online` int(11) DEFAULT '2',
  `snap` int(11) DEFAULT '3',
  `app_type` varchar(255) DEFAULT NULL,
  `app_value` varchar(1024) DEFAULT NULL,
  `place_type_id` int(11) DEFAULT NULL,
  `device_type_id` int(11) DEFAULT NULL,
  `capture_bank_id` bigint(64) NOT NULL DEFAULT '1',
  `snaplevel2` int(11) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `project_type` int(11) DEFAULT '0',
  `snap_threshold` int(11) DEFAULT '1',
  `other_info` varchar(1024) DEFAULT NULL,
  `polenum` varchar(255) DEFAULT NULL,
  `sn_code` varchar(255) DEFAULT NULL,
  `mac_address` varchar(255) DEFAULT NULL,
  `ifbox_camera_id` bigint(20) DEFAULT NULL,
  `ifbox_rstspuri` varchar(255) DEFAULT NULL,
  `ifbox_capbility` int(10) DEFAULT NULL,
  `ifbox_height` varchar(255) DEFAULT NULL,
  `ifbox_width` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_camera_info_id` (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

