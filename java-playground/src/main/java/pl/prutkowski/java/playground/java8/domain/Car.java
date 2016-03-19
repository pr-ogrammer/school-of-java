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
public interface Car {

    default void fuel() {
        System.out.println(Car.class.getSimpleName() + ".fuel() method runs.");
    }
}
