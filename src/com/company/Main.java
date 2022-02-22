package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
	// write your code here
        String url = "jdbc:mysql://127.0.0.1:8889/katesDB";
        String username = "tufeiyuan";
        String password = "saint123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "CREATE TABLE customer (first_name VarCHAR(30) NOT NULL, id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        try {
            stmt.execute(sql);
            System.out.println("table success");
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

        CREATE TABLE IF NOT EXISTS `mydb`.`partnership` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `numOfPuppie` INT NULL,
  `numOfHomoSapient` INT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `num_UNIQUE` (`num` ASC) VISIBLE,
  INDEX `numOfPuppie_idx` (`numOfPuppie` ASC) VISIBLE,
  INDEX `numOfHomoSapient_idx` (`numOfHomoSapient` ASC) VISIBLE,
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
