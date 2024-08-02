package com.task.ApiDesign.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.ApiDesign.Entities.Product;
import com.task.ApiDesign.Repositories.CategoryRepository;
import com.task.ApiDesign.Repositories.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Product> getAllProductService(int page)
	{
		if(page==2)
		{
			return productRepo.findAll();
		}
		return null;
	}

	public Product createNewProductService(Product product)
	{
		return productRepo.save(product);
	}

	public Product getProductByIdService(int di)
	{
		return productRepo.findById(di).get();
	}

	public Product updateProductByIdService(int di, Product product)
	{
		Product foundProduct = productRepo.findById(di).get();
		if(foundProduct == null)
		{
			return null;
		}
		else
		{
			foundProduct.setProductName(product.getProductName());
			foundProduct.setPrice(product.getPrice());
			foundProduct.setCategory(product.getCategory());
	        return productRepo.save(foundProduct);
		}
	}

	public String deleteProductByIdService(int di)
	{
		Product product = productRepo.findById(di).get();
		try {
			productRepo.delete(product);
		}
		catch(IllegalArgumentException iae)
		{
			return " No such Category found ";
		}
		catch(Exception e)
		{
			return " Something Went wrong ";
		}
		
		return " Product Deleted Successfully ";
	}

}
