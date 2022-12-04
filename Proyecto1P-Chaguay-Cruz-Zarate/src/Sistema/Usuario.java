/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;


import Enums.*;

/**
 *
 * @author HP
 */
public abstract class Usuario {

    protected String cedula,nombres,correo,usuario,contrasena;
    protected int edad;
    protected tipoCategoria tipoCategoria;
    
    /**
     * Constructor que crea objetos de tipo Usuario
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoCategoria
     */
    public Usuario(String cedula, String nombres,int edad, String correo,String usuario, String contrasena, tipoCategoria tipoCategoria){
        
        this.cedula = cedula;
        this.nombres = nombres;
        this.correo = correo;
        this.usuario=usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.tipoCategoria = tipoCategoria;
    }

    /**
     * Metodo que devuelve el user del Usuario
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo set para el user del Usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que devuelve la cedula del Usuario
     * @return String
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo set para la cedula del usuario
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que devuelve los nombres del Usuario
     * @return String
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Metodo set para los nombres del usuario
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Metodo que devuelve la edad del Usuario
     * @return int
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo set para la edad del usuario
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo que devuelve el correo del Usuario
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo set para el correo del usuario
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que devuelve la contrasena del Usuario
     * @return String
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo set para la contrasena del usuario
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo que devuelve el tipo de categoria a la que pertenece el usuario
     * @return tipoCategoria (Enum)
     */
    public tipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    /**
     * Metodo set para el tipo Categoria del usuario
     * @param tipoCategoria
     */
    public void setTipoCategoria(tipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    /**
     * Metodo toString que retorna en formato String la descripcion del usuario
     * @return String
     */
    @Override
    public String toString(){
        return "Cedula: "+cedula+", nombres: "+nombres+",edad: "+edad+", correo: "+correo+",contrasena: "+contrasena+",categoria: "+tipoCategoria;
    }
    
    /**
     * Metodo abstracto que se sobreescribe en Cliente y Operador
     */
    public abstract void consultarReservas();
    
    
}
