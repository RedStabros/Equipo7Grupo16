/**
 * 
 */
$(document).ready(function(){
	
	$("#listarU").click(function(){
		$.get("http://localhost:8080/listaproveedores",function(data, status){
			if(status=="success"){
				let longitud = data.length;
				let salida ="<table border='0'>";
				salida = salida + "<tr><th>NIT</th><th>CIUDAD</th><th>DIRECCION</th><th>NOMBRE</th><th>TELEFONO</th></tr>";
				for(let i=0;i<longitud;i++){
					salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].nit+"</td>";
                    salida = salida + "<td>"+data[i].ciudad+"</td>";
                    salida = salida + "<td>"+data[i].direccion+"</td>";
                    salida = salida + "<td>"+data[i].nombre+"</td>";
                    salida = salida + "<td>"+data[i].telefono+"</td>";
                    salida = salida + "</tr>";
                }
				salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		

	$("#buscarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/buscarproveedorID",{nit: elid},function(data, status){
			let longitud = data.length;
			if(longitud>0){
				$("#id").val(data[0].nit);
				$("#ciudad").val(data[0].ciudad);
				$("#direccion").val(data[0].direccion);
				$("#nombre").val(data[0].nombre);
				$("#telefono").val(data[0].telefono);
			}else{
				$("#mensaje").html("<b style='color:green;'>PROVEEDOR NO ENCONTRADO !!!</b>");
            }                  
        });
    });


	$("#agregarU").click(function(){
        let elid = $("#id").val();
		let laciudad = $("#ciudad").val();
		let ladireccion = $("#direccion").val();
		let elnombre = $("#nombre").val();
		let eltelefono = $("#telefono").val();
        $.post("http://localhost:8080/crearproveedor",{nit: elid, ciudad: laciudad, direccion: ladireccion, nombre: elnombre, telefono: eltelefono},function(data, status){
            if(data==true){
                $("#mensaje").html("<b style='color:green;'>EL PROVEEDOR FUE CREADO!!!</b>");
            }else{
                $("#mensaje").html("<b style='color:green;'>NO SE PUDO CREAR, YA EXISTE!!!</b>");
            }
        });
    });
    
    
	$("#actualizarU").click(function(){
		let elid = $("#id").val();
		let laciudad = $("#ciudad").val();
		let ladireccion = $("#direccion").val();
		let elnombre = $("#nombre").val();
		let eltelefono = $("#telefono").val();
		$.post("http://localhost:8080/actualizarproveedor",{nit: elid, ciudad: laciudad, direccion: ladireccion, nombre: elnombre, telefono: eltelefono},function(data, status){
			if(data==true){
				$("#mensaje").html("<b style='color:green;'>EL PROVEEDOR FUE ACTUALIZADO!!!</b>");
			}else{
				$("#mensaje").html("<b style='color:green;'>NO SE PUDO ACTUALIZAR, YA EXISTE!!!</b>");
			}
        });
    });


	$("#eliminarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/borrarproveedor",{nit: elid},function(data, status){
			if(data==true){
				$("#mensaje").html("<b style='color:green;'>EL PROVEEDOR FUE ELIMINADO!!!</b>");
			}else{
				$("#mensaje").html("<b style='color:green;'>NO SE PUDO ELIMINAR, YA EXISTE!!!</b>");
			}
        });
    });

});