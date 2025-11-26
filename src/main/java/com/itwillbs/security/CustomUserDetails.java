package com.itwillbs.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itwillbs.domain.MemberVO;

public class CustomUserDetails implements UserDetails{
	
	private final MemberVO member;

    private final List<GrantedAuthority> authorities;
    
	public CustomUserDetails(MemberVO member, List<GrantedAuthority> authorities) {
		this.member = member;
		this.authorities = authorities;
	}

	// 추가 정보 getter
	public String getNickname() {
		return member.getNickname();
	}
	
	public String getAddress() {
        return member.getAddress();
    }
    public String getGender() {
        return member.getGender();
    }
    public Date getBirthdate() {
        return member.getBirthdate();
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return member.getAuthorities();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return member.isEnabled();
	}
	
}
