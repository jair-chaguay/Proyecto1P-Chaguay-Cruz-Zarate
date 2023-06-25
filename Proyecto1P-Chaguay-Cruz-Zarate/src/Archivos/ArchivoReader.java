/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

/**
 *
 * @author Sam
 */
public interface ArchivoReader {
        ArrayList<String> leerArchivo(String nombreArchivo);

}
public interface ArchivoWriter {
    void escribirArchivo(String nombreArchivo, String linea);
}
