package com.ratel.common.model.page;

import java.io.Serializable;
import java.util.List;

public class Pagination<T extends Serializable> implements Serializable {

    /*默认页号*/
    private static final int DEFAULT_PAGE_NO = 1;
    /*默认煤业显示数量*/
    private static final int DEFAULT_PAGE_SIZE = 10;

    /*页号*/
    private int page;
    /*每页显示记录数*/
    private int pageSize;
    /*总页数*/
    private int totalPage;
    /*数据的总数量*/
    private long dataNumber;

    private List<T> content;

    public Pagination() {
        this(DEFAULT_PAGE_NO, DEFAULT_PAGE_SIZE);
    }

    public Pagination(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Pagination(int page, int pageSize, List<T> content) {
        this.page = page;
        this.pageSize = pageSize;
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public static int getDefaultPageNo() {
        return DEFAULT_PAGE_NO;
    }

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage != 0 ? totalPage : pageSize > 0 ? (dataNumber + pageSize - 1) / pageSize : 0;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(long dataNumber) {
        this.dataNumber = dataNumber;
    }
}
