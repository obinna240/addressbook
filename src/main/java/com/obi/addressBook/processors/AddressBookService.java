package com.obi.addressBook.processors;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

import com.obi.addressBook.model.Person;

/**
 * The address book service which provides methods for carrying out tasks on the addressbook
 * e.g gets a count of particular gender, calculates the difference in age between people of a 
 * particular age group, and gets the oldest person in the addressbook.
 * @author Dr Obinna Onyimadu
 *
 */
public final class AddressBookService {
	
	private final Reader reader;
	
	public AddressBookService(Reader reader) {
		this.reader = reader;
	}
	
	private List<Person> getPeopleInAddressBook() throws IOException, URISyntaxException {
		return reader.parseAddressBookContent();
	}
	
	/**
	 * 
	 * @param genderType
	 * @return A count of people in the address book that are either MALE or FEMALE
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public Integer getCountOfGenders(String genderType) throws IOException, URISyntaxException {
		Long genderCount = getPeopleInAddressBook()
			.stream()
			.filter(person -> person.getSex().equalsIgnoreCase(genderType))
			.count();
		return genderCount.intValue();
	}
	
	/**
	 * 
	 * @return The oldest person or persons in the addressbook 
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<Person> getEldestPersons() throws IOException, URISyntaxException{
		
		List<Person> oldestPerson = getPeopleInAddressBook()
			.stream()
			.sorted(Comparator.comparing(Person::getLocalDate))
			.collect(Collectors.toList());
		
		Person firstPerson = oldestPerson.get(0);
		
		oldestPerson = oldestPerson.stream()
			.filter(person -> person.getLocalDate().isEqual(firstPerson.getLocalDate()))
			.collect(Collectors.toList());

		return oldestPerson;
	}
	
	/**
	 * Calculate the difference in age between people based on their firstnames
	 * @param nameOfirstPerson
	 * @param nameOfSecondPerson
	 * @return the difference between the ages of people in the addressbook
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public long getAgeDifference(final String nameOfirstPerson, final String nameOfSecondPerson) throws IOException, URISyntaxException {
		List<LocalDate> dates = 
		getPeopleInAddressBook()
			.stream()
			.filter(person -> person.getName().startsWith(nameOfirstPerson) | person.getName().startsWith(nameOfSecondPerson))
			.sorted(Comparator.comparing(Person::getLocalDate))
			.map(person -> person.getLocalDate())
			.collect(Collectors.toList());
		
		return ChronoUnit.DAYS.between(dates.get(0), dates.get(1));
	}
	
}
