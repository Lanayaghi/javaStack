package com.axsos.TimeDisplay;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
   
    @RequestMapping("/date")
    public String date(Model model) {
    	Date today = new Date();
		 SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("\"EEE, 'the' d MMM yyyy\"");
		 String date = DATE_FORMAT.format(today);
		model.addAttribute("date", date);
        return "date.jsp";
    }
 
    @RequestMapping("/time")
    public String time(Model model) {
    	Date today = new Date();
		 SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm aaa");
		 String time = DATE_FORMAT.format(today);
		model.addAttribute("time", time);
        return "time.jsp";
    }
}
