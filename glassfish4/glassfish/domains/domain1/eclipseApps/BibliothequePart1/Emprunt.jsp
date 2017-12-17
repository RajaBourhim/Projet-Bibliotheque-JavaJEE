<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String logged = (String)session.getAttribute("Logged");
	String titre = request.getParameter("titre");
	String auteur = request.getParameter("auteur");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprunt</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<h2> Emprunt d'un livre </h2>
<form action='Controleur' method='POST'>
  <div class="form-group row">
    <label for="inputAuteur" class="col-sm-2 col-form-label">Auteur</label>
    <div class="col-sm-10">
      <input class="form-control" type="text" value="<%=auteur%>" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Titre</label>
    <div class="col-sm-10">
        <input class="form-control" type="text" value="<%=titre%>" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputAdherent" class="col-sm-2 col-form-label">Identifinant de l'Adhérent</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAdherent" name="Identifiant">
    </div>
  </div>

  <div class="form-group row">
    <div class="col-sm-10">
    	<input type='hidden' name='FORM' value='validerEmprunt'/> 
		<input type='hidden' name='auteur' value="<%=auteur%>"/> 
		<input type='hidden' name='titre' value="<%=titre%>"/> 
      	<button type="submit" class="btn btn-primary" value="ValiderEmprunt" >Valider Emprunt</button>
    </div>
  </div>
</form>

</body>
</html>