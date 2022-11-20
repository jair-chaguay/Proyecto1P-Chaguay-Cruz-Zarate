/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.*;
import Enums.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Operador extends Usuario{
    private double sueldo;

    public Operador(String cedula, String nombres, String apellidos, int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria, double sueldo) {
        super(cedula, nombres, apellidos, edad, correo, usuario, contrasena, tipoCategoria);
        this.sueldo = sueldo;
    }

    
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
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
    @Override
    public void elegirOpcion(){
        
    }
    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios){
        for(Usuario u:listaUsuarios){
            if(u instanceof Cliente c){
                System.out.println(c.getNombres()+", "+c.getApellidos()+", CLIENTE "+c.getTipoCategoria()+", "+c.getCedula());
            } if(u instanceof Operador o){
                System.out.println(o.getNombres()+", "+o.getApellidos()+", "+o.getTipoCategoria()+", "+o.getSueldo());
            }
        }
        
    }
    
}
