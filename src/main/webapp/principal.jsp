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
<link rel="icon" href="img/logoico.ico">
<link rel="stylesheet" href="css/principal.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
    <header class="header" id="inicio">
        <div class="contenedor baner">
            <img src="img/hamburguesa.svg" alt="" class="hamburger">
            <nav class="menu-navegacion">
                <a href="html/usuarios.html" class="nav-menu-link" target="_self">Modulo de Usuarios</a>
                <a href="html/clientes.html" target="_self" class="nav-menu-link">Modulo de Clientes</a>
                <a href="html/proveedores.html" target="_self" class="nav-menu-link">Modulo de Proveedores</a>
                <a href="html/productos.html" target="_self" class="nav-menu-link">Modulo de Productos</a>
                <a href="html/ventas.html" target="_self" class="nav-menu-link">Modulo de Ventas</a>
                <a href="html/reportes.html" target="_self" class="nav-menu-link">Consultas y Reportes</a>                
            </nav>
            <div class="contenedro head">                
	            <h1 class="titulo">Bienvenido al Sistema</h1>
                <p class="slogan">TecnoGamer para todos</p>
            </div>
            <div class="logo">
                <img src="img/LOGO_PNG.png" alt="">
            </div>
            <div>
            	<div class="dropdown">
				  <a class="btn btn-danger dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
				   Usuario Activo
				  </a>				
				  <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuLink">
				    <li><a class="dropdown-item" href="#">
                        <img src="img/usuario.png" alt="100" width="100">
                    </a></li>
				    <li><a class="dropdown-item" href="#">Usuario</a></li>
				    <li><a class="dropdown-item" href="#">usuario@gmail.com</a></li>
                    <div class="dropdown-divider"></div>
                    <li><a class="dropdown-item" href="index.jsp">Salir</a></li>
				  </ul>
				</div>
				</div>
            </div>
        </div>
    </header>
    <main class="contenido">
         <section class="secciones">
             <h2 class="subtitulo">
                <br> Modulos del sistema
             </h2>
             <div class="galeria-modulos">
                <a href="html/usuarios.html"><img src="img/user1.png" alt="" class="img-galeria-modulos"></a>
                <a href="html/clientes.html"><img src="img/cliente1.png" alt="" class="img-galeria-modulos"></a>
                <a href="html/proveedores.html"><img src="img/proveedores.png" alt="" class="img-galeria-modulos"></a>
                <a href="html/productos.html"><img src="img/productos.png" alt="" class="img-galeria-modulos"></a>
                <a href="html/ventas.html"><img src="img/user2.png" alt="" class="img-galeria-modulos"></a>
                <a href="html/reportes.html"><img src="img/reportes1.png" alt="" class="img-galeria-modulos"></a>
            </div>
         </section>
    </main>
    <footer>
        <div class="line"></div>
        <section class="legal">
            <div class="contenedor-legal">
                <nav class="menu-legal">
                    <a href="**/" class="nav-legal" target="_self">Terminos y condiciones</a>
                    <a href="**/" target="_self" class="nav-legal">Politicas de privacidad</a>
                    <a href="**/" target="_self" class="nav-legal">Politicas de cookies</a>
                    <br>
                    <p>Copyright - 2021 TecnoGamer.com</p>
                </nav>
            </div>
        </section>
    </footer>
    <script src="js/menu.js"></script>

</body>
</html>