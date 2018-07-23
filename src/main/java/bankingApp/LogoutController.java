package bankingApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	protected ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.removeAttribute("email");
		session.removeAttribute("firstName");
		session.removeAttribute("phoneNumber");
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("/login.jsp");
	
		return mw;
	}
	
	
}
