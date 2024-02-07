package com.blueyonder.dao;

import com.blueyonder.model.Customer;

import java.util.List;

public interface CustomerDAO {

    public int addCustomer(Customer customer);

    public Customer getCustomerById(Integer customerId);

    public Customer updateCustomer(Customer customer);

    public String deleteCustomerById(Integer customerId);

    public List<Customer> getAllCustomers();

    public int GetMinId();

    public int GetSmallestGap();
}
