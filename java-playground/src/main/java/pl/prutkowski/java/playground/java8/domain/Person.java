/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prutkowski.java.playground.java8.domain;

/**
 *
 * @author ruter
 */
public class Person {
	
	private int id;
	private String name;
	private Sex sex;

	public Person() {
		this(0, "default", Sex.MALE);
	}	

	public Person(int id, String name, Sex sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}	

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", name=" + name + ", sex=" + sex + '}';
	}
	
}
