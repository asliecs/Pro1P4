/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

/**
 *
 * @author jafet
 */
public class Fecha {
    String anno;
    String mes;
    String dia;

    public Fecha() {
    }
    
    public Fecha(String anno, String mes, String dia) {
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
    }

    public String getAnno() {
        return anno;
    }

    public String getMes() {
        return mes;
    }

    public String getDia() {
        return dia;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

}
