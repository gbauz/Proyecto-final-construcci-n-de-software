package vista;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.Conexion;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import java.util.Calendar;

public final class Inter_jugador extends javax.swing.JInternalFrame {
    
    //Atributos
    Conexion con=new Conexion();    
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    Calendar calendar = Calendar.getInstance();

    /**
     * Constructor de la clase Inter_jugador
     */
    public Inter_jugador(){
        initComponents();
        llenarComboClub(combo_box_club);
        llenarComboBusqueda();
        dtc_fecha_nac.setDateFormatString("yyyy-MM-dd");
        calendar.setTime(new Date());        
        calendar.add(Calendar.YEAR, -50);   // Resta 50 años a la fecha actual
        Date fiftyYearsAgo = calendar.getTime();
        dtc_fecha_nac.setSelectableDateRange(fiftyYearsAgo, new Date());
        dtc_fecha_nac.getDateEditor().setEnabled(false);
        listar();
    }
    
    /**
     * Este método lista las filas de una tabla "jugador" en MySQL
     * @author Gabriel Delgado
     * @version 1.0
     */
    void listar(){
        String sql="Select j.id_jugador, j.nombre, j.apellido, j.nombre_usuario,"
                + " j.email, j.fecha_nac, j.estado, c.nombre as nombre_club "
                + "from jugador j JOIN club c ON j.club_id_club = c.id_club";
        try{
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]persona=new Object[9];
            modelo=(DefaultTableModel)table_jugador.getModel();
            while(rs.next()){
                persona[0]=rs.getInt("id_jugador");
                persona[1]=rs.getString("nombre");
                persona[2]=rs.getString("apellido");
                persona[3]=rs.getString("nombre_usuario");
                persona[4]=rs.getString("email");
                persona[5]=rs.getDate("fecha_nac");
                persona[6]=rs.getString("estado");
                persona[7]=rs.getString("nombre_club");
                modelo.addRow(persona);
            }
            table_jugador.setModel(modelo);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(NullPointerException ex){
            
        }
    } 
    
    /**
     * Método que inserta una nueva fila en la tabla 'jugador' de la BD.
     * @author Gabriel Delgado
     * @version 1.0
     */    
    void agregar(){
        
        //Se recogen los valores de las cajas de texto, combo y el JDateChooser
        String nombre=text_field_nombre_jugador.getText();
        String apellidos=text_field_apellido_jugador.getText();
        String usuario=text_field_usuario_jugador.getText();
        String email=text_field_email.getText();
        String contraseña=text_field_contrasena_jugador.getText();
        Date fecha= dtc_fecha_nac.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   //Se establece el formato de fecha que se desea que obtener
        String fecha_nac = dateFormat.format(fecha);    //Se le aplica el formato a la variable 'fecha'
        String estado=text_field_estado_jugador.getText();
        String club = combo_box_club.getSelectedItem().toString();
        String id_club = obtenerIDClub(club);
        
        //Se comprueba que las cajas de texto de nombre y apellido no se encuentren vacias.
        if(nombre.equals("")||apellidos.equals("")){
            JOptionPane.showMessageDialog(null,"las cajas estan vacias");
        }
        else{
            String insert_sql = "INSERT INTO jugador (nombre,apellido,nombre_usuario,email,contrasenia,fecha_nac,estado,club_id_club) " +
                 "VALUES ('"+nombre+"','" + apellidos + "','" + usuario + "','" + email + "','" + contraseña + "','" + fecha_nac + "','" + estado + "',"+id_club +")";

            try{
                cn=con.getConnection();
                st=cn.createStatement();
                st.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Usuario agregado"); //Mensaje mostrado al haberse ingresado un nuevo jugador
                limpiarTabla(); //Se limpia el JTable
             
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
            }
        }
    }
    
