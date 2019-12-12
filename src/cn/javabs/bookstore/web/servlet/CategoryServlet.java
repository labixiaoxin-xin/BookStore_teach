package cn.javabs.bookstore.web.servlet;

import cn.javabs.bookstore.entity.Category;
import cn.javabs.bookstore.service.CategoryService;
import cn.javabs.bookstore.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 快捷键:  alt + enter            报错/异常
 *          alt + shift  +  ↑/↓  移动
 *
 *
 *
 */
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

    // 1 将 categoryService 提取成为全局变量
    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 编码
         */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //----------------------------------------------------------
        // 你想执行哪个方法  ？  |  增删改查

        //  找前台接收需要调用的参数 进行判断
        String method = request.getParameter("method");

        System.out.println("method = " + method);// method =  addCategory

        if (method.equals("addCategory")){
            addCategory(request,response);
            return;
        }else if(method.equals("delCategory")){
            delCategory(request,response);
        }else if(method.equals("updateCategory")){
            updateCategory(request,response);
        }else if(method.equals("updateCategoryView")){
            updateCategoryView(request,response);
        }else if(method.equals("findAllCategories")){
            findAllCategories(request,response);
        }else{
            System.out.println("啥也不是！");
        }

    }

    /**
     * 数据回显
     * @param request
     * @param response
     */
    private void updateCategoryView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Category c = categoryService.getCategoryById(id);
        if (c != null){
            request.setAttribute("data",c);
            request.getRequestDispatcher("editCategory.jsp").forward(request,response);
        }else{
            request.setAttribute("data","啥也不是，提交失败！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }


    }

    /**
     * 查询全部分类
     * @param request
     * @param response
     */
    private void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAllCategories();
        if (categoryList.size()>0 && categoryList != null ){
            request.setAttribute("data",categoryList);
            request.getRequestDispatcher("/categoryList.jsp").forward(request,response);
        }else{
            request.setAttribute("data","啥也不是，提交失败！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 修改分类
     * @param request
     * @param response
     */
    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(id, name, description);
        int rows = categoryService.updateCategory(category);
        if (rows>0){
            //  1.  将成功的提示语  存储到一个记号里去
            request.setAttribute("data","真棒，提交成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("data","啥也不是，提交失败！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 删除分类
     * @param request
     * @param response
     */
    private void delCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  "7"  含义是  字符串类型
        String sid = request.getParameter("id");//获取前台jsp网页传递过来的 id
        //  7   含义是  是整型
        int id = Integer.parseInt(sid);

        int rows = categoryService.delCategory(id);
        if (rows>0){
            //  1.  将成功的提示语  存储到一个记号里去
            request.setAttribute("data","真棒，提交成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("data","啥也不是，提交失败！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 添加分类
     * @param request
     * @param response
     */
    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        category.setName("武侠");
        category.setDescription("金庸专著");
        int rows = categoryService.addCategory(category);
        if (rows>0){
            //  1.  将成功的提示语  存储到一个记号里去
            request.setAttribute("data","真棒，提交成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("data","啥也不是，提交失败！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
}
