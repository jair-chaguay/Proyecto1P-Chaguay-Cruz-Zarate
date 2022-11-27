package Elementos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import static Archivos.ManejoArchivos.LeerValidando;
import Sistema.*;
import Enums.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
public class VueloReserva {
    private Vuelo codigoVueloReserva;
    private tipoVuelo tipoVuelo;
    private tipoTarifa tarifa;
    private String asiento;
    public static ArrayList<Vuelo> listaVuelos=new ArrayList<>();

    public VueloReserva(Vuelo codigoVueloReserva, tipoVuelo tipoVuelo, tipoTarifa tarifa, String asiento) {
        this.codigoVueloReserva = codigoVueloReserva;
        this.tipoVuelo = tipoVuelo;
        this.tarifa = tarifa;
        this.asiento = asiento;
    }

    
    public Vuelo getCodigoVueloReserva() {
        return codigoVueloReserva;
    }

    public void setCodigoVueloReserva(Vuelo codigoVueloReserva) {
        this.codigoVueloReserva = codigoVueloReserva;
    }

    public tipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(tipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public tipoTarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(tipoTarifa tarifa) {
        this.tarifa = tarifa;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    
    
    @Override
    public String toString(){
        return codigoVueloReserva+","+tipoVuelo+","+tarifa+","+asiento;
    }
    public static void cargarVuelos(){
        ArrayList<String[]> datosVuelo=LeerValidando("vuelos.txt",true);
        Vuelo v;
        for(String[] dato:datosVuelo){
            v=new Vuelo(dato[0],dato[1],dato[2],dato[3],dato[4],Integer.valueOf(dato[5]),Integer.valueOf(dato[6]));
            listaVuelos.add(v);
        }
    }
    private void crearCodigo(){
        
        String opciones="1234567890";
        String cadena="";
        Random r=new Random();
        for(int i=0; i<6;i++){
            int posicion= r.nextInt(opciones.length());
            char caracter=opciones.charAt(posicion);
            cadena+=caracter;
        }
//        int valor=Integer.parseInt(cadena);
//        codigoVueloReserva=valor;
    }
    
}
