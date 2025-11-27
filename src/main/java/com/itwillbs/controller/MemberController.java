package com.itwillbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 마이페이지
	@GetMapping("/mypage")
	public String mypage(Model model) throws Exception{

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		
		//DB에서 최신정보 불러옴
		MemberVO vo = mService.getMemberByUsername(username);
		model.addAttribute("member", vo);
		
		return "/mypage";
	}
	
	
	@GetMapping("/modify")
	public String modifyInfoGET(HttpSession session, Model model) throws Exception{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		MemberVO vo = mService.getMemberByUsername(username);
		model.addAttribute("member", vo);
		
		return "/modify";
	}
	
	@PostMapping("/modify")
	public String modifyInfoPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		MemberVO dbMember = mService.getMemberByUsername(username);
		
		dbMember.setNickname(vo.getNickname());
		dbMember.setAddress(vo.getAddress());
		
		mService.updateMemberInfo(dbMember);
		
		rttr.addFlashAttribute("msg", "modifySuccess");
		
		return "redirect:/mypage";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() throws Exception{
		return "/withdraw";
	}
	
	// 탈퇴 메서드
	@PostMapping("/withdraw")
	public String withdraw(HttpSession session) throws Exception{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		mService.disableMember(username, 0);
		
		SecurityContextHolder.clearContext();
		session.invalidate();
		
		return "redirect:/login?withdrawSuccess";
	}
	
}
