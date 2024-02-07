package com.blueyonder.service;

import com.blueyonder.model.Customer;

public interface CustomerService {
    //Create
    public int addCustomer(Customer customer);
    //Retrieve
    public Customer getCustomerById(Integer customerId);
    //Update
    public Customer updateCustomer(Customer customer);
    //Delete
    public String deleteCustomerById(Integer customerId);
}


