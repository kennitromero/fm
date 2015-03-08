/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilidades;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.daos.CiudadDao;
import modelo.daos.DepartamentoDao;
import modelo.daos.UsuarioDao;
import modelo.dtos.CiudadDto;
import modelo.dtos.DepartamentoDto;
import modelo.dtos.RolDto;
import modelo.dtos.UsuarioDto;

/**
 *
 * @author kennross
 */
public class PruebaConexion {
    
    public static void main (String[] args) {
        
        Connection miCon = Conexion.getInstance();
        
        if (miCon != null) {
            System.out.println("ok");
        } else {
            System.out.println("Error");
        }
        
        CiudadDao udao = new CiudadDao();
        
        ArrayList<CiudadDto> misCiudades;
        misCiudades = (ArrayList<CiudadDto>) udao.obtenerCiudadesPorId(7);
        
        for (CiudadDto p: misCiudades) {
            System.out.println(p);
        }                
        
        System.out.println(udao.obtenerNombrePorId(23417));
        
        System.out.println("-----------------------------------------------");
        
        DepartamentoDao ddao = new DepartamentoDao();
        ArrayList<DepartamentoDto> misDepartamentos;
        
        misDepartamentos = (ArrayList<DepartamentoDto>) ddao.obtenerDepartamentos();
        
        for (DepartamentoDto p: misDepartamentos) {
            System.out.println(p);
        }
        
        System.out.println(ddao.obtenerNombrePorId(85));
        
        
        System.out.println("----------------------------------");
        
        RolDto suRol = new RolDto();
            suRol.setIdRol(1);
            
            UsuarioDto nuevoUsuario = new UsuarioDto();
            nuevoUsuario.setIdUsuario(64569185);
            nuevoUsuario.setNombres("Alyson");
            nuevoUsuario.setApellidos("Romero Oviedo");
            nuevoUsuario.setClave("mark42");
            nuevoUsuario.setCorreo("alyssa-luna@hotmail.com");
            nuevoUsuario.setFechaNacimiento(null);
            nuevoUsuario.setDireccion("Carrera 19 Bis 8 - 19");
            nuevoUsuario.setIdCiudad(70001);
            nuevoUsuario.setImagen(null);
            nuevoUsuario.setEstado(1);
            
            UsuarioDao realizarRegistro = new UsuarioDao();
            String salida = realizarRegistro.insertUsuarioProcedimiento(nuevoUsuario, suRol);
            
            System.out.println(salida);
            
            System.out.println("----------------------------------");
            
            System.out.println(realizarRegistro.validarExistenciaDocumento(64569185));
            
            System.out.println("----------------------------------");                       
            
            UsuarioDto p = realizarRegistro.obtenerUsuarioPorId(1102867002);
            System.out.println(p.getImagen());
            
    }
    
}
