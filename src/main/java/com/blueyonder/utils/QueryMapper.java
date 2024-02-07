package com.blueyonder.utils;

public interface QueryMapper {
    public final String GET_MIN_ID = "SELECT MIN(customerID) FROM customer";
    public final String GET_SMALLEST_GAP = " SELECT MIN(customerID)+1 FROM customer WHERE customerID NOT IN (SELECT customerID-1 FROM customer)";
    public final String GET_ALL_CUSTOMERS = "SELECT * FROM customer ORDER BY customerID";
    public final String GET_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE customerID = ?";
    public final String INSERT_CUSTOMER = "INSERT INTO customer(customerID, customerName, dateOfBirth, address) VALUES (?,?,?,?)";
    public final String UPDATE_CUSTOMER = "UPDATE customer SET customerName = ?, dateOfBirth = ?, address = ? WHERE customerID = ?";
    public final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE customerID = ?";
}
