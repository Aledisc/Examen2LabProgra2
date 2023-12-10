package Reproductor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import static java.awt.SystemColor.control;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;

/**
 *
 * @author Discua
 */
public class Reproductor extends javax.swing.JFrame {

    /**
     * Creates new form Reproductor
     */
    Spotify sp;

    ArrayList<String> dirs = new ArrayList();
    ArrayList<String> nombres = new ArrayList();
    DefaultListModel<String> lista = new DefaultListModel<>();
    private String archivopath;
    private String nombrearchivo;
    private Clip reproductor;
    private int posactual;
    private int contador;
    private int songactual;
    private boolean pausado;
    private boolean reproduciendo;
    private boolean reproducciontotal;
    JMenuBar menu = new JMenuBar();
    private FloatControl floatControl;

    public Reproductor() {
        //sp = new Spotify();
        //initTextArea();

        //setLocationRelativeTo(null);
        songactual = 0;
        pausado = false;
        reproduciendo = false;
        contador = 0;
        reproducciontotal = false;
        initComponents();
        setImagenPanel();
        if (floatControl != null) {
            floatControl.setValue(floatControl.getMaximum());
            actualizarProgressBar();
        }
    }

    public void setImagenPanel() {
        PanelInfo = new JPanel();
        PanelInfo.setLayout(new BorderLayout());

        URL urlImagen = getClass().getResource("descarga.jpg/");

        if (urlImagen != null) {
            ImageIcon imagen = new ImageIcon(urlImagen);

            JLabel labelImagen = new JLabel(imagen);

            PanelInfo.add(labelImagen, BorderLayout.CENTER);
        }
    }

