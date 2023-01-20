
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */
public  class Tarjeta {
    static final int CARACTERES=5;
    static final int FILAS=4;
    static final int COLUMNAS=5;
   
    public int Serial;
    public String [][]arreglo =new String[FILAS][COLUMNAS];   
//Constructores
   public Tarjeta(){ 
       setSerial(0);
    for(int x=0;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
          setArreglo(x,i,"");
          }    
        }  
   }   
      public Tarjeta(int serial){ 
          setSerial(serial);
    for(int x=0;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
          setArreglo(x,i,"");
          }    
        }  
   }   
      
    public Tarjeta(String[][] A){  
          setSerial(0);
          setArreglo(A);        
   } 
//Get y Set
     public int getSerial() {
        return Serial;
    }

    public void setSerial(int Serial) {
        this.Serial = Serial;
    }
    
    public String[][] getArreglo() {
        return arreglo;
    }

    public void setArreglo(String[][] arreglo) {
        this.arreglo = arreglo;
    }
    
   public void setArreglo (int posicionFila, int posicionColumna, String valor){
    this.arreglo[posicionFila][posicionColumna] = valor;   
   }
   
   public String getArreglo (int posicionFila, int posicionColumna){
    return  this.arreglo[posicionFila][posicionColumna];   
   }
   
  //otros Metodos 
  public char letra(){
    int numero;  
    numero=(int)(Math.random()*(65-90+1)+90);
   return (char)numero;       
}

 public String    Subcadena(){
 String Cadena="";
 int numero ;
 for(int x=0;x<CARACTERES-1;x++){
  if (x==2){Cadena+=letra();}
     numero=(int)(Math.random()*8 + 1); 
     Cadena+=numero;    
 } 
 return Cadena;
 }
    
    public void  GenerarTarjeta(){
    for(int x=0;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
          setArreglo(x,i,Subcadena());
          }    
        }
   }   
    
        public String  MostrarTarjeta(){
            String Cadena;
             Cadena=Encabezado();           
            int num=0;
    for(int x=0;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
             if(i==0){Cadena+=Cuadro(num);num++;}
         Cadena+="\t"+getArreglo(x,i)+"!";          
          }  
          Cadena+="\n------------------------------------------------------\n";
        }
    return Cadena;
   } 
        
   public String UltimaComa(String cadena){
       String cadenaNueva = cadena.substring(0, cadena.length()-1);
       return cadenaNueva;
   }
           
   public String  CadenaTarjeta(){
     String Cadena="";      
    for(int x=0;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
          Cadena+=getArreglo(x,i)+",";
          }           
        }
    Cadena= UltimaComa(Cadena);
    return Cadena;
   }   
   
   
   public String Encabezado(){   
   return
   "------------------------------------------------------\n"
 + "\t  !\tA    !\tB    !\tC    !\tD    !\tE    !\n"
 +"------------------------------------------------------\n";
   }
      public String Cuadro(int num){   
   return "\t "+num+"!";
   }

    public void Guardar(String ruta){
    System.out.println(" estoy en guardar "+ruta);
   String Cadena = "";           
             Cadena+=Encabezado();               
            int num=0;
//manejo de excepciones      
      try{
 
            File archivo = new File(ruta);//se usa la clase para escribir caracteres en arhivo, se envia como parametro la ruta 
             FileWriter escribir = new FileWriter(archivo,true);
          //la clase para imprimir o escribir en archivos con formato

            for(int x=0; x<FILAS; x++){
                  for(int i=0; i<COLUMNAS; i++){
                       if(i==0){Cadena+=Cuadro(num);num++;}
         Cadena+="\t"+getArreglo(x,i)+"!";}
         Cadena+="\n------------------------------------------------------\n";              
      }
      escribir.write(Cadena);
      escribir.close();//se cierra el archivo
      }
      catch(IOException e){
      JOptionPane.showMessageDialog( null , "Error \n" + e);
      }  
   }  
      
    public void  CargarTarjetaDEBD(int serial,String Cadena){
    setSerial(serial);    
    String [] ArrayAux;
    ArrayAux=Cadena.split(",");
    for(int x=0,C=-1;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
           C++;            
          setArreglo(x,i,ArrayAux[C]);
          } 
        }
   }    
    
    
 
  /* 
   * 
   * 
   * 
   * 
   * public void Guardar(String ruta){
   System.out.println(" estoy en guardar "+ruta);
        String Cadena;
            Cadena=getSerial()+"\n";  
             Cadena+=Encabezado();               
            int num=0;
//manejo de excepciones      
      try{
 
            FileWriter arch = new FileWriter(ruta);//se usa la clase para escribir caracteres en arhivo, se envia como parametro la ruta 

            PrintWriter escribir = new PrintWriter(arch);//la clase para imprimir o escribir en archivos con formato

            for(int x=0; x<FILAS; x++){
                  for(int i=0; i<COLUMNAS; i++){
                       if(i==0){Cadena+=Cuadro(num);num++;}
         Cadena+="\t"+getArreglo(x,i)+"!";}
         Cadena+="\n------------------------------------------------------\n";              
      }
      escribir.print (Cadena);
      escribir.close();//se cierra el archivo
      }
      catch(IOException e){
      JOptionPane.showMessageDialog( null , "Error \n" + e);
      }  
   }  
      
      * 
      * public void EnviarBD(){
   String cadena1="",cadena2="",Query="";
   cadena1=getSerial();
   cadena2=CadenaTarjeta();
   Query="* from tarjeta where serial="+cadena1+";";
   }*/
   
   public boolean BuscarCoodenada(String cadena){
       for(int x=0;x<FILAS;x++){
         for(int i=0;i<COLUMNAS;i++){
         if (cadena.equals(getArreglo(x,i))){
            // System.out.println("FILA "+x+" Columna "+i+" cadena "+cadena+" arreglo "+getArreglo(x,i));
                 
                return true;
    
          }    
        } 
      
   }    return false;
}
   public int TransformarCaracter(char caracter){
       char letra;      
   HashMap<Character, Integer> ArrayAsoc = new HashMap<>();
   ArrayAsoc.put('A', 0);
   ArrayAsoc.put('B', 1);
   ArrayAsoc.put('C', 2);
   ArrayAsoc.put('D', 3);
   ArrayAsoc.put('E', 4);
   for (letra = 'A'; letra <= 'E'; letra++) {      
       if (caracter == letra) { return ArrayAsoc.get(letra);}
      }
        return 0;
   }
   public String UbicarCoordenada(int numero,char caracter){
    int i;
    i=TransformarCaracter(caracter);
     return getArreglo(numero,i);
    }  
   
 
   public char letraAE(){
    int numero;  
    numero=(int)(Math.random()*(65-70+1)+70);
   return (char)numero;       
}
   public int NumeroFila(){
   int numero;
    numero=(int)(Math.random()*(FILAS-1) + 0); 
    return  numero;
    
   }
   
   public void NumeroUbicar(int F,char H){  
   System.out.println(" UBIQUE ESTA COORDENADA EN SU TARJETA "
                      +F+" "+H);
   }
  
   public boolean isCoordenada(String cadena,int numero,char caracter){
      if (cadena.equals(this.UbicarCoordenada(numero, caracter))) {
           return true; 
       }else {
           return false;
       }   
   }

   
} 

