package com.courier.entity;


import java.util.List;

public class CourierCompany {
    private String companyName;
    private List<Courier> courierDetails;
    private List<Employee> employeeDetails;
    private List<Location> locationDetails;

    public CourierCompany() {}

    public CourierCompany(String companyName, List<Courier> courierDetails, List<Employee> employeeDetails, List<Location> locationDetails) {
        this.companyName = companyName;
        this.courierDetails = courierDetails;
        this.employeeDetails = employeeDetails;
        this.locationDetails = locationDetails;
    }
 // Inside entity/CourierCompany.java

    public List<Employee> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<Employee> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

	@Override
	public String toString() {
		return "CourierCompany [companyName=" + companyName + ", courierDetails=" + courierDetails
				+ ", employeeDetails=" + employeeDetails + ", locationDetails=" + locationDetails + "]";
	}
	
    // Getters, Setters, toString
}
