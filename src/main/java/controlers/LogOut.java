package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import containers.InformationHolder;
import database.DeleteAll;

@Controller
@RequestMapping(value = "/pl")
public class LogOut {
	@RequestMapping(value = "/lo")
	public ModelAndView reg(HttpSession session) {
		ModelAndView m = new ModelAndView("index.jsp");
		session.removeAttribute("usernameSession");
		return m;
	}
}
