package com.imikasa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imikasa.beans.ProductBrand;
import com.imikasa.pojo.CommonPage;
import com.imikasa.pojo.CommonResult;
import com.imikasa.pojo.ResultCode;
import com.imikasa.remoteservice.UploadService;
import com.imikasa.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product/brand")
public class BrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @Autowired
    private UploadService uploadService;

    @GetMapping("/brand/list")
    public CommonResult<List<ProductBrand>> getProductBrands(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<ProductBrand> productBrands = productBrandService.allProductBrands();
        CommonResult<List<ProductBrand>> result = new CommonResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),CommonPage.restPage(productBrands));
        return result;
    }


    @PostMapping("/brand/add")
    public CommonResult<ProductBrand> addProductBrand(ProductBrand productBrand,@RequestPart("img-file") MultipartFile multipartFile){
        String url = uploadService.uploadImg(multipartFile);
        productBrand.setLogo(url);
        int i = productBrandService.addProductBrands(productBrand);
        if(i==1){
            return new CommonResult<ProductBrand>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), productBrand);
        }
        return new CommonResult<ProductBrand>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), productBrand);
    }


}
