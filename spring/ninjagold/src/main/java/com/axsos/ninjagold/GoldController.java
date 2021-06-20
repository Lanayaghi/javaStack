package com.axsos.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GoldController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		if(session.getAttribute("gold")== null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList<String>());
		}
		
		return"index.jsp";
	}
	@RequestMapping(value = "/gold", method=RequestMethod.POST)
	public String gold(HttpSession session, @RequestParam(value="building") String building, Model model) {
		
		String timeStamp = new SimpleDateFormat("E, MMM d, y'at' h:mm a").format(new Date());
		
		if (building.equals("farm")) {
			Integer randFarm = getRandomGold(20,10);	
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+randFarm);
			((ArrayList<String>) session.getAttribute("activities")).add("you enterd a farm and earned"+randFarm+" gold.("+timeStamp+")");
			
			
			}else if (building.equals("cave")) {
				Integer randCave = getRandomGold(10,5);
				Integer gold = (Integer)session.getAttribute("gold");
				session.setAttribute("gold", gold+randCave);
				((ArrayList<String>) session.getAttribute("activities")).add("you enterd a cave and earned"+randCave+" gold.("+timeStamp+")");
				
			}else if (building.equals("house")) {
				Integer randHouse = getRandomGold(5, 2);
				Integer gold = (Integer)session.getAttribute("gold");
				session.setAttribute("gold", gold+randHouse);
				((ArrayList<String>) session.getAttribute("activities")).add("you enterd a house and earned"+randHouse+" gold.("+timeStamp+")");
				
			}else if (building.equals("casino")) {
				Integer randCasino = getRandomGold(50, -50);
				Integer gold = (Integer)session.getAttribute("gold");
				session.setAttribute("gold", gold+randCasino);
				if(randCasino > 0) {
				((ArrayList<String>) session.getAttribute("activities")).add("you enterd a farm and earned"+randCasino+" gold.("+timeStamp+")");
			}
				else {
					((ArrayList<String>) session.getAttribute("activities")).add("ouch! you enterd a casino and lost"+randCasino+" gold.("+timeStamp+")");
				}
		
	}
		return "redirect:/";
	}
		
		
	private Integer getRandomGold(int max, int min) {
		Random rand = new Random();
		int value = rand.nextInt((max-min)+1)+min;
		return value;
	}
	
	

}
