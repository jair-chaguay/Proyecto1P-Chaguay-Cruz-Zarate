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

    /**
     * Metodo que retorna el numero de tarjeta de credito del cliente en formato String
     * @return String
     */
    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    /**
     * Metodo set para el numero de tarjeta de credito del cliente
     * @param numTarjetaCredito
     */
    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }



    /**
     * Metodo que dara lugar a la opcion de comprar tickets de los clientes
     */
    public void comprarTickets() {

        String ciudadOrigen = "";
        boolean comprar = true;
        //MOSTRAR LAS CIUDADES DE DONDE PARTIRAN LOS USUARIOS
        while (comprar) {
            int opcion = 0;
            int cont = 0;
            ArrayList<String> ciudOrigen = ciudadesOrigen();
            System.out.println("----ORIGEN----");
            for (int i = 0; i < ciudOrigen.size(); i++) {
                System.out.println((i + 1) + ". " + ciudOrigen.get(i));
            }
            System.out.print("Seleccione su punto de partida: ");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion <= ciudOrigen.size() && !(opcion <= 0)) {

                ciudadOrigen = ciudOrigen.get(opcion - 1);

                comprar = false;
            } else {
                System.out.println("Seleccion Invalida");

            }

        }
        //MOSTRAR LAS CIUDADES A DONDE PODRAN LOS USUARIOS
        comprar = true;
        String ciudadDestino = "";

        while (comprar) {
            int cont = 0;
            int opcion = 0;
            ArrayList<String> ciudDestino = ciudadesDestino(ciudadOrigen);
            System.out.println("----DESTINO----");
            for (String i : ciudDestino) {
                cont++;
                System.out.println(cont + ". " + i);
            }

            System.out.print("Seleccione el punto de llegada: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion <= cont && !(opcion <= 0)) {
                ciudadDestino = ciudDestino.get(cont - 1);
                comprar = false;
            } else {
                System.out.println("Seleccion Invalida");
            }

        }
        comprar = true;
        while (comprar) {
            System.out.println("---------------------");
            System.out.println("INGRESE LA FECHA CON FORMATO dd/mm/yyyy");
            System.out.print("Fecha de Salida: ");
            String fechaSalida = sc.nextLine();
            System.out.print("Fecha de Retorno: ");
            String fechaRetorno = sc.nextLine();

            ArrayList<Vuelo> listaIda = vuelosFiltrados(ciudadOrigen, ciudadDestino, fechaSalida);
            ArrayList<Vuelo> listaRetorno = vuelosFiltrados(ciudadDestino, ciudadOrigen, fechaRetorno);

            System.out.println("\n******PASO 1*****\n*****************");
            if (!listaIda.isEmpty()) {
                System.out.println("------Vuelos disponibles IDA-----");
                for (int i = 0; i < listaIda.size(); i++) {
                    System.out.println("---------" + (i + 1) + "-----------");
                    System.out.println(listaIda.get(i));

                }
                System.out.print("\nElija el vuelo de ida: ");
                int ind = sc.nextInt();
                sc.nextLine();
                Vuelo vueloIda = listaIda.get(ind - 1);

                Cliente.mostrarTarifas();
                System.out.print("\nElije la tarifa para tu vuelo de ida: ");
                String tarifaIda = sc.nextLine();
                tipoTarifa t;
                switch (tarifaIda) {
                    case "A" -> {
                        t = tipoTarifa.valueOf("A");
                        double valorpago = vueloIda.getPrecio() + 0;
                    }
                    case "B" -> {
                        t = tipoTarifa.valueOf("B");
                        double valorpago = vueloIda.getPrecio() + 60;
                    }
                    case "C" -> {
                        t = tipoTarifa.valueOf("C");
                        double valorpago = vueloIda.getPrecio() + 90;
                    }
                }
                t = tipoTarifa.valueOf(tarifaIda);

                System.out.println("------Vuelos disponibles RETORNO-----");
//                ArrayList<Vuelo> x=Cliente.obtenerVuelosRetorno(fechaRetorno, listaRetorno);
                for (int i = 0; i < listaRetorno.size(); i++) {
                    System.out.println("---------" + (i + 1) + "-----------");
                    System.out.println(listaRetorno.get(i));

                }
                System.out.print("\nElija el vuelo de retorno: ");
                int ind2 = sc.nextInt();
                sc.nextLine();
                Vuelo vueloRetorno = listaIda.get(ind2 - 1);

                Cliente.mostrarTarifas();
                System.out.print("\nElije la tarifa para tu vuelo de retorno: ");
                String tarifaRetorno = sc.nextLine();
                tipoTarifa t2;
                switch (tarifaRetorno) {
                    case "A" -> {
                        t2 = tipoTarifa.valueOf("A");
                        double valorpago = vueloIda.getPrecio() + 0;
                    }
                    case "B" -> {
                        t2 = tipoTarifa.valueOf("B");
                        double valorpago = vueloIda.getPrecio() + 60;
                    }
                    case "C" -> {
                        t2 = tipoTarifa.valueOf("C");
                        double valorpago = vueloIda.getPrecio() + 90;
                    }
                }
                t2 = tipoTarifa.valueOf(tarifaRetorno);

                System.out.println("\n******PASO 2*****\n*****************");
                System.out.println("-----------ASIENTOS----------");
                String asiento1 = Reserva.AsignarAsientos();
                String asiento2 = Reserva.AsignarAsientos();

                System.out.println("Para tu vuelo de ida " + vueloIda.getCodigoVuelo() + " se te ha asignado el asiento: " + asiento1);

                System.out.println("Para tu vuelo de retorno " + vueloRetorno.getCodigoVuelo() + " se te ha asignado el asiento: " + asiento2);
                //CREACION DE VUELO RESERVA
                //CREACION DE TXT DE VUELO RESERVA

                VueloReserva ReservaIda = new VueloReserva(crearCodigo(), vueloIda, tipoVuelo.IDA, t, asiento1);
                VueloReserva ReservaRetorno = new VueloReserva(crearCodigo(), vueloRetorno, tipoVuelo.VUELTA, t2, asiento2);
                
                             

                ManejoArchivos.EscribirArchivo("vuelosReserva.txt", ReservaIda.toString());
                ManejoArchivos.EscribirArchivo("vuelosReserva.txt", ReservaRetorno.toString());

                System.out.println("\n******PASO 3*****\n*****************");
                System.out.println("-----------DATOS PASAJERO----------");
                Paso3();
                System.out.print("\nDesea guardar los datos del pasajero y continuar al pago(s/n)? ");
                String sn = sc.nextLine();
                if (sn.equalsIgnoreCase("s")) {
                    System.out.println("Has completado el paso 3");

                } else {
                    System.out.println("Complete los datos que le faltan para ir al paso 4");
                    Paso3();
                }
                System.out.println("\n******PASO 4*****\n*****************");
                System.out.println("--------------PAGO---------");
                System.out.println("Descripcion:");
                double valorpago = vueloIda.getPrecio() + vueloRetorno.getPrecio();
                System.out.println("Subtotal: " + valorpago);
                if (tipoCategoria.equals(tipoCategoria.valueOf("S"))) {
                    System.out.println("Descuento:0% (cliente ESTANDAR)");
                    System.out.println("Iva: " + valorpago * 12 / 100);
                    double total = valorpago + valorpago * 12 / 100;
                    System.out.println("TOTAL A PAGAR: " + total);

                    System.out.println("Forma de pago: Tarjeta de Credito");
                    System.out.print("Ingrese el numero de T/C: ");
                    String tarjeta = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Estas seguro de pagar el vuelo?(s/n)");
                    String respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        Reserva pago = Pagar(tarjeta, total, ReservaIda, ReservaRetorno);

                        System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago.getCodigo());
                    } else {
                        System.out.println("No has finalizado tu compra.");
                    }

                } else if (tipoCategoria.equals(tipoCategoria.valueOf("V"))) {
                    for (String[] dato : datosClientes) {
                        if (cedula.equals(dato[0]) && dato[2].equals("GOLDEN PASS")) {
                            System.out.println("Descuento:20%  (cliente vip GOLDEN PASS)");
                            double valorDescuento = valorpago - valorpago * 20 / 100;
                            System.out.println("Total: " + valorDescuento);
                            valorpago = valorDescuento;
                            System.out.println("Iva: " + valorpago * 12 / 100);
                            double total = valorpago + valorpago * 12 / 100;
                            System.out.println("TOTAL A PAGAR: " + total);
                            mostrarformasPago();
                            System.out.println("Elige tu forma de pago: ");
                            int opcion = sc.nextInt();
                            if (opcion == 1) {
                                System.out.print("Ingrese el numero de T/C: ");
                                String tarjeta = sc.nextLine();
                                sc.nextLine();

                                System.out.println("Estas seguro de pagar el vuelo?(s/n)");
                                String opc = sc.nextLine();
                                if (opc.equalsIgnoreCase("s")) {

                                    Reserva pago = Pagar(tarjeta, total, ReservaIda, ReservaRetorno);

                                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago.getCodigo());
                                } else {
                                    System.out.println("Tu pago no se ha completado.");
                                }
                            } else if (opcion == 2) {

                                int millas = Integer.parseInt(dato[3]);
                                String pago = Pagar(millas,total, ReservaIda, ReservaRetorno);
                                if(pago.equals("Su pago no se ha completado")){
                                    System.out.println("Su pago no se ha completado");
                                }else{

                                System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago);
                                }
                                
                            }

                        } else if (cedula.equals(dato[0]) && dato[2].equals("PLATINUM PASS")) {
                            System.out.println("Descuento:30%  (cliente vip PLATINUM PASS)");
                            double valorDescuento = valorpago - valorpago * 30 / 100;
                            System.out.println("Total: " + valorDescuento);
                            valorpago = valorDescuento;
                            System.out.println("Iva: " + valorpago * 12 / 100);
                            double total = valorpago + valorpago * 12 / 100;
                            System.out.println("TOTAL A PAGAR: " + total);
                            mostrarformasPago();
                            System.out.print("Elige tu forma de pago: ");
                            int opcion = sc.nextInt();
                            if (opcion == 1) {
                                System.out.print("Ingrese el numero de T/C: ");
                                String tarjeta = sc.nextLine();
                                sc.nextLine();
                                System.out.print("Estas seguro de pagar el vuelo?(s/n)");
                                String opc = sc.nextLine();
                                if (opc.equalsIgnoreCase("s")) {

                                    Reserva pago = Pagar(tarjeta, total, ReservaIda, ReservaRetorno);

                                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago.getCodigo());
                                } else {
                                    System.out.println("Tu pago no se ha completado.");
                                }

                            } else if (opcion == 2) {
                                int millas = Integer.parseInt(dato[3]);
                                int valorMillas = vueloIda.getPrecioMillas() + vueloRetorno.getPrecioMillas();
                                String pago = Pagar(millas,total, ReservaIda, ReservaRetorno);
                                
                                if(pago.equals("Su pago no se ha completado")){
                                    System.out.println("Su pago no se ha completado");
                                }else{
                                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago);
                                }
                                

                            }

                        }

                    }

                }

                comprar = false;
            } else {
                System.out.println("No hay vuelos disponibles");
            }

        }
    }


    /**
     * Metodo para generar el codigo de pago
     * @return
     */
    public int crearCodigo() {
        String opciones = "1234567890";
        String cadena = "";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int posicion = r.nextInt(opciones.length());
            char caracter = opciones.charAt(posicion);
            cadena += caracter;
        }
        int valor = Integer.parseInt(cadena);
        return valor;

    }

    /**
     * Metodo para generar el codigo del vuelo reservado
     * @return
     */
    public String crearCodigoReserva() {

        String opciones = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int posicion = r.nextInt(opciones.length());
            char caracter = opciones.charAt(posicion);
            cadena += caracter;
        }
        String valor = cadena;
        return valor;
    }

    /**
     * Metodo que retorna una lista de las ciudades de Origen de los vuelos
     * @return ArrayList
     */
    public ArrayList<String> ciudadesOrigen() {
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
    public ArrayList<String> ciudadesDestino(String origen) {
        ArrayList<String> destino = new ArrayList<>();

        for (Itinerario i : listaItinerarios) {
            if ((!(destino.contains(i.getDestinoCiudad()))) && i.getOrigenCiudad().equals(origen)) {
                destino.add(i.getDestinoCiudad());
            }
        }
        return destino;
    }

    /**
     * Metodo que retorna una lista de los vuelos filtrados de acuerdo a las ciudades de donde quiere partir y llegar el cliente, ademas de la fecha
     * @param origen
     * @param destino
     * @param fecha
     * @return ArrayList
     */
    public ArrayList<Vuelo> vuelosFiltrados(String origen, String destino, String fecha) {
        ArrayList<Vuelo> lista = new ArrayList<>();

        for (int i = 0; i < listaItinerarios.size(); i++) {
            boolean b = listaItinerarios.get(i).getOrigenCiudad().equals(origen) && listaItinerarios.get(i).getDestinoCiudad().equals(destino) && (listaVuelos.get(i).getFechaSalida().equals(fecha));
            if (b) {
                lista.add(listaVuelos.get(i));
            }
        }
        return lista;
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

    /**
     * Metodo que imprimi los datos del pasajero, luego es llamado en el metodo comprarTickets
     */
    public void Paso3() {
        System.out.println("\nCompleta los datos de pasajero:\nNombres: " + nombres + "\nCorreo: " + correo);
        System.out.print("Fecha de nacimiento: ");
        String fn = sc.nextLine();
        System.out.print("Genero (1. Masculino - 2. Femenino): ");
        int genero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();
        System.out.print("Tipo de documento (1. Cedula - 2. Pasaporte): ");
        int doc = sc.nextInt();
        sc.nextLine();
        if (doc == 1) {
            System.out.println("Numero del documento: " + cedula);
        } else {
            System.out.print("Numero del documento: ");
            String numDoc = sc.nextLine();
        }

    }

    // METDO PARA PAGAR CON TARJETA DE CREDITO

    /**
     * Metodo para realizar los pagos que crea las reservas y los pagos y los escribe en el archivo correspondiente, luego es llamado en el metodo comprarTickets
     * @param numTarjetaCredito
     * @param valor
     * @param vuelo
     * @param vuelo2
     * @return Reserva
     */
    public Reserva Pagar(String numTarjetaCredito, double valor, VueloReserva vuelo, VueloReserva vuelo2) {
        double valorTC = valor + (valor * 10 / 100);
        Reserva r = new Reserva(crearCodigoReserva(), vuelo.getCodigoVueloReserva(), nombres, vuelo.getCodigoVueloReserva().getFechaSalida(), valorTC);
        Reserva r2 = new Reserva(crearCodigoReserva(), vuelo2.getCodigoVueloReserva(), nombres, vuelo2.getCodigoVueloReserva().getFechaSalida(), valorTC);
        listaReservas.add(r);
        listaReservas.add(r2);

        //CREACION DE OBJETO RESERVA
        ManejoArchivos.EscribirArchivo("reservas.txt", r.toString());
        //CREACION DE OBJETO PAGO
        Pago p = new Pago(crearCodigo(), r.getCodigo(), formaPago.TC, valorTC);

        ManejoArchivos.EscribirArchivo("pagos.txt", p.toString());

        return r;
    }

    //METODO PARA PAGAR CON MILLAS

    /**
     * Metodo para pagar con millas, llamado luego en el metodo comprarTickets
     * @param millas
     * @param precio
     * @param vuelo
     * @param vuelo2
     * @return String
     */
    public String Pagar(int millas, double precio,VueloReserva vuelo, VueloReserva vuelo2) {
        int valor = vuelo.getCodigoVueloReserva().getPrecioMillas() + vuelo2.getCodigoVueloReserva().getPrecioMillas();
        if (millas >= valor) {
            Reserva r = new Reserva(crearCodigoReserva(), vuelo.getCodigoVueloReserva(), nombres, vuelo.getCodigoVueloReserva().getFechaSalida(), valor);
            Reserva r2 = new Reserva(crearCodigoReserva(), vuelo2.getCodigoVueloReserva(), nombres, vuelo2.getCodigoVueloReserva().getFechaSalida(), valor);
            listaReservas.add(r);
            listaReservas.add(r2);
            //CREACION DE OBJETO RESERVA
            ManejoArchivos.EscribirArchivo("reservas.txt", r.toString());
            ManejoArchivos.EscribirArchivo("reservas.txt", r2.toString());
            
            //CREACION DE OBJETO PAGO
            Pago p = new Pago(crearCodigo(), r.getCodigo(), formaPago.M, valor);

            ManejoArchivos.EscribirArchivo("pagos.txt", p.toString());
            return r.getCodigo();
        } else {
            System.out.println("No tiene millas suficientes para su pago");
            sc.nextLine();
            System.out.println("Desea intentar con tarjeta de credito?(s/n)");
            String opc = sc.nextLine();
          
            if(opc.equalsIgnoreCase("s")){
                double valorTC = precio + (precio * 10 / 100);
                Pagar(numTarjetaCredito,precio,vuelo,vuelo2);
                Reserva r = new Reserva(crearCodigoReserva(), vuelo.getCodigoVueloReserva(), nombres, vuelo.getCodigoVueloReserva().getFechaSalida(), valorTC);
                Reserva r2 = new Reserva(crearCodigoReserva(), vuelo2.getCodigoVueloReserva(), nombres, vuelo2.getCodigoVueloReserva().getFechaSalida(), valorTC);
                return r.getCodigo();
                
            }else{
                return "Su pago no se ha completado";
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
