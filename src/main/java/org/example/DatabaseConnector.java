package org.example;

import java.sql.*;

public class DatabaseConnector {
    public Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:C:/Users/dayle/Documents/CTAC Program/JDBCLab/src/daylen.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
        return connection;
    }

    public void selectAllBooks() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.connect();
            String sql = "SELECT * FROM Books";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);



            while (rs.next()) {
                System.out.println(rs.getString("title") + "\t" +
                                   rs.getString("author") + "\t" +
                                   rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error selecting books");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




}
