package com.david.jdbc;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
