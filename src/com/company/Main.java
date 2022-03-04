package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        String url = "jdbc:mysql://127.0.0.1:8889/katesDB";
        String username = "tufeiyuan";
        String password = "kaloTC9527";
        try {
            SQLHelper.createTablePuppies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SQLHelper.createTableHomoSapients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SQLHelper.createTablePartnership();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*try {
            SQLHelper.addNewHomoSapient("Tairan", "US");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try {
            SQLHelper.addNewPuppies("Tufeiyuan",3,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLHelper.puppieVaccinated(1);
        /*try {
            SQLHelper.addNewPartner(1,1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        CREATE TABLE IF NOT EXISTS `mydb`.`puppies` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `puppie name` VARCHAR(45) NOT NULL,
  `puppie age` INT NOT NULL,
                PRIMARY KEY (`num`),
                UNIQUE INDEX `num_UNIQUE` (`num` ASC))
        ENGINE = InnoDB

        CREATE TABLE IF NOT EXISTS `katesDB`.`partnership` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `numOfPuppie` INT NULL,
  `numOfHomoSapient` INT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `num_UNIQUE` (`num` ASC) ,
  INDEX `numOfPuppie_idx` (`numOfPuppie` ASC) ,
  INDEX `numOfHomoSapient_idx` (`numOfHomoSapient` ASC) ,
  CONSTRAINT `numOfPuppie`
    FOREIGN KEY (`numOfPuppie`)
    REFERENCES `mydb`.`puppies` (`num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `numOfHomoSapient`
    FOREIGN KEY (`numOfHomoSapient`)
    REFERENCES `mydb`.`homoSapient` (`num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`homoSapient` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `num_UNIQUE` (`num` ASC) VISIBLE,
  UNIQUE INDEX `address_UNIQUE` (`address` ASC) VISIBLE)
ENGINE = InnoDB*/
    }
    
}
