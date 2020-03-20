package com.aaa.lee.repast.controller;


import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.ProductCollection;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: all-repast-app-parent
 * @author: Mr.Yang
 * @create:
 * @description:
 **/
@RestController
@Api(value = "收藏商品",tags = "商品收藏接口(进行商品收藏一系列操作)")
public class ProductCollectionController{
    @Autowired
    private IRepastService repastService;

    /**
     * @Param: [cartItem]
     * @return: boolean
     * @Description:
     *      添加商品进购物车
     */
    @PostMapping("/addProductCollection")
    @ApiOperation(value = "收藏商品",notes = "进行商品收藏")
    public ResultData addProductCollection(@RequestBody ProductCollection productCollection){
        return repastService.addProductCollection(productCollection);

    }

    /**
     * @Param: []
     * @return: java.util.List<com.aaa.yang.repast.model.ProductCollection>
     * @Description:
     *      查询购物车商品
     */
    @PostMapping("/selectCart")
    @ApiOperation(value = "查询收藏商品",notes = "查询已收藏的商品")
    public List<ProductCollection> selectProductCollection(ProductCollection productCollection){
        return repastService.selectProductCollection(productCollection);
    }

    /**
     * @Param:
     * @return: boolean
     * @Description:
     *      手动删除失效商品
     */
    @PostMapping("/deleteProductCollection")
    @ApiOperation(value = "删除失效收藏商品",notes = "删除已失效的商品")
    public ResultData deleteProductCollection(@RequestBody ProductCollection p){
        return repastService.deleteProductCollection(p);

    }
}
