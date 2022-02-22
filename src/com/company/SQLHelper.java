package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLHelper {
    private static String baseURL = "jdbc:mysql://127.0.0.1:8889/";
    private static String schemaName = "classDemo";
    private static String fullURL = baseURL+schemaName;
    private static String username = "tufeiyuan";
    private static String password = "kaloTC9527";
    private static Connection connection = null;

    public static void createTablePuppies() throws SQLException {
        connection = DriverManager.getConnection(baseURL, username, password);
        Statement stmt = null;
        stmt = connection.createStatement();
        String command = "CREATE TABLE IF NOT EXISTS `katesDB`.`puppies` (\n" +
                "  `num` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `puppie name` VARCHAR(45) NOT NULL,\n" +
                "  `puppie age` INT NOT NULL,\n" +
                "  `puppie vaccinated` INT NULL,\n" +
                "  PRIMARY KEY (`num`),\n" +
                "  UNIQUE INDEX `num_UNIQUE` (`num` ASC))\n" +
                "ENGINE = InnoDB";
        //   String sql = "CREATE TABLE customer(first_name VARCHAR(30) NOT NULL,id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        stmt.execute(command);
        System.out.println("Table created successfully");

    }
    public static void createTableHomoSapients() throws SQLException {
        connection = DriverManager.getConnection(baseURL, username, password);
        Statement stmt = null;
        stmt = connection.createStatement();
        String command = "CREATE TABLE IF NOT EXISTS `katesDB`.`homoSapient` (\n" +
                "  `num` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `address` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`num`),\n" +
                "  UNIQUE INDEX `num_UNIQUE` (`num` ASC) ,\n" +
                "  UNIQUE INDEX `address_UNIQUE` (`address` ASC))\n" +
                "ENGINE = InnoDB";
        //   String sql = "CREATE TABLE customer(first_name VARCHAR(30) NOT NULL,id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        stmt.execute(command);
        System.out.println("Table created successfully");
    }
    public static void createTablePartnership() throws SQLException {
        connection = DriverManager.getConnection(baseURL, username, password);
        Statement stmt = null;
        stmt = connection.createStatement();
        String command = "CREATE TABLE IF NOT EXISTS `katesDB`.`partnership` (\n" +
                "  `num` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `numOfPuppie` INT NULL,\n" +
                "  `numOfHomoSapient` INT NULL,\n" +
                "  PRIMARY KEY (`num`),\n" +
                "  UNIQUE INDEX `num_UNIQUE` (`num` ASC) ,\n" +
                "  INDEX `numOfPuppie_idx` (`numOfPuppie` ASC) ,\n" +
                "  INDEX `numOfHomoSapient_idx` (`numOfHomoSapient` ASC) ,\n" +
                "  CONSTRAINT `numOfPuppie`\n" +
                "    FOREIGN KEY (`numOfPuppie`)\n" +
                "    REFERENCES `katesDB`.`puppies` (`num`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `numOfHomoSapient`\n" +
                "    FOREIGN KEY (`numOfHomoSapient`)\n" +
                "    REFERENCES `katesDB`.`homoSapient` (`num`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB";
        //   String sql = "CREATE TABLE customer(first_name VARCHAR(30) NOT NULL,id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        stmt.execute(command);
        System.out.println("Table created successfully");
    }
    public static void addNewPuppies (String puppieName, String puppieGender, String Vaccination){

    }
    // add new puppies
    // modify
    // delete
}
