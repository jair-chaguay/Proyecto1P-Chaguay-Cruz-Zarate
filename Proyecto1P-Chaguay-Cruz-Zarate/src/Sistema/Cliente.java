/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import Elementos.*;
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
            
            System.out.println("******PASO 1*****\n*****************");
            if(!listaIda.isEmpty()){
                System.out.println("------Vuelos disponibles IDA-----");
                for(int i=0; i<listaIda.size(); i++){
                    System.out.println("---------"+(i+1)+"-----------");
                    System.out.println(listaIda.get(i));
                    
                }
                System.out.print("\nElija el vuelo de ida: ");
                int vueloIda=sc.nextInt();
                sc.nextLine();
                comprar = false;
                Cliente.mostrarTarifas();
                System.out.print("\nElije la tarifa para tu vuelo: ");
                String tarifaIda=sc.nextLine();
                
                System.out.println("------Vuelos disponibles RETORNO-----");
                
                
                Cliente.mostrarTarifas();
                System.out.print("\nElije la tarifa para tu vuelo: ");
                String tarifaRetorno=sc.nextLine();
                
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
}
