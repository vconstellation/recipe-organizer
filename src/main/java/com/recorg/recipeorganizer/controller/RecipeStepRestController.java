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
import com.recorg.recipeorganizer.entity.RecipeStep;
import com.recorg.recipeorganizer.service.RecipeService;
import com.recorg.recipeorganizer.service.RecipeStepService;

@RestController
@RequestMapping("/api")
public class RecipeStepRestController {
	
	private RecipeStepService recipeStepService;
	
	@Autowired
	public RecipeStepRestController(RecipeStepService theRecipeStepService) {
		
		recipeStepService = theRecipeStepService;
	}
	
	@GetMapping("/recipesteps")
	public List<RecipeStep> getRecipeSteps() {
		
		return recipeStepService.getRecipeSteps();
	}
	
	@GetMapping("/recipesteps/{recipeStepId}")
	public RecipeStep getRecipeStep(@PathVariable int recipeStepId) {
		
		RecipeStep theRecipeStep = recipeStepService.getRecipeStep(recipeStepId);
		
		if(theRecipeStep == null) {
			throw new RuntimeException("Recipe of id " + recipeStepId + " not found.");
		}
		
		return theRecipeStep;
	}
	
	@PostMapping("/recipesteps")
	public RecipeStep saveRecipeStep(@RequestBody RecipeStep theRecipeStep) {
		
		recipeStepService.saveRecipeStep(theRecipeStep);
		
		return theRecipeStep;
	}
	
	@DeleteMapping("/recipesteps/{recipeStepId")
	public String deleteRecipeStep(@PathVariable int recipeStepId) {
		
		RecipeStep tempRecipeStep = recipeStepService.getRecipeStep(recipeStepId);
		
		if(tempRecipeStep == null) {
			throw new RuntimeException("Recipe of id " + recipeStepId + " not found");
		}
		
		recipeStepService.deleteRecipeStep(recipeStepId);
		
		return "Deleted product of id " + recipeStepId; 
	}

}
