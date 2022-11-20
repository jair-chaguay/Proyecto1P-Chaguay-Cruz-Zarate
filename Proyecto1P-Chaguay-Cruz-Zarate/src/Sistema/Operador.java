/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

/**
 *
 * @author HP
 */
public class Operador extends Usuario{
    private double sueldo;

    public Operador(String cedula, String nombres, String apellidos, int edad, String correo, String contrasena, tipoCategoria tipoCategoria, double sueldo) {
        super(cedula, nombres, apellidos, edad, correo, contrasena, tipoCategoria);
        this.sueldo = sueldo;
    }

    
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    @Override
    public void consultarReservas(){
        
    }
    @Override
    public void elegirOpcion(){
        
    }
    
}
