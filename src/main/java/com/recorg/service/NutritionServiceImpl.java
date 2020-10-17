package com.recorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.dao.NutritionDAO;
import com.recorg.entity.Nutrition;

@Service
public class NutritionServiceImpl implements NutritionService {
	
	@Autowired
	private NutritionDAO nutritionDAO;

	@Override
	@Transactional
	public List<Nutrition> getNutritions() {
		return nutritionDAO.getNutritions();
	}

	@Override
	@Transactional
	public void saveNutrition(Nutrition theNutrition) {
		
		nutritionDAO.saveNutrition(theNutrition); 
	}

	@Override
	@Transactional
	public void deleteNutrition(int theId) {
	
		nutritionDAO.deleteNutrition(theId);
	}

	@Override
	@Transactional
	public Nutrition getNutrition(int theId) {
		
		return nutritionDAO.getNutrition(theId);
	}

}
