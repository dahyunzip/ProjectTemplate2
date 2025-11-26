package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void register(MemberVO member);
	
	// username 중복 체크
	public boolean isUsernameExists(String username);
}
