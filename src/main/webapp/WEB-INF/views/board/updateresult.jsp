<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${result == 1 }">
		<script>
			alert("수정성공");
			location.href="boardcontent.do?no=${board.no}";
		</script>
	</c:if>

	<c:if test="${result != 1 }">
		<script>
			alert("수정실패");
			history.go(-1);		// 이전화면으로 빽 !
			</script>
	</c:if>
	
</body>
</html>