/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import Elementos.*;
import Archivos.*;
import static Elementos.VueloReserva.listaVuelos;
import static Sistema.Sistema.listaItinerarios;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Cliente extends Usuario {

    private String numTarjetaCredito;
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);
    Scanner sc = new Scanner(System.in);
    static ArrayList<Reserva> listaReservas = new ArrayList<>();

    /**
     * Constructor para crear objetos de tipoCliente
     *
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoCategoria
     */
    public Cliente(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);

        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.numTarjetaCredito = dato[1];
            }
        }
    }

    public void mostrarMenu(Scanner sc) {
        Sistema.mostrarMenuCliente();
        int opc = 0;
        while (opc != 3) {
            System.out.println("Ingrese opcion: ");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1:
                    this.comprarTickets();
                    Sistema.mostrarMenuCliente();
                    break;
                case 2:
                    this.consultarReservas();
                    Sistema.mostrarMenuCliente();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    /**
     * Metodo que retorna el numero de tarjeta de credito del cliente en formato
     * String
     *
     * @return String
     */
    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    /**
     * Metodo set para el numero de tarjeta de credito del cliente
     *
     * @param numTarjetaCredito
     */
    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }

    /**
     * Metodo que dara lugar a la opcion de comprar tickets de los clientes
     */
    public void comprarTickets() {

        String ciudadOrigen = Utils.seleccionarCiudad(sc, Utils.ciudadesOrigen(listaItinerarios), "origen");
        //MOSTRAR LAS CIUDADES A DONDE PODRAN LOS USUARIOS
        String ciudadDestino = Utils.seleccionarCiudad(sc, Utils.ciudadesDestino(ciudadOrigen, listaItinerarios), "destino");

        boolean comprar = true;
        while (comprar) {
            System.out.println("---------------------");
            System.out.println("INGRESE LA FECHA CON FORMATO dd/mm/yyyy");
            System.out.print("Fecha de Salida: ");
            String fechaSalida = sc.nextLine();
            System.out.print("Fecha de Retorno: ");
            String fechaRetorno = sc.nextLine();

            ArrayList<Vuelo> listaIda = Utils.vuelosFiltrados(listaItinerarios, listaVuelos, ciudadOrigen, ciudadDestino, fechaSalida);
            ArrayList<Vuelo> listaRetorno = Utils.vuelosFiltrados(listaItinerarios, listaVuelos, ciudadDestino, ciudadOrigen, fechaRetorno);

            System.out.println("\n******PASO 1*****\n*****************");

            GestorDeCompras gdc = new GestorDeCompras();
            if (!listaIda.isEmpty()) {
                VueloReserva ReservaIda = gdc.generarReservaVuelo("ida", listaIda, tipoVuelo.IDA, sc);
                VueloReserva ReservaVuelta = gdc.generarReservaVuelo("retorno", listaRetorno, tipoVuelo.VUELTA, sc);
                GestorDePagos gdp = new GestorDePagos(listaReservas, this);
                comprar = false;

            } else {
                System.out.println("No hay vuelos disponibles");
            }   
        }
    }

    /**
     * Metodo que muestra las reservas correspondientes para cada cliente
     */
    @Override
    public void consultarReservas() {
        int numero = (int) (Math.random() * 10 + 1);
        for (Reserva dato : listaReservas) {
            if (dato.getCliente().equals(nombres)) {
                System.out.println("NOMBRES: " + dato.getCliente());
                System.out.println("CEDULA: " + cedula);
                System.out.println("VUELO:" + dato.getVuelo().getCodigoVuelo());
                for (Itinerario i : listaItinerarios) {
                    if (i.getCod().equals(dato.getVuelo().getCodigoItinerario())) {
                        System.out.println("HORA SALIDA: " + i.getHoraSalida());
                        System.out.println("HORA LLEGADA: " + i.getHoraLlegada());
                        System.out.println("AVION: " + dato.getVuelo().getCodigoAvion());
                        System.out.println("PUERTA DE EMBARQUE: " + numero);
                        System.out.println("---------------------");
                    }
                }
            } else {
                System.out.println("Usted no tiene una reserva.");
            }

        }

    }
}
