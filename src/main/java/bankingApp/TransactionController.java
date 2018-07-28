package bankingApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {
	
	@Autowired
	@Qualifier("hibernateConnImpl")
	DatabaseInf jdbc;


	@RequestMapping(value="/transaction", method=RequestMethod.POST)
	protected ModelAndView transaction(HttpServletRequest req) throws ServletException, IOException {

		String recieverAccountNumber = req.getParameter("accountNumber");
		String amountValue = req.getParameter("amount");
		String senderEmail = (String) req.getSession().getAttribute("email");

	
		AccountInfo fromAccount = jdbc.getAccountInfo(senderEmail);
		double amount = Double.parseDouble(amountValue);
		ModelAndView mw = new ModelAndView();

		if (amount<fromAccount.getBalance()) {
			double amt = fromAccount.getBalance()-amount;
			fromAccount.setBalance(amt);
			try {
				jdbc.updateAccountInfo(fromAccount);
			} catch (Exception e1) {

			}
			AccountInfo toAccount = jdbc.getAccountInfo(Long.parseLong(recieverAccountNumber));

			if(toAccount != null) {
				amt = toAccount.getBalance()+amount;
				toAccount.setBalance(amt);
				try {
					jdbc.updateAccountInfo(toAccount);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				try {
					jdbc.insertActivities(toAccount.getAccountNumber(), "Credit", amount);
					jdbc.insertActivities(fromAccount.getAccountNumber(), "Debit", amount);
					mw.setViewName("/transfer.jsp");
					mw.addObject("message", "Amount $"+amount+" has been transfered to account "+toAccount.getAccountNumber()+ " successfully");


				} catch (Exception e) {
					mw.setViewName("/transfer.jsp");
					mw.addObject("error","There is some internal issue. Please try again");

				}
			} else {
				mw.setViewName("/transfer.jsp");
				mw.addObject("error", "Entered account number does not exist");
			}

		}
		else {
			mw.setViewName("/transfer.jsp");
			mw.addObject("error", "Insufficient Balance");

		}

return mw;
	}
}
