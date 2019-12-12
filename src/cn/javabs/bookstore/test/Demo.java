package cn.javabs.bookstore.test;

public class Demo {
    public static void main(String[] args) {
        int x = 0;

        x  = 9%2 == 1? 85:58;
        // ? 前的是 条件  符合的话  返回第一个值 (冒号前的)  | 不符合的话  返回后一个值 (冒号后的)
        System.out.println(x);
    }
}
