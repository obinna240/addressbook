package com.obi.addressBook.processors;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.obi.addressBook.model.*;
import com.obi.addressBook.util.Utils;

/**
 * This class reads the address book and returns its content
 * @author Dr Obinna Onyimadu
 *
 */
public final class Reader {
	private final String addressBookFile;
	
	public Reader(String addressBookFile) {
		this.addressBookFile = addressBookFile;
		
		
	}
	
	public String getAddressBookFile() {
		return addressBookFile;
	}

	/**
	 * This method parses the addressbook and returns its content as a List of Persons
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<Person> parseAddressBookContent2() throws IOException, URISyntaxException{
		final List<String> addressBookContent = new ArrayList<String>();
		
		Optional<URL> url = Optional
				.ofNullable(
						getClass()
							.getClassLoader()
							.getResource(addressBookFile));
		

		try (Stream<String> bookLines = Files.lines(Paths
				.get(url.get()
						.toURI()))
				.filter(line -> !line.isEmpty())){
			bookLines.forEachOrdered(addressBookContent::add);
		}
		
		return addressBookContent.stream()
				.filter(line -> line != null && line.length() > 0)
				.map(line -> line.split(","))
				.map(line -> new Person(line[0].trim(), line[1].trim(), LocalDate.parse(line[2].trim(), Utils.formatInputDates())))
				.collect(Collectors.toList());
	}
	
	public List<Person> parseAddressBookContent() throws URISyntaxException, IOException {
		final List<String> addressBookContent = new ArrayList<String>();
		
		Optional<URL> url = Optional
				.ofNullable(
						getClass()
							.getClassLoader()
							.getResource(addressBookFile));
		
		URL urls = url.get();
		
		Path path = Paths.get(urls.toURI());
		AsynchronousFileChannel f = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
		
		//this method takes the ByteBuffer as the first parameter.
		//the data read from the asynchronous file channel is read into a bytebuffer, and the 
		//second parameter is the byte position in the file to start reading from
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;
		Future<Integer> operation = f.read(buffer, position); //one way
		
		//another way will be to use the CompletionHandler
		f.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
		    @Override
		    public void completed(Integer result, ByteBuffer attachment) {
		        System.out.println("result = " + result);

		        attachment.flip();
		        byte[] data = new byte[attachment.limit()];
		        attachment.get(data);
		        System.out.println(new String(data));
		        attachment.clear();
		    }

		    @Override
		    public void failed(Throwable exc, ByteBuffer attachment) {

		    }
		});
		

		try (Stream<String> bookLines = Files.lines(Paths
				.get(url.get()
						.toURI()))
				.filter(line -> !line.isEmpty())){
			bookLines.forEachOrdered(addressBookContent::add);
		}
		
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		System.out.println("printing ciontent");
		
		return addressBookContent.stream()
				.filter(line -> line != null && line.length() > 0)
				.map(line -> line.split(","))
				.map(line -> new Person(line[0].trim(), line[1].trim(), LocalDate.parse(line[2].trim(), Utils.formatInputDates())))
				.collect(Collectors.toList());
	}


}
