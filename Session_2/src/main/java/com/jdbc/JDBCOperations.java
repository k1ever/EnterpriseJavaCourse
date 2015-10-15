package com.jdbc;


import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by Klever on 14.10.15.
 */
public class JDBCOperations {

    public void showTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SHOW TABLES");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
        System.out.println();
    }

    public void createTable(Connection connection) throws SQLException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter table name: ");
        String tableName = input.nextLine();
        System.out.print("Enter column count: ");
        int columnCount = input.nextInt();
        input.nextLine(); //to avoid empty string on next nexlLine call, Scanner class bug

        System.out.println("Enter column name,type and options separated by whitespace: ");
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append("CREATE TABLE ");
        sqlStr.append(tableName + "(");
        for (int i=1; i<=columnCount; i++){
            System.out.println("Column" + (i) + ": ");
            sqlStr.append(input.nextLine());
            if (i != columnCount){   //we don't need comma after last parameter
                sqlStr.append(", ");
            }
        }
        sqlStr.append(")");

        Statement statement = connection.createStatement();
        statement.execute(sqlStr.toString());

    }

    public void getDataFromTable (Connection connection) throws SQLException {
        System.out.print("Enter table name: ");
        Scanner input = new Scanner(System.in);
        String tableName = input.nextLine();

        String sqlStr = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement();
        statement.execute(sqlStr);
        ResultSet resultSet = statement.getResultSet();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //display columns names and types
        int columnsCount = resultSetMetaData.getColumnCount();
        for (int i=1; i<=columnsCount; i++){
            System.out.print(resultSetMetaData.getColumnName(i) + "(" + resultSetMetaData.getColumnTypeName(i) + ") ");
        }
        System.out.println();

        //display table data
        while (resultSet.next()){
            for (int i=1; i<=columnsCount; i++){
                System.out.print(resultSet.getString(i) + " ");  //every data type will be casted to String for output
            }
            System.out.println();
        }
        System.out.println();
    }

    public void getPartialDataFromTable (Connection connection) throws SQLException {
        System.out.print("Enter table name: ");
        Scanner input = new Scanner(System.in);
        String tableName = input.nextLine();
        System.out.print("Enter rows per page count: ");
        int rowsPerPage = input.nextInt();
        input.nextLine(); //to avoid empty string on next nextLine call, Scanner class bug

        String sqlStr = "SELECT * FROM " + tableName;
        CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setPageSize(rowsPerPage);
        rowSet.setCommand(sqlStr);
        rowSet.execute(connection);
        ResultSetMetaData resultSetMetaData = rowSet.getMetaData();

        //display columns names and types (head of table)
        String tableHead = "";
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i=1; i<=columnCount; i++){
            tableHead += resultSetMetaData.getColumnName(i) + "(" + resultSetMetaData.getColumnTypeName(i) + ") ";
        }
        System.out.println();

        int pageCommand = -1;

        while (pageCommand !=0){
            System.out.println(tableHead);
            while (rowSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rowSet.getString(i) + " ");  //every data type will be casted to String for output
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("1: Next page, 2: Previous page, 0: Main menu");

            pageCommand = input.nextInt();

            switch (pageCommand){
                case 1:
                    rowSet.nextPage();
                    break;
                case 2:
                    rowSet.previousPage();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }


    public void insertRecord(Connection connection) throws SQLException {
        System.out.print("Enter table name: ");
        Scanner input = new Scanner(System.in);
        String tableName = input.nextLine();

        //this piece is just to retrieve table's metadata
        String sqlStr = "SELECT * FROM " + tableName + " WHERE 1=0";
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.execute(sqlStr);
        ResultSet resultSet = statement.getResultSet();
        ResultSetMetaData tableMetaData = resultSet.getMetaData();

        resultSet.moveToInsertRow();

        int coulumnCount = tableMetaData.getColumnCount();

        for (int i=1; i<=coulumnCount; i++){
            System.out.print(tableMetaData.getColumnName(i) + "(" + tableMetaData.getColumnTypeName(i) + "): ");
            String value = input.nextLine();
            resultSet.updateObject(i, value);
        }
        resultSet.insertRow();
    }

    public void editRecord(Connection connection) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter table name: ");
        String tableName = input.nextLine();
        System.out.print("Enter row number (NOT ID): ");
        int rowNumber = input.nextInt();
        input.nextLine(); //to avoid empty string on next nextLine call, Scanner class bug


        String sqlStr = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.execute(sqlStr);
        ResultSet resultSet = statement.getResultSet();

        ResultSetMetaData tableMetaData = resultSet.getMetaData();

        resultSet.absolute(rowNumber);

        int coulumnCount = tableMetaData.getColumnCount();

        for (int i=1; i<=coulumnCount; i++){
            System.out.print(tableMetaData.getColumnName(i) + "(" + tableMetaData.getColumnTypeName(i) + "): ");
            String value = input.nextLine();
            resultSet.updateObject(i, value);
        }

        resultSet.updateRow();
    }

    public void deleteRecord(Connection connection) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter table name: ");
        String tableName = input.nextLine();
        System.out.print("Enter row number (NOT ID): ");
        int rowNumber = input.nextInt();
        input.nextLine(); //to avoid empty string on next nextLine call, Scanner class bug

        String sqlStr = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.execute(sqlStr);
        ResultSet resultSet = statement.getResultSet();
        resultSet.absolute(rowNumber);
        resultSet.deleteRow();
    }

}
