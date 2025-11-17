/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import core.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Gokhan
 */

public class OrderDAO implements DAO<Order> {
    public OrderDAO() {

    }

    List<Order> orders;

    /**
     * Get a single contact entity as a contact object
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Order> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Order WHERE id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Order order = null;
            while (rs.next()) {
                order = new Order(rs.getInt("OrderID"), rs.getString("OrderItem"), rs.getString("OrderItems"), rs.getInt("OrderQTY"), rs.getInt("OrderPrice"), rs.getInt("OrderTotal"));
            }
            return Optional.ofNullable(order);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    /**
     * Get all contact entities as a List
     *
     * @return
     */
    @Override
    public List<Order> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Contact ORDER BY id";
            rs = db.executeQuery(sql);
            Order order = null;
            while (rs.next()) {
                order = new Order(rs.getInt("OrderID"), rs.getString("OrderItem"), rs.getString("OrderItems"), rs.getInt("OrderQTY"), rs.getInt("OrderPrice"), rs.getInt("OrderTotal"));
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    /**
     * Insert a contact object into contact table
     *
     * @param order
     */
    @Override
    public void insert(Order order) {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Order(OrderID, OrderItem, OrderOptions, OrderQTY, OrderPrice, OrderTotal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, order.getOrderID());
            stmt.setString(2, order.getOrderItem());
            stmt.setString(3, order.getOrderOptions());
            stmt.setInt(4, order.getOrderQTY());
            stmt.setInt(5, order.getOrderPrice());
            stmt.setInt(6, order.getOrderTotal());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new contact was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}