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

	<h1>회원가입</h1>
	<form action="insert.do" method="post">
		<label for="id">id: </label>
		<input name="id" id="id"><br>
		
		<label for="name">name: </label>
		<input name="name" id="name"><br>
		
		<label for="age">age: </label>
		<input name="age" id="age">
		
		<input type="submit" value="회원등록">
	
	</form>

</body>
</html>