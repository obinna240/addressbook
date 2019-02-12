package com.obi.addressBook;

import java.io.IOException;
import java.net.URISyntaxException;

import com.obi.addressBook.processors.AddressBookService;
import com.obi.addressBook.processors.Reader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException, URISyntaxException {
    	Reader reader = new Reader("AddressBook");
    	AddressBookService addressBookService = new AddressBookService(reader );
    	
    	//solution to question 1: How many males are in the address book
    	System.out.println("==Getting total number of males == ");
    	System.out.println(addressBookService.getCountOfGenders("male"));
    	
    	//solution to question 2: Who is the oldest person in the address book?
    	System.out.println("== Printing oldest people == ");
    	addressBookService
    			.getEldestPersons()
    			.stream()
    			.forEach(person -> System.out.println(person.getName()));
    	System.out.println("== Finished Printing oldest people == ");
    	
    	//solution to question 3: How many days older is Bill than Paul??
    	System.out.println("==Getting age difference between Bill and Paul == ");
    	System.out.println(addressBookService.getAgeDifference("Bill", "Paul"));

    }
}
