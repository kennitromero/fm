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
import modelo.dtos.FacturaPedido;
import modelo.dtos.ReportePedidosCiudad;
import modelo.dtos.ReporteProductoDto;
import modelo.dtos.ReporteProductosVendidos;
import modelo.utilidades.Conexion;

/**
 *
 * @author Akashyro
 */
public class ReportesDao {

    private Connection cnn = null;
    private ResultSet rs = null;
    private PreparedStatement pstm = null;

    public ReportesDao() {
        cnn = Conexion.getInstance();
    }

    public List<ReporteProductoDto> productoSistema(String product, String categoria) {
        ArrayList<ReporteProductoDto> productos = new ArrayList();
        try {
            StringBuilder sb = new StringBuilder("select p.nombres as Nombre, p.precioCompra as Precio, c.Descripcion as Categoria "
                    + "from productos as p join categorias as c on p.idCategoria = c.idCategoria WHERE 1=1 ");

            if (product != null) {
                sb.append("AND p.nombres LIKE '").append(product).append("%'");
            }
            if (categoria != null) {
                sb.append("AND c.Descripcion LIKE '").append(categoria).append("%'");
            }

            sb.append("order by precioCompra desc");
            pstm = cnn.prepareStatement(sb.toString());
            rs = pstm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ReporteProductoDto producto = new ReporteProductoDto();
                    producto.setNombre(rs.getString("Nombre"));
                    producto.setPrecio(rs.getLong("Precio"));
                    producto.setCategoria(rs.getString("Categoria"));
                    productos.add(producto);
                }
            }
        } catch (SQLException ex) {

        }

        return productos;
    }

    public List productosMasVendidos(String producto, String novedad) {
        ArrayList<ReporteProductosVendidos> productos = new ArrayList();
        String mensaje = "";
        try {
            StringBuilder sb = new StringBuilder("select count(p.idPedido) as pedidos"
                    + ", pro.nombres as producto, pre.Descripcion as presentacion, n.Descripcion as novedad, pro.PrecioCompra as precioUnitario"
                    + ", o.PrecioVenta as precioVenta from pedidos as p join oferta as o on p.idOferta = o.idOferta "
                    + "join productos as pro on o.idProducto = pro.idProducto join presentacion as pre on o.idPresentacion = pre.idPresentacion "
                    + "join novedades as n on n.idNovedad = o.idNovedad WHERE 1=1 ");
            
            if (producto != null) {
                sb.append("AND pro.nombres LIKE '").append(producto).append("%' ");
            }
            if (novedad != null) {
                sb.append("AND n.Descripcion LIKE '").append(novedad).append("%' ");
            }
             sb.append("group by pro.Nombres order by count(p.idPedido) desc limit 30;");
             
            pstm = cnn.prepareStatement(sb.toString());
            rs = pstm.executeQuery();
            while(rs.next()){
                ReporteProductosVendidos reporteProducto = new ReporteProductosVendidos();
                reporteProducto.setPedidos(rs.getInt("pedidos"));
                reporteProducto.setProducto(rs.getString("producto"));
                reporteProducto.setPresentacion(rs.getString("presentacion"));
                reporteProducto.setNovedad(rs.getString("novedad"));
                reporteProducto.setPrecioUnitario(rs.getLong("precioUnitario"));
                reporteProducto.setPrecioVenta(rs.getLong("precioVenta"));
                productos.add(reporteProducto);
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return productos;
    }
    
    public List productosMenosVendidos(String producto, String novedad) {
        ArrayList<ReporteProductosVendidos> productos = new ArrayList();
        try {
            StringBuilder sb = new StringBuilder("select count(p.idPedido) as pedidos"
                    + ", pro.Nombres as producto, pre.Descripcion as presentacion, n.Descripcion as novedad, pro.PrecioCompra as precioUnitario"
                    + ", o.PrecioVenta as precioVenta from pedidos as p join oferta as o on p.idOferta = o.idOferta "
                    + "join productos as pro on o.idProducto = pro.idProducto join presentacion as pre on o.idPresentacion = pre.idPresentacion "
                    + "join novedades as n on n.idNovedad = o.idNovedad WHERE 1=1 ");
            
            if (producto != null) {
                sb.append("AND pro.Nombres LIKE '").append(producto).append("'% ");
            }
            if (novedad != null) {
                sb.append("AND n.Descrpcion LIKE '").append(novedad).append("'% ");
            }
             sb.append("group by pro.Nombres order by count(p.idPedido) asc limit 30;");
             
            pstm = cnn.prepareStatement(sb.toString());
            rs = pstm.executeQuery();
            while(rs.next()){
                ReporteProductosVendidos reporteProducto = new ReporteProductosVendidos();
                reporteProducto.setPedidos(rs.getInt("pedidos"));
                reporteProducto.setProducto(rs.getString("producto"));
                reporteProducto.setPresentacion(rs.getString("presentacion"));
                reporteProducto.setNovedad(rs.getString("novedad"));
                reporteProducto.setPrecioUnitario(rs.getLong("precioUnitario"));
                reporteProducto.setPrecioVenta(rs.getLong("precioVenta"));
                productos.add(reporteProducto);
            }
        } catch (SQLException ex) {

        }
        return productos;
    }

    public List<ReportePedidosCiudad> ciudadPedidos() {
        ArrayList<ReportePedidosCiudad> pedidos = new ArrayList();

        try {
            pstm = cnn.prepareStatement("select c.ciudad as ciudad, count(p.idCliente) as pedido from pedidos as p join usuarios as u on p.idCliente = u.idUsuario join ciudades as c on u.idCiudad = c.idCiudad group by c.ciudad order by count(p.idCliente) desc ;");

            rs = pstm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ReportePedidosCiudad pedido = new ReportePedidosCiudad();
                    pedido.setCiudad(rs.getString("ciudad"));
                    pedido.setPedidos(rs.getInt("pedido"));
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException ex) {

        }

        return pedidos;
    }

    public FacturaPedido facturaPedido(long cedula) {
        FacturaPedido factura = new FacturaPedido();
        try {
            pstm = cnn.prepareStatement("SELECT p.idPedido as pedido, p.idOferta as oferta, p.idCliente as cliente"
                    + ", concat(u.nombres, ' ', u.apellidos) as nombre, pro.nombres as producto,pre.descripcion as presentacion"
                    + ",pro.unidad as unidad ,p.cantidad as cantidad,o.precioVenta as precio, p.fechaPedido as fechapedido "
                    + "FROM pedidos as p join oferta as o on p.idOferta= o.idOferta join usuarios as u on p.idCliente = u.idUsuario "
                    + "join productos as pro on o.idProducto = pro.idProducto join presentacion as pre on pre.idPresentacion = o.idPresentacion "
                    + "where idUsuario = ? order by idPedido desc limit 1;");
            pstm.setLong(1, cedula);
            rs = pstm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    factura.setPedido(rs.getInt("pedido"));
                    factura.setOferta(rs.getInt("oferta"));
                    factura.setCedula(rs.getLong("cliente"));
                    factura.setNombre(rs.getString("nombre"));
                    factura.setProducto(rs.getString("producto"));
                    factura.setPresentacion(rs.getString("presentacion"));
                    factura.setUnidad(rs.getString("unidad"));
                    factura.setCantidad(rs.getInt("cantidad"));
                    factura.setPrecio(rs.getLong("precio"));
                    factura.setFecha(rs.getString("fechapedido"));
                }
            }
        } catch (SQLException ex) {

        }
        return factura;
    }
}
