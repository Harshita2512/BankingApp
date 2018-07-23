package bankingApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateInfoController{
	
	@RequestMapping(value="/updateInfo", method=RequestMethod.POST)
	protected ModelAndView updateInfo(HttpServletRequest req) throws ServletException, IOException {
		
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		String email = (String) req.getSession().getAttribute("email");
		
		JdbcConn jdbc = new JdbcConn();
		Customer c = new Customer();
		
		c.setPhoneNumber(Long.parseLong(phoneNumber));
		c.setPassword(password);
		c.setEmail(email);
		ModelAndView mv =  new ModelAndView();
		
		 try {
			jdbc.updateInformation(c);
			req.getSession().setAttribute("phoneNumber", phoneNumber);
			AccountInfo a = jdbc.getAccountInfo(email);
			
			mv.setViewName("/updateInfo.jsp");
			mv.addObject("message", "Your Information is updated");
			mv.addObject("accountInfo",a);
			
		} catch (Exception e) {
			mv.setViewName("/updateInfo.jsp");
			mv.addObject("error", "There is some internal issue. Please try again");
			
		}
		 
		 return mv;
	}
	

}
