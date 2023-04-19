/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jafetvs.proyecto.logic;

/**
 *
 * @author vsj94
 */
public class Coberturas {
    
    
    
    Boolean damagePeople;
    Boolean damageBienes;
    Double gastosLegal;
    Boolean damageDirecto;
    Boolean damageAuto;
    Boolean robo;

    public Coberturas(Boolean damagePeople, Boolean damageBienes, Double gastosLegal, Boolean damageDirecto, Boolean damageAuto, Boolean robo) {
        this.damagePeople = damagePeople;
        this.damageBienes = damageBienes;
        this.gastosLegal = gastosLegal;
        this.damageDirecto = damageDirecto;
        this.damageAuto = damageAuto;
        this.robo = robo;
    }

    public Coberturas() {
    }

    public Boolean getDamagePeople() {
        return damagePeople;
    }

    public Boolean getDamageBienes() {
        return damageBienes;
    }

    public Double getGastosLegal() {
        return gastosLegal;
    }

    public Boolean getDamageDirecto() {
        return damageDirecto;
    }

    public Boolean getDamageAuto() {
        return damageAuto;
    }

    public Boolean getRobo() {
        return robo;
    }

    public void setDamagePeople(Boolean damagePeople) {
        this.damagePeople = damagePeople;
    }

    public void setDamageBienes(Boolean damageBienes) {
        this.damageBienes = damageBienes;
    }

    public void setGastosLegal(Double gastosLegal) {
        this.gastosLegal = gastosLegal;
    }

    public void setDamageDirecto(Boolean damageDirecto) {
        this.damageDirecto = damageDirecto;
    }

    public void setDamageAuto(Boolean damageAuto) {
        this.damageAuto = damageAuto;
    }

    public void setRobo(Boolean robo) {
        this.robo = robo;
    }
    
    
}
