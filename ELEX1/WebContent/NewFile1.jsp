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
		int a = 10;
		pageContext.setAttribute("ab", a);
	
	
	%>
	
	${ab}<br>
	
	<hr>
	
	<%
		int b = 20;
		pageContext.setAttribute("b", b);
	%>
	
	<%-- ${++b}<br>
	${4 & 1}<br>
	${4 >> 1}<br> --%>
	
	<%
		String msg = null;
		pageContext.setAttribute("msg", msg);
	
	%>
	
	${msg.charAt(0)}<br>
	
	${msg == null}<br>
	${empty msg}<br>
	${not empty msg}<br>
	
	
</body>
</html>