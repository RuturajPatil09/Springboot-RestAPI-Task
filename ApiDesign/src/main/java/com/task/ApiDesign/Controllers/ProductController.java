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

import com.task.ApiDesign.Entities.Product;
import com.task.ApiDesign.Services.ProductService;

@RestController
public class ProductController
{
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/api/products")
	public List<Product> getAllProducts(@RequestParam(value="page" , required=false, defaultValue="1") int page)
	{
		return productService.getAllProductService(page);
	}
	
	
	@PostMapping("/api/products")
	public Product createNewProduct(@RequestBody Product product)
	{
		return productService.createNewProductService(product);
	}
	
	
	@GetMapping("/api/products/{di}")
	public Product getProductById(@PathVariable(name="di") int di)
	{
		return productService.getProductByIdService(di);
	}
	
	
	@PutMapping("/api/products/{di}")
	public Product updateProductById(@PathVariable(name="di") int di , @RequestBody Product product)
	{
		
		return productService.updateProductByIdService(di,product);
	}
	
	@DeleteMapping("/api/products/{di}")
	public String deleteProductById(@PathVariable(name="di") int di)
	{
		return productService.deleteProductByIdService(di);
	}
	
	

}
