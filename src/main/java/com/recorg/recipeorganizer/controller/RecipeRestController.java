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
import com.recorg.recipeorganizer.service.RecipeService;

@RestController
@RequestMapping("/api")
public class RecipeRestController {
	
	private RecipeService recipeService;
	
	@Autowired
	public RecipeRestController(RecipeService theRecipeService) {
		
		recipeService = theRecipeService;
	}
	
	@GetMapping("/recipes")
	public List<Recipe> getRecipes() {
		
		return recipeService.getRecipes();
	}
	
	@GetMapping("/recipes/{recipeId}")
	public Recipe getRecipe(@PathVariable int recipeId) {
		
		Recipe theRecipe = recipeService.getRecipe(recipeId);
		
		if(theRecipe == null) {
			throw new RuntimeException("Recipe of id " + recipeId + " not found.");
		}
		
		return theRecipe;
	}
	
	@PostMapping("/recipes")
	public Recipe saveRecipe(@RequestBody Recipe theRecipe) {
		
		recipeService.saveRecipe(theRecipe);
		
		return theRecipe;
	}
	
	@DeleteMapping("/recipes/{recipeId")
	public String deleteRecipe(@PathVariable int recipeId) {
		
		Recipe tempRecipe = recipeService.getRecipe(recipeId);
		
		if(tempRecipe == null) {
			throw new RuntimeException("Recipe of id " + recipeId + " not found");
		}
		
		recipeService.deleteRecipe(recipeId);
		
		return "Deleted product of id " + recipeId; 
	}

}
