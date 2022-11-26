/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Elementos.*;
import Enums.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Operador extends Usuario{
    private int sueldo;

    public Operador(String cedula, String nombres,int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);
        ArrayList<String[]> datosClientes=LeerValidando("operadores.txt",true);
        for(String[] dato:datosClientes){
            if(dato[0].equals(cedula)){
                this.sueldo=Integer.valueOf(dato[1]);
            }
        }        
    }

    
    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public String toString(){
        toString();
        return "Sueldo: "+sueldo;
    }
    @Override
    public void consultarReservas(){
        
    }
//    @Override
//    public void elegirOpcion(){
//        
//    }
    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios){
        for(Usuario u:listaUsuarios){
            if(u instanceof Cliente c){
                System.out.println(c.getNombres()+", CLIENTE "+c.getTipoCategoria()+", "+c.getCedula());
            } if(u instanceof Operador o){
                System.out.println(o.getNombres()+", "+o.getTipoCategoria()+", "+o.getSueldo());
            }
        }
        
    }
//    public void mostrarMenuOperario(){
//        System.out.println("1. Consultar usuarios");
//        System.out.println("2. Consultar reservas");
//        System.out.println("3. Salir");
//    }
}
