<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="calc" class="ch07.Calculator" />
<jsp:setProperty name="calc" property="*" />
<%-- 
calc.setN1(request.getParameter("n1"));
calc.setN2(request.getParameter("n2"));
calc.setOp(request.getParameter("op"));
* 을 하면 위의것이 전부 알아서 적용됨.
 --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과: <%=calc.calc()%>
</body>
</html>

