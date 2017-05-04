<jsp:include page="session_hr.jsp"/>
<!DOCTYPE html>
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
    <link rel="stylesheet" href="css/style.css">
 
  </head>

  <body>
    <jsp:include page="nav_hr.jsp"/>

    <div class="main">
      <h2>New Event</h2>
		<form method="post" action="UpdateEventServlet">
			<div class="clear"></div>
			<div class="lable-2">
				<input type="text" class="hidden" name="id" value="${e.event_id}"> 
		   		<input type="text" class="text" name="name" placeholder="Event Name" value="${e.name}">
		   		<input type="text" class="text" name="type" placeholder="Event Type" value="${e.type}">
		   		<input type="text" class="text" name="description" placeholder="Event Description" value="${e.description}">
		   		<input type="date" class="text" name="startDate" placeholder="Start Date" value="${e.start_date}">
		   		<input type="date" class="text" name="endDate" placeholder="End Date" value="${e.end_date}">
		   		<input type="text" class="text" name="duration" placeholder="Duration" value="${e.duration}">
		   		<input type="text" class="text" name="presenter" placeholder="Presenter" value="${e.presenter}">
		   		<div class="clear"></div>
		   </div>
		   
		   <div class="submit">
			  <input type="submit" class="btn" value="UPDATE" >
		   </div>
		   <div class="clear"> </div>
		</form>
	</div>

      


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    
    
  </body>
</html>
