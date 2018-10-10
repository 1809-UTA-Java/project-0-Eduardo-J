package com.revature.model;
import java.util.*;

public class Customer extends Account {
	
	private int id;
	private String username;
	private String password;
	private String name;
	private float balance = 0;
	private int active = 0;
	//private HashMap<String, String> hm = new HashMap<String, String>();
	
	
	
	public Customer(int id, String name, String username, String password, float balance, int active) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.active = active;
	}
	
	public Customer() {
		super();
	}
	/*
	public void setInfo(String user, String pass) {
		hm.put(user, pass);
	}
	
	public String getInfo(String key) {
		return hm.get(key);
	}
	
	public boolean compareUserPass(String u, String p) {
		if(p.equals(hm.get(u))) {
			System.out.println("it works");
			return true;
		}
		else {
			return false;
		}
	}
	*/
	

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
    
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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

	@Override
	protected List<Integer> getRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setRequests(int id2) {
		// TODO Auto-generated method stub
		
	}
	
}
