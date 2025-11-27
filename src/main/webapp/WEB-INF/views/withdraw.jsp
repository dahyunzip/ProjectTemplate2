<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원탈퇴 페이지</h2>
<form action="/withdraw" method="post" onsubmit="return validateWithdrawForm()">

    <label>
        <input type="checkbox" id="agreeCheck"> 탈퇴에 동의합니다.
    </label>

    <input type="text" id="confirmText" placeholder="탈퇴하겠습니다. 입력" />

    <button type="submit">탈퇴하기</button>
</form>

</body>
</html>