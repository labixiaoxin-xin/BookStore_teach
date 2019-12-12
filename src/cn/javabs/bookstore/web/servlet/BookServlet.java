package cn.javabs.bookstore.web.servlet;

import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.entity.Category;
import cn.javabs.bookstore.service.BookService;
import cn.javabs.bookstore.service.impl.BookServiceImpl;
import cn.javabs.bookstore.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/bookServlet")
@MultipartConfig(maxFileSize = 1024*50)
public class BookServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");

        System.out.println(method);

        switch (method){
            case "addBook" :
                addBook(request,response);
                break;

            case  "bookList":
                bookList(request,response);
                break;
        }
    }

    /**
     * 图书列表 == 查询图书
     * @param request
     * @param response
     */
    private void bookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPageNum = request.getParameter("pageNum");
        int pageNum = Integer.parseInt(sPageNum);

        Page page = bookService.getAllBooks(pageNum);
        if (page != null){
            request.setAttribute("page",page);
            request.getRequestDispatcher("/bookList.jsp").forward(request,response);
        }else{
            request.setAttribute("data","提交失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 添加图书
     * @param request
     * @param response
     */
    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 以下只可以获取普通表单
        String name = request.getParameter("name");
        System.out.println(name);
        String author = request.getParameter("author");
        String publish = request.getParameter("publish");
        String sPrice = request.getParameter("price");

        double price = Double.parseDouble(sPrice);

        String sCategoryId = request.getParameter("categoryId");

        int categoryId = Integer.parseInt(sCategoryId);

        Category category = new Category();

        category.setId(categoryId);


        // 1.  获取文件目录
        String realPath = this.getServletContext().getRealPath("upload/");


        File file = new File(realPath);

        if (!file.exists()){
            // 自动创建
            file.mkdirs();
        }
        Part part = request.getPart("photoName");
        String fileName = part.getSubmittedFileName();

        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

        String currentTime = simpleDateFormat.format(date);//  时间 变成 了 一串  数字

        fileName = currentTime +"_"+ fileName;

        System.out.println("fileName:" + fileName);

        System.out.println("realPath：" + realPath);

        System.out.println(realPath +  fileName);

        part.write(realPath +  fileName);

        Book book = new Book(name,author,publish,price,realPath,fileName,category);

        int rows = bookService.addBook(book);

        if (rows >0){
            request.setAttribute("data","提交成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("data","提交失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }

    }
}









