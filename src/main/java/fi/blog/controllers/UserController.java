package fi.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.blog.models.SignupForm;
import fi.blog.models.User;
import fi.blog.models.UserInfo;
import fi.blog.models.UserInfoRepository;
import fi.blog.models.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	//signup form Route
	@RequestMapping(value = "/signup")
	public String addUser(Model model){
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	//Save User Route
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			if(signupForm.getPassword().equals(signupForm.getPasswordCheck())){
				String pwd = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);
				
				User newUser = new User();
				newUser.setPasswordHash(hashPwd);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				newUser.setFirstname(signupForm.getFirstname());
				newUser.setLastname(signupForm.getLastname());
				newUser.setPhone(signupForm.getPhone());
				newUser.setEmail(signupForm.getEmail());
				
				
				if(userRepository.findByUsername(signupForm.getUsername()) == null){
					userRepository.save(newUser);
					
					//For UserInfo 
					UserInfo newUserInfo = new UserInfo();
					newUserInfo.setId(newUser.getId());
					newUserInfo.setFirstname(newUser.getFirstname());
					newUserInfo.setLastname(newUser.getLastname());
					newUserInfo.setRole(newUser.getRole());
					newUserInfo.setPhone(newUser.getPhone());
					newUserInfo.setEmail(newUser.getEmail());
					newUserInfo.setUsername(newUser.getUsername());
					userInfoRepository.save(newUserInfo);
				}
				else{
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			} else{
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords don't match");
			}
		} else{
			return "signup";
		}
		return "redirect:/login";
	}
	
		//GET ALL USERS
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/users", method = RequestMethod.GET)
		public String getAllUsers(Model model){
			model.addAttribute("user", userInfoRepository.findAll());
			return "users";
		}
		
		//=======================
		//EDIT/REMOVE SPECIFIC USER BY USERID
		//=====================
		//Show edit form
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/users/{id}/edit", method = RequestMethod.GET)
		public String userEdit(@PathVariable("id") Long userId, Model model){
			model.addAttribute("user", userInfoRepository.findOne(userId));
			return "userEdit";
		}
		
		//Save edit and return to /users page
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/users/save", method = RequestMethod.POST)
		public String userSave(UserInfo user){
			userInfoRepository.save(user);
			return "redirect:/users";
		}
		
		//Delete user
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/users/{id}/delete", method = RequestMethod.GET)
		public String userDelete(@PathVariable("id") Long userId, Model model){
			userInfoRepository.delete(userId);
			userRepository.delete(userId);
			return "redirect:/users";
		}
		
}

