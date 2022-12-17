package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.DatabaseHandler;

public class ReportTable {


    public static ArrayList<ReportSellDaliy> findReportByOrderId(DatabaseHandler dbHandler, int orderid) throws SQLException {
        String sql = "SELECT OrderID, EmployeeID, FoodName, FoodPrice, Quantity, TotalPrice, SaleTimestamp FROM SaleOrder AS s , Menu AS m WHERE s.FoodID = m.FoodID AND OrderId = '" + orderid + "' ORDER BY OrderID ASC";
        ResultSet rs;
        ArrayList<ReportSellDaliy> reportList = null;
        rs = dbHandler.query(sql);
        reportList = extractDaliy(rs);
        return reportList;
    }

    // การหาค่าในตารางโดยหาชื่อที่ต้องการ
    public static ArrayList<ReportSellDaliy> findReportOrderByTime(DatabaseHandler dbHandler, String time)
            throws SQLException {
        String sql = "SELECT OrderID, EmployeeID, FoodName, FoodPrice, Quantity, TotalPrice, SaleTimestamp FROM SaleOrder AS s , Menu AS m WHERE s.FoodID = m.FoodID AND s.SaleTimestamp Like '" + time + "%' ORDER BY OrderID ASC";
        ResultSet rs;
        ArrayList<ReportSellDaliy> reportList = null;
        rs = dbHandler.query(sql);
        reportList = extractDaliy(rs);
        return reportList;

    }

    // การหาค่าในตารางโดยหาทั้งหมด
    public static ArrayList<ReportSellDaliy> findAllReportOfSell(DatabaseHandler dbHandler) throws SQLException {
        String sql = "SELECT OrderID, EmployeeID, FoodName, FoodPrice, Quantity, TotalPrice, SaleTimestamp FROM SaleOrder AS s , Menu AS m WHERE s.FoodID = m.FoodID ORDER BY OrderID ASC";
        ResultSet rs;
        ArrayList<ReportSellDaliy> reportList = null;
        rs = dbHandler.query(sql);
        reportList = extractDaliy(rs);
        return reportList;
    }

    // เป็นการนำค่าจาก database มาเก็บใว้ในรูปของ arraylist
    private static ArrayList<ReportSellDaliy> extractDaliy(ResultSet rs) {
        ArrayList<ReportSellDaliy> reportList = new ArrayList<>();
        try {
            while (rs.next()) {
                ReportSellDaliy report = new ReportSellDaliy();
                try {
                    report = new ReportSellDaliy();
                    report.setOrderID(rs.getInt("OrderID"));
                    report.setEmployeeID(rs.getInt("EmployeeID"));
                    report.setFoodName(rs.getString("FoodName"));
                    report.setFoodPrice(rs.getInt("FoodPrice"));
                    report.setQuantity(rs.getInt("Quantity"));
                    report.setTotalPrice(rs.getDouble("TotalPrice"));
                    report.setSaleTimestamp(rs.getString("SaleTimestamp"));
                } catch (SQLException ex) {
                    Logger.getLogger(ReportTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                reportList.add(report);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (reportList.isEmpty()) {
            reportList = null;
        }
        return reportList;
    }
}