package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import containers.InformationHolder;
import database.ContactReturner;
import database.DBConnector;

@Controller
@RequestMapping(value = "/pl")
public class ContactsController {
	private ModelAndView pageReturner() {
		DBConnector db = new DBConnector();
		ModelAndView model2 = new ModelAndView("account.jsp");
		model2.addObject("nameAndSurname", InformationHolder.actualNameAndSurname); // Dodaje imie oraz nazwisko
		ContactReturner returnerList = new ContactReturner(InformationHolder.actualUsername);
		model2.addObject("contactArray", returnerList.contactListReturner());
		model2.addObject("titleM",InformationHolder.actualUsername + " &copy; M. S. B.");
		model2.addObject("contactAmound", InformationHolder.actualContactAmound);
		return model2;
	}

	@RequestMapping(value = "/c")
	public ModelAndView backToContacts(HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		if ((session.getAttribute("usernameSession").equals(InformationHolder.actualUsername))) {
			return this.pageReturner();
		}

		ModelAndView m = new ModelAndView("index.jsp");
		return m;
	}
}
