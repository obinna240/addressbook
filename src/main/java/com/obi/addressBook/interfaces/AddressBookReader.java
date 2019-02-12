package com.obi.addressBook.interfaces;

import java.util.List;
import java.util.function.Function;

import com.obi.addressBook.model.Person;

@FunctionalInterface
public interface AddressBookReader {
	List<Person> read(String addressBook);
}
