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
    public Connection authentication() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        return connection;
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
    public void should_InsertQuery(){
        try {
            connection = this.authentication();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO operation values" +
                    "(?,?,?,?)");
            preparedStatement.setInt(1,8);
            preparedStatement.setString(2,"Squirrel");
            preparedStatement.setInt(3,10);
            preparedStatement.setString(4,"herbivorous");

            preparedStatement.executeUpdate();

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
            connection = this.authentication();

            String query = "DELETE FROM operation WHERE span = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,10);

            preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    DB Testing for Updating a column
     */
    @Test(priority = 3)
    public void should_UpdataDataInDatabase(){

        try {
            connection = this.authentication();

            String query = "UPDATE operation SET span =? WHERE animal = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,25);
            preparedStatement.setString(2,"Crocodile");

            preparedStatement.executeUpdate();
            connection.close();

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
