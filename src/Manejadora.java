
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */

public class Manejadora {
   static final String RUTA_PADRE="C:/BancoIUT";
    static final String RUTA_TARJETA="/Tarjetas/";
     static final String RUTA_GEC="/EstadoDeCuenta/";
      static final String RUTA_DEPOSITO="Depositos";
        static final String RUTA_RETIRO="Retiros";
          static final String RUTA_TRANSFERENCIA="Transferencias";
            static final String RUTA_PASAJE="Pasaje";
                static final String RUTA_PAGOS="Pagos";
                  static final String RUTA_TICKECT="/Ticket/";
    Persona Persona;
    Cuenta Cuenta;
    Tarjeta Tarjeta;
    Conexion Conexion=new Conexion();
    Menu M;
    
    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    public Cuenta getCuenta() {
        return Cuenta;
    }

    public void setCuenta(Cuenta Cuenta) {
        this.Cuenta = Cuenta;
    }

    public Tarjeta getTarjeta() {
        return Tarjeta;
    }

    public void setTarjeta(Tarjeta Tarjeta) {
        this.Tarjeta = Tarjeta;
    }

    public Conexion getConexion() {
        return Conexion;
    }

    public void setConexion(Conexion Conexion) {
        this.Conexion = Conexion;
    }

    public Menu getM() {
        return M;
    }

    public void setM(Menu M) {
        this.M = M;
    }
    
    
    public Manejadora(Persona Persona, Cuenta Cuenta, Tarjeta Tarjeta,Conexion c) {
        setPersona(Persona);
        setCuenta(Cuenta);
        setTarjeta(Tarjeta);
        setConexion(c); 
    }
    
    public Manejadora(Persona Persona) {
        setPersona(Persona);
        setCuenta(null);
        setTarjeta(null);
       setConexion(Conexion); 
    }
    
    public Manejadora(Persona Persona, Cuenta Cuenta ) {
        setPersona(Persona);
        setCuenta(Cuenta);
        setTarjeta(null);
        setConexion(Conexion); 
    }

    public Manejadora() {
        setPersona(null);
        setCuenta(null);
        setTarjeta(null);
        setConexion(Conexion); 
        setM(new Menu());
    }
  
