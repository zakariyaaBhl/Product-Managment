package com.bhl.crm.dao;

import java.util.List;

import com.bhl.crm.entities.Product;

public interface IProductDao {
	public List<Product> getAllProducts();
	public List<Product> getAllProductsByMc(String mc);
	public Product getProductById(Long id);
	public Product saveProd(Product product);
	public Product updateProd(Product product);
	public void deleteProd(Long id);
}
