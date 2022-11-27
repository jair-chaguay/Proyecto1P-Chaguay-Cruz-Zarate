/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Enums.formaPago;
import Sistema.*;
import Enums.*;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Pago {
    private int idPago;
    private String codigo;
    private formaPago formaPago;
    private double valorPagar;
    
    //CONSTRUCTOR PARA CREAR OBEJTOS DE TIPO PAGO
    public Pago(int idPago, String codigo,formaPago formaPago,double valorPagar){
    this.idPago=idPago;
    this.codigo=codigo;
    this.formaPago=formaPago;
    this.valorPagar=valorPagar;
    }
    @Override
    public String toString(){
        return idPago+","+codigo+","+formaPago+","+valorPagar;
        
    }
    

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo= codigo;
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
    
    
        
        
}
