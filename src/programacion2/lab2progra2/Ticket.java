package programacion2.lab2progra2;

public class Ticket {

    private String nombrepasajero;
    private double totalpagar;

    public Ticket(String nombrepasajero, double totalpagar) {
        this.nombrepasajero = nombrepasajero;
        this.totalpagar = totalpagar;
    }

    public String getNombrepasajero() {
        return nombrepasajero;
    }

    public double getTotalpagar() {
        return totalpagar;
    }

    public void print() {
        System.out.println("" + this.nombrepasajero + "" + this.totalpagar);
    }
}
