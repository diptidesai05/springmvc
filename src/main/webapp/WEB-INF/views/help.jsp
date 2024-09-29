<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>This is About page</h1>
 <h1>Called by HomeController</h1>
 <h1>URL /help</h1>
 <%
// String name=(String)request.getAttribute("name");
// Integer rollNumber=(Integer)request.getAttribute("rollnumber");
 %>
<!--  <h1>Name is <%--<%=name%> --%> </h1> -->
 <h1>Name is ${name} </h1>
 <h1>Roll Number is ${rollnumber} </h1>
 <h1>Time is ${time} </h1>
 <h1>Marks is ${marks} </h1>
 <c:forEach var="i" items="${marks}">
  <h1>${i}</h1>
 </c:forEach>
</body>
</html>