package com.hlv.dao.impl;

import java.awt.print.Book;
import java.util.List;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.hlv.dao.UserDAO;
import com.hlv.entity.User;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

	// private static final Logger logger =
	// LoggerFactory.getLogger(UserDAOImpl.class);

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * @Autowired public void setSessionFactory(SessionFactory sf){
	 * this.sessionFactory = sf; }
	 */

	private SessionFactory sessionFactory;

	@Override
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Boolean addUser(User user) {
		
		 User getUser = (User) searchByName(user.getUsername());
		  
		  if(!getUser.getUsername().isEmpty() || getUser.getUsername() == null) {
			  
		Session session = this.getSessionFactory().getCurrentSession();
		session.persist(user);
		// has not solution for 2 case in here ????????????????
		// this.save(p); //should not use save in insert, so if exists id then
		// insert become update
		//this._persist(user); // if use _persist: when create new user and has roles
							// then error, so at that time id null and can not
							// reference in user_role table
		// logger.info("Users saved successfully, Users Details="+p);
}
		else {
			return false;
		}
		return true;
	}

	@Override
	public void saveUsers(User user) {
		
		
		Session session = this.getSessionFactory().getCurrentSession();
		session.persist(user);
		// this.save(p);
		// this._update(p); // should not use save in update, so if not exists
		// id
		// then update become to insert
		// logger.info("Users updated successfully, Users Details="+p);
	}

	@Override
	public void addUsers(User user) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.persist(user);

	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Users> listUsers() { Session session =
	 * this.getSessionFactory().getCurrentSession(); List<Users> UserssList =
	 * session.createQuery("from Users order by id desc").list(); return
	 * UserssList; // return findAll(); }
	 */

	@Override
	public User find(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User[] find(Long... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getReference(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User[] getReferences(Long... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeByIds(Long... arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.getSessionFactory().getCurrentSession();

		// Criteria criteria=createEntityCriteria().addOrder(Order.asc("id"));
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<User> user = session.createQuery("from User order by id asc").list();
		return user;
	}

	private Criteria createEntityCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.getSessionFactory().getCurrentSession();
		User user = (User) session.get(User.class, id);
		session.delete(user);
	}

	@Override
	public void updateUser(int id) {
		Session session = this.getSessionFactory().getCurrentSession();
		// Users users = (Users) session.get(Users.class, id);
		session.update(id);
	}

	@Override
	public User getUsers(int id) {
		return (User) getSessionFactory().getCurrentSession().get(User.class, id);

	}

	@Override
	public User updateUsers(User users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editsaveUsers(User users) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(users);

	}

	@Override
	public void editUsers(User users) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(users);

	}

	@Override

	public List<User> getpagination(User users) {
		Session session = (Session) this.sessionFactory.getCurrentSession().createQuery("from users order by id asc")
				.list();
		return listUsers();

	}

	@Override
	public void savepagination(User users) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(users);
	}

	@Override
	public List<User> searchByName(String username) {
		Session session = this.getSessionFactory().getCurrentSession();
        
        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
          .buildQueryBuilder().forEntity(User.class).get();
        org.apache.lucene.search.Query query = (Query) qb
          .keyword().onFields("username")
          .matching(username)
          .createQuery();

        org.hibernate.Query hibQuery = 
           fullTextSession.createFullTextQuery(query, User.class);

        List<User> results = hibQuery.list();
        return results;

	
	}

	private void createQuery() {
		// TODO Auto-generated method stub
		
	}

}
