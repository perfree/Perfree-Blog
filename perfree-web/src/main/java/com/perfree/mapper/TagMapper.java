package com.perfree.mapper;

import com.perfree.model.Tag;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagMapper {
    /**
     * 标签列表
     * @param tag 标签
     * @return List<Tag>
     */
    List<Tag> list(Tag tag);

    /**
     * 添加标签
     * @param tag 标签
     * @return int
     */
    int add(Tag tag);

    /**
     * 更新标签
     * @param tag 标签
     * @return int
     */
    int update(Tag tag);

    /**
     * 删除标签
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 获取所有标签
     * @return  List<Tag>
     */
    List<Tag> all();
}
