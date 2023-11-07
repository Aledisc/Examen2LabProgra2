/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2.JavaTicket;

/**
 *
 * @author Admin
 */
public class Evento2 {
    private int ID;
    private String nombreEvento;
    //private TipoEvento tipoEvento;
    private double valorRenta;
    private int capacidad;
    //private double costoGrama;
    private String autor;

//    Evento2(int ID, String nombreEvento, double valorRenta, String autor) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    public Evento2(int ID, String nombreEvento, double valorRenta, String autor) {
        this.ID=ID;
        this.nombreEvento = nombreEvento;
        this.valorRenta = valorRenta;
        this.autor = autor;
    }

    // Métodos setters
    
    public void setID(int ID){
        this.ID=ID;
        
    }
    
    public int getID(){
        return ID;
    }
    
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setValorRenta(double valorRenta) {
        this.valorRenta = valorRenta;
    }

    public void setCapacidadEvento(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Métodos getters
    public String getNombreEvento() {
        return nombreEvento;
    }

    public double getValorRenta() {
        return valorRenta;
    }

    public int getCapacidadEvento() {
        return capacidad;
    }

    public String getAutor() {
        return autor;
    }
}
