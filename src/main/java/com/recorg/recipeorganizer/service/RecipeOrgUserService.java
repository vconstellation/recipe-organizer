package com.recorg.recipeorganizer.service;

import java.util.List;

import com.recorg.recipeorganizer.entity.RecipeOrgUser;


public interface RecipeOrgUserService {
	
	public List<RecipeOrgUser> getRecipeOrgUsers();
	
	public List<RecipeOrgUser> getPaginatedRecipeOrgUsers(int min, int max);
	
	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser);
	
	public void deleteRecipeOrgUser(int theId);
	
	public RecipeOrgUser getRecipeOrgUser(int theId);
	
	public Long getTotalNumber();

}
