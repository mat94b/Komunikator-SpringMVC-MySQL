package controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import containers.InformationHolder;
import containers.MessageHolder;
import containers.SendMessage;
import containers.Settings;
import database.Messages;
import database.ProfileReturner;
import database.Sending;
import database.SettingsUpdater;

@Controller
@RequestMapping(value = "/pl")
public class SendController {

	
	private ModelAndView pageReturner(){
		ModelAndView model2 = new ModelAndView("send.jsp");
		model2.addObject("nameAndSurname", InformationHolder.actualNameAndSurname);
		model2.addObject("contactAmound", InformationHolder.actualContactAmound);
		model2.addObject("tit", InformationHolder.actualNameAndSurname);
		return model2;
	}
	
	@RequestMapping(value = "/s" , method = RequestMethod.GET)
	public ModelAndView sendRequestGet(HttpSession session) {
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
	
	
	@RequestMapping(value = "/sent", method = RequestMethod.POST)
	public ModelAndView sendRequestPost(@ModelAttribute(value = "s") SendMessage messageContainer, HttpSession session) {
		if (session.isNew()) {
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		new Sending(messageContainer.getAdressContact(), messageContainer.getMessageText(), messageContainer.getTitleOfTheMessage());
		return this.pageReturner();
	}
	

}
