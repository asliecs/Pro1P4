/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jafetvs.proyecto.presentation.cliente.poliza;

import jafetvs.proyecto.logic.Poliza;



/**
 *
 * @author Escinf
 */
public class Model{
    Poliza current;

    public Model() {
        current = new Poliza("",null,0.0,null);
    }

    public Poliza getCurrent() {
        return current;
    }

    public void setCurrent(Poliza current) {
        this.current = current;
    }

}
