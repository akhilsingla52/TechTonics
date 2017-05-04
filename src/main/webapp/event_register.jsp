<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
   

    <title>ATMECS Tech Tonics</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/component.css">
    <link rel="stylesheet" href="css/custom-styles.css">
    <link rel="stylesheet" href="css/font-awesome.css">
	
     
	 <link rel="stylesheet" href="css/demo.css">
    <link rel="stylesheet" href="css/font-awesome-ie7.css">

      <script src="js/jquery.mobilemenu.js"></script>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script>
    $(document).ready(function(){
        $('.menu').mobileMenu();
    });
  </script>
 
  </head>

  <body>
  				<jsp:include page="nav_hr.jsp"/>
  				<br/>
  				<h2 class="success" style="text-align:center;width:100%">${info}</h2>
  				<br/>
  				
  				<div class="container">
	  				<button class="btn btn-primary pull-right" type="button" onclick="window.location.href='EventServlet'">Back</button>
	  				<br/><br/>
	  				<table class="table table-striped">
					    <thead>
					      <tr>
					        <th class="success">Employee ID</th>
					        <th class="success">Employee Name</th>
					        <th class="success">Email ID</th>
					      </tr>
					    </thead>
					    <tbody>
					    <c:forEach items="${list}" var="u">	
					      <tr>
					        <td>${u.emp_id}</td>
					        <td>${u.name}</td>
					        <td>${u.email_id}</td>
					     </tr>
					    </c:forEach>
					   </tbody>
	  				</table>
  				</div>
      			
    
  </body>
</html>
