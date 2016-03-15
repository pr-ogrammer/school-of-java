/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author ruter
 */
public class FilteringApples {
    public static void main(String[] args) {
        
        List<Apple> inventory = Arrays.asList(
            new Apple(80,"green"), 
            new Apple(155, "green"),
            new Apple(120, "red")
        );
        
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
        
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);
        
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);
        
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);     
        
        System.out.println(inventory.stream().filter(a -> a.getWeight() > 150).collect(Collectors.toList()));
    }
    
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }
        return greenApples;
    }
    
    public static List<Apple> filterHeavyApples(List<Apple> apples) {
        List<Apple> heavyApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > 150) {
                heavyApples.add(apple);
            }
        }
        return heavyApples;
    }
    
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    
    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }                                 
    
    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }
}
