package com.Main.Admin;

import java.util.Scanner;

import com.Modal.Admin;
import com.Service.AdminService;

public class AdminLogin {
	
	      public static  Boolean login()  {
	    	  Boolean status = false;
	    	  Scanner sc = new Scanner(System.in);
	    	  
	    	  System.out.println("Enter Username :");
	    	  String uname = sc.next();
	    	  System.out.println("Enter Password :");
	    	  String pass = sc.next();
	    	  
	    	  AdminService adminservice = new AdminService();
	    	  try {
				Admin admin = adminservice.loginAdmin(uname, pass);
			    status = true;
				System.out.println("--------------------------------------------------------");
			    System.out.println("    WELCOME " + admin.getAdmin_name());
			    System.out.println("--------------------------------------------------------");
	    	  } catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    	  
	    	  
			return status;
	      }
	}

