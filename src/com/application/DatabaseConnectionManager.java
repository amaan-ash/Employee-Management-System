package com.application;

import java.sql.*;

public class DatabaseConnectionManager {
    private Connection connection;
    private final String url;
    private final String userName;
    private final String passWord;

    public DatabaseConnectionManager() {
        this.url ="jdbc:mysql://localhost/amaandb";
        this.userName ="root";
        this.passWord ="skamaanali@0707";
    }

    public void openConnection(){
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, userName, passWord);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
