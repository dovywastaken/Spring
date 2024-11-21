<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESTful</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
	<h3>RESTful 웹서비스</h3>
	<button onclick="test()" type="button">실행하기</button>
</body>

<script>
	var obj = {"name" : "kim", "age" : 30};
	
	function test()
	{
		$.ajax
		({
			url : "/test",
			type : "POST",
			data : JSON.stringify(obj),
			dataType : "json",
			contentType : "application/json",
			success : function(data)
			{
				alert("성공");
			},
			error : function(errorThrown)
			{
				alert("실패");
			}
		});
	}
</script>
</html>