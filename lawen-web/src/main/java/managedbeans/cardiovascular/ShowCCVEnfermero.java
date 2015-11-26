/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.cardiovascular;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author daniel
 */
@Named(value = "showCCVEnfermero")
@RequestScoped
public class ShowCCVEnfermero {

    /**
     * Creates a new instance of ShowCCVEnfermero
     */
    CCVEnfermeroController cart;
    CCVEnfermeroController show;

    public CCVEnfermeroController getCart() {
        return cart;
    }

    public void setCart(CCVEnfermeroController cart) {
        this.cart = cart;
    }

    public CCVEnfermeroController getShow() {
        return show;
    }

    public void setShow(CCVEnfermeroController show) {
        this.show = show;
    }
    
    
    public ShowCCVEnfermero() {
    }
    
}
