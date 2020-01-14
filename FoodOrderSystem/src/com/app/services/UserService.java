package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao udao;
	
	@Override
	public User validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
