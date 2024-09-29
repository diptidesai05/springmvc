package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/app")
public class HomeController {
	
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public String home(Model model) {
		System.out.println("this is home URL");
		model.addAttribute("name", "Macchu");
		List<String> friends = new ArrayList<String>();
		friends.add("Mooo");
		friends.add("JKLLL");
		model.addAttribute("listObj",friends);
		return "home";
	}
    
	@RequestMapping("/about")
	public String about() {
		System.out.println("this is about URL");
		return "about";
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("this is index URL");
		return "index";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("this is help URL");
		ModelAndView modelNview = new ModelAndView();
		modelNview.addObject("name", "HGHGHG");
		modelNview.addObject("rollnumber", 1123456);
		LocalDateTime now = LocalDateTime.now();
		modelNview.addObject("time",now);
		List<Integer> lst= new ArrayList<Integer>();
		lst.add(12);
		lst.add(15);
		lst.add(20);
		lst.add(63);
		lst.add(9699);
		modelNview.addObject("marks",lst);
		return modelNview;
	}
	
	@RequestMapping("/userhome")
	public String userHome() {
		System.out.println("this is about User Home");
		return "userhome1";
	}
	
	@RequestMapping("/welcome")
	public String welcome(@RequestParam("user") String name, Model m) {
		System.out.println("user name "+name);
		m.addAttribute("name",name);
		return "welcome";
		
	}
	
}
