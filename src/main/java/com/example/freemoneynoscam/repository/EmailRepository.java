package com.example.freemoneynoscam.repository;

import com.example.freemoneynoscam.utility.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmailRepository {

    static Statement stmt;
    static String sqlString;
    static ResultSet rs;
    private Connector c = new Connector();
    private Connection con = c.connectDB();


    public void insertEmailToDB (String email){
        c.connectDB();
        try{
            stmt = con.createStatement();
            sqlString = "INSERT INTO `test_db`.`email_table` (email) VALUES ('"+ email +"')";
            stmt.executeUpdate(sqlString);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String fetchSingleEmail(){
        c.connectDB();
        String email = "";
        try{
           stmt = con.createStatement();
           sqlString = "SELECT `email` FROM `test_db`.`email_table` WHERE `email_table`.`id`= 1";
           rs = stmt.executeQuery(sqlString);
           rs.next();
           email = rs.getString(1);
        } catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }

    public List<String> fetchAllEmails(){
        c.connectDB();

        ArrayList<String> emailList = new ArrayList<>();

        try{
            stmt = con.createStatement();
            sqlString = "SELECT * FROM `test_db`.`email_table`";
            ResultSet allEmailsResultSet = stmt.executeQuery(sqlString);

            while (allEmailsResultSet.next()){
                emailList.add(allEmailsResultSet.getString(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return emailList;
    }
}
