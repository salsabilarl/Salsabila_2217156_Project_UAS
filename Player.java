/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ojolrush;

/**
 *
 * @author salsa
 */

public class Player extends OjolRush implements InterfaceDriver {
   
    // overloaded constructor 
    public Player() {
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
