package programacion2.JavaTicket;

public class EventoReligioso extends Evento{
    
    public int personasConvertidas;
    
    public EventoReligioso(String nombreEvento, int personasConvertidas) {
        super(nombreEvento, TipoEvento.RELIGIOSO);
        this.personasConvertidas = personasConvertidas;
        
    }

    public int getPersonasConvertidas() {
        return personasConvertidas;
    }

    public void setPersonasConvertidas(int personasConvertidas) {
        this.personasConvertidas = personasConvertidas;
    }
    
    
}
