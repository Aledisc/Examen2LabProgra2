package programacion2.JavaTicket;

public class EventoMusical extends Evento{
    public enum GeneroMusical {
        ROCK, RAP, POP, CLASICA, REGGAETON, OTRO
    }

    private GeneroMusical generoMusical;

    public EventoMusical(String nombreEvento, GeneroMusical generoMusical) {
        super(nombreEvento, TipoEvento.MUSICAL);
        this.generoMusical = generoMusical;
        
    }
    
    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }
}
