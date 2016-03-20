/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import pl.prutkowski.java.playground.java8.domain.Product;

/**
 *
 * @author ruter
 */
public class TestSorted {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Product 1", new BigDecimal(29.99)),
            new Product("Product 2", new BigDecimal(19.99)),
            new Product("Product 3", new BigDecimal(129.99)),
            new Product("Product 4", new BigDecimal(9.99))
        );
        
        List<Product> sortedProducts = products
            .stream()
            .sorted(
                Comparator
                    .comparing(Product::getPrice)
                    .thenComparing(Product::getName)
            )
            .collect(Collectors.toList());
        
        sortedProducts.forEach(p -> System.out.println("Name: " + p.getName() + " | Price: " + p.getPrice().setScale(2, RoundingMode.HALF_UP) ));
    }
    
}
