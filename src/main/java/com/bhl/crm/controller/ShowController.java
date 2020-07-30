package com.bhl.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bhl.crm.dao.IProductDao;
import com.bhl.crm.entities.Product;

@Controller
public class ShowController {

	@Autowired
	IProductDao prodDao;
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("/showProd")
	public String showProducts(Model model) {
		List<Product> list = prodDao.getAllProducts();
		model.addAttribute("listProds",list);
		return "products";
	}
	
	@GetMapping("/addFormProd")
	public String addFormProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addFormPage";
	}
	
	@PostMapping("/addProduct")
	public String add(Model model,@ModelAttribute("prod")@Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "addFormPage";
		}
		model.addAttribute("product", product);
		prodDao.saveProd(product);
		return "confirmation";
	}
	
	@GetMapping("/updateFormProd")
	public String updateFormProduct(Model model,@RequestParam(name = "id") Long id) {
		model.addAttribute("product", prodDao.getProductById(id));
		return "updateFormPage";
	}
	
	
	@PostMapping("/updateProduct")
	public String update(Model model,@ModelAttribute("prod")@Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "updateFormPage";
		}
		model.addAttribute("product", product);
		prodDao.updateProd(product);
		return "confirmation";
	}
	
	@PostMapping("/search")
	public String searchForProducts(Model model,@RequestParam(name = "motCle") String mc) {
		List<Product> list =prodDao.getAllProductsByMc(mc);
		model.addAttribute("listProds", list);
		return "products";
	}
	
	@GetMapping("/deleteProd")
	public String deleteProduct(@RequestParam(name = "id")Long id) {
		prodDao.deleteProd(id);
		return "redirect:/showProd";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	
}
