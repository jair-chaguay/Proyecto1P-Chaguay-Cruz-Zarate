/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import static Archivos.ManejoArchivos.LeerValidando;
import Enums.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ClienteVip extends Cliente {

    private String rango;
    private int millas = +1000;
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);


    /**
     * Constructor que crea objetos de tipo ClienteVip
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoCategoria
     */
    public ClienteVip(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);

        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.rango = dato[2];
                this.millas = Integer.valueOf(dato[3]);
            }
        }
    }

    /**
     * Metodo que retorna el rango del cliente vip
     * @return String
     */
    public String getRango() {
        return rango;
    }

    /**
     * Metodo set para el rango del clientevip
     * @param rango
     */
    public void setRango(String rango) {
        this.rango = rango;
    }

    /**
     * Metodo que retorna el numero de millas que posee el cliente
     * @return int
     */
    public int getMillas() {
        return millas;
    }

    /**
     * Metodo set para las millas del cliente vip
     * @param milla
     * En este código, el método setMillas en la clase ClienteVip simplemente 
     * cambia las millas de un ClienteVip como se esperaría. Esto significa que ahora
     * puedes usar un objeto de tipo ClienteVip en cualquier lugar donde esperes un 
     * objeto de tipo Usuario, y todos los métodos se comportarán de la misma manera, 
     * cumpliendo así con el principio de sustitución de Liskov.
     */
    public void setMillas(int milla) {
        this.millas = milla;
    }


    

}
