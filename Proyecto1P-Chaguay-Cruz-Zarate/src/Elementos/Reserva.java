/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Enums.*;
import java.util.ArrayList;
import java.util.Random;
import static Archivos.ManejoArchivos.LeerValidando;
import static Elementos.Avion.listaAsientos;
/**
 *
 * @author HP
 */
public class Reserva {
   private String codigo;
    private static ArrayList<VueloReserva> vuelosReserva=new ArrayList<>();
    private String cliente;
    private String fecha; 
    private double valorPagar;
    private final Vuelo vuelo;
    
    //CONSTRUCTOR PARA CREAR OBJETOS RESERVA

    /**
     * Constructor que crea objetos de tipo Reserva
     * @param codigo
     * @param vuelo
     * @param cliente
     * @param fecha
     * @param valorPagar
     */
    public Reserva(String codigo, Vuelo vuelo, String cliente, String fecha, double valorPagar) {
        this.codigo = codigo;
        this.vuelo=vuelo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.valorPagar = valorPagar;
    }

    /**
     * Metodo toString que retorna en formato String las reservas
     * @return String
     */
    @Override
    public String toString(){
        return codigo+","+vuelo.getCodigoVuelo()+","+cliente+","+fecha+","+valorPagar;
        
    }

    /**
     * Metodo que retorna el codigo de la reserva
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo que retorna la lista de los vuelos reservados
     * @return ArrayList
     */
    public ArrayList<VueloReserva> getVuelosReserva() {
        return vuelosReserva;
    }

    /**
     *
     * @param vuelosReserva
     */
    public void setVuelosReserva(ArrayList<VueloReserva> vuelosReserva) {
        Reserva.vuelosReserva = vuelosReserva;
    }

    /**
     * Metodo que retorna el cliente que hizo la reserva
     * @return String
     */
    public String getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo que retorna la fecha de la reserva
     * @return String
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que retorna el valor a pagar por el vuelo
     * @return double
     */
    public double getValorPagar() {
        return valorPagar;
    }

    /**
     *
     * @param valorPagar
     */
    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    /**
     * Metodo que retorna el vuelo del que se hizo la reserva
     * @return Vuelo
     */
    public Vuelo getVuelo() {
        return vuelo;
    }
    
    /**
     * Metodo que asigna los asientos aleatorios para los pasajeros 
     * @return String
     */
    public static String AsignarAsientos(){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asiento a;
        int aleatorio=0;

        for(String[] dato:datosAsientos){
            a=new Asiento(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listaAsientos.add(a);
        }
        
        Random f= new Random();  
        double ale=(int)(Math.random()*listaAsientos.size());
        int asAle=(int)ale;
        if(listaAsientos.get(asAle).getDisponible().equals(disponibilidad.valueOf("S"))){
            String c=listaAsientos.get(asAle).getNumAsiento();
            return c;
        }else{
            return "No hay un asiento disponible";
        }                
        
    }


    
    
    
}
