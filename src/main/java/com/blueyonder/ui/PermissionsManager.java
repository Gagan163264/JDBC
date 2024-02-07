package com.blueyonder.ui;

import com.blueyonder.Authenticator.AuthIo;
import com.blueyonder.dao.AuthDAOImpl;

import java.util.List;
import java.util.Scanner;

public class PermissionsManager {
    public void REPL() {
        Scanner sc = new Scanner(System.in);
        AuthIo auth = new AuthIo();
        String username;
        String password;
        System.out.println("Permissions manager");
        boolean flag =  false;
        do {
            if(flag)
                System.out.println("Incorrect credentials");
            flag = true;
            System.out.println("Enter Username:");
            username = sc.nextLine();
            System.out.println("Enter Password:");
            password = sc.nextLine();
        } while(!auth.authenticate(username, password));
        AuthDAOImpl authDAO = new AuthDAOImpl();
        int permission = authDAO.getPermission(username);
        if(permission != 0){
            System.out.println("You do not have permission to access this page");
            System.exit(0);
        }
        System.out.println("Welcome " + username);
        System.out.println();
        boolean isValid = true;
        while(isValid){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Change Password");
            System.out.println("4. Change Permission");
            System.out.println("5. List registered users");
            System.out.println("6. Sign Out");
            System.out.println("7. Exit");
            System.out.print("Input choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            int newPermission;
            String newPassword;
            switch(choice){
                case 1:
                    System.out.println("Enter new username:");
                    String newUsername = sc.nextLine();
                    System.out.println("Enter new password:");
                    newPassword = sc.nextLine();
                    System.out.println("Enter permission:");
                    newPermission = Integer.parseInt(sc.nextLine());
                    authDAO.addUser(newUsername, newPassword, newPermission);
                    break;
                case 2:
                    System.out.println("Enter username to delete:");
                    String deleteUsername = sc.nextLine();
                    authDAO.deleteUser(deleteUsername);
                    break;
                case 3:
                    try {
                        System.out.println("Enter username:");
                        String changePasswordUsername = sc.nextLine();
                        System.out.println("Enter old password:");
                        String oldPassword = sc.nextLine();
                        System.out.println("Enter new password:");
                        newPassword = sc.nextLine();
                        authDAO.changePassword(changePasswordUsername, oldPassword, newPassword);
                    }
                    catch (RuntimeException e)
                    {
                        System.out.println("Wrong Password");
                    }
                    break;
                case 4:
                    System.out.println("Enter username:");
                    String changePermissionUsername = sc.nextLine();
                    System.out.println("Enter new permission:");
                    newPermission = Integer.parseInt(sc.nextLine());
                    authDAO.changePermission(changePermissionUsername, newPermission);
                    break;
                case 5:
                    System.out.println("Registered Users:");
                    List<String> users = authDAO.getAllUsers();
                    System.out.println("Users:");
                    for(String user:users){
                        System.out.println(user);
                    }
                    System.out.println();
                    break;
                case 6:
                    isValid = false;
                    break;
                case 7:
                    System.exit(0);
        
                }
    
            }   

        }
}