
package prueba1progra2;


public class VideoGameItem extends BlockBusterItem {
    private static final double precioRenta=30;
    private static final String play="PLAYSTATION";
    private static final String xbox="XBOX";
    private static final String wii="WII";

    private String consola;

    public VideoGameItem(int codigo,String nombre,String consola) {
        super(codigo,nombre, 30, consola);
        if(consolaValida(consola)) {
            this.consola=consola;
        } else {
            throw new IllegalArgumentException("Consola no válida");
        }
    }

    public String getConsola() {
        return consola;
    }

    @Override
    public double pagoRenta(int dias) {
        return precioRenta*dias;
    }

    @Override
    public String toString() {
        return super.toString()+" - Consola: "+consola+" - Game";
    }

    private boolean consolaValida(String consola) {
        return consola.equals(play)||consola.equals(xbox)||consola.equals(wii);
    }
}