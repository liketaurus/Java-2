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
public class Elevator implements Movable {

    private final int finalFloor;
    private int currentFloor = 0;

    private boolean movingUp = false;
    private boolean movingDown = false;

    public Elevator() {
        this.finalFloor = 3;
    }

    public Elevator(int finalFloor) {

        this.finalFloor = finalFloor;
    }

    @Override
    public String moveUp(int floor) {
        if (floor > currentFloor && floor < finalFloor) {
            movingUp = true;
            while (currentFloor < floor) {
                currentFloor++;
                System.out.print("\t" + currentFloor);
            }
            return "\n"+stop();
        }
        return "Invalid floor number (" + floor + "). Elevator stays on floor " + currentFloor;
    }

    @Override
    public String moveDown(int floor) {
        if (floor < currentFloor && floor >= -1) {
            movingDown = true;
            while (currentFloor > floor) {
                currentFloor--;
                System.out.print("\t" + currentFloor);
            }
            return "\n"+stop();
        }
        return "Invalid floor number (" + floor + "). Elevator stays on floor " + currentFloor;
    }

    @Override
    public String stop() {
        movingDown = false;
        movingUp = false;
        return "Elevator stops on floor " + currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

}
