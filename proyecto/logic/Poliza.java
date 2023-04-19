/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

import java.util.Objects;

/**
 *
 * @author jafet
 */
public class Poliza {
    String NumeroPoliza;
    Marca marca;
    double precio;
    Cliente cliente;
    

    public Poliza() {
    }

    public Poliza(String NumeroPoliza, Marca marca, double precio, Cliente cliente) {
        this.NumeroPoliza = NumeroPoliza;
        this.marca = marca;
        this.precio = precio;
        this.cliente = cliente;
    }


    

    

    public String getNumeroPoliza() {
        return NumeroPoliza;
    }


    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumeroPoliza(String NumeroPoliza) {
        this.NumeroPoliza = NumeroPoliza;
    }

    public Marca getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poliza other = (Poliza) obj;
        return Objects.equals(this.NumeroPoliza, other.NumeroPoliza);
    }
    
}
