package com.company.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import com.company.data.interfaces.IDB;

public class postresql implements IDB{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Parol228");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
