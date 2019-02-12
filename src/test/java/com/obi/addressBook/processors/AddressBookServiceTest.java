package com.obi.addressBook.processors;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
	public void returns5ForCountOfFemalesInAddressBook() {
		//create helper class to read addresses
		//run method to count femmales
		//perform assertion
	}
	
	@Test
	public void returns0ForCountOfMalesWhenAddressBookIsEmpty() {
		//create helper class to read addresses from addressbook
		//run method to count males
		//perform assertion
	}
	
	@Test
	public void returnsAListContainingTheOldestPeopleInAddressBook() {
		//create helper class to read addresses from addressbook
		//run method to count males
		//perform assertion
	}
	
	@Test
	public void returns0ForAgeDifferenceWherePersonAandBHaveSameDOB() {
		//create helper class to read addresses from addressbook
		//run method to count males
		//perform assertion
	}

}
