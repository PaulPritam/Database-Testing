package com.bridgelabz.selenium.selenium1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class Base {
    public static Connection con;
    public static WebDriver driver = null;

    @BeforeTest
    public Connection getConnection() throws ClassNotFoundException,SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("")
    }
}
