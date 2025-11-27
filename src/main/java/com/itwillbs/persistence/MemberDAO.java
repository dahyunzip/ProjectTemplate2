package com.itwillbs.persistence;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	// 회원 등록
	public int insertMember(MemberVO member);
	
	// 권한 등록
	public int insertAuthority(String username, String authority);
	
	// username 중복 체크
	public MemberVO findByUsername(String username);
	
	// user정보 업데이트
	public void updateMemberInfo(MemberVO vo) throws Exception;
	
	// 소프트 딜리트
	public void updateEnabled(@Param("username") String username, @Param("enabled") int enabled) throws Exception;
}
