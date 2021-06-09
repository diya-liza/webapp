<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Registered</title>
<script src="main.js" type="text/javascript"></script>
<link rel="stylesheet" href="main.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div align="center" class="section-1-container section-container">
    <div align="center" class="container">
        <div class="row">
            <div class="col section-1 section-description">
                <h1>Your ${quizname} Quiz is Registered</h1>
               
            </div>
        </div>
        <div class="row">
            <div class="col-10 offset-1 col-lg-8 offset-lg-2  d-flex justify-content-center align-items-center">
 
                <div>
                    <p><button class="btn btn-primary" onclick="Openform()">Add questions</button></p>
                    <a href="index.jsp" class="btn btn-primary">Finish!</a>
                </div>
 
            </div>
        </div>
    </div>
</div>
<form id="addForm" class="classForm div-wrapper div-to-align" style="display:none" action="<%= request.getContextPath() %>/addQuizQuestions" method="post"> 

 <div class="form-group">
       <label for="QuizName">Quiz Name:</label>
       <input type="text" name="quizname" value=${quizname} ><br/>
     </div>
 <div class="form-group">
    <label for="question">Question:</label>
   <textarea name="question" rows="2" cols="40"></textarea>
  </div>
  
     <div class="form-group">
       <label for="OptA">A:</label>
       <input type="text" name="OptA"><br/>
     </div>
     
      <div class="form-group">
       <label for="OptB">B:</label>
       <input type="text" name="OptB"><br/>
     </div>
     
      <div class="form-group">
       <label for="OptC">C:</label>
       <input type="text" name="OptC"><br/>
     </div>
     
      <div class="form-group">
       <label for="OptD">D:</label>
       <input type="text" name="OptD"><br/>
     </div>
    
    <div class="form-group">
    <label for="Answer">Answer: </label>
  <select id="answer" name="answer">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
    <option value="D">D</option>
  </select>
    </div>
    
   
   
    <div class="form-group">
    
  
   
   <button type="submit" class="btn btn-primary">Create</button>
  
  
      </div>
  </form>
</body>
</html>