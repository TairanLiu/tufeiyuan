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
                "  `puppie_name` VARCHAR(45) NOT NULL,\n" +
                "  `puppie_age` INT NOT NULL,\n" +
                "  `puppie_vaccinated` INT NULL,\n" +
                "  `puppie adopted already` INT NOT NULL DEFAULT 0,\n" +
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
                "  `human found home` INT NOT NULL DEFAULT 0,\n" +
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
        String command = "INSERT INTO puppies (`puppie name`, `puppie age`, `puppie vaccinated`,`puppie adopted already`) " +
                "VALUES('"+puppieName+"',"+puppieAge+","+Vaccination+",0);";
        //INSERT INTO `mydb`.`puppies` (`num`, `puppie_name`, `puppie_age`, `puppie_vaccinated`) VALUES (NULL, NULL, NULL, NULL);
        //String command = "INSERT INTO puppies VALUES('"+puppieName+"',"+puppieAge+","+Vaccination+");";
        //?????????????????????
        stmt.execute(command);
        System.out.println("puppie added");
        //try this
    }
    public static void addNewHomoSapient (String pplName, String pplAddress) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "INSERT INTO homoSapient (`name`, `address`, `human found home`) VALUES('"+pplName+"','"+pplAddress+"',0);";
        stmt. execute(command);
        System.out.println("human added");
    }
    public static void addNewPartner (int humanID, int puppieID) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        //System.out.println("Begin adding new partnership");
        String command = "INSERT INTO `partnership` (numOfPuppie, numOfHomoSapient) " +
                "Values ("+puppieID+", "+humanID+");";
        //System.out.println(command);
        //String command = "INSERT INTO `partnership` (numOfPuppie, numOfHomoSapient) " +"Values ('SELECT num FROM puppies WHERE num = "+puppieID+"', 'SELECT * FROM homoSapient WhERE num = "+humanID+"');";

        //INSERT INTO `mydb`.`partnership` (`num`, `numOfPuppie`, `numOfHomoSapient`) VALUES (NULL, NULL, NULL);
        stmt.execute(command);
        //System.out.println("Added partnership");
        humanFoundPuppie(humanID);
        puppieSavedHuman(puppieID);

        System.out.println("New family");
    }

    public static void deadPerson (int humanID) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "DELETE from homoSapient WHERE num = "+humanID+"" ;
        stmt.execute(command);
        System.out.println("get rid of human");
    }
    public static void puppieToHeaven (int puppieID) throws SQLException{
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "DELETE from puppies WHERE num = "+puppieID+"";
        stmt.execute(command);
        System.out.println("Puppie adopted");
    }
    ////////////////
    public static void puppieVaccinated(int puppieID) throws SQLException {
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "UPDATE puppies" +
                "SET `puppie vaccinated`=1" +
                "WHERE num = "+puppieID+";";
        stmt.execute(command);
        System.out.println("happie healthie puppie");
    }
    public static void humanFoundPuppie (int humanID) throws SQLException{
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "UPDATE homoSapient \n" +
                "SET `human found home` = 1\n" +
                "where num = "+humanID+";";
        stmt.execute(command);
        System.out.println("human saved");
    }
    public static void puppieSavedHuman (int puppieID) throws SQLException{
        connection = DriverManager.getConnection(fullURL, username, password);
        Statement stmt = connection.createStatement();
        String command = "UPDATE puppies \n" +
                "SET `puppie adopted already` = 1\n" +
                "where num = "+puppieID+";";
        stmt.execute(command);
        System.out.println("puppie saved human");
    }

}
