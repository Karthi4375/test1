package com.hlv.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;
import com.hlv.bean.Employee;
import com.hlv.bean.UserBean;
import com.hlv.dao.UserDAO;
import com.hlv.entity.User;
import com.hlv.service.UserService;

@Service("UserService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	// @Transactional
	public User getUserByUsername(String username) {
		Search search = new Search(User.class);
		search.addFilterEqual("username", username);
		List<User> result = userDAO.search(search);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}

	@Override
	// @Transactional
	public User findId(Long id) {
		return userDAO.find(id);
	}

	@Override
	// @Transactional
	public UserBean findUsers(UserBean bean) {
		// return userDAO.findUsers(p);
		User user = bean.getEntity();
		Search search = new Search(User.class);
		if (user != null) {
			// search.addFilterILike("username", p.getUsername());
			Filter filter1 = Filter.ilike("username",
					"%" + (user.getUsername() == null ? "" : user.getUsername()) + "%");
			search.addFilters(filter1);
			/*
			 * if (user.getUsername().isEmpty() || user.getFullname().isEmpty())
			 * { search.addFilters(filter1,filter2); } else {
			 * search.addFilterOr(filter1,filter2); }
			 */
		} else {
			search.addFilterILike("username", "%%");
		}

		search.addSort("id", true);
		search.setMaxResults(bean.getLimit());
		search.setPage(bean.getPage() - 1);
		// search.setPage(bean.getPage());
		SearchResult<User> searchResult = userDAO.searchAndCount(search);

		bean.setListResult(searchResult.getResult());
		// bean.setPage(bean.getPage()-1);
		// bean.setPage(bean.getPage());
		bean.setTotal(searchResult.getTotalCount());

		// List<Users> result = userDAO.search(search);
		// List<Users> result = userDAO.searchAndCount(search);
		return bean;
	}

	@Override
	@Transactional
	public User updateUsers(User users) {
		return this.userDAO.updateUsers(users);
	}

	@Override
	@Transactional
	public void updateUser(User p, String username, Date date) {
		this.userDAO.updateUsers(p);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public void addListUser(List<User> lstUsers) {
		for (User user : lstUsers) {
			User userAdd = getUserByUsername(user.getUsername());
			if(userAdd.getUsername()== null || userAdd.getUsername().isEmpty()) {
				this.userDAO.addUser(user);
			}
		}

		
	}

	@Override
	@Transactional
	public void removeUsers(int id) {
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public void updateUsers(int id) {
		this.userDAO.updateUser(id);
	}

	@Override
	public User getUsers(int id) {
		return this.userDAO.getUsers(id);
	}

	@Override
	@Transactional
	public void editsaveUsers(User users) {
		this.userDAO.editsaveUsers(users);
	}
	
	@Override
	public void editUsers(User users) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void addUsers(User p) {
		this.userDAO.addUsers(p);
	}

	@Override
	public List<User> getpagination(User users) {

		return this.userDAO.getpagination(users);
	}

	@Override
	@Transactional
	public void savepagination(User users) {

		this.userDAO.savepagination(users);

	}

	@Override
	public List<User> searchByName(String username) {
		return this.userDAO.searchByName(username);
	}

	

}
