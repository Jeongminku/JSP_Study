<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! String hi = "Hello,Java Server Pages"; 

	String getString(String str) {
		return str;
}%>
	
	<%= getString(hi) %>
	<hr/>
	<% out.println(getString(hi)); %>
	
</body>
</html>