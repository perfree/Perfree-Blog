package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.CommentMapper;
import com.perfree.model.Comment;
import com.perfree.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommentService
 * @Author Majz
 * @Date 2020/7/1 11:40:50
 * @Version 1.0
 **/
@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    /**
     * 评论列表分页
     * @param pager pager
     * @return Pager<Comment>
     */
    public Pager<Comment> list(Pager<Comment> pager) {
        Comment comment = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(),pager.getPageSize());
        List<Comment> comments = commentMapper.list(comment);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        pager.setCode(200);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }


}
