CREATE TABLE `house` (
`id`  long NOT NULL ,
`date`  datetime NULL COMMENT '数据入库时间' ,
`title`  varchar(255) NULL COMMENT '标题' ,
`total_price`  decimal(20,2) NULL COMMENT '总价' ,
`unit_price`  decimal(20,2) NULL COMMENT '单价' ,
`house_detail`  varchar(255) NULL COMMENT '房屋细节' ,
`community_detail`  varchar(255) NULL COMMENT '小区细节' ,
`label`  varchar(255) NULL COMMENT '标签'
)
;




