<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
              <li><a href="LogoutServlet">Logout</a></li>
            </ul>
          </div><!--/.navbar-collapse -->
        </div>
      </div>
      </div>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="banner">
      <div id="carousel-example-generic" class="carousel slide">
  
  <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <img src="img/img1.jpg" alt="">
           <!--  <div class="carousel-caption">
              <h1>Morbi semuis</h1>
              <h2>Praesent dapibus, neque id cursus faucibus tortas augue eu vulputate</h2>
              <a href="#" class="btn">facilis</a>
            </div> -->
          </div>
          <div class="item">
            <img src="img/img2.jpg" alt="">
          </div>
          <div class="item">
            <img src="img/img3.jpg" alt="">
          </div>
        </div>


      <div class="container">
        <div class="featured-content">
          <div class="col-md-12">
            <div class="block">
              <h1>Quisque a lectus. Donec consectetuer ligua </h1>
              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
            </div>            
          </div>
      </div> 
      
      </div>
      <div class="copy-rights">
      <div class="container">
        <div class="row">
          
            <div class="col-md-12">
              <div style="text-align:center;width:100%;text-weight:bold;font-size:20px;">Copyright(c) Atmecs Technologies.</div>
            </div>
            
          </div>
        </div>
      </div>
      </div>
      </div>

      


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    
    
  </body>
</html>
