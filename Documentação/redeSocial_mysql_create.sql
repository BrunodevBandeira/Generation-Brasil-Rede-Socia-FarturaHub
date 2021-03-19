CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nomeCompleto` varchar(75) NOT NULL,
	`email` varchar(150) NOT NULL UNIQUE,
	`senha` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descricao` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `postagem` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`tema_id` INT NOT NULL AUTO_INCREMENT,
	`usuario_id` INT NOT NULL AUTO_INCREMENT,
	`data` DATETIME NOT NULL,
	`titulo` varchar(100) NOT NULL,
	`descricao` varchar(1000) NOT NULL,
	`regiao` varchar(20) NOT NULL,
	`ajudado` BOOLEAN NOT NULL,
	`nomeAjudante` varchar(50) NOT NULL,
	`contato` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk0` FOREIGN KEY (`tema_id`) REFERENCES `tema`(`id`);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario`(`id`);

