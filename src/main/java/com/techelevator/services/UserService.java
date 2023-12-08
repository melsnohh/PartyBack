package com.techelevator.services;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Party;
import com.techelevator.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public boolean createUser(String username, String password, String role) {
        return userDao.create(username, password, role);
    }


}
