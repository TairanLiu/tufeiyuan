package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        String url = "jdbc:mysql://127.0.0.1:8889/katesDB";
        String username = "tufeiyuan";
        String password = "kaloTC9527";

        Scanner user = new Scanner(System.in);
        System.out.println("enter username");
        String inputUsername = user.nextLine();
        System.out.println("enter password");
        String inputPassowrd = user.nextLine();

        if (inputPassowrd.equals(password) && inputUsername.equals(username)){
            SQLHelper.createTablePuppies();
            SQLHelper.createTableHomoSapients();
            SQLHelper.createTablePartnership();
            System.out.println("Are you on behalf of a puppie or a homo sapient?");
            String userBehalf = user.nextLine();
            if (userBehalf.equals("puppie")){
                System.out.println("What do you want");
                String userIntent = user.nextLine();
                if (userIntent.equals("I found a puppie")){
                    System.out.println("give me puppie name, age, vaccination. Enter to seperate info");
                    String newPuppieName = user.nextLine();
                    String newPuppieAgeStr = user.nextLine();
                    String newPuppieVaccinationStr = user.nextLine();
                    int newPuppieAge = Integer.parseInt(newPuppieAgeStr);
                    int newPuppieVaccination = Integer.parseInt(newPuppieVaccinationStr);
                    SQLHelper.addNewPuppies(newPuppieName,newPuppieAge,newPuppieVaccination);
                }else if (userIntent.equals("a puppie is back home")){
                    System.out.println("who?");
                    int heavenPuppieID = Integer.parseInt(user.nextLine());
                    SQLHelper.puppieToHeaven(heavenPuppieID);
                }else if (userIntent.equals("a puppie is vaccinated")){
                    System.out.println("who?");
                    int vaccPuppID = Integer.parseInt(user.nextLine());
                    SQLHelper.puppieVaccinated(vaccPuppID);
                }else{
                    System.out.println("You human");
                    System.exit(999);
                }
            }else if (userBehalf.equals("homo sapient")){
                System.out.println("what do you want?");
                String userIntent = user.nextLine();
                if (userIntent.equals("I want a puppie")){
                    System.out.println("put down your name and address. Enter to seperate");
                    String userName = user.nextLine();
                    String userAddress = user.nextLine();
                    SQLHelper.addNewHomoSapient(userName,userAddress);
                }else if (userIntent.equals("I'm dead")){
                    System.out.println("who do you think you are");
                    int deadID = Integer.parseInt(user.nextLine());
                    SQLHelper.deadPerson(deadID);
                }else if (userIntent.equals("We are together")){
                    System.out.println("who are you? Which angel saves you? enter to seperate");
                    int humanID = Integer.parseInt(user.nextLine());
                    int puppieID = Integer.parseInt(user.nextLine());
                    SQLHelper.addNewPartner(humanID,puppieID);
                }else{
                    System.out.println("shoo");
                    System.exit(678);
                }
            }else{
                System.out.println("shoo");
                System.exit(233);
            }
        }else{
            System.out.println("perish");
            //what is this status?
            System.exit(666);
        }
/*
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


        try {
            SQLHelper.addNewHomoSapient("Tairan", "US");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SQLHelper.addNewPuppies("Tufeiyuan",3,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //SQLHelper.puppieVaccinated(1);
        try {
            SQLHelper.addNewPartner(10,11);
        } catch (SQLException e) {
            e.printStackTrace();
        }


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
