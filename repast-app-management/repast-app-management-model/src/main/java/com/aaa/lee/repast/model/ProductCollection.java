package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "ums_product_collection")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class ProductCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_sku_id")
    private Long productSkuId;

    @Column(name = "member_id")
    private Long memberId;

    private BigDecimal price;

    private String sp1;

    private String sp2;

    private String sp3;

    @Column(name = "product_pic")
    private String productPic;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_sub_title")
    private String productSubTitle;

    @Column(name = "product_sku_code")
    private String productSkuCode;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * 1:未删除 2：已删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_sn")
    private String productSn;

    @Column(name = "product_status")
    private Integer productStatus;

    @Column(name = "product_attr")
    private String productAttr;


}