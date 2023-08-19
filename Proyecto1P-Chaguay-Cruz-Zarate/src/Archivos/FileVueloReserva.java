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
    public void crearArchivoReservas(String nombreArchivo) {
        File archivo; 
        FileWriter f; 
        BufferedWriter bf;
        PrintWriter linea; 

        archivo = new File(nombreArchivo);

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
