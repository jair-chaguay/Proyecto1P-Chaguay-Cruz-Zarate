/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.*;
import static Archivos.ManejoArchivos.LeerValidando;
import static Elementos.VueloReserva.listaVuelos;
import Enums.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Sistema {
   static ArrayList<Usuario> listaUsuarios=new ArrayList<>();
   static ArrayList<Reserva> listaReservas=new ArrayList<>();
   public static ArrayList<Itinerarios> listaItinerarios=new ArrayList<>();
   static ArrayList<Avion> listaAviones=new ArrayList<>();
   
   
   
    //MOSTRAR MENU PARA EL OPERADOR
    public static void mostrarMenuOperador(){
        System.out.println("1. Consultar usuarios\n2. Consultar reservas\n3. Salir");
    }
    
    //MOSTRAR MENU PARA EL CLIENTE
    public static void mostrarMenuCliente(){
        System.out.println("1. Comprar tickets aereos\n2. Consultar reservas\n3. Salir");
    }
    
    //LEER EL ARCHIVO USUARIOS Y CREANDO LOS OBJETOS PARA AGREGARLOS A LA LISTA USUARIOS
    public static void cargarUsuarios(){
        ArrayList<String[]> datosUsuarios=LeerValidando("usuarios.txt",true);
        Usuario u;
        //COMPROBARA SI SON CLIENTES, CLIENTESVIP O OPERADORES)
        for(String[] dato:datosUsuarios){
            switch(dato[6]){
                case "S":
                    u=new Cliente(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],tipoCategoria.valueOf(dato[6]));
                    listaUsuarios.add(u);
                    break;
                case "V":
                    u=new ClienteVip(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],tipoCategoria.valueOf(dato[6]));
                    listaUsuarios.add(u);
                    break; 
                case "O":
                    u=new Operador(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],tipoCategoria.valueOf(dato[6]));
                    listaUsuarios.add(u);
                    break;    
            }
        }
    }
    
    //LEER EL ARCHIVO ITINERARIOS Y CREANDO LOS OBJETOS PARA AGREGARLOS A LA LISTA ITINERARIOS
    public static void cargarItinerarios(){
        ArrayList<String[]> datosItinerarios=LeerValidando("itinerarios.txt",true);
        Itinerarios i;
        for(String[] dato:datosItinerarios){
            i=new Itinerarios(dato[0],dato[1],dato[2],dato[3],dato[4],dato[5]);
            listaItinerarios.add(i);
        }
    }
    
    //LEER EL ARCHIVO VUELOS Y CREANDO LOS OBJETOS PARA AGREGARLOS A LA LISTA VUELOS
    public static void cargarVuelos(){
        ArrayList<String[]> datosVuelo=LeerValidando("vuelos.txt",true);
        Vuelo v;
        for(String[] dato:datosVuelo){
            v=new Vuelo(dato[0],dato[1],dato[2],dato[3],dato[4],Double.valueOf(dato[5]),Integer.valueOf(dato[6]));
            listaVuelos.add(v);
        }
    }
    
    //LEER EL ARCHIVO AVIONES Y CREANDO LOS OBJETOS PARA AGREGARLOS A LA LISTA AVIONES
    public static void cargarAviones(){
        ArrayList<String[]> datosAviones=LeerValidando("aviones.txt",true);
        Avion a;
        for(String[] dato:datosAviones){
            a=new Avion(dato[0],Integer.valueOf(dato[1]));
            listaAviones.add(a);
        }
    }
    
    //MAIN
    public static void main(String[] args){

        //INICIO DE SESION
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Scanner sc=new Scanner(System.in);
        System.out.print("USUARIO: ");
        String user=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String password=sc.nextLine();
        
        //CARGANDO LISTAS
        Sistema.cargarUsuarios();
        Sistema.cargarItinerarios();
        Sistema.cargarVuelos();
        Sistema.cargarAviones();
      
            
        //VALIDANDO INFORMACION
        for(Usuario usuario:listaUsuarios){
            if(usuario.getUsuario().equals(user) && usuario.getContrasena().equals(password)){
                System.out.println("INGRESO EXITOSO");
                //COMPROBRANDO SI EL USUARIO ES CLIENTE 
                if(usuario instanceof Cliente cliente){
                    //COMPRANDO SI EL CLIENTE ES CLIENTE VIP
                    if(cliente instanceof ClienteVip clientevip){
                        Sistema.mostrarMenuCliente();
                        int opc=0;
                        while(opc!=3){
                            System.out.println("Ingrese opcion: ");
                            opc=sc.nextInt();
                            sc.nextLine();
                            switch(opc){
                                case 1:
                                    clientevip.comprarTickets();
                                    break;
                                case 2:
                                    clientevip.consultarReservas();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        }
                    }else{
                        Sistema.mostrarMenuCliente();
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
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        }
                    }    
                }
                //COMPROBANDO SI EL USUARIO ES OPERADOR
                if(usuario instanceof Operador operador){
                    Sistema.mostrarMenuOperador();
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
                            case 3:
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
