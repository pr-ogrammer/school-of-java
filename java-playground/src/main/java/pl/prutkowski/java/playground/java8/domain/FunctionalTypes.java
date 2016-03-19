/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author ruter
 */
public class FunctionalTypes {

    public static <T> Iterable<T> filter(Iterable<T> in, Predicate<T> pred) {
        List<T> out = new ArrayList<>();
        for (T elem : in) {
            if (pred.test(elem)) {
                out.add(elem);
            }
        }
        return out;
    }
    
    public static <T, R> Iterable<R> map(Iterable<T> in, Function<T, R> fun) {
        List<R> out = new ArrayList<>();
        for (T elem : in) {
            out.add(fun.apply(elem));
        }
        return out;
    }
}
