CREATE TABLE `house` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`date`  datetime NULL ON UPDATE CURRENT_TIMESTAMP ,
`title`  varchar(255) NULL ,
`total_price`  decimal(20,2) NULL ,
`unit_price`  decimal(20,2) NULL ,
`house_detail`  varchar(255) NULL ,
`community_detail`  varchar(255) NULL ,
`label`  varchar(255) NULL ,
PRIMARY KEY (`id`)
)
;
