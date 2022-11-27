/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Sistema.*;
import Enums.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import Elementos.Asientos;
import static Archivos.ManejoArchivos.LeerValidando;
/**
 *
 * @author HP
 */
public class Reserva {
    private String codigo;
    private ArrayList<VueloReserva> vuelosReserva=new ArrayList<>();
    private Cliente cliente;
    private Date fecha;
    private double valorPagar;
    private ArrayList<Asientos> listAsientos;
    private ArrayList<Asientos> alea;
    public Reserva(String codigo, Cliente cliente, Date fecha, double valorPagar) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.valorPagar = valorPagar;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<VueloReserva> getVuelosReserva() {
        return vuelosReserva;
    }

    public void setVuelosReserva(ArrayList<VueloReserva> vuelosReserva) {
        this.vuelosReserva = vuelosReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
    
    private String crearCadena(){
        
        String opciones="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena="";
        Random r=new Random();
        for(int i=0; i<6;i++){
            int posicion= r.nextInt(opciones.length());
            char caracter=opciones.charAt(posicion);
            cadena+=caracter;
        }
        return cadena;
    }
    
    public void AsignarAsientos(){
        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
        Asientos a;
        int aleatorio=0;

        for(String[] dato:datosAsientos){
            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
            listAsientos.add(a);
        }
        
        Random f= new Random();  
        double ale=(int)(Math.random()*listAsientos.size());
        int asAle=(int)ale;
        if(listAsientos.get(asAle).equals("S")){
            System.out.println(listAsientos.get(asAle).getNumAsiento());
        }else{
            System.out.println("No hay un asiento disponible");
        }                
        
    }
    
    
    
}
