/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */
import java.sql.*;
public class Conexion {
	
    private String BaseDatos = "BDDBancaIUT";
    private String Usuario = "postgres";
    private String Contrasenhia = "12345";
    private String Url = "jdbc:postgresql://127.0.0.1:5432/";
    //====================================================  
    
    
    public String getBaseDatos() {
		return BaseDatos;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public void setBaseDatos(String baseDatos) {
		BaseDatos = baseDatos;
	}
	public String getContrasenhia() {
		return Contrasenhia;
	}
	public void setContrasenhia(String contrasenhia) {
		Contrasenhia = contrasenhia;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	//========================================================

public Conexion(String baseDatos, String usuario, String contrasenhia,
		String url) {
	super();
	setBaseDatos(baseDatos);
	setUsuario(usuario);
	setContrasenhia(contrasenhia);	
	setUrl(url+getBaseDatos());
}

public Conexion() {
	super();
	setBaseDatos("BDDBancaIUT");
	setUsuario("postgres");
	setContrasenhia("12345");	
	setUrl("jdbc:postgresql://127.0.0.1:5432/"+getBaseDatos());
        System.out.println(Url);
}
	//========================================================

    public Connection openBDD() throws Exception
    {
          Connection conn = null;
          try
          {
           Class.forName("org.postgresql.Driver").newInstance();          //
           conn = DriverManager.getConnection(getUrl(),getUsuario(),getContrasenhia());
           System.out.println("success "+conn);
           return conn;
          }
          catch(Exception ex) 
          {
              System.out.println("exep "+ex);
                return null;
          }
    }
  //========================================================
    public ResultSet Cursor(String SQL) throws Exception
    {
          Connection conn = null;
          try
          {
           if ((conn=openBDD()) != null)
            {                
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery(SQL);
             return res;             
            }
    }
    catch(SQLException ex)
    {System.out.println("Entre por la SQLException " + ex + SQL);}
    catch(ClassNotFoundException ex) 
    {System.out.println("Entre porla ClassNotFoundException");}
    return null;
}
//========================================================
public int Ejecutar(String SQL) throws Exception
{
    Connection conn = null;
    try
    {
     if ((conn=openBDD()) != null)
      {                
       Statement stmt = conn.createStatement();
       int res = stmt.executeUpdate(SQL);
       return res;             
      }    
    }
    catch(SQLException ex)
    {System.out.println("Entre por la SQLException " + ex + SQL);}
    catch(ClassNotFoundException ex) 
    {System.out.println("Entre porla ClassNotFoundException");}
    return -1;
}
//========================================================

	
	

}