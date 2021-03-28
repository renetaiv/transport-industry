-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema endava_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema endava_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `endava_project` DEFAULT CHARACTER SET utf8 ;
USE `endava_project` ;

-- -----------------------------------------------------
-- Table `endava_project`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endava_project`.`addresses` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `endava_project`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endava_project`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `egn` CHAR(10) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(320) NOT NULL,
  `'status'` ENUM('active', 'inactive') NOT NULL,
  `addresses_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `addresses_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_users_addresses_idx` (`addresses_id` ASC) VISIBLE,
  UNIQUE INDEX `egn_UNIQUE` (`egn` ASC) VISIBLE,
  CONSTRAINT `fk_users_addresses`
    FOREIGN KEY (`addresses_id`)
    REFERENCES `endava_project`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
