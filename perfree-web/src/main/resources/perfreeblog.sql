/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : perfreeblog

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 03/07/2020 17:29:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `articleTitle` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `articleContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '文章状态0:正常,1:隐藏,2:置顶,3:草稿',
  `thumbnailId` bigint(20) NULL DEFAULT NULL COMMENT '文章缩略图,对应附件Id',
  `articleSummary` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章描述/摘要',
  `thumbnailType` int(1) NOT NULL DEFAULT 0 COMMENT '缩略图类型:0:随机,1:大图,2:小图',
  `categoryId` int(11) NULL DEFAULT NULL COMMENT '所属分类',
  `userId` int(11) NOT NULL COMMENT '发表人',
  `viewCount` bigint(20) NOT NULL DEFAULT 0 COMMENT '浏览量',
  `isEncrypt` int(1) NOT NULL DEFAULT 0 COMMENT '是否加密0:不加密,1:加密',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `keyword` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关键字',
  `isAllowComment` int(1) NULL DEFAULT 0 COMMENT '是否允许评论:0允许,1不允许',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_article_tag`;
CREATE TABLE `t_article_tag`  (
  `articleId` bigint(20) NOT NULL COMMENT '文章id',
  `tagId` int(11) NOT NULL COMMENT '标签id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_article_tag
-- ----------------------------
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);
INSERT INTO `t_article_tag` VALUES (1, 1);

