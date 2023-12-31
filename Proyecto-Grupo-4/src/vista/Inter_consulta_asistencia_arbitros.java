/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.Conexion;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Arbitro;

public class Inter_consulta_asistencia_arbitros extends javax.swing.JInternalFrame {
    Conexion con=new Conexion();    
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    int id;
    public Inter_consulta_asistencia_arbitros(){
        initComponents();
        listar();
        combo_buscar();
    }
    void listar(){
        String sql="Select * from arbitros";
        try{
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]arbitros=new Object[6];
            int contador = 1; // Inicializa el contador para la numeración
            modelo=(DefaultTableModel)table_arbitros.getModel();
            while(rs.next()){
                arbitros[0] =contador++;
                arbitros[1]=rs.getInt("Id");
                arbitros[2]=rs.getString("Nombre");
                arbitros[3]=rs.getString("Apellidos");
                arbitros[4]=rs.getString("Nacionalidad");
                arbitros[5]=rs.getString("Categoria");
                modelo.addRow(arbitros);
            }
            table_arbitros.setModel(modelo);
        }
        catch(Exception e){
        
        }
    } 
    void limpiarFiltros() {
        combo_box_buscar.setSelectedIndex(0); // Restablece la selección del JComboBox
        text_field_buscar_arbitro.setText(""); // Limpia el JTextField de búsqueda
        modelo.setRowCount(0);
        listar(); // Vuelve a mostrar todos los registros en la tabla
    }
    
    private void buscarArbitros(String filtro, String valor) {
        String sql = "SELECT * FROM arbitros WHERE " + filtro + " LIKE '%" + valor + "%'";
    
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
        
            modelo.setRowCount(0); // Limpia la tabla antes de mostrar los resultados
        
            int contador = 1; // Inicializa el contador para la numeración
            while (rs.next()) {
                Object[] arbitros = {
                    contador++, // Incrementa el contador
                    rs.getInt("Id"),
                    rs.getString("Nombre"),
                    rs.getString("Apellidos"),
                    rs.getString("Nacionalidad"),
                    rs.getString("Categoria")
                };
                modelo.addRow(arbitros);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar árbitros", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelArbitros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_arbitros = new javax.swing.JTable();
        panelAsistencias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_arbitro_asistencia = new javax.swing.JTable();
        combo_box_buscar = new javax.swing.JComboBox<>();
        lbl_advice = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_field_buscar_arbitro = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar_arbitro = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Asistencia arbitros");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelArbitros.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Arbitros"));

        table_arbitros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "Nombres", "Apellidos", "Nacionalidad", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_arbitros);

        javax.swing.GroupLayout panelArbitrosLayout = new javax.swing.GroupLayout(panelArbitros);
        panelArbitros.setLayout(panelArbitrosLayout);
        panelArbitrosLayout.setHorizontalGroup(
            panelArbitrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArbitrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelArbitrosLayout.setVerticalGroup(
            panelArbitrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArbitrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelArbitros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 770, 180));

        panelAsistencias.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de  Asistencia"));

        table_arbitro_asistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Asistencia ID", "Partido", "Lugar", "Fecha", "Asistencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_arbitro_asistencia);

        javax.swing.GroupLayout panelAsistenciasLayout = new javax.swing.GroupLayout(panelAsistencias);
        panelAsistencias.setLayout(panelAsistenciasLayout);
        panelAsistenciasLayout.setHorizontalGroup(
            panelAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(panelAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAsistenciasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelAsistenciasLayout.setVerticalGroup(
            panelAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
            .addGroup(panelAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAsistenciasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(panelAsistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 770, 210));

        combo_box_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Id", "Apellidos", "Nacionalidad", "Categoria" }));
        combo_box_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(combo_box_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 170, -1));

        lbl_advice.setBackground(new java.awt.Color(0, 0, 0));
        lbl_advice.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lbl_advice.setForeground(new java.awt.Color(255, 255, 255));
        lbl_advice.setText("Seleccione un arbitro para visualizar su historial de asistencias *");
        jPanel1.add(lbl_advice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 500, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar Por:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        text_field_buscar_arbitro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text_field_buscar_arbitroKeyPressed(evt);
            }
        });
        jPanel1.add(text_field_buscar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 170, -1));

        btnLimpiar.setBackground(new java.awt.Color(0, 255, 102));
        btnLimpiar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 100, 30));

        btnBuscar_arbitro.setBackground(new java.awt.Color(0, 255, 102));
        btnBuscar_arbitro.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnBuscar_arbitro.setText("Buscar");
        btnBuscar_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 90, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utea.png"))); // NOI18N
        jLabel15.setOpaque(true);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 820, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void combo_buscar(){
        String filtroSeleccionado = combo_box_buscar.getSelectedItem().toString();
    
        if (filtroSeleccionado.equals("Seleccionar")) {
            text_field_buscar_arbitro.setEnabled(false); // Deshabilita la edición del JTextField
            btnBuscar_arbitro.setEnabled(false); // Deshabilita el botón de búsqueda
            modelo.setRowCount(0);
            listar(); // Llama nuevamente a listar() para mostrar todos los registros
        } else {
            modelo.setRowCount(0);
            listar(); // Llama nuevamente a listar() para mostrar todos los registros
            text_field_buscar_arbitro.setEnabled(true); // Habilita la edición del JTextField
            btnBuscar_arbitro.setEnabled(true); // Habilita el botón de búsqueda
        }
    }
    private void combo_box_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_buscarActionPerformed
        combo_buscar();
    }//GEN-LAST:event_combo_box_buscarActionPerformed

    private void btnBuscar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_arbitroActionPerformed
        String filtroSeleccionado = combo_box_buscar.getSelectedItem().toString();
        String valorBusqueda = text_field_buscar_arbitro.getText().trim();
    
        if (!filtroSeleccionado.equals("Seleccionar") && !valorBusqueda.isEmpty()) {
            buscarArbitros(filtroSeleccionado, valorBusqueda);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un filtro válido y proporciona un valor de búsqueda.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar_arbitroActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFiltros();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void text_field_buscar_arbitroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_buscar_arbitroKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        btnBuscar_arbitroActionPerformed(null); // Llama al método de búsqueda
        }        
    }//GEN-LAST:event_text_field_buscar_arbitroKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar_arbitro;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> combo_box_buscar;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_advice;
    private javax.swing.JPanel panelArbitros;
    private javax.swing.JPanel panelAsistencias;
    private javax.swing.JTable table_arbitro_asistencia;
    private javax.swing.JTable table_arbitros;
    private javax.swing.JTextField text_field_buscar_arbitro;
    // End of variables declaration//GEN-END:variables
}
