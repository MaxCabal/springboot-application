-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`region` ;

CREATE TABLE IF NOT EXISTS `mydb`.`region` (
  `id_region` INT NOT NULL,
  `region` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_region`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`comuna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`comuna` ;

CREATE TABLE IF NOT EXISTS `mydb`.`comuna` (
  `id_comuna` INT NOT NULL,
  `comuna` VARCHAR(45) NOT NULL,
  `id_region` INT NOT NULL,
  PRIMARY KEY (`id_comuna`),
  INDEX `fk_comunas_region1_idx` (`id_region` ASC) VISIBLE,
  CONSTRAINT `fk_comunas_region1`
    FOREIGN KEY (`id_region`)
    REFERENCES `mydb`.`region` (`id_region`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`paciente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`paciente` (
  `rut` CHAR(10) NOT NULL,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `fec_nac` TIMESTAMP NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL,
  `id_comuna` INT NOT NULL,
  PRIMARY KEY (`rut`),
  INDEX `fk_comuna_comunas1_idx` (`id_comuna` ASC) VISIBLE,
  CONSTRAINT `fk_comuna_comunas1`
    FOREIGN KEY (`id_comuna`)
    REFERENCES `mydb`.`comuna` (`id_comuna`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`atencion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`atencion` ;

CREATE TABLE IF NOT EXISTS `mydb`.`atencion` (
  `id_atencion` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL DEFAULT NULL,
  `diagnostico` VARCHAR(500) NULL DEFAULT NULL,
  `tratamiento` VARCHAR(500) NULL DEFAULT NULL,
  `fec_control` DATETIME NULL DEFAULT NULL,
  `valor` INT UNSIGNED NOT NULL,
  `rut` CHAR(10) NOT NULL,
  PRIMARY KEY (`id_atencion`),
  INDEX `fk_atenciones_pacientes1_idx` (`rut` ASC) VISIBLE,
  CONSTRAINT `fk_atenciones_pacientes1`
    FOREIGN KEY (`rut`)
    REFERENCES `mydb`.`paciente` (`rut`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`gasto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`gasto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`gasto` (
  `fecha` DATE NOT NULL,
  `valor` INT NOT NULL,
  PRIMARY KEY (`fecha`, `valor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`gasto_detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`gasto_detalle` ;

CREATE TABLE IF NOT EXISTS `mydb`.`gasto_detalle` (
  `fecha` DATETIME NOT NULL,
  `valor` INT UNSIGNED NOT NULL,
  `detalle` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`fecha`, `valor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`ingreso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ingreso` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ingreso` (
  `fecha` DATE NOT NULL,
  `valor` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`fecha`, `valor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`ingreso_detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ingreso_detalle` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ingreso_detalle` (
  `fecha` DATETIME NOT NULL,
  `valor` INT UNSIGNED NOT NULL,
  `detalle` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`fecha`, `valor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NULL DEFAULT NULL,
  `contrasena` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
