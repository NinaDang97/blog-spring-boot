package fi.blog.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String image;
	private String body;
	private Date date = new Date();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "styleid")
	private Style style;
	
	public Post(){
		
	}

	public Post(String title, String image, String body, Style style) {
		super();
		this.title = title;
		this.image = image;
		this.body = body;
		this.style = style;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", image=" + image + ", body=" + body + ", date=" + date
				+ ", style=" + style + "]";
	}

	
	
}
