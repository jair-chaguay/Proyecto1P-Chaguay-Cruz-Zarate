/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Enums.disponibilidad;
import Sistema.*;
import Enums.*;
/**
 *
 * @author HP
 */
public class Asientos {
    private String codigoAvion;
    private String numAsiento;
    private disponibilidad disponible;

    public Asientos(String codigoAvion, String numAsiento, disponibilidad disponible) {
        this.codigoAvion = codigoAvion;
        this.numAsiento = numAsiento;
        this.disponible = disponible;
    }

    
    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public disponibilidad getDisponible() {
        return disponible;
    }

    public void setDisponible(disponibilidad disponible) {
        this.disponible = disponible;
    }
    
    
    
}
