<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>안녕 JSP! 세상에서 제일가는 포테이토칩</h2>
	<hr/>
	현재 날짜와 시간은
	<%=java.time.LocalDateTime.now()%>>
	입니다.
</body>
</html>
