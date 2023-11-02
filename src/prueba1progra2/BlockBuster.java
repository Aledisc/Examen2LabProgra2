/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1progra2;

import java.util.ArrayList;

public class BlockBuster {
    private ArrayList<BlockBusterItem> items;

    public BlockBuster() {
        this.items = new ArrayList<>();
    }

    public BlockBusterItem buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (item.getCodigo() == codigo) {
                if ((tipo.equals("MOVIE") && item instanceof MovieItem) || (tipo.equals("GAME") && item instanceof VideoGameItem)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void agregarItem(int codigo, String nombre, String tipoItem) {
        if (buscarItem(codigo, tipoItem) == null) {
            double precioRenta;
            String estado;


            if (tipoItem.equals("MOVIE")) {
                MovieItem movieItem = new MovieItem(codigo, nombre, tipoItem);
                items.add(movieItem);
            } else if (tipoItem.equals("GAME")) {
                VideoGameItem videoGameItem = new VideoGameItem(codigo, nombre, tipoItem);
                items.add(videoGameItem);
            }

        } else {
        }
    }

    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
            double montoAPagar = item.pagoRenta(dias);
        } else {
            
        }
    }

    public void auditarMovieEstados() {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).evaluarEstado();
            }
        }
    }
}
