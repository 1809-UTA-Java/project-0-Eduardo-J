package com.revature.repository;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.model.Customer;

import oracle.jdbc.OracleTypes;

public class CustomerDao {
	
	public List<Customer> getCustomers() {
		PreparedStatement ps = null;
		Customer a = null;
		List<Customer> customers = new ArrayList<Customer>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM CUSTOMERS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				float balance = rs.getFloat("balance");
				int active = rs.getInt("active");
				
				a = new Customer(id, name, username, password, balance, active);
				customers.add(a);
			}
			ps.execute();
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		return customers;
	}
	
	public Customer getCustomerByName(String n) {
		PreparedStatement ps = null;
		Customer a = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM CUSTOMERS WHERE NAME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, n);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				float balance = rs.getFloat("balance");
				int active = rs.getInt("active");
				
				a = new Customer(id, name, username, password, balance, active);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		return a;
	}
	
	public Customer getCustomerByUserName(String n) {
		PreparedStatement ps = null;
		Customer a = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM CUSTOMERS WHERE USERNAME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, n);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				float balance = rs.getFloat("balance");
				int active = rs.getInt("active");
				
				a = new Customer(id, name, username, password, balance, active);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		return a;
	}
	
	public void getCustomersBySp() {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{ CALL GET_CUSTOMERS(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertCustomer(int id, String name, String username, String password, float balance, int active) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO CUSTOMERS VALUES(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setFloat(5, balance);
			ps.setInt(6, active);
			ps.execute();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCustomerBalance(String username, float balance) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE CUSTOMERS SET BALANCE = ? WHERE USERNAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, balance);
			ps.setString(2, username);
			ps.execute();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertCustomerBalance(String username, float balance) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE CUSTOMERS SET BALANCE = ? WHERE USERNAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, balance);
			ps.setString(2, username);
			ps.execute();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void activateCustomer(String username, int active) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE CUSTOMERS SET ACTIVE = ? WHERE USERNAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, active);
			ps.setString(2, username);
			ps.execute();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cancelAccount(String username) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM CUSTOMERS WHERE USERNAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.execute();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
