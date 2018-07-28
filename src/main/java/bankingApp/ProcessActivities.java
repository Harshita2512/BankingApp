package bankingApp;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProcessActivities {
	@Autowired
	@Qualifier("dbConn")
	DatabaseInf jdbc;

	public void process() {
		
		

		ArrayList<Customer> customers = jdbc.getCustomers();
		for(Customer c : customers ) {
			String email = c.getEmail();

			AccountInfo a = jdbc.getAccountInfo(email);
			long accountNumber = a.getAccountNumber();

			ArrayList<Activities> activities = jdbc.getAllActivites(accountNumber);

			ArrayList<Activities> filteredResult = new ArrayList<Activities>();

			Date currentDate = new Date();
			currentDate.setMonth(currentDate.getMonth()-1);
			long time = currentDate.getTime();

			for (Activities activity : activities) {
				Date activityTime = new Date(activity.getDate());
				
				if (time<activityTime.getTime()) {
					filteredResult.add(activity);
					
				}

			}
			
			SendEmail.sendActivities(email, filteredResult);
		}
		
		

	}
	
	public static void main(String[] args) {
		
		ProcessActivities activities = new ProcessActivities();
		activities.process();
		
	}

}
