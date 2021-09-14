<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;500;700&display=swap" rel="stylesheet">
<title>Tecno Gamer</title>
<link rel="stylesheet" href="css/estilo.css">
<link rel="icon" href="img/logoico.ico">
</head>
<body>
	<div class="container mt-4 col-lg-4">
            <div class="card col-sm-10"  id="contenedor">
                <div class="card-body">
                    <form class="form-sign" method="get" action="./LoginServlet">
                        <div class="form-group text-center">
                            <h2>ACCESO</h2>
                            <img src="img/LOGO_PNG.png" alt="370" width="370"/>
                            
                            <label>Bienvenidos al Sistema</label>                           
                        </div>
                        <div class="form-group">
                         	<br>
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" class="form-control">                            
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="txtpass" class="form-control">
                            <br>
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
                    </form>
                </div>
            </div>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>        
</body>
</html>