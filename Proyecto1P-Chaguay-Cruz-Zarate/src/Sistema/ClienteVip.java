/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

/**
 *
 * @author HP
 */
public class ClienteVip extends Cliente{
    private tipoRango rango;
    private int millas=1000;

    public tipoRango getRango() {
        return rango;
    }

    public void setRango(tipoRango rango) {
        this.rango = rango;
    }

    public int getMillas() {
        return millas;
    }

    public void setMillas(int millas) {
        this.millas = millas;
    }
    @Override
    public void comprarTickets(){
        
    }
    @Override
    public void consultarReservas(){
        
    }
    @Override
    public void elegirOpcion(){
        
    }
    @Override
    public void pagar(int millas){
        
    }
   
}
