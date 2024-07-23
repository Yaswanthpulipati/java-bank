package com.dao;

import java.sql.Statement;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Customer;

public class CustomerDao {
		private String jdbc_url="jdbc:mysql://localhost:3306/bank";
		private String jdbc_user="root";
		private String jdbc_pass="1234";
		private Connection conn=null;
	
		public CustomerDao() {
			conn=DatabaseConnect.getConnection(jdbc_url,jdbc_user,jdbc_pass);
		}
		
		public boolean updateCustomer(Customer c,String accNumber) {
			try {
				String query="update customer set  full_name=?, address=?, mobile_no=?,email=?, dob=? where acc_no=? And password=?";
				PreparedStatement ps=conn.prepareStatement(query);
				
				ps.setString(1, c.getFullName());
				ps.setString(2, c.getAddress());
				ps.setString(3, c.getMobileNumber());
				ps.setString(4, c.getEmail());
				ps.setString(5, c.getDob());
				ps.setString(6, c.getAccNumber());
				ps.setString(7, c.getPassword());
				
				int k=ps.executeUpdate();
				
				if(k==1)
						return true;
				else
						return false;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
public boolean changePassword(String acc, String o, String n) {
				try {
					PreparedStatement ps=conn.prepareStatement(" update customer set password=? where password=? AND acc_no=?; ");
					ps.setString(1, n);
					ps.setString(2, o);
					ps.setString(3, acc);
					
					int k=ps.executeUpdate();
					
					if( k == 1 ) {
						return true;
					}else {
						return false;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				return false;
		}
		
		public Customer getCustomer(String acn) {
			try {
				String query="select * from customer where acc_no=?";
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setString(1, acn);
				
				ResultSet rs=ps.executeQuery();
				System.out.println(rs);
				Customer c=new Customer();
				db_to_customer(c,rs);
				
				System.out.println(c);
				return c;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		public List<Customer> getCustomers(){
			try {
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery("select * from customer");
				List<Customer> lc=new ArrayList<>();
				while(rs.next()) {
					Customer c=new Customer();
					c=db_to_customer(c,rs);
					lc.add(c);
				}
				return lc;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public boolean withDrawl(double amount,String ac_no) {
			try {
				System.out.println(amount+"------"+ac_no);
				PreparedStatement ps=conn.prepareStatement("select balance from customer where acc_no="+ac_no);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					double d=rs.getDouble("balance");
					if(d<=0 || d-amount<=0) {
						return false;
					}
				}
				ps=conn.prepareStatement("update customer set balance=balance-? where acc_no=?");
				ps.setDouble(1,amount );
				ps.setString(2, ac_no);
				int k=ps.executeUpdate();
				if(k==1) {
					return true;
				}else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean deposit(double amount,String ac_no) {
			try {
				PreparedStatement ps=conn.prepareStatement("update customer set balance=balance+? where acc_no=?");
				ps.setDouble(1,amount );
				ps.setString(2, ac_no);
				int k=ps.executeUpdate();
				if(k==1) {
					return true;
				}else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public Customer db_to_customer(Customer c,ResultSet rs) {
			try {
				while(rs.next()) {
				c.setAccNumber(rs.getString("acc_no"));
				c.setAccType(rs.getString("acc_type"));
				c.setAddress(rs.getString("address"));
				c.setBalance(rs.getDouble("balance"));
				c.setDob(rs.getString("dob"));
				c.setEmail(rs.getString("email"));
				c.setFullName(rs.getString("full_name"));
				c.setIdProof(rs.getString("id_proof"));
				c.setMobileNumber(rs.getString("mobile_no"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return c;
		}

		public boolean login(String acc_no,String pass) {
			try {

				System.out.println(conn);
				PreparedStatement ps=conn.prepareStatement("select * from customer where acc_no=? AND password=?");
				ps.setString(1,acc_no);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getString("acc_no"));
					return true;
				}else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		
		public void AddTransaction(String acc_no , double d) {
				double[] d_arr=new double[10];
				int k=0;
			try {
				PreparedStatement ps=conn.prepareStatement("Select t0,t1,t2,t3,t4,t5,t6,t7,t8,t9 from transactions where acc_no=?");
				ps.setString(1, acc_no);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					for(int i=0;i<9;i++) {
						d_arr[i+1]=rs.getDouble("t"+(i));
					}
					d_arr[0]=d;
					ps=conn.prepareStatement("update transactions set t0=?,t1=?,t2=?,t3=?,t4=?,t5=?,t6=?,t7=?,t8=?,t9=? where acc_no=?");
					for(int i=0;i<10;i++) {
						ps.setDouble(i+1, d_arr[i]);
					}
					ps.setString(11, acc_no);
					k=ps.executeUpdate();
				}
				if(k==1) {
					System.out.println("transaction updated");
				}
			
			}catch(Exception e) {
				e.printStackTrace();;
			}
			
		}
		
		public double[] getTransactions(String acc_no) {
			double d[]=new double[10];
			try {
				System.out.println(acc_no);
				PreparedStatement ps=conn.prepareStatement("Select t0,t1,t2,t3,t4,t5,t6,t7,t8,t9 from transactions where acc_no=?");
				ps.setString(1, acc_no);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					for(int i=0;i<10;i++) {
						d[i]=rs.getDouble("t"+i);
					}
					return d;
				}else {
					System.out.println("d is null");
					return null;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
}
