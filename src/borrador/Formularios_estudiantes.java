/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrador;
import Metodos_sql.ConexionPos;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raul
 */
public class Formularios_estudiantes {
    
    DefaultTableModel dtmEjemplo;
    JTable tblEjemplo;
    JScrollPane scpEjemplo;
    public Formularios_estudiantes()
    {
 
        tblEjemplo = new JTable();
        scpEjemplo= new JScrollPane();
 
        //Llenamos el modelo
        dtmEjemplo = new DefaultTableModel(null,getColumnas());
 
        setFilas();
 
        tblEjemplo.setModel(dtmEjemplo);
        scpEjemplo.add(tblEjemplo);
        this.add(scpEjemplo);
        this.setSize(500, 200);
 
        scpEjemplo.setViewportView(tblEjemplo);
 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
 
    //Encabezados de la tabla
    private String[] getColumnas()
    {
          String columna[]=new String[]{"Id","Nombre","Apellido","Correo"};
          return columna;
    }
 
    private void setFilas()
    {
        //Conectar a PostgreSQL\\
        ConexionPos cnndb = new ConexionPos();
        CachedRowSet crs = cnndb.Function("SELECT id_estudiantes, nombre_estudiantes,apellido_estudiantes,correo_estudiantes FROM usuarios");
 
        Object datos[]=new Object[4]; //Numero de columnas de la tabla
 
        try {
            while (crs.next()) {
                for (int i = 0; i < 4; i++) {
                        datos[i] = crs.getObject(i + 1);
                }
                dtmEjemplo.addRow(datos);
                
            }
 
            crs.close();
        } catch (Exception e) {
        }
    }
 
    public static void main(String args[]) {
        Formularios_estudiantes obj1 = new Formularios_estudiantes();
        obj1.setVisible(true);
    }

    private void add(JScrollPane scpEjemplo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
    

