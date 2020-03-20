package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.ShopCollecion;
import com.aaa.lee.repast.service.ShopCollecionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: repast-app-parent-mine
 * @author: Mr.Yang
 * @create:
 * @description:
 **/
@RestController
public class ShopCollecionController extends CommonController<ShopCollecion> {
    @Autowired
    private ShopCollecionService shopCollecionService;

    @Override
    public BaseService<ShopCollecion> getBaseService() {
        return shopCollecionService;
    }

    /**
    * @Param: [shopCollecion]
    * @return: java.lang.Boolean
    * @Description:
     *      添加店铺收藏
    */
    @PostMapping("/addShop")
    public ResultData addShop(@RequestBody ShopCollecion shopCollecion){
        boolean ifsuccess= shopCollecionService.addShop(shopCollecion);
        if (ifsuccess){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
    * @Param: []
    * @return: java.util.List<com.aaa.yang.repast.model.ShopCollecion>
    * @Description:
     *      查询已收藏的店铺
    */
    @PostMapping("/queryAllShop")
    public List<ShopCollecion> selectShopCollection(){
        return shopCollecionService.selectShopCollection();
    }

    /**
    * @Param: [map]
    * @return: com.aaa.lee.repast.base.ResultData
    * @Description:
     *      删除收藏店铺
    */
    @PostMapping("/deleteShop")
    public ResultData deleteShop(@RequestBody ShopCollecion shopCollecion){
        boolean ifsuccess= shopCollecionService.deleteShop(shopCollecion);
        if (ifsuccess){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

}
