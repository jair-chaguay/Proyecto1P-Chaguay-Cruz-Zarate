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
   
   
   public void mostrarMenuCliente(){
       
   }
   public void mostrarMenuOpe(){
       
   }
   public void validarInformacion(){
       
   }
   public void IniciarSesion(){
       
   }
   
   public static void main(String[] args){
       ArrayList<Usuario> listaUsuarios=new ArrayList<>();
       ArrayList<Reserva> listaReservas=new ArrayList<>();
       ArrayList<Itinerarios> listaItinerarios=new ArrayList<>();
       ArrayList<Avion> listaAviones=new ArrayList<>();
       
       System.out.println("++++++++++++++++++++++++++++++++++++++++");
       System.out.println("BIENVENIDO AL SISTEMA");
       System.out.println("++++++++++++++++++++++++++++++++++++++++");
       Scanner sc=new Scanner(System.in);
       System.out.print("USUARIO: ");
       String usuario=sc.nextLine();
       System.out.print("CONTRASEÑA: ");
       String contrasena=sc.nextLine();
       
       
   }
   
}
