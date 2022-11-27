/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Sistema.*;
import Enums.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import Elementos.Asientos;
import static Archivos.ManejoArchivos.LeerValidando;
import static Elementos.Avion.listaAsientos;
/**
 *
 * @author HP
 */
public class Reserva {
   private String codigo;
    private ArrayList<VueloReserva> vuelosReserva=new ArrayList<>();
    private String cliente;
    private String fecha; 
    private double valorPagar;
    private final Vuelo vuelo;
    public Reserva(String codigo, Vuelo vuelo, String cliente, String fecha, double valorPagar) {
        this.codigo = codigo;
        this.vuelo=vuelo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.valorPagar = valorPagar;
    }
    @Override
    public String toString(){
        return codigo+","+vuelo+","+cliente+","+fecha+","+valorPagar;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<VueloReserva> getVuelosReserva() {
        return vuelosReserva;
    }

    public void setVuelosReserva(ArrayList<VueloReserva> vuelosReserva) {
        this.vuelosReserva = vuelosReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
    
//    public void crearCodigoReserva(){
//        
//        String opciones="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String cadena="";
//        Random r=new Random();
//        for(int i=0; i<6;i++){
//            int posicion= r.nextInt(opciones.length());
//            char caracter=opciones.charAt(posicion);
//            cadena+=caracter;
//        }
//        String valor=cadena;
//        codigo=valor;
//    }
    
    public static void AsignarAsientos(){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asientos a;
        int aleatorio=0;

        for(String[] dato:datosAsientos){
            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listaAsientos.add(a);
        }
        
        Random f= new Random();  
        double ale=(int)(Math.random()*listaAsientos.size());
        int asAle=(int)ale;
        if(listaAsientos.get(asAle).equals("S")){
            System.out.println(listaAsientos.get(asAle).getNumAsiento());
        }else{
            System.out.println("No hay un asiento disponible");
        }                
        
    }
    
    
    
}
