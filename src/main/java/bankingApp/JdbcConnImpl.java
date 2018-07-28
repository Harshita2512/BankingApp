package bankingApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jdbcConnImpl")
public class JdbcConnImpl {
	
	Connection con;
		
		public Statement getDatabaseConnection(){
			try {
				Class.forName("com.mysql.jdbc.Driver");

				con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/bankingapplication","root","password");  
				Statement stmt=con.createStatement();
				return stmt;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;  
		}

	
	public void RegisterUser (Customer c) throws Exception {

		try{  
			Statement stmt = getDatabaseConnection();
			String query = "insert into customer (firstName, lastName, email, password, phoneNumber) values ('" + c.getFirstName() +"','"+c.getLastName() +"', '"+c.getEmail() +"','"+c.getPassword() + "',"+ c.getPhoneNumber()+")";

			int rs=stmt.executeUpdate(query); 
			con.close();

		}catch(Exception e) {
			throw e;
		}
	}
	
	public Customer getCusometrInfo (String email)  {

		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from customer where email = '"+email+"'");
			if (rs.next()) {
				
				Customer info = new Customer();
				info.setFirstName(rs.getString(1));
				info.setLastName(rs.getString(2));
				info.setEmail(rs.getString(3));
				info.setPassword(rs.getString(4));
				info.setPhoneNumber(rs.getLong(5));
				
				return info;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void insertAccountInfo (String email) throws Exception {

		try{  
			Statement stmt = getDatabaseConnection();
			String query = "insert into accountInfo (email, type, balance) values ('"+email +"', 'Saving' ,"+ 10000 +")";

			int rs=stmt.executeUpdate(query); 
			con.close();

		}catch(Exception e) {
			throw e;
		}
	}
	
	
	public AccountInfo getAccountInfo (String email) {
		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from accountInfo where email = '"+email+"'");
			if (rs.next()) {
				
				AccountInfo info = new AccountInfo();
				info.setAccountNumber(rs.getLong(1));
				info.setEmail(rs.getString(2));
				info.setType(rs.getString(3));
				info.setBalance(rs.getFloat(4));
				
				return info;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public AccountInfo getAccountInfo (long accountNumber) {
		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from accountInfo where accountNumber = "+accountNumber);
			if (rs.next()) {
				
				AccountInfo info = new AccountInfo();
				info.setAccountNumber(rs.getLong(1));
				info.setEmail(rs.getString(2));
				info.setType(rs.getString(3));
				info.setBalance(rs.getFloat(4));
				
				return info;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void insertActivities (long accountNumber, String  transactionType, double amount) throws Exception {

		try{  
			Statement stmt = getDatabaseConnection();
			String query = "insert into activities (accountNumber, date, Transactiontype, amount) values (" + accountNumber+",'"+new Date().toString() +"','"+transactionType + "',"+ amount+")";

			int rs=stmt.executeUpdate(query); 
			con.close();

		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Activities> getAllActivites (long accountNumber){

		ArrayList<Activities> activities = new ArrayList<Activities>();

		Statement stmt = getDatabaseConnection();
		try {
			ResultSet rs = stmt.executeQuery("select * from activities where accountNumber = "+accountNumber);
			while (rs.next()) {

				Activities info = new Activities();
				info.setAccountNumber(rs.getLong(1));
				info.setDate(rs.getString(2));
				info.setTransactionType(rs.getString(3));
				info.setAmount(rs.getFloat(4));

				activities.add(info);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return activities;
	}


	public void updateAccountInfo(AccountInfo acc) throws Exception {
		
		try {
			Statement stmt = getDatabaseConnection();

			String query = "update accountInfo set balance = "+acc.getBalance() + " where accountNumber = " + acc.getAccountNumber();
			int rs=stmt.executeUpdate(query); 
			con.close();

		}catch(Exception e) {
			throw e;
		}
	}
	
	public void updateInformation (Customer customer) throws Exception {
		
		try {
			Statement stmt = getDatabaseConnection();

			String query = "update customer set phoneNumber = "+customer.getPhoneNumber() + ", password = '"+customer.getPassword() + "' where email = '" + customer.getEmail()+"'";
			int rs=stmt.executeUpdate(query); 
			
			
			con.close();

		}catch(Exception e) {
			throw e;
		}
	}
		
	public ArrayList<Customer> getCustomers ()  {

		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from customer");
			ArrayList<Customer> customers = new ArrayList<Customer>();
			
			while (rs.next()) {
				
				Customer info = new Customer();
				info.setFirstName(rs.getString(1));
				info.setLastName(rs.getString(2));
				info.setEmail(rs.getString(3));
				info.setPassword(rs.getString(4));
				info.setPhoneNumber(rs.getLong(5));
				
				customers.add(info);
			}
				return customers;


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
		
	}
	
	

	
	