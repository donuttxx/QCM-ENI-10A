<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>QCM - Accueil Stagiaires</title>
  <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="icon" type="image/png" href="<%=request.getContextPath() %>/img/question.png" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/theme/css/style.css">
<script src="<%=request.getContextPath() %>/theme/bootstrap/js/bootstrap.min.js"></script>
 <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet"> 
  </head>
  <body>
  
<div class="jumbotron text-center">
		<h1>QCM- Menu Stagiaires</h1>
 	</div>
	  
	<div class="container">
		<div class="row">
 		<div class="col-sm-9">
 			<h2>LISTE DES QCMS DISPONIBLES</h2>
 			<a href="<%=request.getContextPath() %>/Stagiaire/Qcm.jsp"> - QCM 1 - </a>
 			
 			<h2><a href="<%=request.getContextPath() %>/Stagiaire/Resultat.jsp">Acces resultats</a></h2>
 				
 			</div>
 		    <div class="col-sm-3">
 		    	<h3>Menu</h3>
 		   		<a href="<%=request.getContextPath() %>/">Accueil</a><br />
 		  	</div>
 		</div>
 	  	<div class="row">
 			<div class="footer col-sm-12">
 		  		<p>Copyright (c) 10A</p>
 			</div>
 		</div>
 	</div>
 
  </body>
  </html> 