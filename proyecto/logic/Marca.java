/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

/**
 *
 * @author jafet
 */
public final class Marca {
    String Codigo;
    String marca;
    Modelo descripcion;

    public Marca() {
    }

    public Marca(String Codigo, Modelo descripcion) {
        this.Codigo = Codigo;
        elegirMarca();
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    
    

     
    public String getMarca() {
        return marca;
    }

    public Modelo getDescripcion() {
        return descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(Modelo descripcion) {
        this.descripcion = descripcion;
    }
    public void elegirMarca(){
        if("1".equals(this.getCodigo())){
            marca="Toyota";
        }
        else{
         if("2".equals(this.getCodigo())){
             marca="Mitsubishi";
         }
         else{
             marca="ErrorDeMarca";
         }
        }
        
    }
    
}
