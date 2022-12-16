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
	<h2>JSTL 종합예제</h2>
	<hr>
	<h3>set, out</h3>
	<!-- pageScope영역에 저장된다. -->
	<c:set var="Scorpion" value="<h1>진짜무서운스콜피온</h1>"/>
	<c:set var="product1" value="<b>애플 아이폰</b>" />
	<c:set var="product2" value="<b>삼성 갤럭시 노트</b>" />
	<c:set var="intArray" value="${[1,2,3,4,5]}" />
	<p>
	product1(JSTL) 출력: <c:out value="${product1}" default="Not registered" escapeXml="true"></c:out> <br/>
	나와라 스콜피온:<c:out value="${Scorpion}" default="전갈이 없어요" escapeXml="true"></c:out>
	<br/>
	product1(JSTL) 같은 경우 c:out value="${product1}"로 출력하는데 b태그가 안먹고 그냥 태그쓰인거 자체로 출력이됨.
	<br/>
	그치만, defalut값이나 escapeXml 같은 값을 줘야할 때 사용함.
	</p>
	<hr/>
	<p>
	
	product2(EL) 출력: ${product1}<br/>
	product2(EL) 같은 경우 태그가 적용된 채로 출력한다.<br/>
	scorpion(EL) 출력하기: ${Scorpion}
	<hr/>
	intArray[2]출력: ${intArray[2]}<br/>
	intArray부분에 오류가 발생하는건 자체 오류이므로 크게 생각하지 않아도 된다. 
	</p>
	<hr/>
	<h3>forEach배열 출력</h3>
	
	<!-- for(int num : intArray) 와 같은표현. -->
	<ul>
		<c:forEach var="num" varStatus="i" items="${intArray}">
			<li>${i.index} : ${num}</li>
		</c:forEach>
	</ul>
	
	<hr/>
	<h3>if</h3>
	<c:set var="checkout" value="true" />
	<!-- if(checkout == true) 과 같은 표현 -->
	<c:if test="${checkout}">
		<p>주문 제품: ${product2}</p>
	</c:if>
	
	<!-- if(checkout != true) 과 같은 표현 -->
	<c:if test="${!checkout}">
		<p>주문 제품이 아닙니다.</p>
	</c:if>
	
	<!-- empty 는 product2에 값이 들어가 있는지 아닌지 체크한다. -->
	<c:if test="${!empty product2 }">
		<p>${product2}안에 값이 비어있지 않습니다.</p>
	</c:if>
	
	
	<hr>
	<h3>choose, when, otherwise</h3>
	<c:choose>
		<c:when test="${checkout}">
			<p>주문 제품: ${product2}</p>
		</c:when>
		<c:when test="${!checkout}">
			<p>주문 제품: ${product2}</p>
		</c:when>
		<c:otherwise>
			<p>주문 제품이 아닙니다.</p>
		</c:otherwise>
	</c:choose>
	
	
	<hr>
	<h3>forTokens</h3>
	<c:forTokens var="card" items="KING | QUEEN | JACK | A C E | JOKER" delims="|" varStatus="i">
		<!-- i.first = 인덱스가 첫번째라면 true를 반환.
			 if(i.first == true) -->
		<c:if test="${i.first}"> 도시목록: </c:if>
		
		${card}

		<!-- 인덱스가 마지막이 아니라면 실행함. -->
		<!-- if(i.last !=true) -->
		<c:if test="${!i.last}">,</c:if>
	</c:forTokens>
	
	
	
	
	
</body>
</html>