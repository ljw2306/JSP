<%@page import="java.util.List"%>
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
		List<String> list = (List)request.getAttribute("list");
		for(int i = 0; i < list.size(); i++) {
			pageContext.setAttribute("i", i);
	 %>
	 	${list[i]}<br>
	<%
		}
	%>
	
	<hr>
	${map.get("a")}<br>
	${map.get("b")}<br>
	${map["c"]}<br>
	${map["d"]}<br>
	
	
	
</body>
</html>