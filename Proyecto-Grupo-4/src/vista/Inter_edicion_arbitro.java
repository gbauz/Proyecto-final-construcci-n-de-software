/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.Conexion;
import java.sql.Connection;
import modelo.Arbitro;

public class Inter_edicion_arbitro extends javax.swing.JInternalFrame {
Conexion con=new Conexion();    
Connection cn;
Statement st;
ResultSet rs;
DefaultTableModel modelo;
int id;
public Inter_edicion_arbitro(){
    initComponents();
    listar();
}
void listar(){
    String sql="Select * from arbitros";
    try{
        cn=con.getConnection();
        st=cn.createStatement();
        rs=st.executeQuery(sql);
        Object[]persona=new Object[9];
        modelo=(DefaultTableModel)table_arbitro.getModel();
        while(rs.next()){
            persona[0]=rs.getInt("id");
            persona[1]=rs.getString("nombre");
            persona[2]=rs.getString("apellidos");
            persona[3]=rs.getString("usuario");
            persona[4]=rs.getString("email");
            persona[5]=rs.getString("contraseña");
            persona[6]=rs.getInt("edad");
            persona[7]=rs.getInt("total_partidos");
            persona[8]=rs.getString("categoria");
            modelo.addRow(persona);
        }
        table_arbitro.setModel(modelo);
    }
    catch(Exception e){
        
    }
} 
void agregar(){
    String nombre=text_field_nombre_arbitro.getText();
    String apellidos=text_field_apellido_arbitro.getText();
    String usuario=text_field_usuario_arbitro.getText();
    String email=text_field_email_arbitro.getText();
    String contraseña=text_field_contrasena_arbitro.getText();
    String edad=text_field_edad_arbitro.getText();
     String partidos=text_field_partidos_arbitro.getText();
    String categoria = (String) combo_box_categoria_arbitro.getSelectedItem();
    if(nombre.equals("")||apellidos.equals("")){
        JOptionPane.showMessageDialog(null,"las cajas estan vacias");
    }
    else{
     String sql = "INSERT INTO arbitros (nombre, apellidos, usuario, email, contraseña, edad, total_partidos, categoria)\n" +
             "VALUES ('" + nombre + "','" + apellidos + "','" + usuario + "','" + email + "','" + contraseña + "','" + edad + "','" + partidos + "','" + categoria + "')";

     try{
         cn=con.getConnection();
         st=cn.createStatement();
         st.executeUpdate(sql);
          DefaultTableModel modelo = (DefaultTableModel) table_arbitro.getModel();
            modelo.setRowCount(0); // Limpiar la tabla
     }
     catch(Exception e){
         
     }
    }
}
   void limpiarTabla(DefaultTableModel modelo) {
        for (int i=0; i<=table_arbitro.getRowCount()-1; i++) {
            modelo.removeRow(i);
            i = i - 1;
            
        }
    }
void eliminar() {
    int filaseleccionada = table_arbitro.getSelectedRow();
    if (filaseleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
    } else {
        DefaultTableModel modelo = (DefaultTableModel) table_arbitro.getModel();
        String id = modelo.getValueAt(filaseleccionada, 0).toString(); // Obtiene el valor de la columna "id" de la fila seleccionada

        String sql = "DELETE FROM arbitros WHERE id = " + id;
        try {
            cn = con.getConnection(); // Asegúrate de que la conexión a la base de datos está establecida correctamente
            st = cn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
            modelo.removeRow(filaseleccionada); // Remueve la fila seleccionada del modelo de la tabla
            modelo.setRowCount(0); // Limpiar la tabla
        } catch (Exception e) {
            // Manejar la excepción adecuadamente
        }
    }
}
 void modificar(){
     String nombre=text_field_nombre_arbitro.getText();
     String apellido=text_field_apellido_arbitro.getText();
     String usuario=text_field_usuario_arbitro.getText();
     String email=text_field_email_arbitro.getText();
     String contraseña=text_field_contrasena_arbitro.getText();
     String edad=text_field_edad_arbitro.getText();
     String partidos=text_field_partidos_arbitro.getText();
     String categoria=(String) combo_box_categoria_arbitro.getSelectedItem();
            
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boton_limpiar_arbitro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        text_field_usuario_arbitro = new javax.swing.JTextField();
        text_field_apellido_arbitro = new javax.swing.JTextField();
        text_field_edad_arbitro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_field_nombre_arbitro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_field_email_arbitro = new javax.swing.JTextField();
        combo_box_categoria_arbitro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_field_partidos_arbitro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        text_field_contrasena_arbitro = new javax.swing.JPasswordField();
        boton_guardar_arbitro = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbl_Mostrar = new javax.swing.JLabel();
        boton_editar_arbitro = new javax.swing.JButton();
        boton_borrar_arbitro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_arbitro = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ingreso arbitro");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_limpiar_arbitro.setBackground(new java.awt.Color(153, 255, 204));
        boton_limpiar_arbitro.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boton_limpiar_arbitro.setText("Limpiar");
        boton_limpiar_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_limpiar_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(boton_limpiar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 97, -1));

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel7.setText("Partidos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel12.setText("Apellidos:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(text_field_usuario_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 194, -1));
        jPanel1.add(text_field_apellido_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 192, -1));

        text_field_edad_arbitro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_edad_arbitroKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_edad_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 194, -1));

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel9.setText("Usuario:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel3.setText("Correo electronico:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        text_field_nombre_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_field_nombre_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(text_field_nombre_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 192, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel1.add(text_field_email_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 194, -1));

        combo_box_categoria_arbitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria", "Profesional", "Juvenil", "Junior", " " }));
        jPanel1.add(combo_box_categoria_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 194, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Ingreso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        text_field_partidos_arbitro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_partidos_arbitroKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_partidos_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 194, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setText("Nombre completo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel6.setText("Categoria:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        jPanel1.add(text_field_contrasena_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 170, -1));

        boton_guardar_arbitro.setBackground(new java.awt.Color(0, 255, 102));
        boton_guardar_arbitro.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boton_guardar_arbitro.setText("Guardar");
        boton_guardar_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(boton_guardar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 92, -1));

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel10.setText("*Seleccione un registro para efectuar alguna accion de edicion o borrado* ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        lbl_Mostrar.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        lbl_Mostrar.setText("Ver");
        lbl_Mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_Mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_MostrarMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 20, -1));

        boton_editar_arbitro.setBackground(new java.awt.Color(255, 255, 102));
        boton_editar_arbitro.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boton_editar_arbitro.setText("Editar");
        boton_editar_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(boton_editar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 94, -1));

        boton_borrar_arbitro.setBackground(new java.awt.Color(255, 51, 51));
        boton_borrar_arbitro.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boton_borrar_arbitro.setText("Borrar");
        boton_borrar_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_borrar_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(boton_borrar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 92, -1));

        table_arbitro.setForeground(new java.awt.Color(51, 51, 51));
        table_arbitro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre", "Apellidos", "Usuario", "Email", "Contrasenia", "Edad", "Total partidos", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_arbitro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_arbitroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_arbitro);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 742, 320));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo blanco.jpg"))); // NOI18N
        jLabel13.setText("jLabel5");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 350, 460));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo blanco.jpg"))); // NOI18N
        jLabel14.setText("jLabel5");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 760, 460));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utea.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lbl_MostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_MostrarMouseClicked
    }//GEN-LAST:event_lbl_MostrarMouseClicked

    private void text_field_edad_arbitroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_edad_arbitroKeyTyped
    }//GEN-LAST:event_text_field_edad_arbitroKeyTyped

    private void boton_guardar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_arbitroActionPerformed
       agregar();
       listar();
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_guardar_arbitroActionPerformed

    private void boton_limpiar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_limpiar_arbitroActionPerformed
        text_field_nombre_arbitro.setText("");
        text_field_apellido_arbitro.setText("");
        text_field_usuario_arbitro.setText("");
        text_field_email_arbitro.setText("");
        text_field_contrasena_arbitro.setText("");
        text_field_edad_arbitro.setText("");
        text_field_partidos_arbitro.setText("");
        combo_box_categoria_arbitro.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_boton_limpiar_arbitroActionPerformed

    private void boton_editar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar_arbitroActionPerformed
        int fila_select = table_arbitro.getSelectedRow();
        
        text_field_nombre_arbitro.setText(table_arbitro.getValueAt(fila_select, 1).toString());
        text_field_apellido_arbitro.setText(table_arbitro.getValueAt(fila_select, 2).toString());
        text_field_usuario_arbitro.setText(table_arbitro.getValueAt(fila_select, 3).toString());
        text_field_email_arbitro.setText(table_arbitro.getValueAt(fila_select, 4).toString());
        text_field_contrasena_arbitro.setText(table_arbitro.getValueAt(fila_select, 5).toString());
        text_field_edad_arbitro.setText(table_arbitro.getValueAt(fila_select, 6).toString());
        text_field_partidos_arbitro.setText(table_arbitro.getValueAt(fila_select, 7).toString());
        combo_box_categoria_arbitro.setSelectedItem(table_arbitro.getValueAt(fila_select, 8).toString());
    }//GEN-LAST:event_boton_editar_arbitroActionPerformed

    private void boton_borrar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrar_arbitroActionPerformed
         eliminar();
         listar();
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_borrar_arbitroActionPerformed

    private void text_field_partidos_arbitroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_partidos_arbitroKeyTyped

    }//GEN-LAST:event_text_field_partidos_arbitroKeyTyped

    private void table_arbitroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_arbitroMouseClicked
     int fila=table_arbitro.getSelectedRow();
     if(fila==1){
         JOptionPane.showMessageDialog(null, "usuario no encontrado");
     }
     else{
         int id=Integer.parseInt((String)table_arbitro.getValueAt(fila, 0));
         String nombre=(String)table_arbitro.getValueAt(fila,1);
         String apellidos=(String)table_arbitro.getValueAt(fila,2);
         String usuario=(String)table_arbitro.getValueAt(fila, 3);
         String email=(String)table_arbitro.getValueAt(fila,4);
         String contraseña=(String)table_arbitro.getValueAt(fila,5);
         String edad=(String)table_arbitro.getValueAt(fila,6);
         String partidos=(String)table_arbitro.getValueAt(fila,7);
         String categoria=(String) combo_box_categoria_arbitro.getSelectedItem();

           
        text_field_nombre_arbitro.setText(nombre);
        text_field_apellido_arbitro.setText(apellidos);
        text_field_usuario_arbitro.setText(usuario);
        text_field_email_arbitro.setText(email);
        text_field_contrasena_arbitro.setText(contraseña);
        text_field_edad_arbitro.setText(edad);
        text_field_partidos_arbitro.setText(partidos);
         
          String sql = "UPDATE arbitros SET nombre = '"+nombre+"', apellidos = '"+apellidos+"', email = '"+email+"', contraseña = '"+contraseña+"', edad = '"+edad+"', usuario = '"+usuario+"', total_partidos = '"+partidos+"', categoria = '"+categoria+"' WHERE id = "+id;
             
          
     }
    }//GEN-LAST:event_table_arbitroMouseClicked

    private void text_field_nombre_arbitroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_field_nombre_arbitroActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_field_nombre_arbitroActionPerformed

    private void text_field_buscar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_field_buscar_arbitroActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_field_buscar_arbitroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_borrar_arbitro;
    private javax.swing.JButton boton_editar_arbitro;
    private javax.swing.JButton boton_guardar_arbitro;
    private javax.swing.JButton boton_limpiar_arbitro;
    private javax.swing.JComboBox<String> combo_box_categoria_arbitro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Mostrar;
    private javax.swing.JTable table_arbitro;
    private javax.swing.JTextField text_field_apellido_arbitro;
    private javax.swing.JPasswordField text_field_contrasena_arbitro;
    private javax.swing.JTextField text_field_edad_arbitro;
    private javax.swing.JTextField text_field_email_arbitro;
    private javax.swing.JTextField text_field_nombre_arbitro;
    private javax.swing.JTextField text_field_partidos_arbitro;
    private javax.swing.JTextField text_field_usuario_arbitro;
    // End of variables declaration//GEN-END:variables

}
