/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacedemo;

import domain.Bird;
import domain.Pet;
import interfaces.Animal;
import interfaces.Flyer;

/**
 *
 * @author alexa
 */
public class InterfaceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bird myBird = new Bird();
        myBird.LayOff();
        myBird.eat();
        myBird.play();
        myBird.sleep();

        Animal myAnimal = myBird;
        myAnimal.eat();
        
//        System.out.println(myAnimal instanceof Animal);
//        System.out.println(myAnimal instanceof Flyer);

        Pet p = myBird;
        p.sleep();
        
    }

}
