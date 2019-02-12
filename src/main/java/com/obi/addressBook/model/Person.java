package com.obi.addressBook.model;

import java.time.LocalDate;

/**
 * 
 * @author Dr Obinna Onyimadu
 *
 */
public final class Person {

	private final String sex;
	private final String name;
	private final LocalDate localDate;
	
	public Person(String name, String sex, LocalDate localDate) {
		this.name = name;
		this.sex = sex;
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

}
