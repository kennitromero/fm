package modelo.daos;

/**
 * @author Kennit David Ruz Romero 
 * Fecha: 4 de de Enero de 2015
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dtos.RolDto;
import modelo.dtos.UsuarioDto;
import modelo.utilidades.Conexion;

public class UsuarioDao {

    private Connection miCon = null;
    PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";

    public UsuarioDao() {
        miCon = Conexion.getInstance();
    }
    
    public String insertUsuarioProcedimiento(UsuarioDto nuevoUsuario, RolDto suRol) {
        try {
            String sqlInsert = "CALL ProceRegistrarUsuarioCompleto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = miCon.prepareStatement(sqlInsert);
            
            pstm.setLong(1, nuevoUsuario.getIdUsuario());
            pstm.setString(2, nuevoUsuario.getNombres());
            pstm.setString(3, nuevoUsuario.getApellidos());
            pstm.setString(4, nuevoUsuario.getClave());
            pstm.setString(5, nuevoUsuario.getCorreo());
            pstm.setString(6, nuevoUsuario.getFechaNacimiento());
            pstm.setString(7, nuevoUsuario.getDireccion());
            pstm.setInt(8, nuevoUsuario.getIdCiudad());
            pstm.setString(9, nuevoUsuario.getImagen());
            pstm.setInt(10, nuevoUsuario.getEstado());
            pstm.setInt(11, suRol.getIdRol());
            
            rtdo = pstm.executeUpdate();

            if (rtdo != 0) {
                mensaje = "ok";
            } else {
                mensaje = "okno";
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return mensaje;
    }

    public String insertUsuario(UsuarioDto nuevoUsuario) {
        try {
            String sqlInsert = "INSERT INTO `usuarios`(`idUsuario`, `Nombres`, "
                    + "`Apellidos`, `Clave`, `Correo`, `FechaNacimiento`, `Direccion`, "
                    + "`idCiudad`, `FechaSistema`, `imagen`, `Estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, now(), ?, ?)";
            pstm = miCon.prepareStatement(sqlInsert);
            
            pstm.setLong(1, nuevoUsuario.getIdUsuario());
            pstm.setString(2, nuevoUsuario.getNombres());
            pstm.setString(3, nuevoUsuario.getApellidos());
            pstm.setString(4, nuevoUsuario.getClave());
            pstm.setString(5, nuevoUsuario.getCorreo());
            pstm.setString(6, nuevoUsuario.getFechaNacimiento());
            pstm.setString(7, nuevoUsuario.getDireccion());
            pstm.setInt(8, nuevoUsuario.getIdCiudad());
            pstm.setString(9, nuevoUsuario.getImagen());
            pstm.setInt(10, nuevoUsuario.getEstado());
            
            rtdo = pstm.executeUpdate();

            if (rtdo != 0) {
                mensaje = "ok";
            } else {
                mensaje = "okno";
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return mensaje;
    }

    public List obtenerUsuarios() {
        ArrayList<UsuarioDto> usuarios = null;
        sqlTemp = "SELECT `idUsuario`, `Nombres`, `Apellidos`, `Clave`, `Correo`, "
                + "`FechaNacimiento`, `Direccion`, `idCiudad`, `FechaSistema`, `Imagen` `Estado` FROM `usuarios`";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            rs = pstm.executeQuery();

            usuarios = new ArrayList();
            while (rs.next()) {
                UsuarioDto temp = new UsuarioDto();
                temp.setIdUsuario(rs.getLong("idUsuario"));
                temp.setNombres(rs.getString("Nombres"));
                temp.setApellidos(rs.getString("Apellidos"));
                temp.setClave(rs.getString("Clave"));
                temp.setCorreo(rs.getString("Correo"));
                temp.setFechaNacimiento(rs.getString("FechaNacimiento"));
                temp.setDireccion(rs.getString("Direccion"));
                temp.setIdCiudad(rs.getInt("idCiudad"));
                temp.setFechaSistema(rs.getString("FechaSistema"));
                temp.setImagen(rs.getString("Imagen"));
                temp.setEstado(rs.getInt("Estado"));
                usuarios.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("Error, detalle: " + ex.getMessage());
        }
        return usuarios;
    }

    public String actualizarUsuario(UsuarioDto usuarioActualizado) {
        try {
            String sqlInsert = "UPDATE `usuarios` SET `idUsuario` = ? `Nombres` = ?, "
                    + "`Apellidos` = ?, `Clave` = ?, `Correo` = ?, `FechaNacimiento` = ?, "
                    + "`Direccion` = ?, `idCiudad` = ?, `Imagen` = ?, "
                    + "`Estado` = ? WHERE `idUsuario` = ?";
            pstm = miCon.prepareStatement(sqlInsert);

            pstm.setLong(1, usuarioActualizado.getIdUsuario());
            pstm.setString(2, usuarioActualizado.getNombres());
            pstm.setString(3, usuarioActualizado.getApellidos());
            pstm.setString(4, usuarioActualizado.getClave());
            pstm.setString(5, usuarioActualizado.getCorreo());
            pstm.setString(6, usuarioActualizado.getFechaNacimiento());
            pstm.setString(7, usuarioActualizado.getDireccion());
            pstm.setInt(8, usuarioActualizado.getIdCiudad());
            pstm.setString(9, usuarioActualizado.getImagen());
            pstm.setInt(10, usuarioActualizado.getEstado());
            pstm.setLong(11, usuarioActualizado.getIdUsuario());
            
            rtdo = pstm.executeUpdate();

            if (rtdo != 0) {
                mensaje = "ok";
            } else {
                mensaje = "okno";
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return mensaje;
    }
    
    public StringBuilder validarExistenciaDocumento(long idUsuario) {
        StringBuilder salidaValidar = new StringBuilder("");
        sqlTemp = "SELECT `idUsuario` FROM `usuarios` WHERE `idUsuario` = ?";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setLong(1, idUsuario);
            rs = pstm.executeQuery();

            if (rs.next()) {
                salidaValidar.append("existe");
            } else {
                salidaValidar.append("noexiste");
            }
        } catch (SQLException ex) {
            mensaje = "Error, detalle: " + ex.getMessage();
        }
        return salidaValidar;
    }
    
    public StringBuilder validarExistenciaCorreo(String correo) {
        StringBuilder salidaValidar = new StringBuilder("");
        sqlTemp = "SELECT `Correo` FROM `usuarios` WHERE `Correo` = ?";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setString(1, correo);
            rs = pstm.executeQuery();

            if (rs.next()) {
                salidaValidar.append("existe");
            } else {
                salidaValidar.append("noexiste");
            }
        } catch (SQLException ex) {
            mensaje = "Error, detalle: " + ex.getMessage();
        }
        return salidaValidar;
    }
    
    public UsuarioDto validarSesion(long documento) {
        UsuarioDto usuario = null;
        String sqlTemp = "SELECT `idUsuario`, `Clave` FROM `usuarios` WHERE `idUsuario` = ?";
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setLong(1, documento);
            rs = pstm.executeQuery();

            usuario = new UsuarioDto();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getLong("idUsuario"));
                usuario.setClave(rs.getString("Clave"));
            }
        } catch (SQLException ex) {
            System.out.println("Error, detalle: " + ex.getMessage());
        }
        return usuario;
    }
    
    public UsuarioDto obtenerUsuarioPorId(long idUsuario) {        
        sqlTemp = "SELECT `idUsuario`, `Nombres`, `Apellidos`, `Clave`, `Correo`, "
                + "`FechaNacimiento`, `Direccion`, `idCiudad`, `FechaSistema`, `Imagen`, "
                + "`Estado` FROM `usuarios` WHERE `idUsuario` = ?";
        UsuarioDto salidaUsuario = new UsuarioDto();
        try {
            pstm = miCon.prepareStatement(sqlTemp);
            pstm.setLong(1, idUsuario);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                
                salidaUsuario.setIdUsuario(rs.getLong("idUsuario"));
                salidaUsuario.setNombres(rs.getString("Nombres"));
                salidaUsuario.setApellidos(rs.getString("Apellidos"));
                salidaUsuario.setClave(rs.getString("Clave"));
                salidaUsuario.setCorreo(rs.getString("Correo"));
                salidaUsuario.setFechaNacimiento(rs.getString("FechaNacimiento"));
                salidaUsuario.setDireccion(rs.getString("Direccion"));
                salidaUsuario.setIdCiudad(rs.getInt("idCiudad"));
                salidaUsuario.setFechaSistema(rs.getString("FechaSistema"));
                salidaUsuario.setImagen(rs.getString("Imagen"));
                salidaUsuario.setEstado(rs.getInt("Estado"));                
            }
        } catch (SQLException ex) {
            System.out.println("Error, detalle: " + ex.getMessage());
        }
        return salidaUsuario;
    }
}
