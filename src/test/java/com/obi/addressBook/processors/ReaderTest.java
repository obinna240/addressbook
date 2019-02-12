package com.obi.addressBook.processors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;


/**
 * 
 * @author Dr Obinna Onyimadu
 *
 */
public class ReaderTest {
	
	@Test
	public void returnsEmptyListWhenItReadsEmptyAddressBook() throws IOException, URISyntaxException {
		Reader testReader = new Reader("EmptyAddressBook");
		assertTrue(testReader.parseAddressBookContent().isEmpty());
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
