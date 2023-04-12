package com.lms.server.model;

public class Book {
//	private String bookId;
	private String bookName;
	private String copies;
	public Book(String bookName, String copies) {
//		this.bookId = bookId;
		this.bookName = bookName;
		this.copies = copies;
	}
//	public String getBookId() {
//		return bookId;
//	}
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCopies() {
		return copies;
	}
	public void setCopies(String copies) {
		this.copies = copies;
	}
}
