/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.empleado;

/**
 *
 * @author ANDRES
 */

public class sr_empleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    empleado empleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_empleado</title>");
            out.println("</head>");
            out.println("<body>");
           /* out.println("<h1>Servlet sr_empleado at " + request.getContextPath() + "</h1>");*/
           
            empleado =new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_sangre")),0,request.getParameter("txt_nombre"),request.getParameter("txt_apellido"),request.getParameter("txt_direccion"),request.getParameter("txt_numero"),request.getParameter("txt_fn"));
            
            if("agregar".equals(request.getParameter("btn_agreagar"))){
                   if (empleado.agregar()> 0){
            out.println("<h2>ingreso exitoso</h2>");
            out.println("<a href='index.jsp'>regresar</a>");
            }
            else{
            out.println("<h2>error.........</h2>");
           
            
            }
            
            }
            
            
            
              
            if("modificar".equals(request.getParameter("btn_modificar"))){
                   if (empleado.modificar()> 0){
            out.println("<h2>ingreso exitoso</h2>");
            out.println("<a href='index.jsp'>regresar</a>");
            }
            else{
            out.println("<h2>error.........</h2>");
           
            
            }
            
            }
            
            
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
                   if (empleado.eliminar()> 0){
            out.println("<h2>ingreso exitoso</h2>");
            out.println("<a href='index.jsp'>regresar</a>");
            }
            else{
            out.println("<h2>error.........</h2>");
           
            
            }
            
            }
         
           
            
          /*  out.println("<p>" + request.getParameter("txt_codigo") + "</p>");
            out.println("<p>" + request.getParameter("txt_nombre") + "</p>");
            out.println("<p>" + request.getParameter("txt_apellido") + "</p>");
            out.println("<p>" + request.getParameter("txt_direccion") + "</p>");
            out.println("<p>" + request.getParameter("txt_numero") + "</p>");
            out.println("<p>" + request.getParameter("txt_fn") + "</p>");
            out.println("<p>" + request.getParameter("drop_sangre") + "</p>");
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
