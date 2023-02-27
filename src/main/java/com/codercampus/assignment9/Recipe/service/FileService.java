package com.codercampus.assignment9.Recipe.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.codercampus.assignment9.Recipe.domain.Recipes;

@Service
public class FileService {

	private List<Recipes> readAllRecipes() throws IOException {

		Reader in = new FileReader("recipes.csv");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',').withEscape('\\')
				.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes",
						"Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan",
						"Vegetarian")
				.withSkipHeaderRecord()
				.withIgnoreSurroundingSpaces()
				.parse(in);
		List<Recipes> recipesList = new ArrayList<>();

		for (CSVRecord record : records) {
			Recipes recipe = new Recipes();
			recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
			recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
			recipe.setInstructions(record.get("Instructions"));
			recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
			recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
			recipe.setServings(Integer.parseInt(record.get("Servings")));
			recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
			recipe.setTitle(record.get("Title"));
			recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
			recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

			recipesList.add(recipe);

		}
		return recipesList;
	}

	public List<Recipes> getAllRecipes() throws IOException {
		return readAllRecipes();

	}

}
