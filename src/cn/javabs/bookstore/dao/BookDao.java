package cn.javabs.bookstore.dao;

import cn.javabs.bookstore.entity.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);
    int delBook(int id);
    int updateBook(Book book);

    Book getBookById(int id);

    int findPageBookNumber(int categoryId);

    /**
     * 查询全部图书
     *      |--  分页 需要两个参数
     * @param startIndex   开始的索引
     * @param pageSize      一页有多少条
     * @return
     */
    List<Book> findAllBookRecords(int startIndex ,int pageSize);

    /**
     * 查询某分类下的全部图书
     * @param startIndex    开始的索引
     * @param pageSize      一页有多少条
     * @param categoryId    分类的id
     * @return
     */
    List<Book> findPageBooks(int startIndex ,int pageSize , int categoryId);

    int getBookNumber();
}
