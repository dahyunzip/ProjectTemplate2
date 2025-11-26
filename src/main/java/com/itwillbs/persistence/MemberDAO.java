package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	// 회원 등록
	int insertMember(MemberVO member);
	
	// 권한 등록
	int insertAuthority(String username, String authority);
	
	// username 중복 체크
	MemberVO findByUsername(String username);
}
