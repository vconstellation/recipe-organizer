package com.recorg.config;

import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.recorg.entity.Nutrition;
import com.recorg.entity.Product;
import com.recorg.entity.Recipe;
import com.recorg.entity.RecipeOrgUser;
import com.recorg.entity.RecipeRating;
import com.recorg.entity.RecipeStep;
import com.recorg.service.RecipeStepService;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/recipe_org_dc?useSSL=false&amp;serverTimezone=UTC");
				settings.put(Environment.USER, "recipe_org_su");
				settings.put(Environment.PASS, "mo29qwTK!");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				settings.put(Environment.SHOW_SQL, "true");
				
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				settings.put(Environment.HBM2DDL_AUTO, "update");
				
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Nutrition.class);
				configuration.addAnnotatedClass(Product.class);
				configuration.addAnnotatedClass(Recipe.class);
				configuration.addAnnotatedClass(RecipeOrgUser.class);
				configuration.addAnnotatedClass(RecipeRating.class);
				configuration.addAnnotatedClass(RecipeStep.class);
				
				sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
