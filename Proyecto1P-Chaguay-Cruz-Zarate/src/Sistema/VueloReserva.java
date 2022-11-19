/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class VueloReserva {
    private Vuelo codigoVuelo;
    private tipoVuelo tipoVuelo;
    private tipoTarifa tarifa;
    private String asiento;
    private ArrayList<Vuelo> listaVuelos;

    public Vuelo getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(Vuelo codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
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

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    
}
