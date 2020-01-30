<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<h1>회원 등록</h1>
	<form action="insert.do" method="post">
		ID: <input required name="id"><button>중복체크</button>
		<p></p>
		<br>
		Name: <input required name="name"><br>
		Age: <input required name="age", type="number"><br>
		<input type="submit" value="sign up">
	</form>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("button").click(function(){
				var idda = $("input[name='id']").val();
				
				$.ajax({
					type: 'get',
					url: 'checkid.do',
					data: {
						id : idda
					},
					dataType: 'text',
					success: function(result){
						$("p").text(result)
					}
				});
				
			});
		});
	
	</script>
</body>
</html>