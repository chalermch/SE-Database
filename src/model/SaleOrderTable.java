package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.DatabaseHandler;

public class SaleOrderTable {

    /*
     * /เป็นการ update ค่าในตาราง
     * public static int updateOrder(DatabaseHandler dbHandler, SaleOrder order) {
     * String sql = "update teletubbies.Order set name=?, GPA=? where FoodID=?";
     * int rowUpdated;
     * try {
     * rowUpdated = dbHandler.update(sql, Order.getUsername(), Order.getPassword(),
     * Order.getId());
     * }
     * catch (SQLException ex ) {
     * 
     * rowUpdated = 0;
     * }
     * 
     * return rowUpdated;
     * }
     */

    // เป็นการลบค่าในตาราง
    public static int removeSaleOrder(DatabaseHandler dbHandler, SaleOrder order) {
        String sql = "delete from teletubbies.SaleOrder where OrderID = ?";

        int rowDeleted;
        try {
            rowDeleted = dbHandler.update(sql, order.getOrderID());
        } catch (SQLException ex) {
            rowDeleted = 0;
        }
        return rowDeleted;
    }

    // เป็นการเพิ่มค่าในตาราง
    public static int insertOrder(DatabaseHandler dbHandler, SaleOrder order) {
        String sql = "insert into teletubbies.SaleOrder(OrderID, Quantity, TotalPrice, OrderStatus, FoodID, EmployeeID)" +
                " values (?,?,?,?,?,?)";

        int rowInserted;
        try {
            rowInserted = dbHandler.update(sql, order.getOrderID(), order.getQuantity(), order.getTotalPrice(), order.getOrderStatus(), order.getFoodID(), order.getEmployeeID());
        } catch (SQLException ex) {
            rowInserted = 0;
        }
        return rowInserted;
    }

    // การหาค่าในตารางโดยหาจากไอดี
    public static SaleOrder findOrderById(DatabaseHandler dbHandler, int id) throws SQLException {
        String sql = "select * from teletubbies.SaleOrder where OrderID = ?";
        ResultSet rs;
        SaleOrder order = null;
        rs = dbHandler.query(sql, id);
        if (rs.next()) {
            order = new SaleOrder();
            order.setOrderID(rs.getInt("OrderID"));
            order.setQuantity(rs.getInt("Quantity"));
            order.setTotalPrice(rs.getInt("TotalPrice"));
            order.setOrderStatus(rs.getString("OrderStatus"));
            order.setFoodID(rs.getInt("FoodID"));
            order.setEmployeeID(rs.getInt("EmployeeID"));
        }
        return order;

    }

    // การหาค่าในตารางโดยหาชื่อที่ต้องการ
    public static ArrayList<SaleOrder> findOrderByName(DatabaseHandler dbHandler, String name) throws SQLException {
        String sql = "select * from teletubbies.SaleOrder where name = ?";
        ResultSet rs;
        ArrayList<SaleOrder> orderList = null;
        rs = dbHandler.query(sql, name);
        orderList = extractSaleOrder(rs);
        return orderList;

    }

    // การหาค่าในตารางโดยหาทั้งหมด
    public static ArrayList<SaleOrder> findAllOrder(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from teletubbies.SaleOrder";
        ResultSet rs;
        ArrayList<SaleOrder> orderList = null;
        rs = dbHandler.query(sql);
        orderList = extractSaleOrder(rs);
        return orderList;
    }

    // เป็นการนำค่าจาก database มาเก็บใว้ในรูปของ arraylist
    private static ArrayList<SaleOrder> extractSaleOrder(ResultSet rs) {
        ArrayList<SaleOrder> orderList = new ArrayList<>();
        try {
            while (rs.next()) {
                SaleOrder order = new SaleOrder();
                try {
                    order.setOrderID(rs.getInt("OrderID"));
                    order.setQuantity(rs.getInt("Quantity"));
                    order.setTotalPrice(rs.getInt("TotalPrice"));
                    order.setOrderStatus(rs.getString("OrderStatus"));
                    order.setFoodID(rs.getInt("FoodID"));
                    order.setEmployeeID(rs.getInt("EmployeeID"));
                } catch (SQLException ex) {
                    Logger.getLogger(SaleOrderTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (orderList.isEmpty()) {
            orderList = null;
        }
        return orderList;
    }
}