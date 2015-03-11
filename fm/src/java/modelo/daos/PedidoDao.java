/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dtos.PedidoDto;
import modelo.dtos.PedidosDto;
import modelo.utilidades.Conexion;

/**
 *
 * @author User
 */
public class PedidoDao {
    
    private Connection miCon = null;
    PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";
    
    public PedidoDao() {
        miCon = Conexion.getInstance();
    }
    
    public String insertarPedido(PedidoDto pedido) {
        
        sqlTemp = "Insert INTO pedidos VALUES(NULL,?,?,curdate(),?)";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setInt(1, pedido.getIdOferta());
            pstm.setLong(2, pedido.getIdCliente());
            pstm.setInt(3, pedido.getCantidad());
            rtdo = pstm.executeUpdate();
            if (rtdo != 0) {
                mensaje = "Registro Exitoso";
            } else {
                mensaje = "Ha ocurrido algo!!";
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }
    
    public List obtenerPedidos(long idCliente) {
        ArrayList<PedidosDto> pedidos = new ArrayList();
        
        sqlTemp = "select pe.idPedido as pedido, concat(u.Nombres, ' ', u.Apellidos) as cliente, p.Nombres as producto"
                + ", pre.descripcion as presentacion, pe.cantidad as cantidad, pe.fechaPedido as fecha "
                + "from pedidos as pe join oferta as o on pe.idOferta = o.idOferta join productos as p on o.idProducto = p.idProducto "
                + "join presentacion as pre on o.idPresentacion = pre.idPresentacion join usuarios as u on pe.idCliente = u.idUsuario "
                + "where pe.idCliente = ? ;";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setLong(1, idCliente);
            rs = pstm.executeQuery();
            while(rs.next()){
                PedidosDto pedido = new PedidosDto();
                pedido.setIdPedido(rs.getInt("pedido"));
                pedido.setCliente(rs.getString("cliente"));
                pedido.setProducto(rs.getString("producto"));
                pedido.setPresentacion(rs.getString("presentacion"));
                pedido.setCantidad(rs.getInt("cantidad"));
                pedido.setFechaPedido(rs.getString("fecha"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            
        }
        return pedidos;
    }
    
}
