<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="navServlet">
		<table>
			<c:forEach items="${requestScope.allStudents}" var="currentstudent">
				<tr>
					<td><input type="radio" name="id" value="${currentstudent.id}"></td>
					<td>${currentstudent.firstName}</td>
					<td>${currentstudent.lastName}</td>
					<td>${currentstudent.age}</td>
					<td>${currentstudent.belt}</td>
				</tr>
			</c:forEach>
			
		</table>
		<input type="submit" value="edit" name="doThisToStudent"> <input
			type="submit" value="delete" name="doThisToStudent"> <input
			type="submit" value="add" name="doThisToStudent">
	</form>
</body>
</html>