/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.*;
import Archivos.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Sistema {
   static ArrayList<Usuario> listaUsuarios;
   static ArrayList<Reserva> listaReservas;
   static ArrayList<Itinerarios> listaItinerarios;
   static ArrayList<Avion> listaAviones;
           
   public void mostrarMenuCliente(){
       
   }
   public void mostrarMenuOpe(){
       
   }
   public void validarInformacion(){
       
   }
   public void IniciarSesion(){
       
   }
   
    public static void main(String[] args){
        listaUsuarios=new ArrayList<>();
        listaReservas=new ArrayList<>();
        listaItinerarios=new ArrayList<>();
        listaAviones=new ArrayList<>();

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Scanner sc=new Scanner(System.in);
        System.out.print("USUARIO: ");
        String usuario=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contrasena=sc.nextLine();
        System.out.println("1. Comprar tickets aeres");
        System.out.println("2. Consultar reservas");
        System.out.println("3. Salir");
        int opc=0;
        while(opc!=3){
            System.out.println("Ingrese opcion: ");
            opc=sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                   
                   break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;

            }
        }
   }
   
}
