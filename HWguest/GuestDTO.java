package com.guest;

public class GuestDTO {
	
	private String id;
	private int pwd;
	private String name;
	
	private String content;
	private String created;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	
	@Override
	public String toString() {
		return "[id=" + id + " content=" + content + ", created="
				+ created + "]";
	}
	
	
	
	

}
