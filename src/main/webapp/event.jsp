<%@page import="java.util.ArrayList"%>
<%@page import="com.atmecs.pojo.Event"%>
<%@page import="java.util.List"%>
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
 
  </head>

  <body>
  				<div class="menu">
				      <div class="navbar">
				        <div class="container">
				          <div class="navbar-header">
				            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				              <i class="fw-icon-th-list"></i>
				            </button>
				          </div>
				          <div class="navbar-collapse collapse">
						<img style="float:left;margin-right:10px" src="img/logo.jpg" alt="" height="50" width="150">
				            <ul class="nav navbar-nav">
								<jsp:include page="nav.jsp"/>
				              <li><a href="signin.jsp">Sign In</a></li>
				              <li><a href="signup.jsp">Sign Up</a></li>
				            </ul>
				          </div><!--/.navbar-collapse -->
				        </div>
				      </div>
				      </div>
  		
  		
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
									  </div>
									</div>
      			</c:forEach>
  				
  	
    
    
  </body>
</html>
