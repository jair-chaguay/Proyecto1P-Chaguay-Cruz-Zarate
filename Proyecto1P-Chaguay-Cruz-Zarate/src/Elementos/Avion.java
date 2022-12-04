/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;


import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class Avion {
    private String codigoAvion;
    private int capacidad;
    public static ArrayList<Asiento> listaAsientos=new ArrayList<>();

    /**
     * Constructor que creara objetos de tipo Avion
     * @param codigoAvion
     * @param capacidad
     */
    public Avion(String codigoAvion,int capacidad){
        this.codigoAvion=codigoAvion;
        this.capacidad=capacidad;
        
    }
    
    /**
     * Este metodo devuelve el codigo del avion
     * @return String
     */
    public String getCodigoAvion() {
        return codigoAvion;
    }

    /**
     * Metodo set para el codigo del Avion
     * @param codigoAvion
     */
    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    /**
     * Este metodo devuelve la capacidad del avion
     * @return int
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Metodo set para la capacidad del avion
     * @param capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
   
}

