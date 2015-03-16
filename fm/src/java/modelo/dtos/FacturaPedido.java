/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dtos;

/**
 *
 * @author Akashyro
 */
public class FacturaPedido {

    private int pedido = 0;
    private int oferta = 0;
    private long cedula = 0;
    private String nombre = "";
    private String producto = "";
    private String presentacion = "";
    private String unidad = "";
    private int cantidad = 0;
    private long precio = 0;
    private String fecha = "";

    @Override
    public String toString() {
        return "FacturaPedido{" + "pedido=" + pedido + ", oferta=" + oferta + ", cedula=" + cedula + ", nombre=" + nombre + ", producto=" + producto + ", presentacion=" + presentacion + ", unidad=" + unidad + ", cantidad=" + cantidad + ", precio=" + precio + ", fecha=" + fecha + '}';
    }

    /**
     * @return the pedido
     */
    public int getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the oferta
     */
    public int getOferta() {
        return oferta;
    }

    /**
     * @param oferta the oferta to set
     */
    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    /**
     * @return the cedula
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
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
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
