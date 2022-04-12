package com.cloud.myShoppingBackend.DAO;

import java.util.List;
import java.util.Locale.Category;

public interface CategoryDAO {

	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> listCategory();
	Category getCategory(int id);
}
