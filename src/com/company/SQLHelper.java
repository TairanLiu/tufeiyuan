package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLHelper {
    private static String baseURL = "jdbc:mysql://127.0.0.1:8889/";
    private static String schemaName = "katesDB";
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
                "  `puppie vaccinated` INT NOT NULL,\n" +
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

    public static void addNewPuppies (String puppieName, int puppieAge, int Vaccination) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username,password);
        Statement stmt = connection.createStatement();
        String command = "INSERT INTO puppies (`puppie name`, `puppie age`, `puppie vaccinated`) VALUES('"+puppieName+"',"+puppieAge+","+Vaccination+");";
        //INSERT INTO `mydb`.`puppies` (`num`, `puppie_name`, `puppie_age`, `puppie_vaccinated`) VALUES (NULL, NULL, NULL, NULL);
        //String command = "INSERT INTO puppies VALUES('"+puppieName+"',"+puppieAge+","+Vaccination+");";
        //后边的标点很怪
        stmt.execute(command);
        System.out.println("puppie added");
        //try this
    }
    public static void addNewHomoSapient (String pplName, String pplAddress) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "INSERT INTO homoSapient (name, address) VALUES('"+pplName+"','"+pplAddress+"');";
        stmt. execute(command);
        System.out.println("human added");
    }
    public static void addNewPartner (int humanID, int puppieID) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        //String command = "INSERT INTO `partnership` (numOfPuppie, numOfHomoSapient) " +"Values ('SELECT num FROM puppies WHERE num = "+puppieID+"', 'SELECT * FROM homoSapient WhERE num = "+humanID+"');";
        String command = "INSERT INTO `partnership` (numOfPuppie, numOfHomoSapient) " +
                "Values ('"+puppieID+"', '"+humanID+"');";
        //INSERT INTO `mydb`.`partnership` (`num`, `numOfPuppie`, `numOfHomoSapient`) VALUES (NULL, NULL, NULL);
        stmt.execute(command);
        deleteHomoSapient(humanID);
        puppieAdopted(puppieID);
        System.out.println("Puppie adopted");
    }
    public static void deleteHomoSapient(int humanID) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "DELETE from homoSapient WHERE num = "+humanID+"" ;
        stmt.execute(command);
        System.out.println("get rid of human");
    }
    public static void puppieAdopted(int puppieID){

    }
    
    // add new puppies
    // modify will autogenerate delete?
    // delete
}
