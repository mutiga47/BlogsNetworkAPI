package com.reagan.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/posts")
	public List<Post> getPosts(){
		return postService.getAllPosts();
	}

	@RequestMapping(value="/posts/{id}")
	public Optional<Post> getPost(@PathVariable String id) {
		return postService.getPostById(id);
	}
	

//	@RequestMapping(value="/posts/{title}")
//	public List<Post> getPostByTitleHeader(@PathVariable String title) {
////		return postService.getPostByTitle(title);
//	}
	
	@RequestMapping(value="/posts", method = RequestMethod.POST)
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@RequestMapping(value="/posts/{id}", method = RequestMethod.PUT)
	public void modifyPost(@PathVariable String id,
						   @RequestBody Post post) {
		postService.updatePost(id, 
							   post);
	}

	@RequestMapping(value="/posts/{id}", method = RequestMethod.DELETE)
	public void removePost(@PathVariable String id) {
		postService.deletePost(id);
		
	}

}
