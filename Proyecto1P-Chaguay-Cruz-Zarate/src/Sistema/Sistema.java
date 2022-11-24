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
   
//   ArrayList<String> usuarios= ManejoArchivos.LeerArchivo("usuarios.txt");
    
     
//   public void validarInformacion(){
//       
//   }
//   public void IniciarSesion(){
//       
//   }
//    public void mostrarMenuOperario(){
//        System.out.println("1. Consultar usuarios");
//        System.out.println("2. Consultar reservas");
//        System.out.println("3. Salir");
//    }
//    public void mostrarMenuCliente(){
//        System.out.println("1. Comprar tickets aereos");
//        System.out.println("2. Consultar reservas");
//        System.out.println("3. Salir");
//    }
   
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
        String user=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String password=sc.nextLine();
        for(Usuario usuario:listaUsuarios){
            if(usuario.getUsuario().equals(user)){
                if(usuario instanceof Cliente cliente){
                    cliente.mostrarMenuCliente();
                    int opc=0;
                    while(opc!=3){
                        System.out.println("Ingrese opcion: ");
                        opc=sc.nextInt();
                        sc.nextLine();
                        switch(opc){
                            case 1:
                                cliente.comprarTickets();
                                
                                break;
                            case 2:
                                cliente.consultarReservas();
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                    }
                }
                if(usuario instanceof Operador operador){
                    operador.mostrarMenuOperario();
                    int opc2=0;
                    while(opc2!=3){
                        System.out.println("Ingrese opcion: ");
                        opc2=sc.nextInt();
                        sc.nextLine();
                        switch(opc2){
                            case 1:
                                operador.consultarUsuarios(listaUsuarios);
                               break;
                            case 2:
                                operador.consultarReservas();
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                    }
                }
            }else{
                System.out.println("Usuario o contraseña incorrectos");
            }    
        }
   } 
}
