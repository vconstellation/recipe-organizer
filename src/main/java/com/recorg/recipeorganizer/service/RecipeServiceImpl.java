package com.recorg.recipeorganizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.dao.RecipeDAO;
import com.recorg.recipeorganizer.entity.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

	private RecipeDAO recipeDAO;

	@Autowired
	public RecipeServiceImpl(RecipeDAO theRecipeDAO) {
		recipeDAO = theRecipeDAO;
	}

	@Override
	@Transactional
	public List<Recipe> getRecipes() {
		
		return recipeDAO.getRecipes();
	}

	@Override
	@Transactional
	public Recipe getRecipe(int theId) {
		
		return recipeDAO.getRecipe(theId);
	}

	@Override
	@Transactional
	public List<Recipe> getPaginatedRecipes(int min, int max) {
		
		return recipeDAO.getPaginatedRecipes(min, max);
	}

	@Override
	@Transactional
	public Long getTotalNumber() {

		return recipeDAO.getTotalNumber();
	}

	@Override
	@Transactional
	public void saveRecipe(Recipe theRecipe) {
		
		recipeDAO.saveRecipe(theRecipe);
	}

	@Override
	@Transactional
	public void deleteRecipe(int theId) {
		
		recipeDAO.deleteRecipe(theId);
	}

}
