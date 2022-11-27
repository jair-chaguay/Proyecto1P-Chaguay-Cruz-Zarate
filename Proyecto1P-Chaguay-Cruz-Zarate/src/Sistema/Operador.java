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
public class Operador extends Usuario {

    private int sueldo;

    public Operador(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", true);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.sueldo = Integer.valueOf(dato[1]);
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
    public String toString() {
        toString();
        return "Sueldo: " + sueldo;
    }

    @Override
    public void consultarReservas() {
        ArrayList<VueloReserva> vuelosReserva = null;
        for (int i = 0; i < vuelosReserva.size(); i++) {
            System.out.println("VUELO: " + vuelosReserva.get(i).getCodigoVueloReserva().getCodigoVuelo());
            int cantidad = 0;
            if (vuelosReserva.get(i).getCodigoVueloReserva().getCodigoVuelo().equals(vuelosReserva.get(i + 1).getCodigoVueloReserva().getCodigoVuelo())) {
                cantidad++;

            }
            System.out.println("CANTIDAD RESERVADOS: " + cantidad);

        }

    }

    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u instanceof Cliente c) {
                if (c instanceof ClienteVip cv) {
                    System.out.println(c.getNombres() + ", CLIENTE VIP " + cv.getRango() + ", " + c.getCedula());
                } else {
                    System.out.println(c.getNombres() + ", CLIENTE ESTANDAR, " + c.getCedula());
                }

            }
            if (u instanceof Operador o) {
                System.out.println(o.getNombres() + ", OPERADOR, " + o.getSueldo());
            }
        }

    }

}
