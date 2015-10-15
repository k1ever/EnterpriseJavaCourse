package com.jdbc;


import java.sql.*;

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
    }

    public void createTable(Connection connection, String tableName, int columnsCount){
        //todo
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
            System.out.print(resultSetMetaData.getColumnLabel(i) + "(" + resultSetMetaData.getColumnTypeName(i) + ") ");
        }
        System.out.println();

        //display table data
        while (resultSet.next()){
            for (int i=1; i<=columnsCount; i++){
                System.out.print(resultSet.getString(i) + " ");  //every data type will be casted to String for output
            }
            System.out.println();
        }

    }

}
