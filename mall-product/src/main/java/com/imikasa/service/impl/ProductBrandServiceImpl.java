package com.imikasa.service.impl;

import com.imikasa.beans.ProductBrand;
import com.imikasa.mapper.BrandMapper;
import com.imikasa.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrandServiceImpl implements ProductBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<ProductBrand> allProductBrands() {
        return brandMapper.getAllBrand();
    }

}
