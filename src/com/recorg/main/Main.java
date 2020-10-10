package com.recorg.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.recorg.entity.Nutrition;
import com.recorg.entity.Product;
import com.recorg.entity.Recipe;
import com.recorg.entity.RecipeRating;
import com.recorg.entity.RecipeStep;
import com.recorg.entity.RecipeOrgUser;

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
