package com.reagan.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, String>{
	public List<Post> findByUserId(String UserId);
	
//	public List<Post> findByPostTitle(String PostTitle);
}
