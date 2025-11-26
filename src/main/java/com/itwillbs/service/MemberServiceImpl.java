package com.itwillbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDao;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	@Override
	public void register(MemberVO member) {
		// 비밀번호 암호화
		String encoded = pwEncoder.encode(member.getPassword());
		member.setPassword(encoded);
		
		// DB 저장
		mDao.insertMember(member);
		mDao.insertAuthority(member.getUsername(), "ROLE_USER");
	}

	@Override
	public boolean isUsernameExists(String username) {
		return mDao.findByUsername(username) != null;
	}
	
}
