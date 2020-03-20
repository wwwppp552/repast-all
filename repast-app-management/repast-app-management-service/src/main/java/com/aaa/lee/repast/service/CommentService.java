package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.mapper.CommentMapper;
import com.aaa.lee.repast.model.Comment;
import com.aaa.lee.repast.utils.sensiFilter.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @program: repast-app-parent-mine
 * @author: Mr.Yang
 * @create: 2020-03-15 18:05
 * @description:
 *      评论模块service
 **/
@Service
public class CommentService extends BaseService<Comment> {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Mapper getMapper() {
        return commentMapper;
    }

    /**
    * @Param: [memberId]
    * @return: java.util.List<java.util.HashMap>
    * @Description:
     *      查询所有本用户的评价(未删除的)
     *      status 1:显示 2:删除的
    */
    public List<HashMap> selectCommentAndReply(Integer memberId){
        return commentMapper.selectCommentAndReply(memberId);
    }

    /**
    * @Param: [commentId]
    * @return: boolean
    * @Description:
     *      删除评论
    */
    public boolean updateShowStatus(Long commentId){
        Comment comment=new Comment();
        comment.setShowStatus(2);
        comment.setId(commentId);
        int issuccess=commentMapper.updateByPrimaryKeySelective(comment);
        if (issuccess>0){
            return true;
        }
        return false;
    }

    /**
    * @Param: [commentId, content]
    * @return: boolean
    * @Description:
     *      修改评论(需敏感词过滤)
    *//*
    public boolean updateComment(Long commentId,String content){
        SensitiveFilter filter = SensitiveFilter.DEFAULT;
        String filtedComment = filter.filter(content, '*');
        Comment comment=new Comment();
        comment.setId(commentId);
        comment.setContent(filtedComment);
        int issuccess=commentMapper.updateByPrimaryKeySelective(comment);
        if (issuccess>0){
            return true;
        }
        return false;
    }*/

    /**
    * @Param: [comment]
    * @return: boolean
    * @Description:
     *      新增评论(需敏感词过滤)
    */
    public Integer insertComment(Comment comment){
        SensitiveFilter filter = SensitiveFilter.DEFAULT;
        String content=comment.getContent();
        String filtedComment = filter.filter(content, '*');
        comment.setContent(filtedComment);
        return super.add(comment);

    }
}
