package bankingApp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ActivityController{
	
	@Autowired
	@Qualifier("hibernateConnImpl")
	DatabaseInf jdbc;

	@RequestMapping(value="/activities", method=RequestMethod.GET)
	protected ModelAndView activities(HttpServletRequest req)  {
		
		String email = (String) req.getSession().getAttribute("email");
	
		AccountInfo a = jdbc.getAccountInfo(email);
		ArrayList<Activities> at = jdbc.getAllActivites(a.getAccountNumber());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/activities.jsp");
		mv.addObject("activities", at);
		return mv;
		
		
	}

	
}
