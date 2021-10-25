package com.reagan.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/")
	public String home() {
		postService.getAllPosts();
		return ("redirect:/posts");

	}
	
	@RequestMapping(value="/posts")
	public String getPosts(Model modelPosts){
		List<Post> posts = postService.getAllPosts();
		
		modelPosts.addAttribute("posts", posts);
		
		return "posts";
	}
	
	@RequestMapping(value="/posts/{id}")
	public Optional<Post> getPost(@PathVariable Long id) {
		return postService.getPostById(id);
	}
	
	@RequestMapping(value="/addPost")
	public ModelAndView addNewPost() {
		Post post = new Post();
		
		return new ModelAndView("addPost", "form", post);
	}
	
	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public String saveNewPost(Post post) {
		postService.addPost(post);
		return ("redirect:/posts");

	}
	
	@RequestMapping(value="/posts", method = RequestMethod.POST)
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@RequestMapping(value="/posts/{id}", method = RequestMethod.PUT)
	public void modifyPost(@PathVariable Long id,
						   @RequestBody Post post) {
		postService.updatePost(id, 
							   post);
	}

	@RequestMapping(value="/posts/{id}", method = RequestMethod.DELETE)
	public void removePost(@PathVariable Long id) {
		postService.deletePost(id);
		
	}

}
