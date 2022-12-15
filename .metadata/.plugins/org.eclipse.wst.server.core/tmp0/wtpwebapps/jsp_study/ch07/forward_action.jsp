<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--이전 내용을 유지한 채 가져다 줍니다.--%>
	<%request.setCharacterEncoding("UTF-8"); %>

	<jsp:forward page="page_control_end.jsp">
		<jsp:param value="000-1234-6231" name="tel"/>
	</jsp:forward>
</body>
</html>
