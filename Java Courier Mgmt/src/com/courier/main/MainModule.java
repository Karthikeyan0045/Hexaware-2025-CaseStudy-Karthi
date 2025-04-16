package com.courier.main;


import com.courier.dao.CourierServiceDb;
import com.courier.entity.Courier;
import com.courier.exception.InvalidEmployeeIdException;
import com.courier.exception.TrackingNumberNotFoundException;

import java.util.Date;

public class MainModule {
    public static void main(String[] args) {
        CourierServiceDb dbService = new CourierServiceDb();
        Courier c = new Courier(0, "Rahul", "Delhi", "Ramesh", "Mumbai", 5.5, "In Transit", new Date(), 101);

        try {
            // INSERT
            String trackingId = dbService.insertCourier(c);
            if (trackingId == null) {
                throw new RuntimeException("Failed to insert courier.");
            }
            System.out.println("Courier inserted with tracking: " + trackingId);

            // GET STATUS
            String status = dbService.getOrderStatus(trackingId);
            if (status.equals("Not Found")) {
                throw new TrackingNumberNotFoundException("No order found with tracking number: " + trackingId);
            }
            System.out.println("Courier status: " + status);

            // CANCEL
            boolean cancelled = dbService.cancelOrder(trackingId);
            if (!cancelled) {
                throw new TrackingNumberNotFoundException("Failed to cancel order with tracking number: " + trackingId);
            }
            System.out.println("Cancelled: " + cancelled);

            // Invalid employee test
            int empId = -1;
            if (empId <= 0) {
                throw new InvalidEmployeeIdException("Employee ID is invalid: " + empId);
            }

        } catch (TrackingNumberNotFoundException e) {
            System.err.println("Tracking Error: " + e.getMessage());

        } catch (InvalidEmployeeIdException e) {
            System.err.println("Employee Error: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("General Error: " + e.getMessage());

        } finally {
            System.out.println("Operation Completed ✅");
        }
    }
}

