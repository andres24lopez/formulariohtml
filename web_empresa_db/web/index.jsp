<%-- 
    Document   : index
    Created on : 5/10/2024, 4:02:58 p. m.
    Author     : ANDRES
--%>
<%@page  import ="modelo.puestos"%>
<%@page  import ="modelo.empleado"%>
<%@page  import ="javax.swing.table.DefaultTableModel"%>
<%@page  import ="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>empleados</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  
    </head>
    <body>
       
        <h1>Hello World</h1>
        
        <div class="container">
            
            <form action="sr_empleado" method="post"class="form-group">
                
                
                 <label for="lbl_id"> id</label>
                 <input type="text" class="form-control"  name="txt_id" id="txt_id" value="0" readonly >
                  <label for="lbl_codigo"> codigo:</label>
                  <input type="text" class="form-control"  name="txt_codigo" id="txt_codigo" placeholder="codigo" required="" >
                  <label for="lbl_nombre"> nombre:</label>
                  <input type="text" class="form-control"  name="txt_nombre" id="txt_nombre" placeholder="nombre" required="" >
                  <label for="lbl_apellido"> apellido:</label>
                  <input type="text" class="form-control"  name="txt_apellido" id="txt_apellido" placeholder="nombre" required="" >
                  <label for="lbl_direccion"> direccion:</label>
                  <input type="text" class="form-control"  name="txt_direccion" id="txt_direccion" placeholder="nombre" required="" >
                  <label for="lbl_numero"> numero:</label>
                  <input type="number" class="form-control"  name="txt_numero" id="txt_numero" placeholder="nombre" required="" >
                  
                  <label for="lbl_fn"> fecha nacimineto:</label>
                  <input type="date" class="form-control"  name="txt_fn" id="txt_fn"  required="" >
                  <label for="lbl_sangre"> tipo de sangre:</label>
                  <select name="drop_sangre" id="drop_sangre" class="form-control">
                       <%
                      puestos puestos  = new puestos();
                      HashMap<String,String> drop = puestos.drop_sangre();
                      for (String i: drop.keySet()){
                            out.println("<option value='"+ i +"' >" + drop.get(i) + "</option>");
                          }
                      
                      %> 
                    
                  </select>
                      <button  name="btn_agreagar" id="btn_agregar" class="btn btn-primary" value="agregar">egregar</button>
                      <button name="btn_modificar" id="btn_modificar" class="btn btn-warning" value="modificar">modificar</button>
                      <button name="btn_eliminar" id="btn_eliminar" class="btn btn-danger value="modificar">eliminar</button>
            
            
            </form> 
                      <table class="table table-dark table-striped">
                          <thead>
                         
                              <tr>
                                  <th>codigo</th>
                                  <th>nombres</th>
                                  <th>apellidos</th>
                                  <th>direccion</th>
                                  <th>telefono</th>
                                  <th>nacimineto </th>
                                  <th>puestos</th>
                              </tr>
                          
                          </thead>
                          
                          <tbody id="tbl_empleados">
                              <%
                              empleado empleado =new empleado();
                              DefaultTableModel tabla = new DefaultTableModel ();
                              tabla = empleado.leer();
                              for (int t=0;t<tabla.getRowCount();t++){
                                  out.println("<tr data-id="+tabla.getValueAt(t, 0) +">");
                                  out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
                                  out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
                                  out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
                                  out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
                                  out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
                                  out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
                                  out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");
                                  
                                  out.println("/<tr>");
                                  }


                              %>
                                  
                          </tbody>
                          
                      </table>
            
            
            
            
        </div>
       <script src="https://code.jquery.com/jquery-3.7.1.slim.min.js" integrity="sha256-kmHvs0B+OpCW5GVHUNjv9rOmY0IvSIRcf7zGUDTDQM8=" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  
      <script type="text/javascript">
             $('#tbl_empleados').on('click','tr td',function (evt){
                 
               var target,id,codigo,nombres,apellidos,direccion,telefono,nacimiento;
               target = $(event.target);
               id = target.parent().data('id');
               codigo = target.parent("tr").find("td").eq(0).html();
                nombres = target.parent("tr").find("td").eq(1).html();
                 apellidos = target.parent("tr").find("td").eq(2).html();
                  direccion = target.parent("tr").find("td").eq(3).html();
                   telefono = target.parent("tr").find("td").eq(4).html();
                   nacimiento = target.parent("tr").find("td").eq(5).html();
                   
               $(#txt_id).val(id);   
               $(#txt_codigo).val(codigo); 
               $(#txt_nombre).val(nombres); 
               $(#txt_apellido).val(apellidos); 
               $(#txt_direccion).val(direccion); 
               $(#txt_numero).val(telefono); 
               $(#txt_fn).val(nacimiento); 
                
             
            });
     
              
      </script>
    </body>
  
</html>
