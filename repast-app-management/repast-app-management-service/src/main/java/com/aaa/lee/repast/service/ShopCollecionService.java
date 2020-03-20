package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.mapper.ShopCollecionMapper;
import com.aaa.lee.repast.model.ShopCollecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: repast-app-parent-mine
 * @author: Mr.Yang
 * @create: 2020-03-13 18:27
 * @description:
 *      店铺收藏    --(缺少同步店家状态(定时任务))
 **/
@Service
public class ShopCollecionService extends BaseService<ShopCollecion> {
    @Autowired
    private ShopCollecionMapper shopCollecionMapper;
    @Override
    public Mapper getMapper() {
        return shopCollecionMapper;
    }

    /**
    * @Param: [shopCollecion]
    * @return: boolean
    * @Description:
     *      收藏店铺
    */
    public boolean addShop(ShopCollecion shopCollecion){
        try {
            Integer addResult=super.add(shopCollecion);
            if (addResult>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
    * @Param: []
    * @return: java.util.List<com.aaa.yang.repast.model.ShopCollecion>
    * @Description:
     *      查询所有已收藏的店铺
    */
    public List<ShopCollecion> selectShopCollection(){
        ShopCollecion shopCollecion=new ShopCollecion();
        List<ShopCollecion> list=super.queryList(shopCollecion);
        return list;
    }

    /**
    * @Param: [shopCollecion]
    * @return: boolean
    * @Description:
     *      删除收藏的店铺
    */
    public boolean deleteShop(ShopCollecion shopCollecion){
        try {
            Integer addResult=super.delete(shopCollecion);
            if (addResult>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
