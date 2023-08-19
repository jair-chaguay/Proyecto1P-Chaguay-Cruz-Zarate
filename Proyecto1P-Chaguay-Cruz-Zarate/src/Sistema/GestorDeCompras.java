/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.Reserva;
import Elementos.Vuelo;
import Elementos.VueloReserva;
import Enums.tipoTarifa;
import Enums.tipoVuelo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author robes
 */
public class GestorDeCompras {
    
    
    
    public VueloReserva generarReservaVuelo(String mensaje, ArrayList<Vuelo> listaVuelos,tipoVuelo tipo, Scanner sc){
        System.out.println(String.format("------Vuelos disponibles %s-----", mensaje.toUpperCase()));
        for (int i = 0; i < listaVuelos.size(); i++) {
            System.out.println("---------" + (i + 1) + "-----------");
            System.out.println(listaVuelos.get(i));
        }
        System.out.print(String.format("\nElija el vuelo de %s: ", mensaje));
        int ind = sc.nextInt();
        sc.nextLine();
        Vuelo vuelo = listaVuelos.get(ind - 1);
        Utils.mostrarTarifas();
        System.out.print(String.format("\nElije la tarifa para tu vuelo de %s: ",mensaje));
        String tarifaIda = sc.nextLine();
        tipoTarifa t;
        switch (tarifaIda) {
            case "A" -> {
                t = tipoTarifa.valueOf("A");
                double valorpago = vuelo.getPrecio() + 0;
            }
            case "B" -> {
                t = tipoTarifa.valueOf("B");
                double valorpago = vuelo.getPrecio() + 60;
            }
            case "C" -> {
                t = tipoTarifa.valueOf("C");
                double valorpago = vuelo.getPrecio() + 90;
            }
        }
        t = tipoTarifa.valueOf(tarifaIda);
        String asiento = Reserva.AsignarAsientos();
        return new VueloReserva(Utils.crearCodigo(), vuelo, tipo, t, asiento);
    }
    
    
}
