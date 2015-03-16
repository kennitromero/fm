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
public class ReportePedidosCiudad {
    private String nombreCliente = "";
    private String ciudad = "";
    private String correo = "";
    private int pedidos = 0;

    @Override
    public String toString() {
        return "ReportePedidosCiudad{" + "nombreCliente=" + nombreCliente + ", ciudad=" + ciudad + ", correo=" + correo + ", pedidos=" + pedidos + '}';
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
