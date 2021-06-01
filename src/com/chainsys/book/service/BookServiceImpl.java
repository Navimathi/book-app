package com.chainsys.book.service;

import com.chainsys.book.model.Book;
import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.exception.BookNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService{
	private static BookDAO bdao;
	
	public BookServiceImpl() {
		bdao = new BookDAOImpl();
	}
	
	@Override
	public Set<Book> viewDetail(){
		return bdao.viewDetail();
	}
	
	@Override
	public void insertData(Book book) {
		bdao.insertData(book);
	}
	
	@Override
	public Book searchById(int book_id) throws BookNotFoundException {
		Book book = bdao.searchById(book_id);
		if(book == null) {
			throw new BookNotFoundException("Book cannot be found");
		}else {
			return book;
		}
	}

	@Override
	public Book searchByName(String book_name) throws BookNotFoundException {
		Book book = bdao.searchByName(book_name);
		if(book == null) {
			throw new BookNotFoundException("Book cannot be found");
		}else {
			return book;
		}
	}
	
	@Override
	public Book searchByDate(LocalDate publish_date)throws BookNotFoundException {
		Book book = bdao.searchByDate(publish_date);
		if(book == null) {
			throw new BookNotFoundException("Book cannot be found");
		}else {
			return book;
		}
	}
	
	@Override
	public void deleteById(int book_id)throws BookNotFoundException{
		Book book = bdao.searchById(book_id);
		if(book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.deleteById(book_id);
		}
	}
	
	@Override
	public void deleteByName(String book_name)throws BookNotFoundException{
		Book book = bdao.searchByName(book_name);
		if(book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.deleteByName(book_name);
		}
	}
	
	
	@Override
	public void deleteByDate(LocalDate publish_date) throws BookNotFoundException{
		Book book = bdao.searchByDate(publish_date);
		if(book == null) {
			throw new BookNotFoundException("Book PublishDate Not Found");
		}
		else {
			bdao.deleteByDate(publish_date);
		}
	}
	
	@Override
	public void updateByIdName(Book book) throws BookNotFoundException{
		Book updbook = bdao.searchById(book.getId());
		if (updbook == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.updateByIdName(book);
		}
	}
	
	@Override
	public void updateByIdDate(Book book) throws BookNotFoundException{
		Book updbook = bdao.searchById(book.getId());
		if (updbook == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.updateByIdDate(book);
		}
	}
	
	@Override
	public void updateByNameId(Book book) throws BookNotFoundException{
		Book updbook = bdao.searchByName(book.getName());
		if(updbook == null) {
			throw new BookNotFoundException("Book Name Not Found");
		}
		else {
			bdao.updateByNameId(book);
		}
	}
	
	@Override
	public void updateByNameDate(Book book) throws BookNotFoundException{
		Book updbook = bdao.searchByName(book.getName());
		if(updbook == null) {
			throw new BookNotFoundException("Book Name Not Found");
		}
		else {
			bdao.updateByNameDate(book);
		}
	}
	
	@Override
	public void updateByDateId(Book book) throws BookNotFoundException{
		Book updbook = bdao.searchByDate(book.getPublishdate());
		if(updbook == null) {
			throw new BookNotFoundException("Book Publish Date Not Found");
		}
		else {
			bdao.updateByDateId(book);
		}
	}
	
	@Override
	public void updateByDateName(Book book) throws BookNotFoundException{
		Book updbook = bdao.searchByDate(book.getPublishdate());
		if(updbook == null) {
			throw new BookNotFoundException("Book Publish Date Not Found");
		}
		else {
			bdao.updateByDateName(book);
		}
	}
	
	@Override
	public List<Integer> viewAllBookId(){
		return bdao.viewAllBookId();
	}
	
	@Override
	public List<String> viewAllBookName(){
		return bdao.viewAllBookName();
	}
}
