/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Archivos.ManejoArchivos;
import static Archivos.ManejoArchivos.LeerValidando;
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

    public void mostrarMenu(Scanner sc){
        Sistema.mostrarMenuOperador();
        int opc2=0;
        while(opc2!=3){
            System.out.println("Ingrese opcion: ");
            opc2=sc.nextInt();
            sc.nextLine();
            switch(opc2){
                case 1:
                    this.consultarUsuarios(listaUsuarios);
                    Sistema.mostrarMenuOperador();
                    break;
                case 2:
                    this.consultarReservas();
                    Sistema.mostrarMenuOperador();
                    break;
                case 3:
                    break;    
                default:
                    System.out.println("Opcion invalida");
                    break;
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
