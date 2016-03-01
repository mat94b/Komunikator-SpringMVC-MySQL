package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import containers.InformationHolder;
import containers.Profile;
import containers.Statistics;
import database.DeleteAll;
import database.ProfileReturner;

@Controller
@RequestMapping(value = "/pl")
public class DeleteController {

	@RequestMapping(value = "/del")
	public ModelAndView reg(HttpSession session) {
		new DeleteAll(InformationHolder.actualUsername);
		ModelAndView m = new ModelAndView("index.jsp");
		session.removeAttribute("usernameSession");
		return m;
	}
}
