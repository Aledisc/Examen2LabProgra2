package programacion2.ahorcado;

public abstract class JuegoAhorcadoBase implements JuegoAhorcado {

    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;

    public JuegoAhorcadoBase(String palabraSecreta, int intentos) {
        intentos = 6;
    }

    public abstract void actualizar_plabra_atc(char letra);

    public abstract boolean verificar_palabra(char letra);

    public abstract boolean Ganar();

}
