package com.wzq.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driverName;
        String jdbcUrl;
        String user;
        String password;
        InputStream in ;
        try {
            Properties properties = new Properties();
            in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
//            in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(in);
            //获取配置文件的值
            driverName = properties.getProperty("driverName");
            jdbcUrl = properties.getProperty("jdbcUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            return connection;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01(){
        try {
            Connection connection = JdbcUtil.getConnection();
            System.err.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02(){
        JdbcUtil util = new JdbcUtil();
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            connection = util.getConnection();
            System.err.println(connection);
            statement = connection.createStatement();
            String sql = "select * from member where id = 1";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.err.println("id:"+id+",name="+name);
            }
            JdbcUtil.release(connection, statement, resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03(){
        JdbcUtil util = new JdbcUtil();
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = util.getConnection();
            System.err.println(connection);
            String sql = "select * from member where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.err.println("id:"+id+",name="+name);
            }
            JdbcUtil.release(connection, preparedStatement, resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
