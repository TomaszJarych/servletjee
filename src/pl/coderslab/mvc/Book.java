package pl.coderslab.mvc;

public class Book {
	private long id;
	private String author;
	private String title;
	private String isbn;
	public void setId(long id) {
		this.id = id;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public long getId() {
		return id;
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", isbn=" + isbn + "]";
	}

	
	

}
