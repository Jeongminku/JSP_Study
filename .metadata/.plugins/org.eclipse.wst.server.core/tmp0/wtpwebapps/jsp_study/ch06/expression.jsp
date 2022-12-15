<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Current Time: <%=Calendar.getInstance().getTime() %>
<hr/>
Current Time2: <%=Calendar.getInstance().getTimeInMillis() %>
<hr/>
Current Time3: <%=Calendar.getInstance().getTimeZone() %>
</body>
</html>