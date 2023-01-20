
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */     //   import javax.swing.JOptionPane;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;

public class Ppl {
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
     Manejadora m= new Manejadora();
    boolean fin=false;
      do{
   switch(m.getM().MenuPrincipal()){
       
            case '1': {if (m.aperturar())
                                   System.out.println("Registrado correctamente.");
                                else
                                     System.out.println("No se pudo procesar Intente de Nuevo.");
            break;}
                      
            case '2': { if  (m.Iniciar()){
                        System.out.println(" Bienvenido "); 
                        m.menuInterno();
                       }
                        else  System.out.println("No se pudo procesar Intente de Nuevo.");
           break;}
                
           case '3': {fin=true;
           break;}
                
            default: {System.out.println("Elija una correcta ");}
        }     

       
   }while(fin==false);
  
  
 
 
}}
