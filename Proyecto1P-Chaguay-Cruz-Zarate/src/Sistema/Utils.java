/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.Itinerario;
import Elementos.Vuelo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author robes
 */
public class Utils {
    /**
     * Metodo para generar un codigo aleatorio
     * @return
     */

    private static String generarCodigo(String cadenaSeleccion, int longitud){
        String cadena = "";
        Random r = new Random();
        int posicion;
        char caracter;
        for (int i = 0; i < longitud; i++) {
            posicion = r.nextInt(cadenaSeleccion.length());
            caracter = cadenaSeleccion.charAt(posicion);
            cadena += caracter;
        }
        return cadena;
    }

    /**
     * Metodo para generar el codigo de pago
     * @return
     */

    public static int crearCodigo() {
        return(Integer.parseInt(generarCodigo("9876543210",6)));
    }

    /**
     * Metodo para generar el codigo del vuelo reservado
     * @return
     */
    public static String crearCodigoReserva() {
        return generarCodigo("ABCDEFGHIJKLMNOPQRSTUVWXYZ",6);
    }
    
    /**
     * Metodo que retorna una lista de las ciudades de Origen de los vuelos
     * @return ArrayList
     */
    public static ArrayList<String> ciudadesOrigen(ArrayList<Itinerario> listaItinerarios) {
        ArrayList<String> origen = new ArrayList<>();

        for (Itinerario i : listaItinerarios) {
            if (!origen.contains(i.getOrigenCiudad())) {
                origen.add(i.getOrigenCiudad());
            }
        }
        return origen;
    }

    /**
     * Metodo que retorna una lista de las ciudades de destino de los vuelos
     * @param origen
     * @return
     */
    public static ArrayList<String> ciudadesDestino(String origen, ArrayList<Itinerario> listaItinerarios) {
        ArrayList<String> destino = new ArrayList<>();

        for (Itinerario i : listaItinerarios) {
            if ((!(destino.contains(i.getDestinoCiudad()))) && i.getOrigenCiudad().equals(origen)) {
                destino.add(i.getDestinoCiudad());
            }
        }
        return destino;
    }
    
        /**
     * Metodo que imprimi las tarifas disponibles
     */
    public static void mostrarTarifas() {
        System.out.println("\nTARIFAS");
        System.out.println("A. Economy(+0)\nB. Premium economy(+60)\nC. Premium business(+90)");
    }

    /**
     * Metodo que muestra al usuario las formas de pago disponibles
     */
    public static void mostrarformasPago() {
        System.out.println("\nFormas de Pago:");
        System.out.println("1. Tarjeta de Credito\n2. Millas\n");
    }
    
    public static String seleccionarCiudad(Scanner sc, ArrayList<String> ciudades, String mensaje){
        System.out.println("----"+mensaje.toUpperCase()+"----");
        for (int i = 0; i < ciudades.size(); i++) {
                System.out.println((i + 1) + ". " + ciudades.get(i));
            }
            System.out.print(String.format("Seleccione su lugar de %s: ",mensaje));
        int opcion = sc.nextInt();

        while (opcion>ciudades.size() || opcion <=0){
            System.out.println("Seleccion Invalida");
            opcion = sc.nextInt();

        }
        return ciudades.get(opcion - 1);
    }
    
    public static ArrayList<Vuelo> vuelosFiltrados(ArrayList<Itinerario> listaItinerarios, ArrayList<Vuelo> listaVuelos, String origen, String destino, String fecha) {
        ArrayList<Vuelo> lista = new ArrayList<>();
        for (int i = 0; i < listaItinerarios.size(); i++) {
            boolean b = listaItinerarios.get(i).getOrigenCiudad().equals(origen) && listaItinerarios.get(i).getDestinoCiudad().equals(destino) && (listaVuelos.get(i).getFechaSalida().equals(fecha));
            if (b) {
                lista.add(listaVuelos.get(i));
            }
        }
        return lista;
    }
}
