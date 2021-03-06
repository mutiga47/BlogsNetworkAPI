package com.reagan.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public List<Post> getAllPosts(){
		List<Post> posts = new ArrayList<>();
		
		postRepository.findAll().forEach(posts::add);
		
		return posts;
	}

	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}
	

	public List<Post> getPostByUser(Long id) {
		List<Post> posts = new ArrayList<>();
		
		postRepository.findByUserId(id).forEach(posts::add);
		
		return posts;
	}

	public void addPost(Post post) {
		postRepository.save(post);		
	}

	public void updatePost(Long id, 
						   Post post) {
		postRepository.save(post);	
	}

	public void deletePost(Long id) {
		postRepository.deleteById(id);	
	}
}
