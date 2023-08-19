/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author HP
 */
public class Itinerario {
    private String cod;
    private String origenCiudad, destinoCiudad,duracion,horaSalida,horaLlegada;
    

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
     * Metodo set para el codigo del itinerario
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
     * Metodo set para la ciudad de origen del vuelo
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
     * Metodo set para la ciudad de destino del vuelo
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
     * Metodo set para la duracion del vuelo
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
     * Metodo set para la hora de salida del vuelo
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
     * Metodo set para la hora de llegada del vuelo
     * @param horaLlegada
     */
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    @Override
    public String toString(){
        return "HORA SALIDA: " + this.getHoraSalida() 
        + "\nHORA LLEGADA: " + this.getHoraLlegada() 
        + "\nDURACION: " + this.getDuracion();
    }
    
}
