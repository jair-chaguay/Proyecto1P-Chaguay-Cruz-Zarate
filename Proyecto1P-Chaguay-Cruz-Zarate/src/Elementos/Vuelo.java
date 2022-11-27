/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import static Archivos.ManejoArchivos.LeerValidando;
import static Elementos.Avion.listaAsientos;
import Sistema.*;
import Enums.*;
import static Sistema.Sistema.listaItinerarios;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

    public  String getAsientoAleatorio() {
        return asientoAleatorio;
    }

    public void setAsientoAleatorio(String asientoAleatorio) {
        this.asientoAleatorio = asientoAleatorio;
    }
    
    
    @Override
    public String toString(){
        
        String x = "CODIGO: " + getCodigoVuelo() + "\nHORA SALIDA: ";
        for(Itinerarios i: listaItinerarios){
            if(i.getCod().equals(getCodigoItinerario())){
                x = x + i.getHoraSalida() + "\nHORA LLEGADA: " + i.getHoraLlegada() + "\nDURACION: " + i.getDuracion();
            }
        }
        
        return x = x + "\nAVION: " + getCodigoAvion() + "\nPRECIO " + getPrecio() + "\nCOSTO MILLAS: " + getPrecioMillas();
    }
    public static void cargarAsientos(){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asientos a;
        for(String[] dato:datosAsientos){
            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listaAsientos.add(a);
        }
    }
    public  void asignarAsiento(String codigoAvion){
        String a="";
        ArrayList<Asientos> asientosDisponibles=new ArrayList<>();
        Random r=new Random();
        
        for(Asientos asiento:listaAsientos){
            if(asiento.getDisponible().equals(disponibilidad.valueOf("S")) && (asiento.getCodigoAvion().equals(codigoAvion))){
                asientosDisponibles.add(asiento);   
            }      
        }
        for(Asientos AD:asientosDisponibles){
                int posicion= r.nextInt(asientosDisponibles.size());
                AD=asientosDisponibles.get(posicion);
                a=AD.getNumAsiento();
   
        }
        asientoAleatorio=a;
            
    }
}
