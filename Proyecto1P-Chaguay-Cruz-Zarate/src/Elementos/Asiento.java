/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Enums.disponibilidad;
/**
 *
 * @author HP
 */
public class Asiento {
    private String codigoAvion;
    private String numAsiento;
    private disponibilidad disponible;

    /**
     * Constructor que creara objetos de tipo Asiento
     * @param codigoAvion
     * @param numAsiento
     * @param disponible
     */
    public Asiento(String codigoAvion, String numAsiento, disponibilidad disponible) {
        this.codigoAvion = codigoAvion;
        this.numAsiento = numAsiento;
        this.disponible = disponible;
    }

    /**
     * Este metodo devuelve el codigo del avion
     * @return String
     */
    public String getCodigoAvion() {
        return codigoAvion;
    }

    /**
     * Metodo set para el codigo del avion
     * @param codigoAvion
     */
    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    /**
     * Este metodo devuelve el numero de asiento del avion
     * @return String
     */
    public String getNumAsiento() {
        return numAsiento;
    }

    /**
     * Metodo set para el numero de asiento
     * @param numAsiento
     */
    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    /**
     * Este metodo devuelve un dato de tipo Enum que muestra si el asiento esta disponible o no
     * @return disponibilidad (Enum)
     */
    public disponibilidad getDisponible() {
        return disponible;
    }

    /**
     * Metodo set para el estado de disponibilidad del asiento
     * @param disponible
     */
    public void setDisponible(disponibilidad disponible) {
        this.disponible = disponible;
    }
    
    
    
}
