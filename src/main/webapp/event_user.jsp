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
  				<jsp:include page="nav_user.jsp"/>
  		
  				
  				<h2 class="success" style="text-align:center;width:100%">${info}</h2>
  		
  				<c:forEach items="${list}" var="e">	
  								<br/>
  								<div class="panel panel-success">
									  <div class="panel-heading"><h1>${e.name}</h1></div>
									  <div class="panel-body">
									    <h5>Description:${e.description}</h5><br/>
									    <h5>Start Date:${e.start_date}</h5><br/>
									    <h5>End Date:${e.end_date}</h5><br/>
									    <h5>Duration:${e.duration}</h5><br/>
									    <h5>Presenter:${e.presenter}</h5><br/>
									    <p><a class="btn btn-primary" href="EventApplyServlet?id=${e.event_id}" role="button">Apply</a></p>
									  </div>
									</div>
      			</c:forEach>
  	
    
    
  </body>
</html>
