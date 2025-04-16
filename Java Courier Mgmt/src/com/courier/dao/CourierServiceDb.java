package com.courier.dao;

import com.courier.entity.Courier;
import com.courier.util.DBConnUtil;

import java.sql.*;
import java.util.Date;

public class CourierServiceDb {
    private static Connection connection;

    public CourierServiceDb() {
        connection = DBConnUtil.getConnection("db.properties");
    }

    public String insertCourier(Courier c) {
    	String sql = "INSERT INTO Courier (SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getSenderName());
            ps.setString(2, c.getSenderAddress());
            ps.setString(3, c.getReceiverName());
            ps.setString(4, c.getReceiverAddress());
            ps.setDouble(5, c.getWeight());
            ps.setString(6, c.getStatus());
            ps.setString(7, c.getTrackingNumber());
            ps.setDate(8, new java.sql.Date(c.getDeliveryDate().getTime()));
           

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return c.getTrackingNumber();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOrderStatus(String trackingNumber) {
        String sql = "SELECT Status FROM Courier WHERE TrackingNumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trackingNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("Status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Not Found";
    }

    public boolean cancelOrder(String trackingNumber) {
        String sql = "UPDATE Courier SET Status = 'Cancelled' WHERE TrackingNumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trackingNumber);
            int updated = ps.executeUpdate();
            return updated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getAssignedOrders(int employeeId) {
        String sql = "SELECT * FROM Courier WHERE CourierID IN (SELECT CourierID FROM EmployeeAssignment WHERE EmployeeID = ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Tracking: " + rs.getString("TrackingNumber") + " | Status: " + rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
