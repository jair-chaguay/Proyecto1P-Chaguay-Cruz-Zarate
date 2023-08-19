/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Archivos.ManejoArchivos;
import Elementos.Pago;
import Elementos.Reserva;
import Elementos.VueloReserva;
import Enums.formaPago;
import Enums.tipoVuelo;
import static Sistema.Cliente.listaReservas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author robes
 */
public class GestorDePagos {
    private ArrayList<Reserva> reservas;
    private static Scanner sc = new Scanner(System.in);;
    private Cliente cliente;

    
    public GestorDePagos(ArrayList<Reserva> reservas, Cliente cliente){
        this.reservas = reservas;
        this.cliente = cliente;
    }
    
    public Reserva Pagar(String numTarjetaCredito, double valor, VueloReserva vuelo, VueloReserva vuelo2) {
        double valorTC = valor + (valor * 10 / 100);
        Reserva r = new Reserva(Utils.crearCodigoReserva(), vuelo.getVuelo(), cliente.getNombres(), vuelo.getVuelo().getFechaSalida(), valorTC);
        Reserva r2 = new Reserva(Utils.crearCodigoReserva(), vuelo2.getVuelo(),cliente.getNombres(), vuelo2.getVuelo().getFechaSalida(), valorTC);
        reservas.add(r);
        reservas.add(r2);

        //CREACION DE OBJETO RESERVA
        ManejoArchivos.EscribirArchivo("reservas.txt", r.toString());
        //CREACION DE OBJETO PAGO
        Pago p = new Pago(Utils.crearCodigo(), r.getCodigo(), formaPago.TC, valorTC);

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
        int valor = vuelo.getVuelo().getPrecioMillas() + vuelo2.getVuelo().getPrecioMillas();
        if (millas >= valor) {
            Reserva r = new Reserva(Utils.crearCodigoReserva(), vuelo.getVuelo(), cliente.getNombres(), vuelo.getVuelo().getFechaSalida(), valor);
            Reserva r2 = new Reserva(Utils.crearCodigoReserva(), vuelo2.getVuelo(), cliente.getNombres(), vuelo2.getVuelo().getFechaSalida(), valor);
            reservas.add(r);
            reservas.add(r2);
            //CREACION DE OBJETO RESERVA
            ManejoArchivos.EscribirArchivo("reservas.txt", r.toString());
            ManejoArchivos.EscribirArchivo("reservas.txt", r2.toString());
            
            //CREACION DE OBJETO PAGO
            Pago p = new Pago(Utils.crearCodigo(), r.getCodigo(), formaPago.M, valor);

            ManejoArchivos.EscribirArchivo("pagos.txt", p.toString());
            return r.getCodigo();
        } else {
            System.out.println("No tiene millas suficientes para su pago");
            sc.nextLine();
            System.out.println("Desea intentar con tarjeta de credito?(s/n)");
            String opc = sc.nextLine();
          
            if(opc.equalsIgnoreCase("s")){
                double valorTC = precio + (precio * 10 / 100);
                Pagar(cliente.getNumTarjetaCredito(),precio,vuelo,vuelo2);
                Reserva r = new Reserva(Utils.crearCodigoReserva(), vuelo.getVuelo(), cliente.getNombres(), vuelo.getVuelo().getFechaSalida(), valorTC);
                Reserva r2 = new Reserva(Utils.crearCodigoReserva(), vuelo2.getVuelo(), cliente.getNombres(), vuelo2.getVuelo().getFechaSalida(), valorTC);
                return r.getCodigo();
                
            }else{
                return "Su pago no se ha completado";
            }
            

        }

    }
    
    public double calcularTotal(double valorpago){
        if (cliente.tipoCategoria.equals(cliente.tipoCategoria.valueOf("S"))) {
            System.out.println("Descuento:0% (cliente ESTANDAR)");
            System.out.println("Iva: " + valorpago * 12 / 100);
            return valorpago + valorpago * 12 / 100;
        }
        double valorDescuento = 0;
        
            for (String[] dato : cliente.datosClientes) {
                if (cliente.cedula.equals(dato[0]) && dato[2].equals("GOLDEN PASS")) {
                    System.out.println("Descuento:20%  (cliente vip GOLDEN PASS)");
                    valorDescuento = valorpago - valorpago * 20 / 100;
                    System.out.println("Total: " + valorDescuento);
                    valorpago = valorDescuento;
                    System.out.println("Iva: " + valorpago * 12 / 100);
                    return valorpago + valorpago * 12 / 100;
                }
                if (cliente.cedula.equals(dato[0]) && dato[2].equals("PLATINUM PASS")) {
                    System.out.println("Descuento:30%  (cliente vip PLATINUM PASS)");
                    valorDescuento = valorpago - valorpago * 30 / 100;
                    System.out.println("Total: " + valorDescuento);
                    valorpago = valorDescuento;
                    System.out.println("Iva: " + valorpago * 12 / 100);
                    return valorpago + valorpago * 12 / 100;
                }
        }
    return 0;    
    }
    
    public void realizarPago(VueloReserva ReservaIda, VueloReserva ReservaVuelta){
                System.out.println("\n******PASO 3*****\n*****************");
                System.out.println("--------------PAGO---------");
                System.out.println("Descripcion:");
                double valorpago = ReservaIda.getVuelo().getPrecio() + ReservaVuelta.getVuelo().getPrecio();
                double totalPagar = calcularTotal(valorpago);
                System.out.println("Subtotal: " + valorpago);
                if (cliente.tipoCategoria.equals(cliente.tipoCategoria.valueOf("S"))) {
                    System.out.println("TOTAL A PAGAR: " + totalPagar);
                    System.out.println("Forma de pago: Tarjeta de Credito");
                    System.out.print("Ingrese el numero de T/C: ");
                    String tarjeta = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Estas seguro de pagar el vuelo?(s/n)");
                    String respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        Reserva pago = Pagar(tarjeta, totalPagar, ReservaIda, ReservaVuelta);
                        System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago.getCodigo());
                    } else {
                        System.out.println("No has finalizado tu compra.");
                    }
                }else {
                    int millas = 0;
                    System.out.println("TOTAL A PAGAR: " + totalPagar);
                    Utils.mostrarformasPago();
                    System.out.println("Elige tu forma de pago: ");
                    int opcion = sc.nextInt();
                    if (opcion == 1) {
                        System.out.print("Ingrese el numero de T/C: ");
                        String tarjeta = sc.nextLine();
                        sc.nextLine();

                        System.out.print("Estas seguro de pagar el vuelo?(s/n) ");
                        String opc = sc.nextLine();
                        if (opc.equalsIgnoreCase("s")) {
                            Reserva pago = Pagar(tarjeta, totalPagar, ReservaIda, ReservaVuelta);
                            System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago.getCodigo());
                        } else {
                            System.out.println("Tu pago no se ha completado.");
                        }
                    } else if (opcion == 2) {
                        String pago = Pagar(millas, totalPagar, ReservaIda, ReservaVuelta);
                        if (pago.equals("Su pago no se ha completado")) {
                            System.out.println("Su pago no se ha completado");
                        } else {
                            System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + pago);
                        }
                    }

                }
            } 
    }
