package com.revature;

import com.revature.model.Session;

public class BankingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***********");
		System.out.println("* WELCOME *");
		System.out.println("***********");
		System.out.println("Loading App...");
		Session myMenu = new Session();
		myMenu.loginMenu();
		
		//CustomerDao cdao = new CustomerDao();
		//Customer cust = new Customer();
		//List<Customer> customers = cdao.getCustomers();
		//cdao.insertCustomer(7, "ed", "edy", "edyz", 0);
		//cdao.getCustomers();
		//cust=cdao.getCustomerByName("ed");
		
	    //System.out.println(cust.getId());
	    System.out.println("Terminated App");
		
	    
	}

}
