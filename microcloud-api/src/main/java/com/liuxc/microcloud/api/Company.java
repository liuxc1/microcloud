package com.liuxc.microcloud.api;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Company implements Serializable {
	private String title;
	private String note;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
