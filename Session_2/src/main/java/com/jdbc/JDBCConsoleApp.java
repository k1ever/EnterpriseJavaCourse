package com.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Klever on 14.10.15.
 */
public class JDBCConsoleApp {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        JDBCConsoleApp jdbcConsoleApp = new JDBCConsoleApp();
        Class.forName("com.mysql.jdbc.Driver");

        Properties properties = new Properties();
        jdbcConsoleApp.loadProperties(properties);

        String url = properties.getProperty("url");
        String userName = properties.getProperty("user.name");
        String password = properties.getProperty("user.password");

        Connection connection = DriverManager.getConnection(url, userName, password);

        JDBCOperations operations = new JDBCOperations();

        operations.showTables(connection);


    }

    public void loadProperties(Properties properties) throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.config.files/jdbc.properties");
        properties.load(in);
    }


}