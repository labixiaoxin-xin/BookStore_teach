package cn.javabs.bookstore.entity;

/**
 * 1.定义变量
 * 2.生产  toString  三个构造方法（1个无参数  两个有参数的） getter和setter方法        alt + insert
 */
//  图书的分类
public class Category {
    private  Integer id;
    private  String name;
    private  String  description;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Category() {
        super();
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(Integer id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}