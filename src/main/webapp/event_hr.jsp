<jsp:include page="session_hr.jsp"/>

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
  				
  				<div style="padding:0px 100px;">
	  				<button class="btn btn-primary pull-right" type="button" onclick="window.location.href='addEvent.jsp'">Add Event</button>
	  				<br/><br/>
	  				<table class="table table-striped">
					    <thead>
					      <tr>
					        <th class="success">Event Name</th>
					        <th class="success">Type</th>
					        <th class="success">Description</th>
					        <th class="success">Start Date</th>
					        <th class="success">End Date</th>
					        <th class="success">Duration</th>
					        <th class="success">Presenter</th>
					        <th class="success"></th>
					      </tr>
					    </thead>
					    <tbody>
					    <c:forEach items="${list}" var="e">	
					      <tr>
					        <td>${e.name}</td>
					        <td>${e.type}</td>
					        <td>${e.description}</td>
					        <td>${e.start_date}</td>
					        <td>${e.end_date}</td>
					        <td>${e.duration}</td>
					        <td>${e.presenter}</td>
					        <td>
					        	<a href="ListEventServlet?id=${e.event_id}"><img src="img/list.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        	<a href="EditEventServlet?id=${e.event_id}"><img src="img/edit.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        	<a href="DeleteEventServlet?id=${e.event_id}"><img src="img/delete.png"></a>
					        </td>
					     </tr>
					    </c:forEach>
					   </tbody>
	  				</table>
  				</div>
      			
    
  </body>
</html>
