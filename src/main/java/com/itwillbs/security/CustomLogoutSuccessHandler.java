package com.itwillbs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/*
 * 251127
 * 만들었는데 안쓰는중
 * */

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler{

	public CustomLogoutSuccessHandler() {
		// 로그아웃 후 이동할 기본 URL + 파라미터 설정
		setDefaultTargetUrl("/login?logout");
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		super.onLogoutSuccess(request, response, authentication);
	}
	
	
}
