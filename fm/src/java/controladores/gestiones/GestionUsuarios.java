/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.gestiones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.daos.UsuarioDao;
import modelo.dtos.RolDto;
import modelo.dtos.UsuarioDto;

/**
 *
 * @author kennross
 */
public class GestionUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Registro de un usuario dentro del sistema
        if (request.getParameter("botonRegistro") != null && request.getParameter("botonRegistro").equals("Registrarme")) {
            RolDto suRol = new RolDto();
            suRol.setIdRol(Integer.parseInt(request.getParameter("ruRol")));
            
            UsuarioDto nuevoUsuario = new UsuarioDto();
            nuevoUsuario.setIdUsuario(Long.parseLong(request.getParameter("ruDocumento")));
            nuevoUsuario.setNombres(request.getParameter("ruNombres"));
            nuevoUsuario.setApellidos(request.getParameter("ruApellidos"));
            nuevoUsuario.setClave(request.getParameter("ruClave"));
            nuevoUsuario.setCorreo(request.getParameter("ruCorreo"));
            nuevoUsuario.setFechaNacimiento(null);
            nuevoUsuario.setDireccion(request.getParameter("ruDireccion"));
            nuevoUsuario.setIdCiudad(Integer.parseInt(request.getParameter("ruCiudad")));
            nuevoUsuario.setImagen("img/avatars/avatar-productor.png");
            nuevoUsuario.setEstado(1);
            
            UsuarioDao realizarRegistro = new UsuarioDao();
            String salida = realizarRegistro.insertUsuarioProcedimiento(nuevoUsuario, suRol);
            
            if (salida.equals("ok")) {
                response.sendRedirect("index.jsp?msg=<strong><i class='glyphicon glyphicon-ok'></i> ¡Registro Éxitoso!</strong> Revise su correo para activar cuenta, puede iniciar sesión.&tipoAlert=success");
            } else if (salida.equals("okno")) {
                response.sendRedirect("../index.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> Por favor intentelo de nuevo.&tipoAlert=warning");
            } else {
                response.sendRedirect("../index.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Ocurrió un error!</strong> Detalle: " + salida + "&tipoAlert=danger");
            }
        }
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionUsuarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
