/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatordemo;

import domain.Elevator;

/**
 *
 * @author alexa
 */
public class ElevatorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length != 1) {
            System.out.println("ERROR! Arguments not provided!\nUsage: java ElevatorTest <finalFloor>!");
            System.exit(0);
        }
        // initial balance and bank name
        int finalFloor = Integer.parseInt(args[0]);

        Elevator myElevator = new Elevator(finalFloor);
        System.out.println("Elevator is located on " + myElevator.getCurrentFloor() + ". Final floor is " + finalFloor);

        int targetFloor=15;
        
        System.out.println(myElevator.moveDown(-1));
        System.out.println(myElevator.moveUp(9));
        
        /*assert (targetFloor<=finalFloor):"Invalid floor number("+targetFloor+")";*/
        
        System.out.println(myElevator.moveUp(targetFloor));
        System.out.println(myElevator.moveDown(2));

    }

}
