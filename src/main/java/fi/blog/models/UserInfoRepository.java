package fi.blog.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	User findByUsername(String username);
	List<UserInfo> findAll();
}
