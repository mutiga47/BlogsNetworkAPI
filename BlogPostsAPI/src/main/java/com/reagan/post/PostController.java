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

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/posts")
	public String getPosts(Model modelPosts){
		List<Post> posts = postService.getAllPosts();
		
		modelPosts.addAttribute("posts", posts);
		
		return "posts";
	}
	
	@RequestMapping(value="/posts/{id}")
	public Optional<Post> getPost(@PathVariable String id) {
		return postService.getPostById(id);
	}
	
	@RequestMapping(value="/home")
	public static String home() {
		return "index";
	}
	
//	@RequestMapping(value="/savePost", method = RequestMethod.POST)
//	public ModelAndView save1(@ModelAttribute Post post) {
//		//Save to database
////		addPost(post);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("posts");
//		modelAndView.addObject("postData",post);
//		
//		return modelAndView;
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
