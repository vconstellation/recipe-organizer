package com.recorg.recipeorganizer.service;

import java.util.List;

import com.recorg.recipeorganizer.entity.Nutrition;

public interface NutritionService {
	
	public List<Nutrition> getNutritions();
	
	public void saveNutrition(Nutrition theNutrition);
	
	public void deleteNutrition(int theId);
	
	public Nutrition getNutrition(int theId);

}
