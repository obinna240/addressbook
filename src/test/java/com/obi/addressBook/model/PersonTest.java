package com.obi.addressBook.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person person;
	@Before
	public void setUp() throws Exception {
		String name = "test";
		String sex = "male";
		LocalDate date = LocalDate.now();
		person = new Person(name, sex, date);
	}

	@Test
	public void testGetSex() {
		assertEquals("Sex is correct", "male", person.getSex());
	}

	@Test
	public void testGetName() {
		assertEquals("Name is correct", "test", person.getName());
	}
	
	@Test
	public void testGetLocalDate() {
		assertEquals("Date is correct", LocalDate.now(), person.getLocalDate());
	}

}
