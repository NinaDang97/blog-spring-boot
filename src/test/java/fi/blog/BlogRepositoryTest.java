package fi.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fi.blog.models.Post;
import fi.blog.models.PostRepository;
import fi.blog.models.Style;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BlogRepositoryTest {
	
	@Autowired
	private PostRepository postRepository;
		
	@Test
	public void createNewPost(){
		Post post = new Post("Puppy", "http://cdn.akc.org/content/hero/puppy-boundaries_header.jpg", "Puppies are pretty much the cutest creatures", new Style("Zoology"));
		assertThat(post.getTitle()).isNotNull();
	}
	
	@Test
	public void findByTitleShouldReturnPost(){
		List<Post> posts = postRepository.findByTitle("");
			
		assertThat(posts).hasSize(0);
		assertThat(posts.get(0).getTitle()).isEqualTo("");			
	}
	
}
