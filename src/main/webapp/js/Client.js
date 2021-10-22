/**
 * 
 */
$(document).ready(function(){

	$("#listarC").click(function(){
        $.get("http://localhost:8080/listaclientes",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<table border='0' class='table table-dark table-striped table-hover'>";
                salida = salida + "<tr><th>CEDULA</th><th>DIRECCION</th><th>EMAIL</th><th>NOMBRE</th><th>TELEFONO</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].cedula_c+"</td>";
                    salida = salida + "<td>"+data[i].direccion_c+"</td>";
                    salida = salida + "<td>"+data[i].email_c+"</td>";
                    salida = salida + "<td>"+data[i].nombre_c+"</td>";
                    salida = salida + "<td>"+data[i].telefono_c+"</td>";
                    salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		
    $("#buscarC").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/buscarclienteID",{cedula_c: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].cedula_c);
                $("#direccion").val(data[0].direccion_c);
                $("#email").val(data[0].email_c);
                $("#nombre").val(data[0].nombre_c);
                $("#telefono").val(data[0].telefono_c);                   
            }else{
                $("#mensaje").html("<b style='color:red;'>CLIENTE NO ENCONTRADO !!!</b>");
            }                  
        });
    });

    $("#agregarC").click(function(){
        let elid = $("#id").val();
        let ladireccion = $("#direccion").val();
        let elemail = $("#email").val();
        let elnombre = $("#nombre").val();
        let eltelefono = $("#telefono").val();
        $.post("http://localhost:8080/crearcliente",{cedula_c: elid, direccion_c: ladireccion, email_c: elemail, nombre_c: elnombre, telefono_c: eltelefono},function(data, status){
            if(data==true){
                $("#mensaje").html(" El cliente fue creado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se puedo crear, ya existe!!!</b>");
            }
        });
    });
        
    $("#actualizarC").click(function(){
        let elid = $("#id").val();
        let ladireccion = $("#direccion").val();
        let elemail = $("#email").val();
        let elnombre = $("#nombre").val();
        let eltelefono = $("#telefono").val();
        $.post("http://localhost:8080/actualizarcliente",{cedula_c: elid, direccion_c: ladireccion, email_c: elemail, nombre_c: elnombre, telefono_c: eltelefono},function(data, status){
            if(data==true){
                $("#mensaje").html(" El cliente fue actualizado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo actualizar, NO existe!!!</b>");
            }
        });
    });

    $("#eliminarC").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarcliente",{cedula_c: elid},function(data, status){
            if(data==true){
                $("#mensaje").html(" El cliente fue eliminado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe!!!</b>");
            }
        });
    });
}); 