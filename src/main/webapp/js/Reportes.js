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

    $("#buscarVC").click(function(){
        let elid = $("#idC").val();
        $.post("http://localhost:8080/buscarventasC",{cedula_c: elid},function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<table border='0' class='table table-dark table-striped table-hover'>";
                salida = salida + "<tr><th>CLIENTE</th><th>CODIGO_VENTA</th><th>VALOR</th><th>IVA</th><th>TOTAL</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].cedula_c+"</td>";
                    salida = salida + "<td>"+data[i].codigo_venta+"</td>";
                    salida = salida + "<td>"+data[i].total_venta+"</td>";
                    salida = salida + "<td>"+data[i].ivaventa+"</td>";
                    salida = salida + "<td>"+data[i].valor_venta+"</td>";
                    salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);                   
            }else{
                $("#mensaje").html("<b style='color:red;'>CLIENTE SIN VENTAS!!!</b>");
            }                  
        });
    });

});    