    //----------------------------------------------------------persona
   
	
        public void Becado(String cedula) throws Exception{
           String Sql; 
          Sql= "insert into Becados values ("+cedula+");";
          System.out.println(Sql);
         this.DQL(Sql);            
        }
           public void cargarCliente(String cedula) throws IOException, Exception{
        InputStreamReader Canal = new InputStreamReader(System.in);
        BufferedReader Flujo = new BufferedReader(Canal);
        int i = 0;
        String AuxString;
        int AuxInt = 0;
        
        while(i != 4){
            switch (i){
                case 0:{
                    System.out.println("Ocupacion del cliente\n"
                            + "A: Administrativo\n"
                            + "D: Docente\n"
                            + "E: Estudiante\n"
                            + "O: Obrero\n"
                            + "Opcion: ");
                    AuxString = Flujo.readLine();
                    if (AuxString.charAt(0) == 'a' || AuxString.charAt(0) == 'A'){
                         setPersona(new Administrativo());
                         i++;
                    }else
                        if (AuxString.charAt(0) == 'd' || AuxString.charAt(0) == 'D'){
                            setPersona(new Docente());
                             i++;
                        }else
                            if (AuxString.charAt(0) == 'e' || AuxString.charAt(0) == 'E'){
                                 setPersona(new Estudiante());
                                 i++;
                            }else
                                if (AuxString.charAt(0) == 'o' || AuxString.charAt(0) == 'O'){
                                     setPersona(new Obrero());
                                     i++;
                                }else System.out.println("Error, ingrese un tipo de usuario correcto.\n\n");
                    break;
                }
                case 1:{
                  // System.out.println(this.getPersona().getTipo());
                    if (this.getPersona().getTipo() == 0){
                        System.out.println("El estudiante está becado? (S/N): ");
                        AuxString = Flujo.readLine();
                        if (AuxString.charAt(0) == 's' || AuxString.charAt(0) == 'S'){
                            ((Estudiante)getPersona()).setBecado(true);                              
                            i++;
                        }else
                            if (AuxString.charAt(0) == 'n' || AuxString.charAt(0) == 'N'){
                                ((Estudiante)getPersona()).setBecado(false);
                                i++;
                            }
                            else System.out.println("Error, ingrese una opcion valida.\n\n");                                           
                    }
                    else i++;
                    break;
                }                
                case 2:{
                    System.out.print("Ingrese el nombre y apellido: ");
                    String nombre = Flujo.readLine();
                    getPersona().setNombre(nombre);
                    i++;
                    break;
                }
                case 3:{
                    System.out.print("Ingrese la contraseña de su cuenta: ");
                    AuxString = Flujo.readLine();
                    System.out.print("Ingrese la contraseña de su cuenta nuevamente: ");
                    String confirm = Flujo.readLine();
                    if (AuxString.equals(confirm)){
                        getPersona().setClave(AuxString);
                        i++;
                    }else System.out.println("Las contraseñas no coinciden.\n\n");
                    break;
                }
            }
        }
        getPersona().setCedula(cedula);
    }
       public boolean agregarClienteEnBDD() throws Exception{
        String sql ="insert into Clientes values(" + getPersona().getCedula() + ",'" + getPersona().getNombre() + "','" + getPersona().getClave() + "'," + getPersona().getTipo() + ");";
       System.out.println(sql);
        return DQL(sql);       
    }       
      public void cargarCuenta() throws Exception{
        InputStreamReader Canal = new InputStreamReader(System.in);
        BufferedReader Flujo = new BufferedReader(Canal);
         Scanner sc = new Scanner(System.in);
        String AuxString;
        
        boolean correcto = false;
        
        while (!correcto){
            System.out.println("Tipo de la cuenta principal? (A: Ahorro, C: Corriente): ");
            try {
                AuxString = Flujo.readLine();
                if (AuxString.charAt(0) == 'a' || AuxString.charAt(0) == 'A'){
                    setCuenta(new Ahorro());                       
                    ((Ahorro)getCuenta()).setNumeroCuenta(this.TotaldeCuentas());
                  System.out.println("Monto iniciar de tu cuenta: ");   
                    ((Ahorro)getCuenta()).setMonto(sc.nextDouble());
                     ((Ahorro)getCuenta()).setPrincipal(true);
                    correcto = true;
                    
                }else
                    if (AuxString.charAt(0) == 'c' || AuxString.charAt(0) == 'C'){
                        setCuenta(new Corriente());
                        // System.out.println("Numero de cuenta: ");   
                        ((Corriente)getCuenta()).setNumeroCuenta(this.TotaldeCuentas());
                         System.out.println("Monto iniciar de tu cuenta: "); 
                        ((Corriente)getCuenta()).setMonto(sc.nextDouble());
                        ((Corriente)getCuenta()).setPrincipal(true);
                        correcto = true;
                       
                    }else System.out.println("Opcion invalida.");
            
            } catch (IOException ex) {
                Logger.getLogger(Manejadora.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
                
    }  

    public String NombreRutaTarjeta(){
      String cadena="";   
      return cadena=this.getPersona().getNombre()+this.getPersona().getCedula()+".txt";   
    } 

    
    public boolean aperturar() throws IOException, Exception{
     InputStreamReader Canal = new InputStreamReader(System.in);
     BufferedReader Flujo = new BufferedReader(Canal);
     System.out.print("Ingrese Cedula: ");
     String cedula=Flujo.readLine();// leer cedula pàra verficar
    if ( !this.VerficarCedula(cedula)){
      this.cargarCliente(cedula);
      this.cargarCuenta();
      this.CargarTarjetaBD();
       if (this.agregarClienteEnBDD())  System.out.print(" agrge cliente");
       if (this.agregarTarjetaABDD()) this.getTarjeta().Guardar(RUTA_PADRE+RUTA_TARJETA+this.NombreRutaTarjeta());
       
       if (this.getPersona().getTipo()==0){
                 if(((Estudiante)getPersona()).isBecado()) this.Becado(cedula);}
       if (this.agregarCuentaEnBDD())System.out.print(" agrge cuenta");
       return true;
        }    
     return false;
}
   public boolean agregarCuentaEnBDD() throws Exception{
        String sql ="insert into Cuentas values('" + getCuenta().getNumeroCuenta() + "'," + getPersona().getCedula() + ","+this.getCuenta().getMonto()+"," + ((getCuenta().isPrincipal()) ? "true":"false") + "," + getCuenta().getTipo() +");";
       System.out.println(sql);
        return DQL(sql);       
    }   
 public boolean agregarTarjetaABDD() throws Exception{
        String sql ="insert into Tarjeta_Coordenadas values(" + getTarjeta().getSerial() + "," + getPersona().getCedula() + ",'" + getTarjeta().CadenaTarjeta() + "');";
        return DQL(sql);       
    }   
    //----------------------------------------------------------persona
    
    //----------------------------------------------------------tarjeta
     public void  CargarTarjetaBD() throws Exception{
          this.setTarjeta(new Tarjeta());
          this.getTarjeta().setSerial(TotaldeTarjetas()); //-----> numero de cuenta  
        this.getTarjeta().GenerarTarjeta();
        System.out.println(this.getTarjeta().MostrarTarjeta());
   }    
    
   public boolean trajetaEnviarBD() throws Exception{
         
       String sql = "insert into Tarjeta_Coordenadas values((select nextval('CodigoTarjeta') )," + getPersona().getCedula() + ",'" + getTarjeta().CadenaTarjeta()+ "');";
       System.out.println(sql);
        return DQL(sql);  
   }
   //----------------------------------------------------------tarjeta 
   public int TotaldeTarjetas() throws Exception{ 
   String sql = "select count(*) as total from Cuentas;";
          System.out.println(sql);
        return obtenerCantidadEnBD(sql)+1;  
   }
   
       public int TotaldeCuentas() throws Exception{ 
   String sql = "select count(*) as total from Tarjeta_Coordenadas;";
          System.out.println(sql);
        return obtenerCantidadEnBD(sql)+1;  
   }
   //----------------------------------------------------------Cuenta
   public int obtenerCantidadEnBD(String SQL) throws Exception{ 
       ResultSet Cursor=Conexion.Cursor(SQL);
         try{
            Cursor.next(); 
             // System.out.println("cantidad1"+Cursor.getInt("total"));
            return Cursor.getInt("total");
                      	}		
			catch(Exception ex) {
		      System.out.println("ERROR");
                        } 
        return 0; 
    }
   
   //----------------------------------------------------------Cuenta
   
    //----------------------------------------------------------Iniciar Sesion
   public boolean DML(String SQL) throws Exception{      
     ResultSet Cursor=Conexion.Cursor(SQL);
         try{
            if(Cursor.next())return true;  
                      	}		
			catch(Exception ex) {
		      System.out.println("ERROR");
                        } 
        return false;
  }
          
	public boolean DQL(String SQL) throws Exception{	
		try{
			if(Conexion.Ejecutar(SQL) != -1)return true;                     
                     }				
                    catch(IOException | PSQLException ex) {
		     System.out.println("ERROR");
                     }  
		   return false;   
	}
   
   public boolean VerficarCedula(String cedula) throws Exception{
        String sql="select ci  from  Clientes where ci='"+cedula+"';";       
       return DML(sql);      
   }   
   
      public boolean VerficarClaveCedula(String cedula,String clave) throws Exception{
        String sql="select *  from  Clientes   where ci="+cedula+" and  contrasenia='"+clave+"';";  
        // System.out.println(sql);
       return DML(sql);      
   }  
   
   public boolean Iniciar() throws IOException, Exception{
            InputStreamReader Canal = new InputStreamReader(System.in);//input
            BufferedReader Flujo = new BufferedReader(Canal);//
            String cedula="",clave="";
             System.out.println(" INICIAR SESSION ");
            System.out.print(" Ingrese su cedula ");
            cedula=Flujo.readLine();
            System.out.print("Ingrese su contrasenia ");
            clave=Flujo.readLine(); 
           
            if (this.CargarCuentaCliente(cedula))//{ System.out.print("Cuenta  Cargados ");
           // System.out.println( this.getCuenta().toString());
           // }
           //  else  System.out.print(" fali al cargar  cuenta");
            
            if(this.CargarCliente(cedula))// {System.out.print(" cliente Cargados ");
           // System.out.println( this.getPersona().toString());}
            
           //  else  System.out.print(" fali al cargar  cliente");
            
            if (VerficarClaveCedula(cedula,clave)){
                if (this.CargarTarjetaCliente(cedula)){//Carge la tarjeta
                   if (this.autentificar()){ return true;}
                }
                //Cargar Cliente de la BD
             }
        return false;
   }
   
 public boolean autentificar() throws IOException{    
      InputStreamReader Canal = new InputStreamReader(System.in);//input
     BufferedReader Flujo = new BufferedReader(Canal);
    // System.out.println(this.getTarjeta().MostrarTarjeta());  
     int F=this.getTarjeta().NumeroFila();
     char H=this.getTarjeta().letraAE();
     this.getTarjeta().NumeroUbicar(F, H); 
     //System.out.println(this.getTarjeta().UbicarCoordenada(F, H));   

    String aux="";
    aux=Flujo.readLine();
    if (this.getTarjeta().isCoordenada(aux, F, H))  return true; 

    return false;
     
 }  
   //----------------------------------------------------------Iniciar Sesion
   
   public boolean extraerTarjetaBD(String sql) throws Exception{
     //       System.out.println(sql);
     ResultSet Cursor=Conexion.Cursor(sql);
         try{
            Cursor.next();
                        this.setTarjeta(new Tarjeta());
                        this.getTarjeta().CargarTarjetaDEBD(Cursor.getInt("cod_tarjeta"),Cursor.getString("coordenadas"));
                     //   System.out.println(" cargo tarjeta "+ Cursor.getInt("cod_tarjeta")+
                     //    Cursor.getString("coordenadas"));
                        return true;
                      	}		
			catch(Exception ex) {
		      System.out.println("ERROR");
                        } 
        return false;   
   }
   
      public boolean extraerCuentaBD(String sql) throws Exception{
       //    System.out.println(sql);
     ResultSet Cursor=Conexion.Cursor(sql);
         try{
            Cursor.next();                        
                        if (Cursor.getInt("tipo_cuenta")==0){
                             setCuenta(new Ahorro());                       
                            ((Ahorro)getCuenta()).setNumeroCuenta(Cursor.getInt("nro_cuenta"));                   
                            ((Ahorro)getCuenta()).setMonto(Cursor.getDouble("monto"));
                            ((Ahorro)getCuenta()).setPrincipal(Cursor.getBoolean("principal"));
                             return true;
                        }
                       else {
                            setCuenta(new Corriente());                       
                            ((Corriente)getCuenta()).setNumeroCuenta(Cursor.getInt("nro_cuenta"));                   
                            ((Corriente)getCuenta()).setMonto(Cursor.getDouble("monto"));
                            ((Corriente)getCuenta()).setPrincipal(Cursor.getBoolean("principal"));
                            
                         return true;}              
                        }		
			catch(Exception ex) {
		      System.out.println("ERROR");
                        } 
        return false;   
   }
     
    public boolean extraerClienteBD(String sql) throws Exception{
           System.out.println("extraerClienteBD" + sql);
     ResultSet Cursor=Conexion.Cursor(sql);
         try{
            Cursor.next();
          //  System.out.println(Cursor.getInt("tipo"));
                        int i=0;  
                                switch (i){
                                    case 0:{                                        
                                          // System.out.println(" case 0 "+Cursor.getInt("tipo"));
                                        if (Cursor.getInt("tipo")==0){
                                             setPersona(new Estudiante());
                                             i++;
                                        }else
                                            if (Cursor.getInt("tipo")==-1){
                                                setPersona(new Docente());
                                                 i++;
                                            }else
                                                if (Cursor.getInt("tipo")==-1){
                                                     setPersona(new Administrativo());
                                                     i++;
                                                }else
                                                    if (Cursor.getInt("tipo")==-1){
                                                         setPersona(new Obrero());
                                                         i++;
                                                    }                                        
                                    }                            
                                    case 1:{  
                                       //  System.out.println(" case 2 "+Cursor.getInt("tipo"));
                                        getPersona().setNombre(Cursor.getString("nombre"));
                                        i++;
                                      
                                    }
                                    case 2:{
                                       //  System.out.println(" case 3 "+Cursor.getInt("tipo"));
                                        getPersona().setClave(Cursor.getString("contrasenia"));
                                        i++;
                                      
                                        }
                                    case 3:{
                                      //   System.out.println(" case 4 "+Cursor.getInt("tipo"));
                                        getPersona().setCedula(Cursor.getString("ci"));
                                        i++;
                                       // System.out.print("CARGANDO CLIENTE "+i);
                                       
                                        }   
                                    } 
                                  return true;
                }		
			catch(Exception ex) {
		      System.out.println("ERROR");
                        } 
        return false;   
   }   
    //----------------------------------------------------------Autenticarse
  
  public boolean CargarTarjetaCliente(String cedula) throws Exception {        
        String sql="select *  from  Clientes C,Tarjeta_Coordenadas T Where C.ci=T.ci_cliente and C.ci="+cedula+";";       
         return extraerTarjetaBD(sql);   
   }
  
    public boolean CargarCuentaCliente(String cedula) throws Exception {        
        String sql="select *  from  Clientes C,Cuentas T Where C.ci=T.ci_cliente and C.ci="+cedula+";";       
         return extraerCuentaBD(sql);   
   }
     public boolean CargarCliente(String cedula) throws Exception {        
        String sql="select *  from  Clientes  Where ci="+cedula+";";       
         return extraerClienteBD(sql);   
   }
     
   //----------------------------------------------------------Autenticarse
  
  
  //----------------------------------------------------------menu interno
  public void menuInterno() throws IOException, Exception{
      
      switch(this.getM().MenuInterno()){
       
            case '1': { 
                        if ( realizarDeposito()) { System.out.println(" Transaccion Realizada con exito");}
                        else System.out.println(" No pudimos procesar la informacion intente luego");
                       break;}
                case '2': { if( realizarRetiro()){ System.out.println(" Transaccion Realizada con exito");}
                        else System.out.println(" No pudimos procesar la informacion intente luego");
                            break; }
                    case '3': {if( realizarTransferencia()){ System.out.println(" Transaccion Realizada con exito");}
                        else System.out.println(" No pudimos procesar la informacion intente luego");
                                break; }
                        case '4': {if (RealizarEstadoDeCuenta()){ System.out.println(" Transaccion Realizada con exito");}
                            else System.out.println(" No pudimos procesar la informacion intente luego");
                                    break; }
                            case '5': {tipoMenu();
                                        break; }
                                case '6': {CambioClave();System.out.println("6.");
                                            break; }
      }        
      
  }  
  
   public void CambioClave() throws IOException, Exception {
       InputStreamReader Canal = new InputStreamReader(System.in);
     BufferedReader Flujo = new BufferedReader(Canal);
     String AuxString;
       System.out.print("Esta Es la contraseña de su cuenta: "+ getPersona().getClave());
      System.out.print("Ingrese la contraseña Nueva: ");
                    AuxString = Flujo.readLine();
                    System.out.print("Ingrese la contraseña nuevamente: ");
                    String confirm = Flujo.readLine();
                    if (AuxString.equals(confirm)){
                        getPersona().setClave(AuxString);
                    if (ActualizoClienteEnBD(AuxString)){
                        System.out.println("Contraseña actualizada\n");
                    generarTicket("CAMBIO CONTRASENIA",0);
                    comprobante(0,"CAMBIO CONTRASENIA");
                    }
                    }else System.out.println("Las contraseñas no coinciden.\n"); 
        
    }
   
    public boolean  ActualizoClienteEnBD(String Contrasenia) throws Exception{
      String sql="  update Clientes set contrasenia='"+Contrasenia +"'  where nro_ci="+this.getPersona().getCedula() +";" ;
      return DQL(sql);   
    }
      private void tipoMenu() throws IOException, Exception {
      if (this.getPersona().getTipo()==0) {
        switch(this.getM().MenuEstudiante()){
            case '1':{if (PagarTarjeta()){ System.out.println(" Transaccion Realizada con exito");}
                            else System.out.println(" No pudimos procesar la informacion intente luego");
                    break;}
        }
       
      } else{
          switch(this.getM().Menupersonal()){
            case '1':{if (PagarotrosServicios("Abono Cuenta Proveeduria")){ System.out.println(" Transaccion Realizada con exito");}
                            else System.out.println(" No pudimos procesar la informacion intente luego");
                    break;}
                case '2':{if (PagarotrosServicios("Pagar Cuenta Proveeduria")){ System.out.println(" Transaccion Realizada con exito");}
                            else System.out.println(" No pudimos procesar la informacion intente luego");
                        break;}
                    case '3':{if (PagarotrosServicios("Otros/Luz/Agua/Aseo")){ System.out.println(" Transaccion Realizada con exito");}
                            else System.out.println(" No pudimos procesar la informacion intente luego");
                            break;}
        }
      
      }
          
       
    }
    public boolean realizarDeposito() throws IOException, Exception{
    Scanner sc = new Scanner(System.in);  //crear un objeto Scanner
    double monto,aux;
    int nrocta;
    System.out.println(this.getCuenta().getMonto());
       System.out.print("numero de cuenta destino ");
        nrocta=sc.nextInt();
    System.out.print(" ingrese Monto a depositar ");
    monto=sc.nextDouble();  
    
   if (this.getCuenta().getNumeroCuenta()!=nrocta){ 
            if (this.getCuenta().isDebitable(monto)){
                this.getCuenta().debitarMonto(monto); 
              if ( actualizarCuentaEnBDD()) {
                  generarTicket(RUTA_DEPOSITO,monto);
                  DepositosEnBDD(monto,nrocta);
                  comprobante(monto,RUTA_DEPOSITO);
                  return true;}     
        }

  } 
   return false;  
  }
  public boolean PagarTarjeta() throws IOException, Exception{  
    double monto=10.0;
  System.out.print("Se ha debitado 10 bf de su cuenta  ");

            if (this.getCuenta().isDebitable(monto)){
                this.getCuenta().debitarMonto(monto); 
              if ( actualizarCuentaEnBDD()) {
                  generarTicket(RUTA_PASAJE,monto);
                  PagoServicioEnBDD(monto,RUTA_PASAJE);
                  comprobante(monto,RUTA_PASAJE);
                  return true;}     
        }
   return false;  
  }
  
  public boolean PagarotrosServicios(String NombreServicio) throws IOException, Exception{  
  Scanner sc = new Scanner(System.in);  //crear un objeto Scanner
    double monto;
    System.out.print(" ingrese Monto "+NombreServicio);
    monto=sc.nextDouble();  
    
   
            if (this.getCuenta().isDebitable(monto)){
                this.getCuenta().debitarMonto(monto); 
              if ( actualizarCuentaEnBDD()) {
                  generarTicket(NombreServicio,monto);
                   PagoServicioEnBDD(monto,NombreServicio);
                  comprobante(monto,NombreServicio);
                  return true;}     
      

  } 
   return false;  
  }
      public boolean PagoServicioEnBDD(double monto,String tipo ) throws Exception{
        String sql =" insert into Pagos values('"+numeroRef(RUTA_PAGOS)+"',"+this.getCuenta().getNumeroCuenta()+",'"+tipo+"',"+monto+",'"+Fecha()+"');";
       System.out.println(sql);
        return DQL(sql);       
    } 
      
   public boolean realizarRetiro() throws Exception {
        Scanner sc = new Scanner(System.in);  //crear un objeto Scanner
    double monto,aux;
    System.out.println(this.getCuenta().getMonto());
    System.out.print(" ingrese Monto del Retiro ");
    monto=sc.nextDouble();    
   
            if (this.getCuenta().isDebitable(monto)){
                this.getCuenta().debitarMonto(monto); 
              if ( actualizarCuentaEnBDD()) {
                  generarTicket(RUTA_RETIRO,monto);
                  RetirosEnBDD(monto);
                  comprobante(monto,RUTA_RETIRO);
                  return true;}     
       

    } 
   return false;  
        
    }

    public boolean realizarTransferencia() throws Exception {
        Scanner sc = new Scanner(System.in);  //crear un objeto Scanner
    double monto,aux;
      System.out.print("numero de cuenta destino ");
      int nrocta = sc.nextInt();
    System.out.println(this.getCuenta().getMonto());
    System.out.print(" ingrese Monto del Transferencia ");
    monto=sc.nextDouble();    
   
            if (this.getCuenta().isDebitable(monto)){
                this.getCuenta().debitarMonto(monto); 
              if ( actualizarCuentaEnBDD()) {
                  generarTicket(RUTA_TRANSFERENCIA,monto);
                  transferenciaEnBDD(monto,nrocta);
                  comprobante(monto,RUTA_TRANSFERENCIA);
                  return true;}       
 } 
   return false;  
        
    }
  
     public boolean actualizarCuentaEnBDD() throws Exception{
        String sql =" update Cuentas set monto="+this.getCuenta().getMonto()+" where nro_cuenta="+this.getCuenta().getNumeroCuenta()+";";
       System.out.println(sql);
        return DQL(sql);       
    } 
     
    public boolean DepositosEnBDD(double monto ,int nrocta) throws Exception{
        String sql =" insert into Depositos values('"+numeroRef(RUTA_DEPOSITO)+"',"+nrocta+","+monto+",'"+Fecha()+"');";
       System.out.println(sql);
        return DQL(sql);       
    }  
  //----------------------------------------------------------menu interno

    private void generarTicket(String tipo,double Monto) throws SQLException {
        String Cadena="";
       Cadena+="------------------------\n";
       Cadena+=Fecha()+"\n";
       Cadena+="  ticket  \n";
       Cadena+=" Tipo de Operacion  \n";
       Cadena+=tipo+"\n";
       Cadena+=" Monto de la Operacion  \n";
       Cadena+=Monto+"\n";
       Cadena+="------------------------\n";
       System.out.println(Cadena);
       this.GenerarTickecDD(Cadena);
    }
   
    public void GenerarTickecDD(String Cadena) throws SQLException{
      try {
          String ruta;
           ruta = RUTA_PADRE+RUTA_TICKECT+NombreRutaTarjeta();
           System.out.println(ruta);
           File archivo = new File(ruta);//se usa la clase para escribir caracteres en arhivo, se envia como parametro la ruta 
           FileWriter escribir = new FileWriter(archivo,true);           
            escribir.write(" Fecha "+Fecha()+"\n"
            +" Cliente "+this.getPersona().getNombre()+"\n");
            escribir.write(Cadena);          
           escribir.close();    
       }
      catch(Exception ex) 
      {System.out.println("ERROR");}
    }
    public String Fecha(){
      String cadena ="";
       GregorianCalendar Date =new GregorianCalendar();
        cadena=Date.get(GregorianCalendar.DAY_OF_MONTH)+"/"+Date.get(GregorianCalendar.MONTH)+"/"+Date.get(GregorianCalendar.YEAR);
      return cadena;  
    }

    private int numeroRef(String parametro) throws Exception {        
            String sql = "select count(*) as total from " +parametro + ";";
          System.out.println(sql);
        return obtenerCantidadEnBD(sql)+1;  
   
    }
    private int numeroComprobante() throws Exception {        
            String sql = "select count(*) as total from Comprobante;";
          System.out.println(sql);
        return obtenerCantidadEnBD(sql)+1;  
   
    }

    private boolean comprobante(double monto,String tipo) throws Exception {
         String sql =" insert into Comprobante values('"+numeroComprobante()+"',"+this.getCuenta().getNumeroCuenta()+",'"+ tipo+"',"+monto+",'"+Fecha()+"');";
       System.out.println(sql);
        return DQL(sql);
    }

    private boolean RetirosEnBDD(double monto) throws Exception {
        String sql =" insert into Retiros values('"+numeroRef(RUTA_RETIRO)+"',"+this.getCuenta().getNumeroCuenta()+","+monto+",'"+Fecha()+"');";
       System.out.println(sql);
        return DQL(sql);   
    }

    private boolean transferenciaEnBDD(double monto,int nrocta) throws Exception {
      String sql =" insert into Transferencia values('"+numeroRef(RUTA_TRANSFERENCIA)+"',"+this.getCuenta().getNumeroCuenta()+","+nrocta+","+monto+",'"+Fecha()+"');";
       System.out.println(sql);
        return DQL(sql);      
    }


    public boolean RealizarEstadoDeCuenta() throws SQLException{
       String sql ="  select * from comprobante where nro_cuenta="+this.getCuenta().getNumeroCuenta()+";";
       return GenrarEstadoDeCuenta(sql);
    }
    
   public boolean GenrarEstadoDeCuenta(String Sql ) throws SQLException{
      try {
          String ruta;
           ruta = RUTA_PADRE+RUTA_GEC+NombreRutaTarjeta();
           System.out.println(ruta);
           File archivo = new File(ruta);//se usa la clase para escribir caracteres en arhivo, se envia como parametro la ruta 
           FileWriter escribir = new FileWriter(archivo,true);
           
            escribir.write(" Fecha "+Fecha()+"\n"
                    +" Cliente "+this.getPersona().getNombre()+"\n");
    	  Conexion C = new Conexion();
    	  ResultSet Cursor;
    	  Cursor=C.Cursor("select * from comprobante where nro_cuenta="+this.getCuenta().getNumeroCuenta()+";");
          while(Cursor.next())
                 {//nro cta 
                   escribir.write(Cursor.getInt("nro_cuenta")+" "+Cursor.getString("tipo_trans")+" "+Cursor.getInt("monto_trans")+" "+Cursor.getDate("fecha"));          
                 }
        escribir.close();    
        Cursor.close(); 
        return true;
      }
      catch(Exception ex) 
      {System.out.println("ERROR");}
      return false;
	}

   

}
