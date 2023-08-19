/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class ClienteVip extends Cliente {

    private String rango;
    private int millas = +1000;
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);

    /**
     * Constructor que crea objetos de tipo ClienteVip
     * 
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoCategoria
     */
    public ClienteVip(String cedula, String nombres, int edad, String correo, String usuario, String contrasena,
            tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);

        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.rango = dato[2];
                this.millas = Integer.valueOf(dato[3]);
            }
        }
    }

    public void mostrarMenu(Scanner sc){
        Sistema.mostrarMenuCliente();
        int opc=0;
        while(opc!=3){
            System.out.println("Ingrese opcion: ");
            opc=sc.nextInt();
            sc.nextLine();
            switch(opc){
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
     * Metodo que retorna el rango del cliente vip
     * 
     * @return String
     */
    public String getRango() {
        return rango;
    }

    /**
     * Metodo set para el rango del clientevip
     * 
     * @param rango
     */
    public void setRango(String rango) {
        this.rango = rango;
    }

    /**
     * Metodo que retorna el numero de millas que posee el cliente
     * 
     * @return int
     */
    public int getMillas() {
        return millas;
    }

    /**
     * Metodo set para las millas del cliente vip
     * 
     * @param millas
     */
    public void setMillas(int millas) {
        this.millas = millas;
    }

}
