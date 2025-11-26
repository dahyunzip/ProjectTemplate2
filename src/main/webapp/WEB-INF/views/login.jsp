<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>

    <!-- Spring Security form-login 기본 URL이 /login 이므로 action "/login" -->
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <div>
            <label for="username">아이디:</label>
            <input type="text" id="username" name="username" required />
        </div>
        <div>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <div>
            <input type="submit" value="로그인" />
        </div>
        
        <!-- 로그인 실패 시 보여줄 수 있도록 error 파라미터 확인 -->
		<c:if test="${param.error != null}">
			<div style="color:red;">
                로그인에 실패했습니다. 아이디 또는 비밀번호를 확인하세요.
            </div>
		</c:if>

        <!-- 로그아웃 후 /login?logout 에 리다이렉트되면 메시지 -->
        <c:if test="${param.logout != null}">
        	<div style="color:green;">
                로그아웃 되었습니다.
            </div>
        </c:if>
    </form>
    <hr>
    <input type="button" onclick="location.href='/signup'" value="회원가입">
</body>
</html>
