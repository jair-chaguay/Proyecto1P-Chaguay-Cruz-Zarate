package Elementos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Enums.*;
import java.util.ArrayList;

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

    /**
     *
     */
    public static ArrayList<Vuelo> listaVuelos=new ArrayList<>();

    /**
     * Constructor que crea objetos de tipo VueloReserva
     * @param codigo
     * @param codigoVueloReserva
     * @param tipoVuelo
     * @param tarifa
     * @param asiento
     */
    public VueloReserva(int codigo,Vuelo codigoVueloReserva, tipoVuelo tipoVuelo, tipoTarifa tarifa, String asiento) {
        this.codigo=codigo;
        this.codigoVueloReserva = codigoVueloReserva;
        this.tipoVuelo = tipoVuelo;
        this.tarifa = tarifa;
        this.asiento = asiento;
    }

    /**
     * Metodo que retorna el codigo del vuelo de Reserva
     * @return Vuelo
     */
    public Vuelo getCodigoVueloReserva() {
        return codigoVueloReserva;
    }

    /**
     * Metodo set para el codigo del vuelo reservado
     * @param codigoVueloReserva
     */
    public void setCodigoVueloReserva(Vuelo codigoVueloReserva) {
        this.codigoVueloReserva = codigoVueloReserva;
    }

    /**
     * Metodo que retorna si en formato enum si el vuelo reservado es de ida o vuelta
     * @return tipoVuelo(Enum)
     */
    public tipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    /**
     * Metodo set para el tipoVuelo
     * @param tipoVuelo
     */
    public void setTipoVuelo(tipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    /**
     * Metodo que retorna en formato enum el tipo de tarifa que tiene el vuelo reservado 
     * @return tarifa(Enum)
     */
    public tipoTarifa getTarifa() {
        return tarifa;
    }

    /**
     * Metodo set para el tipo de tarifa
     * @param tarifa
     */
    public void setTarifa(tipoTarifa tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Metodo que devuelve el asiento qdel vuelo reservado
     * @return String
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Metodo set para el asiento del avion
     * @param asiento
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * Metodo que devuelve el codigo del vuelo reservado
     * @return int
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo set para el codigo del vuelo reservado
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Metodo que retorna en formato String la descripcion de los vuelos reservados
     * @return String
     */
    @Override
    public String toString(){
        return codigo+","+ codigoVueloReserva.getCodigoVuelo()+","+tipoVuelo+","+tarifa+","+asiento;
    }
    
    

    
}
