/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salcedo
 */
class Cuenta {
private int NumeroCuenta;
private double Monto ;
public boolean principal;
public int Tipo;

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public int getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(int NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public Cuenta(int NumeroCuenta, double Monto,boolean principal,int Tipo) {
        setNumeroCuenta(NumeroCuenta);
        setMonto(Monto);
        setTipo(Tipo);
        setPrincipal(principal);
    }
   public Cuenta() {
        setNumeroCuenta(0);
        setMonto(0);
        setTipo(0);
        setPrincipal(false);
    }
   
   public void depositarMonto(double monto){
        setMonto(getMonto() + monto);
    }
    public void debitarMonto(double monto){
        depositarMonto(monto * -1);
    }
    
      public boolean isDebitable(double monto){
        double aux=getMonto() - monto;
        if  (aux >= 0) return true;
        return false;
    }
   
    @Override
    public String toString() {
        return "Cuenta{" + "NumeroCuenta=" + NumeroCuenta + ", Monto=" + Monto + ", principal=" + principal + ", Tipo=" + Tipo + '}';
    }
   
   
}
