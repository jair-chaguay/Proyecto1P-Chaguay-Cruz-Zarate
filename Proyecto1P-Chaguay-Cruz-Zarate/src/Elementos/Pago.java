/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Enums.formaPago;
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

    /**
     * Constructor que crea objetos de tipo Pago
     * @param idPago
     * @param codigo
     * @param formaPago
     * @param valorPagar
     */
    public Pago(int idPago, String codigo,formaPago formaPago,double valorPagar){
    this.idPago=idPago;
    this.codigo=codigo;
    this.formaPago=formaPago;
    this.valorPagar=valorPagar;
    }

    /**
     * Metodo toString que retorna en formato String los pagos
     * @return String
     */
    @Override
    public String toString(){
        return idPago+","+codigo+","+formaPago+","+valorPagar;
        
    }
    
    /**
     * Metodo que devuelve el id del pago
     * @return int
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * Metodo set para el id del pago
     * @param idPago
     */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    /**
     * Metodo que devuelve el codigo del pago
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo set para el codigo del pago
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo= codigo;
    }

    /**
     * Metodo que devuelve la forma en la que el cliente pagara
     * @return formaPago
     */
    public formaPago getFormaPago() {
        return formaPago;
    }

    /**
     * Metodo set para la forma de pago
     * @param formaPago
     */
    public void setFormaPago(formaPago formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Metodo que devuelve el valor a pagar por el vuelo
     * @return double
     */
    public double getValorPagar() {
        return valorPagar;
    }

    /**
     * Metodo set para el valor a pagar por el vuelo
     * @param valorPagar
     */
    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
   
    /**
     * Metodo para generar el codigo de pago
     * @return
     */
    public int crearCodigo() {
        String opciones = "1234567890";
        String cadena = "";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int posicion = r.nextInt(opciones.length());
            char caracter = opciones.charAt(posicion);
            cadena += caracter;
        }
        int valor = Integer.parseInt(cadena);
        return valor;

    }
    
        
}
