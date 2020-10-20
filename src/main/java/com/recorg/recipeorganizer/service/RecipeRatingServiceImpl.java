package com.recorg.recipeorganizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorg.recipeorganizer.dao.RecipeRatingDAO;
import com.recorg.recipeorganizer.entity.RecipeRating;

@Service
public class RecipeRatingServiceImpl implements RecipeRatingService {

	private RecipeRatingDAO recipeRatingDAO;

	@Autowired
	public RecipeRatingServiceImpl(RecipeRatingDAO theRecipeRatingDAO) {
		recipeRatingDAO = theRecipeRatingDAO;
	}

	@Override
	@Transactional
	public List<RecipeRating> getRecipeRatings() {
		
		return recipeRatingDAO.getRecipeRatings();
	}

	@Override
	public RecipeRating getRecipeRating(int theId) {
		
		return recipeRatingDAO.getRecipeRating(theId);
	}

	@Override
	public List<RecipeRating> getPaginatedRecipeRatings(int min, int max) {
		
		return recipeRatingDAO.getPaginatedRecipeRatings(min, max);
	}

	@Override
	public Long getTotalNumber() {

		return recipeRatingDAO.getTotalNumber();
	}

	@Override
	public void saveRecipeRating(RecipeRating theRecipeRating) {
		
		recipeRatingDAO.saveRecipeRating(theRecipeRating);
	}

	@Override
	public void deleteRecipeRating(int theId) {
		
		recipeRatingDAO.deleteRecipeRating(theId);
	}
	
	

}
