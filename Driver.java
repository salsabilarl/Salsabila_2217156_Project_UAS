/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ojolrush;

/**
 *
 * @author salsa
 */

public class Driver extends OjolRush implements InterfaceDriver {
   
    // overloaded constructor 
    public Driver() {
        ratingDriver = 1;
        motorDriver = "Supra X";
    }
    public void mulai() {
        mulaiDriver();
    }
    public void detail(){
        setDriver();
    }
}
