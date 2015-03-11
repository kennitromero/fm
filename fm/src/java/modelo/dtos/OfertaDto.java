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
public class OfertaDto {
    
    private int idOferta = 0;
    private int idPresentacion = 0;
    private int idProducto = 0;
    private long idProductor = 0;
    private long precioVenta = 0;
    private int idNovedad = 0;
    private String fechaInicio = "";
    private String fechaFin = "";
    private int estado = 0;

    @Override
    public String toString() {
        return "OfertaDto{" + "idOferta=" + idOferta + ", idPresentacion=" + idPresentacion + ", idProducto=" + idProducto + ", idProductor=" + idProductor + ", precioVenta=" + precioVenta + ", idNovedad=" + idNovedad + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + '}';
    }

    /**
     * @return the idOferta
     */
    public int getIdOferta() {
        return idOferta;
    }

    /**
     * @param idOferta the idOferta to set
     */
    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    /**
     * @return the idPresentacion
     */
    public int getIdPresentacion() {
        return idPresentacion;
    }

    /**
     * @param idPresentacion the idPresentacion to set
     */
    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the idProductor
     */
    public long getIdProductor() {
        return idProductor;
    }

    /**
     * @param idProductor the idProductor to set
     */
    public void setIdProductor(long idProductor) {
        this.idProductor = idProductor;
    }

    /**
     * @return the precioVenta
     */
    public long getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(long precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the idNovedad
     */
    public int getIdNovedad() {
        return idNovedad;
    }

    /**
     * @param idNovedad the idNovedad to set
     */
    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
