/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Reserva {
    private String codigo;
    private ArrayList<VueloReserva> vuelosReserva;
    private Cliente cliente;
    private Date fecha;
    private double valorPagar;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<VueloReserva> getVuelosReserva() {
        return vuelosReserva;
    }

    public void setVuelosReserva(ArrayList<VueloReserva> vuelosReserva) {
        this.vuelosReserva = vuelosReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
    
    private void crearCadena(){
        
    }
}
