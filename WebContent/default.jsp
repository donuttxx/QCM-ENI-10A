<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="icon" type="image/png" href="<%=request.getContextPath() %>/img/question.png"/>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/theme/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/theme/css/style.css">
  <script src="<%=request.getContextPath() %>/theme/bootstrap/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet"> 
   
  
  
<title>QCM Projet - 10A</title>
</head>

<body>

<%@ include file="Structure/EnTete.jspf" %>

<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<h3>Bienvenue sur notre page dédiée au QCM</h3>
				<p>Accédez à toutes les fonctionnalités qui vous sont autorisées en vous rendant sur votre rubrique d'accès (animateur ou candidat)</p>
			
		</div>
		    <div class="col-sm-3">
				<%@ include file="/Structure/menu.jspf" %>
		  	</div>
		</div>
		
		<div class="row">
			<div class="footer col-sm-12">
		  		<%@ include file="/Structure/PiedsPage.jspf" %>
			</div>
		</div>
</body>

</html>