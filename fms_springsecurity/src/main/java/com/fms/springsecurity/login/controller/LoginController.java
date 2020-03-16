package com.fms.springsecurity.login.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fms.springsecurity.login.entity.Authority;
import com.fms.springsecurity.login.entity.LoginUserDetails;
import com.fms.springsecurity.login.entity.User;
import com.fms.springsecurity.login.enumtype.AuthorityType;

@RestController
@RequestMapping("/")
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	 ModelAndView modelView = new ModelAndView();
	
	@GetMapping(value = "/login")
	public ModelAndView login() {
		//ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		return modelView;
	}
	
	@GetMapping(value = "/loginFailed")
	public ModelAndView loginError(Model model) {
		log.info("login attempt failed");
		ModelAndView modelView = new ModelAndView();
		model.addAttribute("error", "true");
		modelView.setViewName("login");
		return modelView;
	}
	
	@GetMapping(value = "/logout")
    public ModelAndView logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        //return "redirect:/welcome";
        modelView.setViewName("login");
		return modelView;
    }
	
	@PostMapping(value = "/postLogin")
	public ModelAndView postLogin(Model model, HttpSession session) {
        log.info("postLogin()");
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) 
        		SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((LoginUserDetails) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getUserName());
        
       List<AuthorityType> roles = loggedInUser.getAuthorities().stream().map(r->r.getAuthorityName()).collect(Collectors.toList());
        /*
         * Set<String> roles = authentication.getAuthorities().stream()
     .map(r -> r.getAuthority()).collect(Collectors.toSet());
         */
        model.addAttribute("currentRole", roles.get(0));
        log.info("******loggedInUser.getUserName()********"+loggedInUser.getUserName());
        session.setAttribute("userId", loggedInUser.getUserId());
        // return "redirect:/welcome";
        //ModelAndView modelView = new ModelAndView();
        modelView.setViewName("welcome");
        return modelView;
        
      
    }
	
	@GetMapping(value="/access-denied")
	public ModelAndView deniedPage() {
		ModelAndView modelView=new ModelAndView();
		modelView.setViewName("access-denied");
		return modelView;
	}
	
    private void validatePrinciple(Object principal) {
        if (!(principal instanceof LoginUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }

}
