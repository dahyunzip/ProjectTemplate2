<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이페이지</h2>

	<div>
	    <p><strong>아이디:</strong> ${member.username}</p>
	    <p><strong>닉네임:</strong> ${member.nickname}</p>
	    <p><strong>주소:</strong> ${member.address}</p>
	</div>
	
    <button onclick="location.href='/modify'">회원정보 수정</button>
    <button onclick="location.href='/withdraw'">회원탈퇴</button>
	<button onclick="location.href='/'">홈으로</button>
	
<c:if test="${not empty msg}">
    <script>alert('회원정보가 수정되었습니다!');</script>
</c:if>
</body>
</html>