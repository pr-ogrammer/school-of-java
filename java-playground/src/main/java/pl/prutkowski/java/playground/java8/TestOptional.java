/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pl.prutkowski.java.playground.java8.domain.Person;
import pl.prutkowski.java.playground.java8.domain.Sex;

/**
 *
 * @author ruter
 */
public class TestOptional {

	private static final List<Person> persons;

	static {
		persons = new ArrayList<>();
		persons.add(new Person(1, "Jack", Sex.MALE));
		persons.add(new Person(2, "Suzie", Sex.FEMALE));
		persons.add(new Person(3, "Tom", Sex.MALE));
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		TestOptional testOptional = new TestOptional();

		// Find Person
		System.out.println("findPerson(0): " + testOptional.findPerson(0));
		System.out.println("findPerson(2): " + testOptional.findPerson(2));

		System.out.println("findPersonOptional(0): " + testOptional.findPersonOptional(0));
		System.out.println("findPersonOptional(1): " + testOptional.findPersonOptional(1));

		System.out.println("--------------- TEST map & flatMap ---------------");
		Optional<String> s = Optional.of("input");
		System.out.println(s.map(TestOptional::getOutput));
		System.out.println(s.map(TestOptional::getOutputOpt));
		System.out.println(s.flatMap(TestOptional::getOutputOpt));
		System.out.println(Optional.<String>empty().map(TestOptional::getOutput));
		System.out.println("--------------- TEST map & flatMap ---------------");
		
		System.out.println(testOptional.lookupAddressById(1));
		System.out.println(testOptional.lookupAddressByIdOptional(1));
		
		System.out.println(testOptional.lookupAddressById(0));
		System.out.println(testOptional.lookupAddressByIdOptional(0));
}

	static Optional<String> getOutputOpt(String input) {
		return input == null ? Optional.empty() : Optional.of("output for " + input);
	}

	static String getOutput(String input) {
		return input == null ? null : "output for " + input;
	}

	public Person findPerson(int id) {
		return persons.stream()
			.filter(p -> p.getId() == id)
			.findFirst().orElse(null);
	}
	
	public Optional<Person> findPersonOptional(int id) {
		return persons.stream()
			.filter(p -> p.getId() == id)
			.findFirst();
	}

	public String lookupAddress(Person person) {
		Optional<String> a = persons.stream()
			.filter(p -> p.getId() == person.getId())
			.findFirst().flatMap(this::lookupAddressOptional);
		return persons.stream()
			.filter(p -> p.getId() == person.getId())
			.findFirst().map(p -> ("Address exists for person: " + p)).orElse(null);
	}
	
	public Optional<String> lookupAddressOptional(Person person) {
		return persons.stream()
			.filter(p -> p.getId() == person.getId())
			.findFirst().map(p -> ("Address exists for person: " + p));
	}

	public String lookupAddressById(int id) {
		final Person p = findPerson(id);
		if (p != null) {
			if (p.getSex() == Sex.MALE) {
				final String addr = lookupAddress(p);
				if (addr != null && !addr.isEmpty()) {
					return addr.trim();
				} else {
					return null;
				}
			}
		}
		return null;
	}
	
	public Optional<String> lookupAddressByIdOptional(int id) {
		return findPersonOptional(id)
			.filter(p -> p.getSex() == Sex.MALE)
			.flatMap(this::lookupAddressOptional)
			.filter(addr -> !addr.isEmpty())
			.map(String::trim);
	}
}
