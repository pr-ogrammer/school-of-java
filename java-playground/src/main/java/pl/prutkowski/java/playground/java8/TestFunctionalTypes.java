/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import pl.prutkowski.java.playground.java8.domain.FunctionalTypes;

/**
 *
 * @author ruter
 */
public class TestFunctionalTypes {
    
    static List<String> months = Arrays.asList(
        "styczeń", "luty",
        "marzec", "kwiecień",
        "maj", "czerwiec",
        "lipiec", "sierpień",
        "wrzesień", "październik",
        "listopad", "grudzień"
    );

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Iterable<String> monthsWithR = FunctionalTypes.filter(months, new Predicate<String>() {

            @Override
            public boolean test(String month) {
                return month.contains("r");
            }
        });
        System.out.println("All months:");
        System.out.println(months);
        System.out.println("---------------------------------");
        System.out.println("Months with 'r':");
        System.out.println(monthsWithR);
        System.out.println("---------------------------------");
        
        Iterable<Integer> monthLengths = FunctionalTypes.map(months, new Function<String, Integer>() {

            @Override
            public Integer apply(String month) {
                return month.length();
            }
        });
        System.out.println("Month lengths:");
        System.out.println(monthLengths);
        System.out.println("---------------------------------");
    }
    
}
