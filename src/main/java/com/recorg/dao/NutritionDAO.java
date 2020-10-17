package com.recorg.dao;

import java.util.List;

import com.recorg.entity.Nutrition;

public interface NutritionDAO {
	
	public List<Nutrition> getNutritions();

	public void saveNutrition(Nutrition theNutrition);

	public void deleteNutrition(int theId);

	public Nutrition getNutrition(int theId);

}
