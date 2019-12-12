package cn.javabs.bookstore.service;

import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.util.Page;

public interface BookService {
    //  6个

    int addBook(Book book);
    int updateBook(Book book);
    int delBook(int id);


    Book  getBookById(int id);

    /**
     * 查询所有图书的信息
     * @param  pageNum   当前页码   从何处来的?  jsp  ---  servlet ---- service  --- serviceImpl  ----Dao
     * @return
     */
    Page getAllBooks(int pageNum);

    /**
     *  查询某分类下的分页效果
     * @param pageNum
     * @param categoryId
     * @return
     */
    Page getAllPageRecords(int pageNum , int categoryId);

}
