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
import modelo.dtos.OfertasDto;
import modelo.utilidades.Conexion;

/**
 *
 * @author User
 */
public class OfertaDao {

    private Connection miCon = null;
    PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";

    public OfertaDao() {
        miCon = Conexion.getInstance();
    }

    public List obtenerOfertas() {
        ArrayList<OfertasDto> ofertas = new ArrayList();

        sqlTemp = "SELECT o.idOferta as oferta, concat(u.Nombres, ' ' , u.Apellidos) as productor, p.Nombres as producto"
                + ", pre.Descripcion as presentacion,o.precioVenta as precio, o.fechaInicio as inicio "
                + "FROM oferta as o join productos as p on o.idProducto = p.idProducto join presentacion as pre on o.idPresentacion = pre.idPresentacion "
                + "join usuarios as u on o.idProductor = u.idUsuario;";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OfertasDto oferta = new OfertasDto();
                oferta.setIdOferta(rs.getInt("oferta"));
                oferta.setProductor(rs.getString("productor"));
                oferta.setProducto(rs.getString("producto"));
                oferta.setPresentacion(rs.getString("presentacion"));
                oferta.setPrecio(rs.getLong("precio"));
                oferta.setFechaInicio(rs.getString("inicio"));
                ofertas.add(oferta);
            }

        } catch (SQLException ex) {

        }
        return ofertas;
    }

    public OfertasDto obtenerOferta(int id) {
        OfertasDto oferta = new OfertasDto();

        sqlTemp = "SELECT o.idOferta as oferta, concat(u.Nombres, ' ' , u.Apellidos) as productor, p.Nombres as producto"
                + ", pre.Descripcion as presentacion,o.precioVenta as precio, o.fechaInicio as inicio "
                + "FROM oferta as o join productos as p on o.idProducto = p.idProducto join presentacion as pre on o.idPresentacion = pre.idPresentacion "
                + "join usuarios as u on o.idProductor = u.idUsuario WHERE o.idOferta = ?";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {

                oferta.setIdOferta(rs.getInt("oferta"));
                oferta.setProductor(rs.getString("productor"));
                oferta.setProducto(rs.getString("producto"));
                oferta.setPresentacion(rs.getString("presentacion"));
                oferta.setPrecio(rs.getLong("precio"));
                oferta.setFechaInicio(rs.getString("inicio"));

            }

        } catch (SQLException ex) {

        }
        return oferta;
    }
}
