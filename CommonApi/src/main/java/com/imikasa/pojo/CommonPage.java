package com.imikasa.pojo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class CommonPage<T> {
    private long total;          //数据条数
    private int pageNum;        //当前页（页码）
    private int pageSize;       //当前页条数
    private int pages;          //总页数
    private int prePage;        //上一页页码
    private int nextPage;       //下一页页码
    private Boolean isFirstPage;//是否是首页
    private Boolean isLastPage; //是否是最后一页
    private int[] navigatepageNums;//页码
    private List<T> list;

    public static <T>CommonPage<T> restPage(List<T> list){
        CommonPage<T> commonPage = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo(list);
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setPages(pageInfo.getPages());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setPrePage(pageInfo.getPrePage());
        commonPage.setNextPage(pageInfo.getNextPage());
        commonPage.setIsFirstPage(pageInfo.isIsFirstPage());
        commonPage.setIsLastPage(pageInfo.isIsLastPage());
        commonPage.setNavigatepageNums(pageInfo.getNavigatepageNums());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }


}
