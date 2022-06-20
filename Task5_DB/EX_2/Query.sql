-- 1 Find user with username= 'GHTK'
SELECT *
FROM users u 
WHERE username = 'ghtk'

-- 2 Find Top 10 users in 'SG' with oldest age

SELECT *
FROM users u 
WHERE u.province = 'SG'
ORDER BY u.age DESC 
LIMIT 10

-- Create table

CREATE TABLE `users` (
	`id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`username` varchar(45) NOT NULL,
	`fullname` varchar(45) NOT NULL,
	`province` varchar(45) NOT NULL,
	`age` tinyint (3) NOT NULL, 
	 UNIQUE (`username`)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;