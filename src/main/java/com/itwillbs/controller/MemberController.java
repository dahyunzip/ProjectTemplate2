package com.itwillbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@GetMapping("/signup")
	public String showSignupForm() {
		return "register";
	}
	
	@PostMapping("/signup")
	public String doSignup(MemberVO member) {
		if(mService.isUsernameExists(member.getUsername())) {
			// 중복 아이디이면 처리
			return "redirect:/signup?error=exist";
		}
		mService.register(member);
		return "redirect:/login";
	}
	
}
