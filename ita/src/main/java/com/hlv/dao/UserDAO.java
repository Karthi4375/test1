package com.hlv.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.hlv.entity.User;

public interface UserDAO extends GenericDAO<User, Long> {

	public Boolean addUser(User p);

	public void updateUser(int id);

	public List<User> listUsers();

	public void removeUser(int id);

	public void addUsers(User p);

	public void saveUsers(User users);

	public User getUsers(int id);

	public void editsaveUsers(User users);

	public void editUsers(User users);

	public User updateUsers(User users);

	public List<User> getpagination(User users);

	public void savepagination(User users);
	public List<User> searchByName(String username);

}