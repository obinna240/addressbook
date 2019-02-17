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

	
	@Test
	public void returnsAddressBookContentSizeAs5() throws IOException, URISyntaxException {
		Reader testReader = new Reader("AddressBook");
		assertEquals(8, testReader.parseAddressBookContent().size());
	}
}
