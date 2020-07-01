package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.AttachMapper;
import com.perfree.model.Attach;
import com.perfree.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachService {

    @Autowired
    private AttachMapper attachMapper;
    /**
     * 图片列表分页
     * @param pager 分页
     * @return Pager<Attach>
     */
    public Pager<Attach> imageList(Pager<Attach> pager) {
        Attach attach = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
        List<Attach> attaches = attachMapper.imageList(attach);
        PageInfo<Attach> pageInfo = new PageInfo<>(attaches);
        pager.setCode(0);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }
}
