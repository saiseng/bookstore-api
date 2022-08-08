CREATE USER 'dxc_test_user'@'localhost' IDENTIFIED BY 'password';
-- CREATE USER 'dxc_test_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';


GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'dxc_test_user'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;


# re-login as dxc_test_user
mysql -u dxc_test_user -p


CREATE DATABASE dxc_test CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

CREATE  TABLE `dxc_test`.`author` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL ,
	`birthday` DATE,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE  TABLE `dxc_test`.`book` (
	`id` INT AUTO_INCREMENT,
	`isbn` VARCHAR(255) NOT NULL ,
	`title` VARCHAR(255) NOT NULL ,
	`author_id` INT,
	`year` SMALLINT NOT NULL ,
	`price` DECIMAL(10,2) NOT NULL ,
	`genre` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (author_id) REFERENCES author(id)
) ENGINE = InnoDB;


