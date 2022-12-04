/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Archivos.ManejoArchivos;
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
    
    /**
     * Constructor que crea objetos de tipo Operador
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoCategoria
     */
    public Operador(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoCategoria tipoCategoria) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoCategoria);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", true);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.sueldo = Integer.valueOf(dato[1]);
            }
        }
    }

    /**
     * Metodo que retorna en formato int el sueldo del operador
     * @return int
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Metodo set para el sueldo del operador
     * @param sueldo
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Metodo sobreescrito que muestra las reservas hechas por los clientes
     */
    @Override
    public void consultarReservas() {
        ArrayList<String[]> datosReservas = ManejoArchivos.LeerValidando("reservas.txt", true);
        if (datosReservas != null) {
            for (String[] elemento : datosReservas) {
                String vuelo = elemento[1];
                int cantidad = 0;
                System.out.println("-------------------------");
                System.out.println("VUELO: " + vuelo);

                for (int i = 0; i < datosReservas.size(); i++) {

                    if (vuelo.equals(datosReservas.get(i)[1])) {
                        cantidad++;

                    } else {
                        cantidad += 0;
                    }

                }
                System.out.println("CANTIDAD DE RESERVAS: " + cantidad);

            }

        } else {
            System.out.println("NO HAY RESERVAS QUE CONSULTAR");
        }
    }

//        if (vuelosReserva.isEmpty() == false) {
//            for (VueloReserva elemento : vuelosReserva) {
//
//                String primer = elemento.getCodigoVueloReserva().getCodigoVuelo();
//                System.out.println("--------------------------");
//                System.out.println("VUELO: " + primer);
//                int cantidad = 0;
//                for (int i = 0; i < vuelosReserva.size(); i++) {
//                    if (primer.equals(vuelosReserva.get(i).getCodigoVueloReserva().getCodigoVuelo())) {
//                        cantidad++;
//                        System.out.println("CANTIDAD DE RESERVAS: " + cantidad);
//                        System.out.println("--------------------------");
//
//                    }
//                }
//
//            }
//        } else {
//            System.out.println("NO HAY RESERVAS QUE CONSULTAR");
//        }

    /**
     * Metodo que imprime los usuarios registrados
     * @param listaUsuarios
     */
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
