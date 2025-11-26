package com.itwillbs.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info(" 사용자가 로그인 성공시 실행!");
		
		 // 로그인 성공 후 권한(role)에 따라 리다이렉트 할 경로 결정
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean isAdmin = authorities.stream()
                .anyMatch(auth -> "ROLE_ADMIN".equals(auth.getAuthority()));

        if (isAdmin) {
            // ADMIN 권한이면 /admin 페이지 (혹은 적절한 관리자 페이지)로
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            // 일반 사용자면 기본 홈('/') 또는 원하는 페이지로
            response.sendRedirect(request.getContextPath() + "/");
        }
		
	}

	
}
