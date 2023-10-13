/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2.lab1progra2;

/**
 *
 * @author Admin
 */
public class CuentaBancaria {
    private int codigo;
    private String nombreCliente;
    private double saldoCuenta;
    
    public CuentaBancaria(int codigo, String nombreCliente){
        this.codigo=codigo;
        this.nombreCliente=nombreCliente;
        saldoCuenta=500;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }
    
    public void depositar(double monto){
        if(monto>0){
            saldoCuenta+=monto;
        }
    }
    
    public boolean retirar(double monto){
        if(monto>0&&monto<saldoCuenta){
            saldoCuenta-=monto;
            return true;
        }
        return false;
    }
    
    public String print(){
        String datos="Código: "+codigo+" - Nombre: "+nombreCliente+" - Saldo: "+saldoCuenta;
        return datos;
    }
    
}
