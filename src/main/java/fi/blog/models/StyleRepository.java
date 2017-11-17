package fi.blog.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StyleRepository extends CrudRepository<Style, Long> {
	List<Style> findByName(String name);
}
