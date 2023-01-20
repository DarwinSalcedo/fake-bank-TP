/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */
public class Persona {
  public   String  Nombre;           
  private  String  Cedula; 
  private  String  Clave ;         
  public   int     Tipo;

  //Constructores

    public Persona(String Nombre,String Cedula, String Clave, int Tipo) {
         setNombre(Nombre);   
        setCedula(Cedula);
        setClave(Clave);
        setTipo(Tipo);
    }
        public Persona(String Nombre) {
        setNombre(Nombre);
        setClave("");
        setCedula("");
        setTipo(-1);
    }
   public Persona(String Nombre, String Clave) {
    setNombre(Nombre);
    setClave(Clave);
    setCedula("");
    setTipo(-1);   
   }
      public Persona(String Nombre, String Clave, String Cedula) {
    setNombre(Nombre);
    setClave(Clave);
    setCedula(Cedula);
    setTipo(-1);   
   }

             public Persona(int Tipo) {
    setNombre("S/N");   
    setCedula("0");
    setClave("0");
    setTipo(Tipo);   
   }
       public Persona() {
    setNombre("S/N");   
    setCedula("0");
    setClave("0");
    setTipo(-1);   
   }
   //Getters y Setters 
   public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

   
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        this.Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Cedula=" + this.getCedula() + ", Clave=" + this.getClave() + ", Tipo=" + Tipo + '}';
    }



   

}
