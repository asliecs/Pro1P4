/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jafetvs.proyecto.presentation.cliente.cuenta;

import jafetvs.proyecto.logic.Cuenta;



/**
 *
 * @author Escinf
 */
public class Model{
    Cuenta current;

    public Model() {
        current = new Cuenta("",0.0,null);
    }

    public Cuenta getCurrent() {
        return current;
    }

    public void setCurrent(Cuenta current) {
        this.current = current;
    }

}
