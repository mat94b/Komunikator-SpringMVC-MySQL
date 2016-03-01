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
import containers.Profile;
import containers.Settings;
import database.Account;
import database.ContactReturner;
import database.DBConnector;
import database.ProfileReturner;
import database.SettingsUpdater;

@Controller
@RequestMapping(value = "/pl")
public class SettingsController {

	private ModelAndView helperReturner() {
		ModelAndView model1 = new ModelAndView("settings.jsp");
		ProfileReturner o = new ProfileReturner(InformationHolder.actualUsername);
		Profile p = o.getProfilesInformation();
		model1.addObject("contactAmound", InformationHolder.actualContactAmound);
		model1.addObject("nameAndSurname", InformationHolder.actualNameAndSurname);
		model1.addObject("lang", p.getLanguages());
		model1.addObject("rel", p.getReligion());
		model1.addObject("cit", p.getCity());
		model1.addObject("pho", p.getPhone());
		model1.addObject("des", p.getInterests());
		return model1;

	}

	@RequestMapping(value = "/sett", method = RequestMethod.GET)
	public ModelAndView indexReturner(HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		return this.helperReturner();
	}

	@RequestMapping(value = "/newset", method = RequestMethod.POST)
	public ModelAndView checker(@ModelAttribute(value = "sett") Settings sett, HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		SettingsUpdater su = new SettingsUpdater();
		if (sett.getLanguage().equals("")) {
		} else {
			su.updateLanguage(sett.getLanguage());
		}
		if (sett.getLivingCity().equals("")) {
		} else {
			su.updateCity(sett.getLivingCity());
		}
		if (sett.getReligion().equals("")) {
		} else {
			su.updateReligion(sett.getReligion());
		}
		if (sett.getTelephone().equals("")) {
		} else {
			su.updateCellPhone1(sett.getTelephone());
		}
		if (sett.getDesc().equals("")) {
		} else {
			su.updateDescription(sett.getDesc());
		}
		return this.helperReturner();
	}
}
