package com.recorg.recipeorganizer.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private RecipeOrgUser recipeOrgUser;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number_of_ingredients")
	private int numberOfIngredients;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@ManyToMany
	@JoinTable(
			name="recipe_product",
			joinColumns = @JoinColumn(name="recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	
	@OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RecipeStep> recipeSteps;
	
	@OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RecipeRating> recipeRatings;
	
	public Recipe() {
		
	}

	public Recipe(String name, int numberOfIngredients) {
		this.name = name;
		this.numberOfIngredients = numberOfIngredients;
	}

	public RecipeOrgUser getUser() {
		return recipeOrgUser;
	}

	public void setUser(RecipeOrgUser recipeOrgUser) {
		this.recipeOrgUser = recipeOrgUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfIngredients() {
		return numberOfIngredients;
	}

	public void setNumberOfIngredients(int numberOfIngredients) {
		this.numberOfIngredients = numberOfIngredients;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<RecipeStep> getRecipeSteps() {
		return recipeSteps;
	}

	public void setRecipeSteps(List<RecipeStep> recipeSteps) {
		this.recipeSteps = recipeSteps;
	}

	public List<RecipeRating> getRecipeRatings() {
		return recipeRatings;
	}

	public void setRecipeRatings(List<RecipeRating> recipeRatings) {
		this.recipeRatings = recipeRatings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addProduct(Product product) {
		if(products == null) {
			products = new ArrayList<Product>();
		}
		
		products.add(product);
	}
	
	public void addRecipeStep(RecipeStep recipeStep) {
		if(recipeSteps == null) {
			recipeSteps = new ArrayList<RecipeStep>();
		}
		
		recipeSteps.add(recipeStep);
	}
	
	public void addRecipeRating(RecipeRating recipeRating) {
		if(recipeRatings == null) {
			recipeRatings = new ArrayList<RecipeRating>();
		}
		
		recipeRatings.add(recipeRating);
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeOrgUser=" + recipeOrgUser + ", name=" + name + ", numberOfIngredients=" + numberOfIngredients
				+ ", createdAt=" + createdAt + ", products=" + products + ", recipeSteps=" + recipeSteps + "]";
	}		
}
