package com.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

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

        showCommands();

        Scanner scanner = new Scanner(System.in);
        int operation = -1;

        while (operation != 0){

            System.out.print("Input> ");
            operation = scanner.nextInt();

            switch (operation){
                case 1:
                    operations.showTables(connection);
                    break;
                case 2:
                    //operations.createTable();
                    break;
                case 3:
                    operations.getDataFromTable(connection);
                    break;
                case 4:
                    operations.getPartialDataFromTable(connection, "students");
                    break;
                case 5:
                    operations.editRecord(connection, "students", 3);
                    break;
                case 6:
                    operations.insertRecord(connection, "students");
                    break;
                case 7:
                    operations.deleteRecord(connection, "students", 5);
                    break;
                case 9:
                    showCommands();
                    break;
            }
        }
    }

    public void loadProperties(Properties properties) throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.config.files/jdbc.properties");
        properties.load(in);
    }

    public static void showCommands(){
        System.out.println("Please choose command to execute:");
        System.out.println("    1: Show tables");
        System.out.println("    2: Create new table");
        System.out.println("    3: Get data from table");
        System.out.println("    4: Get partial data from table");
        System.out.println("    5: Edit table's record");
        System.out.println("    6: Insert record into table");
        System.out.println("    7: Delete record from table");
        System.out.println("    0: Exit");
        System.out.println();
    }
}
