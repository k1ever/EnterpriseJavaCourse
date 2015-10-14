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

    public void createTable(Connection connection, String tableName){
        //todo
    }

    public void getDataFromTable (Connection connection, String tableName) throws SQLException {
        String sqlStr = "SELECT * FROM ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setString(1, tableName);
        preparedStatement.execute(sqlStr);


    }

}
