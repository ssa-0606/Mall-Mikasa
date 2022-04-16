package com.imikasa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imikasa.beans.ProductBrand;
import com.imikasa.pojo.CommonPage;
import com.imikasa.pojo.CommonResult;
import com.imikasa.pojo.ResultCode;
import com.imikasa.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/brand")
public class BrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @GetMapping("/brand/list")
    public CommonResult<List<ProductBrand>> getProductBrands(@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<ProductBrand> productBrands = productBrandService.allProductBrands();
        CommonResult<List<ProductBrand>> result = new CommonResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), productBrands,CommonPage.restPage(productBrands));
        return result;
    }

}
