/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Cliente {
    String cedula;
    String nombre;
    String telefono;
    String correo;
    Usuario usuario;
    Tarjeta tarjeta;
    List<Cuenta> cuentas;
    
    public Cliente(String cedula, String nombre, String telefono, String correo, Usuario usuario, Tarjeta tarjeta){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.tarjeta = tarjeta;
        this.cuentas = new ArrayList();
    }
    
    public Cliente(String cedula, String nombre, Usuario usuario){
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.cuentas = new ArrayList();
    }
    
    public Cliente(){
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

}
