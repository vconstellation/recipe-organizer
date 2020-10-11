package com.recorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.dao.RecipeOrgUserDAO;
import com.recorg.entity.RecipeOrgUser;

@Service
public class RecipeOrgUserServiceImpl implements RecipeOrgUserService {

	@Autowired 
	private RecipeOrgUserDAO recipeOrgUserDAO;
	
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

}
