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
public interface Movable {

    String moveUp(int floor);

    String moveDown(int floor);

    String stop();
}
