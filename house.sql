CREATE TABLE `house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(255) DEFAULT NULL,
  `total_price` decimal(20,2) DEFAULT NULL,
  `unit_price` decimal(20,2) DEFAULT NULL,
  `house_detail` varchar(255) DEFAULT NULL,
  `community_detail` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_all` (`title`,`house_detail`,`community_detail`,`label`)
);
