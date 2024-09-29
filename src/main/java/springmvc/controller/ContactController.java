package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonDataForModel(Model model) {
		model.addAttribute("formName","User Sign Up Form");
		model.addAttribute("desc","Good Job will ");
		System.out.println("Adding common data to Model");
	}
	
	@RequestMapping("/contact")
	public String showForm(Model model) {
		//model.addAttribute("header","User Sign Up Form"); does not work
		
		return "contact";
	}

	@RequestMapping("/search")
	public String showSearchForm() {
		//model.addAttribute("header","User Sign Up Form"); does not work
		
		return "search";
	}
	
	/*
	 * Old method to get data from view to controller 
	@RequestMapping(path="/processForm", method=RequestMethod.POST)
	public String handleForm(HttpServletRequest request) {
		
		String email=request.getParameter("email");
		System.out.println("email "+email);
		return "";
	}*/
	
	/* 
	 * Using @RequestParam 
	@RequestMapping(path="/processForm", method=RequestMethod.POST)
	public String handleForm(@RequestParam("email")    String userEmail,
			                 @RequestParam("userName") String userName,
			                 @RequestParam("userPassword") String userPassword,
			                 Model model) {
		
		System.out.println("Email "+userEmail);
		System.out.println("userName "+userName);
		System.out.println("userPassword "+userPassword);
		model.addAttribute("name", userName);
		model.addAttribute("password",userPassword);
		model.addAttribute("email", userEmail);
		return "success";
	}*/
	
	/*
	 * Using User model class
	@RequestMapping(path="/processForm", method=RequestMethod.POST)
	public String handleForm(@RequestParam("email")    String userEmail,
			                 @RequestParam("userName") String userName,
			                 @RequestParam("userPassword") String userPassword,
			                 Model model) {
		
	   User user =new User();
	   user.setEmail(userEmail);
	   user.setUserName(userName);
	   user.setUserPassword(userPassword);
	   
	   System.out.println(user);
		
		model.addAttribute("user", user);
		return "success";
	}
   */
	@RequestMapping(path="/processForm", method=RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user) {
		
	   System.out.println("in controller handleForm");
	   System.out.println("***********"+user+"&&&&&&&&&&&&");
	   if(user.getUserName().isBlank())
	   {
		   return "redirect:/contact";
	   }
	   this.userService.createUser(user);
	   return "success";
	}
	
	@RequestMapping(path="/processSearchForm", method=RequestMethod.POST)
	public String handleSearchForm(@ModelAttribute("user") User user, Model model) {
		
	   System.out.println("in Contactcontroller handleSearchForm");
	   System.out.println("  "+user+"  ");
	   if(user.getId()==0)
	   {
		   System.out.println("entered user id is 0");
		   return "redirect:/search";
	   }
	   User user1= this.userService.getUser(user.getId());
	   System.out.println("Found  "+user1+"  ");
	   model.addAttribute(user1);
	   return "success_search";
	}
}
