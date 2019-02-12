package com.obi.addressBook.processors;

import static org.junit.Assert.assertTrue;

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
	public void returnsEmptyListWhenItReadsNonExistentAddressBook() throws IOException, URISyntaxException {
		//reader parses the address book
		//reader returns list
		//we assert
		Reader testReader = new Reader("NonExistentAddressBook");
		assertTrue(testReader.parseAddressBookContent().isEmpty());
	}
}
