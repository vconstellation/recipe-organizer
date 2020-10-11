package com.recorg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.entity.RecipeOrgUser;

@Repository
public class RecipeOrgUserDAOImpl implements RecipeOrgUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecipeOrgUser> getRecipeOrgUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<RecipeOrgUser> theQuery = currentSession.createQuery("from recipe_org_user", RecipeOrgUser.class);
		
		List<RecipeOrgUser> theUsers = theQuery.getResultList();
		
		return theUsers;
	}

	@Override
	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theRecipeOrgUser);
	}

	@Override
	public void deleteRecipeOrgUser(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from recipe_org_user where id=:recipeOrgUserId");
		
		theQuery.setParameter("recipeOrgUserId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public RecipeOrgUser getRecipeOrgUser(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		RecipeOrgUser theRecipeOrgUser = currentSession.get(RecipeOrgUser.class, theId);
		
		return theRecipeOrgUser;
	}

}
