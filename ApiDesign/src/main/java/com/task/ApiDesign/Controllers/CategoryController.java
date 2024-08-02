package com.task.ApiDesign.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.task.ApiDesign.Entities.Category;
import com.task.ApiDesign.Services.CategoryService;

@RestController
public class CategoryController
{
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("/api/categories")
	public List<Category> getAllCategories(@RequestParam(value="page" , required=false, defaultValue="1") int page)
	{
		return categoryService.getAllCategoryService(page);
	}
	
	@PostMapping("/api/categories")
	public Category createNewCategory(@RequestBody Category category)
	{
		return categoryService.createNewCategoryService(category);
	}
	
	@GetMapping("/api/categories/{di}")
	public Category getCategoryById(@PathVariable(name="di") int di)
	{
		return categoryService.getCategoryByIdService(di);
	}
	
	@PutMapping("/api/categories/{di}")
	public Category updateCategoryById(@PathVariable(name="di") int di , @RequestBody Category category)
	{
		return categoryService.updateCategoryByIdService(di, category);
	}
	
	@DeleteMapping("/api/categories/{di}")
	public String deleteCategoryById(@PathVariable(name="di") int di)
	{
		return categoryService.deleteCategoryByIdService(di);
	}
	

}
