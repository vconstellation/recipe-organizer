package com.recorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.dao.RecipeDAO;
import com.recorg.entity.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	private RecipeDAO recipeDAO;

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
