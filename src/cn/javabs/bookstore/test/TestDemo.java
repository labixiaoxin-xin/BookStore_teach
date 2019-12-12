//package cn.javabs.bookstore.test;
//
//
//import cn.javabs.bookstore.entity.Category;
//import org.junit.Test;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class TestDemo {
//
//
//    @Test
//    public  void  fun(){
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");//  y 年 M 月份 d 日期  h 小时 m 分钟 s 秒
//        String currentTime = sdf.format(date);
//        System.out.println(currentTime);
//    }
//
//
//    CategoryService categoryService = new CategoryServiceImpl();
//    @Test
//    public void testAddCategory(){
//
//        // 1.  用测试 Service 往后的环节
//
//
//        Category category = new Category();
//        category.setName("武侠");
//        category.setDescription("金庸专著");
//        int rows = categoryService.addCategory(category);
//        if (rows>0){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }
//    }
//    @Test
//    public void testDelCategory(){
//
//        // 1.  用测试 Service 往后的环节
//
////        Category category = new Category();
//        int id = 7;
//        int rows = categoryService.delCategory(id);
//        if (rows>0){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }
//    }
//    @Test
//    public void testUpdateCategory(){
//
//        // 1.  用测试 Service 往后的环节
//
//        Category category = new Category();
//        category.setName("经典武侠");
//        category.setDescription("世间再无金庸...");
//        category.setId(8);
//        int rows = categoryService.updateCategory(category);
//        if (rows>0){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }
//    }
//
//    /**
//     * 查询
//     */
//    @Test
//    public void testCategoryList(){
//
//        // 1.  用测试 Service 往后的环节
//
//
//        List<Category> categoryList = categoryService.findAllCategories();
//        if (categoryList.size()>0 && categoryList != null ){
//            for (int i = 0; i < categoryList.size(); i++) {
//                System.out.println(categoryList.get(i));
//            }
//        }else{
//            System.out.println("error");
//        }
//    }
//
//}
