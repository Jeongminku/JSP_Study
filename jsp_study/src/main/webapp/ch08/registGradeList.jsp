<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객목록</h2>
	<hr>
	<table border="1">
	 <tr>
		<th>아이디</th>	
		<th>이 름</th>	
		<th>전화번호</th>
		<th>고객등급</th>
	 </tr>
	 
	 <c:forEach var="r" varStatus="i" items="${gg}">
	 	<tr>
	 		<td>${i.count}</td>
	 		<td><a href="/jsp_study/RegistController?action=info&id=${r.id}">${r.name}</a></td>
	 		<td>${r.phone}</td>
	 		<td>${r.grade}${r.kgrade}</td>
	 		
	 	</tr>
	 </c:forEach>
	</table>
	<a href="/jsp_study/RegistController?action=confirm">등급 확인</a>
	
</body>
</html>