/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Examen2LabProgra2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class PSN extends javax.swing.JFrame {

    /**
     * Creates new form PSN
     */
    PSNUsers psn;

    public PSN() throws IOException {
        initComponents();

        psn = new PSNUsers();
        initPaneles();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initPaneles() {
        PanelMenu.setVisible(true);
        PanelAgregarUsuario.setVisible(false);
        PanelDesactivar.setVisible(false);
        PanelTrofeos.setVisible(false);
        PanelPerfil.setVisible(false);
        this.setSize(1010, 520);
        this.setLocation(500, 250);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        PanelAgregarUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextFieldUsernameAgregar = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        PanelDesactivar = new javax.swing.JPanel();
        DesactivarBoton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFUserDesactivar = new javax.swing.JTextField();
        PanelTrofeos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TFUserTrofeos = new javax.swing.JTextField();
        TFJuegoTrofeos = new javax.swing.JTextField();
        TFNombreTrofeo = new javax.swing.JTextField();
        ListaTipoTrofeo = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        PanelPerfil = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TFUserPerfil = new javax.swing.JTextField();
        BuscarPerfil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaPerfil = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMenu.setBackground(new java.awt.Color(6, 63, 170));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setText("PlayStation™ Network");

        jButton1.setText("Agregar un usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Desactivar usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar un trofeo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ver un perfil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(447, 447, 447)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton5)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        PanelAgregarUsuario.setBackground(new java.awt.Color(6, 63, 170));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setText("Agregar usuario");

        jLabel3.setText("Username:");

        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Regresar al menu");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAgregarUsuarioLayout = new javax.swing.GroupLayout(PanelAgregarUsuario);
        PanelAgregarUsuario.setLayout(PanelAgregarUsuarioLayout);
        PanelAgregarUsuarioLayout.setHorizontalGroup(
            PanelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgregarUsuarioLayout.createSequentialGroup()
                .addGroup(PanelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAgregarUsuarioLayout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(jLabel2))
                    .addGroup(PanelAgregarUsuarioLayout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldUsernameAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAgregarUsuarioLayout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(jButton6)
                        .addGap(38, 38, 38)
                        .addComponent(jButton7)))
                .addContainerGap(388, Short.MAX_VALUE))
        );
        PanelAgregarUsuarioLayout.setVerticalGroup(
            PanelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgregarUsuarioLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(70, 70, 70)
                .addGroup(PanelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextFieldUsernameAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(PanelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        PanelDesactivar.setBackground(new java.awt.Color(6, 63, 170));

        DesactivarBoton.setText("Desactivar");
        DesactivarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesactivarBotonActionPerformed(evt);
            }
        });

        jButton9.setText("Regresar al menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Desactivar cuenta");

        jLabel5.setText("Username: ");

        javax.swing.GroupLayout PanelDesactivarLayout = new javax.swing.GroupLayout(PanelDesactivar);
        PanelDesactivar.setLayout(PanelDesactivarLayout);
        PanelDesactivarLayout.setHorizontalGroup(
            PanelDesactivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDesactivarLayout.createSequentialGroup()
                .addGroup(PanelDesactivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDesactivarLayout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(DesactivarBoton)
                        .addGap(42, 42, 42)
                        .addComponent(jButton9))
                    .addGroup(PanelDesactivarLayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel4))
                    .addGroup(PanelDesactivarLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(TFUserDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        PanelDesactivarLayout.setVerticalGroup(
            PanelDesactivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDesactivarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(PanelDesactivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFUserDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(PanelDesactivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DesactivarBoton)
                    .addComponent(jButton9))
                .addGap(135, 135, 135))
        );

        PanelTrofeos.setBackground(new java.awt.Color(6, 63, 170));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Agregar trofeo");

        jLabel7.setText("Username:");

        jLabel8.setText("Juego:");

        jLabel9.setText("Nombre del trofeo:");

        jLabel10.setText("Tipo de trofeo:");

        ListaTipoTrofeo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLATINO", "ORO", "PLATA", "BRONCE" }));

        jButton8.setText("Agregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setText("Volver al menu");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTrofeosLayout = new javax.swing.GroupLayout(PanelTrofeos);
        PanelTrofeos.setLayout(PanelTrofeosLayout);
        PanelTrofeosLayout.setHorizontalGroup(
            PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTrofeosLayout.createSequentialGroup()
                .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTrofeosLayout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(jLabel6))
                    .addGroup(PanelTrofeosLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFUserTrofeos)
                            .addComponent(TFJuegoTrofeos)
                            .addComponent(TFNombreTrofeo)
                            .addComponent(ListaTipoTrofeo, 0, 191, Short.MAX_VALUE)))
                    .addGroup(PanelTrofeosLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jButton8)
                        .addGap(59, 59, 59)
                        .addComponent(jButton10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTrofeosLayout.setVerticalGroup(
            PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTrofeosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TFUserTrofeos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TFJuegoTrofeos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TFNombreTrofeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(ListaTipoTrofeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(PanelTrofeosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton10))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        PanelPerfil.setBackground(new java.awt.Color(6, 63, 170));

        jLabel11.setText("Ver perfil");

        jLabel12.setText("Username:");

        BuscarPerfil.setText("Buscar");
        BuscarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPerfilActionPerformed(evt);
            }
        });

        AreaPerfil.setColumns(20);
        AreaPerfil.setRows(5);
        jScrollPane1.setViewportView(AreaPerfil);

        jButton11.setText("Volver al menu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPerfilLayout = new javax.swing.GroupLayout(PanelPerfil);
        PanelPerfil.setLayout(PanelPerfilLayout);
        PanelPerfilLayout.setHorizontalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(TFUserPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarPerfil))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(jLabel11))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(427, 427, 427)
                        .addComponent(jButton11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPerfilLayout.setVerticalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel11)
                .addGap(29, 29, 29)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TFUserPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAgregarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTrofeos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTrofeos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PanelMenu.setVisible(false);
        PanelDesactivar.setVisible(true);
        this.setSize(1010, 400);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setSize(1010, 400);
        PanelMenu.setVisible(false);
        PanelAgregarUsuario.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (!TextFieldUsernameAgregar.getText().isBlank()) {
                psn.addUser(TextFieldUsernameAgregar.getText());
                //JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
                TextFieldUsernameAgregar.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        PanelAgregarUsuario.setVisible(false);
        PanelMenu.setVisible(true);
        TextFieldUsernameAgregar.setText("");
        this.setSize(1010, 520);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void DesactivarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesactivarBotonActionPerformed
        try {
            if (!TFUserDesactivar.getText().isBlank()) {
                psn.deactivateUser(TFUserDesactivar.getText());
                TFUserDesactivar.setText("");
                //JOptionPane.showMessageDialog(null, "Cuenta desactivada");
            } else {
                TFUserDesactivar.setText("");
                JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_DesactivarBotonActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        PanelMenu.setVisible(true);
        PanelDesactivar.setVisible(false);
        TFUserDesactivar.setText("");
        this.setSize(1010, 520);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String tipo = ListaTipoTrofeo.getSelectedItem().toString();

        Trophy trofeo = null;
        switch (tipo) {
            case "PLATINO":
                trofeo = Trophy.PLATINO;
                break;
            case "ORO":
                trofeo = Trophy.ORO;
                break;
            case "PLATA":
                trofeo = Trophy.PLATA;
                break;
            case "BRONCE":
                trofeo = Trophy.BRONCE;
                break;
        }

        if (!TFUserTrofeos.getText().isBlank() && !TFJuegoTrofeos.getText().isBlank() && !TFNombreTrofeo.getText().isBlank()) {
            try {
                if (psn.users.Search(TFUserTrofeos.getText()) != -1 && !psn.isDeactivated(TFUserTrofeos.getText())) {
                    psn.addTrophyTo(TFUserTrofeos.getText(), TFJuegoTrofeos.getText(), TFNombreTrofeo.getText(), trofeo);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado un usuario o la cuenta esta desactivada");
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los espacios");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        PanelTrofeos.setVisible(false);
        PanelMenu.setVisible(true);
        TFUserTrofeos.setText("");
        TFJuegoTrofeos.setText("");
        TFNombreTrofeo.setText("");
        this.setSize(1010, 520);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        PanelMenu.setVisible(false);
        PanelTrofeos.setVisible(true);
        this.setSize(1010, 400);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        PanelMenu.setVisible(false);
        PanelPerfil.setVisible(true);
        this.setSize(1010, 710);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BuscarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPerfilActionPerformed
        try {
            if (!TFUserPerfil.getText().isBlank()) {
                if (!psn.playerInfo(TFUserPerfil.getText()).equals("")) {
                    String info = psn.playerInfo(TFUserPerfil.getText());
                    AreaPerfil.setText(info);
                } else {
                    //JOptionPane.showMessageDialog(null, "No se encontro el perfil de ese usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un usuario");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_BuscarPerfilActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        TFUserPerfil.setText("");
        AreaPerfil.setText("");
        PanelPerfil.setVisible(false);
        PanelMenu.setVisible(true);
        this.setSize(1010, 520);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PSN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PSN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PSN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PSN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PSN().setVisible(true);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaPerfil;
    private javax.swing.JButton BuscarPerfil;
    private javax.swing.JButton DesactivarBoton;
    private javax.swing.JComboBox<String> ListaTipoTrofeo;
    private javax.swing.JPanel PanelAgregarUsuario;
    private javax.swing.JPanel PanelDesactivar;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelPerfil;
    private javax.swing.JPanel PanelTrofeos;
    private javax.swing.JTextField TFJuegoTrofeos;
    private javax.swing.JTextField TFNombreTrofeo;
    private javax.swing.JTextField TFUserDesactivar;
    private javax.swing.JTextField TFUserPerfil;
    private javax.swing.JTextField TFUserTrofeos;
    private javax.swing.JTextField TextFieldUsernameAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
