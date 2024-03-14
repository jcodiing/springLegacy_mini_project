<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.za.dto.BoardDto"%>
<%
	BoardDto vo = (BoardDto) request.getAttribute("dto");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정하기</title>
</head>
<body>
	<h1>게시글 수정하기</h1>
	<form action="${pageContext.request.contextPath}/board/modify/action" method="post">
		<input type="hidden" name="bno" value="${dto.bno}"/>
		제목 : <input type="text" name="title" value="${dto.title}"/> <br/>
		내용 : <textarea name="content">${dto.content}</textarea> <br/>
		<input type="submit" value="수정완료"/>
	</form>
</body>
</html>