/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_sql;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
/**
 *
 * @author Estructura de Datos D1
 */
public class ConexionPos {
    public CachedRowSet Function(String sql)
    {
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:8080/postgres";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/unipaz", "root","");
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
 
                    ResultSet rs= s.executeQuery(sql);
 
                    CachedRowSet crs = new CachedRowSetImpl();
                    crs.populate(rs);
 
                    rs.close();
                    s.close();
                    con.close();
 
                    return crs;
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
 
            return null;
    }
 
    public void StoreProcedure(String sql)
    {
 
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:8080/postgres";
                    Connection con = DriverManager.getConnection(url, "usuario","contraseña");
                    Statement s = con.createStatement();
 
                    s.execute(sql);
 
                    s.close();
                    con.close();
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
    }
}