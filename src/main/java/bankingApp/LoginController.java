package bankingApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired 
	private HttpSession httpSession;

	@Autowired
	JdbcConn jdbcConn;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected ModelAndView login(String email, String password) throws ServletException, IOException {

		Customer c = jdbcConn.getCusometrInfo(email);
		ModelAndView mw = new ModelAndView();

		if (c!=null) {
			if(c.getPassword().equals(password)) {
				AccountInfo a = jdbcConn.getAccountInfo(email);

				httpSession.setAttribute("name",c.getFirstName());
				httpSession.setAttribute("email",c.getEmail());
				httpSession.setAttribute("phoneNumber",c.getPhoneNumber());

				mw.setViewName("/summary.jsp");
				mw.addObject("accountInfo", a);
			} else {
				mw.setViewName("/login.jsp");
				mw.addObject("error", "Password does not match" );	
			}
		}
		else {
			mw.setViewName("/login.jsp");
			mw.addObject("error", "User does not match" );	

		}
		return mw;
	}

}
