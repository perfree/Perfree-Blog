package com.perfree.mapper;

import com.perfree.model.Attach;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttachMapper {

    /**
     * 图片列表
     * @param attach 文件
     * @return List<Attach>
     */
    List<Attach> imageList(Attach attach);

    /**
     * 保存文件信息
     * @param attach 信息
     */
    Long saveFile(Attach attach);
}
