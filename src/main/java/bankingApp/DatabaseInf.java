package bankingApp;

import java.util.ArrayList;

public interface DatabaseInf {
	
	public void RegisterUser (Customer c) throws Exception;
	
	public Customer getCusometrInfo (String email) ;
	
	public void insertAccountInfo (String email) throws Exception;
	
	public AccountInfo getAccountInfo (String email);
	
	public AccountInfo getAccountInfo (long accountNumber) ;
	
	public void insertActivities (long accountNumber, String  transactionType, double amount) throws Exception;
	
	public ArrayList<Activities> getAllActivites (long accountNumber);
	
	public void updateAccountInfo(AccountInfo acc) throws Exception;
	
	public void updateInformation (Customer customer) throws Exception;
	
	public ArrayList<Customer> getCustomers ();
}
