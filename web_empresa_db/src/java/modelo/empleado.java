/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import modelo.conexion;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ANDRES
 */
public class empleado extends persona{
    private String codigo;
    private int id_puesto;
    private conexion cn;

    public empleado() { }

    public empleado(String codigo, int id_puesto, int id, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(id, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo = codigo;
        this.id_puesto = id_puesto;
    }
    
   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
    
    
    public DefaultTableModel leer (){
    DefaultTableModel tabla = new DefaultTableModel ();
    try{
    cn =new conexion();
    cn.abrir_coxion();
    String query;
    query ="SELECT e.id_empleado, e.codigo, e.nombres, e.apellidos, e.direccion, e.telefono, e.fecha_nacimiento, p.puesto\n" +
"FROM db_empresa1.empleados e\n" +
"INNER JOIN puestos p ON e.id_puesto = p.id_puesto;";
    ResultSet consulta =cn.conexionBD.createStatement().executeQuery(query);
   
    String encabezadoo[] ={"id","codigo","nombres","apellidos","direccion","telefono","nacimiento","puesto"};
    tabla.setColumnIdentifiers(encabezadoo);
    
    String datos []= new String [8];
    
    while (consulta.next()){
    datos [0]=consulta.getString("e.id_empleado");
    datos [1]=consulta.getString("e.codigo");
    datos [2]=consulta.getString("e.nombres");
    datos [3]=consulta.getString("e.apellidos");
    datos [4]=consulta.getString("e.direccion");
    datos [5]=consulta.getString("e.telefono");
    datos [6]=consulta.getString("e.fecha_nacimiento");
    datos [7]=consulta.getString("p.puesto");
    tabla.addRow(datos);
    
    }
    cn.cerrar_conexion();
    
    }
    
    catch(SQLException ex){
    System.out.println("error :"+ex.getMessage());
    }
    return tabla;
    
    }
    
    @Override
    public int agregar (){
   
        int retorno =0;
        try{
        PreparedStatement parametro;
    cn =new conexion();
    
    String query= "INSERT INTO db_empresa1.empleados(codigo,nombres,apellidos,direccion,telefono,fecha_nacimiento,id_puesto) VALUES (?,?,?,?,?,?,?);";
    cn.abrir_coxion();
    parametro =(PreparedStatement)cn.conexionBD.prepareStatement(query);
    
    parametro.setString(1, this.getCodigo());
    parametro.setString(2, this.getNombres());
    parametro.setString(3, this.getApellidos());
    parametro.setString(4, this.getDireccion());
    parametro.setString(5, this.getTelefono());
    parametro.setString(6, this.getFecha_nacimiento());
    parametro.setInt(7, this.getId_puesto());
    
    retorno =parametro.executeUpdate();
    cn.cerrar_conexion();
    }catch (SQLException ex){
    System.out.println(ex.getMessage());
    retorno=0;}
    
    
    
    return retorno;
    }
    
    
    
    @Override
     public int modificar (){
   
        int retorno =0;
        try{
        PreparedStatement parametro;
    cn =new conexion();
    
    String query= "UPDATE db_empresa1.empleados SET id_empleado= ?,codigo = ?,nombres=?,apellidos=?,direccion =?,telefono=?,fecha_nacimiento = ?,id_puesto =?\n" +
"WHERE id_empleado = ?;";
    cn.abrir_coxion();
    parametro =(PreparedStatement)cn.conexionBD.prepareStatement(query);
    
    parametro.setString(1, this.getCodigo());
    parametro.setString(2, this.getNombres());
    parametro.setString(3, this.getApellidos());
    parametro.setString(4, this.getDireccion());
    parametro.setString(5, this.getTelefono());
    parametro.setString(6, this.getFecha_nacimiento());
    parametro.setInt(7, this.getId_puesto());
    parametro.setInt(8,this.getId());
    
    retorno =parametro.executeUpdate();
    cn.cerrar_conexion();
    }catch (SQLException ex){
    System.out.println(ex.getMessage());
    retorno=0;}
    
    
    
    return retorno;
    }
    
     
     
     
      @Override
     public int eliminar (){
   
        int retorno =0;
        try{
        PreparedStatement parametro;
    cn =new conexion();
    
    String query= "delete from empleados were id_empleado =?;";
    cn.abrir_coxion();
    parametro =(PreparedStatement)cn.conexionBD.prepareStatement(query);
    
    
    parametro.setInt(1,this.getId());
    
    retorno =parametro.executeUpdate();
    cn.cerrar_conexion();
    }catch (SQLException ex){
    System.out.println(ex.getMessage());
    retorno=0;}
    
    
    
    return retorno;
    }
    
}
