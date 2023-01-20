
import java.io.*;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */
public class Estudiante extends Persona {
 static final int TIPO=0;   
 public boolean becado;
 

        public Estudiante(String Nombre, String Clave, String Cedula, int Tipo) {
        super(Nombre, Clave, Cedula, TIPO);
    }

    public boolean isBecado() {
        return becado;
    }

    public void setBecado(boolean becado) {
        this.becado = becado;
    }

    public Estudiante(String Nombre,boolean Becado) {
        super(Nombre);
        setBecado(Becado);
    }

    public Estudiante(String Nombre, String Clave, String Cedula,boolean Becado) {
        super(Nombre, Clave, Cedula);
        setBecado(Becado);
    }

    public Estudiante(int Tipo,boolean Becado) {
        super(TIPO);
        setBecado(Becado);
    }

    public Estudiante() {
          super();
          setTipo(TIPO);
          setBecado(false);
    }



    public boolean EstudianteBecado(){
     String Query="Select * from Becado where Cedula="+this.getCedula()+";";
     return false;
    }
    
      public void Cargar()
  {
	InputStreamReader Canal = new InputStreamReader(System.in);//input
	BufferedReader Flujo = new BufferedReader(Canal);// faltava la d al buffer		
	String AuxString="";
	//COLOCO EL TIPO
	  setTipo(TIPO);
	//CEDULA 
	 try
	  {
		System.out.print("Cedula: ");		
                AuxString=Flujo.readLine();
		setCedula(AuxString);
	  }
	catch(Exception E)
	  {
		System.out.println("Error en el campo Cedula...se Asume 0");
		setCedula("0");
	  }

	//NOMBRE 
	try
	  {
		System.out.print("Nombre: ");
		
                AuxString=Flujo.readLine();
		setNombre(AuxString);
	  }
	catch(Exception E)
	  {
		System.out.println("Error en el campo NOMBRE...se Asume SIN NOMBRE");
		setNombre("SIN NOMBRE");
	  }
	//Clave
	try
	  {
		System.out.print("Clave : ");
		AuxString=Flujo.readLine();// estava raadline es float 
		setClave(AuxString);
	  }
	catch(Exception E)
	  {
		System.out.println("Error en el campo AÑO...se Asume 0");
		setClave("");
	  }
        //Becado
        try
	  {
		System.out.print("Esta Becado Si/No : ");
		AuxString=Flujo.readLine();// estava raadline es float 
		if (AuxString=="Si") setBecado(true);
                else setBecado(false);
	  }
	catch(Exception E)
	  {
		System.out.println("Error en el campo AÑO...se Asume 0");
		setBecado(false);
	  }
 
       
  }

    @Override
    public String toString() {
        return "Estudiante{" + "Nombre=" + Nombre + ", Cedula=" + this.getCedula() + ", Clave=" + this.getClave() + ", Tipo=" + Tipo + " becado=" + becado + '}';
    }
    }


