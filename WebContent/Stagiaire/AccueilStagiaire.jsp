<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		<h1>QCM- Acces Stagiaires</h1>
	</div>
	  
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
			<h3>Liste des tests disponible</h3>
				<a href="<%=request.getContextPath() %>/Stagiaire/Qcm.jsp">Test du jour</a>
				<p>test</p>
			<h3>Selectionner les résultats</h3>
				<a href="<%=request.getContextPath() %>/Stagiaire/Resultat.jsp">Vos résultats</a>
				<p>test</p>
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