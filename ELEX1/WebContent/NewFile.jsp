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
	${"hello"} ${1}<br>
	${false}<br>
	${3+6}<br>
	${3-6}<br>
	${3*6}<br>
	${3/6}<br>
	${3%6}<br>
	<hr>
	
	${3>6}<br>
	${3>=5}<br>
	${3<5}<br>
	${3<=5}<br>
	${3==5}<br>
	${3!=5}<br>
	<hr>
	
	${true && true}<br>
	${true && false}<br>
	${false && true}<br>
	${false && false}<br>
	
	${true || true}<br>
	${true || false}<br>
	${false|| true}<br>
	${false || false}<br>
	
	${!true}<br>
	${!false}<br>
	<hr>
	
	${3 > 5 ? 3 : 5}<br>
</body>
</html>