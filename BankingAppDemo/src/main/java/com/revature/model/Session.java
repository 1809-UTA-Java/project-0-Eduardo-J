package com.revature.model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.repository.CustomerDao;

public class Session {
	
	int menuChoice = 0;
	float amount;
	Scanner scan = new Scanner(System.in);
	List<Customer> customerList = new ArrayList<Customer>();
	public Account cust = new Customer(0, null, null, null, 0, 0);
	public Account empl = new Employee(0, "employee", "employee");
	public Account adm = new Admin(0, "admin", "admin");
	CustomerDao cdao = new CustomerDao();
	
	
	public void loginMenu(){

		String username;
		String password;
		
		//transfer customers
		customerList=cdao.getCustomers();
		
		//login, create login, or exit
		while(menuChoice != 3) {
			mainMenu();
			switch(menuChoice) {
			case 1:
				//Login input
				System.out.println("Type in login Information");
				System.out.println("Username: ");
				username = scan.nextLine();
				System.out.println("Password: ");
				password = scan.nextLine();
			
				//Check username and password
				cust=cdao.getCustomerByUserName(username);
				if(username.equals(empl.getUsername()) &&  password.equals(empl.getPassword())) {
					System.out.println("Welcome " + username);
					employeeLogin();
				}
				else if(username.equals(adm.getUsername()) &&  password.equals(adm.getPassword())) {
					System.out.println("Welcome " + username);
					adminLogin();
				}
				else {
					
					if(username.equals(cust.getUsername()) &&  password.equals(cust.getPassword())) {
						System.out.println("Welcome " + username);
						customerLogin(username);
					}
					else {
						System.out.println("Failed Login");
					}
				}	
					
				break;
			case 2:
				//create a login
				createLogin();
				break;
			case 3:
				menuChoice=3;
				break;
			default:
				System.out.println("Not a valid value.");
			}
		}

	}
	
	public void mainMenu() {
		System.out.println("***Menu***");
		System.out.println("Type in the number corresponding to the option that you want.");
		System.out.println("Option 1: Login");
		System.out.println("Option 2: Create Account");
		System.out.println("Option 3: Exit");

		
		try {
			menuChoice = scan.nextInt();
			scan.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("Input mismatch exception! Now exiting menu.");
		}
		
	}
	
	public void createLogin() {
		String name;
		String user;
		String pass;
		float balance = 0;
		int active = 0;
		System.out.println("Enter your name: ");
		name = scan.nextLine();
		System.out.println("Enter a username: ");
		user = scan.nextLine();
		System.out.println("Enter a password: ");
		pass = scan.nextLine();
		int id = customerList.size();
		id++;
		
		//create and insert customer into database
		Customer cust = new Customer(id, name, user, pass, balance, active);
		customerList.add(cust);
		cdao.insertCustomer(id, name, user, pass, balance, active);
		System.out.println("Your login has been created. ");
	}
	
	public void customerLogin(String username) {
		cust= cdao.getCustomerByUserName(username);
		System.out.println("***Customer Login***");
		System.out.println("Type in the number corresponding to the option that you want.");
		System.out.println("Option 1: Check Balance");
		System.out.println("Option 2: Deposit Funds");
		System.out.println("Option 3: Withdraw Funds");
		System.out.println("Option 4: Transfer Funds");
		System.out.println("Option 5: Apply for Account");
		System.out.println("Option 6: Log Out");
		

		menuChoice = scan.nextInt();
		scan.nextLine();
		while(menuChoice != 6) {
			switch(menuChoice) {
			case 1:
				System.out.println("Balace: " + cust.getBalance());

				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 2:
				if(cust.getActive()==1) {
					if(amount > 0) {
						System.out.println("Type in amount to be deposited: ");
						amount = scan.nextFloat();
						scan.nextLine();
						cust.setBalance(cust.getBalance() + amount);
						System.out.println("Amount deposited: " + amount);
						cdao.insertCustomerBalance(cust.getUsername(), cust.getBalance());
					}
					else {
						System.out.println("Invalid amount.");
					}
				}
				else {
					System.out.println("Denied access. Please make a request to manage transactions");
				}
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 3:
				if(cust.getActive()==1) {
					if(amount<0) {
						System.out.println("Type in amount to be withdrawn: ");
						amount = scan.nextFloat();
						scan.nextLine();
				
						if(cust.getBalance() >= amount) {
							cust.setBalance(cust.getBalance() - amount);
							System.out.println("Amount trasnferred: " + amount);
						}
						else {
							System.out.println("You don not have enough in you account.");
						}
					}
					else {
						System.out.println("invalid amount.");
					}
				}
				else {
					System.out.println("Denied access. Please make a request to manage transactions");
				}
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 4:
				if(cust.getActive()==1) {
					System.out.println("Type in amount to be transferred: ");
					amount = scan.nextFloat();
					scan.nextLine();
				
					System.out.println("Type in ID to be transferred to: ");
					int temp;
					temp = scan.nextInt();
					scan.nextLine();
				
					if(cust.getBalance() >= amount) {
						cust.setBalance(cust.getBalance() - amount);
						System.out.println("Amount trasnferred: " + amount);
					}
					else {
						System.out.println("You don not have enough in you account.");
					}
					//implement transfer
				}
				else {
					System.out.println("Denied access. Please make a request to manage transactions");
				}

				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 5:
				empl.setRequests(cust.getId());
				adm.setRequests(cust.getId());
				System.out.println("Sent request to an employee for customer ID: " + cust.getId());
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 6:
				break;
			default:
				System.out.println("Please enter a valid value.");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			}
		}
	}
	
