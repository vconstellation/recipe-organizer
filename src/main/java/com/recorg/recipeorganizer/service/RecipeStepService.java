package com.recorg.recipeorganizer.service;

import java.util.List;

import com.recorg.recipeorganizer.entity.Recipe;
import com.recorg.recipeorganizer.entity.RecipeRating;
import com.recorg.recipeorganizer.entity.RecipeStep;

public interface RecipeStepService {
	
	public List<RecipeStep> getRecipeSteps();
	
	public RecipeStep getRecipeStep(int theId);
	
	public List<RecipeStep> getPaginatedRecipeSteps(int min, int max);
	
	public Long getTotalNumber();
	
	public void saveRecipeStep(RecipeStep theRecipeStep);
	
	public void deleteRecipeStep(int theId);
}
