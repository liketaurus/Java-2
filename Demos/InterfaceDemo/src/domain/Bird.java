/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.*;

/**
 *
 * @author alexa
 */
public class Bird extends Pet implements Flyer, Animal {

    @Override
    public void LayOff() {
        System.out.println("Bird lay off!");
    }

    @Override
    public void landing() {
        System.out.println("Bird is landing!");
    }

    @Override
    public void fly() {
        System.out.println("Bird flying!");
    }

    @Override
    public void eat() {
        System.out.println("Birds eat worms!");
    }

    @Override
    public void play() {
        System.out.println("I playing with my bird!");
    }

}
