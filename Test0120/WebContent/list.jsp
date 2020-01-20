<%@page import="java.util.ArrayList"%>
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
	
	<header>
	<%@ include file="header.jsp" %>
	</header>
	
	<h1>회원 목록</h1>
	
	<%
		Object obj3 = request.getAttribute("list");
		if(obj3 != null) {
			List<MemberDTO> list = (List<MemberDTO>) obj3;
			 for(int i = 0; i<list.size(); i++) {
				 MemberDTO dto = list.get(i);
				 %>
				 	<%= dto.getId() %>:<a href="read.do?id=<%=dto.getId()%>"><%=dto.getName()%></a><br>
				 <%
			 }
		}
	%>
	
	<footer>
	<%@ include file="footer.jsp" %>
	</footer>
	
</body>
</html>