package com.imikasa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imikasa.beans.ProductBrand;
import com.imikasa.pojo.CommonPage;
import com.imikasa.pojo.CommonResult;
import com.imikasa.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/brand")
public class TestController {

    @Autowired
    private ProductBrandService productBrandService;


    @GetMapping("/test")
    public String test(){
        return "This is a product brand test !!!";
    }

    @GetMapping("/allBrands")
    public List<ProductBrand> all(){
        return productBrandService.allProductBrands();
    }
    @GetMapping("/allBrands_page")
    public CommonResult<List<ProductBrand>> allPage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<ProductBrand> allPage = productBrandService.allProductBrands();
        CommonResult<List<ProductBrand>> result = new CommonResult(200,"操作成功",allPage,CommonPage.restPage(allPage));
        return result;
    }





}
