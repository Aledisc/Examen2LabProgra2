/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2.ahorcado;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminPalabrasSecretas {

    private List<String> palabrasSecretas;
    private Random random;

    public AdminPalabrasSecretas() {
        palabrasSecretas = new ArrayList<>();
        random = new Random();
    }

    public void agregarPalabraSecreta(String palabraSecreta) {
        palabrasSecretas.add(palabraSecreta);
    }

    public String seleccionarPalabraAlAzar() {

        int indiceAleatorio = random.nextInt(palabrasSecretas.size());
        return palabrasSecretas.get(indiceAleatorio);
    }

    public List<String> obtenerPalabrasSecretas() {
        return palabrasSecretas;
    }
    
}
