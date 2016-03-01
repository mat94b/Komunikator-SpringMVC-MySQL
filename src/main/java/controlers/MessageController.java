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
import containers.MessageHolder;
import containers.Profile;
import containers.Statistics;
import database.Messages;
import database.ProfileReturner;

@Controller
@RequestMapping(value = "/pl")
public class MessageController {

	@RequestMapping(value = "/message")
	public ModelAndView reg(HttpSession session) {
		if(session.isNew()){
			ModelAndView m = new ModelAndView("index.jsp");
			return m;
		}
		if((session.getAttribute("usernameSession").equals(InformationHolder.actualUsername))){
		Messages mess = new Messages(InformationHolder.actualUsername);
		ProfileReturner o = new ProfileReturner(InformationHolder.actualUsername);
		ModelAndView model2 = new ModelAndView("messager.jsp");
		model2.addObject("nameAndSurname", InformationHolder.actualNameAndSurname);
		model2.addObject("contactAmound", InformationHolder.actualContactAmound);
		model2.addObject("tit", InformationHolder.actualNameAndSurname);
		MessageHolder[] m = mess.messagesReturner();
		model2.addObject("messageHolder", m);
		return model2;
	}

		ModelAndView m = new ModelAndView("index.jsp");
		return m;
	}

}
