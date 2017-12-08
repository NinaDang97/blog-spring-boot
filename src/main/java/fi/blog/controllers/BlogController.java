package fi.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.blog.models.Post;
import fi.blog.models.PostRepository;
import fi.blog.models.Style;
import fi.blog.models.StyleRepository;

@Controller
public class BlogController {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private StyleRepository styleRepository;
	
	//Login Route
	@RequestMapping(value = "/login")
	public String login(){
		return "login";
	}
	
	//Post Index Route
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {	
		model.addAttribute("post", postRepository.findAll());
		return "index";
	}
	
	//Specific post with id Route
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long postId, Model model) {	
		model.addAttribute("post", postRepository.findOne(postId));
		return "show";
	}
	
	//Create new post Form Route
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPost(Model model){
		model.addAttribute("post", new Post());
		model.addAttribute("styles", styleRepository.findAll());
		return "new";
	}
	
	//SAVE POST AFTER DELETE/EDIT & REDIRECT TO INDEX
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Post post){
		postRepository.save(post);
		return "redirect:/";
	}
	
	//DELETE POST ROUTE & REDIRECT TO INDEX
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long postId, Model model){
		postRepository.delete(postId);
		return "redirect:/";
	}
	
	//EDIT FORM ROUTE 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long postId, Model model){
		model.addAttribute("post", postRepository.findOne(postId));
		model.addAttribute("styles", styleRepository.findAll());
		return "edit";
	}	
	
	//=====================
	//RESTful SERVICES
	//====================
	// Get all posts
	@RequestMapping(value="/posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> postListRest(){
		return (List<Post>) postRepository.findAll();
	}
	
	//Get all styles
	@RequestMapping(value="/styles", method = RequestMethod.GET)
	public @ResponseBody List<Style> styleListRest(){
		return (List<Style>) styleRepository.findAll();
	}
	
	//Get post by ID
	@RequestMapping(value="/post/{id}", method = RequestMethod.GET)
	public @ResponseBody Post findPostRest(@PathVariable("id") Long postId){
		return postRepository.findOne(postId);
	}

}
