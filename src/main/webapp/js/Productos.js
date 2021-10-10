/**
 * 
 */
 $(document).ready(function(){

	$("#listarP").click(function(){
        $.get("http://localhost:8080/listaproductos",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<table border='0'>";
                salida = salida + "<tr><th>COODIGO_PRODUCTO</th><th>NOMBRE</th><th>PROVEEDOR</th><th>PRECIO_COMPRA</th><th>IVA_COMPRA</th><th>PRECIO_VENTA</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].codigo_producto+"</td>";
	                salida = salida + "<td>"+data[i].nombre_producto+"</td>";
	                salida = salida + "<td>"+data[i].nit+"</td>";
	                salida = salida + "<td>"+data[i].precio_compra+"</td>";
	                salida = salida + "<td>"+data[i].iva_compra+"</td>";
					salida = salida + "<td>"+data[i].precio_venta+"</td>";
                    salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		

    $("#buscarP").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/buscarproductoID",{codigo_producto: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].codigo_producto);
                $("#nombre_p").val(data[0].nombre_producto);
                $("#nit_p").val(data[0].nit);
                $("#p_compra").val(data[0].precio_compra);
				$("#iva").val(data[0].iva_compra);
                $("#p_venta").val(data[0].precio_venta);                   
            }else{
                $("#mensaje").html("<b style='color:red;'>PRODUCTO NO ENCONTRADO !!!</b>");
            }                  
        });
    });


    $("#agregarP").click(function(){
        let elid = $("#id").val();
        let elnombre_p = $("#nombre_p").val();
        let elnit_p = $("#nit_p").val();
        let lap_compra = $("#p_compra").val();
		let eliva = $("#iva").val();
        let lap_venta = $("#p_venta").val();
        $.post("http://localhost:8080/crearproducto",{codigo_producto: elid, nombre_producto: elnombre_p, nit: elnit_p, precio_compra: lap_compra, iva_compra: eliva, precio_venta: lap_venta},function(data, status){
            if(data==true){
                $("#mensaje").html(" El producto fue creado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se puedo crear, ya existe!!!</b>");
            }
        });
    });
    
    
    $("#actualizarP").click(function(){
        let elid = $("#id").val();
        let elnombre = $("#nombre_p").val();
        let elnit = $("#nit_p").val();
        let lacompra = $("#p_compra").val();
		let eliva = $("#iva").val();
        let laventa = $("#p_venta").val();
        $.post("http://localhost:8080/actualizarproducto",{codigo_producto: elid, nombre_producto: elnombre, nit: elnit, precio_compra: lacompra, iva_compra: eliva, precio_venta: laventa},function(data, status){
            if(data==true){
                $("#mensaje").html(" El producto fue actualizado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo actualizar, NO existe!!!</b>");
            }
        });
    });


    $("#eliminarP").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarproducto",{codigo_producto: elid},function(data, status){
            if(data==true){
                $("#mensaje").html(" El producto fue eliminado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe!!!</b>");
            }
        });
    });

});    



