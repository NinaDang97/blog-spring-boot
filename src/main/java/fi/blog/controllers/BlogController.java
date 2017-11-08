package fi.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.blog.models.Post;
import fi.blog.models.PostRepository;

@Controller
public class BlogController {
	@Autowired
	private PostRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {	
		model.addAttribute("post", repository.findAll());
		return "index";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long postId, Model model) {	
		model.addAttribute("post", repository.findOne(postId));
		return "show";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPost(Model model){
		model.addAttribute("post", new Post());
		return "new";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Post post){
		repository.save(post);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long postId, Model model){
		repository.delete(postId);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long postId, Model model){
		model.addAttribute("post", repository.findOne(postId));
		return "edit";
	}

}
