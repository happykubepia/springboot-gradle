CREATE TABLE IF NOT EXISTS `tb_user` (
  `user_id` varchar(20) NOT NULL,
  `user_nm` varchar(30) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `cell_phone` varchar(20) DEFAULT NULL,
  `agree_inform` varchar(50) DEFAULT NULL,
  `birth_dt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;