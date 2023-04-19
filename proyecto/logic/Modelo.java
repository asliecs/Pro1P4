/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

/**
 *
 * @author jafet
 */
public class Modelo {
    String modelo;
    String imagen;

    public Modelo() {
    }

    public Modelo(String modelo, String imagen) {
        this.modelo = modelo;
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
