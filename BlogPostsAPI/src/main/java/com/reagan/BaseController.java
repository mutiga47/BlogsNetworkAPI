package com.reagan;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reagan.post.Post;

@Controller
public class BaseController {
	
	@RequestMapping(value="/home")
	public static String home() {
		return "index";
	}

}
