/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vista;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

import static org.junit.Assert.*;
/**
 *
 * @author gerne
 */
public class Inter_modulo_actasTest {
    
    public TablaActas tablaActas;

  
    @Test
    public void testJButton1ActionPerformed() {
        DefaultTableModel tablaModelo = (DefaultTableModel) tablaActas.table_actas.getModel();
        tablaModelo.setRowCount(5); // Simulamos que ya hay 5 filas en la tabla

        tablaActas.fecha_emision.setDate(new Date());
        tablaActas.hora_inicio_text_box.setText("12:00");
        tablaActas.hora_fin_text_box.setText("14:00");
        tablaActas.partido_combo.addItem("Nombre del partido");
        tablaActas.goles_local_text_box.setText("2");
        tablaActas.goles_rival_text_box.setText("1");
        tablaActas.equipo_ganador_text.setText("Equipo ganador");

        tablaActas.jButton1ActionPerformed(null);

        assertEquals(6, tablaModelo.getRowCount());
        assertEquals(6, tablaModelo.getValueAt(5, 0));
        assertEquals(new Date(), tablaModelo.getValueAt(5, 1));
        assertEquals("12:00", tablaModelo.getValueAt(5, 2));
        assertEquals("14:00", tablaModelo.getValueAt(5, 3));
        assertEquals("Nombre del partido", tablaModelo.getValueAt(5, 4));
        assertEquals("2", tablaModelo.getValueAt(5, 5));
        assertEquals("1", tablaModelo.getValueAt(5, 6));
        assertEquals("Equipo ganador", tablaModelo.getValueAt(5, 7));
    }

    @Test
    public void testLlenarFilas() {
        DefaultTableModel tablaModelo = (DefaultTableModel) tablaActas.table_actas.getModel();
        tablaModelo.setRowCount(3); // Simulamos que ya hay 3 filas en la tabla

        Actas_partido acta = new Actas_partido();
        acta.setFecha_emision(new Date());
        acta.setHora_inicio_partido("12:00");
        acta.setHora_fin_partido("14:00");
        acta.setPartido(new Partido("Nombre del partido"));
        acta.setGoles_equipo_local(2);
        acta.setGoles_equipo_rival(1);
        acta.setEquipo_ganador("Equipo ganador");

        tablaActas.llenarFilas(3, acta);

        assertEquals(4, tablaModelo.getRowCount());
        assertEquals(4, tablaModelo.getValueAt(3, 0));
        assertEquals(new Date(), tablaModelo.getValueAt(3, 1));
        assertEquals("12:00", tablaModelo.getValueAt(3, 2));
        assertEquals("14:00", tablaModelo.getValueAt(3, 3));
        assertEquals("Nombre del partido", tablaModelo.getValueAt(3, 4));
        assertEquals(2, tablaModelo.getValueAt(3, 5));
        assertEquals(1, tablaModelo.getValueAt(3, 6));
        assertEquals("Equipo ganador", tablaModelo.getValueAt(3, 7));
    }
    
      @Test
    public void testEliminarFilaSeleccionada() {
        // Crear una tabla de prueba con algunos datos
        String[] columnNames = {"Columna1", "Columna2"};
        Object[][] data = {
            {"Dato1-1", "Dato1-2"},
            {"Dato2-1", "Dato2-2"},
            {"Dato3-1", "Dato3-2"}
        };
        DefaultTableModel tabla = new DefaultTableModel(data, columnNames);

        // Crear la instancia del objeto que contiene el método a probar
        // Supongamos que el método pertenece a una clase llamada "TuClase"
        Inter_modulo_actasTest tuClase = new Inter_modulo_actasTest();

        // Setear la tabla de prueba en el objeto que contiene el método a probar
        tuClase.setTabla(tabla);

        // Seleccionar la segunda fila (fila con índice 1)
        int filaSeleccionada = 1;
        tuClase.setFilaSeleccionada(filaSeleccionada);

        // Llamar al método que queremos probar
        tuClase.jButton5ActionPerformed(null);

        // Verificar que se haya eliminado la fila seleccionada
        assertEquals(data.length - 1, tabla.getRowCount());
    }

    private void setTabla(DefaultTableModel tabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setFilaSeleccionada(int filaSeleccionada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void jButton5ActionPerformed(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
    
    

