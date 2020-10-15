package com.recorg.dao;

import java.util.List;

import com.recorg.entity.RecipeOrgUser;

public interface RecipeOrgUserDAO {
	
	public List<RecipeOrgUser> getRecipeOrgUsers();

	public void saveRecipeOrgUser(RecipeOrgUser theRecipeOrgUser);

	public void deleteRecipeOrgUser(int theId);

	public RecipeOrgUser getRecipeOrgUser(int theId);

	public List<RecipeOrgUser> getPaginatedRecipeOrgUsers(int min, int max);

	public Long getTotalNumber();

}
