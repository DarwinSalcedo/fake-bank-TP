
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */
public class Menu {
    public String opcion;

 
    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        setOpcion(opcion);
    }
    
       public Menu() {
    }

    public Menu(String opcion) {
        this.opcion = opcion;
    }

    public int MenuPrincipal() {
        InputStreamReader Canal = new InputStreamReader(System.in);//input
	BufferedReader Flujo = new BufferedReader(Canal);
        int eleccion=0;
      
        System.out.println(" MENU ");
        System.out.println("1 Crear cuenta ");
        System.out.println("2 Iniciar Session ");
        System.out.println("3 Finalizar ");
        System.out.print("Opcion ");
        try{//ciclo repetir hata q la elceccion sea correcta
        eleccion=Flujo.read();}
        catch(Exception e){
        System.out.println("Error en la lectura del menu ");
        }
        finally{limpiarPantalla();
        return eleccion;}
    }
     public int MenuCrearCuenta() {
        InputStreamReader Canal = new InputStreamReader(System.in);//input
	BufferedReader Flujo = new BufferedReader(Canal);
        int eleccion=0;
        limpiarPantalla();
        System.out.println(" MENU ");
        System.out.println("1 Esudiante ");
        System.out.println("2 Docente ");
        System.out.println("3 Administrativo ");
        System.out.println("4 Obrero ");
        System.out.println("5 Cancelar ");
        System.out.print("Opcion ");
        try{//ciclo repetir hata q la elceccion sea correcta
        eleccion=Flujo.read();}
        catch(Exception e){
        System.out.println("Error en la lectura del menu ");
        }
        finally{
        limpiarPantalla();    
        return eleccion;
        }
    }
     
     public int MenuInterno() {
        InputStreamReader Canal = new InputStreamReader(System.in);//input
	BufferedReader Flujo = new BufferedReader(Canal);
        int eleccion=0;
        
        System.out.println(" Menu ");
        System.out.println("1 Deposito ");
        System.out.println("2 Retiro ");
        System.out.println("3 Transferencia ");
        System.out.println("4 Estado de Cuenta ");
        System.out.println("5 pagos de servico ");
        System.out.println("6 Cambio de Clave  ");
        System.out.print("Opcion ");
        try{//ciclo repetir hata q la elceccion sea correcta
        eleccion=Flujo.read();}
        catch(Exception e){
        System.out.println("Error en la lectura del menu ");
        }
        finally{limpiarPantalla();
        return eleccion;}
    }
     
      public int Menupersonal() {
        InputStreamReader Canal = new InputStreamReader(System.in);//input
	BufferedReader Flujo = new BufferedReader(Canal);
        int eleccion=0;        
        System.out.println(" Menu ");
        System.out.println("1 abono prveeduria ");
        System.out.println("2 pagar proveeduria  ");
        System.out.println("3 otros ");
        System.out.print("Opcion ");
        try{//ciclo repetir hata q la elceccion sea correcta
        eleccion=Flujo.read();}
        catch(Exception e){
        System.out.println("Error en la lectura del menu ");
        }
        finally{limpiarPantalla();
        return eleccion;}
    } 
    
        public int MenuEstudiante() {
        InputStreamReader Canal = new InputStreamReader(System.in);//input
	BufferedReader Flujo = new BufferedReader(Canal);
        int eleccion=0;        
        System.out.println(" Menu ");
        System.out.println("1 Pasaje Estudiantil ");
        System.out.print("Opcion ");
        try{//ciclo repetir hata q la elceccion sea correcta
        eleccion=Flujo.read();}
        catch(Exception e){
        System.out.println("Error en la lectura del menu ");
        }
        finally{limpiarPantalla();
        return eleccion;}
    } 
     
     public void limpiarPantalla(){
     for(int i=0;i<50;i++)
         System.out.println(" ");     
     }
}
