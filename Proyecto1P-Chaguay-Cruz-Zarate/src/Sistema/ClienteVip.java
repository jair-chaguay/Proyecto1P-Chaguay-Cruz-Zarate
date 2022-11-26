/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Elementos.*;
import Enums.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ClienteVip extends Cliente{
    private String rango;
    private int millas=1000;

    public ClienteVip(String cedula, String nombres,int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres,edad, correo,usuario, contrasena, tipoCategoria);
        ArrayList<String[]> datosClientes=LeerValidando("clientes.txt",true);
        for(String[] dato:datosClientes){
            if(dato[0].equals(cedula)){
                this.rango=dato[2];
                this.millas=Integer.valueOf(dato[3]);
            }
        }    
    }

    
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
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
