/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Enums.formaPago;
import Sistema.*;
import Enums.*;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Pago {
    private Date fechaPago;
    private int idPago;
    private Reserva reserva;
    private formaPago formaPago;
    private double valorPagar;

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public formaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(formaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
    
    public void crearIdPago(){
        
    }
}
