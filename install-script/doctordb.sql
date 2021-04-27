-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema doctordb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `doctordb` ;

-- -----------------------------------------------------
-- Schema doctordb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `doctordb` DEFAULT CHARACTER SET utf8 ;
USE `doctordb` ;

-- -----------------------------------------------------
-- Table `doctordb`.`doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doctordb`.`doctor` ;

CREATE TABLE IF NOT EXISTS `doctordb`.`doctor` (
  `id_doctor` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `speciality` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `address` VARCHAR(100) NULL,
  `photo` VARCHAR(50) NULL,
  PRIMARY KEY (`id_doctor`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_doctor_UNIQUE` ON `doctordb`.`doctor` (`id_doctor` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `doctordb`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doctordb`.`patient` ;

CREATE TABLE IF NOT EXISTS `doctordb`.`patient` (
  `id_patient` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `address` VARCHAR(500) NULL,
  `photo` VARCHAR(45) NULL,
  PRIMARY KEY (`id_patient`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_patient_UNIQUE` ON `doctordb`.`patient` (`id_patient` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `doctordb`.`medical_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doctordb`.`medical_record` ;

CREATE TABLE IF NOT EXISTS `doctordb`.`medical_record` (
  `id_medical_record` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `date` DATETIME NOT NULL,
  `prescription_drug` VARCHAR(500) NULL,
  `id_doctor_medical_record` INT NOT NULL,
  `id_patient_medical_record` INT NOT NULL,
  PRIMARY KEY (`id_medical_record`, `id_patient_medical_record`, `id_doctor_medical_record`))
ENGINE = InnoDB;

CREATE INDEX `fk_medical_record_doctor_idx` ON `doctordb`.`medical_record` (`id_doctor_medical_record` ASC) VISIBLE;

CREATE INDEX `fk_medical_record_patient1_idx` ON `doctordb`.`medical_record` (`id_patient_medical_record` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_medical_record_UNIQUE` ON `doctordb`.`medical_record` (`id_medical_record` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `doctordb`.`prescription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doctordb`.`prescription` ;

CREATE TABLE IF NOT EXISTS `doctordb`.`prescription` (
  `id_prescription` INT NOT NULL AUTO_INCREMENT,
  `medicine_detail` VARCHAR(200) NULL,
  `quantity` VARCHAR(45) NULL,
  `id_medical_record_id_prescription` INT NOT NULL,
  PRIMARY KEY (`id_prescription`, `id_medical_record_id_prescription`))
ENGINE = InnoDB;

CREATE INDEX `fk_prescription_medical_record1_idx` ON `doctordb`.`prescription` (`id_medical_record_id_prescription` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_prescription_UNIQUE` ON `doctordb`.`prescription` (`id_prescription` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
