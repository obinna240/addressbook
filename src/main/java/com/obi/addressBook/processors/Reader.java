package com.obi.addressBook.processors;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.obi.addressBook.interfaces.AddressBookReader;
import com.obi.addressBook.model.*;
import com.obi.addressBook.util.Utils;

/**
 * This class reads the address book and returns its content
 * @author Dr Obinna Onyimadu
 *
 */
public final class Reader {
	private final String addressBookFile;
	// private AddressBookReader addressBookReader;
	
	public Reader(String addressBookFile) {
		this.addressBookFile = addressBookFile;
		
		
	}
	
	public String getAddressBookFile() {
		return addressBookFile;
	}
//	
//	public AddressBookReader getAdressBookReader() {
//		return addressBookReader;
//	}
	
	/**
	 * This method parses the addressbook and returns its content as a List of Persons
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<Person> parseAddressBookContent() throws IOException, URISyntaxException{
		final List<String> addressBookContent = new ArrayList<String>();
		try (Stream<String> bookLines = Files.lines(Paths
				.get(getClass()
						.getClassLoader()
						.getResource(addressBookFile)
						.toURI()))){
			bookLines.forEachOrdered(addressBookContent::add);
		}
		return addressBookContent.stream()
				.filter(line -> line != null && line.length() > 0)
				.map(line -> line.split(","))
				.map(line -> new Person(line[0].trim(), line[1].trim(), LocalDate.parse(line[2].trim(), Utils.formatInputDates())))
				.collect(Collectors.toList());
	}

}
