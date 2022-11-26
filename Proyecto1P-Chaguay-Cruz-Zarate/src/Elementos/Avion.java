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

/**
 *
 * @author HP
 */
public class Avion {
    private String codigoAvion;
    private int capacidad;
    private ArrayList<Asientos> listaAsientos;

    public Avion(String codigoAvion,int capacidad,ArrayList<Asientos> listaAsientos){
        this.codigoAvion=codigoAvion;
        this.capacidad=capacidad;
        this.listaAsientos=listaAsientos;
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

    public ArrayList<Asientos> getListaAsientos() {
        return listaAsientos;
    }

    public void setListaAsientos(ArrayList<Asientos> listaAsientos) {
        this.listaAsientos = listaAsientos;
    }
    
    
    public static void cargarAsientos(ArrayList<Asientos> listaAsientos){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asientos a;
        for(String[] dato:datosAsientos){
            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listaAsientos.add(a);
        }
    }
    public void asignarAsiento(ArrayList<Asientos> listaAsientos){
        Avion.cargarAsientos(listaAsientos);
        for(Asientos asiento: listaAsientos){
            if(asiento.getDisponible().equals("S")){
                
            }else{
                break;
            }
            
        }
    }
}
