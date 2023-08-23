/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import com.mysql.cj.x.protobuf.MysqlxResultset;
import org.xml.sax.Attributes;
import java.awt.HeadlessException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.util.Vector;

import modelo.Asistencia;
import modelo.Sorteo;
import modelo.UsuarioCache;
import modelo.Actas_partido;
import modelo.Partido;

public class Inter_modulo_actas extends javax.swing.JInternalFrame {
    
    public ArrayList<Actas_partido> lista_actas = new ArrayList<>();
    private Actas_partido acta = null;

    public Inter_modulo_actas() {
        initComponents();
        llenarTabla();        
    }
    
    private void llenarArray()
    {
        acta = new Actas_partido(1, Date.valueOf(LocalDate.now()), "11:30", "14:00", 
                "Emelec","Aucas", "96 minutos", 0, 2,
                new Partido(1, "Emelec VS Aucas"), "Emelec");
        lista_actas.add(acta);
        
        acta = new Actas_partido(2, Date.valueOf(LocalDate.now()), "14:30", "16:00", 
                "Independiente","Nacional", "99 minutos", 1, 2,
                new Partido(2, "Independiente VS Nacional"), "Independiente");
        lista_actas.add(acta);
        
        acta = new Actas_partido(3, Date.valueOf(LocalDate.now()), "10:30", "12:45", 
                "Liga de Quito","Delfin", "94 minutos", 1, 0,
                new Partido(3, "Liga de Quito VS Delfin"), "Delfin");
        lista_actas.add(acta);
        
        acta = new Actas_partido(4, Date.valueOf(LocalDate.now()), "15:30", "17:45", 
                "Barcelona","Mushuc Runa", "98 minutos", 2, 2,
                new Partido(4, "Barcelona VS Mushuc Runa"), "Empate");
        lista_actas.add(acta);
        
    }
    
    private void llenarTabla()
    {
        llenarArray();
                
        for (int fila = 0; fila <lista_actas.size(); fila++)
        {
            acta = (Actas_partido)lista_actas.get(fila);
            llenarFilas(fila, acta);                        
        }
        
    }    
    
