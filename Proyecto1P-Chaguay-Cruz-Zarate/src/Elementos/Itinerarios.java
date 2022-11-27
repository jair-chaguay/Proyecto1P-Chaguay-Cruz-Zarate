/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;
import Sistema.*;
import Enums.*;

/**
 *
 * @author HP
 */
public class Itinerarios {
    private String cod;
    private String origenCiudad, destinoCiudad,duracion,horaSalida,horaLlegada;
    
    //CONSTRUCTOR PARA CREAR OBEJTOS DE TIPO ITINERARIO
    public Itinerarios(String cod,String origenCiudad,String destinoCiudad,String horaSalida,String horaLlegada,String duracion){
        this.cod = cod;
        this.origenCiudad = origenCiudad;
        this.destinoCiudad = destinoCiudad;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracion = duracion;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getOrigenCiudad() {
        return origenCiudad;
    }

    public void setOrigenCiudad(String origenCiudad) {
        this.origenCiudad = origenCiudad;
    }

    public String getDestinoCiudad() {
        return destinoCiudad;
    }

    public void setDestinoCiudad(String destinoCiudad) {
        this.destinoCiudad = destinoCiudad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    
}
