package com.blueyonder.ui;

import com.blueyonder.model.Customer;
import com.blueyonder.service.CustomerServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Session{
    private String user;
    private int permission;
    
    public Session(String user, int permission){
        this.user = user;
        this.permission = permission;
    }

    public void REPL()
    {
        if(permission <=1)
            REPL_1();
        else
            REPL_2();
    }
    
    public void REPL_1()
    {
        System.out.println("customer CRUD");
        Scanner sc = new Scanner(System.in);
        CustomerServiceImpl csi = new CustomerServiceImpl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isValid = true;
        while(isValid){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. Add Customer");
            System.out.println("2. Get Customer By ID");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Get All Customers");
            System.out.println("6. Sign out");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    //System.out.println("Enter Customer ID:");
                    //int customerID = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Customer Name:");
                    String customerName = sc.nextLine();
                    System.out.println("Enter Customer DOB:");
                    String dob = sc.nextLine();
                    System.out.println("Enter Customer Address:");
                    String address = sc.nextLine();
                    Customer customer = new Customer();
                    //customer.setCustomerID(customerID);
                    customer.setCustomerName(customerName);
                    customer.setDateOfBirth(LocalDate.parse(dob,formatter));
                    customer.setAddress(address);
                    int result = csi.addCustomer(customer);
                    if(result == 1){
                        System.out.println("Customer Added Successfully");
                    }
                    else{
                        System.out.println("Customer Not Added");
                    }
                    break;
                case 2:
                    System.out.println("Enter Customer ID");
                    int customerId = Integer.parseInt(sc.nextLine());
                    Customer customer1 = csi.getCustomerById(customerId);
                    if(customer1 != null){
                        System.out.println(customer1.getCustomerID());
                        System.out.println(customer1.getCustomerName());
                        System.out.println(customer1.getDateOfBirth());
                        System.out.println(customer1.getAddress());
                        System.out.println();
                    }
                    else{
                        System.out.println("Customer Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Enter Customer ID");
                    int customerId1 = Integer.parseInt(sc.nextLine());
                    Customer customer2 = csi.getCustomerById(customerId1);
                    if(customer2 != null){
                        System.out.println("Enter Customer Name");
                        String customerName1 = sc.nextLine();
                        System.out.println("Enter Customer DOB");
                        String dob1 = sc.nextLine();
                        System.out.println("Enter Customer Address");
                        String address1 = sc.nextLine();
                        customer2.setCustomerName(customerName1);
                        customer2.setDateOfBirth(LocalDate.parse(dob1, formatter));
                        customer2.setAddress(address1);
                        Customer customer3 = csi.updateCustomer(customer2);
                        if(customer3 != null){
                            System.out.println("Customer Updated Successfully");
                        }
                        else{
                            System.out.println("Customer Not Updated");
                        }
                    }
                    else{
                        System.out.println("Customer Not Found");
                    }
                    break;
                case 4:
                    System.out.println("Enter Customer ID");
                    int customerId2 = Integer.parseInt(sc.nextLine());
                    String result1 = csi.deleteCustomerById(customerId2);
                    if(result1 != null){
                        System.out.println("Customer Deleted Successfully");
                    }
                    else{
                        System.out.println("Customer Not Deleted");
                    }
                    System.out.println();
                    break;
                case 5:
                    List<Customer> lc = csi.getAllCustomers();
                    for(Customer c:lc){
                        System.out.println(c.getCustomerID());
                        System.out.println(c.getCustomerName());
                        System.out.println(c.getDateOfBirth());
                        System.out.println(c.getAddress());
                        System.out.println();
                    }
                    break;
                case 6:
                    isValid = false;
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    public void REPL_2()
    {
        System.out.println("customer CRUD");
        Scanner sc = new Scanner(System.in);
        CustomerServiceImpl csi = new CustomerServiceImpl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isValid = true;
        while(isValid){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. Get Customer By ID");
            System.out.println("2. Get All Customers");
            System.out.println("3. Sign out");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Enter Customer ID");
                    int customerId = Integer.parseInt(sc.nextLine());
                    Customer customer1 = csi.getCustomerById(customerId);
                    if(customer1 != null){
                        System.out.println(customer1.getCustomerID());
                        System.out.println(customer1.getCustomerName());
                        System.out.println(customer1.getDateOfBirth());
                        System.out.println(customer1.getAddress());
                        System.out.println();
                    }
                    else{
                        System.out.println("Customer Not Found");
                    }
                    break;
                case 2:
                    List<Customer> lc = csi.getAllCustomers();
                    for(Customer c:lc){
                        System.out.println(c.getCustomerID());
                        System.out.println(c.getCustomerName());
                        System.out.println(c.getDateOfBirth());
                        System.out.println(c.getAddress());
                        System.out.println();
                    }
                    break;
                case 3:
                    isValid = false;
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
