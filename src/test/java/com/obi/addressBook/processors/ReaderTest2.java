package com.obi.addressBook.processors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.DynamicAny.DynAnySeqHelper;

import com.obi.addressBook.model.Person;

public class ReaderTest2 {
	
	private String adbook;
	private List<Person> personList;
	private Reader reader;
	
	@Before
	public void setUp() throws Exception {
		adbook = "addressBook";
		Person p1 = new Person("jane", "female", LocalDate.of(1947, Month.APRIL, 12));
		Person p2 = new Person("jon", "male", LocalDate.of(2000, Month.JANUARY, 11));
		Person p3 = new Person("jack", "male", LocalDate.of(1982, Month.SEPTEMBER, 22));
		Person p4 = new Person("june", "female", LocalDate.of(1954, Month.MAY, 01));
		Person[] allPersons = {p1, p2, p3, p4};
		personList = Arrays.asList(allPersons);
		reader = new Reader(adbook);
	}

	

}
