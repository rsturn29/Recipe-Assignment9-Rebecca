package com.codercampus.assignment9.Recipe.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codercampus.assignment9.Recipe.domain.Recipes;
import com.codercampus.assignment9.Recipe.service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;
	
	@GetMapping("/gluten-free")
	public List<Recipes> getGlutenFree () throws IOException{
		return fileService.getAllRecipes()
						.stream()
						.filter(Recipes::getGlutenFree)
						.collect(Collectors.toList());
	}
	@GetMapping("/vegan")
	public List<Recipes> getVegan () throws IOException{
		return fileService.getAllRecipes()
						.stream()
						.filter(Recipes::getVegan)
						.collect(Collectors.toList());
	}
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipes> getVeganAndGlutenFree () throws IOException{
		return fileService.getAllRecipes()
						.stream()
						.filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
						.collect(Collectors.toList());
	}
	@GetMapping("/vegetarian")
	public List<Recipes> getVegetarian () throws IOException{
		return fileService.getAllRecipes()
						.stream()
						.filter(Recipes::getVegetarian)
						.collect(Collectors.toList());
	}

	@GetMapping("/all-recipes")
	public List<Recipes> getAllRecipes () throws IOException{
		return fileService.getAllRecipes();
	}
	}

