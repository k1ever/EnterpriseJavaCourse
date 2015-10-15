package com.jdbc;


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

    public void createTable(Connection connection, String tableName, int columnsCount, String[] columnsNamesAndTypes) throws SQLException {
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append("CREATE TABLE ");
        sqlStr.append(tableName + "(");
        for (int i=1; i<=columnsCount; i++){
            sqlStr.append(columnsNamesAndTypes[i-1]);
            if (i != columnsCount){   //we don't need comma after last parameter
                sqlStr.append(", ");
            }
        }
        sqlStr.append(")");

        Statement statement = connection.createStatement();
        statement.execute(sqlStr.toString());

    }

    public void getDataFromTable (Connection connection, String tableName) throws SQLException {
        String sqlStr = "SELECT * FROM " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.execute(sqlStr);
        ResultSet resultSet = preparedStatement.getResultSet();

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

    public void getPartialDataFromTable (Connection connection, String tableName) throws SQLException {
        //todo
    }


    public void insertRecord(Connection connection, String tableName) throws SQLException {
        //this piece is just to retrieve table's metadata
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM " + tableName + " WHERE 1=0");
        ResultSet resultSet = statement.getResultSet();
        ResultSetMetaData tableMetaData = resultSet.getMetaData();


        StringBuilder sqlInsertStr = new StringBuilder();
        sqlInsertStr.append("INSERT INTO ");
        sqlInsertStr.append(tableName + "(");

        int coulumnsCount = tableMetaData.getColumnCount();
        for (int i=1; i<=coulumnsCount; i++){
            sqlInsertStr.append(tableMetaData.getColumnName(i));
            if (i!=coulumnsCount){
                sqlInsertStr.append(", ");
            }
        }
        sqlInsertStr.append(") VALUES(");

        Scanner input = new Scanner(System.in);
        for (int i=1; i<=coulumnsCount; i++){
            System.out.print(tableMetaData.getColumnName(i) + "(" + tableMetaData.getColumnTypeName(i) + "):");
            String value = input.nextLine();
            sqlInsertStr.append("\'" + value + "\'");
            if (i != coulumnsCount){
                sqlInsertStr.append(", ");
            }
        }
        sqlInsertStr.append(")");

        Statement insertStatement = connection.createStatement();
        insertStatement.execute(sqlInsertStr.toString());
    }

    public void editRecord(Connection connection, String tableName, int rowNumber){
        //todo
    }

    public void deleteRecord(Connection connection, String tableName, int rowNumber) throws SQLException {
        String sqlStr = "SELECT * FROM " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        preparedStatement.execute(sqlStr);
        ResultSet resultSet = preparedStatement.getResultSet();
        resultSet.absolute(rowNumber);
        resultSet.deleteRow();
    }

}
