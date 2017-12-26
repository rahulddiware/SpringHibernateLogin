package javaonline.login.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javaonline.menu.model.Menu;
import javaonline.menu.service.RoleMenuService;

@Controller
@RequestMapping("/")
public class UserController {
  
	    @Autowired
	    RoleMenuService roleMenuService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    
 

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    } 
    
    
   
    @RequestMapping(value = "/loadMenuItem", method =  {RequestMethod.POST, RequestMethod.GET})
    public String loadMenu(HttpServletRequest request, Model model, Authentication authentication) {
    	
  	List<Menu> menuList=new ArrayList<Menu>();
    	
    	System.out.println("menu map " +roleMenuService.menuMap("ROLE_USER"));
    	
    	System.out.println("role name "+authentication.getAuthorities() );
    	
    	
    	int[] i = { 0 };
    	
    	Iterator it=authentication.getAuthorities().iterator();
    	
    	while (it.hasNext())
    	{
    	
        roleMenuService.menuMap(it.next().toString()).forEach((k,v)->
        {
        	
        	Menu m1=new Menu();
        	m1.setId(i[0]+++"");
        	m1.setLabel(k);
        	m1.setUrl(v);
        	menuList.add(m1);
        	
        }
        		);
    	}
    	
    	
    	model.addAttribute("menuList",menuList);
    	
          return "menu/menu";
    }
    
    
       
   

}
