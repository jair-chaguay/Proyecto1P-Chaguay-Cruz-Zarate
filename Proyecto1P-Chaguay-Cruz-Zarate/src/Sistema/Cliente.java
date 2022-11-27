/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import Elementos.*;
import static Elementos.Avion.listaAsientos;
import static Elementos.VueloReserva.listaVuelos;
import static Sistema.Sistema.listaItinerarios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Cliente extends Usuario {
    private String numTarjetaCredito;
    
    

    public Cliente(String cedula, String nombres,int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo,usuario, contrasena, tipoCategoria);
        ArrayList<String[]> datosClientes=LeerValidando("clientes.txt",true);
        for(String[] dato:datosClientes){
            if(dato[0].equals(cedula)){
                this.numTarjetaCredito=dato[1];
            }
        }
    }

    
    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }
    
    @Override
    public String toString(){
        toString();
        return "Num T/C: "+numTarjetaCredito;
    }
        
    Scanner sc=new Scanner(System.in);
    @Override
    public void consultarReservas(){
        
    }
    public void comprarTickets(){
        String ciudadOrigen="";
        boolean comprar = true;

        while(comprar){
            int opcion = 0;
            int cont = 0;
            ArrayList<String> ciudOrigen = ciudadesOrigen();
            System.out.println("----ORIGEN----");
            for(int i=0; i<ciudOrigen.size(); i++){
                System.out.println((i+1) + ". " + ciudOrigen.get(i));
            }
            System.out.print("Seleccione su punto de partida: ");
            opcion = sc.nextInt();
            sc.nextLine();
            if(opcion <= ciudOrigen.size() && !(opcion<=0)){
                
                ciudadOrigen = ciudOrigen.get(opcion-1);

                comprar = false;
            }
            else{
                System.out.println("Seleccion Invalida");
                
            }

        }
        comprar = true;
        String ciudadDestino="";
        
        while(comprar){
            int cont =0;
            int opcion = 0;
            ArrayList<String> ciudDestino = ciudadesDestino(ciudadOrigen);
            System.out.println("----DESTINO----");
            for(String i: ciudDestino){
               cont++;
                System.out.println(cont + ". " + i);
            }
            
            System.out.print("Seleccione el punto de llegada: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            if(opcion <= cont && !(opcion<=0) ){
                ciudadDestino = ciudDestino.get(cont-1);
                comprar = false;
            }
            else{
                System.out.println("Seleccion Invalida");
            }
            
        }
        comprar = true;
        while(comprar){
            System.out.println("Fechas");
            System.out.print("Fecha de Salida: ");
            String fechaSalida = sc.nextLine();
            System.out.print("Fecha de Retorno: ");
            String fechaRetorno = sc.nextLine();
            
            ArrayList<Vuelo> listaIda = vuelosFiltrados(ciudadOrigen, ciudadDestino, fechaSalida);
            ArrayList<Vuelo> listaRetorno = vuelosFiltrados(ciudadDestino, ciudadOrigen, fechaRetorno);
            
            System.out.println("\n******PASO 1*****\n*****************");
            if(!listaIda.isEmpty()){
                System.out.println("------Vuelos disponibles IDA-----");
                for(int i=0; i<listaIda.size(); i++){
                    System.out.println("---------"+(i+1)+"-----------");
                    System.out.println(listaIda.get(i));
                    
                }
                System.out.print("\nElija el vuelo de ida: ");
                int ind=sc.nextInt();
                sc.nextLine();
                Vuelo vueloIda=listaIda.get(ind);
                
                Cliente.mostrarTarifas();
                System.out.print("\nElije la tarifa para tu vuelo de ida: ");
                String tarifaIda=sc.nextLine();
                tipoTarifa t;
                switch(tarifaIda){
                    case "A":
                        t=tipoTarifa.valueOf("A");
                        break;
                    case "B":
                        t=tipoTarifa.valueOf("B");
                        break;
                    case "C":
                        t=tipoTarifa.valueOf("C");
                        break;
                }
                
                
                
                System.out.println("------Vuelos disponibles RETORNO-----");
//                ArrayList<Vuelo> x=Cliente.obtenerVuelosRetorno(fechaRetorno, listaRetorno);
                for(int i=0; i<listaRetorno.size(); i++){
                    System.out.println("---------"+(i+1)+"-----------");
                    System.out.println(listaRetorno.get(i));
                    
                }
                System.out.print("\nElija el vuelo de retorno: ");
                int ind2=sc.nextInt();
                sc.nextLine();
                Vuelo vueloRetorno=listaIda.get(ind2);
                
                Cliente.mostrarTarifas();
                System.out.print("\nElije la tarifa para tu vuelo de retorno: ");
                String tarifaRetorno=sc.nextLine();
                tipoTarifa t2;
                switch(tarifaRetorno){
                    case "A":
                        t2=tipoTarifa.valueOf("A");
                        break;
                    case "B":
                        t2=tipoTarifa.valueOf("B");
                        break;
                    case "C":
                        t2=tipoTarifa.valueOf("C");
                        break;
                }
                for(Asientos l:listaAsientos){
                    System.out.println("Asientos");
                }
                System.out.println("\n******PASO 2*****\n*****************");
                System.out.println("-----------ASIENTOS----------");
                
                System.out.println("Para tu vuelo de ida "+vueloIda.getCodigoVuelo()+" se te ha asignado el asiento: "+ vueloIda.getAsientoAleatorio());
                System.out.println("Para tu vuelo de retorno "+vueloRetorno.getCodigoVuelo()+" se te ha asignado el asiento: "+ vueloRetorno.getAsientoAleatorio());
                comprar = false;
            }
            else{
                System.out.println("No hay vuelos disponibles :C");
            }
            
        }
    }    
    

    public void pagar(int numTarjetaCredito){
        
    }
    public void crearReserva(){
        
    }
    public ArrayList<String> ciudadesOrigen(){
        ArrayList<String> origen = new ArrayList<>();
        
        for(Itinerarios i: listaItinerarios){
            if(!origen.contains(i.getOrigenCiudad())){
                origen.add(i.getOrigenCiudad());
            }
        }
        return origen;
    }
    
    public ArrayList<String> ciudadesDestino(String origen){
        ArrayList<String> destino = new ArrayList<>();
        
        for(Itinerarios i: listaItinerarios){
            if((!(destino.contains(i.getDestinoCiudad()))) && i.getOrigenCiudad().equals(origen) ){
                destino.add(i.getDestinoCiudad());
            }
        }
        return destino;
    }
    
    public ArrayList<Vuelo> vuelosFiltrados(String origen, String destino, String fecha){
        ArrayList<Vuelo> lista = new ArrayList<>();
        
        for(int i = 0; i<listaItinerarios.size(); i++){
            boolean b = listaItinerarios.get(i).getOrigenCiudad().equals(origen) && listaItinerarios.get(i).getDestinoCiudad().equals(destino) && (listaVuelos.get(i).getFechaSalida().equals(fecha));
            if(b){
               lista.add(listaVuelos.get(i));
            }
        }
        return lista;
    }
    public static void mostrarTarifas(){
        System.out.println("\nTARIFAS");
        System.out.println("A. Economy(+0)\nB. Premium economy(+60)\nC. Premium business(+90)");
    }
//    public static ArrayList<Vuelo> obtenerVuelosRetorno(String fechaRetorno,ArrayList<Vuelo> listaRetorno){
//        ArrayList<Vuelo> lista2=new ArrayList<>();
//        for(int i = 0; i<listaRetorno.size(); i++){
//            String[] arrayFechaSalida=listaRetorno.get(i).getFechaSalida().split("/");
//            String[] arrayFechaRetorno=fechaRetorno.split("/");
//            boolean b1=Integer.valueOf(arrayFechaSalida[0])<Integer.valueOf(arrayFechaRetorno[0]);
//            boolean b2=Integer.valueOf(arrayFechaSalida[1])<Integer.valueOf(arrayFechaRetorno[1]);
//            if(b1 || b2){
//                lista2.add(listaRetorno.get(i));
//            }
//        }for(Vuelo l:lista2){
//            System.out.println(l);
//        }
//        return lista2;
//    }
    
}
