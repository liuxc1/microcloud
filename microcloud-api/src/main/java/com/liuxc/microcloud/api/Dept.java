package com.liuxc.microcloud.api;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long id;
	private String name;
	private String loc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
