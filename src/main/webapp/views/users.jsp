<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table, th, td {
		  border: 1px solid;
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
