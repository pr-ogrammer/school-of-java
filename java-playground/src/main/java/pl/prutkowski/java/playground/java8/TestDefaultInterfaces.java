/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import pl.prutkowski.java.playground.java8.domain.Boat;
import pl.prutkowski.java.playground.java8.domain.Car;

/**
 *
 * @author ruter
 */
public class TestDefaultInterfaces implements Car, Boat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestDefaultInterfaces defaultInterfaces = new TestDefaultInterfaces();
        defaultInterfaces.fuel();
    }

    @Override
    public void fuel() {
        Car.super.fuel();
        Boat.super.fuel();
        System.out.println("Override fuel method runs.");
    }
}
