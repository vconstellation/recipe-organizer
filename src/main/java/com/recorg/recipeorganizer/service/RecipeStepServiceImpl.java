package com.recorg.recipeorganizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.dao.RecipeStepDAO;
import com.recorg.recipeorganizer.entity.RecipeStep;

@Service
public class RecipeStepServiceImpl implements RecipeStepService {

	private RecipeStepDAO recipeStepDAO;

	@Autowired
	public RecipeStepServiceImpl(RecipeStepDAO theRecipeStepDAO) {
		recipeStepDAO = theRecipeStepDAO;
	}

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
