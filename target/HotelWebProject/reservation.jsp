<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
	<div align="center">
		<form:form action="reservation" method="post" commandName="reservation">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo - Reservation</h2></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="customerName" /></td>
				</tr>
				<tr>
					<td>Surname:</td>
					<td><form:password path="customerSurname" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="customerEmail" /></td>
				</tr>
				<tr>
					<td>Start Date: (mm/dd/yyyy):</td>
					<td><form:input path="startDate" /></td>
				</tr>
				<tr>
					<td>End Date: (mm/dd/yyyy):</td>
					<td><form:input path="endDate" /></td>
				</tr>
				<tr>
					<td>No return::</td>
					<form:checkbox path="receiveNewsletter" />
				</tr>
				<tr>
					<td>Half-board:</td>
					<form:checkbox path="receiveNewsletter" />
				</tr>
				<tr>
					<td>Use of sports facilities:</td>
					<form:checkbox path="receiveNewsletter" />
				</tr>
				<tr>
					<td>Use of pool facility:</td>
					<form:checkbox path="receiveNewsletter" />
				</tr>
				<tr>
					<td>All Inclusive:</td>
					<form:checkbox path="allInclusive" />
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Complete" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>