package com.obi.addressBook.model;

import java.time.LocalDate;

/**
 * By making the class final it is thread safe
 * It is also immutable which means its state cannot be changed
 * To this end we have no setter methods
 * Initialize at the constructor level
 * Our fields are also private and final so that they are instantiated once
 * The use of immutable objects makes the code thread safe because it si final
 * Hence in a multi threaded distributed environment, a new thread will simply
 * create an instance of an object instead of a previous one
 * State modification will result in a new instance
 * @author Dr Obinna Onyimadu
 *
 */
public final class Person {

	private final String sex;
	private final String name;
	private final LocalDate localDate; //this class is immutable
	
	/**
	 * 
	 * @param name
	 * @param sex
	 * @param localDate
	 */
	public Person(String name, String sex, LocalDate localDate) {
		this.name = name;
		this.sex = sex;
		//Localdate makes sense as it is not tied to timezones
		//it is simply a description of a point in time
		this.localDate = localDate;
	}
	
	public String getSex() {
		return sex;
	}

	public String getName() {
		return name;
	}


	public LocalDate getLocalDate() {
		return localDate;
	}
	
//	public Person modifySex(Person person, final String sex) {
//		person = new Person(person.getName(), sex, person.getLocalDate());
//		return person;
//	}

}
