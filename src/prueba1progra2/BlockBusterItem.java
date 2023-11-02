
package prueba1progra2;

import java.util.Date;

public abstract class BlockBusterItem {

    private int codigo;
    private String nombre;
    private double precioRenta;
    private Date fechaAdicion;

    public BlockBusterItem(int codigo, String nombre, double precioRenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioRenta = precioRenta;
        this.fechaAdicion = new Date(); // La fecha de adición se establece como la fecha actual por defecto
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioRenta() {
        return precioRenta;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public abstract double pagoRenta(int dias);

    @Override
    public String toString() {
        return "Código: " + codigo
                + ", Nombre: " + nombre
                + ", Precio de Renta: " + precioRenta;
    }
    
}
