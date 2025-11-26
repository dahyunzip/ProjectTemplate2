<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>홈</title>
</head>
<body>
    <sec:authorize access="isAuthenticated()">
	    <p>환영합니다, <strong><sec:authentication property="principal.username" /></strong> 님!</p>
	    <p>닉네임: <sec:authentication property="principal.nickname" /></p>
	    <p>주소: <sec:authentication property="principal.address" /></p>
	    <p>성별: <sec:authentication property="principal.gender" /></p>
	    <p>생년월일: <sec:authentication property="principal.birthdate" /></p>
  	</sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <p>로그인 해주세요.</p>
    </sec:authorize>

    <!-- 로그아웃 버튼 (예, 상단 공통 헤더에 포함) -->
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="로그아웃" />
    </form>
</body>
</html>
