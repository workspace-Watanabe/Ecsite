SET names utf8;
SET foreign_key_checks = 0;
DROP DATABASE IF EXISTS ecsite;

CREATE DATABASE IF NOT EXISTS ecsite;
USE ecsite;

DROP TABLE IF EXISTS login_user;
CREATE TABLE login_user(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	login_id VARCHAR(16) UNIQUE,
	login_pass VARCHAR(16),
	user_name VARCHAR(50),
	insert_date DATETIME,
	updated_date DATETIME
);

DROP TABLE IF EXISTS item_info;

CREATE TABLE item_info(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(30),
	item_price INT,
	item_stock INT,
	insert_date DATETIME,
	update_date DATETIME
);

CREATE TABLE user_buy(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	item_id INT,
	total_price INT,
	total_count INT,
	user_id VARCHAR(16),
	pay VARCHAR(30),
	insert_date DATETIME,
	delete_date DATETIME
);

INSERT INTO item_info(item_name, item_price, item_stock) VALUES("ノートBOOK", 100, 50);

INSERT INTO login_user(login_id, login_pass, user_name) VALUES("internous", "internous01" , "test");