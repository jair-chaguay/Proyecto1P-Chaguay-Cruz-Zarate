/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import static Archivos.ManejoArchivos.LeerValidando;
import Elementos.Asientos;
import Sistema.*;
import Enums.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Avion {
    private String codigoAvion;
    private int capacidad;
    private static ArrayList<Asientos> listaAsientos=new ArrayList<>();
    private static String asientoAleatorio;
    
    public Avion(String codigoAvion,int capacidad){
        this.codigoAvion=codigoAvion;
        this.capacidad=capacidad;
        
    }
    
    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

 
    
    public static void cargarAsientos(){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asientos a;
        for(String[] dato:datosAsientos){
            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listaAsientos.add(a);
        }
    }
    public static String asignarAsiento(String codigoAvion){
        
        ArrayList<Asientos> asientosDisponibles=new ArrayList<>();
        Random r=new Random();
        
        for(Asientos asiento:listaAsientos){
            if(asiento.getDisponible().equals(disponibilidad.valueOf("S")) && (asiento.getCodigoAvion().equals(codigoAvion))){
                asientosDisponibles.add(asiento);   
            }      
        }
        for(Asientos AD:asientosDisponibles){
                int posicion= r.nextInt(asientosDisponibles.size());
                AD=listaAsientos.get(posicion);
                asientoAleatorio=AD.getNumAsiento();
   
        }
        return asientoAleatorio;
            
    }
}
