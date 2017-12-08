package fi.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.blog.models.Post;
import fi.blog.models.PostRepository;
import fi.blog.models.Style;
import fi.blog.models.StyleRepository;
import fi.blog.models.User;
import fi.blog.models.UserRepository;

@SpringBootApplication
public class BlogApplication {
	private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner blogDemo(PostRepository postRepository, StyleRepository styleRepository, UserRepository userRepository){
		return (args) -> {
			log.info("save posts");
			styleRepository.save(new Style("Beauty"));
			styleRepository.save(new Style("Economy"));			
			styleRepository.save(new Style("Technology"));
			styleRepository.save(new Style("Travel"));
			styleRepository.save(new Style("Universe and Geography"));
			styleRepository.save(new Style("Others"));
			
//			srepository.save(new Student("John", "Johnson", "john@john.com", drepository.findByName("IT").get(0)));
//			Post newPost = new Post();
//			newPost.setTitle("Puppy");
//			newPost.setImage("http://cdn.akc.org/content/hero/puppy-boundaries_header.jpg");
//			newPost.setBody("Puppies are pretty much the cutest creatures, everyone agrees definitely!!! Much cuter than bunnies.");
//			newPost.setStyle(styleRepository.findByName("Animal").get(0));
//			postRepository.save(newPost);
			
			//Create users: admin/admin user/user
			User user1 = new User("Khanh", "Dang", "0468450492", "khanh.2dbt@gmail.com", "admin", "$2a$06$lvFCYKn5YQXaq9/bUrcVNOQwMaAOp8H7z5rh5HqlKOCIMntqj3dna", "ADMIN");
			User user2 = new User("Khanh", "Dang", "0468450492", "khanh.2dbt@gmail.com", "user", "$2a$06$tbUaiUpPcxljg8sMM1VXg.ogo27QspWTBOrwNBKDENIVG9Q8AVIQy", "USER");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all posts");
			for(Post post : postRepository.findAll()){
				log.info(post.toString());
			}
		};
	}
	
}
