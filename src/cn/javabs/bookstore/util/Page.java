package cn.javabs.bookstore.util;

import java.util.List;

public class Page {
    // 存放分页记录内容的集合
    private List record;
    //每页显示几条
    private int pageSize = 3;
    //当前页面
    private int currentPage;
    //总页数
    private int totalPage;
    //总记录数
    private int totalRecord;
    //上一页
    private int prePageNumber;
    //下一页
    private int nextPageNumber;
    //开始索引
    private int startIndex;
    // 链接
    private String url;

    /**
     * 有参数的构造方法
     * @param currentPage 当前页码
     * @param totalRecord  总(数据记录)条数
     */
    public Page(int currentPage, int totalRecord) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
//      总页数 =  总的记录条数(7)  取模  当前显示的条数(3)  == 0 ?
        // 符合   总的记录条数(6)  除  当前显示的条数(3) = 2 [页]
        // 不符合   总的记录条数(7)  除  当前显示的条数(3) = 2 [页] + 1 = 3 [页]
        totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize :totalRecord / pageSize + 1;

        startIndex = (currentPage - 1)*pageSize;
    }

    public List getRecord() {
        return record;
    }

    public void setRecord(List record) {
        this.record = record;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPrePageNumber() {
        prePageNumber = currentPage - 1 >0? currentPage - 1 :1;
        return prePageNumber;
    }

    public void setPrePageNumber(int prePageNumber) {
        this.prePageNumber = prePageNumber;
    }

    public int getNextPageNumber() {
        nextPageNumber = currentPage + 1 > totalPage ? totalPage : currentPage + 1 ;
        return nextPageNumber;
    }

    public void setNextPageNumber(int nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
