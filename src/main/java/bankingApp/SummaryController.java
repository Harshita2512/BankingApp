package bankingApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SummaryController{
	
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	protected ModelAndView summary(HttpServletRequest req) throws ServletException, IOException {
		JdbcConn jdbc = new JdbcConn();
		String email = (String) req.getSession().getAttribute("email");
		AccountInfo a = jdbc.getAccountInfo(email);
		ModelAndView mw = new ModelAndView();
		mw.setViewName("/summary.jsp");
		mw.addObject("accountInfo", a);
		
		return mw;
	}

}
