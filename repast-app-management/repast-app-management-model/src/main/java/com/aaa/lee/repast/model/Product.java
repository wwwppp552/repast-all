package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pms_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ??ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * ??ID
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * ????ID
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * ??????ID
     */
    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    /**
     * ??
     */
    @Column(name = "product_sn")
    private String productSn;

    /**
     * ?????0->????1->???
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * ?????0->???1->??
     */
    @Column(name = "publish_status")
    private Integer publishStatus;

    /**
     * ????:0->?????1->??
     */
    @Column(name = "new_status")
    private Integer newStatus;

    /**
     * ?????0->????1->??
     */
    @Column(name = "recommand_status")
    private Integer recommandStatus;

    /**
     * ??
     */
    private Integer sort;

    /**
     * ??
     */
    private Integer sale;

    private BigDecimal price;

    /**
     * ????
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * ?????
     */
    @Column(name = "gift_point")
    private Integer giftPoint;

    /**
     * ???
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * ???
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * ??
     */
    private Integer stock;

    /**
     * ?????
     */
    @Column(name = "low_stock")
    private Integer lowStock;

    /**
     * ??
     */
    private String unit;

    /**
     * ?????????
     */
    private BigDecimal weight;

    /**
     * ???????????1->?????2->?????3->????
     */
    @Column(name = "service_ids")
    private String serviceIds;

    private String keywords;

    private String note;

    /**
     * ??id
     */
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "detail_title")
    private String detailTitle;

    /**
     * ??????
     */
    @Column(name = "promotion_start_time")
    private Date promotionStartTime;

    /**
     * ??????
     */
    @Column(name = "promotion_end_time")
    private Date promotionEndTime;

    /**
     * ??????
     */
    @Column(name = "promotion_per_limit")
    private Integer promotionPerLimit;

    /**
     * ?????0->????????;1->??????2->??????3->???????4->???????5->???
     */
    @Column(name = "promotion_type")
    private Integer promotionType;

    /**
     * ????
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * ??????
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * ???0-> ???;  1-> ??
     */
    private Byte currency;

    /**
     * ????
     */
    private String description;

    @Column(name = "detail_desc")
    private String detailDesc;

    /**
     * ????????
     */
    @Column(name = "detail_html")
    private String detailHtml;

    /**
     * ???????
     */
    @Column(name = "detail_mobile_html")
    private String detailMobileHtml;

    }