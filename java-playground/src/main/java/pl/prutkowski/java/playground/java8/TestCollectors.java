/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import pl.prutkowski.java.playground.java8.domain.ListCollector;

/**
 *
 * @author ruter
 */
public class TestCollectors {
    
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
        Map<String, Integer> monthByLen = months
            .stream()
            .collect(
                Collectors.toMap(
                    String::toUpperCase,
                    m -> StringUtils.countMatches(m, "e")
                )
            );        
        
        monthByLen.forEach(
            (month, eCount) -> System.out.println(month + " -> " + eCount)
        );
        
        System.out.println("---------------------------------");
        
        Map<Object, List<String>> monthByLen2 = months
            .stream()
            .collect(
                Collectors.groupingBy(
                    m -> StringUtils.countMatches(m, "e")
                )
            );
        
        monthByLen2.forEach(
            (count, groupedMonths) -> System.out.println(count + " -> " + groupedMonths)
        );
        
        System.out.println("---------------------------------");
        
        Double averageLength = months
            .stream()
            .collect(
                Collectors.averagingDouble(String::length)
            ).doubleValue();
        System.out.println("Average length: " + averageLength);
        System.out.println("---------------------------------");
        
        Double max = months
            .stream()
            .collect(Collectors.summarizingDouble(String::length))
            .getMax();
        System.out.println("Max length: " + max);
        System.out.println("---------------------------------");
        
        String reduced = months
            .stream()
            .collect(Collectors.reducing((m1, m2) -> (m1 + ", " + m2)))
            .get();
        System.out.println("Reduced: " + reduced);
        System.out.println("---------------------------------");
        System.out.println(String.join(", ", months));
        System.out.println("---------------------------------");
        
        List<String> monthsWithZ = months
            .stream()
            .filter(m -> m.contains("z"))
            .collect(new ListCollector<>());
        System.out.println(monthsWithZ);
        
    }
    
}
