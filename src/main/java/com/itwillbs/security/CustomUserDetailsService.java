package com.itwillbs.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberDAO mDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = mDao.findByUsername(username);
		if(username == null) {
			throw new UsernameNotFoundException("User not found : " + username);
		}
		// 권한 리스트 — 만약 관리 권한/역할이 필요 없으면 기본 ROLE_USER 하나라도 할당
        GrantedAuthority defaultAuth = new SimpleGrantedAuthority("ROLE_USER");
        return new CustomUserDetails(member, Collections.singletonList(defaultAuth));
	}
	
	
}
