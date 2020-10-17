package com.recorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.dao.RecipeStepDAO;
import com.recorg.entity.RecipeStep;

@Service
public class RecipeStepServiceImpl implements RecipeStepService {
	
	@Autowired
	private RecipeStepDAO recipeStepDAO;

	@Override
	@Transactional
	public List<RecipeStep> getRecipeSteps() {
		
		return recipeStepDAO.getRecipeSteps();
	}

	@Override
	@Transactional
	public RecipeStep getRecipeStep(int theId) {
		
		return recipeStepDAO.getRecipeStep(theId);
	}

	@Override
	@Transactional
	public List<RecipeStep> getPaginatedRecipeSteps(int min, int max) {
		
		return recipeStepDAO.getPaginatedRecipeSteps(min, max);
	}

	@Override
	@Transactional
	public Long getTotalNumber() {
		
		return recipeStepDAO.getTotalNumber();
	}

	@Override
	@Transactional
	public void saveRecipeStep(RecipeStep theRecipeStep) {
		
		recipeStepDAO.saveRecipeStep(theRecipeStep);
	}

	@Override
	@Transactional
	public void deleteRecipeStep(int theId) {

		recipeStepDAO.deleteRecipeStep(theId);
	}
	
	
}
