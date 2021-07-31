// Program to establish connectivity with database and run sql queries

package com.bridgelabz.selenium;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SqlConnectivity {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "Pritampaul@1997";
        Connection con = null;


        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM operation");
        ResultSetMetaData resultSetMetaData = resultset.getMetaData();

        System.out.println("col1" + "\t" + "col2");
        while (resultset.next()) {
            String col1 = resultset.getString(1);
            String col2 = resultset.getString(2);
            System.out.println(col1 + "\t\t" + col2);
        }

    }
}

