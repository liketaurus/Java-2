/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author alexa
 */
public abstract class Pet {
    
    public abstract void play();
    
    public void sleep(){
        System.out.println("Pet is sleeping!");
    }
    
}
