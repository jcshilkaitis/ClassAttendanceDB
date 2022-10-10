<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance</title>
</head>
<body>
	<form method="post" action="attendancenavigationServlet">
		<table>
			<c:forEach items="${requestScope.allAttendance}" var="currentattendance">
				<tr>
					<td><input type="radio" name="id" value="${currentattendance.id}"></td>
					<td><h2>${currentattendance.className}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Class Date: ${currentattendance.ClassDate}</td>
				</tr>
				<tr>
					<td colspan="3">Class Time: ${currentattendance.ClassTime}</td>
				</tr>
				<tr>
					<td colspan="3">Instructor: ${currentattendance.instructor.name}</td>
				</tr>
				<c:forEach var="listVal" items="${currentattendance.listOfStudents}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.FirstName}, ${listVal.LastName}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	<a href="addItemsForListServlet">Create a new List</a>
	<a href="index2.html">Insert a new item</a>
</body>
</html>