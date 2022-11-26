/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Sistema.*;
import Enums.*;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Vuelo {
    private String codigoVuelo;
    private String codigoAvion;
    private String fechaSalida;
    private String fechaLlegada;
    private String codigoItinerario;
    private double precio;
    private int precioMillas;

    public Vuelo(String codigoVuelo, String codigoAvion, String fechaSalida, String fechaLlegada, String codigoItinerario, double precio, int precioMillas) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAvion = codigoAvion;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.codigoItinerario = codigoItinerario;
        this.precio = precio;
        this.precioMillas = precioMillas;
    }
    
    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String avion) {
        this.codigoAvion = avion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigoItinerario() {
        return codigoItinerario;
    }

    public void setCodigoItinerario(String codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getPrecioMillas() {
        return precioMillas;
    }

    public void setPrecioMillas(int precioMillas) {
        this.precioMillas = precioMillas;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }
    
    
}
