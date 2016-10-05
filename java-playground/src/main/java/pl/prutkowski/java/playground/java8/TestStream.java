/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static pl.prutkowski.java.playground.java8.TestFunctionalTypes.months;

/**
 *
 * @author ruter
 */
public class TestStream {
    
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
        String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
        List<String> filteredNames = IntStream.range(0, names.length)
                .filter(i -> (i+1) % 2 != 0)
                .mapToObj(i -> names[i])
                .collect(Collectors.toList());

        System.out.println("Filtered names 1:");
        System.out.println(filteredNames);
        System.out.println("---------------------------------");

        AtomicInteger index = new AtomicInteger();
        filteredNames = Arrays.stream(names)
                .filter(n -> {
                    boolean result = index.incrementAndGet() % 2 != 0;
                    return result;
                })
                .collect(Collectors.toList());

        System.out.println("Filtered names 2:");
        System.out.println(filteredNames);
        System.out.println("---------------------------------");


        System.out.println("All months:");
        System.out.println(months);
        System.out.println("---------------------------------");
        
        List<String> monthsWithR = months.stream()
            .filter(month -> month.contains("r"))
            .collect(Collectors.toList());
        System.out.println("Months with 'r':");
        System.out.println(monthsWithR);
        System.out.println("---------------------------------");
        
        List<Integer> monthLengths = months.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Month lengths:");
        System.out.println(monthLengths);
        System.out.println("---------------------------------"); 
        
        monthLengths = months.stream()
            .filter(month -> month.contains("r"))
            .map(String::length)
            .distinct()
            .limit(2)
            .collect(Collectors.toList());
        System.out.println("Month lengths distinct with limit:");
        System.out.println(monthLengths);
        System.out.println("---------------------------------");
        
        Set<Character> chars = IntStream
            .rangeClosed((int) 'a', (int) 'z')
            .mapToObj(ascii -> (char) ascii)
            .filter(ch -> months.stream().noneMatch(
                m -> m.indexOf(ch) > 0
            ))            
            .collect(Collectors.toSet());
        System.out.println("Non match characters:");
        System.out.println(chars);
        System.out.println("---------------------------------");
        
        System.out.println("All months foreach:");
        months.stream().forEach(m -> System.out.println(m));
        System.out.println("---------------------------------");
        
        System.out.println("All months foreach:");
        months.stream().forEach(System.out::println);
        System.out.println("---------------------------------");
        
        System.out.println("All months foreach:");
        months.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        try {
            Stream<String> s = months.stream()
                .filter(m -> m.contains("r"));
            
            System.out.println("Months with 'r':");
            s.forEach(System.out::println);
            System.out.println("---------------------------------");
            s.collect(Collectors.toList()); // Exception
        } catch (IllegalStateException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("---------------------------------");
        }
        
        monthLengths = months.parallelStream()
            .filter(month -> month.contains("r"))
            .map(String::length)
            .distinct()
            .limit(2)
            .collect(Collectors.toList());
        System.out.println("Month lengths distinct with limit (parallel):");
        System.out.println(monthLengths);
        System.out.println("---------------------------------");
    }
    
}
