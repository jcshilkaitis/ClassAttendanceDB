<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new class</title>
</head>
<body>
	<form action="createNewClassServlet" method="post">
		Class name: <input type="text" name="className"><br />
		 
		Class date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4"> 
			
		Instructor Name: <input type="text" name="instructorName"><br /> 
		
		Students:<br /> <select name="allStudentsToAdd" multiple size="12">
			<c:forEach items="${requestScope.allStudents}" var="currentstudent">
				<option value="${currentstudent.id}">${currentstudent.firstName} ${currentstudent.lastName}
					</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Class">
	</form>
	<a href="index.html">Add a student</a>
</body>
</html>