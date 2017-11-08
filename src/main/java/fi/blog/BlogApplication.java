package fi.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.blog.models.Post;
import fi.blog.models.PostRepository;

@SpringBootApplication
public class BlogApplication {
	private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner blogDemo(PostRepository repository){
		return (args) -> {
			log.info("save posts");
			repository.save(new Post("Puppy - cuter creature than Bunny", "https://pbs.twimg.com/profile_images/832259393391562752/WpPpF-xW_400x400.jpg", "Puppies are pretty much the cutest creatures"));
			
			log.info("fetch all posts");
			for(Post post : repository.findAll()){
				log.info(post.toString());
			}
		};
	}
	
}
