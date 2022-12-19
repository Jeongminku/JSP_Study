<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생 정보</h2><a href="/studentInfo2/StudentControl">새로고침</a>
<hr/>
<table border="1">
	<tr>
		<th>id</th>
		<th>이름</th>
		<th>대학</th>
		<th>생일</th>
		<th>이메일</th>	
	</tr>
	<!-- for(Student s : Students_key) 와 같은 표현.-->
	<!-- students_key는 ArrayList이고, s에는 Student객체가 하나씩 담기므로 그것을 풀어주면 된다.-->
	<c:forEach items="${students_key}" var="s">
		<tr>
			<td>${s.id}</td>
			<td>${s.username}</td>
			<td>${s.univ}</td>
			<td>${s.birth}</td>
			<td>${s.email}</td>
		</tr>			
	</c:forEach>
	
	
</table>

<h2>학생 추가</h2>
<hr>
<form method="post" action="/studentInfo2/StudentControl?action=insert"> <!-- input으로 입력하기위해서 form태그 사용. /폴더명/서블릿위치 -->
	<label>이름</label><input type="text" name="username" /><br />
	<label>대학</label><input type="text" name="univ" /><br />
	<label>생일</label><input type="text" name="birth" /><br />
	<label>이메일</label><input type="text" name="email" /><br />
	<button type="submit">등록</button>
</form>


</body>
</html>