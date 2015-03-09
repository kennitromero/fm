/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dtos;

/**
 *
 * @author User
 */
public class ReporteProductoDto {
    
    private String nombre = "";
    private long precio = 0;
    private String categoria = "";

    @Override
    public String toString() {
        return "ReporteProductoDto{" + "nombre=" + getNombre() + ", precio=" + getPrecio() + ", categoria=" + getCategoria() + '}';
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public long getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(long precio) {
        this.precio = precio;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
