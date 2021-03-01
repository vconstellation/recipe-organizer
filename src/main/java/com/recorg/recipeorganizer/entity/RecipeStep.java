package com.recorg.recipeorganizer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_steps")
public class RecipeStep {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "step_text")
	private String stepText;
	
	@Column(name = "step_number")
	private int stepNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	public RecipeStep() {
		
	}

	public RecipeStep(String stepText, int stepNumber) {
		this.stepText = stepText;
		this.stepNumber = stepNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStepText() {
		return stepText;
	}

	public void setStepText(String stepText) {
		this.stepText = stepText;
	}

	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "RecipeStep [id=" + id + ", stepText=" + stepText + ", stepNumber=" + stepNumber + ", recipe=" + recipe
				+ "]";
	}
		
}
