/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Elementos.*;
import Enums.*;
import Archivos.*;

/**
 *
 * @author HP
 */
public abstract class Usuario {
    protected String cedula,nombres,apellidos,correo,usuario, contrasena;
    protected int edad;
    protected tipoCategoria tipoCategoria;
    
    
    
    public Usuario(String cedula, String nombres, String apellidos,int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria){
        
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.usuario=usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.tipoCategoria = tipoCategoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public tipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(tipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
    @Override
    public String toString(){
        return "Cedula: "+cedula+", nombres: "+nombres+",apellidos: "+apellidos+",edad: "+edad+", correo: "+correo+",contrasena: "+contrasena+",categoria: "+tipoCategoria;
    }
    
    public abstract void consultarReservas();
    
//    public void elegirOpcion(){
//        
//    }
    
    
}
