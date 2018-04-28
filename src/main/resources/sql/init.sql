DROP DATABASE IF EXISTS kleancierge_product_api;
CREATE DATABASE kleancierge_product_api;
USE kleancierge_product_api;

DROP TABLE IF EXISTS `vendor_review`;
CREATE TABLE vendor_review (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  vendor_id    INT NOT NULL,
  cleaner_id   INT NOT NULL,
  rating_score INT NOT NULL,
  rating_msg   TINYTEXT NOT NULL,
  timestamp    DATETIME NOT NULL,

  UNIQUE KEY vendor_id_idx(`vendor_id`),
  UNIQUE KEY cleaner_id_idx(`cleaner_id`),
  KEY rating_score_idx(`rating_score`)

);

DROP TABLE IF EXISTS `cart`;
CREATE TABLE cart (
  id              INT PRIMARY KEY AUTO_INCREMENT,
  cleaner_id      INT NOT NULL,
  transaction_id  VARCHAR(100),
  last_modified   DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),

  INDEX cleaner_id_idx(cleaner_id),
  INDEX transaction_id_idx(transaction_id),
  INDEX last_modified_idx(last_modified)
);

DROP TABLE IF EXISTS `cart_product`;
CREATE TABLE cart_product (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  product_id  INT NOT NULL,
  cart_id     INT NOT NULL,
  quantity    INT NOT NULL,

  UNIQUE (cart_id, product_id),
  INDEX product_id_idx(product_id),
  INDEX cart_id_idx(cart_id),
  INDEX quantity_idx(quantity)
);

DROP TABLE IF EXISTS `cart_status`;
CREATE TABLE cart_status (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  status    ENUM('TRANSACTED', 'ACTIVE') DEFAULT 'ACTIVE',
  cart_id   INT NOT NULL,

  INDEX status_idx(status),
  INDEX cart_id_idx(cart_id)
);

