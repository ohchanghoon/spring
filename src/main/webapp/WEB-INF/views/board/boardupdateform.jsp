<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>

	<form method=post action="boardupdate.do">
	<input type="hidden" name="no" value="${board.no }">
		<table border=1 align=center width=400>
			<caption>글수정</caption>
			<tr>
				<td>작성자명</td>
				<td><input type=text name="writer" value="${board.writer }"></td>		<!-- value값설정시 내가작성해놓은게 뜸 -->
			</tr>
			<tr>
				<td>제목</td>
				<td><input type=text name="subject" value="${board.subject }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="40" name="content">${board.content }</textarea></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
				<input type="submit" value="글수정	"> 
				<input type="submit" value="취소">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>