	public void employeeLogin() {
		
		System.out.println("***Employee Login***");
		System.out.println("Type in the number corresponding to the option that you want.");
		System.out.println("Option 1: View Customers");
		System.out.println("Option 2: Approve Accounts");
		System.out.println("Option 3: Log Out");
		
		menuChoice = scan.nextInt();
		scan.nextLine();
		while(menuChoice != 3) {
			switch(menuChoice) {
			case 1:
				Iterator itr = customerList.iterator();
				while(itr.hasNext()) {
					Customer cust = (Customer)itr.next();
					System.out.println("Customer ID: " + cust.getId());
					System.out.println("Customer Name: " + cust.getName());
					System.out.println("Customer Username: " + cust.getUsername());
					System.out.println("Customer Password: " + cust.getPassword());
					System.out.println("Customer Account Balance: " + cust.getBalance());
					System.out.println("Customer is active: " + cust.getActive());
				}
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 2:
				if(empl.getRequests().isEmpty()) {
					System.out.println("There are no requests at this time.");
				}
				else {
					System.out.println("Account request: " + empl.getRequests().size() + " Would you like to approve?");
					List<Integer> temp = new ArrayList<Integer>();
					
					temp=empl.getRequests();
					
					for(int i=0;i<temp.size();i++) {
						System.out.println("Request from customer ID: " + temp.get(i));
					}
					
					System.out.println("Option 1: yes");
					System.out.println("Option 2: no");
					menuChoice = scan.nextInt();
					scan.nextLine();
					
					if(menuChoice==1) {
						Iterator itr1 = customerList.iterator();
						for(int i = 0; i<=customerList.size(); i++) {
							while(itr1.hasNext()) {
								Customer cust = (Customer)itr1.next();
								if(empl.getRequests().get(i)==cust.getId()) {
									System.out.println("Setting active...");
									cust.setActive(1);
									cdao.activateCustomer(cust.getUsername(), cust.getActive());
									//empl.getRequests().remove(i+1);
								}
								else {
									System.out.println("nope");
								}
							}
						}
						//System.out.println("Customer ID: " + cust.getId());
						System.out.println("Approved");
					}
					else if(menuChoice==2) {
						System.out.println("Denied");
					}
					else {
						System.out.println("Please choose a valid option.");
					}
				}
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 3:
				break;
			default:
				break;
			}
		}
		menuChoice = scan.nextInt();
		scan.nextLine();
	}
	
	public void adminLogin() {
		
		System.out.println("***Employee Login***");
		System.out.println("Type in the number corresponding to the option that you want.");
		System.out.println("Option 1: View Customers");
		System.out.println("Option 2: Approve Accounts");
		System.out.println("Option 3: Cancel Accounts");
		System.out.println("Option 4: Log Out");
		
		menuChoice = scan.nextInt();
		scan.nextLine();
		while(menuChoice != 4) {
			switch(menuChoice) {
			case 1:
				Iterator itr = customerList.iterator();
				while(itr.hasNext()) {
					Customer cust = (Customer)itr.next();
					System.out.println("Customer ID: " + cust.getId());
					System.out.println("Customer Name: " + cust.getName());
					System.out.println("Customer Username: " + cust.getUsername());
					System.out.println("Customer Password: " + cust.getPassword());
					System.out.println("Customer Account Balance: " + cust.getBalance());
					System.out.println("Customer is active: " + cust.getActive());
				}
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 2:
				if(empl.getRequests().isEmpty()) {
					System.out.println("There are no requests at this time.");
				}
				else {
					System.out.println("Account request: " + empl.getRequests().size() + " Would you like to approve?");
					List<Integer> temp = new ArrayList<Integer>();
					
					temp=empl.getRequests();
					
					for(int i=0;i<temp.size();i++) {
						System.out.println("Request from customer ID: " + temp.get(i));
					}
					
					System.out.println("Option 1: yes");
					System.out.println("Option 2: no");
					menuChoice = scan.nextInt();
					scan.nextLine();
					
					if(menuChoice==1) {
						Iterator itr1 = customerList.iterator();
						for(int i = 0; i<=customerList.size(); i++) {
							while(itr1.hasNext()) {
								Customer cust = (Customer)itr1.next();
								if(empl.getRequests().get(i)==cust.getId()) {
									System.out.println("Setting active...");
									cust.setActive(1);
									cdao.activateCustomer(cust.getUsername(), cust.getActive());
									//adm.getRequests().remove(i+1);
								}
								else {
								}
							}
						}
						//System.out.println("Customer ID: " + cust.getId());
						System.out.println("Approved");
					}
					else if(menuChoice==2) {
						System.out.println("Denied");
					}
					else {
						System.out.println("Please choose a valid option.");
					}
				}
				System.out.println("Next Option: ");
				menuChoice = scan.nextInt();
				scan.nextLine();
				break;
			case 3:
				System.out.println("Type in username: ");
				String usr = scan.nextLine();
				scan.nextLine();
				System.out.println("Type in password: ");
				String psw = scan.nextLine();
				scan.nextLine();
				cust=cdao.getCustomerByUserName(usr);

					if(usr.equals(cust.getUsername()) &&  psw.equals(cust.getPassword())) {
						System.out.println("Deleted " + usr);
						customerLogin(usr);
					}
					else {
						System.out.println("Failed, incorrect username/password combination.");
					}
				break;
			case 4:
				break;
			default:
				break;
			}
		}
		menuChoice = scan.nextInt();
		scan.nextLine();
	}
		
}
