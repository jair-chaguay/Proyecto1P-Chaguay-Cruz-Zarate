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
public class ClienteVip {

    private String rango;
    private int millas = +1000;
    private Cliente cliente;
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);


    /**
     * Constructor que crea objetos de tipo ClienteVip
     
     * @param tipoCategoria
     */
    public ClienteVip(Cliente c, tipoCategoria tipoCategoria) {
       

        for (String[] dato : datosClientes) {
            if (dato[0].equals(c.getCedula())) {
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
     * @param millas
     */
    public void setMillas(int millas) {
        this.millas = millas;
    }


    

}
