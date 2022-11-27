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
    public static ArrayList<Asientos> listaAsientos=new ArrayList<>();
    
    //CONSTRUCTOR QUE CREARA OBJETOS AVION
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

    
    
 
    
    
}

