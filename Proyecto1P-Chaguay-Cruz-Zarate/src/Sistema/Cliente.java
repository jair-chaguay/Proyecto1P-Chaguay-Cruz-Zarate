/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import Elementos.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Cliente extends Usuario {
    private String numTarjetaCredito;
    
    

    public Cliente(String cedula, String nombres,int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo,usuario, contrasena, tipoCategoria);
        ArrayList<String[]> datosClientes=LeerValidando("clientes.txt",true);
        for(String[] dato:datosClientes){
            if(dato[0].equals(cedula)){
                this.numTarjetaCredito=dato[1];
            }
        }
    }

    
    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }
    
    @Override
    public String toString(){
        toString();
        return "Num T/C: "+numTarjetaCredito;
    }
        
    
    @Override
    public void consultarReservas(){
        
    }
    public void comprarTickets(){
        System.out.println("----ORIGEN----");
        System.out.println("1. Guayaquil");
        System.out.println("2. Lima");
        System.out.println("Elige punto de partida: ");
        
        System.out.println("----DESTINO----");
        System.out.println("1. Guayaquil");
        System.out.println("2. Lima");
        System.out.println("Elige punto de destino: ");
        
        System.out.println("Fecha de salida: " +"/"+" / ");
        System.out.println("Fecha de retorno: " +"/ "+"/ ");
        
        System.out.println("***************PASO 1***************\n************************************");
        System.out.println("------Vuelos disponibles IDA-----");
        System.out.println("----------------1----------------");
    }    
    

    public void pagar(int numTarjetaCredito){
        
    }
    public void crearReserva(){
        
    }

}
