package com.chainsys.book.test;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookClient {
	public static void main(String[] args) {
		
		Book book = new Book();
		BookService service= new BookServiceImpl();
		Set<Book> bookSet;
		List<Integer> bookId;
		List<String> bookName;
		Scanner scan = new Scanner(System.in);
		int menuchoice;
		int choice;
		int colchoice;
		int book_id;
		String book_name;
		String publish_date;
		DateTimeFormatter dateFormat;
		System.out.println("1. View details");
		System.out.println("2. Add a book");
		System.out.println("3. Search a book");
		System.out.println("4. Delete a book");
		System.out.println("5. Update a  book");
		System.out.println("6.View all Product Name");
		System.out.println("7.View all Product Id");
		while(true) {
			System.out.println("Enter the Choice");
			menuchoice = scan.nextInt();
			switch(menuchoice) {
				case 1:
					bookSet = service.viewDetail();
					System.out.println(bookSet);
					break;
				case 2:
					System.out.println("Enter Book Id:");
					book_id = scan.nextInt();
					System.out.println("Enter Book name");
					book_name = scan.next();
					System.out.println("Enter publish date");
					publish_date = scan.next();
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					try {
					book = new Book(book_id,book_name,LocalDate.parse(publish_date, dateFormat));
					service.insertData(book);
					bookSet = service.viewDetail();
					System.out.println(bookSet);
					}
					catch(Exception e) {
						System.out.println(e);
					}
					break;
					
					
				case 3:
					System.out.println("Select choice for searching a book");
					System.out.println("1.Search by Id");
					System.out.println("2.Search by name");
					System.out.println("3.Search by publish date");
					choice = scan.nextInt();
					if(choice == 1) {
						System.out.println("Enter the id");
						book_id = scan.nextInt();
						try{
							book = service.searchById(book_id);
							System.out.println(book);
						}catch(BookNotFoundException e){	
						}
					}else if(choice == 2) {
						System.out.println("Enter the name");
						book_name = scan.next();
						try {
							book = service.searchByName(book_name);
							System.out.println(book);
						}catch(BookNotFoundException e) {
						}
					}
					else if(choice == 3) {
						System.out.println("Enter the Publish Date :");
						publish_date = scan.next();
						dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						try {
							book = service.searchByDate(LocalDate.parse(publish_date,dateFormat));
							System.out.println(book);
							}
							catch(BookNotFoundException e) {
								
							}
					}
					else {
						System.out.println("Search function cannot be performed");
					}
					break;
				
				case 4:
					System.out.println("Select choice for delete:");
					System.out.println("1. Delete book by ID");
					System.out.println("2. Delete book by name");
					System.out.println("3. Delete book by publishdate");
					choice = scan.nextInt();
					if(choice == 1) {
						System.out.println("Enter the id");
						book_id = scan.nextInt();
						try{
							service.deleteById(book_id);
							bookSet = service.viewDetail();
							System.out.println(bookSet);
						}catch(BookNotFoundException e){	
						}
					}
					else if(choice == 2) {
						System.out.println("Enter the name");
						book_name = scan.next();
						try{
							service.deleteByName(book_name);
							bookSet = service.viewDetail();
							System.out.println(bookSet);
						}catch(BookNotFoundException e){	
						}
					}
					else if(choice == 3) {
						System.out.println("Enter the publish date");
						publish_date = scan.next();
						dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						try{
							service.deleteByDate(LocalDate.parse(publish_date,dateFormat));
							bookSet = service.viewDetail();
							System.out.println(bookSet);
						}catch(BookNotFoundException e){	
						}
					}
					else {
						System.out.println("Invalid choice! Can't Delete book");
					}
					break;
				case 5:
					System.out.println("Select Choice for update book:");
					System.out.println("1. Update book by ID");
					System.out.println("2. Update book by Name");
					System.out.println("3. Update book by Publish Date");
					choice = scan.nextInt();
					//To update Book by Book_id
					if(choice == 1) {
						System.out.println("Enter the Id :");
						book_id = scan.nextInt();
						System.out.println("What to update :");
						System.out.println("1. Name");
						System.out.println("2. Date");
						colchoice = scan.nextInt();
						//To update Book_name by Book_id
						if(colchoice == 1) {
							System.out.println("Enter the name :");
							book_name = scan.next();
							try {
							Book updbook = service.searchById(book_id);
							book = new Book(book_id,book_name,updbook.getPublishdate());
							service.updateByIdName(book);
							bookSet = service.viewDetail();
							System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						//To update publishDate by Book_id
						else if(colchoice == 2) {
							System.out.println("Enter the Publish Date");
							publish_date = scan.next();
							dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							try {
							Book updbook = service.searchById(book_id);
							book = new Book(book_id,updbook.getName(),LocalDate.parse(publish_date,dateFormat));
							service.updateByIdDate(book);
							bookSet = service.viewDetail();
							System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						else {
							System.out.println("Invalid choice!!! Select 1 or 2");
						}	
					}
					//To update Book by Book_name
					else if(choice == 2) {
						System.out.println("Enter the name :");
						book_name = scan.next();
						System.out.println("What to update :");
						System.out.println("1. Id");
						System.out.println("2. Date");
						colchoice = scan.nextInt();
						//To update Book_id by Book_name
						if(colchoice == 1) {
							System.out.println("Enter the ID :");
							book_id = scan.nextInt();
							try {
							Book updbook = service.searchByName(book_name);
							book = new Book(book_id,book_name,updbook.getPublishdate());
							service.updateByNameId(book);
							bookSet = service.viewDetail();
							System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						//To update publishDate by Book_name
						else if(colchoice == 2) {
							System.out.println("Enter the Publish Date :");
							publish_date = scan.next();
							dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							try {
								Book updbook = service.searchByName(book_name);
								book = new Book(updbook.getId(),book_name,LocalDate.parse(publish_date,dateFormat));
								service.updateByNameDate(book);
								bookSet = service.viewDetail();
								System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						else {
							System.out.println("Invalid choice!!! Select 1 or 2");
						}
					}
					//To update Book by publishDate
					else if(choice == 3) {
						System.out.println("Enter the Publish Date :");
						publish_date = scan.next();
						dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						System.out.println("What to update :");
						System.out.println("1. Id");
						System.out.println("2. Name");
						colchoice = scan.nextInt();
						//To update Book_id by publishDate
						if(colchoice == 1) {
							System.out.println("Enter the Id :");
							book_id = scan.nextInt();
							try {
								Book updbook = service.searchByDate(LocalDate.parse(publish_date,dateFormat));
								book = new Book(book_id,updbook.getName(),LocalDate.parse(publish_date,dateFormat));
								service.updateByDateId(book);
								bookSet = service.viewDetail();
								System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						//To update Book_name by publishDate
						else if(colchoice == 2) {
							System.out.println("Enter the name :");
							book_name = scan.next();
							try {
								Book updbook = service.searchByDate(LocalDate.parse(publish_date,dateFormat));
								book = new Book(updbook.getId(),book_name,LocalDate.parse(publish_date,dateFormat));
								service.updateByDateName(book);
								bookSet = service.viewDetail();
								System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						else {
							System.out.println("Invalid choice!!! Select 1 or 2");
						}
					}
					else {
						System.out.println("Invalid choice!!! Can't Update book");
					}
					break;
				case 6:
					bookId = service.viewAllBookId();
					System.out.println(bookId);
					break;
				case 7:
					bookName = service.viewAllBookName();
					System.out.println(bookName);
					break;

				default:
					System.exit(0);
				break;
			}
		}
		
	}
}


