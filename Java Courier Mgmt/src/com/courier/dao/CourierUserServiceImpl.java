package com.courier.dao;


import com.courier.entity.CourierCompany;

public class CourierUserServiceImpl implements ICourierUserService {
    protected CourierCompany companyObj;

    public CourierUserServiceImpl(CourierCompany companyObj) {
        this.companyObj = companyObj;
    }

    public String placeOrder() {
        // Simulate
        return "TRK" + System.currentTimeMillis();
    }

    public String getOrderStatus(String trackingNumber) {
        return "In Transit";
    }

    public boolean cancelOrder(String trackingNumber) {
        return true;
    }

    public void getAssignedOrder(int courierStaffId) {
        System.out.println("Assigned orders to staff ID: " + courierStaffId);
    }
}
