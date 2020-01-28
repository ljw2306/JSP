<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		pageContext.setAttribute("p", "page");
		request.setAttribute("r", "request");
		session.setAttribute("s", "session");
		application.setAttribute("a", "application");
	%>
	
	${p} | ${r} | ${s} | ${a}<br>
	${pageScope.p} | ${requestScope.r} | ${sessionScope.s} | ${applicationScope.a}<br>
	
	
	${initParam.url}<br>
	
	<a href="a.jsp?id=tea">a.jsp</a>
	
</body>
</html>