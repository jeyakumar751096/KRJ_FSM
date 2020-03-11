package com.fms.springsecurity.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.springsecurity.login.entity.LoginUserDetails;
import com.fms.springsecurity.login.entity.User;

@RestController
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/loginFailed")
	public String loginError(Model model) {
		log.info("login attempt failed");
		model.addAttribute("error", "true");
		return "login";
	}
	
	
	@PostMapping(value = "/postLogin")
	public String postLogin(Model model, HttpSession session) {
        log.info("postLogin()");
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) 
        		SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((LoginUserDetails) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getUserName());
        log.info("******loggedInUser.getUserName()********"+loggedInUser.getUserName());
        session.setAttribute("userId", loggedInUser.getUserId());
        return "redirect:/login";
    }
	
    private void validatePrinciple(Object principal) {
        if (!(principal instanceof LoginUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }

}
