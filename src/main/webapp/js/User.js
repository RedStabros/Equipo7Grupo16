/**
 * 
 */

 $(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listausuarios",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<table border='0' class='table table-dark table-striped table-hover'>";
                salida = salida + "<tr><th>CEDULA</th><th>NOMBRE</th><th>EMAIL</th><th>USUARIO</th><th>CLAVE</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].cedula_usuario+"</td>";
                    salida = salida + "<td>"+data[i].nombre_usuario+"</td>";
                    salida = salida + "<td>"+data[i].email_usuario+"</td>";
                    salida = salida + "<td>"+data[i].usuario+"</td>";
                    salida = salida + "<td>"+data[i].clave+"</td>";
                    salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		

    $("#buscarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/buscarusuarioID",{cedula_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].cedula_usuario);
                $("#nombre").val(data[0].nombre_usuario);
                $("#email").val(data[0].email_usuario);
                $("#usuario").val(data[0].usuario);
                $("#clave").val(data[0].clave);                   
            }else{
                $("#mensaje").html("<b style='color:red;'>USUARIO NO ENCONTRADO !!!</b>");
            }                  
        });
    });


    $("#agregarU").click(function(){
        let elid = $("#id").val();
        let elnombre = $("#nombre").val();
        let elemail = $("#email").val();
        let elusuario = $("#usuario").val();
        let laclave = $("#clave").val();
        $.post("http://localhost:8080/crearusuario",{cedula_usuario: elid, nombre_usuario: elnombre, email_usuario: elemail, usuario: elusuario, clave: laclave},function(data, status){
            if(data==true){
                $("#mensaje").html(" El usuario fue creado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se puedo crear, ya existe!!!</b>");
            }
        });
    });
    
    
    $("#actualizarU").click(function(){
        let elid = $("#id").val();
        let elnombre = $("#nombre").val();
        let elemail = $("#email").val();
        let elusuario = $("#usuario").val();
        let laclave = $("#clave").val();
        $.post("http://localhost:8080/actualizarusuario",{cedula_usuario: elid, nombre_usuario: elnombre, email_usuario: elemail, usuario: elusuario, clave: laclave},function(data, status){
            if(data==true){
                $("#mensaje").html(" El usuario fue actualizado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo actualizar, NO existe!!!</b>");
            }
        });
    });


    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarusuario",{cedula_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html(" El usuario fue eliminado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe!!!</b>");
            }
        });
    });

}); 