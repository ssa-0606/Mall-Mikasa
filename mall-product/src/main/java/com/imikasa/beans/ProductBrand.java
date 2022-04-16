package com.imikasa.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrand {

    private Long id;
    private String name;
    private String firstLetter;
    private Integer sort;
    //是否为品牌制造商： 0-》不是；1-》是
    private Integer factoryStatus;
    //是否展示
    private Integer showStatus;
    private Integer productCount;
    private Integer productCommentCount;
    private String logo;
    private String bigPic;
    private String brandStory;
}
