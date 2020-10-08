package com.recorg.entity;

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
	private User user;
	
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
	
	public Recipe() {
		
	}

	public Recipe(String name, int numberOfIngredients) {
		this.name = name;
		this.numberOfIngredients = numberOfIngredients;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public void addProduct(Product product) {
		if(products == null) {
			products = new ArrayList<>();
		}
		
		products.add(product);
	}
		
}
