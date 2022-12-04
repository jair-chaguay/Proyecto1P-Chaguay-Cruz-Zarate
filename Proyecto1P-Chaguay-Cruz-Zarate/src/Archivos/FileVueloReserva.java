/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.*;

/**
 *
 * @author HP
 */
public class FileVueloReserva {

    /**
     *
     * @param nombre
     */
    public void Escribir(String nombre) {
        File archivo; //Manipulacion de Archivo
        FileWriter f; //Escribir archivo(agregar los vuelosReservas)
        BufferedWriter bf;
        PrintWriter linea; //Escribir Archivo

        archivo = new File(nombre);

        if(!archivo.exists()) {

            try {
                archivo.createNewFile();
                f = new FileWriter(archivo);
                bf = new BufferedWriter(f);
                linea = new PrintWriter(bf);

                linea.write("codigoVueloReserva, codigoVuelo, tipo, tarifa, asiento");

            } catch (IOException ex) {
                System.err.println("No se ha creado el archivo");
            }

        }else{
            try {                
                f = new FileWriter(archivo);
                bf = new BufferedWriter(f);
                linea = new PrintWriter(bf);

                linea.write("codigoVueloReserva, codigoVuelo, tipo, tarifa, asiento");

            } catch (IOException ex) {
                System.err.println("No se ha creado el archivo");                
            }
        }

    }
    
}
