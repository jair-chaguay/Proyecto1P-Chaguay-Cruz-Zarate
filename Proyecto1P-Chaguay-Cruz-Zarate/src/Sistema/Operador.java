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
     ArrayList<VueloReserva> vuelosReserva;

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
        for(VueloReserva elemento: vuelosReserva){
            String primer=elemento.getCodigoVueloReserva().getCodigoVuelo();
            System.out.println("--------------------------");
            System.out.println("VUELO: "+primer);
            int cantidad=0;
            for(int i=0;i<vuelosReserva.size();i++){
                if(primer.equals(vuelosReserva.get(i).getCodigoVueloReserva().getCodigoVuelo())){
                    cantidad++;
                    System.out.println("CANTIDAD DE RESERVAS: "+cantidad);
                    System.out.println("--------------------------");
                    
                }
            }
            
            
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
