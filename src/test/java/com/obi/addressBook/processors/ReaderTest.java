package com.obi.addressBook.processors;

import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * 
 * @author Dr Obinna Onyimadu
 *
 */
public class ReaderTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test(expected = NoSuchElementException.class) 
	public void returnsExceptionWithMessageNoValuePresent() throws IOException, URISyntaxException {
		Reader testReader = new Reader("EmptyAddressBook");
		testReader.parseAddressBookContent();
	}
	
	@Test(expected = NoSuchElementException.class) 
	public void throwsNoSuchElementExceptionForNonExistentAddressBook() throws IOException, URISyntaxException {
		Reader testReader = new Reader("NonExistentBook");
		testReader.parseAddressBookContent();
	}
	
	@Test
	public void returnsAddressBookContentSizeAs5() throws IOException, URISyntaxException {
		Reader testReader = new Reader("AddressBook");
		assertEquals(5, testReader.parseAddressBookContent().size());
	}
}
