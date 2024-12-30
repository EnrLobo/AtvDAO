package model.entities;

import java.util.Date;

public class Post {
	private int id;
	private String content;
	private Date date;
	private User userId;
	
	public Post() {
		this(0);
	}
	
	public Post(int id){
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
}
