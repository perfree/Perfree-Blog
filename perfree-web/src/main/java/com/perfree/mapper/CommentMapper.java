package com.perfree.mapper;

import com.perfree.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName CommentMapper
 * @Author Majz
 * @Date 2020/7/1 9:40:39
 * @Version 1.0
 **/
@Component
public interface CommentMapper {

    /**
     * 获取评论列表
     * @param comment
     * @return
     */
    List<Comment> list(Comment comment);

}
