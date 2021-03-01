package com.recorg.recipeorganizer.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.recorg.recipeorganizer.entity.Nutrition;
import com.recorg.recipeorganizer.entity.Product;
import com.recorg.recipeorganizer.entity.Recipe;
import com.recorg.recipeorganizer.entity.RecipeRating;
import com.recorg.recipeorganizer.entity.RecipeStep;
import com.recorg.recipeorganizer.entity.RecipeOrgUser;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Nutrition.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Recipe.class)
				.addAnnotatedClass(RecipeRating.class)
				.addAnnotatedClass(RecipeStep.class)
				.addAnnotatedClass(RecipeOrgUser.class)
				.buildSessionFactory();

			Session session = factory.getCurrentSession();
			try {
					session.beginTransaction();
					session.getTransaction().commit();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			finally {
				session.close();
				factory.close();
			}
	}

}