    private void llenarFilas(int fila, Actas_partido acta)
    {
        DefaultTableModel tabla = (DefaultTableModel)table_actas.getModel();
        
        tabla.addRow(new Object[1]);
        table_actas.setValueAt(fila+1, fila, 0);
            table_actas.setValueAt(acta.getFecha_emision(), fila, 1);
            table_actas.setValueAt(acta.getHora_inicio_partido(), fila, 2);
            table_actas.setValueAt(acta.getHora_fin_partido(), fila, 3);
            table_actas.setValueAt(acta.getPartido().getPartido_descripcion(), fila, 4);
            table_actas.setValueAt(acta.getGoles_equipo_local(), fila, 5);
            table_actas.setValueAt(acta.getGoles_equipo_rival(), fila,6);
            table_actas.setValueAt(acta.getEquipo_ganador(), fila, 7);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        goles_local_text_box = new javax.swing.JTextField();
        partido_combo = new javax.swing.JComboBox<>();
        goles_rival_text_box = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fecha_emision = new com.toedter.calendar.JDateChooser();
        hora_fin_text_box = new javax.swing.JFormattedTextField();
        hora_inicio_text_box = new javax.swing.JFormattedTextField();
        equipo_ganador_text = new javax.swing.JLabel();
        duracion_partido_text = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        combo_buscar = new javax.swing.JComboBox<>();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_actas = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        boton_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear/Modificar Acta"));
        jPanel2.setForeground(new java.awt.Color(57, 120, 25));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel4.setText("Fecha de emisión:");

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel5.setText("Hora inicio partido:");

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel6.setText("Hora fin partido:");

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel7.setText("Partido:");

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel9.setText("Duración partido:");

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel10.setText("Goles equipo local:");

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel11.setText("Goles equipo rival:");

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel12.setText("Equipo ganador:");

        goles_local_text_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                goles_local_text_boxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                goles_local_text_boxKeyTyped(evt);
            }
        });

        partido_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emelec VS Independiente", "Delfin VS Liga de Loja", "Barcelona VS Aucas" }));
        partido_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                partido_comboItemStateChanged(evt);
            }
        });
        partido_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partido_comboActionPerformed(evt);
            }
        });

        goles_rival_text_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                goles_rival_text_boxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                goles_rival_text_boxKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 102));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 204));
        jButton2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        hora_fin_text_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hora_fin_text_boxKeyReleased(evt);
            }
        });

        equipo_ganador_text.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        equipo_ganador_text.setText("EQUIPO");

        duracion_partido_text.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        duracion_partido_text.setText("00:00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(partido_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_emision, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hora_inicio_text_box, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hora_fin_text_box, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(duracion_partido_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(equipo_ganador_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(goles_rival_text_box)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(goles_local_text_box)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hora_inicio_text_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(hora_fin_text_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(partido_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(duracion_partido_text)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goles_local_text_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goles_rival_text_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(equipo_ganador_text)
                    .addComponent(jLabel12))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 430));

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel13.setText("Seleccione un registro para realizar una acción.");

        jLabel14.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel14.setText("Buscar por:");

        combo_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fecha", "Equipo", "Partido" }));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });

        table_actas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Fecha emision", "Hora Inicio", "Hora Fin", "Partido", "Goles Local", "Goles Rival", "Equipo Ganador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_actas);

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        boton_buscar.setBackground(new java.awt.Color(0, 102, 204));
        boton_buscar.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        boton_buscar.setText("Buscar");
        boton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addComponent(jLabel13)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boton_buscar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_buscar)
                    .addComponent(jLabel14)
                    .addComponent(txt_buscar)
                    .addComponent(boton_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(100, 100, 100))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 700, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utea.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
   
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void boton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscarActionPerformed
        
    }//GEN-LAST:event_boton_buscarActionPerformed

    private void goles_local_text_boxKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_goles_local_text_boxKeyReleased
    }
    private void goles_rival_text_boxKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_goles_rival_text_boxKeyReleased
    }// GEN-LAST:event_goles_rival_text_boxKeyReleased

    private void hora_fin_text_boxKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_hora_fin_text_boxKeyReleased

    }// GEN-LAST:event_hora_fin_text_boxKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        fecha_emision.setDate(Date.valueOf(LocalDate.now()));
        hora_inicio_text_box.setText("");
        hora_fin_text_box.setText("");
        duracion_partido_text.setText("");
        partido_combo.setSelectedIndex(0);
        goles_local_text_box.setText("");
        goles_rival_text_box.setText("");
        equipo_ganador_text.setText("");
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        
        DefaultTableModel tabla = (DefaultTableModel)table_actas.getModel();
        int filas = tabla.getRowCount();
        
        tabla.addRow(new Object[1]);
        table_actas.setValueAt(filas+1, filas, 0);
        table_actas.setValueAt(fecha_emision.getDate(), filas, 1);
        table_actas.setValueAt(hora_inicio_text_box.getText(), filas, 2);
        table_actas.setValueAt(hora_fin_text_box.getText(), filas, 3);
        table_actas.setValueAt(partido_combo.getSelectedItem(), filas, 4);
        table_actas.setValueAt(goles_local_text_box.getText(), filas, 5);
        table_actas.setValueAt(goles_rival_text_box.getText(), filas,6);
        table_actas.setValueAt(equipo_ganador_text.getText(), filas, 7);
        
        
    }// GEN-LAST:event_jButton1ActionPerformed

    private void goles_rival_text_boxKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_goles_rival_text_boxKeyTyped

    }// GEN-LAST:event_goles_rival_text_boxKeyTyped

    private void partido_comboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_partido_comboActionPerformed
    }// GEN-LAST:event_partido_comboActionPerformed

    private void partido_comboItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_partido_comboItemStateChanged
    }// GEN-LAST:event_partido_comboItemStateChanged

    private void goles_local_text_boxKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_goles_local_text_boxKeyTyped

    }// GEN-LAST:event_goles_local_text_boxKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel tabla = (DefaultTableModel)table_actas.getModel();
        int fila_select = table_actas.getSelectedRow();
        if(tabla.getRowCount()>0)
        {
            tabla.removeRow(fila_select);
        }
    }// GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        
        int fila_select = table_actas.getSelectedRow();
        
        fecha_emision.setDateFormatString(table_actas.getValueAt(fila_select, 1).toString());
        hora_inicio_text_box.setText(table_actas.getValueAt(fila_select, 2).toString());
        hora_fin_text_box.setText(table_actas.getValueAt(fila_select, 3).toString());
        partido_combo.setSelectedItem(table_actas.getValueAt(fila_select, 4).toString());
        goles_local_text_box.setText(table_actas.getValueAt(fila_select, 5).toString());
        goles_rival_text_box.setText(table_actas.getValueAt(fila_select, 6).toString());
        equipo_ganador_text.setText(table_actas.getValueAt(fila_select, 7).toString());
    }// GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed

    }// GEN-LAST:event_jButton3ActionPerformed

    private void equipo_ganador_text_boxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_equipo_ganador_text_boxActionPerformed

    }// GEN-LAST:event_equipo_ganador_text_boxActionPerformed

    private void goles_local_text_boxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_goles_local_text_boxActionPerformed

    }// GEN-LAST:event_goles_local_text_boxActionPerformed

    private void goles_rival_text_boxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_goles_rival_text_boxActionPerformed

    }// GEN-LAST:event_goles_rival_text_boxActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_buscar;
    private javax.swing.JComboBox<String> combo_buscar;
    private javax.swing.JLabel duracion_partido_text;
    private javax.swing.JLabel equipo_ganador_text;
    private com.toedter.calendar.JDateChooser fecha_emision;
    private javax.swing.JTextField goles_local_text_box;
    private javax.swing.JTextField goles_rival_text_box;
    private javax.swing.JFormattedTextField hora_fin_text_box;
    private javax.swing.JFormattedTextField hora_inicio_text_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> partido_combo;
    private javax.swing.JTable table_actas;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
