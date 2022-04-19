package com.imikasa.mapper;

import com.imikasa.beans.ProductBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<ProductBrand> getAllBrand();
    int addBrand(ProductBrand brand);

}