    public void ReproducirCancion() {
        if (archivopath != null) {
            try {
                File audio = new File(archivopath);
                AudioInputStream adminaudio = AudioSystem.getAudioInputStream(audio);
                try {
                    reproductor = AudioSystem.getClip();
                    reproductor.open(adminaudio);
                    BotonPlayPause.setText("||");
                    if (posactual == 0) {
                        reproduciendo = true;
                        reproductor.start();
                        ConectarProgreso();
                    } else {
                        Reanudar();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void agregarCancion() {
        ActionListener[] actionListeners = AgregarCancionBtn.getActionListeners();
        for (ActionListener listener : actionListeners) {
            AgregarCancionBtn.removeActionListener(listener);
        }
        AgregarCancionBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Solo archivos .WAV");
                JFileChooser selectorsong = new JFileChooser();
                FileNameExtensionFilter filtrar = new FileNameExtensionFilter("Archivos de Audio", "wav");

                selectorsong.setFileFilter(filtrar);

                int eleccion = selectorsong.showOpenDialog(menu);
                if (eleccion == selectorsong.APPROVE_OPTION) {
                    File fichero = selectorsong.getSelectedFile();

                    if (!BuscarCancion(fichero.getAbsolutePath())) {
                        dirs.add(fichero.getAbsolutePath());
                        nombres.add(fichero.getName());
                        lista.addElement((contador + 1) + " - " + fichero.getName());
                        contador++;
                        ListaCanciones.setModel(lista);
                        setElementoSeleccionado(ListaCanciones, (songactual + 1) + " - " + nombrearchivo);
                    }
                }
            }
        ;
    }

    );
    }
     public void ConectarProgreso() {
        if (reproductor != null && reproduciendo) {
            Timer timer = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int duracion = reproductor.getFrameLength();
                    int posicion = reproductor.getFramePosition();
                    double porcentaje = (double) posicion / duracion * 100;
                    ProgresoCancion.setValue((int) porcentaje);
                    int possegundos = (int) (posicion / reproductor.getFormat().getFrameRate());
                    int minutos = possegundos / 60;
                    int segundoss = possegundos % 60;
                    TiempoActual.setText(String.format("%02d:%02d", minutos, segundoss));

                    if (porcentaje >= 100) {
                        posactual = 0;
                        reproduciendo = false;
                        pausado = false;
                        if (reproducciontotal) {
                            if (songactual < dirs.size()) {
                                songactual++;
                                SiguienteAnteriorCancion(true);
                            } else {
                                reproducciontotal = false;
                            }
                        }
                    }
                }
            });
            timer.start();
        }
    }

    public void Seleccionar() {
        String pos = ListaCanciones.getSelectedValue();
        if (pos != null) {
            String[] separador = pos.split("\\s+");
            int indice = Integer.valueOf(separador[0]) - 1;
            songactual = indice + 1;
            archivopath = dirs.get(indice);
            nombrearchivo = nombres.get(indice);
            NombreCancion.setText(nombrearchivo);
            reproducciontotal = false;
            Parar();
            try {
                File audio = new File(archivopath);
                AudioInputStream adminaudio = AudioSystem.getAudioInputStream(audio);
                reproductor = AudioSystem.getClip();
                reproductor.open(adminaudio);
                int duracion = (int) ((reproductor.getFrameLength()) / reproductor.getFormat().getFrameRate());
                int minutos = duracion / 60;
                int segundoss = duracion % 60;
                TiempoTotal.setText(String.format("%02d:%02d", minutos, segundoss));
            } catch (Exception e) {

            }
            if (reproduciendo == true) {
                reproductor.close();
                ProgresoCancion.setValue(0);
                posactual = 0;
                TiempoActual.setText("00:00");
            }
        }
    }

    public void SiguienteAnteriorCancion(boolean siguiente) {
        for (int i = 0; i < dirs.size(); i++) {
            if (archivopath.equals(dirs.get(i))) {
                if (siguiente) {
                    if (siguiente && (i + 1 < dirs.size())) {
                        Parar();
                        archivopath = dirs.get(i + 1);
                        nombrearchivo = nombres.get(i + 1);
                        setElementoSeleccionado(ListaCanciones, (i + 2) + " - " + nombrearchivo);
                    }
                } else {
                    if (!siguiente && (i - 1 > -1)) {
                        Parar();
                        archivopath = dirs.get(i - 1);
                        nombrearchivo = nombres.get(i - 1);
                        setElementoSeleccionado(ListaCanciones, (i) + " - " + nombrearchivo);
                    }
                }
                if ((siguiente && (i + 1 < dirs.size())) || (!siguiente && (i - 1 > -1))) {
                    NombreCancion.setText(nombrearchivo);
                    try {
                        File audio = new File(archivopath);
                        AudioInputStream adminaudio = AudioSystem.getAudioInputStream(audio);
                        reproductor = AudioSystem.getClip();
                        reproductor.open(adminaudio);
                        int duracion = (int) ((reproductor.getFrameLength()) / reproductor.getFormat().getFrameRate());
                        int minutos = duracion / 60;
                        int segundoss = duracion % 60;
                        TiempoTotal.setText(String.format("%02d:%02d", minutos, segundoss));
                        ReproducirCancion();
                    } catch (Exception e) {

                    }
                }
            }
        }
    }

    public void subirVolumen(Clip clip) {
        if (floatControl == null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        if (floatControl != null) {
            float incremento = 2f; 
            float nuevoVolumen = Math.min(floatControl.getValue() + incremento, floatControl.getMaximum());
            floatControl.setValue(nuevoVolumen);
        }
        actualizarProgressBar();
    }

    public void bajarVolumen(Clip clip) {
        if (floatControl == null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        if (floatControl != null) {
            float decremento = 2f; 
            float nuevoVolumen = Math.max(floatControl.getValue() - decremento, floatControl.getMinimum());
            floatControl.setValue(nuevoVolumen);
        }
        actualizarProgressBar();
    }

    private void actualizarProgressBar() {
        if (floatControl != null && floatControl.getMinimum() != floatControl.getMaximum()) {
            float minimumVolume = floatControl.getMinimum();
            float maximumVolume = floatControl.getMaximum();
            float currentVolume = floatControl.getValue();

            
            int progressValue = Math.round(((currentVolume - minimumVolume) / (maximumVolume - minimumVolume)) * 100);
            volumenBar.setValue(progressValue);
        }
    }

    public void setElementoSeleccionado(JList<String> listacanciones, String cancion) {
        DefaultListModel<String> modelo = (DefaultListModel) listacanciones.getModel();
        int indice = -1;
        for (int i = 0; i < modelo.getSize(); i++) {
            if (modelo.getElementAt(i).equals(cancion)) {
                indice = i;
            }
        }
        ListaCanciones.setSelectedIndex(indice);
    }

    public void Parar() {
        if (reproductor != null) {
            reproductor.close();
            BotonPlayPause.setText(">");
            posactual = 0;
            reproduciendo = false;
            pausado = false;
        }
    }

    public void Pausar() {
        if (reproductor != null) {
            BotonPlayPause.setText(">");
            posactual = reproductor.getFramePosition();
            reproductor.stop();
            reproduciendo = false;
            pausado = true;
        }
    }

    public void Reanudar() {
        if (reproductor != null && pausado) {
            BotonPlayPause.setText("||");
            reproductor.setFramePosition(posactual);
            reproductor.start();
            reproduciendo = true;
            pausado = false;
        }
    }

    public boolean BuscarCancion(String path) {
        boolean esta = false;
        for (String dir : dirs) {
            if (dir.equals(path)) {
                esta = true;
            }
        }
        return esta;
    }

//    private void initTextArea() {
//        areaCanciones = new JTextArea();
//        areaCanciones.setEditable(false);
//        
//        ArrayList<String> canciones = obtenerCancionesDeCarpeta(); 
//        
//        StringBuilder cancionesTexto = new StringBuilder();
//        for (String cancion : canciones) {
//            cancionesTexto.append(cancion).append("\n");
//        }
//
//        // Establecer el texto en el JTextArea
//        areaCanciones.setText(cancionesTexto.toString());
//
//        //setVisible(true);
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoReproductor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelCanciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaCanciones = new javax.swing.JList<>();
        PanelControl = new javax.swing.JPanel();
        ProgresoCancion = new javax.swing.JProgressBar();
        volumenBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BotonPlayPause = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        TiempoActual = new javax.swing.JLabel();
        TiempoTotal = new javax.swing.JLabel();
        PararBtn = new javax.swing.JButton();
        AgregarCancionBtn = new javax.swing.JButton();
        SeleccionarCancionBtn = new javax.swing.JButton();
        NombreCancion = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        LabelAutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor");
        setBackground(new java.awt.Color(0, 0, 0));

        FondoReproductor.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Java Spotify");

        PanelCanciones.setBackground(new java.awt.Color(18, 18, 18));

        ListaCanciones.setBackground(new java.awt.Color(26, 26, 26));
        ListaCanciones.setForeground(new java.awt.Color(0, 153, 0));
        jScrollPane2.setViewportView(ListaCanciones);

        javax.swing.GroupLayout PanelCancionesLayout = new javax.swing.GroupLayout(PanelCanciones);
        PanelCanciones.setLayout(PanelCancionesLayout);
        PanelCancionesLayout.setHorizontalGroup(
            PanelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCancionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelCancionesLayout.setVerticalGroup(
            PanelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCancionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelControl.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Volume:");

        jButton1.setBackground(new java.awt.Color(78, 78, 78));
        jButton1.setText("+ Vol");
        jButton1.setPreferredSize(new java.awt.Dimension(76, 22));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(78, 78, 78));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("- Vol");
        jButton2.setPreferredSize(new java.awt.Dimension(76, 22));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BotonPlayPause.setBackground(new java.awt.Color(78, 78, 78));
        BotonPlayPause.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonPlayPause.setText("►");
        BotonPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPlayPauseActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(78, 78, 78));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setText("«");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(78, 78, 78));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("»");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        TiempoActual.setForeground(new java.awt.Color(255, 255, 255));
        TiempoActual.setText("00:00");

        TiempoTotal.setForeground(new java.awt.Color(255, 255, 255));
        TiempoTotal.setText("00:00");

        PararBtn.setBackground(new java.awt.Color(78, 78, 78));
        PararBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PararBtn.setText("■");
        PararBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PararBtnActionPerformed(evt);
            }
        });

        AgregarCancionBtn.setBackground(new java.awt.Color(78, 78, 78));
        AgregarCancionBtn.setText("Add");
        AgregarCancionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCancionBtnActionPerformed(evt);
            }
        });

        SeleccionarCancionBtn.setBackground(new java.awt.Color(78, 78, 78));
        SeleccionarCancionBtn.setText("Select");
        SeleccionarCancionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarCancionBtnActionPerformed(evt);
            }
        });

        NombreCancion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NombreCancion.setForeground(new java.awt.Color(255, 255, 255));
        NombreCancion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PanelControlLayout = new javax.swing.GroupLayout(PanelControl);
        PanelControl.setLayout(PanelControlLayout);
        PanelControlLayout.setHorizontalGroup(
            PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlLayout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addGroup(PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlLayout.createSequentialGroup()
                        .addComponent(SeleccionarCancionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PararBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonPlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AgregarCancionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlLayout.createSequentialGroup()
                        .addComponent(TiempoActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProgresoCancion, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TiempoTotal)
                        .addGap(82, 82, 82)))
                .addGroup(PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelControlLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(volumenBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        PanelControlLayout.setVerticalGroup(
            PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(NombreCancion, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(volumenBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ProgresoCancion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TiempoActual, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TiempoTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPlayPause)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(PararBtn)
                    .addComponent(AgregarCancionBtn)
                    .addComponent(SeleccionarCancionBtn))
                .addGap(47, 47, 47))
        );

        PanelInfo.setBackground(new java.awt.Color(18, 18, 18));

        LabelAutor.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(LabelAutor)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(LabelAutor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FondoReproductorLayout = new javax.swing.GroupLayout(FondoReproductor);
        FondoReproductor.setLayout(FondoReproductorLayout);
        FondoReproductorLayout.setHorizontalGroup(
            FondoReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoReproductorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoReproductorLayout.createSequentialGroup()
                        .addComponent(PanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FondoReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(PanelCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoReproductorLayout.setVerticalGroup(
            FondoReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoReproductorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoReproductorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FondoReproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FondoReproductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            subirVolumen(reproductor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AgregarCancionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCancionBtnActionPerformed
        // TODO add your handling code here:
        agregarCancion();
    }//GEN-LAST:event_AgregarCancionBtnActionPerformed

    private void SeleccionarCancionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarCancionBtnActionPerformed
        Seleccionar();
    }//GEN-LAST:event_SeleccionarCancionBtnActionPerformed

    private void BotonPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPlayPauseActionPerformed
        if (reproduciendo == false) {
            if (archivopath != null) {
                ReproducirCancion();
            }
        } else {
            Pausar();
        }
    }//GEN-LAST:event_BotonPlayPauseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            bajarVolumen(reproductor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        SiguienteAnteriorCancion(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        SiguienteAnteriorCancion(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void PararBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PararBtnActionPerformed
        // TODO add your handling code here:
        Parar();
    }//GEN-LAST:event_PararBtnActionPerformed

//    private void agregarCancion() {
//        JFileChooser fileChooser = new JFileChooser();
//
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos MP3", "mp3"));
//
//        int result = fileChooser.showOpenDialog(null);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            // Obtener el archivo seleccionado
//            File selectedFile = fileChooser.getSelectedFile();
//
//            // Verificar si es un archivo mp3
//            if (selectedFile.getName().toLowerCase().endsWith(".mp3")) {
//                // Ruta del archivo seleccionado
//                String sourcePath = selectedFile.getAbsolutePath();
//
//                // Ruta del directorio de canciones
//                String destinoPath = "spotify/canciones/" + selectedFile.getName();
//
//                try {
//                    // Mover el archivo seleccionado al directorio de canciones
//                    Path origen = selectedFile.toPath();
//                    Path destino = Paths.get(destinoPath);
//                    Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
//
//                    String rutaArchivoMP3 = destinoPath;
//
//                    try {
//
//                        File archivoMP3 = new File(rutaArchivoMP3);
//                        AudioFile audioFile = AudioFileIO.read(archivoMP3);
//
//                        Tag tag = audioFile.getTag();
//
//                        if (tag != null) {
//                            String titulo = tag.getFirst(FieldKey.TITLE);
//                            String artista = tag.getFirst(FieldKey.ARTIST);
//                            String album = tag.getFirst(FieldKey.ALBUM);
//                            int duracion = audioFile.getAudioHeader().getTrackLength();
//                            //Artwork artwork = tag.getFirstArtwork();
//
//                            // Mostrar los metadatos obtenidos
//                            System.out.println("Titulo: " + titulo);
//                            System.out.println("Artista: " + artista);
//                            System.out.println("Album: " + album);
//                            System.out.println("Duracon: " + duracion);
//
//                            // Ruta de la carpeta de imágenes
//                            String rutaCarpetaImagenes = "spotify/imagenes/";
//
//                            // Guardar la imagen en un archivo (opcional)
//                            String nombreArchivoImagen = titulo + ".jpg";
//                            Path rutaImagen = Paths.get("spotify/imagenes/" + nombreArchivoImagen);
//
//                            Optional<Artwork> optionalArtwork = Optional.ofNullable(tag.getFirstArtwork());
//                            optionalArtwork.ifPresent(artwork -> {
//
//                                try {
//                                    byte[] imageData = artwork.getBinaryData();
//                                    Files.write(rutaImagen, imageData);
//                                    System.out.println("Imagen guardada en " + rutaCarpetaImagenes + nombreArchivoImagen);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            });
//                            if (!optionalArtwork.isPresent()) {
//                                System.out.println("No se encontro una portada");
//                            }
//
//                            sp.agregarCancion(titulo, duracion, artista, destinoPath, rutaCarpetaImagenes + nombreArchivoImagen);
//                        } else {
//                            System.out.println("No se encontraron metadatos");
//                        }
//
//                    } catch (Exception a) {
//                        a.printStackTrace();
//                    }
//
//                    JOptionPane.showMessageDialog(null, "Canción agregada correctamente.");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    JOptionPane.showMessageDialog(null, "Error al agregar la canción.");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Por favor, selecciona un archivo MP3.");
//            }
//        }
//    }
//    private ArrayList<String> obtenerCancionesDeCarpeta() {
//        ArrayList<String> listaCanciones = new ArrayList<>();
//        File carpeta = new File("spotify/canciones/");
//
//        if (carpeta.isDirectory()) {
//            File[] archivos = carpeta.listFiles();
//            if (archivos != null) {
//                for (File archivo : archivos) {
//                    if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".mp3")) {
//                        listaCanciones.add(archivo.getName());
//                        System.out.println(archivo);
//                    }
//                }
//            }
//        }
//        return listaCanciones;
//    }
//    String selectedFilePath;
//    private void seleccionarCancion() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//        JFileChooser fileChooser = new JFileChooser("spotify/canciones");
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos MP3", "mp3");
//        fileChooser.setFileFilter(filter);
//        
//        int returnValue = fileChooser.showOpenDialog(null);
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fileChooser.getSelectedFile();
//            //selectedFilePath = selectedFile.getAbsolutePath();
//            
//            AudioInputStream audiInputStream = AudioSystem.getAudioInputStream(selectedFile);
//            
//            clip = AudioSystem.getClip();
//            
//            clip.open(audiInputStream);
//        }
//        
//        
//    }
    //private Image backGroundImage;
//    private void reproducirCancion() throws IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
//        if (selectedFilePath != null) {
//            try {
//                AudioFile audioFile = AudioFileIO.read(new File(selectedFilePath));
//                Tag tag = audioFile.getTag();
//                String songTitle = tag.getFirst(FieldKey.TITLE);
//                NombreCancion.setText(songTitle);
//                
//                String autor = tag.getFirst(FieldKey.ARTIST);
//                LabelAutor.setText(autor);
//                
//                
////                try{
////                    backGroundImage = ImageIO.read(new File());
////                }
//                // Aquí puedes utilizar JAudiotagger para obtener información adicional si es necesario
//                
//                // Tu lógica para reproducir la canción seleccionada con JAudiotagger
//                // Por ejemplo, usar un reproductor que soporte reproducción desde archivo o flujo de audio
//            } catch (CannotReadException e) {
//                e.printStackTrace();
//                // Manejar la excepción, por ejemplo, mostrando un mensaje de error
//                System.out.println(e.getMessage());
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No ha seleccionado una cancion");
//            // Mostrar un mensaje indicando que no se ha seleccionado ninguna canción
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reproductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCancionBtn;
    private javax.swing.JButton BotonPlayPause;
    private javax.swing.JPanel FondoReproductor;
    private javax.swing.JLabel LabelAutor;
    private javax.swing.JList<String> ListaCanciones;
    private javax.swing.JLabel NombreCancion;
    private javax.swing.JPanel PanelCanciones;
    private javax.swing.JPanel PanelControl;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JButton PararBtn;
    private javax.swing.JProgressBar ProgresoCancion;
    private javax.swing.JButton SeleccionarCancionBtn;
    private javax.swing.JLabel TiempoActual;
    private javax.swing.JLabel TiempoTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JProgressBar volumenBar;
    // End of variables declaration//GEN-END:variables
}
