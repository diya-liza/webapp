<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"/></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Quiz Page</title>
</head>
<body>
<h1>Select the quiz from list</h1>
<table class="table" id="table1">
<thead class="thead-dark">
<tr>
<th>id</th>
<th>Quiz Name</th>
<th>Quiz Master</th>
<th></th>
</tr>
</thead>
<tbody>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizquestions?allowPublicKeyRetrieval=true&useSSL=false", "root", "Writerdillz123@");
statement=connection.createStatement();
String sql ="select * from quizcreator";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("quizName") %></td>
<td><%=resultSet.getString("quizMasterName") %></td>
<td>
<form action="quizQuestionsPage.jsp" method="post">
<input type="hidden" value=<%=resultSet.getString("quizName") %> name="dataField" />
<input type="submit" value="Start Quiz Now" class="btn btn-secondary " />


</form>
</td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
 </tbody>
</table>

</body>
</html>