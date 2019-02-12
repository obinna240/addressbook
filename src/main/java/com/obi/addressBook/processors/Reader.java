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
	

}
