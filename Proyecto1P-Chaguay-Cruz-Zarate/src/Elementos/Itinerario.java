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
public class Itinerario {
    private String cod;
    private String origenCiudad, destinoCiudad,duracion,horaSalida,horaLlegada;
    
    //CONSTRUCTOR PARA CREAR OBEJTOS DE TIPO ITINERARIO

    /**
     * Constructor que crea obejtos de tipo Itinerario
     * @param cod
     * @param origenCiudad
     * @param destinoCiudad
     * @param horaSalida
     * @param horaLlegada
     * @param duracion
     */
    public Itinerario(String cod,String origenCiudad,String destinoCiudad,String horaSalida,String horaLlegada,String duracion){
        this.cod = cod;
        this.origenCiudad = origenCiudad;
        this.destinoCiudad = destinoCiudad;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracion = duracion;
    }

    /**
     * Metodo que devuelve el codigo del itinerario
     * @return String
     */
    public String getCod() {
        return cod;
    }

    /**
     *
     * @param cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Meotodo que devuelve desde donde parte el vuelo
     * @return String
     */
    public String getOrigenCiudad() {
        return origenCiudad;
    }

    /**
     *
     * @param origenCiudad
     */
    public void setOrigenCiudad(String origenCiudad) {
        this.origenCiudad = origenCiudad;
    }

    /**
     * Metodo que devuelve hacia donde llega el vuelo
     * @return Stirng
     */
    public String getDestinoCiudad() {
        return destinoCiudad;
    }

    /**
     *
     * @param destinoCiudad
     */
    public void setDestinoCiudad(String destinoCiudad) {
        this.destinoCiudad = destinoCiudad;
    }

    /**
     * Metodo que devuelve la duracion del vuelo
     * @return Striing
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo que devuelve la hora de salida del vuelo
     * @return Stirng
     */
    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     *
     * @param horaSalida
     */
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Metodo que devuelve la hora de llegada del vuelo
     * @return String
     */
    public String getHoraLlegada() {
        return horaLlegada;
    }

    /**
     *
     * @param horaLlegada
     */
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    
}
