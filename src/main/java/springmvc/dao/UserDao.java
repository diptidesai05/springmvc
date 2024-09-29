package springmvc.dao;

import org.springframework.stereotype.Repository;


import springmvc.model.User;

@Repository
public interface UserDao {

	public int insert(User user);
	public User getUser(int userId); 
	
}
