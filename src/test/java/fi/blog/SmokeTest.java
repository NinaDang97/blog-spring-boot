package fi.blog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.blog.controllers.BlogController;
import fi.blog.controllers.HomeController;
import fi.blog.controllers.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	//TESTING ALL CONTROLLERS
	@Autowired
	private BlogController blogController;
	@Autowired
	private UserController userController;	
	@Autowired
	private HomeController homeController;
	
	@Test
    public void contexLoads() throws Exception {
		assertThat(blogController).isNotNull();
		assertThat(userController).isNotNull();
		assertThat(homeController).isNotNull();
	}
	
}
