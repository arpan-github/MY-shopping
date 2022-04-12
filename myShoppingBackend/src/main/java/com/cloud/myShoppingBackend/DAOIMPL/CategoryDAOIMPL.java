package com.cloud.myShoppingBackend.DAOIMPL;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.myShoppingBackend.DAO.CategoryDAO;



@Repository("categoryDAO")
@Transactional

public abstract class CategoryDAOIMPL implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategory() {
		String selectActiveCategory = "FROM Category WHERE isactive = :active";

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public Category getCategory(int id) {
		String selectActiveCategory = "FROM Category WHERE isactive = :active and id= :id";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		query.setParameter("id", id);
		return (Category) query.getSingleResult();
	}

}