    /**
     * Método que obtiene el id del club mediante su nombre
     * @param club El nombre del club.
     * @return Devuelve el id del club.
     * @author Gabriel Delgado
     * @version 1.0
     */
    public String obtenerIDClub(String club)
    {
        String sql = "SELECT id_club FROM club WHERE nombre = '"+club+"'";
        String resultado = "";
        try{
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                resultado = rs.getString("id_club");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return resultado;
    }
    
    /**
     * Método que se encarga de llenar el comboBox con los nombre de los clubes alojados en la BD
     * @param combo_box_club Se pasa al metodo el objeto JComboBox que se va llenar
     * @author Gabriel Delgado
     * @version 1.0
     */
    private void llenarComboClub(JComboBox combo_box_club)
    {
        String sql = "SELECT nombre FROM club";
        try{
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                combo_box_club.addItem(rs.getString("nombre"));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        catch(NullPointerException ex){            
        }
    }
    
    /**
     * Método que llena el combo de los atributos por lo cuales se va a realizar una busqueda
     * @author Gabriel Delgado
     * @version 1.0
     */
    private void llenarComboBusqueda()
    {
        
        combo_box_buscar_jugador.addItem("Club");
        combo_box_buscar_jugador.addItem("Estado");
    }
    
    /**
     * Método que limpia el JTable.
     * @author Gabriel Delgado
     * @version 1.0
     */
    void limpiarTabla() 
   {
        try
       {
        for (int i=table_jugador.getRowCount()-1; i>=0; i--) {
            modelo.removeRow(i);
        }
       }
       catch (Exception ex)
       {
           JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
       }
    }
   
    /**
     * Este método se encarga de modificar el registro seleccionado en la BD de Datos
     * @author Gabriel Delgado
     * @version 1.0
     * 
     */
    public void modificar()
    {
        String id=text_field_id_jugador.getText();
        String nombre=text_field_nombre_jugador.getText();
        String apellidos=text_field_apellido_jugador.getText();
        String usuario=text_field_usuario_jugador.getText();
        String email=text_field_email.getText();
        String contraseña=text_field_contrasena_jugador.getText();
        Date fecha= dtc_fecha_nac.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_nac = dateFormat.format(fecha);
        String estado=text_field_estado_jugador.getText();
        String club = combo_box_club.getSelectedItem().toString();
        String id_club = obtenerIDClub(club);
        
        //Se comprueba que las cajas de texto de nombre y apellido no se encuentren vacias.
        if(nombre.equals("")||apellidos.equals("")){
            JOptionPane.showMessageDialog(null,"las cajas estan vacias");
        }
        else{
            String insert_sql = "UPDATE jugador SET nombre='"+nombre+"', apellido='"+apellidos+"', nombre_usuario='"+usuario+
                    "', email='"+email+"', contrasenia='"+contraseña+"', fecha_nac='"+fecha_nac+"', estado='"+estado+"', club_id_club='"+
                    id_club+"' WHERE id_jugador="+id;

            try{
                cn=con.getConnection();
                st=cn.createStatement();
                st.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Usuario actualizado"); //Mensaje mostrado al haberse actualizado un nuevo jugador
                limpiarTabla(); //Se limpia el JTable
             
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
            }
        }
   }
    
    /**
     * Este método elimina la fila que se encuentra seleccionada
     * @author Gabriel Delgado
     * @version 1.0
     */   
    void eliminar() 
    {
        int filaseleccionada = table_jugador.getSelectedRow();
        String id = table_jugador.getValueAt(filaseleccionada, 0).toString();
        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            String sql = "DELETE FROM jugador WHERE id_jugador ="+id;
            try {
                cn = con.getConnection(); // Asegúrate de que la conexión a la base de datos está establecida correctamente
                st = cn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                limpiarTabla();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
            }
        }
    }
    
    /**
     * Este método realiza una busqueda en base a una cadena de texto y una consulta en la base de datos
     * @author Gabriel Delgado
     * @version 1.0
     */
    void buscar()
    {
        String str_busqueda = text_field_buscar_jugador.getText().trim();
        String seleccionado = combo_box_buscar_jugador.getSelectedItem().toString();
        String sql = "", id;
        
        if (seleccionado.compareTo("Estado") == 0)
        {
            sql = "SELECT j.id_jugador, j.nombre, j.apellido, j.nombre_usuario,"
                + " j.email, j.fecha_nac, j.estado, c.nombre as nombre_club "
                + "from jugador j JOIN club c ON j.club_id_club=c.id_club "
                + "WHERE j.estado='"+str_busqueda+"'";
            
        }
        else if(seleccionado.compareTo("Club") == 0)
        {
            id = obtenerIDClub(str_busqueda);
            sql = "SELECT j.id_jugador, j.nombre, j.apellido, j.nombre_usuario,"
                + " j.email, j.fecha_nac, j.estado, c.nombre as nombre_club "
                + "from jugador j JOIN club c ON j.club_id_club=c.id_club "
                + "WHERE j.club_id_club="+id;
        }
        try{
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]persona=new Object[9];
            modelo=(DefaultTableModel)table_jugador.getModel();
            while(rs.next()){
                persona[0]=rs.getInt("id_jugador");
                persona[1]=rs.getString("nombre");
                persona[2]=rs.getString("apellido");
                persona[3]=rs.getString("nombre_usuario");
                persona[4]=rs.getString("email");
                persona[5]=rs.getDate("fecha_nac");
                persona[6]=rs.getString("estado");
                persona[7]=rs.getString("nombre_club");
                modelo.addRow(persona);
            }
            table_jugador.setModel(modelo);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boton_limpiar_arbitro = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        text_field_email = new javax.swing.JTextField();
        text_field_id_jugador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_field_nombre_jugador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_field_apellido_jugador = new javax.swing.JTextField();
        combo_box_club = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boton_guardar_arbitro = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        text_field_buscar_jugador = new javax.swing.JTextField();
        text_field_estado_jugador = new javax.swing.JTextField();
        lbl_Mostrar = new javax.swing.JLabel();
        boton_buscar_arbitro = new javax.swing.JButton();
        boton_editar_arbitro = new javax.swing.JButton();
        boton_borrar_arbitro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        text_field_usuario_jugador = new javax.swing.JTextField();
        text_field_contrasena_jugador = new javax.swing.JPasswordField();
        combo_box_buscar_jugador = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        dtc_fecha_nac = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_jugador = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ingreso jugador");
        setToolTipText("");

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

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        text_field_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_emailKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 194, -1));

