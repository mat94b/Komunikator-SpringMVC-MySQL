/*
 * Kontroler odpowiedzialny za ulozenie podstrony settings.html
 */

package controlers;

import java.lang.ref.PhantomReference;

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
import containers.MessageHolder;
import containers.Profile;
import containers.Settings;
import containers.Statistics;
import database.Account;
import database.ContactReturner;
import database.DBConnector;
import database.Messages;
import database.ProfileReturner;
import database.SettingsUpdater;

@Controller
@RequestMapping(value = "/pl")
public class KeyController {

	@RequestMapping(value = "/key", method = RequestMethod.POST)
	public ModelAndView keyFinder(@ModelAttribute(value = "sett") Key k, HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		if ((session.getAttribute("usernameSession").equals(InformationHolder.actualUsername))) {
			Messages mess = new Messages(InformationHolder.actualUsername);
			ProfileReturner o = new ProfileReturner(InformationHolder.actualUsername);
			ModelAndView model2 = new ModelAndView("messager.jsp");
			model2.addObject("nameAndSurname", InformationHolder.actualNameAndSurname);
			model2.addObject("contactAmound", InformationHolder.actualContactAmound);
			model2.addObject("tit", InformationHolder.actualNameAndSurname);
			MessageHolder[] m = mess.fullTextReturner(k.getKey());
			model2.addObject("messageHolder", m);
			return model2;
		}

		ModelAndView m = new ModelAndView("index.jsp");
		return m;
	}

}
