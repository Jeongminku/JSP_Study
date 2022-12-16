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
	<h2>상품목록</h2>
	<hr>
	<table border="1">
	 <tr>
		<th>번 호</th>	
		<th>상품명</th>	
		<th>가 격</th>	
	 </tr>
	 <!-- for(Product p : products) 와 같은 표현. -->
	 <c:forEach var="p" varStatus="i" items="${products1}">
	 	<tr>
	 		<td>${i.count}</td>
	 		<td><a href="/jsp_study/pcontrol?action=info&id=${p.id}">${p.name}</a></a></td>
	 		<td>${p.price}</td>
	 	</tr>
	 </c:forEach>
	</table>
</body>
</html>