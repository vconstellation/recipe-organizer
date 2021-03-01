package com.recorg.recipeorganizer.service;

import java.util.List;

import com.recorg.recipeorganizer.entity.Recipe;
import com.recorg.recipeorganizer.entity.RecipeRating;

public interface RecipeRatingService {
	
	public List<RecipeRating> getRecipeRatings();
	
	public RecipeRating getRecipeRating(int theId);
	
	public List<RecipeRating> getPaginatedRecipeRatings(int min, int max);
	
	public Long getTotalNumber();
	
	public void saveRecipeRating(RecipeRating theRecipeRating);
	
	public void deleteRecipeRating(int theId);
}
