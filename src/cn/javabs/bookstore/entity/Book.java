package cn.javabs.bookstore.entity;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private double price;
    private String path;
    private String photoName;
    private Category category;// 外键关联

    public Book() {
        super();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", price=" + price +
                ", path='" + path + '\'' +
                ", photoName='" + photoName + '\'' +
                ", category=" + category +
                '}';
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book(String name, String author, String publish, double price, String path, String photoName, Category category) {
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.price = price;
        this.path = path;
        this.photoName = photoName;
        this.category = category;
    }

    public Book(Integer id, String name, String author, String publish, double price, String path, String photoName, Category category) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.price = price;
        this.path = path;
        this.photoName = photoName;
        this.category = category;
    }
}
