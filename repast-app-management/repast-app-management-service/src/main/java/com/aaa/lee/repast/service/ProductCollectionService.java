package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.mapper.MemberMapper;
import com.aaa.lee.repast.mapper.ProductCollectionMapper;
import com.aaa.lee.repast.mapper.ProductMapper;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.model.Product;
import com.aaa.lee.repast.model.ProductCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.repast.staticstatus.StaticCode.*;

/**
 * @program: all-repast-app-parent
 * @author: Mr.Yang
 * @create:
 * @description:
 **/
@Service
public class ProductCollectionService extends BaseService<ProductCollection> {
    @Autowired
    private ProductCollectionMapper productCollectionMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<ProductCollection> getMapper() {
        return productCollectionMapper;
    }

    /**
     * @Param: [productid]
     * @return: boolean
     * @Description:
     *       判断商品是否可以加入购物车???
     *       delete_status(删除状态0->未删除；1->已删除)
     *       publish_status(上架状态: 0->下架；1->上架)
     */
    public boolean isEnough(Long productid){
        Product product = productMapper.selectByPrimaryKey(productid);
        Integer deleteStatus = product.getDeleteStatus();
        Integer publishStatus = product.getPublishStatus();
        if (ZERO .equals(deleteStatus)&&publishStatus.equals(ONE)){
            return true;
        }
        return false;
    }

    /**
     * @Param: [ProductCollection]
     * @return: boolean
     * @Description:
     *      添加商品进购物车
     */
    public boolean addProductCollection(ProductCollection productCollection){
        Long productId = productCollection.getProductId();
        boolean isEnough=isEnough(productId);
        if (isEnough){
            try {
                Integer ifsuccess = super.add(productCollection);
                if (ifsuccess>0){
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @Param: []
     * @return: java.util.List<com.aaa.yang.repast.model.ProductCollection>
     * @Description:
     *      查询购物车所有未进行删除的商品
     *      delete_status ：0代表未删除
     */
    public List<ProductCollection> selectProductCollection(ProductCollection productCollection){
        return super.queryList(productCollection);
    }

    /**
     * @Param: []
     * @return: boolean
     * @Description:
     *      创建定时任务（每天凌晨3点进行更新）
     *      更新收藏商品状态
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public boolean updateProductStatus(){
        ProductCollection productCollection=new ProductCollection();
        //查询哪些商品失效，需要进行购物车状态更改
        List<Object> products = productMapper.selectState();
            //更改状态，改为失效
            int i = super.updateBatch(productCollection,products,null);
            if (i>0){
                return true;
            }

        return false;
    }

    /**
     * @Param: [productCollection]
     * @return: boolean
     * @Description:
     *      手动删除购物车中的失效商品
     */
    public boolean  deleteProductStatus(ProductCollection productCollection){
        int i = super.update(productCollection);
        if (i>0){
            return true;
        }
        return false;
    }

}
