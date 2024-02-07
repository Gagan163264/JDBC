package com.blueyonder.ui;

import com.blueyonder.Authenticator.AuthIo;
import com.blueyonder.dao.AuthDAOImpl;

import java.util.Scanner;

public class MainLoop {
    public static void main(String[] args) {
        System.out.println("Customer service UI");
        while (true) {
            String username, password;
            Scanner sc = new Scanner(System.in);
            AuthIo auth = new AuthIo();
            boolean flag = false;
            do {
                if(flag)
                    System.out.println("Incorrect Credentials");
                flag = true;
                System.out.println("Enter Username:");
                username = sc.nextLine();
                System.out.println("Enter Password:");
                password = sc.nextLine();
            } while(!auth.authenticate(username, password));

            System.out.println("Welcome " + username);
            AuthDAOImpl authDAO = new AuthDAOImpl();
            int permission = authDAO.getPermission(username);

            Session session = new Session(username, permission);
            PermissionsManager pm = new PermissionsManager();
                if(permission == 0)
                {
                    System.out.println("1. Customer Service portal");
                    System.out.println("2. Permissions Manager");
                    System.out.println("3. Sign Out");
                    System.out.println("4. Exit");
                    System.out.print("Input choice: ");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch(choice){
                        case 1:
                            session.REPL();
                            break;
                        case 2:
                            pm.REPL();
                            break;
                        case 3:
                            break;
                        case 4:
                            System.exit(0);
                    }
                }
                else
                    session.REPL();
        }
    }
}
