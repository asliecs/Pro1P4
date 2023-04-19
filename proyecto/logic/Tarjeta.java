/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Tarjeta {
   String tipo;
   String numeroTarjeta;
   Fecha fecha;
   String codigo;

    public Tarjeta() {
    }

    public Tarjeta(String tipo, String numeroTarjeta, String codigo, Fecha fecha) {
        this.tipo = tipo;
        this.numeroTarjeta = numeroTarjeta;
        this.fecha = fecha;
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   
}
   