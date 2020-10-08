package com.recorg.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	// Price per fixed unit
	@Column(name="price")
	private double price;
	
	//Vegan option
	@Column(name="is_vegan")
	private boolean isVegan;
	
	//Vegetarian option
	@Column(name="is_meat")
	private boolean isMeat;
	
	@ManyToMany
	@JoinTable(
			name="recipe_product",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<Recipe> recipes;
	
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JoinColumn(name="nutrition_id")
	private List<Nutrition> nutritions;
	
	
	public Product() {
		
	}

	

	public Product(String name, double price, boolean isVegan, boolean isMeat) {
		super();
		this.name = name;
		this.price = price;
		this.isVegan = isVegan;
		this.isMeat = isMeat;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isVegan() {
		return isVegan;
	}

	public void setVegan(boolean isVegan) {
		this.isVegan = isVegan;
	}

	public boolean isMeat() {
		return isMeat;
	}

	public void setMeat(boolean isMeat) {
		this.isMeat = isMeat;
	}
	
	
	
}
