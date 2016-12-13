/*
 Navicat Premium Data Transfer

 Source Server         : postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 90408
 Source Host           : localhost
 Source Database       : ASVA
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90408
 File Encoding         : utf-8

 Date: 07/21/2016 09:00:35 AM
*/

-- ----------------------------
--  Sequence structure for ads_detail_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "ads_detail_id_seq";
CREATE SEQUENCE "ads_detail_id_seq" INCREMENT 1 START 6 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for ads_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "ads_id_seq";
CREATE SEQUENCE "ads_id_seq" INCREMENT 1 START 13 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for banner_auto_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "banner_auto_id";
CREATE SEQUENCE "banner_auto_id" INCREMENT 1 START 1001 MAXVALUE 9223372036854775807 MINVALUE 1000 CACHE 1;

-- ----------------------------
--  Sequence structure for category_auto_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "category_auto_id";
CREATE SEQUENCE "category_auto_id" INCREMENT 1 START 1026 MAXVALUE 9223372036854775807 MINVALUE 1000 CACHE 1;

-- ----------------------------
--  Sequence structure for item_auto_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "item_auto_id";
CREATE SEQUENCE "item_auto_id" INCREMENT 1 START 1022 MAXVALUE 9223372036854775807 MINVALUE 1000 CACHE 1;

-- ----------------------------
--  Sequence structure for user_auto_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "user_auto_id";
CREATE SEQUENCE "user_auto_id" INCREMENT 1 START 1027 MAXVALUE 9223372036854775807 MINVALUE 1000 CACHE 1;

