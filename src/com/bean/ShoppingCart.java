package com.bean;

import java.math.BigDecimal;

public class ShoppingCart {
	private Integer bookId;
	private String bookName;
	private Integer count;
	private Double price;
	private BigDecimal amount;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount() {
		BigDecimal count = new BigDecimal(Integer.toString(this.count));
		BigDecimal price = new BigDecimal(Double.toString(this.price));
		BigDecimal amount = count.multiply(price);
		this.amount = amount;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
}
