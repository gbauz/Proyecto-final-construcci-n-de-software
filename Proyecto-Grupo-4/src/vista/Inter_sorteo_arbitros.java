/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Arbitro;

public class Inter_sorteo_arbitros extends javax.swing.JInternalFrame {
    
    public ArrayList<Arbitro> list_arb = new ArrayList<>();
    private Arbitro arb = null;
    public Inter_sorteo_arbitros() {
        initComponents();
        llenarTabla();
    }
    
    private void llenarLista()
    {
        arb = new Arbitro(1, "Jose", "Vargas", "", "", "", "", 
                "Profesional", "Ecuatoriano");
        list_arb.add(arb);
        
        arb = new Arbitro(2, "Francisco", "Sarmiento", "", "", "", "", 
                "Juvenil", "Ecuatoriano");
        list_arb.add(arb);
        
        arb = new Arbitro(3, "Sergio", "Lara", "", "", "", "", 
                "Profesional", "Ecuatoriano");
        list_arb.add(arb);
        
        arb = new Arbitro(4, "Ramon", "Montero", "", "", "", "", 
                "Profesional", "Ecuatoriano");
        list_arb.add(arb);
    }
    
    private void llenarTabla()
    {
        llenarLista();
                
        for (int fila = 0; fila <list_arb.size(); fila++)
        {
            arb = (Arbitro)list_arb.get(fila);
            llenarFilas(fila, arb);                        
        }
    }
    
    private void llenarFilas(int fila, Arbitro arb)
    {
        DefaultTableModel tabla = (DefaultTableModel)table_sorteo.getModel();
        
        tabla.addRow(new Object[1]);
        table_sorteo.setValueAt(fila+1, fila, 0);
        table_sorteo.setValueAt(arb.getNombre(), fila, 1);
        table_sorteo.setValueAt(arb.getApellido(), fila, 2);
        table_sorteo.setValueAt(arb.getNacionalidad(), fila, 3);
        table_sorteo.setValueAt(arb.getCategoria(), fila, 4);
    }
    /**
     * Creates new form Inter_sorteo_arbitros
     */
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        checkTodos = new javax.swing.JButton();
        text_arbitro_principal = new javax.swing.JTextField();
        text_arbitro_sustituto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblPartido = new javax.swing.JLabel();
        partido_combo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        boton_sorteo_arbitro = new javax.swing.JButton();
        btnGuardarSorteo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_sorteo = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Sorteo arbitros");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel3.setText("Arbitro principal:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        checkTodos.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        checkTodos.setText("Seleccionar Todos");
        checkTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodosActionPerformed(evt);
            }
        });
        getContentPane().add(checkTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 30, 140, -1));

        text_arbitro_principal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_arbitro_principal.setEnabled(false);
        text_arbitro_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_arbitro_principalActionPerformed(evt);
            }
        });
        getContentPane().add(text_arbitro_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, -1));

        text_arbitro_sustituto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_arbitro_sustituto.setEnabled(false);
        text_arbitro_sustituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_arbitro_sustitutoActionPerformed(evt);
            }
        });
        getContentPane().add(text_arbitro_sustituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 174, 170, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel1.setText("Sorteo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lblPartido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPartido.setText("Partido");
        getContentPane().add(lblPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        partido_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barcelona VS Emelec", "Independiente VS Dep.Cuenca", "Nacional VS Liga de Quito", "Delfin VS Aucas", "Guayaquil City VS Orense" }));
        partido_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partido_comboActionPerformed(evt);
            }
        });
        getContentPane().add(partido_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel5.setText("Arbitro sustituto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        boton_sorteo_arbitro.setBackground(new java.awt.Color(153, 255, 153));
        boton_sorteo_arbitro.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        boton_sorteo_arbitro.setText("Generar sorteo");
        boton_sorteo_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_sorteo_arbitroActionPerformed(evt);
            }
        });
        getContentPane().add(boton_sorteo_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 150, -1));

        btnGuardarSorteo.setBackground(new java.awt.Color(0, 255, 102));
        btnGuardarSorteo.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnGuardarSorteo.setText("Guardar Sorteo");
        btnGuardarSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSorteoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarSorteo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 130, 40));

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel10.setText("Listado de arbitros a sortear");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        table_sorteo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre", "Apellido", "Nacionalidad", "Categoria", "Seleccione"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_sorteo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 640, 340));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo blanco.jpg"))); // NOI18N
        jLabel13.setText("jLabel5");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 250));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo blanco.jpg"))); // NOI18N
        jLabel14.setText("jLabel5");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 660, 410));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utea.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodosActionPerformed

    }//GEN-LAST:event_checkTodosActionPerformed

    private void partido_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partido_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partido_comboActionPerformed

    private void text_arbitro_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_arbitro_principalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_arbitro_principalActionPerformed

    private void btnGuardarSorteoActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tabla = (DefaultTableModel)table_sorteo.getModel();
        int filas = tabla.getRowCount();
        
        tabla.addRow(new Object[1]);
        table_sorteo.setValueAt(filas+1, filas, 0);
        table_sorteo.setValueAt(text_arbitro_principal.getText().substring(0,10), filas, 1);
        table_sorteo.setValueAt(text_arbitro_principal.getText().substring(10), filas, 2);
        table_sorteo.setValueAt("Ecuatoriano", filas, 2);
        table_sorteo.setValueAt("Profesional", filas, 2);
    }// GEN-LAST:event_btnGuardarSorteoActionPerformed
 
    private void boton_sorteo_arbitroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boton_sorteo_arbitroActionPerformed

    }// GEN-LAST:event_boton_sorteo_arbitroActionPerformed

    private void text_arbitro_sustitutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_arbitro_sustitutoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_arbitro_sustitutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_sorteo_arbitro;
    private javax.swing.JButton btnGuardarSorteo;
    private javax.swing.JButton checkTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPartido;
    private javax.swing.JComboBox<String> partido_combo;
    private javax.swing.JTable table_sorteo;
    private javax.swing.JTextField text_arbitro_principal;
    private javax.swing.JTextField text_arbitro_sustituto;
    // End of variables declaration//GEN-END:variables
}