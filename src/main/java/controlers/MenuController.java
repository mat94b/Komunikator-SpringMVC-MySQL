/*
 * Klasa jest kontrolerem.
 * Tworzy model profile.html.
 */

package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import containers.InformationHolder;
import containers.Profile;
import containers.Statistics;
import database.ProfileReturner;

@Controller
@RequestMapping(value = "/pl")
public class MenuController {

	@RequestMapping(value = "/profile")
	public ModelAndView reg(HttpSession session) {
		if(session.isNew()){
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		ProfileReturner o = new ProfileReturner(InformationHolder.actualUsername);
		Profile p = o.getProfilesInformation();
		Statistics s = o.getStatisticInformation();
		ModelAndView model2 = new ModelAndView("profil.jsp");
		model2.addObject("nameAndSurname", InformationHolder.actualNameAndSurname);
		model2.addObject("contactAmound", InformationHolder.actualContactAmound);
		model2.addObject("tit", InformationHolder.actualNameAndSurname);
		model2.addObject("un", InformationHolder.actualUsername);
		model2.addObject("email", p.getAdressEmail());
		model2.addObject("city", p.getCity());
		model2.addObject("religion", p.getReligion());
		model2.addObject("des", p.getInterests());
		model2.addObject("phone", p.getPhone());
		model2.addObject("lang", p.getLanguages());
		model2.addObject("birthday", p.getBirthdate());
		model2.addObject("id", s.getId());
		model2.addObject("lastOnline", s.getLastOnline());
		model2.addObject("sendM", s.getSendMessages());
		model2.addObject("recievedM", s.getRecievedMessages());
		model2.addObject("registraionDate", s.getRegistrationDate());
		model2.addObject("registeredPeople", o.howManyRegistered());
		model2.addObject("sameName", o.howManyTheSameName("Mateusz"));
		model2.addObject("creative", o.crative());
		System.out.println("MAX: "+o.maxId());
		System.out.println("MIN: "+o.minId());
		return model2;
	}

}
