package com.hlv.service;

import java.util.Date;
import java.util.List;

import com.hlv.bean.Employee;
import com.hlv.bean.UserBean;
import com.hlv.entity.User;

public interface UserService {

	public User getUserByUsername(String username);

	public User findId(Long id);

	public void addUsers(User p);

	public void updateUser(User p, String username, Date date);

	public User updateUsers(User users);

	public UserBean findUsers(UserBean bean);

	public List<User> listUsers();

	public void addListUser(List<User> lstUser);

	public void removeUsers(int id);

	public void updateUsers(int id);

	public User getUsers(int id);

	public void editsaveUsers(User users);

	public List<User> searchByName(String username);

	public void editUsers(User users);

	public void savepagination(User users);

	public List<User> getpagination(User users);

}