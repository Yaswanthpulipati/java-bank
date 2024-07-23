package com.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.Admin;
import com.entity.Customer;

public class AdminDao {
	
	private String jdbc_url="jdbc:mysql://localhost:3306/bank";
	private String jdbc_user="root";
	private String jdbc_pass="1234";
	private Connection conn;
	
	public AdminDao() {
		conn=DatabaseConnect.getConnection(jdbc_url,jdbc_user,jdbc_pass);
	}
	
	
	
	public boolean registerCustomer(Customer c) {
		try {
			System.out.println(c.getFullName());
			String query="insert into customer values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, c.getAccNumber());
			ps.setString(2, c.getAccType());
			ps.setString(3, c.getAddress());
			ps.setDouble(4, c.getBalance());
			ps.setString(5, c.getDob());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getFullName());
			ps.setString(8, c.getIdProof());
			ps.setString(9, c.getMobileNumber());
			ps.setString(10, c.getPassword());
			
			int k=ps.executeUpdate();
			Statement cs=conn.createStatement();
			cs.execute("insert into transactions values(null,null,null,null,null,null,null,null,null,null,"+c.getAccNumber()+")");
			if(k==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
			
	}
	
	public boolean deleteCustomer(String acc_no, String name) {
		try {
			String query="DELETE FROM customer WHERE acc_no=? AND full_name=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, acc_no);
			ps.setString(2, name);
			int k=ps.executeUpdate();
			Statement cs=conn.createStatement();
			cs.execute("delete from transactions where acc_no="+acc_no);
			if(k==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean login(String id,String pass) {
		try {
			System.out.println(conn);
			PreparedStatement ps=conn.prepareStatement("select * from admin where admin_id=? AND password=?");
			ps.setString(1,id);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("admin_id"));
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Admin getAdmin(String parameter) {
		try {
			PreparedStatement ps=conn.prepareStatement("select * from admin where admin_id=?");
			ps.setString(1, parameter);
			Admin a=new Admin();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a.setAdminId(parameter);
				a.setEmail(rs.getString("email"));
				a.setDob(rs.getString("dob"));
				a.setName(rs.getString("name"));
				a.setExpLevel(rs.getInt("exp_level"));
			}
			return a;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Customer getCustomer(String acc) {
		try {
			PreparedStatement ps=conn.prepareStatement("select * from customer where acc_no=?");
			ps.setString(1, acc);
			ResultSet rs=ps.executeQuery();
			Customer c=new Customer();
			while(rs.next()) {
				
				db_to_customer(c,rs);
			}
			return c;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Customer> getCustomers(){
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from customer;");
			List<Customer> lc=new ArrayList<Customer>();
			while(rs.next()) {
				Customer c=new Customer();
				db_to_customer(c,rs);
				System.out.println(c.getFullName());
				lc.add(c);
			}
			Iterator<Customer> itr=lc.iterator();
			while(itr.hasNext()) {
				Customer c=(Customer) itr.next();
				System.out.println("name: "+c.getFullName()+"---- number: "+c.getAccNumber());
			}
			return lc;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void db_to_customer(Customer c,ResultSet rs) {
		try {
			c.setAccNumber(rs.getString("acc_no"));
			c.setAccType(rs.getString("acc_type"));
			c.setAddress(rs.getString("address"));
			c.setBalance(rs.getDouble("balance"));
			c.setDob(rs.getString("dob"));
			c.setEmail(rs.getString("email"));
			c.setFullName(rs.getString("full_name"));
			c.setIdProof(rs.getString("id_proof"));
			c.setMobileNumber(rs.getString("mobile_no"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