-- ----------------------------
-- Table structure for t_attach
-- ----------------------------
DROP TABLE IF EXISTS `t_attach`;
CREATE TABLE `t_attach`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fileName` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名',
  `fileType` int(1) NOT NULL COMMENT '文件类型1:图片,2:视频,3:音乐,4:文本,5:其他',
  `filePath` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件路径',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_attach
-- ----------------------------
INSERT INTO `t_attach` VALUES (1, '1593509921297-The Mire.png', 1, '/img/1593509921297-The Mire.png', '2020-07-01 09:52:32');
INSERT INTO `t_attach` VALUES (2, '1593509921297-The Mire.png', 1, '/img/1593509921297-The Mire.png', '2020-07-01 11:28:32');
INSERT INTO `t_attach` VALUES (3, '1593509921297-The Mire.png', 1, '/img/1593509921297-The Mire.png', '2020-07-01 11:28:32');
INSERT INTO `t_attach` VALUES (4, '1593509921297-The Mire.png', 1, '/img/1593509921297-The Mire.png', '2020-07-01 11:28:32');
INSERT INTO `t_attach` VALUES (5, '1593594860680-The Forest.png', 1, '/img/1593594860680-The Forest.png', '2020-07-01 09:14:21');
INSERT INTO `t_attach` VALUES (6, '1593594937686-Toxic Valley.png', 1, '/img/1593594937686-Toxic Valley.png', '2020-07-01 09:15:38');
INSERT INTO `t_attach` VALUES (7, '1593595072468-Ash Heap.png', 1, '/img/1593595072468-Ash Heap.png', '2020-07-01 09:17:52');
INSERT INTO `t_attach` VALUES (8, '1593595200671-Cranberry Bog.png', 1, '/img/1593595200671-Cranberry Bog.png', '2020-07-01 09:20:01');
INSERT INTO `t_attach` VALUES (9, '1593595250946-Savage Divide.png', 1, '/img/1593595250946-Savage Divide.png', '2020-07-01 09:20:51');
INSERT INTO `t_attach` VALUES (10, '1593595274060-The Forest.png', 1, '/img/1593595274060-The Forest.png', '2020-07-01 09:21:14');
INSERT INTO `t_attach` VALUES (11, '1593595452023-Toxic Valley.png', 1, '/img/1593595452023-Toxic Valley.png', '2020-07-01 09:24:12');
INSERT INTO `t_attach` VALUES (12, '1593595474765-Savage Divide.png', 1, '/img/1593595474765-Savage Divide.png', '2020-07-01 09:24:35');
INSERT INTO `t_attach` VALUES (13, '1593595540573-Toxic Valley.png', 1, '/img/1593595540573-Toxic Valley.png', '2020-07-01 09:25:41');
INSERT INTO `t_attach` VALUES (14, '1593596067596-The Mire.png', 1, '/img/1593596067596-The Mire.png', '2020-07-01 09:34:28');
INSERT INTO `t_attach` VALUES (15, '1593596097019-Toxic Valley.png', 1, '/img/1593596097019-Toxic Valley.png', '2020-07-01 09:34:57');
INSERT INTO `t_attach` VALUES (16, '1593596247351-The Mire.png', 1, '/img/1593596247351-The Mire.png', '2020-07-01 09:37:27');
INSERT INTO `t_attach` VALUES (17, '1593596501558-Toxic Valley.png', 1, '/img/1593596501558-Toxic Valley.png', '2020-07-01 09:41:42');
INSERT INTO `t_attach` VALUES (18, '1593596546399-Toxic Valley.png', 1, '/img/1593596546399-Toxic Valley.png', '2020-07-01 09:42:26');
INSERT INTO `t_attach` VALUES (19, '1593659817644-Toxic Valley.png', 1, '/img/1593659817644-Toxic Valley.png', '2020-07-02 03:16:58');
INSERT INTO `t_attach` VALUES (20, '1593662000434-Toxic Valley.png', 1, '/img/1593662000434-Toxic Valley.png', '2020-07-02 03:53:20');
INSERT INTO `t_attach` VALUES (21, '1593662428859-Toxic Valley.png', 1, '/img/1593662428859-Toxic Valley.png', '2020-07-02 04:00:29');
INSERT INTO `t_attach` VALUES (22, '1593677481462-The Forest.png', 1, '/img/1593677481462-The Forest.png', '2020-07-02 08:11:21');
INSERT INTO `t_attach` VALUES (23, '1593677612981-The Mire.png', 1, '/img/1593677612981-The Mire.png', '2020-07-02 08:13:33');
INSERT INTO `t_attach` VALUES (24, '1593677701925-Toxic Valley.png', 1, '/img/1593677701925-Toxic Valley.png', '2020-07-02 08:15:02');
INSERT INTO `t_attach` VALUES (25, '1593677733704-Toxic Valley.png', 1, '/img/1593677733704-Toxic Valley.png', '2020-07-02 08:15:34');
INSERT INTO `t_attach` VALUES (26, '1593678215751-Toxic Valley.png', 1, '/img/1593678215751-Toxic Valley.png', '2020-07-02 08:23:36');
INSERT INTO `t_attach` VALUES (27, '1593678258559-Toxic Valley.png', 1, '/img/1593678258559-Toxic Valley.png', '2020-07-02 08:24:19');
INSERT INTO `t_attach` VALUES (28, '1593678308928-The Mire.png', 1, '/img/1593678308928-The Mire.png', '2020-07-02 08:25:09');
INSERT INTO `t_attach` VALUES (29, '1593678345963-Toxic Valley.png', 1, '/img/1593678345963-Toxic Valley.png', '2020-07-02 08:25:46');
INSERT INTO `t_attach` VALUES (30, '1593678381092-The Mire.png', 1, '/img/1593678381092-The Mire.png', '2020-07-02 08:26:21');
INSERT INTO `t_attach` VALUES (31, '1593678551436-Toxic Valley.png', 1, '/img/1593678551436-Toxic Valley.png', '2020-07-02 08:29:11');
INSERT INTO `t_attach` VALUES (32, '1593678612981-The Mire.png', 1, '/img/1593678612981-The Mire.png', '2020-07-02 08:30:13');
INSERT INTO `t_attach` VALUES (33, '1593678635345-The Forest.png', 1, '/img/1593678635345-The Forest.png', '2020-07-02 08:30:35');
INSERT INTO `t_attach` VALUES (34, '1593678669985-The Mire.png', 1, '/img/1593678669985-The Mire.png', '2020-07-02 08:31:10');
INSERT INTO `t_attach` VALUES (35, '1593678991597-Toxic Valley.png', 1, '/img/1593678991597-Toxic Valley.png', '2020-07-02 08:36:32');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `categoryName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名',
  `categoryIcon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类图标',
  `categorySummary` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类简介',
  `seq` int(11) NOT NULL COMMENT '排序',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (3, '1', '/img/1593509921297-The Mire.png', '123', 1, '2020-06-30 09:38:45', '2020-06-30 09:38:45');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `context` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `type` int(1) NOT NULL COMMENT '评论类型：1,文章，2回复',
  `articleId` bigint(20) NOT NULL COMMENT '文章Id',
  `commentator` bigint(20) NOT NULL COMMENT '评论人',
  `audit` int(1) NOT NULL DEFAULT 0 COMMENT '审核：0未审核，1通过，2未通过',
  `auditTime` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `parentId` bigint(20) NULL DEFAULT -1 COMMENT '父级Id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, '哈哈哈', 1, 1, 1, 0, '2020-07-02 14:14:43', '2020-07-02 14:14:46', -1);
INSERT INTO `t_comment` VALUES (2, '呵呵呵', 2, 1, 2, 0, '2020-07-02 14:15:14', '2020-07-02 14:15:17', 1);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名',
  `menuIcon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menuPath` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单路径url',
  `pid` int(11) NOT NULL DEFAULT -1 COMMENT '父菜单id，若为-1则为父菜单',
  `seq` int(64) NOT NULL COMMENT '菜单序号',
  `type` int(11) NOT NULL COMMENT '菜单类型0：后台，1：前台',
  `target` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单打开方式',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `source` int(1) NOT NULL COMMENT '来源:0默认.1用户添加',
  `status` int(1) NOT NULL COMMENT '状态:0可用,1禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '控制台', 'line-chart', '/admin/console', -1, 0, 0, '_self', '2020-04-10 16:10:17', '2020-06-30 01:08:57', 0, 1);
INSERT INTO `t_menu` VALUES (2, '菜单管理', 'menu', '/admin/menus', -1, 4, 0, '_self', '2020-06-22 10:27:39', '2020-06-29 09:33:12', 0, 0);
INSERT INTO `t_menu` VALUES (13, '用户管理', 'user', '/admin/user', -1, 5, 0, '_self', '2020-06-23 01:57:33', '2020-06-30 05:39:14', 0, 0);
INSERT INTO `t_menu` VALUES (14, '分类管理', 'reconciliation', '/admin/category', -1, 2, 0, '_self', '2020-06-23 02:34:06', '2020-06-23 02:34:47', 0, 0);
INSERT INTO `t_menu` VALUES (15, '文章管理', 'audit', '', -1, 1, 0, '_self', '2020-06-29 09:28:51', '2020-06-30 01:09:10', 0, 0);
INSERT INTO `t_menu` VALUES (17, '新建文章', NULL, '/admin/article/create', 15, 1, 0, '_self', '2020-06-30 00:37:06', '2020-06-30 00:47:19', 0, 0);
INSERT INTO `t_menu` VALUES (18, '标签管理', 'tag', '/admin/tag', -1, 3, 0, '_self', '2020-06-30 05:39:00', '2020-06-30 05:39:00', 0, 0);
INSERT INTO `t_menu` VALUES (19, '文章列表', NULL, '/admin/article/list', 15, 2, 0, '_self', '2020-06-30 06:41:58', '2020-06-30 06:41:58', 0, 0);
INSERT INTO `t_menu` VALUES (20, '评论管理', 'container', '/admin/comment', -1, 6, 0, '_self', '2020-07-02 01:32:02', '2020-07-02 01:32:11', 0, 0);
INSERT INTO `t_menu` VALUES (21, '配置管理', 'setting', '/admin/option', -1, 7, 0, '_self', '2020-07-02 02:22:01', '2020-07-02 02:22:01', 1, 0);

-- ----------------------------
-- Table structure for t_option
-- ----------------------------
DROP TABLE IF EXISTS `t_option`;
CREATE TABLE `t_option`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `key` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '键',
  `value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `type` int(1) NOT NULL DEFAULT 1 COMMENT '类型：0系统配置，1用户配置',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_option
