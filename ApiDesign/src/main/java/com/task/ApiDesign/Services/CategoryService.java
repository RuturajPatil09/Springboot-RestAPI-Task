package com.task.ApiDesign.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.ApiDesign.Entities.Category;
import com.task.ApiDesign.Repositories.CategoryRepository;

@Service
public class CategoryService
{
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getAllCategoryService(int page)
	{
		if(page==3)
		{
			return categoryRepo.findAll();
		}
		return null;
	}

	public Category createNewCategoryService(Category category)
	{
		return categoryRepo.save(category);
	}

	public Category getCategoryByIdService(int di)
	{
		return categoryRepo.findById(di).get();
	}

	public Category updateCategoryByIdService(int di, Category category)
	{
		Category foundCategory = categoryRepo.findById(di).get();
		if(foundCategory == null)
		{
			return null;
		}
		else
		{
			foundCategory.setCategoryName(category.getCategoryName());
			return categoryRepo.save(foundCategory);
		}
	}

	public String deleteCategoryByIdService(int di)
	{
		Category category = categoryRepo.findById(di).get();
		try {
			categoryRepo.delete(category);
		}
		catch(IllegalArgumentException iae)
		{
			return " No such Category found ";
		}
		catch(Exception e)
		{
			return " Something Went wrong ";
		}
		
		return " Category Deleted Successfully ";
	}

}
