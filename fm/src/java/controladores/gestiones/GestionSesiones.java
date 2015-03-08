/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.gestiones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.daos.RolUsuarioDao;
import modelo.daos.UsuarioDao;
import modelo.dtos.UsuarioDto;

/**
 *
 * @author kennross
 */
public class GestionSesiones extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        if ((request.getParameter("botonIniciar") != null) && (request.getParameter("botonIniciar").equals("Entrar"))) {

            if ((request.getParameter("isDocumento") != null) && (request.getParameter("isClave") != null)) {

                long documento = Long.parseLong(request.getParameter("isDocumento"));
                String clave = request.getParameter("isClave");

                UsuarioDao validar = new UsuarioDao();
                UsuarioDto usuario;

                usuario = validar.validarSesion(documento);

                if (usuario.getClave().equals("")) {
                    response.sendRedirect("index.jsp?msg=<strong><i class='glyphicon glyphicon-remove'></i> ¡USUARIO NO EXISTE!</strong> Intente nuevamente.&tipoAlert=warning");
                } else if (usuario.getClave().equals(clave)) {
                    HttpSession miSesion = request.getSession();
                    HttpSession rolesUsuario = request.getSession();

                    UsuarioDto queryPersona;
                    queryPersona = validar.obtenerUsuarioPorId(usuario.getIdUsuario());
                    miSesion.setAttribute("usuarioEntro", queryPersona);

                    RolUsuarioDao roles = new RolUsuarioDao();
                    ArrayList<Integer> rolesActual;
                    rolesActual = roles.obtenerRolesParaUsuario(documento);
                    rolesUsuario.setAttribute("roles", rolesActual);

                    for (Integer i : rolesActual) {
                        if (i.toString().equals("1")) {
                            response.sendRedirect("pages/plantilla.jsp");
                        } else if (i.toString().equals("2")) {
                            response.sendRedirect("pages/indexc.jsp");
                        } else if (i.toString().equals("3")) {
                            response.sendRedirect("pages/indexa.jsp");
                        }
                    }
                } else {
                    response.sendRedirect("index.jsp?msg=<strong><i class='glyphicon glyphicon-remove'></i> ¡CONTRASEÑA INCORRETA!</strong> Intente nuevamente.&tipoAlert=warning");
                }
            } else {
                response.sendRedirect("index.jsp?msg=<strong><i class='glyphicon glyphicon-remove'></i> ¡CAMPOS VACIOS!</strong> Intente nuevamente.&tipoAlert=warning");                
            }

        } else if (request.getParameter("op").equals("salir")) {
            HttpSession miSesion = request.getSession();
            miSesion.invalidate();            
            response.sendRedirect("index.jsp?msg=<strong>¡Sesión Cerrada Correctamente!</strong> <i class='glyphicon glyphicon-ok'></i>&tipoAlert=info");            
        } else {
            response.sendRedirect("index.jsp");
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
