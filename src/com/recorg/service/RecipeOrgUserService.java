package com.recorg.service;

import java.util.List;

import com.recorg.entity.RecipeOrgUser;


public interface RecipeOrgUserService {
	
	public List<RecipeOrgUser> getRecipeOrgUsers();
	
	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser);
	
	public void deleteRecipeOrgUser(int theId);
	
	public RecipeOrgUser getRecipeOrgUser(int theId);

}
