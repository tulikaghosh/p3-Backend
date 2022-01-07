package com.project3.revtech.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.entity.User;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.UserPojo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository 	userRepositoryDao ;
	
	 public UserServiceImpl() {}
	
	@Override
	public UserPojo updateUserService(UserPojo userInfo) throws ApplicationException {
	
		 User updateUser = new User(userInfo.getUser_id(), userInfo.getUsername(), userInfo.getPassword(), userInfo.getEmail(), userInfo.getFirst_name(), userInfo.getLast_name(),
				                    userInfo.getAddress(), userInfo.getContact());
		User  returnUser = userRepositoryDao.save(updateUser);
				
		return userInfo;
	}
	
	

}
