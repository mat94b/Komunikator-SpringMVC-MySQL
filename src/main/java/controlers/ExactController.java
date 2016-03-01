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
import containers.Key;
import database.Account;
import database.ContactReturner;
import database.DBConnector;

@Controller
@RequestMapping(value = "/pl")
public class ExactController {

	@ModelAttribute
	private void addingCommonObjects(Model model) {
		model.addAttribute("indexTitleMessage", "M. S. B.");
	}

	@RequestMapping(value = "/contactExact", method = RequestMethod.POST)
	public ModelAndView checker(@ModelAttribute(value = "acc") Key k, HttpSession session) {
		DBConnector db = new DBConnector();
		ModelAndView model2 = new ModelAndView("account.jsp");
		String tmp = db.returnNameAndSurname(InformationHolder.actualUsername);
		InformationHolder.actualNameAndSurname = tmp;
		model2.addObject("nameAndSurname", tmp); // Dodaje imie oraz nazwisko
		ContactReturner returnerList = new ContactReturner(InformationHolder.actualUsername);
		model2.addObject("contactArray", returnerList.contactListReturnerProcedure(k.getKey()));
		model2.addObject("titleM", InformationHolder.actualUsername + " &copy; M. S. B.");
		session.setAttribute("usernameSession", InformationHolder.actualUsername);
		model2.addObject("contactAmound", InformationHolder.actualContactAmound);
		db.changelastLogDate();
		return model2;

	}

}
