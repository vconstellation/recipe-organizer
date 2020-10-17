package com.recorg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="nutrition")
public class Nutrition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="prep_type")
	private String prepType;
	
	@Column(name="fat")
	private int fat;
	
	@Column(name="carbs")
	private int carbs;
	
	@Column(name="proteins")
	private int proteins;
	
	@Column(name="calories")
	private int calories;
	
	public Nutrition() {
		
	}

	public Nutrition(String prepType, int fat, int carbs, int proteins, int calories) {
		super();
		this.prepType = prepType;
		this.fat = fat;
		this.carbs = carbs;
		this.proteins = proteins;
		this.calories = calories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrepType() {
		return prepType;
	}

	public void setPrepType(String prepType) {
		this.prepType = prepType;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getProteins() {
		return proteins;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	

}
