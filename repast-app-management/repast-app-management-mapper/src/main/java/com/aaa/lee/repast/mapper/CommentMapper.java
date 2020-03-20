package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.Comment;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface CommentMapper extends Mapper<Comment> {
    List<HashMap> selectCommentAndReply(Integer memberId);
}