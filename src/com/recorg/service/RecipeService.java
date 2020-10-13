package com.recorg.service;

import java.util.List;

import com.recorg.entity.Recipe;

public interface RecipeService {
	
	public List<Recipe> getRecipes();
	
	public Recipe getRecipe(int theId);
	
	public List<Recipe> getPaginatedRecipes(int min, int max);
	
	public Long getTotalNumber();
	
	public void saveRecipe(Recipe theRecipe);
	
	public void deleteRecipe(int theId);
}
