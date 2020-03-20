package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Comment;
import com.aaa.lee.repast.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @program: repast-app-parent-mine
 * @author: Mr.Yang
 * @create: 2020-03-15 18:44
 * @description:
 **/
@RestController
public class CommentController extends CommonController {
    @Autowired
    private CommentService commentService;

    @Override
    public BaseService getBaseService() {
        return commentService;
    }

    /**
    * @Param: [memberId]
    * @return: java.util.List<java.util.HashMap>
    * @Description:
     *      查询所有本用户的评价及回复(未删除的)
    */
    @PostMapping("/selectCommentAndReply")
    public List<HashMap> selectCommentAndReply(@RequestParam("memberId") Integer memberId){
        return commentService.selectCommentAndReply(memberId);
    }

    /**
    * @Param: [commentId]
    * @return: boolean
    * @Description:
     *      删除评价
    */
    @PostMapping("/updateShowStatus")
    public ResultData updateShowStatus(@RequestParam("commentId") Long commentId){
        boolean issuccess= commentService.updateShowStatus(commentId);
        if(issuccess){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
    * @Param: [commentId, content]
    * @return: boolean
    * @Description:
     *      修改评论--->不做
    */
    /*@PostMapping("/updateComment")
    public boolean updateComment(@RequestParam("commentId") Long commentId, @RequestParam("content") String content){
        return commentService.updateComment(commentId,content);
    }*/

    /**
    * @Param: [comment]
    * @return: boolean
    * @Description:
     *      新增评论
    */
    @PostMapping("/insertComment")
    public ResultData insertComment(@RequestBody Comment comment){
        int add= commentService.insertComment(comment);
        if(add>0){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }


}
