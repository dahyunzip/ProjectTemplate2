package com.itwillbs.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class MemberVO {
	private String username;
	private String password;
	private boolean enabled;
	
	private String nickname;
	private String address;
	private String gender;
	private Date birthdate;
	
	// 권한 정보
    private List<GrantedAuthority> authorities;
}
