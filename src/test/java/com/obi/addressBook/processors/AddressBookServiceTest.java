package com.obi.addressBook.processors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;



public class AddressBookServiceTest {

	@Test
	public void returns4ForCountOfMalesInAddressBook() throws IOException, URISyntaxException {
		Reader reader = new Reader("AddressBook");
		AddressBookService addressBookService = new AddressBookService(reader);
		assertEquals(new Long(4), new Long(addressBookService.getCountOfGenders("male")));

	}
	
	@Test
	public void returns6ForCountOfMalesInAddressBookWhereGenderIsUppercase() throws IOException, URISyntaxException {
		Reader reader = new Reader("AddressBook");
		AddressBookService addressBookService = new AddressBookService(reader);
		assertEquals(new Long(4), new Long(addressBookService.getCountOfGenders("MALE")));
	}
	
	@Test
	public void returns4ForCountOfFemalesInAddressBook() throws IOException, URISyntaxException {
		Reader reader = new Reader("AddressBook");
		AddressBookService addressBookService = new AddressBookService(reader);
		assertEquals(new Long(4), new Long(addressBookService.getCountOfGenders("female")));
	}
	
	
	@Test
	public void returnsAListContainingTheNamesOfOldestPeopleInAddressBook() throws IOException, URISyntaxException {
		List<String> expected = Arrays.asList("Wes Jackson", "Jim Jacksons");

		Reader reader = new Reader("AddressBook");
		AddressBookService addressBookService = new AddressBookService(reader);
		assertEquals(addressBookService
			.getEldestPersons()
			.stream()
			.map(person -> person.getName())
			.collect(Collectors.toList()), expected);

	}
	
	@Test
	public void returns0ForAgeDifferenceWherePersonAandBHaveSameDOB() {
		//create helper class to read addresses from addressbook
		//run method to count males
		//perform assertion
	}

}
