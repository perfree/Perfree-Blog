package com.perfree.mapper;

import com.perfree.model.Option;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName OptionMapper
 * @Author Majz
 * @Date 2020/7/1 11:40:15
 * @Version 1.0
 **/
@Component
public interface OptionMapper {

    /**
     * 配置列表
     * @return
     */
    List<Option> list(Option option);

    /**
     * 根据key获取对象
     * @param key
     * @return
     */
    Option getByKey(String key);

    /**
     * 添加配置
     * @param option
     * @return
     */
    Integer addOption(Option option);

    /**
     * 修改配置
     * @param option
     * @return
     */
    Integer updateOption(Option option);

    /**
     * 删除配置
     * @param id
     * @return
     */
    Integer delOption(Integer id);

    /**
     * 修改web配置
     * @param option 配置信息
     * @return int
     */
    int webOption(Option option);

    List<Option> getWebOption();
}
