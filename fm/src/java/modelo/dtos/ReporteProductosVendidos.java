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
public class ReporteProductosVendidos {
    private String producto = "";
    private String presentacion = "";
    private String novedad = "";
    private long precioUnitario = 0;
    private long precioVenta = 0;
    private int pedidos = 0;

    @Override
    public String toString() {
        return "ReporteProductosVendidos{" + "producto=" + producto + ", presentacion=" + presentacion + ", novedad=" + novedad + ", precioUnitario=" + precioUnitario + ", precioVenta=" + precioVenta + ", pedidos=" + pedidos + '}';
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * @param presentacion the presentacion to set
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     * @return the novedad
     */
    public String getNovedad() {
        return novedad;
    }

    /**
     * @param novedad the novedad to set
     */
    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    /**
     * @return the precioUnitario
     */
    public long getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(long precioUnitario) {
        this.precioUnitario = precioUnitario;
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
     * @return the pedidos
     */
    public int getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(int pedidos) {
        this.pedidos = pedidos;
    }
}
