package com.chainsys.book.model;

import java.time.LocalDate;

public class Book {
	private int id;
	private String name;
	private LocalDate publishdate;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, LocalDate publishdate) {
		super();
		this.id = id;
		this.name = name;
		this.publishdate = publishdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publishdate == null) ? 0 : publishdate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publishdate == null) {
			if (other.publishdate != null)
				return false;
		} else if (!publishdate.equals(other.publishdate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", publishdate=" + publishdate + "]";
	}
	
}

