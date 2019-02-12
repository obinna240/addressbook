package com.obi.addressBook.processors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
	
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
	
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
}
