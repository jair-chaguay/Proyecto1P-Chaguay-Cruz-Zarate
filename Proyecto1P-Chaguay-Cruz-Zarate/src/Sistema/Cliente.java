/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import Elementos.*;
import Archivos.*;
import static Elementos.Avion.listaAsientos;
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

    //CONSTRUCTOR PARA CREAR CLIENTES
    public Cliente(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);

        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.numTarjetaCredito = dato[1];
            }
        }
    }

    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }

    //TOSTRING PARA MOSTRAR LOS CLIENTES
    @Override
    public String toString() {
        toString();
        return "Num T/C: " + numTarjetaCredito;
    }

    @Override
    public void consultarReservas() {
        ArrayList<VueloReserva> vuelosReserva = null;
        for (int i = 0; i < vuelosReserva.size(); i++) {
            String vuelo = vuelosReserva.get(i).getCodigoVueloReserva().getCodigoVuelo();
            System.out.println("--------------------------------------");
            System.out.println("VUELO: " + vuelo);
            int cantidad = -1;
            for (int j = 0; j < vuelosReserva.size(); j++) {
                if (vuelo.equals(vuelosReserva.get(j).getCodigoVueloReserva().getCodigoVuelo())) {
                    cantidad++;

                }
                System.out.println("CANTIDAD RESERVADOS: " + cantidad);
                System.out.println("--------------------------------------");

            }

        }        
    }

    //MEOTOD PARA COMPRAR TICKETS
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
                    case "A":
                        t = tipoTarifa.valueOf("A");
                        double valorpago=vueloIda.getPrecio()+0;
                        
                        break;
                    case "B":
                        t = tipoTarifa.valueOf("B");
                        valorpago=vueloIda.getPrecio()+60;
                        break;
                    case "C":
                        t = tipoTarifa.valueOf("C");
                        valorpago=vueloIda.getPrecio()+90;
                        break;
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
                    case "A":
                        t2 = tipoTarifa.valueOf("A");
                        double valorpago=vueloIda.getPrecio()+0;
                        
                        break;
                    case "B":
                        t2 = tipoTarifa.valueOf("B");
                        valorpago=vueloIda.getPrecio()+60;
                        break;
                    case "C":
                        t2 = tipoTarifa.valueOf("C");
                        valorpago=vueloIda.getPrecio()+90;
                        break;
                }
                t2 = tipoTarifa.valueOf(tarifaRetorno);

                System.out.println("\n******PASO 2*****\n*****************");
                System.out.println("-----------ASIENTOS----------");
                System.out.println(vueloIda);
                System.out.println(" ");
                System.out.println(vueloRetorno);
                System.out.println("Para tu vuelo de ida " + vueloIda.getCodigoVuelo() + " se te ha asignado el asiento: " + Reserva.AsignarAsientos());

                System.out.println("Para tu vuelo de retorno " + vueloRetorno.getCodigoVuelo() + " se te ha asignado el asiento: " + Reserva.AsignarAsientos());
                //CREACION DE VUELO RESERVA
                //CREACION DE TXT DE VUELO RESERVA

                VueloReserva ReservaIda = new VueloReserva(crearCodigo(), vueloIda, tipoVuelo.IDA, t, vueloIda.getAsientoAleatorio());
                VueloReserva ReservaRetorno = new VueloReserva(crearCodigo(), vueloRetorno, tipoVuelo.VUELTA, t2, vueloRetorno.getAsientoAleatorio());

                ManejoArchivos.EscribirArchivo("vuelosReserva.txt", "codigoVueloReserva,codigoVuelo,tipo,tarifa,asiento");
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
                    System.out.println("Ingrese el numero de T/C: ");
                    String tarjeta = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Estas seguro de pagar el vuelo?(s/n)");
                    String respuesta = sc.nextLine();
                    if (respuesta.equals("s")) {
                        String pago1=Pagar(tarjeta, total, ReservaIda);
                        
                        String pago2=Pagar(tarjeta, total, ReservaRetorno);
                        System.out.println("Has comprado tu vuelo. El codigo de reserva es: " +pago1);
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
                                System.out.println("Ingrese el numero de T/C: ");
                                String tarjeta = sc.nextLine();
                                sc.nextLine();
                                 
                                System.out.println("Estas seguro de pagar el vuelo?(s/n)");
                                String opc=sc.nextLine();
                                if(opc.equalsIgnoreCase("s")){
                                
                                String pago1=Pagar(tarjeta, total, ReservaIda);
                                String pago2=Pagar(tarjeta, total, ReservaRetorno);
                                System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago1);
                                }else{
                                    System.out.println("Tu pago no se ha completado.");}
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
                                String opc=sc.nextLine();
                                if(opc.equalsIgnoreCase("s")){
                          
                                String pago1=Pagar(tarjeta, total, ReservaIda);
                                String pago2=Pagar(tarjeta, total, ReservaRetorno);
                                System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago1);
                                }else{
                                    System.out.println("Tu pago no se ha completado.");}
                            }

                        }

                    }

                }
             

                comprar = false;
            } else {
                System.out.println("No hay vuelos disponibles :C");
            }

        }
    }

    //METODO PARA GENERAR CODIGO DE PAGO Y VUELORESERVA
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

    //METODO PARA GENERAR CODIGO RESERVA
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

    public ArrayList<String> ciudadesOrigen() {
        ArrayList<String> origen = new ArrayList<>();

        for (Itinerarios i : listaItinerarios) {
            if (!origen.contains(i.getOrigenCiudad())) {
                origen.add(i.getOrigenCiudad());
            }
        }
        return origen;
    }

    public ArrayList<String> ciudadesDestino(String origen) {
        ArrayList<String> destino = new ArrayList<>();

        for (Itinerarios i : listaItinerarios) {
            if ((!(destino.contains(i.getDestinoCiudad()))) && i.getOrigenCiudad().equals(origen)) {
                destino.add(i.getDestinoCiudad());
            }
        }
        return destino;
    }

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

    public static void mostrarTarifas() {
        System.out.println("\nTARIFAS");
        System.out.println("A. Economy(+0)\nB. Premium economy(+60)\nC. Premium business(+90)");
    }

    public static void mostrarformasPago() {
        System.out.println("\nFormas de Pago:");
        System.out.println("1. Tarjeta de Credito\n2. Millas\n");
    }

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

    public String Pagar(String numTarjetaCredito, double valor, VueloReserva vuelo) {
        double valorTC = valor + valor * 10 / 100;
        Reserva r = new Reserva(crearCodigoReserva(), vuelo.getCodigoVueloReserva(), nombres, vuelo.getCodigoVueloReserva().getFechaSalida(), valorTC);

        if (numTarjetaCredito.equals(getNumTarjetaCredito())) {
            
            //CREACION DE OBJETO RESERVA
            ManejoArchivos.EscribirArchivo("reservas.txt", "codigoReserva,codigoVuelo,cliente,fecha,valorPagar");
            ManejoArchivos.EscribirArchivo("reservas.txt", r.toString());
            //CREACION DE OBJETO PAGO
            Pago p = new Pago(crearCodigo(), r.getCodigo(), formaPago.TC, valorTC);
            ManejoArchivos.EscribirArchivo("pagos.txt", "idPago,codigoReserva,totalPagarfina,modoPago");
            ManejoArchivos.EscribirArchivo("pagos.txt", p.toString());

        }
        return r.getCodigo();
    }
}
