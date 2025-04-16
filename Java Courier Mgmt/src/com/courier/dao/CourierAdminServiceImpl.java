package com.courier.dao;


import com.courier.entity.*;
import com.courier.entity.Employee;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {
    public CourierAdminServiceImpl(CourierCompany companyObj) {
        super(companyObj);
    }

    public int addCourierStaff(Employee employee) {
        companyObj.getEmployeeDetails().add(employee);
        return employee.getEmployeeId();
    }
}
