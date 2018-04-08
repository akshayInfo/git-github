<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a New User 
</h1>

<c:url var="addAction" value="/add-user" ></c:url>

<form:form action="${addAction}" commandName="user">
<center>
<table >
	<c:if test="${!empty user.firstname}">
	<tr>		
		<td>			
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstname">
				<spring:message text="Firstname"/>
			</form:label>
		</td>
        <td>
			<form:input path="firstname" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastname">
				<spring:message text="Lastname"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastname" />
		</td>
	</tr>
	<tr>
        <td>
			<form:label path="sex">
				<spring:message text="Sex"/>
			</form:label>
		</td>
                <td>
			<form:input path="sex" />
		</td>
	</tr>
	<tr>
        <td>
			<form:label path="emailid">
				<spring:message text="Emailid"/>
			</form:label>
		</td>
        <td>
			<form:input path="emailid" />
		</td>
	</tr>
	<tr>
       <td>
			<form:label path="phoneno">
				<spring:message text="Phoneno"/>
			</form:label>
		</td>
                <td>
			<form:input path="phoneno" />
		</td>
		</tr>
		<tr>
                <td>
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		</td>
                <td>
			<form:input path="address" />
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<c:if test="${!empty user.firstname}">
				<input type="submit"
					value="<spring:message text="Edit"/>" />
			</c:if>
			<c:if test="${empty user.firstname}">
				<input type="submit" value="<spring:message text="Add "/>" />
			</c:if>
		</td>
	</tr>
</table>	
</center>
</form:form>

<br>
<h3>Users List</h3>
<c:if test="${!empty listUsers}">
	<table class="tg">
	<tr>
		<th width="80">User ID</th>
		<th width="120">User Firstname</th>
		<th width="120">User Lastname</th>
                <th width="120">User Sex</th>
                <th width="120">User EmailId</th>
                <th width="120">User Phoneno</th>
                <th width="120">User Address</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="users">
		<tr>
			<td>${users.id}</td>
			<td>${users.firstname}</td>
			<td>${users.lastname}</td>
                        <td>${users.sex}</td>
                        <td>${users.emailid}</td>
                        <td>${users.phoneno}</td>
                        <td>${users.address}</td>
			<td><a href="<c:url value='/edit/${users.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${users.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
