package controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import database.DBConnector;
import database.RegisterAccount;

@Controller
@RequestMapping(value = "/pl")
public class RegistrationControllers {
	@ModelAttribute
	private void addingCommonObjects(Model model) {
		model.addAttribute("registerTitleMessage", "Rejestracia - M. S. B.");
		model.addAttribute("nicknameExist", "");
		model.addAttribute("emailExist", "");
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registrationTry() {
		ModelAndView model1 = new ModelAndView("newuser.jsp");		
		return model1;
	}
	
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView reg(@ModelAttribute(value="register") RegisterAccount ra) {
		DBConnector db = new DBConnector();
		if(db.checkAuthenticOfNewUser(ra.getEmailadress(), ra.getNickname())){
			ModelAndView model2 = new ModelAndView("newuser.jsp");
			model2.addObject("nicknameExist", "Taki nick ju¿ istnieje");
			model2.addObject("emailExist", "Taki e-mail ju¿ istnieje");
			return model2;
		} 		
		String imie = ra.getName();
		String nazwisko = ra.getLastname();
		String nick = ra.getNickname();
		String em = ra.getEmailadress();
		String password = ra.getPassword();
		String tel = ra.getCellphone();
		String miasto = ra.getCity();
		if(imie.equals("")) imie = "noname";
		if(nazwisko.equals("")) nazwisko = "noname";
		if(tel.equals("")) tel = "noname";
		if(miasto.equals("")) miasto = "noname";

		ModelAndView model2 = new ModelAndView("index.jsp");
		boolean done = db.registrationNewUser(imie, nazwisko, nick, em, password, tel, miasto);
		if (done==true) {
			model2.addObject("doneRegistration", true);
		}
		else{
			model2.addObject("doneRegistration", false);	
		}
		
		return model2;
	}
	
}
