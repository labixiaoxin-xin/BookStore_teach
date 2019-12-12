package cn.javabs.bookstore.service.impl;

import cn.javabs.bookstore.dao.BookDao;
import cn.javabs.bookstore.dao.imp.BookDaoImpl;
import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.service.BookService;
import cn.javabs.bookstore.util.Page;

import java.util.List;


public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int delBook(int id) {
        return bookDao.delBook(id);
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    /**
     * 查询所有图书的信息
     *
     * @param pageNum 当前页码   从何处来的?  jsp  ---  servlet ---- service  --- serviceImpl  ----Dao
     * @return
     */
    @Override
    public Page getAllBooks(int pageNum) {
        if (pageNum == 0){
            // 1.当前页码
            pageNum = 1;
        }
        // 2.  查询总条数
        int number = bookDao.getBookNumber();

        Page page = new Page(pageNum, number);

        int startIndex = page.getStartIndex();
        int pageSize = page.getPageSize();

        List<Book> bookList = bookDao.findAllBookRecords(startIndex, pageSize);

        page.setRecord(bookList);

        return page;
    }

    /**
     * 查询某分类下的分页效果
     *
     * @param pageNum
     * @param categoryId
     * @return
     */
    @Override
    public Page getAllPageRecords(int pageNum, int categoryId) {
        if (pageNum == 0){
            // 1.当前页码
            pageNum = 1;
        }
        // 2.  查询总条数
        int number = bookDao.getBookNumber();

        Page page = new Page(pageNum, number);

        int startIndex = page.getStartIndex();
        int pageSize = page.getPageSize();
        // 传递了三个参数
        List<Book> bookList = bookDao.findPageBooks(startIndex, pageSize, categoryId);

        page.setRecord(bookList);

        return page;
    }
}
