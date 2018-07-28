package bankingApp;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("hibernateConnImpl")
public class HibernateConnImpl implements DatabaseInf {

	SessionFactory sf = DatabaseConn.getSessionFactory();


	public void RegisterUser (Customer c) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.save(c);
		t.commit();
		session.flush();
		session.close();
	}


	public Customer getCusometrInfo (String email)  {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Customer c = (Customer) session.get(Customer.class, email);
		session.close();

		return c;
	}

	public void insertAccountInfo (String email) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		AccountInfo a = new AccountInfo();
		a.setType("Saving");
		a.setBalance(10000);
		a.setEmail(email);

		session.save(a);
	}


	public AccountInfo getAccountInfo (String email) {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		String sql = "SELECT * FROM ACCOUNTINFO WHERE email = :email";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(AccountInfo.class);
		query.setParameter("email", email);
		
		AccountInfo a = (AccountInfo) query.uniqueResult();

		session.close();

		return a;

	}


	public AccountInfo getAccountInfo (long accountNumber) {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		AccountInfo a = (AccountInfo) session.get(AccountInfo.class, accountNumber);

		session.close();

		return a;
	}

	public void insertActivities (long accountNumber, String  transactionType, double amount) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Activities at = new Activities();
		at.setAccountNumber(accountNumber);
		at.setDate(new Date().toString());
		at.setTransactionType(transactionType);
		at.setAmount(amount);

		session.save(at);
		t.commit();
		session.flush();
		session.close();
	}

	public ArrayList<Activities> getAllActivites (long accountNumber){

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Criteria c = session.createCriteria(Activities.class);
		c.add(Restrictions.eq("accountNumber", accountNumber));

		ArrayList<Activities> ac= (ArrayList<Activities>) c.list();

		session.close();
		return ac;

	}


	public void updateAccountInfo(AccountInfo acc) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		AccountInfo a = (AccountInfo) session.get(AccountInfo.class, acc.getAccountNumber());

		a.setBalance(acc.getBalance());

		session.save(a);
		t.commit();
		session.flush();
		session.close();
	}

	public void updateInformation (Customer customer) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Customer c= (Customer) session.get(Customer.class, customer.getEmail());

		c.setPhoneNumber(customer.getPhoneNumber());
		c.setPassword(customer.getPassword());

		session.save(c);
		t.commit();
		session.flush();
		session.close();

	}

	public ArrayList<Customer> getCustomers ()  {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<Customer> customers =(ArrayList<Customer>) session.createCriteria(Customer.class);
		session.close();
		return customers;

	}


}