        text_field_id_jugador.setEditable(false);
        text_field_id_jugador.setEnabled(false);
        jPanel1.add(text_field_id_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 192, -1));

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel9.setText("Email:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        text_field_nombre_jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_nombre_jugadorKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_nombre_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 192, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        text_field_apellido_jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_apellido_jugadorKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_apellido_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 194, -1));

        combo_box_club.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un club" }));
        jPanel1.add(combo_box_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 194, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Ingreso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel5.setText("Estado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel6.setText("Club:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

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

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel11.setText("Buscar por:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        text_field_buscar_jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_buscar_jugadorKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_buscar_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 157, -1));

        text_field_estado_jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_estado_jugadorKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_estado_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 194, -1));

        lbl_Mostrar.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        lbl_Mostrar.setText("Ver");
        lbl_Mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lbl_Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 20, -1));

        boton_buscar_arbitro.setBackground(new java.awt.Color(0, 102, 204));
        boton_buscar_arbitro.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boton_buscar_arbitro.setText("Buscar");
        boton_buscar_arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_arbitroActionPerformed(evt);
            }
        });
        jPanel1.add(boton_buscar_arbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

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

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        text_field_usuario_jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_usuario_jugadorKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_usuario_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 194, -1));

        text_field_contrasena_jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_field_contrasena_jugadorKeyTyped(evt);
            }
        });
        jPanel1.add(text_field_contrasena_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 170, -1));

        combo_box_buscar_jugador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un criterio de busqueda" }));
        jPanel1.add(combo_box_buscar_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 145, -1));

        jLabel16.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel16.setText("Usuario:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));
        jPanel1.add(dtc_fecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 190, -1));

        table_jugador.setForeground(new java.awt.Color(51, 51, 51));
        table_jugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre", "Apellidos", "Usuario", "Email", "Fecha de nacimiento", "Estado", "Club"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_jugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_jugadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_jugador);

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


    private void boton_guardar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_arbitroActionPerformed
       agregar();
       listar();
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_guardar_arbitroActionPerformed

    private void boton_limpiar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_limpiar_arbitroActionPerformed
        //Se limpian los campos
        text_field_id_jugador.setText("");
        text_field_nombre_jugador.setText("");
        text_field_apellido_jugador.setText("");
        text_field_email.setText("");
        text_field_usuario_jugador.setText("");
        text_field_contrasena_jugador.setText("");
        text_field_estado_jugador.setText("");
        dtc_fecha_nac.setDate(new Date());
        combo_box_club.setSelectedIndex(0);        // TODO add your handling code here:
        
        //Se borra la busqueda
        combo_box_buscar_jugador.setSelectedIndex(0);
        limpiarTabla();
        listar();       
        
    }//GEN-LAST:event_boton_limpiar_arbitroActionPerformed

    private void boton_editar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar_arbitroActionPerformed
        modificar();
        listar();
    }//GEN-LAST:event_boton_editar_arbitroActionPerformed

    private void boton_borrar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrar_arbitroActionPerformed
         eliminar();
         listar();
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_borrar_arbitroActionPerformed

    private void table_jugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_jugadorMouseClicked
        int fila = table_jugador.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
        }else
        {
            text_field_id_jugador.setText(table_jugador.getValueAt(fila, 0).toString());
            text_field_nombre_jugador.setText(table_jugador.getValueAt(fila, 1).toString());
            text_field_apellido_jugador.setText(table_jugador.getValueAt(fila, 2).toString());
            text_field_usuario_jugador.setText(table_jugador.getValueAt(fila, 3).toString());
            text_field_email.setText(table_jugador.getValueAt(fila, 4).toString());            
            
            try {
                SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                Date formato_fecha = fecha.parse(table_jugador.getValueAt(fila, 5).toString());
                dtc_fecha_nac.setDate(formato_fecha);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }            
            
            text_field_estado_jugador.setText(table_jugador.getValueAt(fila, 6).toString());
            combo_box_club.setSelectedItem(table_jugador.getValueAt(fila, 7).toString());
        }
    }//GEN-LAST:event_table_jugadorMouseClicked

    private void boton_buscar_arbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_arbitroActionPerformed
        limpiarTabla();
        buscar();
    }//GEN-LAST:event_boton_buscar_arbitroActionPerformed

    private void text_field_nombre_jugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_nombre_jugadorKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetter(c) && (c != ' ') && (c != KeyEvent.VK_BACK_SPACE) || (text_field_nombre_jugador.getText().trim().length() > 40))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_nombre_jugadorKeyTyped

    private void text_field_apellido_jugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_apellido_jugadorKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetter(c) && (c != ' ') && (c != KeyEvent.VK_BACK_SPACE) || (text_field_apellido_jugador.getText().trim().length() > 40))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_apellido_jugadorKeyTyped

    private void text_field_usuario_jugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_usuario_jugadorKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetterOrDigit(c) && (c != KeyEvent.VK_BACK_SPACE) || (text_field_usuario_jugador.getText().trim().length() > 50))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_usuario_jugadorKeyTyped

    private void text_field_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_emailKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetterOrDigit(c) && (c != '@') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE) || (text_field_email.getText().trim().length() > 70))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_emailKeyTyped

    private void text_field_contrasena_jugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_contrasena_jugadorKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetterOrDigit(c) && (c != KeyEvent.VK_BACK_SPACE) || (text_field_contrasena_jugador.getText().trim().length() > 50))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_contrasena_jugadorKeyTyped

    private void text_field_estado_jugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_estado_jugadorKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetter(c) && (c != KeyEvent.VK_BACK_SPACE) || (text_field_estado_jugador.getText().trim().length() > 1))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_estado_jugadorKeyTyped

    private void text_field_buscar_jugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_buscar_jugadorKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isLetter(c) && (c != ' ') && (c != KeyEvent.VK_BACK_SPACE) || (text_field_estado_jugador.getText().trim().length() > 35))
        {
            evt.consume();
        }
    }//GEN-LAST:event_text_field_buscar_jugadorKeyTyped
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_borrar_arbitro;
    private javax.swing.JButton boton_buscar_arbitro;
    private javax.swing.JButton boton_editar_arbitro;
    private javax.swing.JButton boton_guardar_arbitro;
    private javax.swing.JButton boton_limpiar_arbitro;
    private javax.swing.JComboBox<String> combo_box_buscar_jugador;
    private javax.swing.JComboBox<String> combo_box_club;
    private com.toedter.calendar.JDateChooser dtc_fecha_nac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTable table_jugador;
    private javax.swing.JTextField text_field_apellido_jugador;
    private javax.swing.JTextField text_field_buscar_jugador;
    private javax.swing.JPasswordField text_field_contrasena_jugador;
    private javax.swing.JTextField text_field_email;
    private javax.swing.JTextField text_field_estado_jugador;
    private javax.swing.JTextField text_field_id_jugador;
    private javax.swing.JTextField text_field_nombre_jugador;
    private javax.swing.JTextField text_field_usuario_jugador;
    // End of variables declaration//GEN-END:variables

}
