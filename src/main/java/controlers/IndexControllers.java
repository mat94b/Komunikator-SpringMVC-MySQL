package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import containers.InformationHolder;
import database.Account;
import database.ContactReturner;
import database.DBConnector;

@Controller
@RequestMapping(value = "/pl")
public class IndexControllers {

	@ModelAttribute
	private void addingCommonObjects(Model model) {
		model.addAttribute("indexTitleMessage", "M. S. B.");
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexReturner() {
		ModelAndView model1 = new ModelAndView("index.jsp");
		return model1;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checker(@ModelAttribute(value="acc") Account acc, HttpSession session) {
		DBConnector db = new DBConnector();
		String isCorrectPassword = db.passwordChecker(acc.getUsername());
		String isCorrectPasswordEmail = db.emailChecker(acc.getUsername());
		if(acc.getPassword().equals(isCorrectPassword)){
			ModelAndView model2 = new ModelAndView("account.jsp");
			String tmp = db.returnNameAndSurname(acc.getUsername());
			InformationHolder.actualNameAndSurname = tmp;
			model2.addObject("nameAndSurname", tmp); // Dodaje imie oraz nazwisko
			InformationHolder.actualUsername = acc.getUsername();
			ContactReturner returnerList = new ContactReturner(acc.getUsername());
			model2.addObject("contactArray", returnerList.contactListReturner());
			model2.addObject("titleM", acc.getUsername() +  " &copy; M. S. B.");
			session.setAttribute("usernameSession", acc.getUsername());
			model2.addObject("contactAmound", InformationHolder.actualContactAmound);
			InformationHolder.actualUsername = acc.getUsername();
			db.changelastLogDate();
			return model2;
		}
		
		else if(acc.getPassword().equals(isCorrectPasswordEmail)){
			ModelAndView model2 = new ModelAndView("account.jsp");
			session.setAttribute("usernameSession", acc.getUsername());
			model2.addObject("contactAmound", InformationHolder.actualContactAmound);
			model2.addObject("titleM", acc.getUsername() +  " &copy; M. S. B.");
			ContactReturner returnerList = new ContactReturner(acc.getUsername());
			model2.addObject("contactArray", returnerList.contactListReturner());
			InformationHolder.actualUsername = acc.getUsername();
			String tmp = db.returnNameAndSurname(acc.getUsername());
			InformationHolder.actualNameAndSurname = tmp;
			model2.addObject("nameAndSurname", tmp); // Dodaje imie oraz nazwisko
			db.changelastLogDate();
			return model2;
		}
		ModelAndView model2 = new ModelAndView("index.jsp");
		return model2;
	}	

}
