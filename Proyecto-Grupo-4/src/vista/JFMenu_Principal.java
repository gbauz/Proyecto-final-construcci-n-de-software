/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Dimension;
import javax.swing.JDesktopPane;

import modelo.Rol;
import modelo.UsuarioCache;


public class JFMenu_Principal extends javax.swing.JFrame {

    public Dimension dimension;
    public static JDesktopPane JFmenu_principal;

    /**
     * Creates new form JFMenu_Principal
     */
    public JFMenu_Principal() {
        initComponents();

        this.setTitle("MENÚ PRINCIPAL - SISTEMA DE GESTIÓN DE ARBITROS");
        
        this.setLayout(null);

        
        JFmenu_principal = new JDesktopPane();
        
        dimension = super.getToolkit().getScreenSize();
        super.setSize(dimension);
        JFmenu_principal.setSize(dimension);
        this.add(JFmenu_principal);

        //
        permisosMenu();
        
    }

    private void permisosMenu(){
        if(UsuarioCache.getUsuarioCache().getId_rol() == null) return;
        
        int rol = UsuarioCache.getUsuarioCache().getId_rol();
        switch (rol) {
            case Rol.ARBITRO:
            secretarioMenu.setVisible(false);
            usuarioMenu.setVisible(false);
            presidenteMenu.setVisible(false);
                break;
            case Rol.SECRETARIO:
            arbitroMenu.setVisible(false);
            usuarioMenu.setVisible(false);
            presidenteMenu.setVisible(false);
            default:
                break;
            case Rol.PRESIDENTE:
            arbitroMenu.setVisible(false);
            usuarioMenu.setVisible(false);
            secretarioMenu.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        arbitroMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        secretarioMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        presidenteMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        usuarioMenu = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arbitroMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/football_referee(23).png"))); // NOI18N
        arbitroMenu.setText("  Árbitro");
        arbitroMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        arbitroMenu.setMinimumSize(new java.awt.Dimension(180, 30));
        arbitroMenu.setPreferredSize(new java.awt.Dimension(160, 40));

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/document(23).png"))); // NOI18N
        jMenuItem1.setText("  Actas");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(158, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        arbitroMenu.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seen_assist(23).png"))); // NOI18N
        jMenuItem2.setText("  Asistencia");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(158, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        arbitroMenu.add(jMenuItem2);

        jMenuBar1.add(arbitroMenu);

        secretarioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/assistant(23).png"))); // NOI18N
        secretarioMenu.setText("  Secretaria");
        secretarioMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        secretarioMenu.setMinimumSize(new java.awt.Dimension(180, 30));
        secretarioMenu.setPreferredSize(new java.awt.Dimension(160, 40));

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avatar_referee_edit(23).png"))); // NOI18N
        jMenuItem3.setText("  Árbitro");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(158, 30));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        secretarioMenu.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendar(23).png"))); // NOI18N
        jMenuItem4.setText("  Calendario");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(158, 30));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        secretarioMenu.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clan-group(23).png"))); // NOI18N
        jMenuItem5.setText("  Club");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(158, 30));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        secretarioMenu.add(jMenuItem5);

        jMenuBar1.add(secretarioMenu);

        presidenteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/president(23).png"))); // NOI18N
        presidenteMenu.setText("  Presidente");
        presidenteMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        presidenteMenu.setMinimumSize(new java.awt.Dimension(180, 30));
        presidenteMenu.setPreferredSize(new java.awt.Dimension(158, 30));

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perspective-dado(23).png"))); // NOI18N
        jMenuItem6.setText("  Sorteo");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(156, 30));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        presidenteMenu.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seen_assist(23).png"))); // NOI18N
        jMenuItem7.setText("  Asistencia");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(156, 30));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        presidenteMenu.add(jMenuItem7);

        jMenuBar1.add(presidenteMenu);

        usuarioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/register_login(23).png"))); // NOI18N
        usuarioMenu.setText("  Registro usuario");
        usuarioMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuarioMenu.setMinimumSize(new java.awt.Dimension(180, 30));
        usuarioMenu.setPreferredSize(new java.awt.Dimension(160, 40));
        usuarioMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(usuarioMenu);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jMenu7.setText("  Cerrar sesión");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(160, 40));

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(255, 0, 51));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit_to_app(23).png"))); // NOI18N
        jMenuItem8.setText("  Salir");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(158, 30));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem8);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMenuMouseClicked
       Inter_ingreso_usuarios ventanaAsistencia = new Inter_ingreso_usuarios ();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }//GEN-LAST:event_usuarioMenuMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
        Inter_modulo_actas ventanaAsistencia = new Inter_modulo_actas ();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }// GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem7ActionPerformed
        Inter_consulta_asistencia_arbitros ventanaAsistencia = new Inter_consulta_asistencia_arbitros();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }// GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
        Inter_fecha_calendario ventanaAsistencia = new Inter_fecha_calendario();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }// GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
        Inter_asistencia ventanaAsistencia = new Inter_asistencia();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);

    }// GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
        Inter_edicion_arbitro ventanaAsistencia = new Inter_edicion_arbitro();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }// GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
        Inter_ingreso_clubs ventanaAsistencia = new Inter_ingreso_clubs();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }// GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
       Inter_sorteo_arbitros ventanaAsistencia = new Inter_sorteo_arbitros();
        JFmenu_principal.add(ventanaAsistencia);
        ventanaAsistencia.setVisible(true);
    }// GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem8ActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMenu_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMenu_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMenu_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMenu_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu arbitroMenu;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu presidenteMenu;
    private javax.swing.JMenu secretarioMenu;
    private javax.swing.JMenu usuarioMenu;
    // End of variables declaration//GEN-END:variables
}