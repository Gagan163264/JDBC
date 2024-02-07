package com.blueyonder.model;
import java.time.LocalDate;
public class Customer {

    public Customer(Integer customerID, String customerName, LocalDate dateOfBirth, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Customer() {
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer customerID;
    private String customerName;
    private LocalDate dateOfBirth;
    private String address;

}
