package com.recorg.recipeorganizer.dao;

import java.util.List;

import com.recorg.recipeorganizer.entity.Nutrition;

public interface NutritionDAO {
	
	public List<Nutrition> getNutritions();

	public void saveNutrition(Nutrition theNutrition);

	public void deleteNutrition(int theId);

	public Nutrition getNutrition(int theId);

}
