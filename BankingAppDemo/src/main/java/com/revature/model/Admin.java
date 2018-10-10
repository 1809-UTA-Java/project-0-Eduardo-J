package com.revature.model;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Account{

	private int id;
	private String username;
	private String password;
	private String name;
	private float balance;
	private boolean request = false;
	private int active = 1;
	public List<Integer> requests = new ArrayList<Integer>();
	
	public List<Integer> getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests.add(requests);
	}
	
    public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	protected void setInfo(String user, String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean compareUserPass(String username2, String password2) {
		// TODO Auto-generated method stub
		return false;
	}

}