-- ----------------------------
--  Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS "tb_banner";
CREATE TABLE "tb_banner" (
	"banner_id" int4 NOT NULL DEFAULT nextval('banner_auto_id'::regclass),
	"banner_image" text COLLATE "default",
	"banner_position" text COLLATE "default",
	"banner_width" int4,
	"banner_height" int4,
	"banner_position_type" varchar COLLATE "default",
	"banner_url" text COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS "tb_category";
CREATE TABLE "tb_category" (
	"category_id" int4 NOT NULL DEFAULT nextval('category_auto_id'::regclass),
	"category_name" varchar COLLATE "default",
	"category_image" text COLLATE "default",
	"category_status" int4 DEFAULT 1,
	"main_category_id" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Records of tb_category
-- ----------------------------
BEGIN;
INSERT INTO "tb_category" VALUES ('1006', 'Phone', null, '1', null);
INSERT INTO "tb_category" VALUES ('1015', 'New Phone', 'string', '1', '1006');
INSERT INTO "tb_category" VALUES ('1016', 'New Car', 'http://www.sastacars.in/wp-content/uploads/2015/12/Hyundai-India-Launching-New-Car-Elantra-in-2016.jpg', '1', '1014');
INSERT INTO "tb_category" VALUES ('1017', 'Second Hand Car', 'http://carssearchmanchester.co.uk/wp-content/uploads/2012/08/usedcar1.jpg', '1', '1014');
INSERT INTO "tb_category" VALUES ('1018', 'MacBook', 'http://images.apple.com/macbook-air/images/overview_wireless_hero.jpg', '1', null);
INSERT INTO "tb_category" VALUES ('1021', 'Electronic', 'Electronic', '1', null);
INSERT INTO "tb_category" VALUES ('1025', 'Fan', 'url', '1', '1021');
INSERT INTO "tb_category" VALUES ('1026', 'Air Conditioner', 'url', '1', '1021');
INSERT INTO "tb_category" VALUES ('1014', 'Car', 'string', '1', null);
INSERT INTO "tb_category" VALUES ('1007', 'Second Hands', 'image_url', '1', '1006');
INSERT INTO "tb_category" VALUES ('1022', 'Refrigrator', 'url', '1', '1021');
INSERT INTO "tb_category" VALUES ('1024', 'Washing Machine', 'url', '1', '1021');
COMMIT;

-- ----------------------------
--  Table structure for ads_detail
-- ----------------------------
DROP TABLE IF EXISTS "ads_detail";
CREATE TABLE "ads_detail" (
	"id" int4 NOT NULL DEFAULT nextval('ads_detail_id_seq'::regclass),
	"location" varchar(100) COLLATE "default",
	"type" bit(1),
	"max_width" int4,
	"max_height" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Records of ads_detail
-- ----------------------------
BEGIN;
INSERT INTO "ads_detail" VALUES ('1', 'top', null, null, null);
INSERT INTO "ads_detail" VALUES ('3', 'top_full', null, null, null);
INSERT INTO "ads_detail" VALUES ('2', 'left', '1', null, null);
INSERT INTO "ads_detail" VALUES ('4', 'right', null, null, null);
INSERT INTO "ads_detail" VALUES ('5', 'bottom_small', null, null, null);
INSERT INTO "ads_detail" VALUES ('6', 'bottom_big', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for ads
-- ----------------------------
DROP TABLE IF EXISTS "ads";
CREATE TABLE "ads" (
	"id" int4 NOT NULL DEFAULT nextval('ads_id_seq'::regclass),
	"name" varchar(200) COLLATE "default",
	"owner" varchar(100) COLLATE "default",
	"image" text COLLATE "default",
	"link" text COLLATE "default",
	"width" int4,
	"height" int4,
	"ads_detail_id" int4,
	"order" int2,
	"status" varchar(1) DEFAULT 1 COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Records of ads
-- ----------------------------
BEGIN;
INSERT INTO "ads" VALUES ('3', 'Khmer Academy', 'KSHRD', 'https://i.ytimg.com/vi/9NAJeGiGDHc/maxresdefault.jpg', 'http://khmeracademy.org', '373', '254', '1', '1', '1');
INSERT INTO "ads" VALUES ('2', 'Smart Axiata', 'Smart Axiata', 'http://www.axiata.com/investor-relations/2013/img/chapter5/cambodia-poster2.jpg', 'http://www.smart.com.kh', '373', '254', '1', '2', '1');
INSERT INTO "ads" VALUES ('1', 'Cellcard', 'Cellcard', 'http://www.cellcard.com.kh/Data/Sites/1/media/notbanner/leaflet/newleaflet/osja-big_en_1.jpg', 'http://www.cellcard.com.kh', '373', '254', '1', '3', '1');
INSERT INTO "ads" VALUES ('5', 'Seang Lin', 'Seang Lin', 'http://www.seanglin.com/imgs/299/980x290_logo_03.png', 'http://www.seanglin.com', '119', '254', '3', '1', '1');
INSERT INTO "ads" VALUES ('6', 'AllKhmerPhone', 'AllKhmerPhone', 'http://img.phone.baidu.com/public/uploads/store_7/5/0/e/d180cc59c448f8f00d967540318f578e.png', 'http://fullandroidapk.com/apps.php?id=4294176065', '95', '264', '2', '1', '1');
INSERT INTO "ads" VALUES ('7', 'KoungY', 'KoungY', 'http://cdn8.staztic.com/app/a/4881/4881359/khmer-all-phone-shops-mobile-2-3-s-307x512.jpg', 'http://www.koungy.com', '95', '264', '2', '2', '1');
INSERT INTO "ads" VALUES ('8', 'Khmer2Hand', 'Khmer2Hand', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSHTVpPrGuj9YcaIoY_nb32J1z66xf5LyXRjL9B5X8GU4hhgkV7xw', 'http://www.khmer2hand.com', '95', '264', '4', '1', '1');
INSERT INTO "ads" VALUES ('9', 'Nika', 'Nika', 'http://nika.com.kh/images/Nika-Modern-Phone-Shop.png', 'http://nika.com.kh/home/', '1119', '254', '3', '1', '1');
INSERT INTO "ads" VALUES ('10', 'KoungY', 'KoungY', 'https://phone855.com/assets/clientsite/image/koungy.png', 'http://www.koungy.com', '130', '50', '5', '1', '1');
INSERT INTO "ads" VALUES ('11', 'Hakse', 'Hakse', 'http://www.hakse.com.kh/images/logo.gif', 'http://www.hakse.com.kh', '130', '50', '5', '1', '1');
INSERT INTO "ads" VALUES ('12', 'Phone Price', 'Phone Price', 'https://lh4.ggpht.com/OzPpy4CZFwLKZBvRvmjC3pgkpO2kzh_Nyswz81MpfN4gIPBPSjsNhgnF6eUGqoUFSQ=w300', 'http://windowsphoneapk.com/APK_Khmer-Phone-Shops_Windows-Phone.html', '367', '367', '6', '1', '1');
INSERT INTO "ads" VALUES ('4', 'Heng Heng Phone Shop', 'Heng Heng Phone Shop', 'http://henghengphone.com/wp-content/uploads/2016/03/hengheng-service.jpg', 'http://henghengphone.com', '1119', '254', '3', '2', '1');
COMMIT;

-- ----------------------------
--  Table structure for tb_item
-- ----------------------------
DROP TABLE IF EXISTS "tb_item";
CREATE TABLE "tb_item" (
	"item_id" int4 NOT NULL DEFAULT nextval('item_auto_id'::regclass),
	"item_name" varchar COLLATE "default",
	"item_description" text COLLATE "default",
	"item_image" text COLLATE "default",
	"item_is_sold" bool DEFAULT false,
	"item_category_id" int4,
	"item_user_id" int4,
	"item_status" int4,
	"item_price" float8,
	"item_publish_date" date DEFAULT now()
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Records of tb_item
-- ----------------------------
BEGIN;
INSERT INTO "tb_item" VALUES ('1003', 'iPhone 6S Second Hand', 'Just used 1 month', 'http://brain-images.cdn.dixons.com/7/3/10138637/u_10138637.jpg', 'f', '1007', '1001', '1', '450', '2016-07-12');
INSERT INTO "tb_item" VALUES ('1002', 'iPhone 6S', 'iPhone 6S new inbox.', 'http://brain-images.cdn.dixons.com/7/3/10138637/u_10138637.jpg', 'f', '1015', '1001', '3', '660', '2016-07-12');
INSERT INTO "tb_item" VALUES ('1009', 'Range Rover 2016', '100% New', 'http://frogcars.com/wp-content/gallery/2016-range-rover-evoque/2016-Range-Rover-Evoque-colors_Fuji-White-Solid.jpg', 'f', '1016', '1001', '1', '100000', '2016-07-15');
INSERT INTO "tb_item" VALUES ('1010', 'Lexus LX 570 2016', '100% New', 'http://s1.cdn.autoevolution.com/images/news/gallery/modellista-has-a-wide-body-kit-for-the-2016-lexus-lx-suv-only-japan-will-get-it_6.jpg', 'f', '1016', '1001', '1', '150000', '2016-07-15');
INSERT INTO "tb_item" VALUES ('1011', 'Lexus LX 570 2017', '100% New', 'http://st.motortrend.com/uploads/sites/10/2015/09/2016-Lexus-LX-570-front-three-quarter.jpg?interpolation=lanczos-none&fit=around%7C660%3A439&crop=660%3A439%3B*%2C*', 'f', '1016', '1001', '1', '150000', '2016-07-15');
INSERT INTO "tb_item" VALUES ('1013', 'Lamborghini Egoista', '100% New', 'http://www.topgear.com/sites/default/files/styles/fit_1960x1102/public/news/carousel/2015/04/Large%20Image_10190.jpg?itok=Lgxsgsdk', 'f', '1017', '1001', '1', '15000000', '2016-07-15');
INSERT INTO "tb_item" VALUES ('1012', 'Lamborghini Red 2016', '100% New', 'http://buyersguide.caranddriver.com/media/assets/submodel/6869.jpg', 't', '1016', '1001', '1', '15000000', '2016-07-15');
INSERT INTO "tb_item" VALUES ('1014', 'LG Air Conditioner', 'LG Air Conditioner 2016', 'http://srtechnicool.co.za/wp-content/uploads/2014/09/lg-air-conditioner.jpg', 'f', '1026', '1001', '1', '150', '2016-07-16');
INSERT INTO "tb_item" VALUES ('1015', 'Samsung Inverter Air Conditioner', 'Samsung Split Digital Inverter AC Ranger 2016', 'http://www.samsung.com/in/ac/images/Samsung_New_Air_Triangle_Conditioner.jpg', 'f', '1026', '1001', '1', '199', '2016-07-16');
INSERT INTO "tb_item" VALUES ('1017', 'Panasonic Inverter Air Conditioner', 'Panasonic Inverter Air Conditioner', 'https://doxz7msmg7sxx.cloudfront.net/media/catalog/product/cache/21/image/992x558/9df78eab33525d08d6e5fb8d27136e95/2/0/2086_1.jpg', 'f', '1026', '1001', '1', '189', '2016-07-16');
INSERT INTO "tb_item" VALUES ('1019', 'Samsung ''s Family Hub Smart Fridge 2016', 'Samsung ''s Family Hub Smart Fridge', 'http://icdn8.digitaltrends.com/image/samsung-4-door-flex-refrigerator-with-family-hub-image-1-970x647-c.jpg', 'f', '1022', '1001', '1', '429', '2016-07-17');
INSERT INTO "tb_item" VALUES ('1018', 'LG Refrigerator Smart Inverter 3.0 model 2016', 'LG Refrigerator Smart Inverter 3.0', 'http://www.lg.com/in/images/HA/features/Saves_every_day_ref_hero_banner_Final_newREVISED.jpg', 'f', '1022', '1001', '1', '529', '2016-07-17');
INSERT INTO "tb_item" VALUES ('1020', 'Lg Washing Machine', 'Lg Washing Machine', 'http://www.reviewsbymary.com/wp-content/uploads/2015/06/lg-washing-machine-1.jpg', 'f', '1024', '1001', '1', '329', '2016-07-17');
INSERT INTO "tb_item" VALUES ('1021', 'Hatari Wall Fan', 'Hatari Wall Fan', 'http://www.bigc.co.th/media/catalog/product/cache/1/image/500x/9df78eab33525d08d6e5fb8d27136e95/8/8/8850918003707_2.jpg', 'f', '1025', '1001', '1', '29', '2016-07-17');
INSERT INTO "tb_item" VALUES ('1022', 'iPhone 7 Gold', 'iPhone 7 Gold, Arrived Soon', 'http://cdn.macrumors.com/article-new/2015/02/iphone7mockupantennabands-800x659.jpg', 'f', '1015', '1001', '1', '1129', '2016-07-17');
INSERT INTO "tb_item" VALUES ('1016', 'LG Mosquito Air Conditioner', 'LG Launches its Mosquito-Repelling Air Conditioner', 'http://logbaby.com/files/logo2/52988f658ec97.jpg', 'f', '1026', '1001', '1', '299', '2016-07-16');
COMMIT;

-- ----------------------------
--  Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS "tb_user_role";
CREATE TABLE "tb_user_role" (
	"role_id" int4 NOT NULL,
	"role_name" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Records of tb_user_role
-- ----------------------------
BEGIN;
INSERT INTO "tb_user_role" VALUES ('1000', 'Admin');
INSERT INTO "tb_user_role" VALUES ('2000', 'Editor');
INSERT INTO "tb_user_role" VALUES ('3000', 'Ads');
INSERT INTO "tb_user_role" VALUES ('4000', 'Member');
COMMIT;

-- ----------------------------
--  Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS "tb_user";
CREATE TABLE "tb_user" (
	"user_id" int4 NOT NULL DEFAULT nextval('user_auto_id'::regclass),
	"user_first_name" varchar COLLATE "default",
	"user_last_name" varchar COLLATE "default",
	"user_gender" varchar COLLATE "default",
	"user_email" varchar COLLATE "default",
	"user_password" varchar COLLATE "default",
	"user_photo" text COLLATE "default",
	"user_status" int4,
	"user_telephone" varchar COLLATE "default",
	"user_role" int4,
	"user_status_1" varchar(1) DEFAULT 1 COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO "tb_user" VALUES ('1001', 'Lun', 'Sovathana', 'Male', 'sovathanalun@gmail.com', '123', 'data:image/jpeg;base64,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', '1', '070 565 585', '1000', '0');
INSERT INTO "tb_user" VALUES ('1027', 'Sovathana', 'Lun', 'Male', 'lunsovathana@gmail.com', '123', 'http://images.newseveryday.com/data/images/full/32948/lee-min-ho-news-actor-lee-min-ho-was-in-malaysia-for-kyochon-launching.jpg', null, '012 359 768', '4000', '1');
COMMIT;


-- ----------------------------
--  Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "ads_detail_id_seq" RESTART 7 OWNED BY "ads_detail"."id";
ALTER SEQUENCE "ads_id_seq" RESTART 14 OWNED BY "ads"."id";
ALTER SEQUENCE "banner_auto_id" RESTART 1002;
ALTER SEQUENCE "category_auto_id" RESTART 1027;
ALTER SEQUENCE "item_auto_id" RESTART 1023;
ALTER SEQUENCE "user_auto_id" RESTART 1028;
-- ----------------------------
--  Primary key structure for table tb_banner
-- ----------------------------
ALTER TABLE "tb_banner" ADD PRIMARY KEY ("banner_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tb_category
-- ----------------------------
ALTER TABLE "tb_category" ADD PRIMARY KEY ("category_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table tb_category
-- ----------------------------
ALTER TABLE "tb_category" ADD CONSTRAINT "tb_category_category_name_key" UNIQUE ("category_name") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "tb_category" ADD CONSTRAINT "tb_category_category_name_key1" UNIQUE ("category_name") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table ads_detail
-- ----------------------------
ALTER TABLE "ads_detail" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table ads
-- ----------------------------
ALTER TABLE "ads" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tb_item
-- ----------------------------
ALTER TABLE "tb_item" ADD PRIMARY KEY ("item_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tb_user_role
-- ----------------------------
ALTER TABLE "tb_user_role" ADD PRIMARY KEY ("role_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tb_user
-- ----------------------------
ALTER TABLE "tb_user" ADD PRIMARY KEY ("user_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table tb_category
-- ----------------------------
ALTER TABLE "tb_category" ADD CONSTRAINT "tb_category_main_category_id_fkey" FOREIGN KEY ("main_category_id") REFERENCES "tb_category" ("category_id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table ads
-- ----------------------------
ALTER TABLE "ads" ADD CONSTRAINT "ads_ads_detail_id_fkey" FOREIGN KEY ("ads_detail_id") REFERENCES "ads_detail" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table tb_item
-- ----------------------------
ALTER TABLE "tb_item" ADD CONSTRAINT "tb_item_item_category_id_fkey" FOREIGN KEY ("item_category_id") REFERENCES "tb_category" ("category_id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "tb_item" ADD CONSTRAINT "tb_item_item_user_id_fkey" FOREIGN KEY ("item_user_id") REFERENCES "tb_user" ("user_id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table tb_user
-- ----------------------------
ALTER TABLE "tb_user" ADD CONSTRAINT "tb_user_user_role_fkey" FOREIGN KEY ("user_role") REFERENCES "tb_user_role" ("role_id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

