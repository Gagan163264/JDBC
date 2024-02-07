package com.blueyonder.dao;

import com.blueyonder.model.Customer;
import com.blueyonder.utils.DBConn;
import com.blueyonder.utils.QueryMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO, QueryMapper {

    Connection conn = DBConn.createConn();
    public int GetMinId(){
        int minId = 0;
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(QueryMapper.GET_MIN_ID);
            while(rs.next()){
                minId = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return minId;
    }

    public int GetSmallestGap(){
        int smallestGap = 0;
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(QueryMapper.GET_SMALLEST_GAP);
            while(rs.next()){
                smallestGap = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return smallestGap;
    }

    public int addCustomer(Customer customer){
        int res;
        try{
            PreparedStatement stm = conn.prepareStatement(QueryMapper.INSERT_CUSTOMER);
            stm.setInt(1, customer.getCustomerID());
            stm.setString(2, customer.getCustomerName());
            stm.setDate(3, Date.valueOf(customer.getDateOfBirth()));
            stm.setString(4, customer.getAddress());

            res = stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> lc = new ArrayList<>();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(QueryMapper.GET_ALL_CUSTOMERS);
            while(rs.next()){
                Customer customer= new Customer();
                customer.setCustomerID(rs.getInt("customerID"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                customer.setAddress(rs.getString("address"));
                lc.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lc;
    }

    public Customer getCustomerById(Integer customerId){
        Customer customer= new Customer();
        try{
            PreparedStatement stm = conn.prepareStatement(QueryMapper.GET_CUSTOMER_BY_ID);
            stm.setInt(1, customerId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                customer.setCustomerID(rs.getInt("customerID"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                customer.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }

    public Customer updateCustomer(Customer customer){
        try{
            PreparedStatement stm = conn.prepareStatement(QueryMapper.UPDATE_CUSTOMER);
            stm.setString(1, customer.getCustomerName());
            stm.setDate(2, Date.valueOf(customer.getDateOfBirth()));
            stm.setString(3, customer.getAddress());
            stm.setInt(4, customer.getCustomerID());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }

    public String deleteCustomerById(Integer customerId){
        try{
            PreparedStatement stm = conn.prepareStatement(QueryMapper.DELETE_CUSTOMER_BY_ID);
            stm.setInt(1, customerId);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Customer with ID "+customerId+" deleted successfully";
    }

}
