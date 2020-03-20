package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Comment;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @program: repast-app-parent-mine
 * @author: Mr.Yang
 * @create: 2020-03-15 22:52
 * @description:
 **/
@RestController
@Api(value = "商品评价",tags = "商品评价接口(提供商品评价一系列操作)")
public class CommentController {
    @Autowired
    private IRepastService repastService;

    /**
     * @Param: [memberId]
     * @return: java.util.List<java.util.HashMap>
     * @Description:
     *      查询所有本用户的评价及回复(未删除的)
     */
    @PostMapping("/selectCommentAndReply")
    @ApiOperation(value = "查询评价", notes = "查询所有本用户的评价及回复(未删除的)")
    public List<HashMap> selectCommentAndReply(@RequestParam("memberId") Integer memberId){
        return repastService.selectCommentAndReply(memberId);
    }

    /**
     * @Param: [commentId]
     * @return: boolean
     * @Description:
     *      删除评价
     */
    @PostMapping("/updateShowStatus")
    @ApiOperation(value = "删除评价", notes = "根据评价id删除评价")
    public ResultData updateShowStatus(@RequestParam("commentId") Long commentId){
        return repastService.updateShowStatus(commentId);
    }

    /**
     * @Param: [commentId, content]
     * @return: boolean
     * @Description:
     *      修改评价---不做
     */
    /*@PostMapping("/updateComment")
    @ApiOperation(value = "修改评价", notes = "根据评价id修改评价")
    public boolean updateComment(@RequestParam("commentId") Long commentId, @RequestParam("content") String content){
        return repastService.updateComment(commentId,content);
    }*/

    /**
     * @Param: [comment]
     * @return: boolean
     * @Description:
     *      新增评价
     */
    @PostMapping("/insertComment")
    @ApiOperation(value = "新增评价", notes = "添加用户评价")
    public ResultData insertComment(Comment comment){
        return repastService.insertComment(comment);
    }

}
