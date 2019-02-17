# addressbook

## Introduction
The addressbookreader in this application reads a file containing a comma separated list of addresses in the format 'name, sex, dob'

The solutions to the problem can be run from the main application class in ```com.obi.addressBook.App.java```.

## Design
### Models 
The application was designed in such a way that we modeled the content of the addressbook as Persons featuring the main elements name, sex and dob. This is modelled in the Person class.

### Processors
A ```com.obi.addressBook.processors.Reader``` class reads the addressbook into a list of persons.

The ```com.obi.addressBook.processors.AddressBookService``` class uses the reader to solve problems like finding the oldest people, finding the difference in age and also identifying people of a particular sex.

### Solutions
- Problem 1: How many males are in the address book?
  We assume that a user can specify the sex as a string regardless of case. Alternatively, we could model the gender as an ENUM to be passed into ```getCountOfGenders(String genderType)``` method. We return an integer value.

- Problem 2: Who is the oldest person in the address book?
  We assume that the addressbook could have more than one person. To this end, the method, ```getEldestPersons()``` returns a list of Persons. In the main application class, we simply print out the names of the persons from the list.

- Problem 3: How many days older is Bill than Paul?
  In this case, we assume that a user uses just the first names to make this check. In a real world scenario, we will pass the Person object, however for simplicity we simply passed their first names. The method returns the age difference in days. in the case of Bill and Paul it is 2862. you can run this in ```App.java```.


### Building App
The solution was implemented using Java 8 and Maven (Dependency management). Please note that no external libraries like Apache Commons or Guava were used. This was a decision made on purpose. In production these external libraries would be the preferred choice to make some of the processes like string manipulations easier.

The main application with all the solutions can be run and found in ```com.obi.addressBook.App.java```
To run this using maven, do:
```
mvn exec:java -D "exec.mainClass"="com.obi.addressBook.App"
```

### Test coverage
Test coverage includes tests for the classes in the ```com.obi.addressBook.processors``` package. We provide tests for ```AddressBookService``` and ```Reader```. All tests can be run by simply doing: 
```
mvn clean test

```

 