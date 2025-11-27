<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<form action="/modify" method="post">

    <div>
        <label>닉네임</label>
        <input type="text" name="nickname" value="${member.nickname}" required>
    </div>

    <div>
        <label>주소</label>
        <input type="text" name="address" value="${member.address}" required>
    </div>

    <button type="submit">수정하기</button>
</form>
</body>
</html>