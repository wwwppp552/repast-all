package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "ums_shop_collection")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class ShopCollecion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 店铺名
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 店铺地址
     */
    @Column(name = "shop_address")
    private String shopAddress;

    /**
     * 是否打烊（手动打烊标示）和营业时间一起使用
     */
    private Byte closed;

    /**
     * 开店时间
     */
    @Column(name = "open_time")
    private String openTime;

    /**
     * 0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭
     */
    private Byte status;

    }