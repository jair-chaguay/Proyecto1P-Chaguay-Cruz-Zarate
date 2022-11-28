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
    private int codigo;
    private Vuelo codigoVueloReserva;
    private tipoVuelo tipoVuelo;
    private tipoTarifa tarifa;
    private String asiento;
    public static ArrayList<Vuelo> listaVuelos=new ArrayList<>();

    //CONSTRUCTOR PARA CREAR OBJETOS DE VUELORESERVA
    public VueloReserva(int codigo,Vuelo codigoVueloReserva, tipoVuelo tipoVuelo, tipoTarifa tarifa, String asiento) {
        this.codigo=codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    @Override
    public String toString(){
        return codigo+","+ codigoVueloReserva.getCodigoVuelo()+","+tipoVuelo+","+tarifa+","+asiento;
    }
    
    

    
}
