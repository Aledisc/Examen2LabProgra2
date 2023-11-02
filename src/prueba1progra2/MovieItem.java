/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1progra2;

import java.util.Date;

public class MovieItem extends BlockBusterItem {
    private String estado;

    public MovieItem(int codigo, String nombre, double precioRenta) {
        super(codigo, nombre, precioRenta);
        this.estado = "ESTRENO"; // Estado por defecto
    }

    @Override
    public double pagoRenta(int dias) {
        double precioTotal = getPrecioRenta();
        if (estado.equals("ESTRENO") && dias > 2) {
            precioTotal += (dias - 2) * 50;
        } else if (estado.equals("NORMAL") && dias > 5) {
            precioTotal += (dias - 5) * 30;
        }
        return precioTotal;
    }

    public void evaluarEstado() {
        Date fechaAdicion = getFechaAdicion();
        Date fechaActual = new Date();
        long diferenciaTiempo = fechaActual.getTime() - fechaAdicion.getTime();
        long mesesDiferencia = diferenciaTiempo / (30L * 24L * 60L * 60L * 1000L); // Aproximadamente 30 días por mes

        if (mesesDiferencia >= 5 && estado.equals("ESTRENO")) {
            estado = "NORMAL";
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + estado + " - Movie";
    }
}