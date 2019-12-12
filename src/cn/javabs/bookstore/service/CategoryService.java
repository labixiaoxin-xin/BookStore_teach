package cn.javabs.bookstore.service;

import cn.javabs.bookstore.entity.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 添加分类
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 修改分类
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int delCategory(int id);

    /**
     * 根据分类的id进行查询分类
     * @param id
     * @return
     */
    Category getCategoryById(int id);

    /**
     * 查询全部分类
     * @return
     */
    List<Category> getAllCategories();

}
