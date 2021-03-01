package com.recorg.recipeorganizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.dao.RecipeOrgUserDAO;
import com.recorg.recipeorganizer.entity.RecipeOrgUser;

@Service
public class RecipeOrgUserServiceImpl implements RecipeOrgUserService {

	private RecipeOrgUserDAO recipeOrgUserDAO;

	@Autowired
	public RecipeOrgUserServiceImpl(RecipeOrgUserDAO theRecipeOrgUserDAO) {
		recipeOrgUserDAO = theRecipeOrgUserDAO;
	}

	@Override
	@Transactional
	public List<RecipeOrgUser> getRecipeOrgUsers() {
		return recipeOrgUserDAO.getRecipeOrgUsers();
	}

	@Override
	@Transactional
	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser) {
		
		recipeOrgUserDAO.saveRecipeOrgUser(theRecipeOrgUser);
	}

	@Override
	@Transactional
	public void deleteRecipeOrgUser(int theId) {

		recipeOrgUserDAO.deleteRecipeOrgUser(theId);
	}

	@Override
	@Transactional
	public RecipeOrgUser getRecipeOrgUser(int theId) {
	
		return recipeOrgUserDAO.getRecipeOrgUser(theId);
	}

	@Override
	@Transactional
	public List<RecipeOrgUser> getPaginatedRecipeOrgUsers(int min, int max) {
		
		return recipeOrgUserDAO.getPaginatedRecipeOrgUsers(min, max);
	}

	@Override
	@Transactional
	public Long getTotalNumber() {
		
		return recipeOrgUserDAO.getTotalNumber();
	}

}
