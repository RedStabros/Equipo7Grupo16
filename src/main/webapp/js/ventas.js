$(document).ready(function(){

    $("#buscarP").click(function(){
        let elid1 = $("#id").val();
        $.post("http://localhost:8080/buscarproductoID",{codigo_producto: elid1},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].codigo_producto);
                $("#nombre_p").val(data[0].nombre_producto);
                //$("#nit_p").val(data[0].nit);
                //$("#p_compra").val(data[0].precio_compra);
				$("#iva").val(data[0].iva_compra);
                $("#p_venta").val(data[0].precio_venta);                  
            }else{
                $("#mensaje").html("<b style='color:red;'>PRODUCTO NO ENCONTRADO !!!</b>");
            } 
            subtotal1();                 
        });
    });


    $("#buscarC").click(function(){
        let elidC = $("#idC").val();
        $.post("http://localhost:8080/buscarclienteID",{cedula_c: elidC},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#idC").val(data[0].cedula_c);
               // $("#direccion").val(data[0].direccion_c);
               // $("#email").val(data[0].email_c);
                $("#nombre").val(data[0].nombre_c);
                //$("#telefono").val(data[0].telefono_c);                   
            }else{
                $("#mensaje").html("<b style='color:red;'>CLIENTE NO ENCONTRADO !!!</b>");
            }                  
        });
    });

    $("#buscarU").click(function(){
        let elidU = $("#idU").val();
        $.post("http://localhost:8080/buscarusuarioID",{cedula_usuario: elidU},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#idU").val(data[0].cedula_usuario);
                $("#nombreU").val(data[0].nombre_usuario);
                //$("#email").val(data[0].email_usuario);
                //$("#usuario").val(data[0].usuario);
                //$("#clave").val(data[0].clave);                   
            }else{
                $("#mensaje").html("<b style='color:red;'>USUARIO NO ENCONTRADO !!!</b>");
            }                  
        });
    });

    $("#buscarP2").click(function(){
        let elid2 = $("#id2").val();
        $.post("http://localhost:8080/buscarproductoID",{codigo_producto: elid2},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id2").val(data[0].codigo_producto);
                $("#nombre_p2").val(data[0].nombre_producto);
                //$("#nit_p").val(data[0].nit);
                //$("#p_compra").val(data[0].precio_compra);
				//$("#iva2").val(data[0].iva_compra);
                $("#p_venta2").val(data[0].precio_venta);                  
            }else{
                $("#mensaje").html("<b style='color:red;'>PRODUCTO NO ENCONTRADO !!!</b>");
            }  
            subtotal2();                
        });
    });

    $("#buscarP3").click(function(){
        let elid3 = $("#id3").val();
        $.post("http://localhost:8080/buscarproductoID",{codigo_producto: elid3},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id3").val(data[0].codigo_producto);
                $("#nombre_p3").val(data[0].nombre_producto);
                //$("#nit_p").val(data[0].nit);
                //$("#p_compra").val(data[0].precio_compra);
				//$("#iva3").val(data[0].iva_compra);
                $("#p_venta3").val(data[0].precio_venta);                  
            }else{
                $("#mensaje").html("<b style='color:red;'>PRODUCTO NO ENCONTRADO !!!</b>");
            } 
            subtotal3();                 
        });
    });

    
});    
