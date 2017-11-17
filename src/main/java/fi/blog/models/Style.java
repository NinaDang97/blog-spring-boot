package fi.blog.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Style {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long styleid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "style")
	private List<Post> posts;
	
	public Style(){
		
	}

	public Style(String name) {
		super();
		this.name = name;
	}

	public Long getStyleid() {
		return styleid;
	}

	public void setStyleid(Long styleid) {
		this.styleid = styleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Style [styleid=" + styleid + ", name=" + name + ", posts=" + posts + "]";
	}
	
}
