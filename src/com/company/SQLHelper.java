package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLHelper {
    private static String baseURL = "jdbc:mysql://127.0.0.1:8889/";
    private static String schemaName = "classDemo";
    private static String fullURL = baseURL+schemaName;
    private static String username = "joey";
    private static String password = "saint123";
    private static Connection connection = null;

    public static void createTablePuppies(String name) throws SQLException {
        connection = DriverManager.getConnection(baseURL, username, password);
        Statement stmt = null;
        stmt = connection.createStatement();
        String command = "CREATE TABLE IF NOT EXISTS `mydb`.`puppies` (\n" +
                "  `num` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `puppie name` VARCHAR(45) NOT NULL,\n" +
                "  `puppie age` INT NOT NULL,\n" +
                "                PRIMARY KEY (`num`),\n" +
                "                UNIQUE INDEX `num_UNIQUE` (`num` ASC))\n" +
                "        ENGINE = InnoDB" + name;
        //   String sql = "CREATE TABLE customer(first_name VARCHAR(30) NOT NULL,id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        stmt.execute(command);
        System.out.println("Table created successfully");

    }
    public static void createTableHomoSapients(String name) throws SQLException {
        connection = DriverManager.getConnection(baseURL, username, password);
        Statement stmt = null;
        stmt = connection.createStatement();
        String command = "CREATE TABLE IF NOT EXISTS `mydb`.`homoSapient` (\n" +
                "  `num` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `address` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`num`),\n" +
                "  UNIQUE INDEX `num_UNIQUE` (`num` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `address_UNIQUE` (`address` ASC) VISIBLE)\n" +
                "ENGINE = InnoDB" + name;
        //   String sql = "CREATE TABLE customer(first_name VARCHAR(30) NOT NULL,id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        stmt.execute(command);
        System.out.println("Table created successfully");
    }
    public static void createTablePartnership(String name) throws SQLException {
        connection = DriverManager.getConnection(baseURL, username, password);
        Statement stmt = null;
        stmt = connection.createStatement();
        String command = "CREATE TABLE IF NOT EXISTS `mydb`.`partnership` (\n" +
                "  `num` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `numOfPuppie` INT NULL,\n" +
                "  `numOfHomoSapient` INT NULL,\n" +
                "  PRIMARY KEY (`num`),\n" +
                "  UNIQUE INDEX `num_UNIQUE` (`num` ASC) VISIBLE,\n" +
                "  INDEX `numOfPuppie_idx` (`numOfPuppie` ASC) VISIBLE,\n" +
                "  INDEX `numOfHomoSapient_idx` (`numOfHomoSapient` ASC) VISIBLE,\n" +
                "  CONSTRAINT `numOfPuppie`\n" +
                "    FOREIGN KEY (`numOfPuppie`)\n" +
                "    REFERENCES `mydb`.`puppies` (`num`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `numOfHomoSapient`\n" +
                "    FOREIGN KEY (`numOfHomoSapient`)\n" +
                "    REFERENCES `mydb`.`homoSapient` (`num`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB" + name;
        //   String sql = "CREATE TABLE customer(first_name VARCHAR(30) NOT NULL,id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY)";
        stmt.execute(command);
        System.out.println("Table created successfully");
    }
}
