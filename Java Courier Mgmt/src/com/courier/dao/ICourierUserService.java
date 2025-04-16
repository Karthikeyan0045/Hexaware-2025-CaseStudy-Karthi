package com.courier.dao;

public interface ICourierUserService {
    String placeOrder();
    String getOrderStatus(String trackingNumber);
    boolean cancelOrder(String trackingNumber);
    void getAssignedOrder(int courierStaffId);
}
