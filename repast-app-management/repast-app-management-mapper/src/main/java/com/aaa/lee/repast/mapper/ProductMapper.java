package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface ProductMapper extends Mapper<Product> {
    List<Object> selectState();
}