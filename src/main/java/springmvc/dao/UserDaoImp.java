package springmvc.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springmvc.model.User;

@Component
public class UserDaoImp implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public int insert(User user) {
		
		System.out.println("in userDaoImp insert");
		Integer i =(Integer)hibernateTemplate.save(user);
		return i;
		
	}

	@Override
	public User getUser(int userId) {
		System.out.println("in userDaoImp getUser");
		User user = hibernateTemplate.get(User.class, userId);
		System.out.println(user);
		return user;
		
	}
}
