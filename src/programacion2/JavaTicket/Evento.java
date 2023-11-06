package programacion2.JavaTicket;

//import com.toedter.calendar.JCalendar;

public class Evento {

    private String nombreEvento;
    private TipoEvento tipoEvento;
    private double valorRenta;
    private int capacidadEvento;
    private double costoGrama;
    
    
    public Evento(String nombreEvento, TipoEvento tipoEvento) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.valorRenta = valorRenta;
        
        if (tipoEvento == TipoEvento.MUSICAL) {
            capacidadEvento = 25000;
            valorRenta = 50000;
        } else if (tipoEvento == TipoEvento.DEPORTIVO) {
            capacidadEvento = 20000;
            valorRenta = 35000;
        } else if (tipoEvento == TipoEvento.RELIGIOSO) {
            capacidadEvento = 30000;
            valorRenta = 15000;
        }
    }
}


