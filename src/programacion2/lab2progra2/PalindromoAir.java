/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2.lab2progra2;

/**
 *
 * @author Admin
 */
public class PalindromoAir {

    private Ticket[] tickets = new Ticket[30];
    boolean verificar = false;
    double price=0;
    double totalIncome;
    public int firstAvailable() {
        return firstAvailableHelper(0);
    }

    private int firstAvailableHelper(int index) {
        if (index >= tickets.length) {
            return -1;
        }
        if (tickets[index] == null) {
            return index;
        }
        return firstAvailableHelper(index + 1);
    }

    public int searchPassenger(String name) {
        return searchPassengerHelper(0, name);
    }

    private int searchPassengerHelper(int index, String name) {
        if (index >= tickets.length) {
            return -1;
        }
        if (tickets[index] != null && tickets[index].getNombrepasajero().equals(name)) {
            return index;
        }
        return searchPassengerHelper(index + 1, name);
    }

    public boolean isPalindromo(String name) {
        return isPalindromoHelper(0, name.length() - 1, name);
    }

    private boolean isPalindromoHelper(int index, int endIndex, String name) {
        if (index >= endIndex) {
            return true;
        }
        if (name.charAt(index) != name.charAt(endIndex)) {
            return false;
        }
        return isPalindromoHelper(index + 1, endIndex - 1, name);
    }

    public void printPassengers() {
        printPassengersHelper(0);
    }

    private void printPassengersHelper(int index) {
        if (index >= tickets.length) {
            return;
        }
        if (tickets[index] != null) {
            System.out.println(tickets[index].getNombrepasajero() + " - " + tickets[index].getTotalpagar());
        }
        printPassengersHelper(index + 1);
    }

    public double income() {
        return incomeHelper(0);
    }

    private double incomeHelper(int index) {
        if (index >= tickets.length) {
            return 0;
        }
        if (tickets[index] != null) {
            return tickets[index].getTotalpagar() + incomeHelper(index + 1);
        }
        return incomeHelper(index + 1);
    }

    public void reset() {
        resetHelper(0);
    }

    private void resetHelper(int index) {
        if (index >= tickets.length) {
            return;
        }
        tickets[index] = null;
        resetHelper(index + 1);
    }

    public void sellTicket(String name) {
        
        int seat = firstAvailable();
        if (seat != -1) {
            price = 800;
            if (isPalindromo(name)) {
                price *= 0.8;
                verificar = true;
            }
            tickets[seat] = new Ticket(name, price);
            System.out.println("Se vendió el boleto a " + name + " por un total de " + price);
        } else {
            System.out.println("No hay asientos disponibles");
            verificar = false;
        }
    }

    public boolean cancelTicket(String name) {
        int seat = searchPassenger(name);
        if (seat != -1) {
            tickets[seat] = null;
            return true;
        }
        return false;
    }

    public void dispatch() {
        totalIncome = income();
        System.out.println("Total de ingresos generados: " + totalIncome);
        reset();
    }
    
}
