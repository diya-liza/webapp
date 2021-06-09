<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Create your Quiz</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/register" method="post">



  <div class="form-group">
    <label for="Nameofquiz">Name of quiz:</label>
   <input type="text" name="quizName"><br/>
  </div>
  
     <div class="form-group">
    
    <label for="Nameofquizmaster">Name of quiz master:</label>
   <input type="text" name="quizMasterName"><br/>
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-primary">Create</button>
  </div>
  
  
  
</form>

</body>
</html>