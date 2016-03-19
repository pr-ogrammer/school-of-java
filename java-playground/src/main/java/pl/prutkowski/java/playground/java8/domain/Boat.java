/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8.domain;

/**
 *
 * @author ruter
 */
public interface Boat {

    default void fuel() {
        System.out.println(Boat.class.getSimpleName() + ".fuel() method runs.");
    }
}
