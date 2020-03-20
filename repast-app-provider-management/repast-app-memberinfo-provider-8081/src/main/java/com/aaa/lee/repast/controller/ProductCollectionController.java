package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.ProductCollection;
import com.aaa.lee.repast.service.ProductCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: all-repast-app-parent
 * @author: Mr.Yang
 * @create:
 * @description:
 **/
@RestController
public class ProductCollectionController extends CommonController<ProductCollection> {
    @Autowired
    private ProductCollectionService productCollectionService;

    @Override
    public BaseService<ProductCollection> getBaseService() {
        return productCollectionService;
    }

    /**
     * @Param: [cartItem]
     * @return: boolean
     * @Description:
     *      添加商品进购物车
     */
    @PostMapping("/addProductCollection")
    public ResultData addProductCollection(@RequestBody ProductCollection productCollection){
        boolean ifsuccess=productCollectionService.addProductCollection(productCollection);
        if (ifsuccess){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Param: []
     * @return: java.util.List<com.aaa.yang.repast.model.ProductCollection>
     * @Description:
     *      查询购物车商品
     */
    @PostMapping("/selectCart")
    public List<ProductCollection> selectProductCollection(ProductCollection productCollection){
        return productCollectionService.selectProductCollection(productCollection);
    }

    /**
     * @Param:
     * @return: boolean
     * @Description:
     *      手动删除失效商品
     */
    @PostMapping("/deleteProductCollection")
    public ResultData deleteProductCollection(@RequestBody ProductCollection p){
        Boolean ifsuccess= productCollectionService.deleteProductStatus(p);
        if (ifsuccess){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
}
