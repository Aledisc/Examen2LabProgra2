/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2.ahorcado;

import java.util.Random;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    AhorcadoMain am = new AhorcadoMain();

    private static final String[] palabrasPosibles = {"papel", "carro", "mesa", "silla", "lapiz"};

    public JuegoAhorcadoAzar(String palabraSecreta, int intentos) {
        super(palabraSecreta, intentos);
        int indice = (int) (Math.random() * palabrasPosibles.length);
        this.palabraSecreta = palabrasPosibles[indice];
        this.palabraActual = "_".repeat(palabraSecreta.length());
    }

    public void inicializarPalabraSecreta() {
        
    }

    public void jugar() {
        while (intentos > 0 && !Ganar()) {

            char letra = am.getLetra2();
            if (verificarLetra(letra)) {
                actualizarPalabraActual(letra);
            } else {
                intentos--;

            }
        }
    }

    public void actualizarPalabraActual(char letra) {

        StringBuilder nuevaPalabra = new StringBuilder(palabraActual);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nuevaPalabra.setCharAt(i, letra);
            }
        }
        palabraActual = nuevaPalabra.toString();
    }

    public boolean verificarLetra(char letra) {

        return palabraSecreta.contains(String.valueOf(letra));
    }

    public boolean hasGanado() {
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
}