DROP TABLE IF EXISTS `cleaner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cleaner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `bt_customer_id` VARCHAR(100) DEFAULT NULL,
  `commission_percent` decimal(3,3) DEFAULT '0.300',
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `main_phone` varchar(100) NOT NULL DEFAULT '',
  `main_phone_type` varchar(100) NOT NULL DEFAULT '',

  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `bt_customer_id_idx`(`bt_customer_id`),
  KEY `commission_percent_idx` (`commission_percent`),
  KEY `firstname_idx` (`firstname`),
  KEY `lastname_idx` (`lastname`),
  KEY `main_phone_idx` (`main_phone`),
  KEY `main_phone_type_idx` (`main_phone_type`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `product`;
CREATE TABLE product (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  vendor_id   INT NOT NULL,
  alt_id      VARCHAR(50),
  price       DECIMAL(10,2),
  name        VARCHAR(50),
  description TEXT NOT NULL,
  summary     VARCHAR(255),
  img_url     VARCHAR(100),
  status      ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',

  INDEX vendor_id_idx(vendor_id),
  INDEX alt_id_idx(alt_id),
  INDEX price_idx(price),
  INDEX name_idx(name),
  INDEX status_idx(status)
);

DROP TABLE IF EXISTS `vendor`;
CREATE TABLE vendor (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  name    VARCHAR(100) NOT NULL,
  summary TINYTEXT NOT NULL,
  url     TINYTEXT NOT NULL,
  address VARCHAR(255) NOT NULL,
  img_url TINYTEXT NOT NULL,
  status  ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
  bt_merchant_id VARCHAR(36) DEFAULT NULL,

  INDEX name_idx(name),
  INDEX address_idx(address),
  INDEX status_idx(status),
  INDEX bt_merchant_id_idx(bt_merchant_id)

);

DROP TABLE IF EXISTS `contact`;
CREATE TABLE contact (
  id            INT PRIMARY KEY AUTO_INCREMENT,
  vendor_id     INT NOT NULL,
  first_name    VARCHAR(50) NOT NULL,
  last_name     VARCHAR(50) NOT NULL,
  note          VARCHAR(100) DEFAULT '',
  email_address VARCHAR(50) NOT NULL,

  INDEX vendor_id_idx(vendor_id),
  INDEX first_name_idx(first_name),
  INDEX last_name_idx(last_name),
  INDEX note_idx(note),
  INDEX email_address_idx(email_address)
);

DROP TABLE IF EXISTS `phone`;
CREATE TABLE phone (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  area_code VARCHAR(10) NOT NULL,
  number    VARCHAR(10) NOT NULL,
  extension VARCHAR(10),
  contact_id INT NOT NULL,
  type      ENUM('WORK', 'MOBILE'),

  INDEX area_code_idx(area_code),
  INDEX number_idx(number),
  INDEX extension_idx(extension),
  INDEX contact_id_idx(contact_id),
  INDEX type_idx(type)
);

DROP TABLE IF EXISTS `product_review`;
CREATE TABLE product_review (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  cleaner_id INT NOT NULL,
  product_id INT NOT NULL,
  review     TEXT NOT NULL,
  score      INT NOT NULL,
  time       DATETIME,

  UNIQUE(cleaner_id, product_id),
  INDEX cleaner_id_idx(cleaner_id),
  INDEX product_id_idx(product_id),
  INDEX score_idx(score),
  INDEX time_idx(time)
);

DROP TABLE IF EXISTS `product_fav`;
CREATE TABLE product_fav (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  cleaner_id INT NOT NULL,
  product_id INT NOT NULL,

  UNIQUE(cleaner_id, product_id),
  INDEX cleaner_id_idx(cleaner_id),
  INDEX product_id_idx(product_id)
);

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE user_role (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  role    ENUM('CLEANER', 'VENDOR', 'ADMIN') NOT NULL,

  INDEX user_id_idx(user_id),
  INDEX role_idx(role)
);

DROP TABLE IF EXISTS `cart_vendor_notification`;
CREATE TABLE cart_vendor_notification (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  cart_id   INT NOT NULL,
  vendor_id INT NOT NULL,

  INDEX cart_id_idx(cart_id),
  INDEX vendor_id_idx(vendor_id)
);

DROP TABLE IF EXISTS `cart_product_status`;
CREATE TABLE cart_product_status (
  id              INT PRIMARY KEY AUTO_INCREMENT,
  status          ENUM('IN_CART', 'PENDING', 'SHIPPED') DEFAULT 'IN_CART',
  cart_product_id INT NOT NULL,

  INDEX status_idx(status),
  INDEX cart_product_id_idx(cart_product_id)
);

DROP TABLE IF EXISTS `cart_transaction`;
CREATE TABLE cart_transaction (
  id                INT PRIMARY KEY AUTO_INCREMENT,
  btTransactionId   VARCHAR(36),
  cart_id           INT NOT NULL,

  INDEX btTransactionId_idx(btTransactionId),
  INDEX cart_id_idx(cart_id)
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `email` varchar(100) NOT NULL,
 `password` varchar(100) NOT NULL DEFAULT '',
 `date_created` datetime NOT NULL,
 `active` tinyint(1) NOT NULL DEFAULT '0',
 `account_id` int(11) DEFAULT '0',
 `accepted_eula` datetime DEFAULT NULL,

 PRIMARY KEY (`id`),
 UNIQUE KEY `email` (`email`),
 KEY `email_idx` (`email`),
 KEY `password_idx` (`password`),
 KEY `date_created_idx` (`date_created`),
 KEY `active_idx` (`active`),
 KEY `account_id_idx` (`account_id`),
 KEY `accepted_eula_idx` (`accepted_eula`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE VIEW `vw_current_cart_status` AS
  SELECT cart_status1.id AS id, cart_status1.status AS status, cart_status1.cart_id AS cart_id
  FROM (cart_status AS cart_status1 LEFT JOIN cart_status cart_status2
      ON (((cart_status1.cart_id = cart_status2.cart_id) AND (cart_status1.id < cart_status2.id))))
  WHERE ISNULL(cart_status2.cart_id);

CREATE VIEW `vw_current_cart_product_status` AS
  SELECT cart_product_status1.id AS id, cart_product_status1.status AS status, cart_product_status1.cart_product_id AS cart_product_id
  FROM (cart_product_status AS cart_product_status1 LEFT JOIN cart_product_status AS cart_product_status2
      ON (((cart_product_status1.cart_product_id = cart_product_status2.cart_product_id) AND (cart_product_status1.id < cart_product_status2.id))))
  WHERE ISNULL(cart_product_status2.id);
