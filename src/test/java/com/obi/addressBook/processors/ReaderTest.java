package com.obi.addressBook.processors;

import static org.junit.Assert.assertFalse;
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
	public void returnsEmptyListWhenItReadsEmptyAddressBook() throws IOException, URISyntaxException {
		Reader testReader = new Reader("EmptyAddressBook");
		assertTrue(testReader.parseAddressBookContent().isEmpty());
	}
}
