package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void register(MemberVO member);
	
	// username 중복 체크
	public boolean isUsernameExists(String username);
	
	// 회원정보 수정
	public void updateMemberInfo(MemberVO vo) throws Exception;
	
	// username으로 정보 ㄱ가져오기
	public MemberVO getMemberByUsername(String username) throws Exception;
	
	// 소프트 딜리트
	public void disableMember(String username, int enabled) throws Exception;
}
