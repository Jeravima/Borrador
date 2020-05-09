/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;
//PARA NO TENER PROBLEMAS REALIZAMOS PRIMERO
//LAS SIGUIENTES IMPORTACIONES

import java.awt.event.ActionEvent;
import java.awt.event.AWTEventListener;
import java.io.*;
import Excel.VistaExcel;
import Excel.ModeloExcel;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Estructura Datos D1
 */
public class ControladorExcel implements ActionListener {

    ModeloExcel ModeloEX = new ModeloExcel();
    VistaExcel VistaEX = new VistaExcel();
    JFileChooser SelectArchivo = new JFileChooser();
    File archivo;
    int contador = 0;

    public ControladorExcel(VistaExcel VistaEX, ModeloExcel ModeloEX) {
        this.VistaEX = VistaEX;
        this.ModeloEX = ModeloEX;
        //SI LES APARECE LA LINEA ROJA COMO EN ESTE CASO
        //CLIC EN GUARDAR PARA ACTUALIZAR
        // O REPETIR LOS MISMOS PASOS ANTERIORES PUBLIC
        this.VistaEX.btnImportar.addActionListener(this);
        this.VistaEX.btnExportar.addActionListener(this);
        VistaEX.setVisible(true);
        VistaEX.setLocationRelativeTo(null);
    }

    public void AgregarFiltro() {
        SelectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        SelectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contador++;
        if (contador == 1) {
            AgregarFiltro();
        }

        if (e.getSource() == VistaEX.btnImportar) {
            if (SelectArchivo.showDialog(null, "Seleccionar Archivo") == JFileChooser.APPROVE_OPTION) {
                archivo = SelectArchivo.getSelectedFile();
                //ALT + 124 ||
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, ModeloEX.Importar(archivo, VistaEX.DatosExcel));
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccionar formato Valido");
                }
            }
        }
        //COPIAR Y PEGAR EL MISMO CODIGO

        if (e.getSource() == VistaEX.btnExportar) {
            if (SelectArchivo.showDialog(null, "Seleccionar Archivo") == JFileChooser.APPROVE_OPTION) {
                archivo = SelectArchivo.getSelectedFile();
                //ALT + 124 ||
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, ModeloEX.Exportar(archivo, VistaEX.DatosExcel));
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccionar formato Valido");
                }
            }
        }
    }

}
