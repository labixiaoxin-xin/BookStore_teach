package cn.javabs.bookstore.service.impl;

import cn.javabs.bookstore.dao.CategoryDao;
import cn.javabs.bookstore.dao.imp.CategoryDaoImpl;
import cn.javabs.bookstore.entity.Category;
import cn.javabs.bookstore.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao =  new CategoryDaoImpl();


    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public int delCategory(int id) {
        return categoryDao.delCategory(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
