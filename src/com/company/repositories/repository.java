package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.products.Item;
import com.company.repositories.interfaces.prlist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class repository implements prlist{
    private final IDB db;

    public repository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTable() {
        Connection con = null;
        try{
            con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS item(id serial PRIMARY KEY, name VARCHAR(256), price double, rating VARCHAR(256))");
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addItem(Item company) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO medicine(name, price, rating) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, company.getName());
            st.setDouble(2, company.getPrice());
            st.setInt(3, company.getRating());

            st.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Item getItem(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,rating FROM item WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Item user = new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("rating"));

                return user;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,rating FROM item";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Item> users = new LinkedList<>();
            while (rs.next()) {
                Item user = new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("rating"));

                users.add(user);
            }

            return users;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Item getItemByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,rating FROM item WHERE name = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Item company = new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("rating"));

                return company;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean removeItemById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM item WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }
}