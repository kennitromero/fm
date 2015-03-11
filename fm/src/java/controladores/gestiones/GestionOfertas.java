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
import javax.servlet.http.HttpSession;
import modelo.daos.OfertaDao;
import modelo.daos.PedidoDao;
import modelo.dtos.OfertasDto;
import modelo.dtos.PedidoDto;
import modelo.dtos.UsuarioDto;

/**
 *
 * @author User
 */
public class GestionOfertas extends HttpServlet {

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

        if (request.getParameter("id") != null) {
            HttpSession sesion = request.getSession(false);
            OfertaDao obtenerOferta = new OfertaDao();
            OfertasDto oferta = obtenerOferta.obtenerOferta(Integer.parseInt(request.getParameter("id")));
            sesion.setAttribute("oferta", oferta);
            response.sendRedirect("pages/carrito.jsp");

        } else if (request.getParameter("pedir") != null) {
            HttpSession sesion = request.getSession(false);
            UsuarioDto usuario = (UsuarioDto) sesion.getAttribute("usuarioEntro");
            PedidoDao registrarPedido = new PedidoDao();
            PedidoDto pedido = new PedidoDto();
            pedido.setIdOferta(Integer.parseInt(request.getParameter("pedido")));
            pedido.setIdCliente(usuario.getIdUsuario());
            pedido.setCantidad(Integer.parseInt(request.getParameter("cantidad")));

            String mensaje = registrarPedido.insertarPedido(pedido);
            response.sendRedirect("pages/indexc.jsp?exitoso=" + mensaje);
        }

        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionOfertas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionOfertas at " + request.getContextPath() + "</h1>");
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
