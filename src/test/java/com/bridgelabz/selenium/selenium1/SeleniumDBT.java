package com.bridgelabz.selenium.selenium1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class SeleniumDBT {

    /*Establishing Connection */

    static Connection connection = null;
    private static Statement statement;
    private static String url = "jdbc:mysql://localhost:3306/demo";
    public static String username = "root";
    public static String password = "Pritampaul@1997";

    @BeforeTest
    public void authentication() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    /*
    DB Testing to display all data
     */
    @Test(priority = 4)
    public void shouldReturn_AllDataFromDatabase() {
        try {
            String query = "SELECT * FROM operation";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
                System.out.print(" " + res.getString(3));
                System.out.println(" " + res.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    DB Testing for insert query
     */
    @Test(priority = 1)
    public void should_InsertQuery() {
        try {
            String query = "INSERT INTO operation(sno,animal,span,animal_type) " +
                    "VALUES (8,'Squirrel',8,'herbivorous')";

            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    DB Testing for Deleting a column
     */
    @Test(priority = 2)
    public void should_DeletedataFromDatabase() {
        try {
            String query = "DELETE FROM operation WHERE sno=8";

            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    DB Testing for Updating a column
     */
    @Test(priority = 3)
    public void should_UpdataDataInDatabase() {
        try {
            String query = "UPDATE operation SET span =40 " +
                    "WHERE animal = 'Bear'";

            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Closing Database connection
    */
    @AfterTest
    public void endTest() throws Exception {
        if (connection != null)
            connection.close();
    }
}
