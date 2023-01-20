
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
 */
public class Corriente extends Cuenta {
   static final int TIPO=1;  

    public Corriente(int NumeroCuenta, double Monto, boolean principal, int Tipo) {
        super(NumeroCuenta, Monto, principal, TIPO);
    }

    public Corriente() {
         super(0,0,false,TIPO);
    }
   

    @Override
    public String toString() {
        return "Corriente{"+getNumeroCuenta()+" "+getMonto()+'}';
    }

}
