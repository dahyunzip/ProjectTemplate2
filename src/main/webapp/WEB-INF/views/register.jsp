<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
</head>
<body>
  <h2>회원가입</h2>
  <form action="${pageContext.request.contextPath}/signup" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div>
      <label for="username">아이디 :</label>
      <input type="text" id="username" name="username" required />
    </div>
    <div>
      <label for="password">비밀번호 :</label>
      <input type="password" id="password" name="password" required />
    </div>
    <div>
      <label for="nickname">닉네임 :</label>
      <input type="text" id="nickname" name="nickname" required />
    </div>
    <div>
      <label for="address">주소 :</label>
      <input type="text" id="address" name="address" required />
    </div>
    <div>
      <label>성별 :</label>
      <input type="radio" id="gender_m" name="gender" value="M" required />
      <label for="gender_m">남성</label>
      &nbsp;
      <input type="radio" id="gender_f" name="gender" value="F" required />
      <label for="gender_f">여성</label>
    </div>
    <div>
      <label for="birthdate">생년월일 :</label>
      <input type="date" id="birthdate" name="birthdate" required />
    </div>
    <div>
      <input type="submit" value="가입하기" />
    </div>
  </form>
</body>
</html>