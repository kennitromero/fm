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
import modelo.dtos.ReporteProductoDto;
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
//           pstm = cnn.prepareStatement("select p.nombres as Nombre, p.precioCompra as Precio, c.Descripcion as Categoria from productos as p join categorias as c on p.idCategoria = c.idCategoria");
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

//    public List<ReporteOfertasDto> ofertasSolicitadas(String producto, String presentacion) {
//        ArrayList<ReporteOfertasDto> ofertas = new ArrayList();
//        try {
//
//            StringBuilder sb = new StringBuilder("select f.idOferta as oferta, p.nombres as producto, pre.descripcion as presentacion, f.precioVenta as precio, count(f.idOferta) as pedido from oferta as f join presentacion as pre on f.idPresentacion = pre.idPresentacion join productos as p on f.idProducto = p.idProducto join pedidos as pe on pe.idOferta = f.idOferta ");
//
//            if (producto != null) {
//                sb.append("AND p.nombres LIKE '").append(producto).append("%' ");
//            }
//            if (presentacion != null) {
//                sb.append("AND pre.descripcion LIKE '").append(presentacion).append("%' ");
//            }
//
////            pstm = cnn.prepareStatement("select f.idOferta as oferta, p.nombres as producto, pre.descripcion as presentacion, f.precioVenta as precio, count(f.idOferta) as pedido from oferta as f join presentacion as pre on f.idPresentacion = pre.idPresentacion join productos as p on f.idProducto = p.idProducto join pedidos as pe on pe.idOferta = f.idOferta group by f.idOferta");
//            sb.append("group by f.idOferta order by count(f.idOferta) desc limit 10");
//            pstm = cnn.prepareStatement(sb.toString());
//            rs = pstm.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//                    ReporteOfertasDto oferta = new ReporteOfertasDto();
//                    oferta.setOferta(rs.getInt("oferta"));
//                    oferta.setProducto(rs.getString("producto"));
//                    oferta.setPresentacion(rs.getString("presentacion"));
//                    oferta.setPrecio(rs.getLong("precio"));
//                    oferta.setPedidos(rs.getInt("pedido"));
//                    ofertas.add(oferta);
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//        return ofertas;
//    }
//
//    public List<ReporteClientesDto> frecuenciaClientes(String ciudad) {
//        ArrayList<ReporteClientesDto> clientes = new ArrayList();
//        try {
//            // pstm = cnn.prepareStatement("select idCliente as Documento , concat(u.nombres, ' ', u.apellidos) as Nombre, c.ciudad as Ciudad , count(idPedido)  as Veces from pedidos as p join usuarios as u on p.idCliente = u.idUsuario join ciudades as c on u.idCiudad = c.idCiudad group by idCliente order by count(idPedido) desc;");
//            StringBuilder sb = new StringBuilder("select idCliente as Documento , concat(u.nombres, ' ', u.apellidos) as Nombre, c.ciudad as Ciudad , count(idPedido)  as Veces from pedidos as p join usuarios as u on p.idCliente = u.idUsuario join ciudades as c on u.idCiudad = c.idCiudad WHERE 1=1 ");
//
//            if (ciudad != null) {
//                sb.append("AND c.ciudad LIKE '").append(ciudad).append("%'");
//            }
//
//            sb.append("group by idCliente order by count(idPedido) desc;");
//            pstm = cnn.prepareStatement(sb.toString());
//            rs = pstm.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//                    ReporteClientesDto cliente = new ReporteClientesDto();
//                    cliente.setDocumento(rs.getLong("Documento"));
//                    cliente.setNombre(rs.getString("Nombre"));
//                    cliente.setCiudad(rs.getString("Ciudad"));
//                    cliente.setCantidad(rs.getInt("Veces"));
//                    clientes.add(cliente);
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//        return clientes;
//    }
//
//    public List<ReportePedidosDto> ciudadPedidos(/*String ciudad*/) {
//        ArrayList<ReportePedidosDto> pedidos = new ArrayList();
//
//        try {
//            pstm = cnn.prepareStatement("select c.ciudad as ciudad, count(p.idCliente) as pedido from pedidos as p join usuarios as u on p.idCliente = u.idUsuario join ciudades as c on u.idCiudad = c.idCiudad group by c.ciudad order by count(p.idCliente) desc ;");
////            StringBuilder sb = new StringBuilder("select c.ciudad as ciudad, count(p.idCliente) as pedido from pedidos as p join usuarios as u on p.idCliente = u.idUsuario join ciudades as c on u.idCiudad = c.idCiudad WHERE 1=1 ");
////            
////            if (ciudad != null) {
////                sb.append("AND c.ciudad LIKE '").append(ciudad).append("%'");
////            }
////            
////            sb.append("group by c.ciudad order by count(p.idCliente) desc ;");
////            pstm = cnn.prepareStatement(sb.toString());
//            rs = pstm.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//                    ReportePedidosDto pedido = new ReportePedidosDto();
//                    pedido.setCiudad(rs.getString("ciudad"));
//                    pedido.setPedidos(rs.getInt("pedido"));
//                    pedidos.add(pedido);
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//
//        return pedidos;
//    }
//
//    public List<ReportePedidoClienteDto> misPedidos(long usuario, String fechaBusqueda, String producto) {
//        ArrayList<ReportePedidoClienteDto> pedidos = new ArrayList();
//        try {
////            pstm = cnn.prepareStatement("select p.idPedido as numeroPedido, pro.nombres as producto"
////                    + ", pre.descripcion as presentacion, pro.unidad as unidad, p.cantidad as cantidad"
////                    + ", o.precioVenta as precio, p.fechaPedido as fecha from pedidos as p "
////                    + "join oferta as o on p.idPedido = o.idOferta join productos as pro on pro.idProducto = o.idProducto " + "join presentacion as pre on o.idPresentacion = pre.idPresentacion "
////                    + "join usuarios as u on u.idUsuario = p.idCliente where u.idUsuario = ? group by pro.nombres;");
//
//            StringBuilder sb = new StringBuilder("select p.idPedido as numeroPedido, pro.nombres as producto"
//                    + ", pre.descripcion as presentacion, pro.unidad as unidad, p.cantidad as cantidad"
//                    + ", o.precioVenta as precio, p.fechaPedido as fecha from pedidos as p "
//                    + "join oferta as o on p.idPedido = o.idOferta join productos as pro on pro.idProducto = o.idProducto "
//                    + "join presentacion as pre on o.idPresentacion = pre.idPresentacion "
//                    + "join usuarios as u on u.idUsuario = p.idCliente where u.idUsuario = ? AND p.fechaPedido BETWEEN ? AND curdate() ");
//
//            if (producto != null) {
//                sb.append("AND pro.nombres LIKE '").append(producto).append("%' ");
//            }
////            if (fechaBusqueda != null) {
////                sb.append("AND p.fechaPedido BETWEEN ").append(fechaBusqueda).append("AND curdate() ");
////            }
//            sb.append("group by pro.nombres;");
//            pstm = cnn.prepareStatement(sb.toString());
//            pstm.setLong(1, usuario);
//            pstm.setString(2, fechaBusqueda);
//            rs = pstm.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//                    ReportePedidoClienteDto pedido = new ReportePedidoClienteDto();
//                    pedido.setPedido(rs.getInt("numeroPedido"));
//                    pedido.setProducto(rs.getString("producto"));
//                    pedido.setPresentacion(rs.getString("presentacion"));
//                    pedido.setUnidad(rs.getString("unidad"));
//                    pedido.setCantidad(rs.getInt("cantidad"));
//                    pedido.setPrecio(rs.getLong("precio"));
//                    pedido.setFechaPedido(rs.getString("fecha"));
//                    pedidos.add(pedido);
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//        return pedidos;
//    }
//
//    public List<ReporteOfertaProductorDto> misOfertas(long usuario, String fecha, String producto, String presentacion) {
//        ArrayList<ReporteOfertaProductorDto> ofertas = new ArrayList();
//        try {
//
////            pstm = cnn.prepareStatement("select o.idOferta as oferta, p.nombres as producto, pre.descripcion as presentacion"
////                    + ", n.descripcion as novedad, o.precioVenta as precio, o.fechaInicio as publicacion  from oferta as o "
////                    + "join usuarios as u on u.idUsuario = o.idProductor join productos as p on p.idProducto= o.idProducto "
////                    + "join presentacion as pre on o.idPresentacion = pre.idPresentacion join novedades as n on o.idNovedad = n.idNovedad "
////                    + "where u.idUsuario = ? AND o.fechaInicio BETWEEN ? AND curdate() group by o.idOferta");
//            StringBuilder sb = new StringBuilder("select o.idOferta as oferta, p.nombres as producto, pre.descripcion as presentacion"
//                    + ", n.descripcion as novedad, o.precioVenta as precio, o.fechaInicio as publicacion  from oferta as o "
//                    + "join usuarios as u on u.idUsuario = o.idProductor join productos as p on p.idProducto= o.idProducto "
//                    + "join presentacion as pre on o.idPresentacion = pre.idPresentacion join novedades as n on o.idNovedad = n.idNovedad "
//                    + "where u.idUsuario = ? AND o.fechaInicio BETWEEN ? AND curdate() ");
//            if (producto != null) {
//                sb.append("AND p.nombres LIKE '").append(producto).append("%'");
//            }
//            if (presentacion != null) {
//                sb.append("AND pre.descripcion LIKE '").append(presentacion).append("%'");
//            }
//
//            sb.append("group by o.idOferta");
//            pstm = cnn.prepareStatement(sb.toString());
//            pstm.setLong(1, usuario);
//            pstm.setString(2, fecha);
//            rs = pstm.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//                    ReporteOfertaProductorDto oferta = new ReporteOfertaProductorDto();
//                    oferta.setOferta(rs.getInt("oferta"));
//                    oferta.setProducto(rs.getString("producto"));
//                    oferta.setPresentacion(rs.getString("presentacion"));
//                    oferta.setNovedad(rs.getString("novedad"));
//                    oferta.setPrecio(rs.getLong("precio"));
//                    oferta.setPublicacion(rs.getString("publicacion"));
//                    ofertas.add(oferta);
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//        return ofertas;
//    }
//
//    public List<ReporteUsuariosDto> usuariosRegistrados(String ciudad, String fecha) {
//        ArrayList<ReporteUsuariosDto> usuarios = new ArrayList();
//        try {
//            StringBuilder sb = new StringBuilder("SELECT idUsuario,concat(nombres,' ', apellidos) as nombres, correo "
//                    + ", direccion, c.ciudad as ciudad, fechaSistema as ingreso, count(idUsuario) as registrados from usuarios as u "
//                    + "join ciudades as c on u.idCiudad = c.idCiudad WHERE 1=1 AND fechaSistema between ? and curdate() ");
//            if (ciudad != null) {
//                sb.append("AND c.ciudad LIKE '").append(ciudad).append("%'");
//            }
//            
//            sb.append("group by idUsuario;");
//            pstm = cnn.prepareStatement(sb.toString());
//            pstm.setString(1, fecha);
//            rs = pstm.executeQuery();
//            if (rs !=null) {
//                while(rs.next()){
//                    ReporteUsuariosDto usuario = new ReporteUsuariosDto();
//                    usuario.setCedula(rs.getLong("idUsuario"));
//                    usuario.setNombre(rs.getString("nombres"));
//                    usuario.setCorreo(rs.getString("correo"));
//                    usuario.setDireccion(rs.getString("direccion"));
//                    usuario.setCiudad(rs.getString("ciudad"));
//                    usuario.setIngreso(rs.getString("ingreso"));
//                    usuario.setRegistrados(rs.getInt("registrados"));
//                    usuarios.add(usuario);
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//        
//        return usuarios;
//
//    }
//    
//    public FacturaPedido facturaPedido(long cedula){
//        FacturaPedido factura = new FacturaPedido();
//        try{
//            pstm = cnn.prepareStatement("SELECT p.idPedido as pedido, p.idOferta as oferta, p.idCliente as cliente"
//                    + ", concat(u.nombres, ' ', u.apellidos) as nombre, pro.nombres as producto,pre.descripcion as presentacion"
//                    + ",pro.unidad as unidad ,p.cantidad as cantidad,o.precioVenta as precio, p.fechaPedido as fechapedido "
//                    + "FROM pedidos as p join oferta as o on p.idOferta= o.idOferta join usuarios as u on p.idCliente = u.idUsuario "
//                    + "join productos as pro on o.idProducto = pro.idProducto join presentacion as pre on pre.idPresentacion = o.idPresentacion "
//                    + "where idUsuario = ? order by idPedido desc limit 1;");
//            pstm.setLong(1, cedula);
//            rs = pstm.executeQuery();
//            if (rs != null) {
//                while(rs.next()){
//                    factura.setPedido(rs.getInt("pedido"));
//                    factura.setOferta(rs.getInt("oferta"));
//                    factura.setCedula(rs.getLong("cliente"));
//                    factura.setNombre(rs.getString("nombre"));
//                    factura.setProducto(rs.getString("producto"));
//                    factura.setPresentacion(rs.getString("presentacion"));
//                    factura.setUnidad(rs.getString("unidad"));
//                    factura.setCantidad(rs.getInt("cantidad"));
//                    factura.setPrecio(rs.getLong("precio"));
//                    factura.setFecha(rs.getString("fechapedido"));
//                }
//            }
//        }catch (SQLException ex) {
//            
//        }
//        return factura;
//    }
}
