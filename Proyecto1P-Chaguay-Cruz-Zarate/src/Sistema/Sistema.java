/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.*;
import Enums.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Sistema {
   ArrayList<Usuario> listaUsuarios=new ArrayList<>();
   ArrayList<Reserva> listaReservas=new ArrayList<>();
   ArrayList<Itinerarios> listaItinerarios=new ArrayList<>();
   ArrayList<Avion> listaAviones=new ArrayList<>();
   
   public static void main(String[] args){
       System.out.println("++++++++++++++++++++++++++++++++++++++++");
       System.out.println("BIENVENIDO AL SISTEMA");
       System.out.println("++++++++++++++++++++++++++++++++++++++++");
       Scanner sc=new Scanner(System.in);
       System.out.print("USUARIO: ");
       String usuario=sc.nextLine();
       System.out.print("CONTRASEddhsd: ");
       String contrasena=sc.nextLine();
   }
   public void mostrarMenuCliente(){
       
   }
   public void mostrarMenuOpe(){
       
   }
   public void validarInformacion(){
       
   }
   public void IniciarSesion(){
       
   }
}
