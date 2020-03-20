package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.ShopCollecion;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.aaa.lee.repast.status.StatusEnums.*;

/**
 * @program: repast-app-parent-mine
 * @author: Mr.Yang
 * @create: 2020-03-13 20:41
 * @description:
 **/
@RestController
@Api(value = "收藏店铺",tags = "收藏店铺接口(进行店铺收藏一系列操作)")
public class ShopCollecionController {
    @Autowired
    private IRepastService repastService;

    /**
    * @Param: [shopCollecion]
    * @return: com.aaa.yang.repast.base.ResultData
    * @Description:
     *      收藏店铺
    */
    @PostMapping("/addShop")
    @ApiOperation(value = "收藏店铺",notes = "进行店铺收藏")
    public ResultData addShop(@RequestBody ShopCollecion shopCollecion){
        return repastService.addShop(shopCollecion);

    }

    /**
    * @Param: []
    * @return: java.util.List<com.aaa.yang.repast.model.ShopCollecion>
    * @Description:
     *      查询已收藏的店铺
    */
    @PostMapping("/selectShopCollection")
    @ApiOperation(value = "收藏店铺查询",notes = "进行已收藏店铺的查询")
    public List<ShopCollecion> selectShopCollection(){
        return repastService.selectShopCollection();
    }

    /**
     * @Param: [map]
     * @return: com.aaa.lee.repast.base.ResultData
     * @Description:
     *      删除收藏店铺
     */
    @PostMapping("/deleteShop")
    @ApiOperation(value = "删除收藏店铺",notes = "进行已收藏店铺的删除")
    public ResultData deleteShop(@RequestBody ShopCollecion shopCollecion){
        return repastService.deleteShop(shopCollecion);
    }

}
