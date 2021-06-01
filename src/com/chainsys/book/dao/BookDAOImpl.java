package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;


import com.chainsys.book.model.Book;

public class BookDAOImpl implements BookDAO{

	public static Connection con;
	public static Set<Book> bookSet;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static ArrayList<Integer> bookId;
	public static ArrayList<String> bookname;
	
	
	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Set<Book> viewDetail() {
		try {
			pstmt = con.prepareStatement("select * from book_2607");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("B_id"), rs.getString("B_name"),
						rs.getDate("B_publish_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}
	@Override
	public void insertData(Book book) {
		try{
			pstmt = con.prepareStatement("insert into book_2607 (B_id,B_name,B_publish_date) values (?,?,?)");
			pstmt.setInt(1, book.getId());
			pstmt.setString(2, book.getName());
			pstmt.setDate(3, Date.valueOf(book.getPublishdate()));
			pstmt.executeQuery();
			System.out.println("data inserted successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Book searchById(int book_id) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("Select * from book_2607 where B_id=?");
			pstmt.setInt(1, book_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book(rs.getInt("B_id"),rs.getString("B_name"),rs.getDate("B_publish_date").toLocalDate());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public Book searchByName(String book_name) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("Select * from book_2607 where B_name=?");
			pstmt.setString(1, book_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book(rs.getInt("B_id"),rs.getString("B_name"),rs.getDate("B_publish_date").toLocalDate());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	
	@Override
	public Book searchByDate(LocalDate publish_date) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2607 where B_publish_date = ?");
			pstmt.setDate(1,Date.valueOf(publish_date));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book(rs.getInt("B_id"),rs.getString("B_name"),rs.getDate("B_publish_date").toLocalDate());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public void deleteById(int book_id) {
		try {
			pstmt = con.prepareStatement("delete book_2607 where B_id = ?");
			pstmt.setInt(1, book_id);
			pstmt.executeQuery();
			System.out.println("Deleted Successfully!!!");
		}
		catch(SQLException e) {
			
		}
	}
	
	@Override
	public void deleteByName(String book_name) {
		try {
			pstmt = con.prepareStatement("delete book_2607 where B_name = ?");
			pstmt.setString(1, book_name);
			pstmt.executeQuery();
			System.out.println("Deleted Successfully!!!");
		}
		catch(SQLException e) {
			
		}
	}
	
	@Override
	public void deleteByDate(LocalDate publish_date) {
		try {
			pstmt = con.prepareStatement("delete book_2607 where B_publish_date = ?");
			pstmt.setDate(1, Date.valueOf(publish_date));
			pstmt.executeQuery();
			System.out.println("Deleted Successfully!!!");
		}
		catch(SQLException e) {
			
		}
	}
	
	@Override
	public void updateByIdName(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2607 set B_name = ? where B_id = ?");
			pstmt.setString(1,book.getName());
			pstmt.setInt(2, book.getId());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateByIdDate(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2607 set B_pub_date = ? where B_id = ?");
			pstmt.setDate(1, Date.valueOf(book.getPublishdate()));
			pstmt.setInt(2, book.getId());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateByNameId(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2607 set B_id = ? where B_name = ?");
			pstmt.setInt(1, book.getId());
			pstmt.setString(2, book.getName());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateByNameDate(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2607 set B_publish_date = ? where B_name = ?");
			pstmt.setDate(1, Date.valueOf(book.getPublishdate()));
			pstmt.setString(2, book.getName());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateByDateId(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2607 set B_id = ? where B_publish_date = ?");
			pstmt.setInt(1, book.getId());
			pstmt.setDate(2, Date.valueOf(book.getPublishdate()));
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateByDateName(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2607 set B_name = ? where B_publish_date = ?");
			pstmt.setString(1, book.getName());
			pstmt.setDate(2, Date.valueOf(book.getPublishdate()));
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> viewAllBookId(){
		try {
			bookId = new ArrayList<>();
			pstmt = con.prepareStatement("select B_id from book_2607");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookId.add(rs.getInt("B_id"));
			}
		  }
			catch(SQLException e) {
				e.printStackTrace();
			}
		return bookId;
		}
	
	public List<String> viewAllBookName(){
		try {
			bookname = new ArrayList<>();
			pstmt = con.prepareStatement("select B_name from book_2607");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookname.add(rs.getString("B_name"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return bookname;
	}
}
