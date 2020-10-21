package com.recorg.recipeorganizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recorg.recipeorganizer.entity.Recipe;
import com.recorg.recipeorganizer.entity.RecipeRating;
import com.recorg.recipeorganizer.entity.RecipeStep;
import com.recorg.recipeorganizer.service.RecipeRatingService;
import com.recorg.recipeorganizer.service.RecipeService;
import com.recorg.recipeorganizer.service.RecipeStepService;

@RestController
@RequestMapping("/api")
public class RecipeRatingRestController {
	
	private RecipeRatingService recipeRatingService;
	
	@Autowired
	public RecipeRatingRestController(RecipeRatingService theRecipeRatingService) {
		
		recipeRatingService = theRecipeRatingService;
	}
	
	@GetMapping("/recipesteps")
	public List<RecipeRating> getRecipeRatings() {
		
		return recipeRatingService.getRecipeRatings();
	}
	
	@GetMapping("/reciperatings/{recipeRatingId}")
	public RecipeRating getRecipeRating(@PathVariable int recipeRatingId) {
		
		RecipeRating theRecipeRating = recipeRatingService.getRecipeRating(recipeRatingId);
		
		if(theRecipeRating == null) {
			throw new RuntimeException("Recipe of id " + recipeRatingId + " not found.");
		}
		
		return theRecipeRating;
	}
	
	@PostMapping("/reciperatings")
	public RecipeRating saveRecipeRating(@RequestBody RecipeRating theRecipeRating) {
		
		recipeRatingService.saveRecipeRating(theRecipeRating);
		
		return theRecipeRating;
	}
	
	@DeleteMapping("/reciperatings/{recipeRatingId")
	public String deleteRecipeRating(@PathVariable int recipeRatingId) {
		
		RecipeRating tempRecipeRating = recipeRatingService.getRecipeRating(recipeRatingId);
		
		if(tempRecipeRating == null) {
			throw new RuntimeException("Recipe of id " + recipeRatingId + " not found");
		}
		
		recipeRatingService.deleteRecipeRating(recipeRatingId);
		
		return "Deleted product of id " + recipeRatingId; 
	}

}
