/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import java.net.Socket;
import static pl.prutkowski.java.playground.java8.domain.FunctionalTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import pl.prutkowski.java.playground.java8.domain.MyStringHandler;

/**
 *
 * @author ruter
 */
public class TestLambda {
    
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
        Predicate<String> predicate = (String month) -> month.contains("r");
        Iterable<String> monthsWithR = filter(months, predicate);
        System.out.println(monthsWithR);
        
        monthsWithR = filter(months, (String month) -> month.contains("r"));
        System.out.println(monthsWithR);
        
        monthsWithR = filter(months, m -> {
            String needle = "r";
            return m.contains(needle);
        });
        System.out.println(monthsWithR);
        
        monthsWithR = filter(months, m -> m.contains("r"));
        System.out.println(monthsWithR);
        
        System.out.println(map(months, month -> month.length()));
        System.out.println(map(months, String::length));
        
        List<String> primes = Arrays.asList("2", "3", "5");
        System.out.println(map(primes, Integer::parseInt));
        System.out.println(map(primes, p -> new Integer(p)));        
        System.out.println(map(primes, Integer::new));
        
        TestLambda testLambda = new TestLambda();
        System.out.println(testLambda.parseNums(primes));
        
        BiFunction<String, Integer, Boolean> fun = (String s, Integer x) -> {
            return s.length() > x;
        };        
        System.out.println(filter(months, m -> fun.apply(m, 5)));
        
        BiFunction<String, Integer, Boolean> fun2 = (s, x) -> s.length() > x;
        System.out.println(filter(months, m -> fun2.apply(m, 7)));
        
        MyStringHandler handler = (String str) -> {
            System.out.println("Connect: " + str);
        };
        handler.handle("www.test.com");
    }
    
    Iterable<Integer> parseNums(List<String> inputs) {
        return map(inputs, this::parseStr);
    }
    
    Integer parseStr(String s) {
        return Integer.parseInt(s);
    }
}
