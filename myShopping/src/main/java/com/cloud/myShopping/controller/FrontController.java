package com.cloud.myShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.myShoppingBackend.DAO.CategoryDAO;

@Controller
public class FrontController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/home" , "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title" ,"E_COMMERCE FRONTEND HOME");
		mv.addObject("categories", categoryDAO.listCategory());
		mv.addObject("userclickhome", true);
		return mv;
	}
	
	@RequestMapping(value="/aboutus")
	public ModelAndView aboutus()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title" ,"E_COMMERCE FRONTEND About Us");
		mv.addObject("userclickaboutus", true);

		return mv;
	}
	
	
	@RequestMapping(value="/all/products")
	public ModelAndView allproducts()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title" ,"E_COMMERCE FRONTEND ALL PRODUCTS");
		mv.addObject("userclickallproducts", true);

		return mv;
	}
	
	

}