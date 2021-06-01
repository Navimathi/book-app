package com.chainsys.book.service;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {

	Set<Book> viewDetail();
	
	public void insertData(Book book);
	
	public Book searchById(int book_id)throws BookNotFoundException;
	
	public Book searchByName(String book_name)throws BookNotFoundException;

	public void deleteById(int book_id)throws BookNotFoundException;
	
	public void deleteByName(String book_name)throws BookNotFoundException;
	
	public void deleteByDate(LocalDate publish_date)throws BookNotFoundException;

	Book searchByDate(LocalDate publish_date) throws BookNotFoundException;
	
	public void updateByIdName(Book book) throws BookNotFoundException;
	
	public void updateByIdDate(Book book) throws BookNotFoundException;
	
	public void updateByNameId(Book book) throws BookNotFoundException;
	
	public void updateByNameDate(Book book) throws BookNotFoundException;
	
	public void updateByDateId(Book book) throws BookNotFoundException;
	
	public void updateByDateName(Book book) throws BookNotFoundException;
	
	public List<Integer> viewAllBookId();
	
	public List<String> viewAllBookName();
	
}
