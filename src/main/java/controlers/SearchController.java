package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import containers.FinderHolder;
import containers.InformationHolder;
import containers.Profile;
import containers.SendMessage;
import containers.Statistics;
import database.AddFriend;
import database.ContactReturner;
import database.ProfileReturner;

@Controller
@RequestMapping(value = "/pl")
public class SearchController {
	
	private String aaa;
	
	private ModelAndView pageReturner(String u){
		ContactReturner cr = new ContactReturner(u);
		if(!(cr.isExist())){
			return new ModelAndView("failure.jsp");
		}
		ModelAndView model2 = new ModelAndView("finder.jsp");
		ProfileReturner o = new ProfileReturner(u);
		Profile p = o.getProfilesInformation();
		Statistics s = o.getStatisticInformationSec(u);
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
		model2.addObject("nameAndSurname", InformationHolder.actualNameAndSurname);
		model2.addObject("contactAmound", InformationHolder.actualContactAmound);
		model2.addObject("tit", u);
		InformationHolder.visitedProfile = u;
		return model2;
	}
	

	@RequestMapping(value = "/find" , method = RequestMethod.POST)
	public ModelAndView findRequestGet(@ModelAttribute(value = "s") FinderHolder fh, HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		this.aaa = fh.getFindThisPerson();
		if ((session.getAttribute("usernameSession").equals(InformationHolder.actualUsername))) {
			return this.pageReturner(fh.getFindThisPerson());
		}
		ModelAndView m = new ModelAndView("index.jsp");
		return m;
	}
	
	@RequestMapping(value = "/addcontact")
	public ModelAndView adding(HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		if ((session.getAttribute("usernameSession").equals(InformationHolder.actualUsername))) {
			new AddFriend(InformationHolder.visitedProfile);
			return this.pageReturner(aaa);
		}
		ModelAndView m = new ModelAndView("index.jsp");
		return m;
	}
	
	
}
