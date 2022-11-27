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
    private static ArrayList<Asientos> listaAsientos;

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

 
    
    public static void cargarAsientos(ArrayList<Asientos> listaAsientos){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asientos a;
        for(String[] dato:datosAsientos){
            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listaAsientos.add(a);
        }
    }
    public static String asignarAsiento(String codigoAvion){
        Avion.cargarAsientos(listaAsientos);
        Asientos a;
        String nA="";
        for(Asientos asiento: listaAsientos){
            if(asiento.getDisponible().equals(disponibilidad.valueOf("S")) && (asiento.getCodigoAvion().equals(codigoAvion))){
                Random r=new Random();
                for(int i=0; i<listaAsientos.size();i++){
                    int posicion= r.nextInt(listaAsientos.size());
                    a=listaAsientos.get(posicion);
                    nA+=a.getNumAsiento();
                }
            }    
            
        }return nA;
    }
}
