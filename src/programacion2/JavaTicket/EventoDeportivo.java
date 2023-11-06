package programacion2.JavaTicket;

public class EventoDeportivo extends Evento{
    
    public enum TipoDeporte{
        FUTBOL, TENIS, RUGBY, BASEBALL
    }
    
    private TipoDeporte tipoDeporte;
    
    public EventoDeportivo(String nombreEvento, TipoDeporte tipoDeporte ) {
        super(nombreEvento, TipoEvento.DEPORTIVO);
        this.tipoDeporte = tipoDeporte;
        
    }
    
    public void setTipoDeporte(TipoDeporte tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }
}
