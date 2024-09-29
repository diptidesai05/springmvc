<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>This is Home page</h1>
 <h1>Called by HomeController</h1>
 <h1>URL /home</h1>
 <%
 String name=(String)request.getAttribute("name");
 List<String> friends=(List<String>)request.getAttribute("listObj");
 %>
 <h1>Name is <%=name%> </h1>
 <h1>
 <%
  for(String f:friends)
  {
 %>	  
 <h1><%=f%></h1>
	 
 <%  } %>

 </h1>
</body>
</html>