-- ----------------------------
INSERT INTO `t_option` VALUES (3, '321', '123', NULL, 1, NULL, NULL);
INSERT INTO `t_option` VALUES (4, '123', '123', NULL, 1, '2020-07-02 04:03:47', '2020-07-02 04:03:47');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(20) NOT NULL COMMENT '主键',
  `roleName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名',
  `roleCode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色代码',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员', 'supperAdmin', '2020-04-13 09:34:42', '2020-04-13 09:34:35');
INSERT INTO `t_role` VALUES (2, '管理员', 'admin', '2020-05-20 08:12:21', '2020-06-30 11:40:36');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `menuId` int(11) NOT NULL COMMENT '菜单id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (1, 13);
INSERT INTO `t_role_menu` VALUES (1, 14);
INSERT INTO `t_role_menu` VALUES (1, 15);
INSERT INTO `t_role_menu` VALUES (1, 17);
INSERT INTO `t_role_menu` VALUES (1, 18);
INSERT INTO `t_role_menu` VALUES (1, 19);
INSERT INTO `t_role_menu` VALUES (1, 20);
INSERT INTO `t_role_menu` VALUES (1, 21);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tagName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, '7777', '2020-06-30 13:54:49', '2020-06-30 06:31:02');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登陆账户',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码加密盐值',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别：0女，1男',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '账户状态：0：正常，1：禁用',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'Admin', '123456', '2b87d050b7b30bc5fc02063126cfe4b6', '557ad0b706834690b0472f41e422a8d4', 'perfree@126.com', 1, 20, 0, '2020-04-10 16:09:30', '2020-04-10 16:09:32');
INSERT INTO `t_user` VALUES (2, 'user33', 'user33', '2a1492b5196e8f4a9aa764a2b30a5202', '626bc87fe7574ee08f36e8df9f05f42b', '123@123', 0, 20, 0, '2020-06-30 02:32:08', '2020-06-30 02:32:08');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `roleId` int(20) NOT NULL COMMENT '角色id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);
INSERT INTO `t_user_role` VALUES (9, 2);
INSERT INTO `t_user_role` VALUES (2, 1);

SET FOREIGN_KEY_CHECKS = 1;
