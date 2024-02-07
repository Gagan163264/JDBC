package com.blueyonder.service;

import com.blueyonder.dao.CustomerDAOImpl;
import com.blueyonder.model.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    CustomerDAOImpl cDAO = new CustomerDAOImpl();
    @Override
    public int addCustomer(Customer customer) {
        int mid = cDAO.GetMinId();
        int id = (mid==1)?cDAO.GetSmallestGap():1;
        customer.setCustomerID(id);
        return cDAO.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return cDAO.getCustomerById(customerId);
    }

    public Customer updateCustomer(Customer customer)
    {
        return cDAO.updateCustomer(customer);
    }

    public String deleteCustomerById(Integer customerId)
    {
        return cDAO.deleteCustomerById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return cDAO.getAllCustomers();
    }
}
