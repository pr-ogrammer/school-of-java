/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.se;

/**
 *
 * @author ruter
 */
public class ConverterApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("10 binary: " + toBinaryString(10) + " | " + Integer.toBinaryString(10));
		System.out.println("5 binary: " + toBinaryString(5) + " | " + Integer.toBinaryString(5));
	}
	
	public static String toBinaryString(int i) {
		StringBuilder binary = new StringBuilder();
		while (i > 0) {
			binary.append(i % 2);
			i = i / 2;
		}		
		return binary.toString();
	}
	
}
