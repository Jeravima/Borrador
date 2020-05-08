/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import Excel.ControladorExcel;
import Excel.ModeloExcel;
import Excel.VistaExcel;

/**
 *
 * @author JeanCarlos
 */
//CREAMOS UNA LIBRERIA E IMPORTAMOS LOS ARCHIVOS
public class ImportarExportarExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModeloExcel ModeloEX=new ModeloExcel();
        VistaExcel VistaEX=new VistaExcel();
        ControladorExcel ControlExcel=new ControladorExcel(VistaEX, ModeloEX);
        //EJECUTAMOS DESDE EL MAIN
    }
    
}
