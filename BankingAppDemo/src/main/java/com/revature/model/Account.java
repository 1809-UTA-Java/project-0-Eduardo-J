package com.revature.model;
import java.util.HashMap;
import java.util.List;

public abstract class Account {
	
	private int id;
	private String username;
	private String password;
	private String name;
	private String address;
	private String email;
	private String dob;
	private float balance;
	private int active = 0;
	//public HashMap<String,String> customerMap = new HashMap<String, String>();
	
	public float deposit() {
    	return balance;
    }

    public float withdraw() {
    	return balance;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	protected abstract void setInfo(String user, String pass);

	protected abstract boolean compareUserPass(String username2, String password2);

	protected abstract List<Integer> getRequests();

	protected abstract void setRequests(int id2);

}
