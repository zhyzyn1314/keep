CREATE TABLE seckill (
	`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
	NAME VARCHAR (120) NOT NULL COMMENT '商品名称',
	number INT NOT NULL COMMENT '库存数量',
	start_time TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
	end_time TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
	create_time TIMESTAMP NOT NULL COMMENT '创建时间',
	PRIMARY KEY (seckill_id),
	KEY idx_start_time (start_time),
	KEY idx_end_time (end_time),
	KEY idx_create_time (create_time)

) ENGINE = INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT = '秒杀库存表';

-- 触发器
DROP TRIGGER IF EXISTS `update_seckill_trigger`;
DELIMITER //
CREATE TRIGGER `update_seckill_trigger` BEFORE UPDATE ON `seckill`
 FOR EACH ROW SET NEW.`create_time` = NOW()
//
DELIMITER ;

insert into seckill (name, number, start_time, end_time)
VALUES
('1000元秒杀iPhone6', '100', '2016-5-19 00:00:00', '2016-5-20 00:00:00'),
('800元秒杀iPad', '200', '2016-5-19 00:00:00', '2016-5-20 00:00:00'),
('600元秒杀三星', '300', '2016-5-19 00:00:00', '2016-5-20 00:00:00'),
('200元秒杀红米note', '400', '2016-5-19 00:00:00', '2016-5-20 00:00:00')
;

create TABLE success_killed(
	seckill_id BIGINT not null comment '秒杀id',
	user_phone BIGINT not null comment '用户手机号',
	state TINYINT not null DEFAULT -1 comment '状态表示：-1 无效 0 成功 1 下单',
	create_time TIMESTAMP not null comment '创建时间',
	PRIMARY KEY (seckill_id, user_phone),
	key idx_create_time(create_time)
) ENGINE = INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT = '秒杀成功明细表';

