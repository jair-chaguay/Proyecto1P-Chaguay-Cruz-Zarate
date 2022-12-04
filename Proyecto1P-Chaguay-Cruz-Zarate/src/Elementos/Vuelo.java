/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import static Sistema.Sistema.listaItinerarios;


/**
 *
 * @author HP
 */
public class Vuelo {
    private String codigoVuelo;
    private String codigoAvion;
    private String fechaSalida;
    private String fechaLlegada;
    private String codigoItinerario;
    private double precio;
    private int precioMillas;
    private  String asientoAleatorio;

    //CONSTRUCTOR PARA CREAR OBJETOS VUELO

    /**
     * Constructor que crea objetos de tipo Vuelo
     * @param codigoVuelo
     * @param codigoAvion
     * @param fechaSalida
     * @param fechaLlegada
     * @param codigoItinerario
     * @param precio
     * @param precioMillas
     */
    public Vuelo(String codigoVuelo, String codigoAvion, String fechaSalida, String fechaLlegada, String codigoItinerario, double precio, int precioMillas) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAvion = codigoAvion;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.codigoItinerario = codigoItinerario;
        this.precio = precio;
        this.precioMillas = precioMillas;
    }
    
    /**
     * Metodo que retorna el codigo del avion
     * @return String
     */
    public String getCodigoAvion() {
        return codigoAvion;
    }

    /**
     *
     * @param avion
     */
    public void setCodigoAvion(String avion) {
        this.codigoAvion = avion;
    }

    /**
     * Metodo que retorna el precio del vuelo
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo que retorna el codigo del itinerario
     * @return Stirng
     */
    public String getCodigoItinerario() {
        return codigoItinerario;
    }

    /**
     *
     * @param codigoItinerario
     */
    public void setCodigoItinerario(String codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    /**
     * Metodo que retorna la fecha de salida del vuelo
     * @return String
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     *
     * @param fechaSalida
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Metodo que retorna la fecha de llegada del vuelo
     * @return String
     */
    public String getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     *
     * @param fechaLlegada
     */
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Metodo que retorna el precio del vuelo en millas
     * @return int
     */
    public int getPrecioMillas() {
        return precioMillas;
    }

    /**
     *
     * @param precioMillas
     */
    public void setPrecioMillas(int precioMillas) {
        this.precioMillas = precioMillas;
    }

    /**
     * Metodo que retorna el codigo del vuelo
     * @return String
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**
     *
     * @param codigoVuelo
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**
     * Metodo que retorna el asiento designado para el pasajero 
     * @return String
     */
    public  String getAsientoAleatorio() {
        return asientoAleatorio;
    }

    /**
     *
     * @param asientoAleatorio
     */
    public void setAsientoAleatorio(String asientoAleatorio) {
        this.asientoAleatorio = asientoAleatorio;
    }
    
    //METODO TOSTRING PARA MOSTRAR LOS VUELOS

    /**
     * Metodo que retorna la descripcion del vuelo en formato String, se lo llama a la hora de mostrar los vuelos a los clientes
     * @return String
     */
    @Override
    public String toString(){
        
        String x = "CODIGO: " + getCodigoVuelo() + "\nHORA SALIDA: ";
        for(Itinerario i: listaItinerarios){
            if(i.getCod().equals(getCodigoItinerario())){
                x = x + i.getHoraSalida() + "\nHORA LLEGADA: " + i.getHoraLlegada() + "\nDURACION: " + i.getDuracion();
            }
        }
        
        return x = x + "\nAVION: " + getCodigoAvion() + "\nPRECIO " + getPrecio() + "\nCOSTO MILLAS: " + getPrecioMillas();
    }
//    public static void cargarAsientos(){
//        ArrayList<String[]> datosAsientos=LeerValidando("asientos.txt",true);
//        Asientos a;
//        for(String[] dato:datosAsientos){
//            a=new Asientos(dato[0],dato[1],disponibilidad.valueOf(dato[2]));
//            listaAsientos.add(a);
//        }
//    }
//    public  void asignarAsiento(String codigoAvion){
//        String a="";
//        ArrayList<Asientos> asientosDisponibles=new ArrayList<>();
//        Random r=new Random();
//        
//        for(Asientos asiento:listaAsientos){
//            if(asiento.getDisponible().equals(disponibilidad.valueOf("S")) && (asiento.getCodigoAvion().equals(codigoAvion))){
//                asientosDisponibles.add(asiento);   
//            }      
//        }
//        for(Asientos AD:asientosDisponibles){
//                int posicion= r.nextInt(asientosDisponibles.size());
//                AD=asientosDisponibles.get(posicion);
//                a=AD.getNumAsiento();
//   
//        }
//        asientoAleatorio=a;
//            
//    }
}
