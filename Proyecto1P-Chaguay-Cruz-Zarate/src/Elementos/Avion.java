/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

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
    
    public void asignarAsiento(){
        
        
    }
}
