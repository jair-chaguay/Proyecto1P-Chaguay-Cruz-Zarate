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
    public static ArrayList<Itinerario> listaItinerarios=new ArrayList<>();
    static ArrayList<Avion> listaAviones=new ArrayList<>();

    /**
     * Metodo que imprime el menu del Operador
     */
    public static void mostrarMenuOperador(){
        System.out.println("1. Consultar usuarios\n2. Consultar reservas\n3. Salir");
    }

    /**
     * Metodo que imprime el menu del Cliente
     */
    public static void mostrarMenuCliente(){
        System.out.println("1. Comprar tickets aereos\n2. Consultar reservas\n3. Salir");
    }
    
    /**
     * Metodo que lee el archivo Usuarios y crea los objetos de los mismos para agregarlos a la lista de Usuarios
     */
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
    
    /**
     * Metodo que lee el archivo Itinerios y crea los objetos del mismo para agregarlos a la lista de Itinerarios
     */
    public static void cargarItinerarios(){
        ArrayList<String[]> datosItinerarios=LeerValidando("itinerarios.txt",true);
        Itinerario i;
        for(String[] dato:datosItinerarios){
            i=new Itinerario(dato[0],dato[1],dato[2],dato[3],dato[4],dato[5]);
            listaItinerarios.add(i);
        }
    }
    
    /**
     * Metodo que lee el archivo Vuelos y crea los objetos correspondientes para agregarlos a la lista de Vuelos
     */
    public static void cargarVuelos(){
        ArrayList<String[]> datosVuelo=LeerValidando("vuelos.txt",true);
        Vuelo v;
        for(String[] dato:datosVuelo){
            v=new Vuelo(dato[0],dato[1],dato[2],dato[3],dato[4],Double.valueOf(dato[5]),Integer.valueOf(dato[6]));
            listaVuelos.add(v);
        }
    }
    
    /**
     * Metodo que lee el archivo Aviones y crea los obejtos correspondientes para agregarlos a la lista de Aviones
     */
    public static void cargarAviones(){
        ArrayList<String[]> datosAviones=LeerValidando("aviones.txt",true);
        Avion a;
        for(String[] dato:datosAviones){
            a=new Avion(dato[0],Integer.valueOf(dato[1]));
            listaAviones.add(a);
        }
    }
    
    /**
     * Main
     * @param args
     */
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
                usuario.mostrarMenu(sc);
            }else if(!usuario.getUsuario().equals(user) && usuario.getContrasena().equals(password)){
                System.out.println("Usuario o contraseña incorrectos");
            }    
        }
   } 
}
