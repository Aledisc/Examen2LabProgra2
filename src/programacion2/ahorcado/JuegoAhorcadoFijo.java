package programacion2.ahorcado;

public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {

    public JuegoAhorcadoFijo(String palabraSecreta, int intentos) {
        super(palabraSecreta, intentos);
    }

    protected void actualizarPalabraActual(char letra) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                StringBuilder sb = new StringBuilder(palabraActual);
                sb.setCharAt(i, letra);
                palabraActual = sb.toString();
            }
        }
    }

    protected boolean verificarLetra(char letra) {
        return palabraSecreta.contains(String.valueOf(letra));
    }

    protected boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }

    @Override
    public void actualizar_plabra_atc(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificar_palabra(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Ganar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inicializarPalabraSecreta(String palabraSecreta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void jugar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
