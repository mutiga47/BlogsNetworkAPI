/*
 * This is a POJO Template for a Blog that is posted by any user in the network
 * 
 */

package com.reagan.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.reagan.user.User;

@Entity
public class Post {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id//PrimaryKey
	private Long id;
	private String title;
	private String postDate;
	@ManyToOne //Foreign link Relationship
	private User user;
	private String postContent;
	
	public Post() {}
	
	public Post(Long id, String postDate, User user, String postDetails) {
		super();
		this.id = id;
		this.postDate = postDate;
		this.user = user;
		this.postContent = postDetails;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Post(Long id, String title, String postDate, User user, String postContent) {
		super();
		this.id = id;
		this.title = title;
		this.postDate = postDate;
		this.user = user;
		this.postContent = postContent;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPostDetails() {
		return postContent;
	}
	public void setPostDetails(String postDetails) {
		this.postContent = postDetails;
	}


}
