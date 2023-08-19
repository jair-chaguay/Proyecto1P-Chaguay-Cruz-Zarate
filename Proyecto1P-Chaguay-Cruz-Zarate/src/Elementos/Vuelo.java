/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import static Sistema.Sistema.listaItinerarios;


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
    private  String asientoAleatorio;


    /**
     * Constructor que crea objetos de tipo Vuelo
     * @param codigoVuelo
     * @param codigoAvion
     * @param fechaSalida
     * @param fechaLlegada
     * @param codigoItinerario
     * @param precio
     * @param precioMillas
     */
    public Vuelo(String codigoVuelo, String codigoAvion, String fechaSalida, String fechaLlegada, String codigoItinerario, double precio, int precioMillas) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAvion = codigoAvion;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.codigoItinerario = codigoItinerario;
        this.precio = precio;
        this.precioMillas = precioMillas;
    }
    
    /**
     * Metodo que retorna el codigo del avion
     * @return String
     */
    public String getCodigoAvion() {
        return codigoAvion;
    }

    /**
     * Metodo set para el codigo del avion
     * @param avion
     */
    public void setCodigoAvion(String avion) {
        this.codigoAvion = avion;
    }

    /**
     * Metodo que retorna el precio del vuelo
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo set para el precio del vuelo
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo que retorna el codigo del itinerario
     * @return Stirng
     */
    public String getCodigoItinerario() {
        return codigoItinerario;
    }

    /**
     * Metodo set para el codigo del Itinerario
     * @param codigoItinerario
     */
    public void setCodigoItinerario(String codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    /**
     * Metodo que retorna la fecha de salida del vuelo
     * @return String
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Metodo set para la fecha de salida del vuelo
     * @param fechaSalida
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Metodo que retorna la fecha de llegada del vuelo
     * @return String
     */
    public String getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Metodo set para la fehca de llegada del vuelo
     * @param fechaLlegada
     */
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Metodo que retorna el precio del vuelo en millas
     * @return int
     */
    public int getPrecioMillas() {
        return precioMillas;
    }

    /**
     * Metodo set para el precio en millas del vuelo
     * @param precioMillas
     */
    public void setPrecioMillas(int precioMillas) {
        this.precioMillas = precioMillas;
    }

    /**
     * Metodo que retorna el codigo del vuelo
     * @return String
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**
     * Metodo set para el codigo del vuelo
     * @param codigoVuelo
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**
     * Metodo que retorna el asiento designado para el pasajero 
     * @return String
     */
    public  String getAsientoAleatorio() {
        return asientoAleatorio;
    }

    /**
     * Metodo set para el asiento aleatorio
     * @param asientoAleatorio
     */
    public void setAsientoAleatorio(String asientoAleatorio) {
        this.asientoAleatorio = asientoAleatorio;
    }
    
    //METODO TOSTRING PARA MOSTRAR LOS VUELOS

    /**
     * Metodo que retorna la descripcion del vuelo en formato String, se lo llama a la hora de mostrar los vuelos a los clientes
     * @return String
     */
    @Override
    public String toString(){
        
        String x = "CODIGO: " + getCodigoVuelo();
        for(Itinerario i: listaItinerarios){
            if(i.getCod().equals(getCodigoItinerario())){
                x = x + "\n" + i.toString();
            }
        }
        
        return x = x + "\nAVION: " + getCodigoAvion() + "\nPRECIO " + getPrecio() + "\nCOSTO MILLAS: " + getPrecioMillas();
    }

}
