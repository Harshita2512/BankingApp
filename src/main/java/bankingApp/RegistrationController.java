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
public class RegistrationController {
	
	@Autowired
	@Qualifier("dbConn")
	DatabaseInf jdbc;

	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	protected ModelAndView registration(HttpServletRequest req) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String lastName =req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phoneNumber = req.getParameter("phoneNumber");
		
		
		Customer c = new Customer();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setEmail(email);
		c.setPassword(password);
		c.setPhoneNumber( Long.parseLong(phoneNumber));
		
		Customer existingUser = jdbc.getCusometrInfo(email);
		ModelAndView mw = new ModelAndView();
		if(existingUser==null) {
			try {
				jdbc.RegisterUser(c);
				jdbc.insertAccountInfo(email);
				long a = jdbc.getAccountInfo(email).getAccountNumber();
				
				SendEmail.sendAccountInfo(email, a);
				
				mw.setViewName("/login.jsp");
				mw.addObject("message", "Registration Complete");
				
			} catch (Exception e) {
				mw.setViewName("/signup.jsp");
				mw.addObject("error", "There is some internal issue. Please register again");
			}
			
		}else {
			mw.setViewName("/signup.jsp");
			mw.addObject("error",  "User is already exist with matching this email Id");
		}
		return mw;
		
		
		
	}
}
