package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.UserDao;
import springmvc.model.User;



@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public int createUser(User user) {
		
		System.out.println("in userService insert");
		return this.userDao.insert(user);
	}
	
	public User getUser(int userId) {
		
		System.out.println("in userService getUser");
		return this.userDao.getUser(userId);
	}
	
}
