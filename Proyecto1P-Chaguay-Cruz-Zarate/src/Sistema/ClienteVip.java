/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.*;
import Enums.*;

/**
 *
 * @author HP
 */
public class ClienteVip extends Cliente{
    private tipoRango rango;
    private int millas=1000;

    public ClienteVip(String cedula, String nombres, String apellidos, int edad, String correo,String usuario, String contrasena,tipoCategoria tipoCategoria, int numTarjetaCredito, tipoRango rango, int millas) {
        super(cedula, nombres, apellidos, edad, correo,usuario, contrasena, tipoCategoria, numTarjetaCredito);
        this.rango = rango;
        this.millas=millas;
    }

    
    public tipoRango getRango() {
        return rango;
    }

    public void setRango(tipoRango rango) {
        this.rango = rango;
    }

    public int getMillas() {
        return millas;
    }

    public void setMillas(int millas) {
        this.millas = millas;
    }
    
    @Override
    public String toString(){
        toString();
        return "Rango: "+rango+",millas: "+millas;
    }
    @Override
    public void comprarTickets(){
        
    }
    @Override
    public void consultarReservas(){
        
    }
//    @Override
//    public void elegirOpcion(){
//        
//    }
    @Override
    public void pagar(int millas){
        
    }
   
}
