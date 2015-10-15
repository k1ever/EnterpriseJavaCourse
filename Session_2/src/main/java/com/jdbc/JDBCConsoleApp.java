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

//        operations.showTables(connection);

//        String[] columnsNamesAndTypes = new String[4];
//        columnsNamesAndTypes[0] = "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT";
//        columnsNamesAndTypes[1] = "student_id INT NOT NULL";
//        columnsNamesAndTypes[2] = "subject_id INT NOT NULL";
//        columnsNamesAndTypes[3] = "grade INT NOT NULL";
//        operations.createTable(connection, "grades", 4, columnsNamesAndTypes);
//        operations.getDataFromTable(connection, "grades");

        operations.getDataFromTable(connection, "students");

//        operations.editRecord(connection, "students", 3);
//        operations.getDataFromTable(connection, "students");

        operations.insertRecord(connection, "students");
        operations.getDataFromTable(connection, "students");

//        operations.deleteRecord(connection, "students", 4);3
//        operations.getDataFromTable(connection, "students");


    }

    public void loadProperties(Properties properties) throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.config.files/jdbc.properties");
        properties.load(in);
    }


}
