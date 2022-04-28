package bookmanagement.dto;

import java.io.Serializable;

public class BookResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String title;
	private String author;
	private double price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [code=" + code + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
}
