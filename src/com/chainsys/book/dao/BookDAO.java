package com.chainsys.book.dao;

import com.chainsys.book.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookDAO {

	public Set<Book> viewDetail();
	
	public void insertData(Book book);
	
	public Book searchById(int book_id);
	
	public Book searchByName(String book_name);
	
	public void deleteById(int id);
	
	public void deleteByName(String name);
	
	public void deleteByDate(LocalDate publish_date);

	Book searchByDate(LocalDate publish_date);
	
	public void updateByIdName(Book book);
	
	public void updateByIdDate(Book book);
	
	public void updateByNameId(Book book);
	
	public void updateByNameDate(Book book);
	
	public void updateByDateId(Book book);
	
	public void updateByDateName(Book book);
	
	public List<Integer> viewAllBookId();
	
	public List<String> viewAllBookName();
}
