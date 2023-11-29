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
public class OverDraftException extends Exception {

    private double deficit;

    public OverDraftException(double deficit, String message) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }

}
