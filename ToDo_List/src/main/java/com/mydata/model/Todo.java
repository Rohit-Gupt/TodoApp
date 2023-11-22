package com.mydata.model;

import java.io.Serializable;
import java.sql.Date;

public class Todo implements Serializable{
	private String title;
	private Date targetDate;
	private String status;
	
	public Todo() {}

	public Todo(String title, Date targetDate, String status) {
		super();
		this.title = title;
		this.targetDate = targetDate;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", targetDate=" + targetDate + ", status=" + status + "]";
	}
	

}
