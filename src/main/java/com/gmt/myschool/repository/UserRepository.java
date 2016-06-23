package com.gmt.myschool.repository;

import java.util.List;
import com.gmt.myschool.dao.UserDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserDao, Long> {

	public List<UserDao> findAll();
	
	public UserDao save(UserDao user);
	
	public UserDao findOne(Long id);

	public boolean exists(Long id);

	public long count();

	public void delete(Long id);

	public void delete(UserDao entity);

}
