package Reproductor;

/**
 *
 * @author Discua
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JList;
import javax.swing.Timer;


public class Spotify {
    
    
    protected RandomAccessFile listaCanciones;
    
    
    public Spotify(){
        try{
           File s = new File("spotify");
           s.mkdir();
           File imagenes = new File("spotify/imagenes");
           imagenes.mkdir();
           File canciones = new File("spotify/canciones");
           canciones.mkdir();
           listaCanciones = new RandomAccessFile("spotify/canciones.sptf","rw");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
            
            
    public void agregarCancion(String nombre, long duracion, String autor, String path, String pathImage) throws IOException{
        //FORMATO: String nombre, int duracion, String autor, String path, String pathImagen
        listaCanciones.seek(listaCanciones.length());
        listaCanciones.writeUTF(nombre);
        listaCanciones.writeLong(duracion);
        listaCanciones.writeUTF(autor);
        listaCanciones.writeUTF(path);
        listaCanciones.writeUTF(pathImage);
        
    }
    
    
        
}
