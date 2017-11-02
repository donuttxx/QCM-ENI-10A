<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>QCMv - Acces Stagiaires</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/img/question.png" />
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
				<form action="<%=request.getContextPath() %>/login/validerAcces" method="post">
				  	<div class="form-group">
				    	<label for="identifiant">Email :</label>
				    	<input type="email" class="form-control" id="identifiant" name="identifiant">
				  	</div>
				  	<div class="form-group">
				    	<label for="motdepasse">Mot de passe :</label>
				    	<input type="password" class="form-control" id="motdepasse" name="motdepasse">
				  	</div>
				  	<button type="submit" class="btn btn-default">se connecter</button>
				</form>
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